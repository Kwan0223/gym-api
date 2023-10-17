package com.best.kwan.vo;

import com.best.kwan.Entity.NotificationEntity;
import com.best.kwan.Entity.ReservationEntity;
import com.best.kwan.eums.NotificationCode;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequestVO {

    private Long trainerId;
    private Long userId;
    private boolean checkYn;
    private String content;
    private NotificationCode notificationCode;

    public static NotificationEntity toNotificationEntity(ReservationEntity reservation){
        NotificationEntity notification = new NotificationEntity();
        notification.setTrainer(reservation.getTrainer());
        notification.setUser(reservation.getUser());
        notification.setCheckYn(false);
        notification.setContent(reservation.getUser().getName() + NotificationCode.RESERVATION_APPLICATION.getMsg());
        notification.setCode(NotificationCode.RESERVATION_APPLICATION);

        return notification;
    }

    public static NotificationRequestVO fromEntity(NotificationEntity notification) {
        NotificationRequestVO vo = new NotificationRequestVO();
        vo.setUserId(notification.getUser().getId());
        vo.setNotificationCode(notification.getCode());
        vo.setTrainerId(notification.getTrainer().getTrainerId());
        vo.setContent(notification.getContent());
        vo.setCheckYn(notification.getCheckYn());
        return vo;
    }

}
