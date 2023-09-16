package com.best.kwan.eums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NotificationCode {

    RESERVATION_APPLICATION("님이 예약을 신청하였습니다.") ,
    RESERVATION_APPROVAL("트레이너님이 예약을 승인하였습니다."),
    RESERVATION_CANCEL("예약이 취소되었습니다."),
    ;

    private final String msg;

}
