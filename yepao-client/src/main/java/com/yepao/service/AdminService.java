package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Admin;
import com.yepao.pojo.Clientmenu;
import com.yepao.pojo.Menu;
import com.yepao.pojo.User;
import com.yepao.utils.YePaoResult;

public interface AdminService {
	
	public List<Clientmenu> getMenuAll();

}
