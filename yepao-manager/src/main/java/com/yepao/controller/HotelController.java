package com.yepao.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yepao.pojo.Hotel;
import com.yepao.pojo.HotelA;
import com.yepao.service.HotelService;
import com.yepao.utils.JsonUtils;
import com.yepao.utils.YePaoResult;

@Controller
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	//查询酒店信息
	@RequestMapping("hotel_pageQuery")
	@ResponseBody
	public List<Hotel> getHotelList(){
		List<Hotel> list = hotelService.getHotelList();
		return list;
	}
	
	//添加酒店并上传图片
	@RequestMapping(value="/hotel/add",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	public String addHotel(MultipartFile uploadFile,Hotel hotel,HttpServletRequest  request,ModelMap model) {
		if(request instanceof MultipartHttpServletRequest){
			
		
		System.out.println("开始");  
	        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/hotelImg/");  
	        String fileName = uploadFile.getOriginalFilename();  
	        String extName = fileName.substring(fileName.lastIndexOf("."));
//	        String fileName = new Date().getTime()+".jpg";  
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
	            //保存酒店信息
	            hotel.setImg("/upload/"+newFile);
	            hotel.setInsertDate(new Date());
	            hotel.setUpdateDate(new Date());
	            hotelService.saveHotel(hotel);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        System.out.println(JsonUtils.objectToJson(hotel));
		}else{
			System.out.println("上传出错");
		}
	        return "redirect:/pages/base/hotelInfo";
		
	}
	
	//更改酒店信息
	@RequestMapping(value="/hotel/update",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	public String updateHotel(MultipartFile uploadFile,HotelA hotela,HttpServletRequest  request,ModelMap model) {
		if(request instanceof MultipartHttpServletRequest){
		String checkFileName = uploadFile.getOriginalFilename();
	        
			//如果不需要更改图片
			if(StringUtils.isBlank(checkFileName)){
				 Hotel hotelB =  hotelService.getHotel(hotela.getHotelId());
				 Hotel hotel = new Hotel();
		            hotel.setHotelId(hotela.getHotelId());
		            hotel.setName(hotela.getName());
		            hotel.setAddress(hotela.getAddress());
		            hotel.setDescreption(hotela.getDescreption());
		            hotel.setTel(hotela.getTel());
		            hotel.setImg(hotelB.getImg());
		            hotel.setInsertDate(new Date(Long.parseLong(hotela.getInsertDate())));;
		            hotel.setUpdateDate(new Date());
		            hotel.setStandby(hotela.getStandby());
		            hotelService.updateHotel(hotel);
		            
		            return "redirect:/pages/base/hotelInfo";
			}
			
			//如果需要更改图片
	        Hotel hotelB =  hotelService.getHotel(hotela.getHotelId());
	        String img = hotelB.getImg();
	        String delPath = request.getSession().getServletContext().getRealPath("/WEB-INF");
			 File file = new File(delPath+img);
			 System.out.println(file);
			 if(file.exists()){
				 file.delete();
			 }
			 
			 //更换新的图片
			String path = request.getSession().getServletContext().getRealPath("/WEB-INF/hotelImg/"); 
	        String fileName = uploadFile.getOriginalFilename();  
	        String extName = fileName.substring(fileName.lastIndexOf("."));
//	        String fileName = new Date().getTime()+".jpg";  
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
	            //保存酒店信息
	            Hotel hotel = new Hotel();
	            hotel.setHotelId(hotela.getHotelId());
	            hotel.setName(hotela.getName());
	            hotel.setAddress(hotela.getAddress());
	            hotel.setDescreption(hotela.getDescreption());
	            hotel.setTel(hotela.getTel());
	            hotel.setImg("/upload/"+newFile);
	            hotel.setInsertDate(new Date(Long.parseLong(hotela.getInsertDate())));;
	            hotel.setUpdateDate(new Date());
	            hotel.setStandby(hotela.getStandby());
	            hotelService.updateHotel(hotel);
	            System.out.println(JsonUtils.objectToJson(hotel));
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	       
		}else{
			System.out.println("上传出错");
		}
		
	        return "redirect:/pages/base/hotelInfo";	
	}
	
	//删除酒店信息
	@RequestMapping("/hotel/delete")
	public String deleteHotel(String ids,HttpServletRequest request){
		
		 String delPath = request.getSession().getServletContext().getRealPath("/WEB-INF");
		String[] strArr = ids.split(",");
		for (String string : strArr) {
			Long hotelId = Long.parseLong(string);
			//删除图片
	        Hotel hotelB = hotelService.getHotel(hotelId);
	        String img = hotelB.getImg();
	       
			 File file = new File(delPath+img);
			 System.out.println(file);
			 if(file.exists()){
				 file.delete();
			 }
		hotelService.deleteHotel(hotelId);
		
	}
		return "redirect:/pages/base/hotelInfo";
		}
}
