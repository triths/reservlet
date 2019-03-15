package com.triths.dao;

import com.triths.entity.TestUser;
import com.triths.rowmapper.TestUserRowmapper;
import com.triths.util.JDBCTemplate;

public class TestUserDaoIm implements TestUserDao {

	private static final String INSERT_SQL = "insert into test_user(username, password) values(?, ?)";
	private static final String SELECT_BY_NAME = "select * from test_user where username = ?";
	private static final String SELECT_USER_USERNAMEANDPWD = "select * from test_user where username=? and password=?";
	JDBCTemplate<TestUser> jt = new JDBCTemplate<TestUser>();
	@Override
	public void addUser(TestUser user) {
		// TODO Auto-generated method stub
		jt.update(INSERT_SQL, user.getUsername(), user.getPassword());
		
	}

	@Override
	public TestUser selectByName(String username) {
		// TODO Auto-generated method stub
		TestUser t = jt.selectOne(SELECT_BY_NAME, new TestUserRowmapper(), username);
		return t;
	}

	@Override
	public TestUser selectByNameAndPwd(TestUser user) {
		// TODO Auto-generated method stub
		TestUser u = jt.selectOne(SELECT_USER_USERNAMEANDPWD, new TestUserRowmapper(), user.getUsername(),user.getPassword());
		return u;
	}

}
