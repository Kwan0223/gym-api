package com.best.kwan.controller;


import com.best.kwan.Entity.ReservationEntity;
import com.best.kwan.service.ReservationService;
import com.best.kwan.vo.ReservationVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservation")
public class ReservationController {


    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationVO> createReservation(@RequestBody ReservationVO reservationVO){
        ReservationVO createdReservation = reservationService.createReservation(reservationVO);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }



}
