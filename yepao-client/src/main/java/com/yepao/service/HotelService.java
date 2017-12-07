package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Hotel;

public interface HotelService {
	public Hotel getHotel(Long hotelId);
	
	public void updateHotel(Hotel hotel);
	
}
