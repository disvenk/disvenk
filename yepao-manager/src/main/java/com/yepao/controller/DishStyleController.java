package com.yepao.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yepao.pojo.Dishstyle;
import com.yepao.pojo.DishstyleA;
import com.yepao.service.DishStyleService;
import com.yepao.utils.FastDFSClient;

@Controller
public class DishStyleController {

	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	@Autowired
	private DishStyleService dishStyleService;
	
	//查询酒店信息
	@RequestMapping("dishStyle_pageQuery")
	@ResponseBody
	public List<Dishstyle> getDishStyleList(){
		List<Dishstyle> list = dishStyleService.getDishStyleList();
		return list;
	}
	
	//添加菜品并上传图片
	@RequestMapping(value="/dishStyle/add",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	public String addDishStyle(MultipartFile uploadFile,Dishstyle dishstyle,HttpServletRequest  request,ModelMap model) {
		
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
				
				dishstyle.setImg(url);
				dishstyle.setCreated(new Date());
				dishstyle.setUpdated(new Date());
				dishStyleService.addDishStyle(dishstyle);
			} catch (Exception e) {
				e.printStackTrace();

			}
	        return "redirect:/pages/base/dishStyleInfo";
		
	}
	
	//更改菜品信息
	@RequestMapping(value="/dishStyle/update",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	public String updateDishStyle(MultipartFile uploadFile,DishstyleA dishstyleA,HttpServletRequest  request,ModelMap model) throws Exception {
		String checkFileName = uploadFile.getOriginalFilename();
	        
			//如果不需要更改图片
			if(StringUtils.isBlank(checkFileName)){
				Dishstyle dishstyleB = dishStyleService.getDishStyle(dishstyleA.getId());
				 Dishstyle dishstyle = new Dishstyle();
		            dishstyle.setId(dishstyleA.getId());
		            dishstyle.setName(dishstyleA.getName());;
		            dishstyle.setImg(dishstyleB.getImg());
		            dishstyle.setPrice(dishstyleA.getPrice());
		            dishstyle.setCreated(new Date(Long.parseLong(dishstyleA.getCreated())));
		            dishstyle.setUpdated(new Date());
		            dishStyleService.updateDishStyle(dishstyle);
		            
		            return "redirect:/pages/base/dishStyleInfo";
			}
			
			//如果需要更改图片
			Dishstyle dishstyleB = dishStyleService.getDishStyle(dishstyleA.getId());
	        String img = dishstyleB.getImg().substring(20);
	        FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
	        fastDFSClient.delete_file(img);
	     
			 
			 //更换新的图片
	      //3、执行上传处理并返回一个路径
	        String extName = checkFileName.substring(checkFileName.lastIndexOf(".") + 1);
			String path = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			//4、拼接返回的url和ip地址，拼装成完整的url
			String url = IMAGE_SERVER_URL + path; 
	  
	     
	            //保存酒店信息
			 Dishstyle dishstyle = new Dishstyle();
	            dishstyle.setId(dishstyleA.getId());
	            dishstyle.setName(dishstyleA.getName());;
	            dishstyle.setImg(url);
	            dishstyle.setPrice(dishstyleA.getPrice());
	            dishstyle.setCreated(new Date(Long.parseLong(dishstyleA.getCreated())));
	            dishstyle.setUpdated(new Date());
	            dishStyleService.updateDishStyle(dishstyle);
		
	        return "redirect:/pages/base/dishStyleInfo";	
	}
	
	//删除菜品信息
	@RequestMapping("/dishStyle/delete")
	public String deleteDishStyle(String ids,HttpServletRequest request) throws Exception{
		
		 FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
		String[] strArr = ids.split(",");
		for (String string : strArr) {
			Long id = Long.parseLong(string);
			//删除图片
	        Dishstyle dishstyle = dishStyleService.getDishStyle(id);
	        String img = dishstyle.getImg().substring(20);
	        
	     fastDFSClient.delete_file(img);
		dishStyleService.deleteDishStyle(id);
		
	}
		return "redirect:/pages/base/dishStyleInfo";
		}
}
