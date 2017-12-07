package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Message;

public interface MessageService {
	public List<Message> getMessageList();
	public void addMessage(Message message);
	public Message getMessage(Long id);
	public void update(Message message);
	public void delete(Long id);
	
	public List<Message> getMessageList(Long hotelId);
}
