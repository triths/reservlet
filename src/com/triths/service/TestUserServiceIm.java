package com.triths.service;

import com.triths.dao.TestUserDao;
import com.triths.entity.TestUser;
import com.triths.util.ApplicationContext;
import com.triths.util.TransactionManager;

public class TestUserServiceIm implements TestUserService {

	ApplicationContext<TestUserDao> ac = new ApplicationContext<TestUserDao>();
	TestUserDao ud = ac.getBean("testuserdao");
	@Override
	public boolean login(TestUser user) {
		// TODO Auto-generated method stub
		TransactionManager.begin();
		TestUser u = null;
		try {
			u = ud.selectByNameAndPwd(user);
			TransactionManager.commit();
			if (u != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			TransactionManager.rollback();
			return false;
		}
	}

	@Override
	public boolean regist(TestUser user) {
		// TODO Auto-generated method stub
		TransactionManager.begin();
		try {
			if (ud.selectByName(user.getUsername()) == null) {
				ud.addUser(user);
				TransactionManager.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			TransactionManager.rollback();
			return false;
		}
	}

}
