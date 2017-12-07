package com.yepao.weixin.controller;

import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.service.HomeService;

@Controller
@RequestMapping("/home")
public class WxHomeController {
	
	 private static Logger log = Logger.getLogger(WxHomeController.class);
	 
	@Autowired
	private HomeService homeService;
	
	/**
	 * 进入首页
	 * @param hotelId
	 * @return json对象
	 */
	@RequestMapping("/toHome")
	@ResponseBody
	public Map<String, Object> toHome(String hotelId) {
		log.debug("hotelId:"+hotelId);
		System.out.println("hotelId:"+hotelId);
		Map<String, Object> homeResult = homeService.toHome(Long.valueOf(hotelId));
		return homeResult;
	}
	
	@RequestMapping("/aaa")
	@ResponseBody
	public String aaaHome(HttpServletRequest req) {
		return "111";
	}
	
	 @RequestMapping("/home1")
	    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		 String weixinName = "abcdefg";
		 if(weixinName.length()<3)
			weixinName = weixinName.substring(0,1)+"**";
		 else
			 weixinName = weixinName.substring(0,1)+"**"+weixinName.substring(weixinName.length()-1);
			System.out.println(weixinName);
	        return "hello";
	    }

}
