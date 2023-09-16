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
    private String startTime;
    private String endTime;

}
