package com.triths.service;

import java.util.List;

import com.triths.dao.PersonDao;
import com.triths.entity.Person;
import com.triths.util.ApplicationContext;
import com.triths.util.TransactionManager;

public class PersonServiceIm implements PersonService{
	
	ApplicationContext<PersonDao> ac = new ApplicationContext<PersonDao>();
	PersonDao pd = ac.getBean("persondao");
	@Override
	
	public boolean addPerson(Person person) {
		// TODO Auto-generated method stub
		TransactionManager.begin();
		if (person.getName()== "") {
			return false;
		}else if(pd.selectByName(person)==null) {
			try{
				pd.add(person);
				TransactionManager.commit();
				return true;
			}catch(Exception e){
				e.printStackTrace();
				TransactionManager.rollback();
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		Person p = pd.selectById(id);
		TransactionManager.begin();
		if (p == null) {
			return false;
		}else{
			try{
				pd.delete(p);
				TransactionManager.commit();
				return true;
			}catch(Exception e){
				e.printStackTrace();
				TransactionManager.rollback();
				return false;
			}
		}
	}

	@Override
	public boolean deleteBySelect(int[] ids) {
		// TODO Auto-generated method stub
		TransactionManager.begin();
		try{
			for(int i : ids){
				/*调用ud的函数才能保证若ids含有不正确id时回滚而不删除其他正确id，
				调用该类中deletebyid则正确一个提交一个回滚失败*/
				pd.delete(pd.selectById(i));
				}
			TransactionManager.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			TransactionManager.rollback();
			return false;
		}
	}

	@Override
	public boolean updatePerson(Person person) {
		// TODO Auto-generated method stub
		TransactionManager.begin();
		if(person==null||pd.selectById(person.getId())==null){
			return false;
		}else{
			try{
				pd.update(person);
				TransactionManager.commit();
				return true;
			}catch(Exception e){
				e.printStackTrace();
				TransactionManager.rollback();
				return false;
			}
		}
	}

	@Override
	public List<Person> selectAll() {
		// TODO Auto-generated method stub
		List<Person> list = null;
		TransactionManager.begin();
		try {
			list = pd.selectAll();
			TransactionManager.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			TransactionManager.rollback();
			return null;
		}
	}

}
