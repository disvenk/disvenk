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

import com.yepao.pojo.Media;
import com.yepao.pojo.Picture;
import com.yepao.service.MediaFileService;
import com.yepao.utils.CutImgUtils;
import com.yepao.utils.FastDFSClient;
import com.yepao.utils.JsonUtils;

@Controller
public class MediaController {
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	@Autowired
	private MediaFileService mediaFileService;

	@RequestMapping(value="/media/upload",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String fileUpload(String token,MultipartFile uploadFile,HttpServletRequest request) {
		System.out.println(token);
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
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				if(cookie.getName().equals(token)){
					String decode = URLDecoder.decode(cookie.getValue(),"utf-8");
					System.out.println(decode);
					String[] idAndName = decode.split(",");
					Integer id = Integer.parseInt(idAndName[0]);
					Media media = new Media();
					media.setTalentId(id);
					media.setTalentName(idAndName[1]);
					media.setVediosrc(url);
					String cutPicture = CutImgUtils.cutPicture(url, request);
					media.setImgsrc(cutPicture);
					media.setUptime(new Date());
					mediaFileService.addMedia(media);
					break;
					
				}
			}
			//5、返回map
			Map result = new HashMap<String,Object>();
			result.put("error", 0);
			result.put("url", url);
			System.out.println("视频上传完成");
			return JsonUtils.objectToJson(result);
		} catch (Exception e) {
			e.printStackTrace();
			//5、返回map
			Map result = new HashMap<String,Object>();
			result.put("error", 1);
			result.put("message", "视频上传失败");
			return JsonUtils.objectToJson(result);
		}
	}
	
	//视频作品查询
	@RequestMapping("/media_pageQuery")
	@ResponseBody
	public List<Media> getImageWorks(Integer id){
		List<Media> mediaWorks = mediaFileService.getMediaWorks(id);
		return mediaWorks;
	}
}
