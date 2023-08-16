package com.best.kwan.controller;


import com.best.kwan.Entity.NotificationEntity;
import com.best.kwan.Entity.TrainerEntity;
import com.best.kwan.Entity.UserEntity;
import com.best.kwan.Repository.TrainerRepository;
import com.best.kwan.Repository.UserRepository;
import com.best.kwan.eums.NotificationCode;
import com.best.kwan.service.NotificationService;
import com.best.kwan.vo.NotificationResponseVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationResponseVO>> getNotificationsByUser(@PathVariable Long userId) {
        List<NotificationResponseVO> notifications = notificationService.getNotificationsByUserId(userId);
        if (notifications == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/trainer/{trainerId}")
    public ResponseEntity<List<NotificationResponseVO>> getNotificationsByTrainer(@PathVariable Long trainerId) {
        List<NotificationResponseVO> notifications = notificationService.getNotificationsByTrainerId(trainerId);
        if (notifications == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notifications);
    }

//    @GetMapping
//    public ResponseEntity<List<NotificationResponseVO>> test (@PathVariable Long userId){
//        return notificationService.getNotifications(userId);
//
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<List<NotificationResponseVO>> getNotifications(@PathVariable Long id) {
//         NotificationCode test =
//
//            return ResponseEntity.ok(notifications);
//        }
}


