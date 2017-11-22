package com.yepao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.AdminMapper;
import com.yepao.mapper.MenuMapper;
import com.yepao.mapper.UserMapper;
import com.yepao.pojo.Admin;
import com.yepao.pojo.AdminExample;
import com.yepao.pojo.Menu;
import com.yepao.pojo.MenuExample;
import com.yepao.pojo.User;
import com.yepao.pojo.UserExample;
import com.yepao.pojo.UserExample.Criteria;
import com.yepao.service.AdminService;
import com.yepao.utils.YePaoResult;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private UserMapper userMapper;
	
	public void addUser(User user){
		userMapper.insert(user);
	}
	
	public YePaoResult getUser(String username){
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		if(!list.isEmpty()){
			return YePaoResult.build(400, "","");
		}
		return YePaoResult.ok();
	}
	
	public List<Admin> getAdmin() {
		AdminExample example = new AdminExample();
		List<Admin> list = adminMapper.selectByExample(example);
		return list;
	}

	public List<Menu> getMenu(String userName) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(userName);
		List<User> list1 = userMapper.selectByExample(example);
		String[] memuIds = list1.get(0).getMenu().split(",");
		List<Menu> list = new ArrayList<Menu>();
		for (String string : memuIds) {
			Long id = Long.parseLong(string);
			list.add(menuMapper.selectByPrimaryKey(id));
		}
		
		return list;
	}

	//获取所有的菜单项
	public List<Menu> getMenuAll() {
		MenuExample example = new MenuExample();
		List<Menu> list = menuMapper.selectByExample(example);
		return list;
	}

	//用户修改密码
	public YePaoResult updatePass(String newPass, Integer id) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		//User user = userMapper.selectByPrimaryKey(id);
		User user = new User();
		user.setPassword(newPass);
		
		userMapper.updateByExampleSelective(user, example);
		return YePaoResult.ok();
	}
	
	
	//查询所用用户
	public List<User> getUserList() {
		UserExample example = new UserExample();
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

	//删除用户
	public void deleteUser(String ids) {
		String[] uIds = ids.split(",");
		for (String string : uIds) {
			Integer id = Integer.parseInt(string);
			userMapper.deleteByPrimaryKey(id);
		}
		
	}
	
	
	

}
