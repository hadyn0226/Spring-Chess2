package com.example.chess.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SimpleTextHandler extends TextWebSocketHandler {
	
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();
		System.out.println("받은 메세지: " + payload);
		session.sendMessage(new TextMessage("서버에서 받은 메세지: " + payload));
	}
	
}
