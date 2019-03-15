package com.triths.service;

import java.util.List;

import com.triths.entity.Person;

public interface PersonService {
	boolean addPerson(Person person);
	boolean deleteById(int id);
	boolean deleteBySelect(int[] ids);
	boolean updatePerson(Person person);
	List<Person> selectAll();

}
