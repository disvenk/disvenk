package com.pay.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import com.google.gson.JsonObject;
import com.other.pojo.CelebrationAsistant;
import com.yepao.pojo.Celebration;
import com.yepao.pojo.WeddingTalent;
import com.yepao.utils.JsonUtils;
import com.yepao.utils.TimeUtils;

import net.sf.json.JSONArray;

public class Test {
	public static void main(String[] args){
		String jsonToList = "[{\"itemName\":[{\"id\":1,\"hotelid\":13100738632,\"name\":\"爱情的Tiffany蓝\",\"style\":\"小清新\",\"theme\":\"小清新、奢华、浪漫、个性司仪、化妆师、摄影师、摄像师为你服务\",\"basename\":\"基础套餐\",\"preprice\":15888.00,\"img\":\"\",\"isStage\":null,\"comboStyle\":null,\"comboname\":\"超值LED大屏全鲜花优惠套餐\",\"stagePrice\":10000.00,\"price\":32888.00,\"welcome\":\"\",\"ceremony\":\"\",\"weddingplace\":\"\",\"desklight\":\"\",\"stageHolographic\":\"舞台全息一套\",\"standby\":\"\"}],\"stage\":true,\"comboName\":\"基础套餐\"}]";
		List<CelebrationAsistant> jsonToList2 = JsonUtils.jsonToList(jsonToList, CelebrationAsistant.class);
		CelebrationAsistant celebrationAsistant = jsonToList2.get(0);
		List itemName = celebrationAsistant.getItemName();
		LinkedHashMap<String, Object> ceLinkedHashMap = (LinkedHashMap<String, Object>) itemName.get(0);
		System.out.println(ceLinkedHashMap.get("name"));
	}
}
