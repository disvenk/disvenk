package com.yepao.weixin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.MedGroupByDate;
import com.yepao.service.MediaService;

@Controller
@RequestMapping("/media")
public class WxMediaController {
	
	@Autowired
	private MediaService mediaService;
	
	//视频作品查询
	@RequestMapping("/getTalentMedias")
	@ResponseBody
	public List<MedGroupByDate> getTalentMedias(Integer talentId){
		List<MedGroupByDate> medGroupByDateList = mediaService.getTalentMediasByTalentId(talentId);
		return medGroupByDateList;
	}

}
