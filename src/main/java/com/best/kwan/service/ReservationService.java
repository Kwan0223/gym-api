package com.best.kwan.service;


import com.best.kwan.Entity.*;
import com.best.kwan.Repository.*;
import com.best.kwan.eums.NotificationCode;
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

    private final  NotificationService notificationService;



    public ReservationVO createReservation(ReservationVO reservationVO) {
            UserEntity user = userRepository.findById(reservationVO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
            TrainerEntity trainer = trainerRepository.findById(reservationVO.getTrainerId()).orElseThrow(() -> new RuntimeException("Trainer not found"));

        // 스케줄 생성
        ScheduleEntity schedule = new ScheduleEntity();
        schedule.setStartTime(reservationVO.getStartTime());
        schedule.setEndTime(reservationVO.getEndTime());
        schedule = scheduleRepository.save(schedule);

        ReservationEntity reservation = new ReservationEntity();
        reservation.setUser(user);
        reservation.setTrainer(trainer);
        reservation.setSchedule(schedule);
        reservation.setReservationDate(reservationVO.getDate());

        reservation = reservationRepository.save(reservation);
        System.out.println("TEST reservationDate ::: " + reservation.getReservationDate());


        // 생성된 예약을 ReservationVO로 변환
        ReservationVO responseVO = new ReservationVO();
        responseVO.setReservationId(reservation.getReservationId());
        responseVO.setUserId(reservation.getUser().getId());
        responseVO.setTrainerId(reservation.getTrainer().getTrainerId());
        responseVO.setDate(reservation.getReservationDate());
        responseVO.setStartTime(reservation.getSchedule().getStartTime());
        responseVO.setEndTime(reservation.getSchedule().getEndTime());

        // 예약 완료 알림 생성 및 추가
        NotificationEntity notification = new NotificationEntity();
        notification.setTrainer(reservation.getTrainer());
        notification.setUser(reservation.getUser());
        notification.setCheckYn(false);
        notification.setContent(user.getName() + NotificationCode.RESERVATION_APPLICATION.getMsg());
        notification.setCode(NotificationCode.RESERVATION_APPLICATION);
        notificationRepository.save(notification);

        NotificationRequestVO requestVO = new NotificationRequestVO();
        requestVO.setUserId(notification.getUser().getId());
        requestVO.setNotificationCode(notification.getCode());
        requestVO.setTrainerId(notification.getTrainer().getTrainerId());
        requestVO.setContent(notification.getContent());
        requestVO.setCheckYn(notification.getCheckYn());

        notificationService.sendNotificationToUser(requestVO);

        return responseVO;
    }

    public List<ReservationVO> getReservationsByDateAndTrainer(LocalDateTime date, Long trainerId) {
        List<ReservationEntity> reservations = reservationRepository.findByReservationDateAndTrainerTrainerId(date, trainerId);
        return reservations.stream().map(this::convertEntityToVO).collect(Collectors.toList());
    }

    private ReservationVO convertEntityToVO(ReservationEntity entity) {
        ReservationVO vo = new ReservationVO();
        vo.setReservationId(entity.getReservationId());
        vo.setTrainerId(entity.getTrainer().getTrainerId());
        vo.setScheduleId(entity.getSchedule().getScheduleId());
        vo.setUserId(entity.getUser().getId());
        vo.setDate(entity.getReservationDate());
        vo.setStartTime(entity.getSchedule().getStartTime());
        vo.setEndTime(entity.getSchedule().getEndTime());

        return vo;
    }
}