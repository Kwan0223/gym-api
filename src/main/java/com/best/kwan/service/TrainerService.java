package com.best.kwan.service;

import com.best.kwan.Entity.PointEntity;
import com.best.kwan.Entity.TrainerEntity;
import com.best.kwan.Repository.PointRepository;
import com.best.kwan.Repository.TrainerRepository;
import com.best.kwan.vo.PointVO;
import com.best.kwan.vo.TrainerVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainerService {

    private final TrainerRepository trainerRepository;


    public List<TrainerVO> getTrainerList() {

        List<TrainerEntity> trainers = trainerRepository.findAll();
//        List<TrainerEntity> trainer = trainerRepository.findById(pointId);


        List<TrainerVO> trainerList = trainers.stream()
                .map(TrainerVO :: new)
                .collect(Collectors.toList());
        return trainerList;
    }
}
