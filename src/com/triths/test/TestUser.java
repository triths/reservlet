package com.triths.test;
/*package com.baizhi.test;

import java.util.List;
import java.util.Scanner;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.ApplicationContext;

public class TestUser {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("please input your account");
		String name = s.next();
		User user = new User();
		user.setName(name);

		ApplicationContext<UserService> ac = new ApplicationContext<UserService>();
		UserService us = ac.getBean("userservice");
		boolean b = us.login(user);
		if(b){
			List<User> selectAll2 = us.selectAll();
			for (User user2 : selectAll2) {
				System.out.println(user2);
			}
		}else{
			System.out.println("UserName or PassWord is WRONG");
		}
	}
	
}
*/