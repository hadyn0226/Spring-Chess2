package com.example.chess.controller;

import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.chess.dto.ChatMessage;
import com.example.chess.dto.MatchRequest;
import com.example.chess.dto.MatchResponse;
import com.example.chess.service.MatchService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChessController {
	
	private final MatchService matchService;
	private final SimpMessagingTemplate messagingTemplate;
	
	@MessageMapping("sendMessage")
	@SendTo("/topic/messages")
	public ChatMessage send(ChatMessage chatMessage) {
		System.out.println(chatMessage);
		return chatMessage;
	}
	
	@MessageMapping("/match")
	public void match(MatchRequest request) {
		log.info("Matching Request!");
		MatchResponse response = matchService.addToQueue(request.getUserId());
		if("MATCHED".equals(response.getStatus())) {
			for(String userId : matchService.getUserIds(response.getGameId())) {
				messagingTemplate.convertAndSend("/topic/match/" + userId, response);
			}
		}
	}
	
}
