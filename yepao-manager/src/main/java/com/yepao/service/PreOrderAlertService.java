package com.yepao.service;

import java.util.List;

import com.yepao.pojo.Orders;
import com.yepao.utils.YePaoResult;

public interface PreOrderAlertService {
	//已付定金单
	public List<Orders> getUnCheck();
	//更改已付定金单为已查看
	public YePaoResult editorChecked(String ids);
}
