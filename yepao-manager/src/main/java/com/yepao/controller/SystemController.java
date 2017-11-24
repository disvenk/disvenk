package com.yepao.controller;

import java.io.File;
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
import com.yepao.pojo.Hotel;
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
						user.getUsername(), user.getPassword());
				try {
					//当subject调用login方法的时候，subject就会起调用安全管理器，然后安全管理器回去调用realm中的认证专用的方法
					//realm中的认证的方法里面有一个参数就是token,底层就把这个token传了过去
					subject.login(token);
					//得到当前的用户
					User user2 = (User) subject.getPrincipal();
					request.getSession().setAttribute("userName", user2.getUsername());
					Cookie cookie1 = new Cookie("userId", user2.getId().toString());
					Cookie nameCookie = new Cookie("userName", user2.getUsername());
					nameCookie.setMaxAge(1800);
					cookie1.setMaxAge(1800);
					response.addCookie(cookie1);
					response.addCookie(nameCookie);
					// 登录成功
					// 将用户信息 保存到 Session
					//将用户名保存到cookie
					if(remeber!=null){
						Cookie cookie2 = new Cookie("username", user.getUsername());
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
		adminService.updatePass(newPass, id);
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return YePaoResult.ok();
	}
	
	
	//查询当前用户具有的菜单
	@RequestMapping("/data/menu")
	@ResponseBody
	public Object getmenu(){
		// 调用业务层，查询当前用户具有菜单 列表
				Subject subject = SecurityUtils.getSubject();
						//得到当前的用户
				User user = (User) subject.getPrincipal();
				if(user.getUsername().equals("admin")){
					List<Menu> list = adminService.getMenuAll();
					return list;
				}
		List<Menu> list = adminService.getMenu(user.getUsername());
		return list;
	}
	
	//增加角色查询所有的菜单
	@RequestMapping("/menu_list")
	@ResponseBody
	public Object getmenuAll(){
		// 调用业务层，查询所有有菜单 列表
		List<Menu> list = adminService.getMenuAll();
		return list;
	}
	
	//增加用户
	@RequestMapping("/add/user")
	public String addUser(User user){
		adminService.addUser(user);
		return "redirect:/pages/base/userInfo";
	}
	
	//用户名校验
	@RequestMapping("/checkUsername")
	@ResponseBody
	public YePaoResult checkUsername(String username){
		YePaoResult user = adminService.getUser(username);
		return user;
	}
	
	//查询所有用户
	@RequestMapping("/user_list")
	@ResponseBody
	public List<User> getUserList(){
		List<User> userList = adminService.getUserList();
		return userList;
	}
	
	//更改用户
	@RequestMapping("/updateUser")
	public String updateUser(User user){
		List<User> userList = adminService.getUserList();
		return "userInfo";
	}
	
	//删除用户信息
	@RequestMapping("/user/delete")
	public String deleteUser(String ids,HttpServletRequest request){
		adminService.deleteUser(ids);
		return "redirect:/pages/base/userInfo";
		}
	
}
