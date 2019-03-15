package com.triths.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.triths.entity.Person;
import com.triths.entity.TestUser;
import com.triths.service.PersonServiceIm;
import com.triths.service.TestUserService;
import com.triths.service.TestUserServiceIm;

public class TestService {

	/*@Test
	public void testLogin() {
		User user = new User();
		user.setName("lisi");
		user.setPassword("12356");
		UserServiceIm userServiceIm = new UserServiceIm();
		System.out.println(userServiceIm.login(user));

	}

	@Test
	public void testRegist() {
		User user = new User();
		user.setName("zhaohu");
		user.setPassword("12356");
		UserServiceIm userServiceIm = new UserServiceIm();
		System.out.println(userServiceIm.regist(user));
	}

	@Test
	public void testAdd() {

		User user = new User();
		user.setName("Trump");
		//user.setPassword("123456");

		UserServiceIm userServiceIm = new UserServiceIm();
		System.out.println(userServiceIm.addUser(user));
	}

	@Test
	public void testDelete(){
		User user = new User();
		user.setName("john");
		user.setPassword("123456");

		UserServiceIm userServiceIm = new UserServiceIm();
		System.out.println(userServiceIm.deleteById(7));
	}
	
	@Test
	public void testDeleteByIds(){
		User user = new User();
		user.setName("john");
		user.setPassword("123456");
		int[] ids={2,5,1};

		UserServiceIm userServiceIm = new UserServiceIm();
		System.out.println(userServiceIm.deleteBySelect(ids));
	}
	@Test
	public void testGetUser(){
		User user = new User();
		user.setName("john");
		user.setPassword("123456");
		int[] ids={2,5,1};

		UserServiceIm userServiceIm = new UserServiceIm();
	}
	*/
	@Test
	public void TestPsersonService(){
		
		PersonServiceIm ps = new PersonServiceIm();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = null;
		try {
			utilDate = sdf.parse("1990-09-09");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Person person = new Person(7,"张三d", "13849331980","010-12345678", "xx@gmail.com", "郑州",utilDate );
		
		if(ps.addPerson(person)){
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
		}
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = null;
		try {
			utilDate = sdf.parse("1990-09-09");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Person person = new Person(7,"张三d", "13849331980","010-12345678", "xx@gmail.com", "郑州",utilDate );
		int[] ids = {7,9,6};
		ps.updatePerson(person);
		
		List<Person> list = ps.selectAll();
		for(Person p : list){
			System.out.println(p);
		}*/
	}
	
	@Test
	public void testTestUserService(){
		TestUserService ts = new TestUserServiceIm();
		
		TestUser user = new TestUser("赵六","123456");
		
		if(ts.login(user)){
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
		}
		
		if(ts.regist(user)){
			System.out.println("注册成功");
		}else{
			System.out.println("注册失败");
		}
	}
	
}
