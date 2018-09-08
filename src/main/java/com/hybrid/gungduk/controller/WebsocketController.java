package com.hybrid.gungduk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.hybrid.gungduk.handler.SocketHandler;

@CrossOrigin(origins = "*")
@RestController
@EnableWebSocket
public class WebsocketController implements WebSocketConfigurer{
	@Autowired
	SocketHandler handler;
	
	@RequestMapping(value = "/api/v1/websocket", method = RequestMethod.GET)
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(handler, "/echo.do").setAllowedOrigins("*");		
	}
	
}
