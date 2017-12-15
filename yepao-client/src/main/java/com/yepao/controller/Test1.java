package com.yepao.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.junit.Test;

import com.yepao.utils.FastDFSClient;
import com.yepao.utils.JsonUtils;

public class Test1 {
	@Test
	public void test(){
		String string;
		try {
			string = URLDecoder.decode("主持人", "utf-8");
			System.out.println(string);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
