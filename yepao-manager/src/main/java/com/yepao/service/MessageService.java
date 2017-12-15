package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Message;

public interface MessageService {
	public List<Message> getMessageList();
	public void addMeaage(Message message);
	public void deleteMeaage(String ids)throws Exception;
}
