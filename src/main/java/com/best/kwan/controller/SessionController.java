package com.best.kwan.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/check-session")
@Log4j2
public class SessionController {

    private final  HttpSession session;

//    @GetMapping
//    public String checkSession() {
//        System.out.println("TEST checkSesiion Start!!!!");
//        System.out.println("TEST checkSesiion !!!!" + session.getAttribute("user"));
//
//        System.out.println("TEST checkSesiion !!!!" + session);
//        System.out.println("TEST checkSesiion !!!!" + session.getAttribute("user"));
//        System.out.println("Login checkSesiion ID: " + session.getId());
//
//
//        if (session.getAttribute("user") == null) {
//            return "No session found";
//        }
//        return "Session is valid";
//    }

    @GetMapping
    public String sessionInfo(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return "세션이 없습니다";
        }

        log.info("sessionId = {}", session.getId());
        log.info("getMaxInactiveInterval={}", session.getMaxInactiveInterval());
        log.info("creationTime={}", new Date(session.getCreationTime()));
        log.info("lastAccessTime={}", new Date(session.getLastAccessedTime()));

        return "세션출력";

    }





}
