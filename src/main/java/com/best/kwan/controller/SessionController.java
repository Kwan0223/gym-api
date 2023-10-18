package com.best.kwan.controller;

import com.best.kwan.service.SessionService;
import com.best.kwan.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/checkSession")
@Log4j2
public class SessionController {

    private final SessionService sessionService;

    @GetMapping
    public ResponseEntity<?> checkLoginStatus() {
        UserVO userVO = sessionService.checkLoginStatus();

        log.info("Checking session for user: {}", userVO);

        if (userVO != null) {
            return ResponseEntity.ok(userVO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not logged in");
        }
    }
}
