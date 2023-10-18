package com.best.kwan.service;


import com.best.kwan.Entity.*;
import com.best.kwan.Repository.*;
import com.best.kwan.eums.ErrorCode;
import com.best.kwan.eums.NotificationCode;
import com.best.kwan.exception.CustomException;
import com.best.kwan.vo.NotificationRequestVO;
import com.best.kwan.vo.ReservationVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final UserRepository userRepository;
    private final TrainerRepository trainerRepository;
    private final ScheduleRepository scheduleRepository;
    private final ReservationRepository reservationRepository;
    private final NotificationRepository notificationRepository;
    private final NotificationService notificationService;


    public ReservationVO createReservation(ReservationVO reservationVO) {

        UserEntity user = userRepository.findById(reservationVO.getUserId()).orElseThrow(() ->  new CustomException(ErrorCode.USER_NOT_FOUND));
        TrainerEntity trainer = trainerRepository.findById(reservationVO.getTrainerId()).orElseThrow(() -> new CustomException(ErrorCode.TRAINER_NOT_FOUND));
        ScheduleEntity schedule = scheduleRepository.save(reservationVO.convertToScheduleEntity());
        ReservationEntity reservation = reservationRepository.save(reservationVO.toReservationEntity(user, trainer, schedule));
        // 생성된 예약을 ReservationVO로 변환
        ReservationVO responseVO = ReservationVO.fromEntity(reservation);
        // 예약 완료 알림 생성 및 추가
        NotificationEntity notification = notificationRepository.save(NotificationRequestVO.toNotificationEntity(reservation));

        NotificationRequestVO requestVO = NotificationRequestVO.fromEntity(notification);

        notificationService.sendNotificationToUser(requestVO);

        return responseVO;
    }

public List<ReservationVO> getReservationsByDateAndTrainer(LocalDateTime date, Long trainerId) {

    List<ReservationEntity> reservations = reservationRepository.findByReservationDateAndTrainerTrainerId(date, trainerId);

    return reservations.stream().map(ReservationVO::convertFromEntity).collect(Collectors.toList());
}

}