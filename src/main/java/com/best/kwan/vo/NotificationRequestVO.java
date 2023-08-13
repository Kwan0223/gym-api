package com.best.kwan.vo;

import com.best.kwan.eums.NotificationCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequestVO {

  private Long trainerId;

  private Long userId;

  private NotificationCode notificationCode;

}
