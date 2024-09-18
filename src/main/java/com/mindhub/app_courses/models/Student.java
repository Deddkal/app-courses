package com.mindhub.app_courses.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public class Student extends Person{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    private String lastname;

    @ManyToMany( mappedBy = "students")
    private Set<WorkShop> workShops = new HashSet<>();

    public Student() {
    }

    public Student(String name, String email, String password, String lastname) {
        super(name, email, password);
        this.lastname = lastname;
    }


//    public Long getId() {
//        return id;
//    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<WorkShop> getWorkShops() {
        return workShops;
    }

    public void addWorkshop(WorkShop workShop){
        workShop.getStudents().add(this);
        this.workShops.add(workShop);
    }
}
