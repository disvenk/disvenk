package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Appointment;
import com.yepao.pojo.HallComment;
import com.yepao.pojo.OptionAdvice;

public interface OptionAdviceService {
	public List<OptionAdvice> getOptionAdviceList(Long hotelId);
	public void deleteOptionAdvice(String ids);
}
