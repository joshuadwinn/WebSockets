package com.example.websocket.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

@Component
public class JobSocketHandler implements WebSocketHandler {
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        // Assuming message.getPayload() returns a String
        String json = (String) message.getPayload();

        // Use TypeReference to correctly deserialize into a Map<String, String>
        Map<String, String> value = objectMapper.readValue(json, new TypeReference<Map<String, String>>() {});

        System.out.println(value.keySet());
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
