package com.yepao.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class CutImgUtils {
	 public static String cutPicture(String upFilePath,HttpServletRequest request) {  
     	// 创建一个List集合来保存从视频中截取图片的命令
 		List<String> cutpic = new ArrayList<String>();
 		String serialName = String.valueOf(System.currentTimeMillis());
 		//File file = new File("C:\\Users\\Administrator\\Desktop\\新建文件夹 (1)\\ffmpeg-20170130-cba4f0e-win64-static\\bin\\ffmpeg.exe");
 		File file = new File("/usr/local/ffmpeg/ffmpeg-20170130-cba4f0e-win64-static/bin/ffmpeg.exe");
 		String path = file.getAbsolutePath();
 		//String path = request.getSession().getServletContext().getRealPath("/WEB-INF/ffmpeg/ffmpeg.exe");
 		//String cutPath = request.getSession().getServletContext().getRealPath("/WEB-INF/cutImg/"+serialName+".jpg");
 		//System.out.println(cutPath);
 		//String upPath = request.getSession().getServletContext().getRealPath("/WEB-INF/hallImg/爱剪辑-我的视频 - 副本 (3).mp4");
 		File file2 = new File("/home/cutImg");
 		String cutPath = file2.getAbsolutePath();
 		cutpic.add(path);
 		cutpic.add("-i");
 		//String file = upPath+"/"+"爱剪辑-我的视频 - 副本 (3).mp4";
 		cutpic.add(upFilePath); // 同上（指定的文件即可以是转换为flv格式之前的文件，也可以是转换的flv文件）
 		cutpic.add("-y");
 		cutpic.add("-f");
 		cutpic.add("image2");
 		cutpic.add("-ss"); // 添加参数＂-ss＂，该参数指定截取的起始时间
 		cutpic.add("1"); // 添加起始时间为第1秒
 		cutpic.add("-t"); // 添加参数＂-t＂，该参数指定持续时间
 		cutpic.add("0.001"); // 添加持续时间为1毫秒
 		cutpic.add("-s"); // 添加参数＂-s＂，该参数指定截取的图片大小
 		cutpic.add("800*280"); // 添加截取的图片大小为800*280
 		cutpic.add(cutPath); // 添加截取的图片的保存路径

 		boolean mark = true;
 		ProcessBuilder builder = new ProcessBuilder();
 		try {
 			builder.command(cutpic);
 			builder.redirectErrorStream(true);
 			// 如果此属性为 true，则任何由通过此对象的 start() 方法启动的后续子进程生成的错误输出都将与标准输出合并，
 			// 因此两者均可使用 Process.getInputStream() 方法读取。这使得关联错误消息和相应的输出变得更容易
 			Process process = builder.start();
 			InputStream std = process.getInputStream();
 			InputStreamReader isr = new InputStreamReader(std);
 			BufferedReader br = new BufferedReader(isr);
 			String line = null;
 			while ((line = br.readLine()) != null)
 				System.out.println(line);
 			process.waitFor();
 			int status = process.waitFor();
 			if (status == 0)
 				System.out.println("截图执行完毕！");
 			else
 				System.out.println("截图执行失败！");
 		} catch (Exception e) {
 			mark = false;
 			System.out.println(e);
 			e.printStackTrace();
 		}
 		return "/cutImg/"+serialName+".jpg";
     }  
   
}
