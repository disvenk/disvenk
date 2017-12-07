package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Hotel;
import com.yepao.pojo.HotelA;

public interface HotelService {
	public Hotel getHotel(Long hotelId);
	public List<Hotel> getHotelList();
	public void saveHotel(Hotel hotel);
	public void updateHotel(HotelA hotelA,Hotel hotel);
	public void deleteHotel(Long hotelId);
}
