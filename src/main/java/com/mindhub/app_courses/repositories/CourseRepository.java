package com.mindhub.app_courses.repositories;

import com.mindhub.app_courses.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
}
