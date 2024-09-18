package com.mindhub.app_courses.repositories;

import com.mindhub.app_courses.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
