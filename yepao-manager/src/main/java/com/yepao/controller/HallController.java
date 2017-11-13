package com.yepao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.BanquetHall;
import com.yepao.service.HallService;
import com.yepao.utils.YePaoResult;

@Controller
public class HallController {

	@Autowired
	private HallService hallService;
	
	@RequestMapping("/hall_pageQuery")
	@ResponseBody
	public List<BanquetHall> getHallList(){
		List<BanquetHall> list = hallService.getHallList();
		return list;
	}
	
	//增加宴会大厅
	@RequestMapping("/add/hall")
	@ResponseBody
	public YePaoResult addHall(BanquetHall banquetHall){
		YePaoResult result = hallService.addHall(banquetHall);
		return result;
	}
	
	//删除宴会大厅
	@RequestMapping("/hall/delete")
	public String deleteHall(){
		
		return null;
	}
}
