package com.mindhub.app_courses.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String number;

    private Integer capacity;

    @OneToMany(mappedBy = "classRoom")
    private Set<WorkShop> workShops = new HashSet<>();

    public ClassRoom() {
    }

    public ClassRoom(Integer capacity, String number) {
        this.capacity = capacity;
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Set<WorkShop> getWorkShops() {
        return workShops;
    }

    public void addWorkshop(WorkShop workShop){
        workShop.setClassRoom(this);
        this.workShops.add(workShop);
    }
}
