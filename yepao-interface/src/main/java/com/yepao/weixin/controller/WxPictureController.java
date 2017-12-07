package com.yepao.weixin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.Celebration;
import com.yepao.pojo.PicGroupByDate;
import com.yepao.service.PictureService;

@Controller
@RequestMapping("/picture")
public class WxPictureController {

	@Autowired
	private PictureService pictureService;
	
	//图片作品查询
	@RequestMapping("/getTalentPictures")
	@ResponseBody
	public List<PicGroupByDate> getTalentPictures(Integer talentId){
		List<PicGroupByDate> picGroupByDateList = pictureService.getTalentPicturesByTalentId(talentId);
		return picGroupByDateList;
	}
}
