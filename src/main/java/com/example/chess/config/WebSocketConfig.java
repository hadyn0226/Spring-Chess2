package com.example.chess.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.example.chess.handler.ChatHandler;
import com.example.chess.handler.SimpleTextHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
		//registry.addHandler(new SimpleTextHandler(), "/chess").setAllowedOrigins("*");
		registry.addHandler(new ChatHandler(), "/chat").setAllowedOrigins("*");
	}

}
