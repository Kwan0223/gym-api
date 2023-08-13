package com.best.kwan.service;


import com.best.kwan.Entity.NotificationEntity;
import com.best.kwan.Entity.TrainerEntity;
import com.best.kwan.Entity.UserEntity;
import com.best.kwan.Repository.NotificationRepository;
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

    public void sendNotificationToUser(NotificationEntity notification, Long userId) {
        System.out.println("TEST Send !!!!!!! ");
        messagingTemplate.convertAndSendToUser(
                String.valueOf(userId),
                "/topic/notifications",
                notification
        );


    }
}
