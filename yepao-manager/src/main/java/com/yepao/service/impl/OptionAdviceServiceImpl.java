package com.yepao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.AppointmentMapper;
import com.yepao.mapper.CelebrationCommentMapper;
import com.yepao.mapper.OptionAdviceMapper;
import com.yepao.pojo.Appointment;
import com.yepao.pojo.AppointmentExample;
import com.yepao.pojo.CelebrationComment;
import com.yepao.pojo.CelebrationCommentExample;
import com.yepao.pojo.OptionAdvice;
import com.yepao.pojo.OptionAdviceExample;
import com.yepao.service.AppointmentService;
import com.yepao.service.OptionAdviceService;
import com.yepao.utils.FastDFSClient;

@Service
public class OptionAdviceServiceImpl implements OptionAdviceService {
	@Autowired
	private OptionAdviceMapper OptionAdviceMapper;
	
	public List<OptionAdvice> getOptionAdviceList() {
		OptionAdviceExample example = new OptionAdviceExample();
		List<OptionAdvice> list = OptionAdviceMapper.selectByExample(example);
		return list;
	}

	public void deleteOptionAdvice(String ids) {
		String[] Tids = ids.split(",");
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
			for (String string : Tids) {
				Long id = Long.parseLong(string);
				OptionAdviceMapper.deleteByPrimaryKey(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
