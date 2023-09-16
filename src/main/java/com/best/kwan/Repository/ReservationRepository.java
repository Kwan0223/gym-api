package com.best.kwan.Repository;

import com.best.kwan.Entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    @Query("SELECT r FROM ReservationEntity r WHERE r.reservationDate = :date AND r.trainer.trainerId = :trainerId")
    List<ReservationEntity> findByReservationDateAndTrainerTrainerId(LocalDateTime date, Long trainerId);


}
