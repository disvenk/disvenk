package com.yepao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yepao.mapper.AdminMapper;
import com.yepao.mapper.ClientmenuMapper;
import com.yepao.mapper.MenuMapper;
import com.yepao.mapper.UserMapper;
import com.yepao.pojo.Admin;
import com.yepao.pojo.AdminExample;
import com.yepao.pojo.Clientmenu;
import com.yepao.pojo.ClientmenuExample;
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
	private ClientmenuMapper clientmenuMapper;

	//获取所有的菜单项
	public List<Clientmenu> getMenuAll() {
		ClientmenuExample example = new ClientmenuExample();
		List<Clientmenu> list = clientmenuMapper.selectByExample(example);
		return list;
	}

	/*//用户修改密码
	public YePaoResult updatePass(String newPass, Integer id) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		//User user = userMapper.selectByPrimaryKey(id);
		User user = new User();
		user.setPassword(newPass);
		
		userMapper.updateByExampleSelective(user, example);
		return YePaoResult.ok();
	}*/
	
	
	/*//查询所用用户
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
		
	}*/
	
	
	

}
