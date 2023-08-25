package com.best.kwan.config;

import com.best.kwan.handler.SessionCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




//@Configuration
//public class SessionConfig  implements WebMvcConfigurer  {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SessionCheckInterceptor())
//                .addPathPatterns("/api/**")  // `/api/`로 시작하는 모든 요청에 대해 적용
//                .excludePathPatterns("/api/v1/users/login", "/api/v1/users/signUp", "/api/v1/users/check-session"); // 로그인, 회원가입, 세션 체크 API는 제외
//    }
//}
