package com.yepao.service.impl;

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
	
	public List<Admin> getAdmin() {
		AdminExample example = new AdminExample();
		List<Admin> list = adminMapper.selectByExample(example);
		return list;
	}

	public List<Menu> getMenu(String userName) {
		MenuExample example = new MenuExample();
		com.yepao.pojo.MenuExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(userName);
		List<Menu> list = menuMapper.selectByExample(example);
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

}
