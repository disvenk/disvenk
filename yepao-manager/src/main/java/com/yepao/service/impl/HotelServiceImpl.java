package com.yepao.service.impl;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.HotelMapper;
import com.yepao.pojo.Hotel;
import com.yepao.pojo.HotelA;
import com.yepao.pojo.HotelExample;
import com.yepao.pojo.HotelExample.Criteria;
import com.yepao.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelMapper hotelMapper;
	
	//查询酒店列表
	public List<Hotel> getHotelList() {
		HotelExample example = new HotelExample();
		List<Hotel> list = hotelMapper.selectByExample(example);
		return list;
	}

	//添加酒店信息
	public void saveHotel(Hotel hotel) {
		 hotelMapper.insert(hotel);
	}

	//更新酒店信息
	public void updateHotel(HotelA hotelA,Hotel hotel) {
		HotelExample example = new HotelExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(hotelA.getId());
		
		hotelMapper.updateByExampleSelective(hotel, example);
		
	}

	//查询酒店
	public Hotel getHotel(Long hotelId) {
		Hotel hotel = hotelMapper.selectByPrimaryKey(hotelId);
		return hotel;
	}

	//删除酒店信息
	public void deleteHotel(Long hotelId) {
	
			hotelMapper.deleteByPrimaryKey(hotelId);
		}
	
	}
	

