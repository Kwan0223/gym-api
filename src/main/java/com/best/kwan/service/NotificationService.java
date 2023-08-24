package com.best.kwan.service;


import com.best.kwan.Entity.NotificationEntity;
import com.best.kwan.Entity.TrainerEntity;
import com.best.kwan.Entity.UserEntity;
import com.best.kwan.Repository.NotificationRepository;
import com.best.kwan.Repository.TrainerRepository;
import com.best.kwan.Repository.UserRepository;
import com.best.kwan.eums.NotificationCode;
import com.best.kwan.handler.NotificationHandler;
import com.best.kwan.vo.NotificationRequestVO;
import com.best.kwan.vo.NotificationResponseVO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private final NotificationRepository notificationRepository;
//    private final SimpMessagingTemplate messagingTemplate;

    private final UserRepository userRepository;
    private final TrainerRepository trainerRepository;

    private final NotificationHandler notificationHandler;



    public List<NotificationResponseVO> getNotificationsByUserId(Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) return null;

        List<NotificationEntity> notifications = notificationRepository.findByUser(user);
        return notifications.stream()
                .map(NotificationResponseVO::convertToResponseVO)
                .collect(Collectors.toList());
    }

    public List<NotificationResponseVO> getNotificationsByTrainerId(Long trainerId) {
        TrainerEntity trainer = trainerRepository.findById(trainerId).orElse(null);
        if (trainer == null) return null;

        List<NotificationEntity> notifications = notificationRepository.findByTrainer(trainer);
        return notifications.stream()
                .map(NotificationResponseVO::convertToResponseVO)
                .collect(Collectors.toList());
    }

//    public void sendNotificationToUser(NotificationRequestVO requestVO) {
//        System.out.println("TEST !!! Send Start ::  " );
//        System.out.println("TEST !!! Send Start ::  " + requestVO );
//        NotificationCode code = requestVO.getNotificationCode();
//        System.out.println("TEST !!! NotificationCode ::  " + code );
//        System.out.println("TEST !!! getUserId ::  " + requestVO.getUserId() );
//        if (code.equals(NotificationCode.RESERVATION_APPLICATION)) {
//        System.out.println("TEST !!! convertAndSendToUser ::  " + code );
////            messagingTemplate.convertAndSend("/topic/notifications", requestVO);
//
//            messagingTemplate.convertAndSendToUser(
//                    String.valueOf(requestVO.getUserId()),
//                    "/topic/notifications", // '/user/{userId}' 접두사는 자동으로 추가됩니다.
//                    requestVO
//            );
//            System.out.println("TEST !!! End Start ::  " + requestVO );
//
//        } else {
//            System.out.println("TEST !!! convertAndSendToTrainer ::  " + code );
//
//            messagingTemplate.convertAndSendToUser(
//                    String.valueOf(requestVO.getUserId()),
//                    "/topic/notifications",
//
//                    requestVO
//            );
//        }
//
//        System.out.println("TEST !!! Final  ::  " + requestVO );
//
//    }

    public void sendNotificationToUser(NotificationRequestVO requestVO) {
        System.out.println("TEST !!!! NotificationRequestVO   : " + requestVO);
        NotificationCode code = requestVO.getNotificationCode();
        String id = "";

        System.out.println("TEST code :::: " + code);
        if(code == NotificationCode.RESERVATION_APPLICATION){
            id = String.valueOf(requestVO.getUserId());
        }else{
            id = String.valueOf(requestVO.getTrainerId());
        }
        System.out.println("TEST id Check ::::" + id) ;
//        String userId = String.valueOf(requestVO.getUserId());
        String message = requestVO.getContent();  // 또는 원하는 형식으로 메시지를 포맷할 수 있습니다.
        notificationHandler.sendNotificationToUser(id, message);
    }
}


