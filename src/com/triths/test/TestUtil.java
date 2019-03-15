package com.triths.test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.triths.util.JDBCUtil;

public class TestUtil {
	@Test
	public void testConnection(){
		Connection conn = JDBCUtil.getConnection();
		System.out.println(conn);
		JDBCUtil.close(conn, null);
	}
	@Test
	public void test1(){
		List<Animal> list = new ArrayList<Animal>();
		Animal[] a = new Animal[]{};
		for (Animal animal : a) {
			if(animal instanceof Dog){
				list.add(animal);
			}
		}
		Dog[] dogs = list.toArray(new Dog[]{});//   T   Dog
	}
	
	
	@Test
	public void testForm(){
		String email = "^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$";
		String email1 = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
		String tel = "^[0][1-9]{2,3}-[0-9]{5,10}$";
		String birth = "^[1][0-9]{3}-[0-9]{2}-[0-9]{2}$";
		if(checkValidity("12s@qq.com",email1)){
			System.out.println("正确");
		}else{
			System.out.println("错误");
		}
		
		
	}
	
	public static boolean checkValidity(String str, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}
}
class Fish implements Comparable<Fish>{

	@Override
	public int compareTo(Fish o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
class Animal<T>{
	public <T> T getT(){
		return (T)new Dog();
	}
}
class Dog extends Animal{}
class Cat extends Animal{}
