package com.best.kwan.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//util 사용법
// static 싱글톤 두개 방법
// static 이 초보자용 실글톤 : 중급?
// 싱클톤 : 메모리사용이 적음 대부분 많이 사용 : 집에서 찾아보기
// 오늘은 static으로 진행
// validation은 컨트롤러에서 작성
@Component
public class TimeUtil {

    public  LocalDateTime convertStringToLocalDateTime(String str) {

        return LocalDateTime.parse(str, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }



}
