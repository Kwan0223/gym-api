package com.best.kwan.service;

import com.best.kwan.vo.UserVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessionService {

    private final HttpSession session;
    private final ObjectMapper objectMapper;

    public UserVO checkLoginStatus() {
        log.info("Checking session for Session ID: {}", session.getId());

        String jsonUser = (String) session.getAttribute("user");
        try {
            return objectMapper.readValue(jsonUser, UserVO.class);
        } catch (Exception e) {
            log.error("Error parsing session user data", e);
            return null;
        }
    }
}
