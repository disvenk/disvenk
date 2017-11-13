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

import com.yepao.pojo.Combo;
import com.yepao.pojo.ComboA;
import com.yepao.pojo.Dishstyle;
import com.yepao.pojo.DishstyleA;
import com.yepao.service.ComboService;
import com.yepao.service.DishStyleService;
import com.yepao.utils.FastDFSClient;

@Controller
public class ComboController {

	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	@Autowired
	private ComboService comboService;
	
	//查询酒店信息
	@RequestMapping("combo_pageQuery")
	@ResponseBody
	public List<Combo> getComboList(){
		List<Combo> list = comboService.getComboList();
		return list;
	}
	
	//添加菜品并上传图片
	@RequestMapping(value="/combo/add",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	public String addCombo(MultipartFile uploadFile,Combo combo,HttpServletRequest  request,ModelMap model) {
		
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
				
				combo.setImg(url);
				combo.setCreated(new Date());
				combo.setUpdated(new Date());
				comboService.addCombo(combo);
			} catch (Exception e) {
				e.printStackTrace();

			}
	        return "redirect:/pages/base/comboInfo";
		
	}
	
	//更改菜品信息
	@RequestMapping(value="/combo/update",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	public String updateCombo(MultipartFile uploadFile, ComboA comboA,HttpServletRequest  request,ModelMap model) throws Exception {
		String checkFileName = uploadFile.getOriginalFilename();
	        
			//如果不需要更改图片
			if(StringUtils.isBlank(checkFileName)){
				Combo comboB = comboService.getCombo(comboA.getId());
				Combo combo = new Combo();
		            combo.setId(comboA.getId());
		            combo.setName(comboA.getName());;
		            combo.setImg(comboB.getImg());
		            combo.setPrice(comboA.getPrice());
		            combo.setCreated(new Date(Long.parseLong(comboA.getCreated())));
		            combo.setUpdated(new Date());
		            comboService.updateCombo(combo);
		            
		            return "redirect:/pages/base/comboInfo";
			}
			
			//如果需要更改图片
			Combo comboB = comboService.getCombo(comboA.getId());
	        String img = comboB.getImg().substring(20);
	        FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
	        fastDFSClient.delete_file(img);
	     
			 
			 //更换新的图片
	      //3、执行上传处理并返回一个路径
	        String extName = checkFileName.substring(checkFileName.lastIndexOf(".") + 1);
			String path = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			//4、拼接返回的url和ip地址，拼装成完整的url
			String url = IMAGE_SERVER_URL + path; 
	  
	     
	            //保存酒店信息
			 Combo combo = new Combo();
			 	combo.setId(comboA.getId());
			 	combo.setName(comboA.getName());;
			 	combo.setImg(url);
			 	combo.setPrice(comboA.getPrice());
			 	combo.setCreated(new Date(Long.parseLong(comboA.getCreated())));
			 	combo.setUpdated(new Date());
			 	comboService.updateCombo(combo);
		
	        return "redirect:/pages/base/comboInfo";	
	}
	
	//删除菜品信息
	@RequestMapping("/combo/delete")
	public String deleteCombo(String ids,HttpServletRequest request) throws Exception{
		
		 FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
		String[] strArr = ids.split(",");
		for (String string : strArr) {
			Long id = Long.parseLong(string);
			//删除图片
	        Combo combo = comboService.getCombo(id);
	        String img = combo.getImg().substring(20);
	        
	     fastDFSClient.delete_file(img);
	     comboService.deleteCombo(id);
		
	}
		return "redirect:/pages/base/comboInfo";
		}
	
	//查询已关联的菜品
	@RequestMapping("/findDishStyle_combo")
	@ResponseBody
	public List<Dishstyle> findDishStyle_combo(Long id){
		List<Dishstyle> list = comboService.getDishStyleByCombo(id);
		return list;
	}
	
	//关联菜品
	@RequestMapping("/combo_dishStyle")
	public String combo_dishStyle(Long id,String[] dishStyleIds){
		System.out.println(dishStyleIds);
		comboService.comboDishStyle(id, dishStyleIds);
		return "redirect:/pages/base/comboInfo";
	}
}
