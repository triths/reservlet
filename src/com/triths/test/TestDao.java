package com.triths.test;
/*package com.baizhi.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import com.baizhi.dao.PersonDaoIm;
import com.baizhi.dao.TestUserDaoIm;
import com.baizhi.dao.UserDao;
import com.baizhi.dao.UserDaoIm;
import com.baizhi.entity.Person;
import com.baizhi.entity.User;
import com.baizhi.entity.TestUser;
import com.baizhi.rowmapper.UserRowmapper;
import com.baizhi.util.ApplicationContext;
import com.baizhi.util.JDBCTemplate;
import com.baizhi.util.JDBCUtil;


public class TestDao {
	private static final String INSERT_INTO_T_USER_ID_NAME_SCORE_BIRTHDAY_VALUES_USER_SEQ_NEXTVAL = "insert into t_user(name,score,birthday,password)values(?,?,?,?)";
	@Test
	
	public void testApplicationContext() throws Exception{
		ApplicationContext<UserDao> ac = new ApplicationContext<UserDao>();
		UserDao userDao = ac.getBean("userdao");
		System.out.println(userDao);
	}
	
	@Test
	public void testInsert(){
		JDBCTemplate jt = new JDBCTemplate();
		jt.update(INSERT_INTO_T_USER_ID_NAME_SCORE_BIRTHDAY_VALUES_USER_SEQ_NEXTVAL,"小黑",66.6,JDBCUtil.dealSqlDate("1990-06-13"),"123456");
	}
	@Test
	public void testDelete(){
		JDBCTemplate jt = new JDBCTemplate();
		jt.update("delete from t_user where id=?",1);
	}
	@Test
	public void testSelectALL(){
		JDBCTemplate<User> jt = new JDBCTemplate<User>();
		List<User> list = jt.selectMuch("select * from t_user",new UserRowmapper());
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void testSelectOne(){
		JDBCTemplate<User> jt = new JDBCTemplate<User>();
		User user = jt.selectOne("select * from t_user where id=?", new UserRowmapper(), 2);
		System.out.println(user);
	}
	
	@Test
	public void testSelectByNameAndPwd(){
		User user = new User();
		user.setName("lisi");
		user.setPassword("123456");
		UserDaoIm ud = new UserDaoIm();
		System.out.println(ud.selectByNameAndPwd(user));
	}
	
	@Test
	public void testUser(){
		User u = new User();
		
		u.setBirthday("");
		u.setScore("89");
		u.setName(null);
		Double dscore = 	(Double)u.getScore();
		if(dscore == 0.0 ){
			System.out.println("score is null");
		}
		
		if(u.getBirthday()==null){
			System.out.println("brithday is null");
		}
		System.out.println(u);
	}
	
	@Test 
	public void TestPerson(){
		PersonDaoIm t = new PersonDaoIm();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = null;
		try {
			utilDate = sdf.parse("1990-09-09");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Person p = new Person(3,"张三", "13849331980","010-12345678", "xx@gmail.com", "郑州",utilDate );
		
		
		Person p1 = new Person(1, "李四", "13849331980","010-12345678", "xx@gmail.com", "郑州",utilDate);
		
		//t.add(p1);
		//t.update(p1);
		
		//t.delete(p);
		
		System.out.println(t.selectById(5));
		
		List<Person> list = t.selectAll();
		for(Person i : list){
			System.out.println(i);
		}
	}
	
	@Test
	public void testTestUser(){
		TestUserDaoIm t = new TestUserDaoIm();
		
		TestUser u1 = new TestUser("王五","123456");
		
		t.addUser(u1);
		System.out.println(t.selectByName("张三"));
	}
	
}
*/