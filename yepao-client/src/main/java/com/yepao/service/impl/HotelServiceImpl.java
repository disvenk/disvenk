package com.yepao.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.HotelMapper;
import com.yepao.pojo.Hotel;
import com.yepao.pojo.HotelExample;
import com.yepao.pojo.HotelExample.Criteria;
import com.yepao.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelMapper hotelMapper;
	
	//补全酒店信息
	public void updateHotel(Hotel hotel) {
		HotelExample example = new HotelExample();
		Criteria criteria = example.createCriteria();
		criteria.andHotelIdEqualTo(hotel.getHotelId());
		Hotel hotel2 = new Hotel();
		hotel2.setName(hotel.getName());
		hotel2.setAddress(hotel.getAddress());
		hotel2.setDescreption(hotel.getDescreption());
		hotel2.setTel(hotel.getTel());
		hotel2.setImg(hotel.getImg());
		hotel2.setReputationLevel(hotel.getReputationLevel());
		hotel2.setCommentCount(hotel.getCommentCount());
		hotel2.setInsertDate(hotel.getInsertDate());
		hotel2.setInsertDate(getHotel(hotel.getHotelId()).getInsertDate());;
		hotel2.setUpdateDate(new Date());
		hotelMapper.updateByExampleSelective(hotel2, example);
		
	}

	//查询酒店
	public Hotel getHotel(Long hotelId) {
		Hotel hotel = hotelMapper.selectByPrimaryKey(hotelId);
		return hotel;
	}
	
}
	

