package com.yepao.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.AppointmentMapper;
import com.yepao.mapper.BanquetHallMapper;
import com.yepao.pojo.Appointment;
import com.yepao.service.AppointmentUnPayService;
import com.yepao.utils.YePaoResult;

@Service
public class AppointmentUnPayServiceImpl implements AppointmentUnPayService {

	@Autowired
	private AppointmentMapper appointmentMapper;
	@Autowired
	private BanquetHallMapper banquetHallMapper;
	
	//添加预约看场
	public YePaoResult addAppointmentUnPay(Appointment appointment,String time) {
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			appointment.setTime(sDateFormat.parse(time));
			appointment.setStatus("有效");
			appointment.setCreated(new Date());
			appointmentMapper.insert(appointment);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return YePaoResult.ok();
	}

}
