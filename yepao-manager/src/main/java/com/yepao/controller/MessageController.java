package com.yepao.controller;

import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yepao.pojo.Message;
import com.yepao.pojo.Picture;
import com.yepao.service.MessageService;
import com.yepao.utils.FastDFSClient;
import com.yepao.utils.JsonUtils;

@Controller
public class MessageController {
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value="/message/add",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	public String fileUpload(Message message,MultipartFile uploadFile,HttpServletRequest request) {
		try {
			//1、取文件的全名和扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			//2、创建一个FastDFS的客户端
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
			//3、执行上传处理并返回一个路径
			String path = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			//4、拼接返回的url和ip地址，拼装成完整的url
			String url = IMAGE_SERVER_URL + path;
			//5、返回map
			message.setImg(url);
			message.setInsertDate(new Date());
			message.setUpdateDate(new Date());
			messageService.addMeaage(message);
			return "redirect:/pages/base/massegerInfo";
		} catch (Exception e) {
			e.printStackTrace();
			//5、返回map
			Map result = new HashMap<String,Object>();
			result.put("error", 1);
			result.put("message", "图片上传失败");
			return JsonUtils.objectToJson(result);
		}
	}
	
	//查询消息
	@RequestMapping("/messager_pageQuery")
	@ResponseBody
	public List<Message> getMessageList(){
		List<Message> messageList = messageService.getMessageList();
		return messageList;
	}
	
	//删除消息
	@RequestMapping("/masseger/delete")
	public String deleteMessage(String ids){
		try {
			messageService.deleteMeaage(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/pages/base/massegerInfo";
	}
}
