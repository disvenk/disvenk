package com.yepao.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.print.attribute.standard.Media;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yepao.utils.JsonUtils;
import com.yepao.utils.YePaoResult;

@Controller
public class HallUploadController {

	//宴会厅上传图片
	@RequestMapping(value="/ha/upload",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String hallUpload(MultipartFile uploadFile,HttpServletRequest request,
			HttpServletResponse response){
		if(request instanceof MultipartHttpServletRequest){
			
			
			System.out.println("开始");  
		        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/hallImg/");  
		        String fileName = uploadFile.getOriginalFilename();  
		        String extName = fileName.substring(fileName.lastIndexOf("."));
//		        String fileName = new Date().getTime()+".jpg";  
		      //生成随机图片名
				UUID uuid = UUID.randomUUID();
				//拼接成新的文件名
				String newFile = uuid+extName;
		        System.out.println(path);  
		        File targetFile = new File(path+"/"+newFile);  
		        if(!targetFile.exists()){  
		            targetFile.mkdirs();  
		        }  
		   
		        try { 
		        	//保存 图片
		            uploadFile.transferTo(targetFile);
		            Map result = new HashMap<String,Object>();
					result.put("error", 0);
					result.put("url", "/hallImg/"+newFile);
					return JsonUtils.objectToJson(result);
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
			}else{
				System.out.println("上传出错");
			}
		return null;
	}
	
}
