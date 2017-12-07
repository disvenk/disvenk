package com.yepao.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.yepao.pojo.Hotel;
import com.yepao.pojo.HotelA;
import com.yepao.pojo.Media;
import com.yepao.pojo.Picture;
import com.yepao.pojo.WeddingTalent;
import com.yepao.pojo.WeddingTalentA;
import com.yepao.service.MediaFileService;
import com.yepao.service.TalentService;
import com.yepao.utils.FastDFSClient;
import com.yepao.utils.JsonUtils;

@Controller
public class TalentController {
	
	@Autowired
	private TalentService talentService;
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	@Autowired
	private MediaFileService mediaFileService;
	
	//查询人才
	@RequestMapping("/talent_pageQuery")
	@ResponseBody
	public List<WeddingTalent> getWeddingTalent(String name,Long hotelId){
		try {
			name = new String(name.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(name);
		List<WeddingTalent> list = talentService.getWeddingTalents(name,hotelId);
		return list;
	}
	
	//添加人才并上传图片
		@RequestMapping(value="/talent/add",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
		public String addHotel(String[] styles,String talent,MultipartFile uploadFile,WeddingTalent wTalent,HttpServletRequest  request,ModelMap model) {
			
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
		            wTalent.setHeadImg(url);
		            if(styles!=null){
		            	 String style =  StringUtils.join(styles,",");
				           wTalent.setStyle(style);	
		            }
		          
		            wTalent.setCreated(new Date());
		            wTalent.setUpdated(new Date());
		            talentService.saveTalent(wTalent);
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
		        System.out.println(JsonUtils.objectToJson(wTalent));
			
		        return "redirect:/pages/base/"+talent+"Info";
			
		}
		
		//更改人才信息
		@RequestMapping(value="/talent/update",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
		public String updateHotel(String[] styles,String talent,MultipartFile uploadFile,WeddingTalentA wTalentA,HttpServletRequest  request,ModelMap model) throws Exception {
			if(request instanceof MultipartHttpServletRequest){
			String checkFileName = uploadFile.getOriginalFilename();
		        
				//如果不需要更改图片
				if(StringUtils.isBlank(checkFileName)){
					 WeddingTalent wTalentB =  talentService.getWeddingTalent(wTalentA.getWeddingTalentId());
					 WeddingTalent wTalent = new WeddingTalent(); 
			            wTalent.setWeddingTalentId(wTalentA.getWeddingTalentId());
			            wTalent.setHotelid(wTalentA.getHotelid());
			            wTalent.setHeadImg(wTalentB.getHeadImg());
			            wTalent.setName(wTalentA.getName());
			            wTalent.setOccupation(wTalentA.getOccupation());
			            wTalent.setExperience(wTalentA.getExperience());
			            wTalent.setTel(wTalentA.getTel());
			            wTalent.setPrice(wTalentA.getPrice());
			            wTalent.setIntroduction(wTalentA.getIntroduction());
			            if(styles == null){
			            	 wTalent.setStyle(wTalentA.getStyle());
			            }else{
			            	 String style =  StringUtils.join(styles,",");
					           wTalent.setStyle(style);
			            }
			           
			            wTalent.setGoodReputation(wTalentA.getGoodReputation());
			            wTalent.setComprehensive(wTalentA.getComprehensive());
			            wTalent.setChosenCount(wTalentA.getChosenCount());
			            wTalent.setCreated(new Date(Long.parseLong(wTalentA.getCreated())));
			            wTalent.setUpdated(new Date());
			            wTalent.setStandby(wTalentA.getStandby());
			            talentService.updateTalent(wTalent);
			            
			            return "redirect:/pages/base/"+talent+"Info";
				}
				
				//如果需要更改图片
				//先删除原来的图片
		        WeddingTalent wTalentB =  talentService.getWeddingTalent(wTalentA.getWeddingTalentId());
		        String img = wTalentB.getHeadImg();
		        String delName = img.substring(20);
		        FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
		        Integer result = fastDFSClient.delete_file(delName);
				 
				 //更换新的图片
		        String originalFilename = uploadFile.getOriginalFilename();
				String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
				//3、执行上传处理并返回一个路径
				String path = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
				//4、拼接返回的url和ip地址，拼装成完整的url
				String url = IMAGE_SERVER_URL + path; 
		          
		  
		        try {  
		        	
		            //保存人才信息
		            WeddingTalent wTalent = new WeddingTalent();
		            wTalent.setHotelid(wTalentA.getHotelid());
		            wTalent.setWeddingTalentId(wTalentA.getWeddingTalentId());
		            wTalent.setName(wTalentA.getName());
		            wTalent.setHeadImg(url);
		            wTalent.setOccupation(wTalentA.getOccupation());
		            wTalent.setExperience(wTalentA.getExperience());
		            wTalent.setTel(wTalentA.getTel());
		            wTalent.setPrice(wTalentA.getPrice());
		            wTalent.setIntroduction(wTalentA.getIntroduction());
		            wTalent.setStyle(wTalentA.getStyle());
		            wTalent.setGoodReputation(wTalentA.getGoodReputation());
		            wTalent.setComprehensive(wTalentA.getComprehensive());
		            wTalent.setChosenCount(wTalentA.getChosenCount());
		            wTalent.setCreated(new Date(Long.parseLong(wTalentA.getCreated())));
		            wTalent.setUpdated(new Date());
		            wTalent.setStandby(wTalentA.getStandby());
		            talentService.updateTalent(wTalent);
		            
		            System.out.println(JsonUtils.objectToJson(wTalent));
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
		       
			}else{
				System.out.println("上传出错");
			}
			
		        return "redirect:/pages/base/"+talent+"Info";	
		}
		
		//删除人才信息
		@RequestMapping("/talent/delete")
		public String deleteHotel(String talent,String ids,HttpServletRequest request) throws Exception{
			 FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
			String[] strArr = ids.split(",");
			for (String string : strArr) {
				Long id = Long.parseLong(string);
				
		        WeddingTalent wTalent = talentService.getWeddingTalent(id);
		        String img = wTalent.getHeadImg();
		        Integer tid = wTalent.getWeddingTalentId().intValue();
		        
		        //查询出picture和media表里的所有关于该人才的图片和视频然后一个一个的删除
		        List<Picture> picList = mediaFileService.getPicByTid(tid);
		        for (Picture picture : picList) {
		        	fastDFSClient.delete_file(picture.getSrc().substring(20));
					mediaFileService.deletePic(picture.getId());
				}
		        List<Media> mediaList = mediaFileService.getMediaByTid(tid);
		        for (Media media : mediaList) {
					fastDFSClient.delete_file(media.getImgsrc().substring(20));
					fastDFSClient.delete_file(media.getVediosrc().substring(20));
					mediaFileService.deleteMedia(media.getId());
				}
		        
		        //删除头像
				String delName =  img.substring(20);
				System.out.println("要删的"+delName);
				fastDFSClient.delete_file(delName);
				 talentService.deleteTalent(id);
			
		}
			return "redirect:/pages/base/"+talent+"Info";
			}

		
		//图片作品删除
		@RequestMapping("/talentImgWorks/delete")
		public String talentImgWorksDelete(String talent,String ids,HttpServletRequest request) throws Exception{
			 FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
			String[] strArr = ids.split(",");
			for (String string : strArr) {
				Integer id = Integer.parseInt(string);
				Picture pic = mediaFileService.getPic(id);
				String delPicName = pic.getSrc().substring(20);
				fastDFSClient.delete_file(delPicName);
				 
				mediaFileService.deletePic(id);
			
		}
			return "redirect:/pages/base/"+talent+"Works";
		}
		
		//视频作品删除
		@RequestMapping("/talentMediaWorks/delete")
		public String talentMediaWorksDelete(String talent,String ids,HttpServletRequest request) throws Exception{
			 FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
			String[] strArr = ids.split(",");
			for (String string : strArr) {
				Integer id = Integer.parseInt(string);
				Media media = mediaFileService.getMedia(id);
				String delPicName = media.getVediosrc().substring(20);
				fastDFSClient.delete_file(delPicName);
				
				String firstImg = media.getImgsrc().substring(20);
				fastDFSClient.delete_file(firstImg);
				 
				mediaFileService.deleteMedia(id);
			
		}
			return "redirect:/pages/base/"+talent+"Works";
		}
}
