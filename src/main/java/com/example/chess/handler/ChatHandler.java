package com.example.chess.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.example.chess.dto.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChatHandler extends TextWebSocketHandler{
	
	private static Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();//ConcurrentHashMap : Multi-Thread 환경에서 사용하는 클래스
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String userId = session.getUri().getQuery().split("=")[1];
		sessions.put(userId, session);
		System.out.println(userId + " 접속됨");
	}
	
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//JSON -> DTO
		ChatMessage chatMessage = objectMapper.readValue(message.getPayload(), ChatMessage.class);
		
		String to = chatMessage.getTo();
		String msg = chatMessage.getMsg();
		
		System.out.println("\"메시지 수신: to=\" + to + \", msg=\" + msg");
		
		WebSocketSession targetSession = sessions.get(to);
		if (targetSession != null && targetSession.isOpen()) {
			String response = objectMapper.writeValueAsString(new ChatMessage("server", "상대가 보냄: " + msg));
			targetSession.sendMessage(new TextMessage(response));
		}
		
	}
	
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		sessions.values().remove(session);
	}
	
}
