package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Admin;
import com.yepao.pojo.Menu;
import com.yepao.pojo.User;
import com.yepao.utils.YePaoResult;

public interface AdminService {
	public void addUser(User user);
	public List<Admin> getAdmin();
	public List<Menu> getMenu(String userName);
	public List<Menu> getMenuAll();
	public YePaoResult updatePass(String newPass,Integer id);
	public YePaoResult getUser(String username);
	
	public List<User> getUserList();
	public void deleteUser(String ids);
}
