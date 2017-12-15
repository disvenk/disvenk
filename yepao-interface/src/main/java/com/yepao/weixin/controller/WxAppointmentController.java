package com.yepao.weixin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.Appointment;
import com.yepao.service.AppointmentService;
import com.yepao.utils.CommonConstants;

@Controller
@RequestMapping("/appointment")
public class WxAppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@RequestMapping("/submitApp")
	@ResponseBody
	public String submitAppointment(String dateString,Long hallId,String customer,String tel/*,String timepoint*/){
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(dateString);
			Appointment app = new Appointment();
			app.setHallId(hallId);
			app.setCustomer(customer);
			app.setTime(date);
			app.setTel(tel);
			//app.setTimepoint(timepoint);
			app.setCreated(new Date());
			String result = appointmentService.submitAppointment(app);
			return result;
		}catch (ParseException e) {
			e.printStackTrace();
			return CommonConstants.ERROR;
		}  
	}
}
