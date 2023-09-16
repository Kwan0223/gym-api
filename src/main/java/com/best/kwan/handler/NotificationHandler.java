package com.best.kwan.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class NotificationHandler  extends TextWebSocketHandler {

    private static List<WebSocketSession> list = new ArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload : " + payload);

        for(WebSocketSession sess: list) {
            sess.sendMessage(message);
        }
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // URI에서 사용자 ID 추출
        String userId = extractUserIdFromSession(session);
        session.getAttributes().put("user_id", userId);
        list.add(session);
        log.info("User " + userId + " connected.");
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

        log.info(session + " 클라이언트 접속 해제");
        log.info("User " + session.getAttributes().get("user_id") + " disconnected.");
        list.remove(session);
    }
    private String extractUserIdFromSession(WebSocketSession session) {
        // URI에서 사용자 ID를 추출하는 로직을 작성합니다.
        // 예를 들면, /ws/notification/user/1234에서 '1234'를 추출하는 로직
        String path = session.getUri().getPath();
        String[] pathSegments = path.split("/");
        return pathSegments[pathSegments.length - 1]; // 마지막 세그먼트 반환
    }
    public void sendNotificationToUser(String userId, String message) {
        System.out.println("Sending message to user: " + userId);
        System.out.println("Number of WebSocket sessions: " + list.size());


        for (WebSocketSession session : list) {
            System.out.println("TEST Handlder for Start");
            System.out.println("Given userId: " + userId);
            System.out.println("Given session: " + session);
            System.out.println("Given session ID: " + session.getId());
            System.out.println("Given session getAttributes: " + session.getAttributes().get("id"));
            System.out.println("Session's userId: " + session.getAttributes().get("user_id"));

            if (userId.equals(session.getAttributes().get("user_id"))) {
                System.out.println("TEST Handlder if Start");
                try {
                    session.sendMessage(new TextMessage(message));
                    System.out.println("Message sent successfully to session");
                } catch (IOException e) {
                    System.out.println("Message sent fail to session");
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
