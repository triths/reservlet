package com.triths.entity;

import java.util.Date;

import com.triths.util.JDBCUtil;

public class Person {
	/*
	id number(7) primary key,
	name varchar2(15) not null,
	mobile varchar2(11) not null unique check( length(mobile)=11 ),
	telphone varchar2(13) check( telphone like '___%-_______%'),
	email varchar2(30) unique check( email like '_%@%_' ),
	city varchar2(20),
	birthday date
	*/
	
	private int id;
	private String name;
	private String mobile;
	private String telphone;
	private String email;
	private String city;
	private Date birthday;
	public Person() {
		super();
	}
	public Person(int id, String name, String mobile, String telphone, String email, String city, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.telphone = telphone;
		this.email = email;
		this.city = city;
		this.birthday = birthday;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		if(birthday==null||birthday==""){//防止空指针（新建对象）、空值（request.getParameter()获取到空值）
			this.birthday=null;
		}else{
			try{
				java.sql.Date dealSqlDate = JDBCUtil.dealSqlDate(birthday);
				this.birthday = dealSqlDate;
			}catch(Exception e){
				e.printStackTrace();
				this.birthday=null;
				System.out.println("生日日期格式错误，已设置为空");
			}
		}
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", mobile=" + mobile + ", telphone=" + telphone + ", email="
				+ email + ", city=" + city + ", birthday=" + birthday + "]";
	}
	
	
	
}
