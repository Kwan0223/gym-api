package com.best.kwan.vo;

import com.best.kwan.Entity.NotificationEntity;
import com.best.kwan.Entity.UserEntity;
import com.best.kwan.eums.NotificationCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResponseVO {

    private Long noticeId;
    private String content;
    private NotificationCode notificationCode;
    private TrainerVO trainer;
    private UserVO user;


    public static NotificationResponseVO convertToResponseVO(NotificationEntity notificationEntity) {

        NotificationResponseVO notificationResponseVO = new NotificationResponseVO();
        notificationResponseVO.setNoticeId(notificationEntity.getNoticeId());
        notificationResponseVO.setContent(notificationEntity.getContent());
        notificationResponseVO.setNotificationCode(notificationEntity.getCode());

        TrainerVO trainer = new TrainerVO(notificationEntity.getTrainer());
        notificationResponseVO.setTrainer(trainer);

        UserVO user = UserVO.toUserVO(notificationEntity.getUser());
        notificationResponseVO.setUser(user);

        return notificationResponseVO;
    }


}
