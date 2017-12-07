package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.AppointmentPayedMapper;
import com.yepao.pojo.AppointmentPayed;
import com.yepao.pojo.AppointmentPayedExample;
import com.yepao.pojo.AppointmentPayedExample.Criteria;
import com.yepao.service.AppointmentPayService;

@Service
public class AppointmentPayServiceImpl implements AppointmentPayService {

	@Autowired
	private AppointmentPayedMapper appointmentPayedMapper;
	
	@Override
	public List<AppointmentPayed> getAppointmentPay(Long hotelId) {
		AppointmentPayedExample example = new AppointmentPayedExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andHotelIdEqualTo(hotelId);
		List<AppointmentPayed> list = appointmentPayedMapper.selectByExample(example);
		return list;
	}

	//增加
	@Override
	public void addAppointmentPay(Long hotelId, Long hallId) {
		// TODO Auto-generated method stub
		
	}

}
