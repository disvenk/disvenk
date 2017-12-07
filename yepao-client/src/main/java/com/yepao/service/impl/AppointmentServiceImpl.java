package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.AppointmentMapper;
import com.yepao.pojo.Appointment;
import com.yepao.pojo.AppointmentExample;
import com.yepao.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentMapper appointmentMapper;
	
	//查询所有的预约
	public List<Appointment> getAppointmentList() {
		AppointmentExample example = new AppointmentExample();
		List<Appointment> list = appointmentMapper.selectByExample(example);
		return list;
	}

	//添加预约
	public void addAppointment(Appointment appointment) {
		appointmentMapper.insert(appointment);
	}

	//更改
	public void update(Appointment appointment) {
		appointmentMapper.updateByPrimaryKey(appointment);
	}

	//删除
	public void delete(String ids) {
		String[] aids = ids.split(",");
		for (String string : aids) {
			Long id = Long.parseLong(string);
			appointmentMapper.deleteByPrimaryKey(id);
		}
		
	}
	

	

}
