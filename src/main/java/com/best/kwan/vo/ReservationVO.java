package com.best.kwan.vo;

import com.best.kwan.Entity.ReservationEntity;
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

    private Long trainerId;

    private Long scheduleId;

    private Long userId;

    private LocalDateTime date;

    private String startTime;

    private String endTime;

    public static ReservationVO fromEntity(ReservationEntity reservationEntity) {
        ReservationVO reservationVO = new ReservationVO();
        reservationVO.setReservationId(reservationEntity.getReservationId());
        reservationVO.setTrainerId(reservationEntity.getTrainer().getTrainerId());
        reservationVO.setScheduleId(reservationEntity.getSchedule().getScheduleId());
        reservationVO.setUserId(reservationEntity.getUser().getId());
        reservationVO.setDate(reservationEntity.getReservationDate());
        reservationVO.setStartTime(reservationEntity.getSchedule().getStartTime());
        reservationVO.setEndTime(reservationEntity.getSchedule().getEndTime());

        return reservationVO;

    }


}

