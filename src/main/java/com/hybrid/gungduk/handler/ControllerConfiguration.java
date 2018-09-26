package com.hybrid.gungduk.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@EnableWebMvc
public class ControllerConfiguration extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
	
	@Autowired
	private SocketHandler socketHandler; 
	
	@Override public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(socketHandler, "/echo.do").setAllowedOrigins("*").withSockJS(); 
	}

}
