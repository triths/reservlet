package com.triths.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ApplicationContext<T> {
	private static Properties p = new Properties();
	
	static{
		InputStream is = ApplicationContext.class.getResourceAsStream("/com/triths/conf/applicationContext.properties");
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*public  T getBean(String str) {
		Object object = null;
		try{                  //   ApplicationContext.class
			Class clazz = Class.forName(p.getProperty(str));
			 object = clazz.newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		return (T)object;
	}*/
	
	public  T getBean(String str) {
		T t = null;
		try{                 
			//ApplicationContext.class
			Class<?> clazz = Class.forName(p.getProperty(str));
			t = (T)clazz.newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		return t;
	}
}
