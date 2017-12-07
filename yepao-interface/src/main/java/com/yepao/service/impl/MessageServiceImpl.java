package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.MessageMapper;
import com.yepao.pojo.Message;
import com.yepao.pojo.MessageExample;
import com.yepao.pojo.MessageExample.Criteria;
import com.yepao.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageMapper messageMapper;
	
	public List<Message> getMessageList() {
		MessageExample example = new MessageExample();
		List<Message> list = messageMapper.selectByExample(example);
		return list;
	}

	public void addMessage(Message message) {
		messageMapper.insert(message);
	}

	public Message getMessage(Long id) {
		Message message = messageMapper.selectByPrimaryKey(id);
		return message;
	}

	public void update(Message message) {
		messageMapper.updateByPrimaryKey(message);
	}

	public void delete(Long id) {
		messageMapper.deleteByPrimaryKey(id);

	}

	public List<Message> getMessageList(Long hotelId) {
		MessageExample example = new MessageExample();
		Criteria criteria = example.createCriteria();
		criteria.andHotelidEqualTo(hotelId);
		List<Message> list = messageMapper.selectByExample(example);
		return list;
	}

}
