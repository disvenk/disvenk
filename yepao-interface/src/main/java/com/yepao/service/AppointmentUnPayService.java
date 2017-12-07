package com.yepao.service;

import com.yepao.pojo.Appointment;
import com.yepao.utils.YePaoResult;

public interface AppointmentUnPayService {
	public YePaoResult addAppointmentUnPay(Appointment appointment,String time);
}
