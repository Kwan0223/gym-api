package com.best.kwan.controller;


import com.best.kwan.vo.UserVO;
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
@RequestMapping("/api/v1/check-session")
@Log4j2
public class SessionController {

    private final HttpSession session;


    @GetMapping
    public ResponseEntity<?> checkLoginStatus() {
        UserVO user = (UserVO) session.getAttribute("user");

        if (user != null) {
            System.out.println("Session Check !!!! YESS!!!!");
            return ResponseEntity.ok(user);
        } else {
            System.out.println("Session Check !!!! NO!!!!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not logged in");
        }
    }


}
