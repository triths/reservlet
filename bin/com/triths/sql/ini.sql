create database triths;

use triths;

create table test_user( 
    username varchar(15) primary key,
    password varchar(6) not null
)default charset=utf8;

insert into test_user(username, password) values('root','123456');

create table person(
	id integer primary key auto_increment,
	name varchar(15) not null,
	mobile varchar(11) not null,
	telphone varchar(13) ,
	email varchar(30) ,
	city varchar(20),
	birthday date
)default charset=utf8;

insert into person(name, mobile, telphone, email, city, birthday ) values('马汉','13849381234','0321-12334445','134@163.com','合肥','1999-03-01');
insert into person(name, mobile, telphone, email, city, birthday ) values('王朝','13849381235','0321-12334345','121@163.com','西安','1994-12-01');
insert into person(name, mobile, telphone, email, city, birthday ) values('张三','13849381236','0321-12333445','135@163.com','郑州','1996-09-01');

