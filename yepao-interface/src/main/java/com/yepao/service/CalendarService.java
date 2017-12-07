package com.yepao.service;

import java.util.List;

import com.yepao.pojo.ChineseCalendar;

public interface CalendarService {
	public List<ChineseCalendar> getReservedCalList(String year,String month,Long hallId);
}
