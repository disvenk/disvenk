package com.websocket.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        /* registry.addHandler(systemWebSocketHandler(),"/webSocketServer");
         registry.addHandler(systemWebSocketHandler(),"/sockjs/webSocketServer");*/
         registry.addHandler(pointWebSocketHandler(),"/webSocketServer").setAllowedOrigins("*").addInterceptors(new WebSocketHandshakeInterceptor());
         registry.addHandler(pointWebSocketHandler(),"/sockjs/webSocketServer").setAllowedOrigins("*");
    }
    @Bean
    public WebSocketHandler systemWebSocketHandler(){
        return new SystemWebSocketHandler();
    }
    
    @Bean
    public WebSocketHandler pointWebSocketHandler(){
        return new PointWebSocketHandler();
    }
}