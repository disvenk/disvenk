package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Orders;
import com.yepao.utils.YePaoResult;

public interface OrderAlertService {
	//已付全款单
	public List<Orders> getUnCheck();
	//更改已付全款单为已查看
	public YePaoResult editorChecked(String ids);
}
