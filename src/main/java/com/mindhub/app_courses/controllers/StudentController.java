package com.mindhub.app_courses.controllers;

import com.mindhub.app_courses.dtos.admin.StudentDTO;
import com.mindhub.app_courses.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public StudentDTO getStudent(Authentication authentication){
        return new StudentDTO(studentRepository.findByEmail(authentication.getName()));
    }
}
