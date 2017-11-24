package com.websocket.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.yepao.utils.JsonUtils;

public class WebSocketHandshakeInterceptor implements HandshakeInterceptor{
	 //握手前
    public boolean beforeHandshake(ServerHttpRequest request,
            ServerHttpResponse response, WebSocketHandler handler,
            Map<String, Object> attr) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                String userName = (String) session.getAttribute(Constants.SESSION_USERNAME);
                attr.put(Constants.WEBSOCKET_USERNAME,userName);
                System.out.println(JsonUtils.objectToJson(attr));
            }
        }
        return true;
    }
    
    //握手后
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
            WebSocketHandler handler, Exception e) {
    }
}
