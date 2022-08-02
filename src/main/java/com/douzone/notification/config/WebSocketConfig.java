package com.douzone.notification.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		
		// 클라이언트로 메세지를 응답 해 줄 때 prefix 정의
		registry.enableSimpleBroker("/sub");
		
		// 클라이언트에서 메세지 송신 시 붙일 prefix 정의
		registry.setApplicationDestinationPrefixes("/pub");
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		
		// 웹소켓과 핸드 쉐이크 할 URL
		registry.addEndpoint("/stomp/chat") // 핸드쉐이크가 될 endpoint 지정
				.setAllowedOrigins("*") // 현대 구동되고 있는 서버와 다른 도메인에서 접근 가능하게
				.withSockJS(); //SockJS 사용
	}
}
