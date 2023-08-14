package com.best.kwan.vo;

import com.best.kwan.eums.NotificationCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequestVO {

    private Long trainerId;

    private Long userId;

    private boolean checkYn;

    private String content;

    private NotificationCode notificationCode;

}
