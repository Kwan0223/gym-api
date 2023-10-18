package com.best.kwan.service;


import com.best.kwan.Entity.NotificationEntity;
import com.best.kwan.Entity.UserEntity;
import com.best.kwan.Repository.NotificationRepository;
import com.best.kwan.Repository.TrainerRepository;
import com.best.kwan.Repository.UserRepository;
import com.best.kwan.eums.ErrorCode;
import com.best.kwan.eums.NotificationCode;
import com.best.kwan.exception.CustomException;
import com.best.kwan.handler.NotificationHandler;
import com.best.kwan.vo.NotificationRequestVO;
import com.best.kwan.vo.NotificationResponseVO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    private final NotificationHandler notificationHandler;



    public List<NotificationResponseVO> getNotificationsByUserId(Long userId) {

        UserEntity user = userRepository.findById(userId).orElseThrow(() ->  new CustomException(ErrorCode.USER_NOT_FOUND));

        List<NotificationEntity> notifications = notificationRepository.findByUser(user);
        //User 말고 fk로 받게 userid로만 받게
        return notifications.stream()
                .map(NotificationResponseVO::convertToResponseVO)
                .collect(Collectors.toList());
    }

    public void sendNotificationToUser(NotificationRequestVO requestVO) {
        NotificationCode code = requestVO.getNotificationCode();
        String id = "";

        System.out.println("TEST code :::: " + code);

        if(code == NotificationCode.RESERVATION_APPLICATION){
            id = String.valueOf(requestVO.getUserId());
        }else{
            id = String.valueOf(requestVO.getTrainerId());
        }
        System.out.println("TEST id Check ::::" + id) ;

        String message = requestVO.getContent();  // 또는 원하는 형식으로 메시지를 포맷할 수 있습니다.

        notificationHandler.sendNotificationToUser(id, message);
    }

    public List<NotificationResponseVO> getNotificationsById(Long id) {

        UserEntity user = userRepository.findById(id).orElseThrow(() ->  new CustomException(ErrorCode.USER_NOT_FOUND));

        List<NotificationEntity> notifications = notificationRepository.findByUser(user);
        return notifications
                .stream()
                .map(NotificationResponseVO::convertToResponseVO)
                .collect(Collectors.toList());
    }
}


