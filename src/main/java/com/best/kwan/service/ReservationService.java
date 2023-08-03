package com.best.kwan.service;


import com.best.kwan.Entity.ReservationEntity;
import com.best.kwan.Entity.ScheduleEntity;
import com.best.kwan.Entity.TrainerEntity;
import com.best.kwan.Entity.UserEntity;
import com.best.kwan.Repository.ReservationRepository;
import com.best.kwan.Repository.ScheduleRepository;
import com.best.kwan.Repository.TrainerRepository;
import com.best.kwan.Repository.UserRepository;
import com.best.kwan.vo.ReservationVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ReservationRepository reservationRepository;

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

        // 생성된 예약을 ReservationVO로 변환
        ReservationVO responseVO = new ReservationVO();
        responseVO.setReservationId(reservation.getReservationId());
        responseVO.setUserId(reservation.getUser().getId());
        responseVO.setTrainerId(reservation.getTrainer().getTrainerId());
        responseVO.setDate(reservation.getReservationDate());
        responseVO.setStartTime(reservation.getSchedule().getStartTime());
        responseVO.setEndTime(reservation.getSchedule().getEndTime());


        return responseVO;
    }
}
