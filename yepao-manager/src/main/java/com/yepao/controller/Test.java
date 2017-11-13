package com.yepao.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yepao.utils.FastDFSClient;

/*@Controller
public class Test {

	@RequestMapping("/test")
	public void test(String[] styles){
		String str = StringUtils.join(styles,",");
		System.out.println(str);
	}
}
*/
 
public class Test{
	public static void main(String[] args) throws Exception{
		String string = "http://47.104.19.44/group1/M00/00/00/rB_ZQVoCW1CAczfYAAAT7-0xdqM166_big.png".substring(20);
		System.out.println(string);
		 FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
	        Integer result = fastDFSClient.delete_file(string);
	        System.out.println(result);
	}
}