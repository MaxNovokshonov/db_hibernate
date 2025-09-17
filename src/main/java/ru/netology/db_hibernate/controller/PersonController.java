package ru.netology.db_hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.db_hibernate.entity.Person;
import ru.netology.db_hibernate.entity.PersonId;
import ru.netology.db_hibernate.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.findByCityOfLiving(city);
    }

    @GetMapping("/younger-than")
    public List<Person> getPersonsYoungerThan(@RequestParam int age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("/find")
    public Optional<Person> findPersonByNameAndSurname(
            @RequestParam String name,
            @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @DeleteMapping
    public void deletePerson(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam short age) {
        PersonId id = new PersonId(name, surname, age);
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
        } else {
            throw new RuntimeException("Person not found");
        }
    }
}
