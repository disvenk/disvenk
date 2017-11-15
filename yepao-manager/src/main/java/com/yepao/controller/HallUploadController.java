package com.yepao.controller;

import java.io.File;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.print.attribute.standard.Media;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yepao.pojo.Picture;
import com.yepao.utils.FastDFSClient;
import com.yepao.utils.JsonUtils;
import com.yepao.utils.YePaoResult;

@Controller
public class HallUploadController {

	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	//宴会厅上传图片
	@RequestMapping(value="/ha/upload",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String hallUpload(MultipartFile uploadFile,HttpServletRequest request,
			HttpServletResponse response){
		try{
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
		Map result = new HashMap<String,Object>();
		result.put("error", 0);
		result.put("url", url);
		System.out.println("图片上传完成");
		return JsonUtils.objectToJson(result);
	} catch (Exception e) {
		e.printStackTrace();
		//5、返回map
		Map result = new HashMap<String,Object>();
		result.put("error", 1);
		result.put("message", "图片上传失败");
		return JsonUtils.objectToJson(result);
	}
	}
}
