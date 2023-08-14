package com.best.kwan.Repository;

import com.best.kwan.Entity.NotificationEntity;
import com.best.kwan.Entity.PointEntity;
import com.best.kwan.Entity.TrainerEntity;
import com.best.kwan.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {


    List<NotificationEntity> findByUser(UserEntity user);

    List<NotificationEntity> findByTrainer(TrainerEntity trainer);
}
