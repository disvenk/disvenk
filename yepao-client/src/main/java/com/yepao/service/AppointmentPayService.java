package com.yepao.service;

import java.util.List;

import com.yepao.pojo.AppointmentPayed;

public interface AppointmentPayService {
  public List<AppointmentPayed> getAppointmentPay(Long hotelId);
  public void addAppointmentPay(Long hotelId,Long hallId);
}
