package com.yepao.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.AppointmentPayed;

@Controller
public class HallAppointmentController {

	@RequestMapping("/hallAppointment")
	@ResponseBody
	public List<AppointmentPayed> getAppointmentPay(Long hotelId){
		return null;
	}
}
