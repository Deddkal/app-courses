package com.mindhub.app_courses.repositories;

import com.mindhub.app_courses.models.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, UUID> {
}
