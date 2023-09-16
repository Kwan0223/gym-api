package com.best.kwan.controller;


import com.best.kwan.vo.UserVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/checkSession")
@Log4j2
public class SessionController {

    private final HttpSession session;
    private final ObjectMapper objectMapper;


    @GetMapping
    public ResponseEntity<?> checkLoginStatus() {
        System.out.println("TEST !!!!!!!!!! checkLoginStatus ");
        System.out.println("TEST !!!!!!!!!! checkLoginStatus getAttribute  " + session.getAttribute("user"));
        System.out.println("Login  checkLoginStatus Session ID: " + session.getId());

        String jsonUser = (String) session.getAttribute("user");
        UserVO userVO = null;


        try {
            userVO = objectMapper.readValue(jsonUser, UserVO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("Checking session for user: {}", userVO);

        if (userVO != null) {
            System.out.println("Session Check !!!! YESS!!!!");
            return ResponseEntity.ok(userVO);
        } else {
            System.out.println("Session Check !!!! NO!!!!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not logged in");
        }
    }
}
