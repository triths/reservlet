 package com.triths.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triths.entity.Person;
import com.triths.service.PersonService;
import com.triths.util.ApplicationContext;

public class UpdatePersonAction extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		
		ApplicationContext<PersonService>ac = new ApplicationContext<PersonService>();
		PersonService us = ac.getBean("personservice");
		
		Person u = new Person();
		u.setId(Integer.parseInt(req.getParameter("id")));
		u.setName(req.getParameter("name"));
		u.setMobile(req.getParameter("mobile"));
		u.setTelphone(req.getParameter("telphone"));
		u.setEmail(req.getParameter("email"));
		u.setCity(req.getParameter("city"));
		u.setBirthday(req.getParameter("birthday"));
		
		if(us.updatePerson(u)){
			req.getRequestDispatcher("/index/QueryAllJSP").forward(req, resp);
		}else{
			req.getRequestDispatcher("/index/fauls.html").forward(req, resp);
		}
	}
}