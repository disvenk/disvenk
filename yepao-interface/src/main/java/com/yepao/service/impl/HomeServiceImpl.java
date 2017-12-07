package com.yepao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.BanquetHallMapper;
import com.yepao.mapper.CelebrationMapper;
import com.yepao.mapper.ComboMapper;
import com.yepao.mapper.HotelMapper;
import com.yepao.pojo.BanquetHall;
import com.yepao.pojo.BanquetHallExample;
import com.yepao.pojo.BanquetHallExample.Criteria;
import com.yepao.pojo.Celebration;
import com.yepao.pojo.CelebrationExample;
import com.yepao.pojo.Combo;
import com.yepao.pojo.ComboExample;
import com.yepao.pojo.Hotel;
import com.yepao.pojo.HotelExample;
import com.yepao.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HotelMapper hotelMapper;
	
	@Autowired
	private BanquetHallMapper bHallMapper;
	
	@Autowired
	private ComboMapper comboMapper;
	
	@Autowired
	private CelebrationMapper celebrationMapper;

	public Map<String, Object> toHome(Long hotelId) {
		Map<String, Object> homeResult = new HashMap<String,Object>();
		HotelExample hotelExample = new HotelExample();
		com.yepao.pojo.HotelExample.Criteria homeCriteria = hotelExample.createCriteria();
		homeCriteria.andHotelIdEqualTo(hotelId);
		List<Hotel> hotelList = hotelMapper.selectByExample(hotelExample);
		if(hotelList.size()==0)
			homeResult.put("hotel", null);
		else {
			Hotel hotel = hotelList.get(0);
			homeResult.put("hotel", hotel);
		}
		BanquetHallExample hallExample = new BanquetHallExample();
		com.yepao.pojo.BanquetHallExample.Criteria hallCriteria = hallExample.createCriteria();
		hallCriteria.andHotelidEqualTo(hotelId);
		List<BanquetHall> bHallList = bHallMapper.selectByExample(hallExample);
		homeResult.put("banquetHallList", bHallList);
		ComboExample comboExample = new ComboExample();
		com.yepao.pojo.ComboExample.Criteria comboCriteria = comboExample.createCriteria();
		comboCriteria.andHotelidEqualTo(hotelId);
		List<Combo> comboList =comboMapper.selectByExample(comboExample);
		if(comboList.isEmpty())
			homeResult.put("comboList", null);
		else
			homeResult.put("comboList", comboList);
		CelebrationExample celeExample = new CelebrationExample();
		com.yepao.pojo.CelebrationExample.Criteria celeCriteria = celeExample.createCriteria();
		celeCriteria.andHotelidEqualTo(hotelId);
		List<Celebration> celebrationList =celebrationMapper.selectByExample(celeExample);
		if(celebrationList.isEmpty())
			homeResult.put("celebrationList", null);
		else
			homeResult.put("celebrationList", celebrationList);
		return homeResult;
	}

}
