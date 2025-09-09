package com.example.chess.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.chess.dto.ChatMessage;

@Controller
public class ChessController {
	
	@MessageMapping("sendMessage")
	@SendTo("/topic/messages")
	public ChatMessage send(ChatMessage chatMessage) {
		System.out.println(chatMessage);
		return chatMessage;
	}
	
}
