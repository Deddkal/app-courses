package com.mindhub.app_courses.repositories;

import com.mindhub.app_courses.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByEmail(String email);

//    Person findByEmail(String email);
}
