package com.triths.dao;

import java.util.List;

import com.triths.entity.Person;
import com.triths.rowmapper.PersonRowmapper;
import com.triths.util.JDBCTemplate;

public class PersonDaoIm implements PersonDao {

	JDBCTemplate<Person> jt = new JDBCTemplate<Person>();
	private static final String INSERT_SQL = "insert into person(name, mobile, telphone, email, city, birthday ) values(?, ?, ?, ?, ?, ?)";
	private static final String SELECTALL = "select * from person";
	private static final String UPDATE_SQL = "update person set name=?,mobile=?, telphone=?, email=?, city=?, birthday=? where id=?";
	private static final String DELETE_BYID = "delete from person where id=?";
	private static final String SELECT_BY_NAME = "select * from person where name = ?";
	private static final String SELECT_BY_ID = "select * from person where id = ?";
	
	@Override
	public void add(Person person) {
		jt.update(INSERT_SQL, person.getName(), person.getMobile(), person.getTelphone(), person.getEmail(), person.getCity(), person.getBirthday());
	}

	@Override
	public void delete(Person person) {
		// TODO Auto-generated method stub
		jt.update(DELETE_BYID, person.getId());
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		jt.update(UPDATE_SQL, person.getName(), person.getMobile(), person.getTelphone(), person.getEmail(), person.getCity(), person.getBirthday(), person.getId());
	}

	@Override
	public Person selectByName(Person person) {
		// TODO Auto-generated method stub
		Person p = jt.selectOne(SELECT_BY_NAME, new PersonRowmapper(), person.getName());
		return p;
	}

	@Override
	public Person selectById(int id) {
		// TODO Auto-generated method stub
		Person p = jt.selectOne(SELECT_BY_ID, new PersonRowmapper(), id);
		return p;
	}

	@Override
	public List<Person> selectAll() {
		// TODO Auto-generated method stub
		List<Person> list = jt.selectMuch(SELECTALL, new PersonRowmapper());
		return list;
	}

}
