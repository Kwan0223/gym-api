package com.best.kwan.handler;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class SessionCheckInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("user") == null) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return false; // 요청 처리 중단
//        }
//        return true; // 요청 처리 계속 진행
//    }
}
