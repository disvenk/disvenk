package com.yepao.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	public void addAppointmentPay(Long out_trade_no,Long hotelId, Long hallId,String hallName,
			String customerName,String tel,String reservedDate) {
		AppointmentPayed apPayed = new AppointmentPayed();
		apPayed.setHotelId(hotelId);
		apPayed.setHallId(hallId);
		apPayed.setHallName(hallName);
		apPayed.setCustomer(customerName);
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date parse = sFormat.parse(reservedDate);
		apPayed.setTime(parse);
		apPayed.setTel(tel);
		apPayed.setStatus("有效");
		apPayed.setCreated(new Date());
		appointmentPayedMapper.insert(apPayed);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
