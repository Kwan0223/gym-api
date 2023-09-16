package com.best.kwan.controller;


import com.best.kwan.service.PointService;
import com.best.kwan.vo.PointVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/point")
public class PointController {

    private final PointService pointService;

    @GetMapping
    public Page<PointVO> getPointList(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "5") int size ) throws JsonProcessingException {

        Pageable pageable = PageRequest.of(page, size);
        return pointService.getPointList(pageable);
    }

    @GetMapping("/search")
    public Page<PointVO> searchPointList(@RequestParam String pointName,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);

        return pointService.searchPointList(pointName, pageable);
    }
}
