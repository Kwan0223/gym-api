package com.best.kwan.controller;


import com.best.kwan.service.PointService;
import com.best.kwan.vo.PointVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/point")
public class PointController {

    private final PointService pointService;


    @GetMapping
    public List<PointVO> getPointList() throws JsonProcessingException {

        return pointService.getPointList();
    }

    @GetMapping("/search")
    public List<PointVO> searchPointList(@RequestParam String pointName) {
        PointVO pointVO = new PointVO();
        pointVO.setPointName(pointName);
        return pointService.searchPointList(pointVO);
    }
}
