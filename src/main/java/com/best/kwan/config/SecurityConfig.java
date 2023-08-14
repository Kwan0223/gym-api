package com.best.kwan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.formLogin().disable().cors().and().csrf().disable();
//
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/ws/**", "/api/**").permitAll() // 웹소켓과 API 엔드포인트에 대한 권한 부여
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().disable()
//                .cors()
//                .and()
//                .csrf().disable();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/ws/**", "/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().disable()
                .cors()
                .and()
                .csrf().disable()
                .requestCache().requestCache(new NullRequestCache()) // 웹소켓 연결을 위한 설정 추가
                .and()
                .headers().frameOptions().sameOrigin(); // 웹소켓 연결을 위한 설정 추가
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}

