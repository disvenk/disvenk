package com.yepao.weixin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.CelePicGroupByDate;
import com.yepao.pojo.Celebration;
import com.yepao.service.CelebrationService;

@Controller
@RequestMapping("/celebration")
public class WxCelebrationController {
	@Autowired
	private CelebrationService celebrationService;
	
	//查询宴会庆典
	@RequestMapping("/celebrationList")
	@ResponseBody
	public List<Celebration> getCelebrationList(Long hotelId){
		List<Celebration> list = celebrationService.getCelebrationList(hotelId);
		return list;
	}
	
	/**
	 * 获得宴会厅详情
	 * @param hallId 宴会厅id
	 * @return 宴会厅详情
	 */
	@RequestMapping("/celebrationDetail")
	@ResponseBody
	public Celebration getCelebrationDetail(Long celebrationId){
		Celebration celebration = celebrationService.getCelebration(celebrationId);
		return celebration;
	}
	
	@RequestMapping("/celebrationPicture")
	@ResponseBody
	public List<CelePicGroupByDate> getCelebrationPicture(Long celebrationId){
		List<CelePicGroupByDate> CelePicGroupByDateList = celebrationService.getCelebrationPicture(celebrationId);
		return CelePicGroupByDateList;
	}
}
