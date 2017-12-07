package com.yepao.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.AppointmentMapper;
import com.yepao.mapper.AppointmentPayedMapper;
import com.yepao.mapper.ChineseCalendarMapper;
import com.yepao.pojo.Appointment;
import com.yepao.pojo.AppointmentExample;
import com.yepao.pojo.AppointmentPayed;
import com.yepao.pojo.AppointmentPayedExample;
import com.yepao.pojo.ChineseCalendar;
import com.yepao.pojo.ChineseCalendarExample;
import com.yepao.pojo.ChineseCalendarExample.Criteria;
import com.yepao.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService {
	
	@Autowired
	private ChineseCalendarMapper cCalendarMapper;
	
	@Autowired
	private AppointmentPayedMapper appointmentPayedMapper;
	
	private final String ALL_BAD = "诸事不宜";
	private final String GOOD_MARRIAGE = "嫁娶";
	private final String STATUS = "有效";
	
	/**
	 * 获得日历，并携带是否被预定
	 */
	public List<ChineseCalendar> getReservedCalList(String year,String month,Long hallId) {
		System.out.println("hallId:"+hallId);
		System.out.println("year:"+year);
		System.out.println("month:"+month);
		ChineseCalendarExample example = new ChineseCalendarExample();
		Criteria criteria = example.createCriteria();
		criteria.andYearEqualTo(Integer.valueOf(year));
		criteria.andMonthEqualTo(Integer.valueOf(month));
		List<ChineseCalendar> list = cCalendarMapper.selectByExample(example);
		for(ChineseCalendar r:list) {
			addGoodFlag(r);
			addReservedFlag(r,hallId);
		}
		return list;
	}
	
	//判断是否是吉日
	private void addGoodFlag(ChineseCalendar chineseCalendar) {
		String ji = chineseCalendar.getJi();
		String yi = chineseCalendar.getYi();
		if(ALL_BAD.equals(ji))
			chineseCalendar.setGoodFlag(false);
		else {
			if(yi.indexOf(GOOD_MARRIAGE)>0)
				chineseCalendar.setGoodFlag(true);
			else
				chineseCalendar.setGoodFlag(false);
		}
	}
	
	//判断日子是否被预定
	private void addReservedFlag(ChineseCalendar chineseCalendar,Long hallId) {
		Integer year = chineseCalendar.getYear();
		Integer month = chineseCalendar.getMonth();
		Integer day = chineseCalendar.getDay();
		String dateString = year+"-"+month+"-"+day;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = sdf.parse(dateString);
			AppointmentPayedExample example = new AppointmentPayedExample();
			com.yepao.pojo.AppointmentPayedExample.Criteria criteria = example.createCriteria();
			criteria.andTimeEqualTo(date);
			criteria.andStatusEqualTo(STATUS);
			criteria.andHallIdEqualTo(hallId);
			List<AppointmentPayed> list = appointmentPayedMapper.selectByExample(example);
			if(list.isEmpty())
				chineseCalendar.setReservedFlag(false);
			else
				chineseCalendar.setReservedFlag(true);
		} catch (ParseException e) {
			e.printStackTrace();
			chineseCalendar.setReservedFlag(false);
		}  
	}
	
	
	
	

}
