package com.mindhub.app_courses.repositories;

import com.mindhub.app_courses.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByEmail(String email);

}
