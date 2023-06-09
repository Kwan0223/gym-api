package com.best.kwan.service;

import com.best.kwan.Entity.PointEntity;
import com.best.kwan.Repository.PointRepository;
import com.best.kwan.Repository.UserRepository;
import com.best.kwan.vo.PointVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository pointRepository;





    public List<PointVO> getPointList() throws JsonProcessingException {

        List<PointEntity> pointList = pointRepository.findAll();

//        for(int i = 0; i<pointList.size(); i++){
//            System.out.println("TEST !!  : " + pointList.get(i).getPointImageEntities().size());
//        }

        List<PointVO> pointVOList = pointList.stream()
                .map(PointVO::new)
                .collect(Collectors.toList());

//         ObjectMapper test = new ObjectMapper();
//        String json = test.writeValueAsString(pointList);



        return pointVOList;
    }

    public List<PointVO> searchPointList(PointVO pointVO) {
        String PointName = pointVO.getPointName();
        List<PointEntity> searchResult = pointRepository.findAllByPointNameContaining(PointName);

        List<PointVO> pointVOList = searchResult.stream()
                .map(PointVO::new)
                .collect(Collectors.toList());


        return pointVOList;

    }
}
