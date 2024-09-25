package com.mindhub.app_courses.repositories;

import com.mindhub.app_courses.models.ClassRoom;
import com.mindhub.app_courses.models.WorkShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.UUID;

public interface WorkshopRepository extends JpaRepository<WorkShop, UUID> {

    boolean existsByStartDateBetween(LocalDateTime startTime, LocalDateTime endTime);

    boolean existsByStartDateBetweenOrEndDateBetween(
            LocalDateTime startTime,
            LocalDateTime endTime,
            LocalDateTime startTime2,
            LocalDateTime endTime2);


    boolean existsByClassRoomAndEndDateBetween(
            ClassRoom classRoom,
            LocalDateTime startTime,
            LocalDateTime endTime);

//    boolean existsByClientAndCardColorAndCardType(Client client, CardColor cardColor, CardType cardType);

}
