package com.example.chess.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer  {

	
	public void configureMessageBroker(MessageBrokerRegistry config) {
		// 메시지 브로커 설정 (/topic 은 구독용, /queue 개인용)
        config.enableSimpleBroker("/topic");
        // 메시지 보낼 때 prefix
        config.setApplicationDestinationPrefixes("/app");
	}
	
	 public void registerStompEndpoints(StompEndpointRegistry registry) {
	        // 클라이언트가 연결할 WebSocket endpoint
	        registry.addEndpoint("/ws-chat").setAllowedOriginPatterns("*").withSockJS();
	    }
	
}
