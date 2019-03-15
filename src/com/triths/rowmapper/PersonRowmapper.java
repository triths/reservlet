package com.triths.rowmapper;

import java.sql.ResultSet;
import java.util.Date;

import com.triths.entity.Person;
import com.triths.util.Rowmapper;

public class PersonRowmapper implements Rowmapper<Person>{

	@Override
	public Person mapperRow(ResultSet rs) {
		// TODO Auto-generated method stub
		Person p = null;
		
		try{
			p = new Person();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setMobile(rs.getString(3));
			p.setTelphone(rs.getString(4));
			p.setEmail(rs.getString(5));
			p.setCity(rs.getString(6));
			if(rs.getDate(7)==null){
				p.setBirthday(null);
			}else{
				p.setBirthday(rs.getDate(7).toString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
				
		return p;
	}

}
