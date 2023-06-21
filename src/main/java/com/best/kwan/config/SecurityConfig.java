package com.best.kwan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.formLogin().disable().cors().disable().csrf().disable();
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin().disable().cors().and().csrf().disable();

    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .logout()
//                .logoutSuccessHandler((request, response, authentication) -> {
//                    response.setStatus(HttpServletResponse.SC_OK);
//                })
//                .invalidateHttpSession(true)
//                .deleteCookies("JSESSIONID")
//                .and()
//                .formLogin().disable().cors().and().csrf().disable();
//    }



    @Bean
    public  BCryptPasswordEncoder passwordEncoder() {

        return  new BCryptPasswordEncoder();
    }
}

