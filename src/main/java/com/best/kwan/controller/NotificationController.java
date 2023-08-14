package com.best.kwan.controller;


import com.best.kwan.Entity.NotificationEntity;
import com.best.kwan.Entity.TrainerEntity;
import com.best.kwan.Entity.UserEntity;
import com.best.kwan.Repository.TrainerRepository;
import com.best.kwan.Repository.UserRepository;
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
    private final UserRepository userRepository;

    private final TrainerRepository trainerRepository;
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationResponseVO>> getNotificationsByUser(@PathVariable Long userId) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);

        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        UserEntity user = userOptional.get();
        List<NotificationResponseVO> notifications = notificationService.getNotificationsByUser(user);
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/trainer/{trainerId}")
    public ResponseEntity<List<NotificationEntity>> getNotificationsByTrainer(@PathVariable Long trainerId) {
        Optional<TrainerEntity> trainerOptional = trainerRepository.findById(trainerId);

        if(!trainerOptional.isPresent()){
            return  ResponseEntity.notFound().build();
        }

        TrainerEntity trainer = trainerOptional.get();
        List<NotificationEntity> notifications = notificationService.getNotificationsByTrainer(trainer);
        return ResponseEntity.ok(notifications);
    }

}

