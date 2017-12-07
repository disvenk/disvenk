package com.yepao.controller;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;  
  
public class Test {  
  
    public static void main(String[] args) throws Exception {  
         testEncode();  
       // testDecode();  
    }  
  
    /** 
     * 生成二维码 
     *  
     * @throws WriterException 
     * @throws IOException 
     */  
    public static void testEncode() throws WriterException, IOException {  
        String filePath = "D://";  
        String fileName = "zxing.png";  
        String content = "测试zxing生成二维码";  
        int width = 300; // 图像宽度  
        int height = 300; // 图像高度  
        String format = "png";// 图像类型  
        HashMap<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();  
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,  
                BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵  
        Path path = FileSystems.getDefault().getPath(filePath, fileName);  
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像  
        System.out.println("输出成功.");  
    } 
}