package com.best.kwan.vo;

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

//    private LocalDateTime startTime;
    private String startTime;

//    private LocalDateTime endTime;
    private String endTime;

}
