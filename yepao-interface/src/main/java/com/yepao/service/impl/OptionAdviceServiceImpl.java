package com.yepao.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.OptionAdviceMapper;
import com.yepao.pojo.OptionAdvice;
import com.yepao.service.OptionAdviceService;

@Service
public class OptionAdviceServiceImpl implements OptionAdviceService {

	@Autowired
	private OptionAdviceMapper opadMapper;
	
	//提交意见建议
	public boolean submitOptionAdvice(OptionAdvice opad) {
		String weixinName = opad.getWeixinName();
		if(weixinName.length()<3)
			weixinName = weixinName.substring(0,1)+"**";
		else
			weixinName = weixinName.substring(0,1)+"**"+weixinName.substring(weixinName.length()-1);
		opad.setWeixinName(weixinName);
		opad.setSubmitDate(new Date());
		int result = opadMapper.insert(opad);
		if(result==-1)
			return false;
		else
			return true;
	}

}
