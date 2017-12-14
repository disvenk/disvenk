package com.yepao.service;

import java.util.List;

import com.yepao.pojo.OrderAlert;
import com.yepao.pojo.Orders;
import com.yepao.utils.YePaoResult;

public interface OrderAlertService {
	//已付全款单
	public List<Orders> getUnCheck();
	//更改已付全款单为已查看
	public YePaoResult editorChecked(String ids);
	//用户不在线时存储离线消息
	public void saveOrderAlert(Long hotelId);
	//登录时查询离线消息
	public YePaoResult getOrderAlert(Long hotelId);
}
