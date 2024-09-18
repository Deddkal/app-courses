package com.mindhub.app_courses.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher extends Person{

    private String speciality;

    @OneToMany( mappedBy = "teacher")
    private Set<Course> courses = new HashSet<>();

    public Teacher() {
    }

    public Teacher(String name, String email, String password, String speciality) {
        super(name, email, password);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course){
        course.setTeacher(this);
        courses.add(course);
    }
}
