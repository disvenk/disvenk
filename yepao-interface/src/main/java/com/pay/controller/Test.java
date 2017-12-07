package com.pay.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.yepao.utils.TimeUtils;

public class Test {
	public static void main(String[] args){
		String string = new SimpleDateFormat("yyyy-MM-dd HH:dd:ss").format(TimeUtils.addDay(new Date(), 2));
		System.out.println(string);
	}
}
