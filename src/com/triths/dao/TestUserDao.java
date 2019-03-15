package com.triths.dao;

import com.triths.entity.TestUser;

public interface TestUserDao {
	void addUser(TestUser user);
	TestUser selectByName(String username);
	TestUser selectByNameAndPwd(TestUser user);
}
