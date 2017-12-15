package com.yepao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.AppointmentMapper;
import com.yepao.mapper.BanquetHallMapper;
import com.yepao.pojo.Appointment;
import com.yepao.pojo.BanquetHall;
import com.yepao.service.AppointmentService;
import com.yepao.utils.CommonConstants;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentMapper appointmentMapper;
	
	@Autowired
	private BanquetHallMapper hallMapper;

	public String submitAppointment(Appointment app) {
		try {
			Long hallId = app.getHallId();
			BanquetHall hall = hallMapper.selectByPrimaryKey(hallId);
			Long hotelId = hall.getHotelid();
			String hallName = hall.getName();
			app.setHallName(hallName);
			app.setHotelId(hotelId);
			app.setStatus("有效");
			appointmentMapper.insert(app);
			return CommonConstants.SUCCESS;
		}catch (Exception e){
			return CommonConstants.ERROR;
		}
	}

}
