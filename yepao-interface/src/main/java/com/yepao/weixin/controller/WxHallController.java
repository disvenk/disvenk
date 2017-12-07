package com.yepao.weixin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.Appointment;
import com.yepao.pojo.BanquetHall;
import com.yepao.service.AppointmentUnPayService;
import com.yepao.service.HallService;
import com.yepao.utils.YePaoResult;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/hall")
public class WxHallController {
	@Autowired
	private HallService hallService;
	@Autowired
	private AppointmentUnPayService appointmentUnPayService;
	
	/**
	 * 获得宴会厅列表
	 * @return 宴会厅列表
	 */
	@RequestMapping("/hallList")
	@ResponseBody
	public List<BanquetHall> getHallList(Long hotelId){
		List<BanquetHall> list = hallService.getHallList(hotelId);
		return list;
	}
	
	/**
	 * 获得宴会厅详情
	 * @param hallId 宴会厅id
	 * @return 宴会厅详情
	 */
	@RequestMapping("/hallDetail")
	@ResponseBody
	public BanquetHall getHallDetail(Long hallId){
		BanquetHall hall = hallService.getBanquetHall(hallId);
		return hall;
	}
	
	/**
	 * 宴会厅预约看场
	 * @param hallId 宴会厅id
	 * @return 通知对象
	 */
	@RequestMapping("/appointmentUnPay")
	@ResponseBody
	public YePaoResult addAppointment(Appointment appointment,String aPPtime){
		YePaoResult result = appointmentUnPayService.addAppointmentUnPay(appointment, aPPtime);
		return result;
	}
 }
