package com.best.kwan.vo;

import com.best.kwan.eums.NotificationCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.management.Notification;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateNotificationRequestVO {

  private Long trainerId;

  private Long userId;

  private NotificationCode notificationCode;

}
