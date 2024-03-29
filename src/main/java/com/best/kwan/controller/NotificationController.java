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

    @GetMapping("/{id}")
    public ResponseEntity<List<NotificationResponseVO>> getNotifications(@PathVariable Long id) {
        List<NotificationResponseVO> notifications = notificationService.getNotificationsById(id);

        //여기서 빈 리스트를 보내고  프론트에서 빈 리스트가오면 알림이 안뜨게
        return ResponseEntity.ok(notifications);
    }
}


