package com.yepao.service;

import java.util.List;

import com.yepao.pojo.AppointmentPayed;

public interface AppointmentPayService {
  public List<AppointmentPayed> getAppointmentPay(Long hotelId);
  public void addAppointmentPay(Long out_trade_no,Long hotelId, Long hallId,String hallName,
			String customerName,String tel,String reservedDate);
}
