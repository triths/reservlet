package com.triths.util;

import java.sql.ResultSet;

public interface Rowmapper<T> {
	//   rs-----T
	T mapperRow(ResultSet rs);
}
