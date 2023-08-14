package com.best.kwan.service;


import com.best.kwan.Entity.NotificationEntity;
import com.best.kwan.Entity.TrainerEntity;
import com.best.kwan.Entity.UserEntity;
import com.best.kwan.Repository.NotificationRepository;
import com.best.kwan.vo.NotificationRequestVO;
import com.best.kwan.vo.NotificationResponseVO;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final SimpMessagingTemplate messagingTemplate;


    public List<NotificationResponseVO> getNotificationsByUser(UserEntity user) {
        List<NotificationEntity> notifications = notificationRepository.findByUser(user);
        return notifications.stream()
                .map(NotificationResponseVO::convertToResponseVO)
                .collect(Collectors.toList());
    }
    public List<NotificationEntity> getNotificationsByTrainer(TrainerEntity trainer) {
        return notificationRepository.findByTrainer(trainer);
    }

    public void sendNotificationToUser(NotificationRequestVO requestVO) {
        System.out.println("TEST Send !!!!!!! ");
        messagingTemplate.convertAndSendToUser(
                String.valueOf(requestVO.getUserId()),
                "/topic/notifications",
                // 여기서는 NotificationEntity의 정보를 전송해야 할 것 같습니다.
                // 따라서 NotificationEntity를 다시 구성하거나 NotificationRequestVO에서 필요한 정보만 추출해야 할 수도 있습니다.
                // 이 예제에서는 requestVO를 그대로 전송하고 있습니다.
                requestVO
        );
    }


}
