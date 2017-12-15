package com.yepao.weixin.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.ChineseCalendar;
import com.yepao.service.CalendarService;

@Controller
@RequestMapping("/calendar")
public class WxCalendarController {
	@Autowired
	private CalendarService calendarService;
	
	@RequestMapping("/reservedCal")
	@ResponseBody
	public List<ChineseCalendar> getReservedCalList(String year,String month,Long hallId){
		/*try {
			year = new String(year.getBytes("iso-8859-1"),"utf-8");
			month = new String(month.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		List<ChineseCalendar> list = calendarService.getReservedCalList(year,month,hallId);
		return list;
	}
	
	@RequestMapping("reservedCal2")
	@ResponseBody
	public Boolean getReservedCal2(String dateString,Long hallId){
		boolean reservedFlag = calendarService.isReservedFlag(dateString, hallId);
		return reservedFlag;
	}
}
