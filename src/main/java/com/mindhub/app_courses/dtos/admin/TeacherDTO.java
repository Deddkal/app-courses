package com.mindhub.app_courses.dtos.admin;

import com.mindhub.app_courses.models.Teacher;

public class TeacherDTO {

    private Long id;

    private String name;

    private String email;

    private String speciality;

    public TeacherDTO(Teacher teacher){
        id = teacher.getId();
        name = teacher.getName();
        email = teacher.getEmail();
        speciality = teacher.getSpeciality();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSpeciality() {
        return speciality;
    }
}
