package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Appointment;

public interface AppointmentService {
	public List<Appointment> getAppointmentList();
	public void addAppointment(Appointment appointment);
	public void update(Appointment appointment);
	public void delete(String ids);
}
