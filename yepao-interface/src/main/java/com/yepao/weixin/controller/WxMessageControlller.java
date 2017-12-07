package com.yepao.weixin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.Message;
import com.yepao.service.MessageService;

@Controller
@RequestMapping("/message")
public class WxMessageControlller {
	@Autowired
	private MessageService messageService;
	
	/**
	 * 获得消息列表
	 * @return 消息列表
	 */
	@RequestMapping("/messageList")
	@ResponseBody
	public List<Message> getMessageList(Long hotelId){
		List<Message> list = messageService.getMessageList(hotelId);
		return list;
	}
	
	/**
	 * 获得消息详情
	 * @param messageId 消息id
	 * @return 消息详情
	 */
	@RequestMapping("/messageDetail")
	@ResponseBody
	public Message getMessageDetail(Long messageId){
		Message message= messageService.getMessage(messageId);
		return message;
	}
}
