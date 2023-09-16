package com.best.kwan.controller;


import com.best.kwan.Entity.ReservationEntity;
import com.best.kwan.service.ReservationService;
import com.best.kwan.vo.ReservationVO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservation")
public class ReservationController {


    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationVO> createReservation(@RequestBody ReservationVO reservationVO) {

        ReservationVO createdReservation = reservationService.createReservation(reservationVO);

        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ReservationVO>> getReservations(
            @RequestParam("date") String dateStr,
            @RequestParam("trainerId") Long trainerId) {

        LocalDateTime date = convertStringToLocalDateTime(dateStr);
        List<ReservationVO> reservations = reservationService.getReservationsByDateAndTrainer(date, trainerId);

        return ResponseEntity.ok(reservations);
    }

    public LocalDateTime convertStringToLocalDateTime(String str) {

        return LocalDateTime.parse(str, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }



}
