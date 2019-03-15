package com.triths.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.triths.entity.TestUser;
import com.triths.util.Rowmapper;

public class TestUserRowmapper implements Rowmapper<TestUser> {

	@Override
	public TestUser mapperRow(ResultSet rs) {
		// TODO Auto-generated method stub
		TestUser user = null;
		try {
			user = new TestUser();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
