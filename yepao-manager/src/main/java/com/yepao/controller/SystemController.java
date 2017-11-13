package com.yepao.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yepao.pojo.Admin;
import com.yepao.pojo.Menu;
import com.yepao.pojo.User;
import com.yepao.service.AdminService;
import com.yepao.utils.YePaoResult;

@Controller
public class SystemController {

	@Autowired
	private AdminService adminService;
	
	//login
	@RequestMapping("/login")
	@ResponseBody
	public YePaoResult login(User user,String validateCode,String remeber,
			HttpServletRequest request,HttpServletResponse response){
		// 用户名和密码 都保存在model中
				// 基于shiro实现登录
				//subject 指的就是用户对象
				Subject subject = SecurityUtils.getSubject();
				String validateKey= (String) request.getSession().getAttribute("key");
				if(!validateCode.equalsIgnoreCase(validateKey)){
					request.getSession().removeAttribute("key");
					return YePaoResult.build(400, "验证码错误");
				}
				request.getSession().removeAttribute("key");
				// 用户名和密码信息MD5Util.md5(user.getPwd()
				//authenticationToken是一个认证对象，它用来存储用户登录进来的用户名和密码
				AuthenticationToken token = new UsernamePasswordToken(
						user.getName(), user.getPassword());
				try {
					//当subject调用login方法的时候，subject就会起调用安全管理器，然后安全管理器回去调用realm中的认证专用的方法
					//realm中的认证的方法里面有一个参数就是token,底层就把这个token传了过去
					subject.login(token);
					//得到当前的用户
					User user2 = (User) subject.getPrincipal();
					Cookie cookie1 = new Cookie("userId", user2.getId().toString());
					cookie1.setMaxAge(1800);
					response.addCookie(cookie1);
					// 登录成功
					// 将用户信息 保存到 Session
					//将用户名保存到cookie
					if(remeber!=null){
						Cookie cookie2 = new Cookie("username", user.getName());
						cookie2.setMaxAge(1800);
						response.addCookie(cookie2);
					}
					
					
					return YePaoResult.ok();
				} catch (AuthenticationException e) {
					// 登录失败
					e.printStackTrace();
					
					return YePaoResult.build(400, "用户名或密码错误");
				}
	}
	
	//logout
	@RequestMapping("/logout")
	public String logout() {
		// 基于shiro完成退出
		//整个登录认证的过程都是基于subject类完成的，
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/";
	}
	
	//管理员修改密码
	@RequestMapping("/editorPass")
	@ResponseBody
	public YePaoResult editorPass(String newPass,String userId){
		Integer id = Integer.parseInt(userId);
		System.out.println("当前用户的ID是："+id);
		adminService.updatePass(newPass, id);
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return YePaoResult.ok();
	}
	
	
	//超级管理员具有权限管理菜单
	@RequestMapping("/data/admin")
	@ResponseBody
	public Object getAdmin(){
		// 调用业务层，查询当前用户具有菜单 列表
			Subject subject = SecurityUtils.getSubject();
				//得到当前的用户
			User user = (User) subject.getPrincipal();
			if(user.getName().equals("admin")){
				List<Admin> list = adminService.getAdmin();
				return list;
			}
		
		return null;
	}
	
	//查询当前用户具有的菜单
	@RequestMapping("/data/menu")
	@ResponseBody
	public Object getmenu(){
		// 调用业务层，查询当前用户具有菜单 列表
				Subject subject = SecurityUtils.getSubject();
						//得到当前的用户
				User user = (User) subject.getPrincipal();
				if(user.getName().equals("admin")){
					List<Menu> list = adminService.getMenuAll();
					return list;
				}
		List<Menu> list = adminService.getMenu(user.getName());
		return list;
	}
}
