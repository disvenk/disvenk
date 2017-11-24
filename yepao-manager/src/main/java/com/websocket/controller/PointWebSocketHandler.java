package com.websocket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.sun.net.httpserver.HttpServer;
import com.yepao.pojo.User;
import com.yepao.utils.JsonUtils;


public class PointWebSocketHandler extends  TextWebSocketHandler {


	    //在线用户列表
	    private static final ConcurrentHashMap<String, WebSocketSession> users;
	    //用户标识
	    private static final String CLIENT_ID = "user";

	    static {
	        users = new ConcurrentHashMap<>();
	    }

	    
	    @Override
	    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	    	Long uid = (Long) session.getAttributes().get("userid");
	        System.out.println("成功建立连接");
	        String userId = getClientId(session);
	        System.out.println("userId:"+userId);
	        if (userId != null) {
	            users.put(userId, session);
	            session.sendMessage(new TextMessage("成功建立socket连接"));
	            System.out.println(userId);
	            System.out.println(session);
	        }
	    }

	    @Override
	    public void handleTextMessage(WebSocketSession session, TextMessage message) {
	        // ...
	        System.out.println(message.getPayload());

	        WebSocketMessage message1 = new TextMessage("server:"+message);
	        try {
	            session.sendMessage(message1);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * 发送信息给指定用户
	     * @param clientId
	     * @param message
	     * @return
	     */
	    public boolean sendMessageToUser(Integer clientId, TextMessage message) {
	        if (users.get(clientId) == null) return false;
	        WebSocketSession session = users.get(clientId);
	        System.out.println("sendMessage:" + session);
	        if (!session.isOpen()) return false;
	        try {
	            session.sendMessage(message);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	    }


	    @Override
	    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
	        if (session.isOpen()) {
	            session.close();
	        }
	        System.out.println("连接出错");
	        users.remove(getClientId(session));
	    }

	    @Override
	    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	        System.out.println("连接已关闭：" + status);
	        users.remove(getClientId(session));
	    }

	    @Override
	    public boolean supportsPartialMessages() {
	        return false;
	    }

	    /**
	     * 获取用户标识
	     * @param session
	     * @return
	     */
	    private String getClientId(WebSocketSession session) {
	        try {
	            String clientId = (String) session.getAttributes().get("websocket_username");
	            String objectToJson = JsonUtils.objectToJson(session.getAttributes());
	            System.out.println(objectToJson);
	            return clientId;
	        } catch (Exception e) {
	            return null;
	        }
	    }
	}

