package com.yepao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yepao.pojo.Celebration;
import com.yepao.pojo.CelebrationPicture;
import com.yepao.pojo.Media;
import com.yepao.pojo.Picture;
import com.yepao.pojo.WeddingTalent;
import com.yepao.service.CelebrationService;
import com.yepao.service.MediaFileService;
import com.yepao.utils.FastDFSClient;

@Controller
public class CelebrationController {

	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	@Autowired
	private CelebrationService celebrationService;
	@Autowired
	private MediaFileService mediaFileService;
	
	//查询宴会庆典
	@RequestMapping("/celebration_pageQuery")
	@ResponseBody
	public List<Celebration> getCelebration_pageQuery(Long hotelId){
		List<Celebration> list = celebrationService.getCelebrationList(hotelId);
		return list;
	}
	
	//图片查询
	@RequestMapping("/celeImage_pageQuery")
	@ResponseBody
	public List<CelebrationPicture> getImageWorks(Long id){
		List<CelebrationPicture> imageWorks = mediaFileService.getPicByCid(id);
		return imageWorks;
	}
	
	//增加宴会庆典
	@RequestMapping(value="/celebration/add",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	public String add(Celebration celebration,@RequestParam("uploadFile")MultipartFile[] uploadFile,HttpServletRequest request,
			String[] stageHolographics,String[] welcomes,String[] ceremonys,String[] weddings,String[] deskLights ) {
		List<String> list = new ArrayList<String>();
		for (MultipartFile multipartFile : uploadFile) {
			try {
				//1、取文件的全名和扩展名
				String originalFilename = multipartFile.getOriginalFilename();
				String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
				//2、创建一个FastDFS的客户端
				FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
				//3、执行上传处理并返回一个路径
				String path = fastDFSClient.uploadFile(multipartFile.getBytes(), extName);
				//4、拼接返回的url和ip地址，拼装成完整的url
				String url = IMAGE_SERVER_URL + path;
				list.add(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String imgs = StringUtils.join(list, ",");
		System.out.println(imgs);
		String stageHolographic = StringUtils.join(stageHolographics,",");
		System.out.println(stageHolographic);
		String welcome = StringUtils.join(welcomes,",");
		String ceremony = StringUtils.join(ceremonys,",");
		String wedding = StringUtils.join(weddings,",");
		String deskLight = StringUtils.join(deskLights,",");
		celebration.setImg(imgs);
		celebration.setWelcome(welcome);
		celebration.setCeremony(ceremony);
		celebration.setWeddingplace(wedding);
		celebration.setDesklight(deskLight);
		celebration.setStageHolographic(stageHolographic);
		celebrationService.addCelebration(celebration);
		return "redirect:/pages/base/celebrationInfo";
}
	
	//修改庆典
	@RequestMapping(value="/celebration/update",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	public String upload(Celebration celebration,@RequestParam("uploadFile")MultipartFile[] uploadFile,HttpServletRequest request,
			String[] EstageHolographics,String[] Ewelcomes,String[] Eceremonys,String[] Eweddings,String[] EdeskLights ) {
		List<String> list = new ArrayList<String>();
		String one = uploadFile[0].getOriginalFilename();
		String two = uploadFile[1].getOriginalFilename();
		Celebration celebration2 = celebrationService.getCelebration(celebration.getId());
		if(StringUtils.isNotBlank(one) && StringUtils.isNotBlank(two) && uploadFile!=null){
			
			
				try {
					FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
					String[] image = celebration2.getImg().split(",");
					for (String string : image) {
						String path=string.substring(23);
						fastDFSClient.delete_file(path);
					}
					for (MultipartFile multipartFile : uploadFile) {
					//1、取文件的全名和扩展名
					String originalFilename = multipartFile.getOriginalFilename();
					String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
					//2、创建一个FastDFS的客户端
					
					//3、执行上传处理并返回一个路径
					String path = fastDFSClient.uploadFile(multipartFile.getBytes(), extName);
					//4、拼接返回的url和ip地址，拼装成完整的url
					String url = IMAGE_SERVER_URL + path;
					list.add(url);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			String imgs = StringUtils.join(list, ",");
			String stageHolographic = StringUtils.join(EstageHolographics,",");
			String welcome = StringUtils.join(Ewelcomes,",");
			String ceremony = StringUtils.join(Eceremonys,",");
			String wedding = StringUtils.join(Eweddings,",");
			String deskLight = StringUtils.join(EdeskLights,",");
			celebration.setHotelid(celebration.getHotelid());
			celebration.setImg(imgs);
			celebration.setWelcome(welcome);
			celebration.setCeremony(ceremony);
			celebration.setWeddingplace(wedding);
			celebration.setDesklight(deskLight);
			celebration.setStageHolographic(stageHolographic);
			celebrationService.update(celebration);
		}else{
			
			String stageHolographic = StringUtils.join(EstageHolographics,",");
			String welcome = StringUtils.join(Ewelcomes,",");
			String ceremony = StringUtils.join(Eceremonys,",");
			String wedding = StringUtils.join(Eweddings,",");
			String deskLight = StringUtils.join(EdeskLights,",");
			
			celebration.setHotelid(celebration.getHotelid());
			celebration.setImg(celebration2.getImg());
			celebration.setWelcome(welcome);
			celebration.setCeremony(ceremony);
			celebration.setWeddingplace(wedding);
			celebration.setDesklight(deskLight);
			celebration.setStageHolographic(stageHolographic);
			celebrationService.update(celebration);
		}
		
	
		return "redirect:/pages/base/celebrationInfo";
}
	
	//删除庆典
	@RequestMapping("/celebration/delete")
	public String deleteHotel(String ids,HttpServletRequest request) throws Exception{
		 FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
		String[] strArr = ids.split(",");
		for (String string : strArr) {
			Long id = Long.parseLong(string);
			
	        Celebration celebration = celebrationService.getCelebration(id);
	        String img = celebration.getImg();
	        Long cid = celebration.getId();
	        
	        //查询出picture和media表里的所有关于该人才的图片和视频然后一个一个的删除
	        List<CelebrationPicture> picList = mediaFileService.getPicByCid(cid);
	        for (CelebrationPicture picture : picList) {
	        	fastDFSClient.delete_file(picture.getSrc().substring(22));
				mediaFileService.deleteCelebrationPic(picture.getId());
			}
	        
	        //删除大图
			String[] delName =  img.split(",");
			for (String string2 : delName) {
				fastDFSClient.delete_file(string2.substring(23));
			}
			
			 celebrationService.delete(id);
		
	}
		return "redirect:/pages/base/celebrationInfo";
		}
	
	//图片删除
	@RequestMapping("/celebrationImgWorks/delete")
	public String talentImgWorksDelete(String talent,String ids,HttpServletRequest request) throws Exception{
		 FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
		String[] strArr = ids.split(",");
		for (String string : strArr) {
			Long id = Long.parseLong(string);
			CelebrationPicture celebrationpicture = mediaFileService.getCelebrationPic(id);
			String delPicName = celebrationpicture.getSrc().substring(23);
			fastDFSClient.delete_file(delPicName);
			 
			mediaFileService.deleteCelebrationPic(id);
		
	}
		return "redirect:/pages/base/celebrationImgWorks";
	}
}
