package com.mindhub.app_courses.dtos.admin;

import com.mindhub.app_courses.models.Course;
import com.mindhub.app_courses.models.Teacher;
import com.mindhub.app_courses.models.WorkShop;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class CourseDTO {

    private UUID id;

    private String name, description;

    private TeacherDTO teacher;

    private Set<WorkshopDTO> workShops;

    public CourseDTO (Course course){
        id = course.getId();
        name = course.getName();
        description = course.getDescription();
        teacher = new TeacherDTO(course.getTeacher());
        workShops = course.getWorkShops().stream().map(WorkshopDTO::new).collect(Collectors.toSet());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public Set<WorkshopDTO> getWorkShops() {
        return workShops;
    }
}
