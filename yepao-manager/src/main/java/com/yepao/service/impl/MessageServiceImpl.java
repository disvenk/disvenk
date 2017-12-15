package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.MessageMapper;
import com.yepao.pojo.Message;
import com.yepao.pojo.MessageExample;
import com.yepao.service.MessageService;
import com.yepao.utils.FastDFSClient;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageMapper messageMapper;
	
	@Override
	public void addMeaage(Message message) {
		messageMapper.insert(message);
	}

	@Override
	public void deleteMeaage(String ids) throws Exception {
		String[] mid = ids.split(",");
		FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
		for (String string : mid) {
			Long id = Long.parseLong(string);
			Message message = messageMapper.selectByPrimaryKey(id);
			String img = message.getImg();
			fastDFSClient.delete_file(img.substring(20));
			messageMapper.deleteByPrimaryKey(id);
		}

	}

	@Override
	public List<Message> getMessageList() {
		MessageExample example = new MessageExample();
		List<Message> list = messageMapper.selectByExample(example);
		return list;
	}

}
