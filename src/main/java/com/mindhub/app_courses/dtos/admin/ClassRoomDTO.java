package com.mindhub.app_courses.dtos.admin;

import com.mindhub.app_courses.models.ClassRoom;

import java.util.UUID;

public class ClassRoomDTO {

    private UUID id;

    private String number;

    private Integer capacity;

    public ClassRoomDTO() {
    }

    public ClassRoomDTO(ClassRoom classRoom){
        id = classRoom.getId();
        number = classRoom.getNumber();
        capacity = classRoom.getCapacity();
    }

    public UUID getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
