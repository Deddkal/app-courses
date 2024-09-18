package com.mindhub.app_courses.models;

import jakarta.persistence.*;

//TABLE_PER_CLASS = 2, una por cada clase hija
// SINGLE_TABLE = 1
//JOINED =
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public class Admin extends Person{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    public Admin() {
    }

    public Admin(String name, String email, String password) {
        super(name, email, password);
    }

//    public Long getId() {
//        return id;
//    }
}
