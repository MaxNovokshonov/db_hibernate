package ru.netology.db_hibernate.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/method-security")
public class MethodSecurityController {

    @GetMapping("/read")
    @Secured("ROLE_READ")
    public Map<String, Object> readOnly() {
        Map<String, Object> body = new HashMap<>();
        body.put("endpoint", "/method-security/read");
        body.put("access", "ROLE_READ only (@Secured)");
        return body;
    }

    @GetMapping("/write")
    @RolesAllowed("ROLE_WRITE")
    public Map<String, Object> writeOnly() {
        Map<String, Object> body = new HashMap<>();
        body.put("endpoint", "/method-security/write");
        body.put("access", "ROLE_WRITE only (@RolesAllowed)");
        return body;
    }

    @GetMapping("/edit")
    @PreAuthorize("hasAnyRole('WRITE','DELETE')")
    public Map<String, Object> editAllowed() {
        Map<String, Object> body = new HashMap<>();
        body.put("endpoint", "/method-security/edit");
        body.put("access", "hasAnyRole('WRITE','DELETE') (@PreAuthorize)");
        return body;
    }

    @GetMapping("/self")
    @PreAuthorize("#username == authentication.name")
    public Map<String, Object> selfOnly(@RequestParam String username, Authentication authentication) {
        Map<String, Object> body = new HashMap<>();
        body.put("endpoint", "/method-security/self");
        body.put("requestedUsername", username);
        body.put("authenticatedAs", authentication.getName());
        body.put("access", "@PreAuthorize username == authentication.name");
        return body;
    }
}