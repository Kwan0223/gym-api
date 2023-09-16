package com.best.kwan.controller;


import com.best.kwan.service.PointService;
import com.best.kwan.service.TrainerService;
import com.best.kwan.vo.PointVO;
import com.best.kwan.vo.TrainerVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    @GetMapping
    public List<TrainerVO> getTrainer(){

        return trainerService.getTrainerList();
    }


}
