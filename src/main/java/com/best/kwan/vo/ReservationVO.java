package com.best.kwan.vo;

import com.best.kwan.Entity.ReservationEntity;
import com.best.kwan.Entity.ScheduleEntity;
import com.best.kwan.Entity.TrainerEntity;
import com.best.kwan.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationVO {

    private Long reservationId;
    private Long pointId;
    private Long trainerId;
    private Long scheduleId;
    private Long userId;
    private LocalDateTime date;
    private String startTime;
    private String endTime;

    public ScheduleEntity convertToScheduleEntity() {
        ScheduleEntity schedule = new ScheduleEntity();
        schedule.setStartTime(this.getStartTime());
        schedule.setEndTime(this.getEndTime());
        return schedule;
    }

    public static ReservationVO convertFromEntity(ReservationEntity entity) {
        ReservationVO vo = new ReservationVO();
        vo.setReservationId(entity.getReservationId());
        vo.setTrainerId(entity.getTrainer().getTrainerId());
        vo.setScheduleId(entity.getSchedule().getScheduleId());
        vo.setUserId(entity.getUser().getId());
        vo.setDate(entity.getReservationDate());
        vo.setStartTime(entity.getSchedule().getStartTime());
        vo.setEndTime(entity.getSchedule().getEndTime());

        return vo;
    }

    public ReservationEntity toReservationEntity(UserEntity user, TrainerEntity trainer, ScheduleEntity schedule) {
        ReservationEntity reservation = new ReservationEntity();
        reservation.setUser(user);
        reservation.setTrainer(trainer);
        reservation.setSchedule(schedule);
        reservation.setReservationDate(this.getDate());
        return reservation;
    }

    public static ReservationVO fromEntity(ReservationEntity reservation){
        ReservationVO vo = new ReservationVO();
        vo.setReservationId(reservation.getReservationId());
        vo.setUserId(reservation.getUser().getId());
        vo.setTrainerId(reservation.getTrainer().getTrainerId());
        vo.setDate(reservation.getReservationDate());
        vo.setStartTime(reservation.getSchedule().getStartTime());
        vo.setEndTime(reservation.getSchedule().getEndTime());
        return vo;
    }

}
