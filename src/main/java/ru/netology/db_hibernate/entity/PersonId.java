package ru.netology.db_hibernate.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PersonId implements Serializable {
    private String name;
    private String surname;
    private short age;
}
