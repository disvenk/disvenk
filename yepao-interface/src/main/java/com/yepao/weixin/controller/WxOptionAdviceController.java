package com.yepao.weixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.OptionAdvice;
import com.yepao.service.OptionAdviceService;

@Controller
@RequestMapping("/optionAdvice")
public class WxOptionAdviceController {
	
	@Autowired
	private OptionAdviceService optionAdviceService;
	
	/**
	 * 提交意见建议
	 * @param opad 意见实体
	 * @return 结果信息
	 */
	@RequestMapping("/submitOpad")
	@ResponseBody
	public boolean submitOptionAdvice(OptionAdvice opad) {
		boolean result = optionAdviceService.submitOptionAdvice(opad);
		return result;
	}
}
