package com.stars.sea.work.utils;

import java.io.*;
import java.util.Base64;

public class FileUtil {
    final static Base64.Decoder decoder = Base64.getDecoder();
    final static Base64.Encoder encoder = Base64.getEncoder();
    public static void main(String[] args) {
        String fileName = "E:\\chromeFile\\赵明的推荐教学计划（2021-07-30）.vbplan";
        String plan = decode(readFile(fileName));
        System.out.println(plan);
    }
    public static String readFile(String filePath)  {
        // 1. .csv文件的路径。注意只有一个\的要改成\\
        File csv = new File(filePath); // CSV文件路径
        BufferedReader br = null;
        // DataInputStream in = new DataInputStream(new FileInputStream(new File("E:\\test\\testcsv.csv")));
        //  BufferedReader br= new BufferedReader(new InputStreamReader(in,"GBK"));
        //  br = new BufferedReader(new FileReader(csv));
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        try {
            StringBuilder allString = new StringBuilder();
            while ((line = br.readLine()) != null) // 读取到的内容给line变量
            {
                everyLine = line;
                // System.out.println(everyLine);
                allString.append(everyLine);
            }

            //System.out.println("csv表格中所有行数：" + allString.size());
            return allString.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //编码
    public static String encode(String str) {
        byte[] textByte = new byte[0];
        try {
            textByte = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //编码
        String encodedText = encoder.encodeToString(textByte);
        //System.out.println("Base64编码：" + encodedText);
        return encodedText;
    }

    //解码
    public static String decode(String encodedText) {
        String str = "";
        try {
            str = new String(decoder.decode(encodedText), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
       // System.out.println(str);
        return str;
    }
}
