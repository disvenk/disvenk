package com.yepao.weixin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.TalentGroupByOccu;
import com.yepao.pojo.WeddingTalent;
import com.yepao.service.TalentService;

@Controller
@RequestMapping("/talent")
public class WxTalentController {
	@Autowired
	private TalentService talentService;
	
	//查询人才
	@RequestMapping("/talentList")
	@ResponseBody
	public List<TalentGroupByOccu> getWeddingTalent(Long hotelId,String reservedDateString){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date reservedDate = null;
		try {
			reservedDate = sdf.parse(reservedDateString);
		} catch (ParseException e) {
			return null;
		}
		List<TalentGroupByOccu> list = talentService.getWeddingTalentList(hotelId,reservedDate);
		return list;
	}
	
	/**
	 * 获得人才详情
	 * @param talentId 人才id
	 * @return 人才详情
	 */
	@RequestMapping("/talentDetail")
	@ResponseBody
	public Map<String,Object> getTalentDetail(Long talentId,String reservedDateString){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date reservedDate = null;
		try {
			reservedDate = sdf.parse(reservedDateString);
		} catch (ParseException e) {
			return null;
		}
		Map<String,Object> talentMap = talentService.getWeddingTalentDetail(talentId,reservedDate);
		return talentMap;
	}
	
	//对比人才列表
	@RequestMapping("/compareTalentList")
	@ResponseBody
	public List<WeddingTalent> getTalentListByOccupation(Long talentId,String reservedDateString){
		String orderByClause = "price"+" desc";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date reservedDate = null;
		try {
			reservedDate = sdf.parse(reservedDateString);
		} catch (ParseException e) {
			return null;
		}
		List<WeddingTalent> list = talentService.getTalentListByOccupation(talentId,orderByClause,reservedDate);
		return list;
	}
}
