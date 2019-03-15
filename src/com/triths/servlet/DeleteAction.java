package com.triths.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triths.service.PersonService;
import com.triths.util.ApplicationContext;

public class DeleteAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		ApplicationContext<PersonService>ac = new ApplicationContext<PersonService>();
		PersonService us = ac.getBean("personservice");
		
		if(us.deleteById(Integer.parseInt( req.getParameter("id")))){
			req.getRequestDispatcher("/index/QueryAllJSP").forward(req, resp);
		}else{
			req.getRequestDispatcher("/index/fauls.html").forward(req, resp);
		}
	}
}
