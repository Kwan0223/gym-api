package com.best.kwan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해
                .allowedOrigins("http://localhost:3000") // 이 도메인에서의 액세스를 허용
                .allowedMethods("*") // 모든 HTTP 메서드 허용
                .allowCredentials(true) // 자격증명 허용.
                .exposedHeaders("Authorization")
                .maxAge(3600);
    }
}
