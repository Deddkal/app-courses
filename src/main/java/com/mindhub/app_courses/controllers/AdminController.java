package com.mindhub.app_courses.controllers;

import com.mindhub.app_courses.dtos.admin.ClassRoomDTO;
import com.mindhub.app_courses.dtos.admin.CourseDTO;
import com.mindhub.app_courses.models.ClassRoom;
import com.mindhub.app_courses.repositories.ClassRoomRepository;
import com.mindhub.app_courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @GetMapping
    public Set<CourseDTO> getAllCourse(){
        return courseRepository.findAll().stream().map(CourseDTO::new).collect(Collectors.toSet());
    }

    @PostMapping("/classroom")
    public ResponseEntity<?> createClassroom( @RequestBody ClassRoomDTO classRoomDTO ){

        if (classRoomDTO.getCapacity() != null && classRoomDTO.getCapacity() < 30  ){
            return ResponseEntity.badRequest().body("No puede ser menor a 30 la capacidad");
        }

        if (classRoomDTO.getNumber().isBlank()){
            return ResponseEntity.badRequest().body("Number no puede estar en blanco o vacio");
        }

        ClassRoom classRoom = new ClassRoom(classRoomDTO.getCapacity(), classRoomDTO.getNumber());
        classRoomRepository.save(classRoom);
        return new ResponseEntity<>(new ClassRoomDTO(classRoom), HttpStatus.CREATED);
//        return ResponseEntity.ok("Se creo el classroom");
    }

}
