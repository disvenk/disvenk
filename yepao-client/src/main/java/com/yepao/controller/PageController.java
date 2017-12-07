package com.yepao.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.Admin;
import com.yepao.pojo.Menu;
import com.yepao.pojo.User;
import com.yepao.service.AdminService;

@Controller
public class PageController {
	
	@RequestMapping("/")
	public String index(){
		return "redirect:/pages/base/login";
	}
	

	
	@RequestMapping("pages/base/{page}")
	public String showPages(@PathVariable String page){
		//访问登录页面使判断是否已经登录，如果已经登录直接跳转到主界面
		if(page.equals("login")){
			Subject subject = SecurityUtils.getSubject();
			//得到当前的用户
		User user = (User) subject.getPrincipal();
		if(user != null){
			 return "redirect:/pages/base/index";
		}
			return page;
		}
		
		return page;
	}
}
