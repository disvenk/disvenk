package com.yepao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.BanquetHall;
import com.yepao.service.HallService;
import com.yepao.utils.FastDFSClient;
import com.yepao.utils.YePaoResult;

@Controller
public class HallController {

	@Autowired
	private HallService hallService;
	
	@RequestMapping("/hall_pageQuery")
	@ResponseBody
	public List<BanquetHall> getHallList(Long hotelId){
		List<BanquetHall> list = hallService.getHallList(hotelId);
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
	public String deleteHall(String ids){
		String[] hallIds = ids.split(",");
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
			for (String string : hallIds) {
				Long id = Long.parseLong(string);
				BanquetHall banquetHall = hallService.getBanquetHall(id);
				String[] images = banquetHall.getImg().split(",");
				for (String string2 : images) {
					fastDFSClient.delete_file(string2.substring(23));
				}
				hallService.deleteHall(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/pages/base/hall";
	}
}
