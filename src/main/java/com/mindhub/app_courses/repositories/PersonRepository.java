package com.mindhub.app_courses.repositories;

import com.mindhub.app_courses.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
