package ru.netology.db_hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.db_hibernate.entity.Person;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            return List.of();
        }

        return entityManager.createQuery(
                        "SELECT p FROM Person p WHERE p.cityOfLiving = :city", Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}
