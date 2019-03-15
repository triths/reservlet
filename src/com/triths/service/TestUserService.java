
package com.triths.service;

import com.triths.entity.TestUser;

public interface TestUserService {
	boolean login(TestUser user);
	boolean regist(TestUser user);

}
