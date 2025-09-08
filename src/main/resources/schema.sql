CREATE SCHEMA IF NOT EXISTS netology;

CREATE TABLE IF NOT EXISTS netology.PERSONS (
    name           VARCHAR(20) NOT NULL,
    surname        VARCHAR(20) NOT NULL,
    age            SMALLINT    NOT NULL,
    phone_number   VARCHAR(20),
    city_of_living VARCHAR(20),
    PRIMARY KEY (name, surname, age)
    );