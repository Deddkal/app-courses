package com.mindhub.app_courses.dtos.admin;

import com.mindhub.app_courses.models.Student;

public class StudentDTO {

    private Long id;

    private String lastname, name, email;

    public StudentDTO(Student student){
        id = student.getId();
        lastname = student.getLastname();
        name = student.getName();
        email = student.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
