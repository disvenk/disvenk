package com.yepao.weixin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.other.pojo.PictrueCommentAsistant;
import com.yepao.pojo.Celebration;
import com.yepao.pojo.PicGroupByDate;
import com.yepao.service.PictureService;
import com.yepao.utils.FastDFSClient;
import com.yepao.utils.JsonUtils;

@Controller
@RequestMapping("/picture")
public class WxPictureController {

	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	@Autowired
	private PictureService pictureService;
	
	//图片作品查询
	@RequestMapping("/getTalentPictures")
	@ResponseBody
	public List<PicGroupByDate> getTalentPictures(Integer talentId){
		List<PicGroupByDate> picGroupByDateList = pictureService.getTalentPicturesByTalentId(talentId);
		return picGroupByDateList;
	}
	
	@RequestMapping(value="/upload",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String fileUpload(MultipartFile uploadFile,HttpServletRequest request) {
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
			
			System.out.println("图片上传成功");
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			//5、返回map
			System.out.println("图片上传失败");
			return null;
		}
	}
}
