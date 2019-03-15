package com.triths.dao;

import java.util.List;

import com.triths.entity.Person;

public interface PersonDao {
	void add(Person person);
	void delete(Person person);
	void update(Person person);
	Person selectByName(Person person);
	Person selectById(int id);
	List<Person> selectAll();
}
