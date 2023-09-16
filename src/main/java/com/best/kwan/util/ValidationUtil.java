package com.best.kwan.util;

//util 사용법
// static 싱글톤 두개 방법
// static 이 초보자용 실글톤 : 중급?
// 싱클톤 : 메모리사용이 적음 대부분 많이 사용 : 집에서 찾아보기
// 오늘은 static으로 진행
// validation은 컨트롤러에서 작성
public class ValidationUtil {

    static public boolean checkPwd(String pwd) {

        return pwd.matches("^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[!\"#$%&'()*+,./:;<=>?@^_`{|}~-]).{8,}$");
    }

    static public boolean checkEmail(String email) {

        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

}
