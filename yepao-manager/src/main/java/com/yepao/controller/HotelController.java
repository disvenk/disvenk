package com.yepao.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.socket.TextMessage;

import com.websocket.controller.PointWebSocketHandler;
import com.yepao.pojo.Hotel;
import com.yepao.pojo.HotelA;
import com.yepao.service.HotelService;
import com.yepao.utils.FastDFSClient;
import com.yepao.utils.JsonUtils;
import com.yepao.utils.YePaoResult;

@Controller
public class HotelController {

	@Autowired
	private HotelService hotelService;
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
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
		
			
		try {
			//1、取文件的全名和扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			if(StringUtils.isNotBlank(originalFilename)){
				String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
				//2、创建一个FastDFS的客户端
				FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
				//3、执行上传处理并返回一个路径
				String path = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
				//4、拼接返回的url和ip地址，拼装成完整的url
				String url = IMAGE_SERVER_URL + path;
				//保存酒店信息
	            hotel.setImg(url);
	            hotel.setInsertDate(new Date());
	            hotel.setUpdateDate(new Date());
	            hotel.setReputationLevel(new BigDecimal("0"));
	            hotel.setCommentCount(0);
	            hotel.setGoodReputation(0);
	            hotelService.saveHotel(hotel);
			}else {
				String url = null;
				//保存酒店信息
	            hotel.setImg(url);
	            hotel.setInsertDate(new Date());
	            hotel.setUpdateDate(new Date());
	            hotelService.saveHotel(hotel);
			}
			
		            
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	    
	        return "redirect:/pages/base/hotelInfo";
		
	}
	
	//更改酒店信息
	@RequestMapping(value="/hotel/update",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	public String updateHotel(MultipartFile uploadFile,HotelA hotela,HttpServletRequest  request,ModelMap model) {
		
		String checkFileName = uploadFile.getOriginalFilename();
	        
			//如果需要更改图片
	        Hotel hotelB =  hotelService.getHotel(hotela.getId());
	        String img = hotelB.getImg();
	        
	        try {
	        	
	        	 FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
	        	 if(img!=null){
	        	 fastDFSClient.delete_file(img.substring(20));
	        	}
			 
			 //更换新的图片
	        	 String originalFilename = uploadFile.getOriginalFilename();
	 			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
	 			
	 			//3、执行上传处理并返回一个路径
	 			String path = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
	 			//4、拼接返回的url和ip地址，拼装成完整的url
	 			String url = IMAGE_SERVER_URL + path;
	        
	            //保存酒店信息
	            Hotel hotel = new Hotel();
	       
	            hotel.setHotelId(hotela.getHotelId());
	            hotel.setName(hotela.getName());
	            hotel.setAddress(hotela.getAddress());
	            hotel.setDescreption(hotela.getDescreption());
	            hotel.setTel(hotela.getTel());
	            hotel.setImg(url);
	            hotel.setInsertDate(new Date(Long.parseLong(hotela.getInsertDate())));;
	            hotel.setUpdateDate(new Date());
	            hotel.setStandby(hotela.getStandby());
	            hotelService.updateHotel(hotela,hotel);
	            System.out.println(JsonUtils.objectToJson(hotel));
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
		
	        return "redirect:/pages/base/hotelInfo";	
	}
	
	//删除酒店信息
	@RequestMapping("/hotel/delete")
	public String deleteHotel(String ids,HttpServletRequest request){
		try {
			 FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
			 String[] strArr = ids.split(",");
				for (String string : strArr) {
					Long hotelId = Long.parseLong(string);
					//删除图片
			        Hotel hotelB = hotelService.getHotel(hotelId);
			        String img = hotelB.getImg();
			       fastDFSClient.delete_file(img.substring(20));
				hotelService.deleteHotel(hotelId);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/pages/base/hotelInfo";
		}
}
