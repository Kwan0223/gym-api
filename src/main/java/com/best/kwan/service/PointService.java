package com.best.kwan.service;

import com.best.kwan.Entity.PointEntity;
import com.best.kwan.Repository.PointRepository;
import com.best.kwan.Repository.UserRepository;
import com.best.kwan.vo.PointVO;
import com.best.kwan.vo.TrainerVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository pointRepository;

    private final TrainerService trainerService;

public Page<PointVO> getPointList(Pageable pageable) {

    Page<PointEntity> pointPage = pointRepository.findAll(pageable);
    List<PointVO> pointList = pointPage.getContent().stream()
            .map(point -> {
                PointVO pointVO = new PointVO(point);
                List<TrainerVO> trainerList = trainerService.getTrainersByPoint(point);
                pointVO.setTrainerInfo(trainerList);
                return pointVO;
            })
            .collect(Collectors.toList());

    return new PageImpl<>(pointList, pageable, pointPage.getTotalElements());
}

    public Page<PointVO> searchPointList(String pointName, Pageable pageable) {
        Page<PointEntity> searchResult = pointRepository.findAllByPointNameContaining(pointName, pageable);

        List<PointVO> pointList = searchResult.getContent().stream()
                .map(PointVO::new)
                .collect(Collectors.toList());
        // 확인 요망
        return new PageImpl<>(pointList, pageable, searchResult.getTotalElements());
    }
}

// 리스트 데이터 간단하게 만들기