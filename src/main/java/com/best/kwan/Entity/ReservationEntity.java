package com.best.kwan.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
@Entity
public class ReservationEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    @Column(length = 255, columnDefinition="TIMESTAMP WITH TIME ZONE")
    private LocalDateTime reservationDate;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "trainerId")
    private TrainerEntity trainer;

    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private ScheduleEntity schedule;







}
