package com.best.kwan.controller;


import com.best.kwan.service.PointService;
import com.best.kwan.vo.PageVO;
import com.best.kwan.vo.PointResposeVO;
import com.best.kwan.vo.PointVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/point")
public class PointController {

    private final PointService pointService;

//    @GetMapping
//    public Page<PointVO> getPointList(@RequestParam(defaultValue = "0") int page,
//                                      @RequestParam(defaultValue = "5") int size ){
//
//        Pageable pageable = PageRequest.of(page, size);
//        return pointService.getPointList(pageable);
//    }


//    @GetMapping("/search")
//    public Page<PointVO> searchPointList(@RequestParam String pointName,
//                                         @RequestParam(defaultValue = "0") int page,
//                                         @RequestParam(defaultValue = "5") int size) {
//        Pageable pageable = PageRequest.of(page, size);
//
//        return pointService.searchPointList(pointName, pageable);
//    }

    @GetMapping
    public ResponseEntity<PointResposeVO> getPointList(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<PointVO> result = pointService.getPointList(pageable);

        PointResposeVO response = new PointResposeVO(new PageVO(result), result.getContent());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<PointResposeVO> searchPointList(@RequestParam String pointName,
                                                         @RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<PointVO> result = pointService.searchPointList(pointName, pageable);

        PointResposeVO response = new PointResposeVO(new PageVO(result), result.getContent());

        return ResponseEntity.ok(response);
    }
}
