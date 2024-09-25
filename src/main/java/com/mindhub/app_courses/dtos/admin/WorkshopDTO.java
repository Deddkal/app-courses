package com.mindhub.app_courses.dtos.admin;

import com.mindhub.app_courses.models.ClassRoom;
import com.mindhub.app_courses.models.Course;
import com.mindhub.app_courses.models.Student;
import com.mindhub.app_courses.models.WorkShop;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class WorkshopDTO {

    private UUID id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private ClassRoomDTO classRoom;

    private Set<StudentDTO> students;

    public WorkshopDTO (WorkShop workShop){
        id = workShop.getId();
        startDate = workShop.getStartDate();
        endDate = workShop.getEndDate();
        classRoom = new ClassRoomDTO(workShop.getClassRoom());
        students = workShop.getStudents().stream().map(StudentDTO::new).collect(Collectors.toSet());
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public ClassRoomDTO getClassRoom() {
        return classRoom;
    }

    public Set<StudentDTO> getStudents() {
        return students;
    }
}
