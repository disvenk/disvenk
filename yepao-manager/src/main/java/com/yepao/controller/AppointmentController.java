package com.yepao.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.Appointment;
import com.yepao.service.AppointmentService;

@Controller
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	//查询预约
	@RequestMapping("/appointment_pageQuery")
	@ResponseBody
	public List<Appointment> getAppointment(){
		List<Appointment> list = appointmentService.getAppointmentList();
		return list;
	}
	
	//增加预约
	@RequestMapping("/appointment/add")
	public String addAppointment(Appointment appointment,String times){
		try {
			Date time = new SimpleDateFormat("yyyy-MM-dd").parse(times);
			appointment.setTime(time);
			appointment.setCreated(new Date());
			appointment.setStatus("有效");
			appointmentService.addAppointment(appointment);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "redirect:/pages/base/appointmentHall";
	}
	
	//更改
	@RequestMapping("/appointment/update")
	public String updateAppointment(Appointment appointment,String timess){
		try {
			Date time = new SimpleDateFormat("yyyy-MM-dd").parse(timess);
			appointment.setTime(time);
			appointment.setCreated(new Date());
			appointmentService.update(appointment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/pages/base/appointmentHall";
	}
	
	//删除
	@RequestMapping("/appointment/delete")
	public String deleteAppointment(String ids){
		appointmentService.delete(ids);
		return "redirect:/pages/base/appointmentHall";
	}
}
