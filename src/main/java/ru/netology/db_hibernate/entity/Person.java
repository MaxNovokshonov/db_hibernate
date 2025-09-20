package ru.netology.db_hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "persons", schema = "netology") // ← нижний регистр!
@IdClass(PersonId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Id
    @Column(name = "surname", nullable = false, length = 20)
    private String surname;

    @Id
    @Column(name = "age", nullable = false)
    private short age;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "city_of_living", length = 20)
    private String cityOfLiving;
}
