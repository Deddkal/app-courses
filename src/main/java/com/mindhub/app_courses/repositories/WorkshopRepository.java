package com.mindhub.app_courses.repositories;

import com.mindhub.app_courses.models.WorkShop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkshopRepository extends JpaRepository<WorkShop, UUID> {
}
