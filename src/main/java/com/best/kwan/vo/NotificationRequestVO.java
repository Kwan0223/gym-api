package com.best.kwan.vo;

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

}
