package com.stars.sea.work.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 
 * 读取propertyies配置文件的
 * @author Administrator
 *
 */
public class PropUtil {
	
	private static Properties props1 = null;
	
	private static Properties props2 = null;
	
	static{
		try {
			props2 = new Properties();
			props2.load(new BufferedReader(new InputStreamReader(PropUtil.class.getClassLoader().getResourceAsStream("global.properties"),"utf-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String type ){
		 	return (String)props1.get(type);
	}
	
	public static String getValue2(String type ) {
		return (String)props2.get(type);
	}

	/**
	 * 如果用key找不到对应配置，使用默认值返回
	 * @param type 配置文件的键
	 * @param defaultValue 默认值
	 * @return 配置值
	 */
	public static String getValue2WithDefault(String type, String defaultValue) {
		String result = (String)props2.get(type);
		if (result == null || "".equals(result) || "null".equals(result)) {
			return defaultValue;
		}
		return result;
	}

	public static String getProValue(String proFileName, String key){
		try {
			Properties props = new Properties();
			props.load(new BufferedReader(new InputStreamReader(PropUtil.class.getClassLoader().getResourceAsStream(proFileName + ".properties"),"utf-8")));
			return (String)props.get(key);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
