package com.triths.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triths.entity.TestUser;
import com.triths.service.TestUserService;
import com.triths.util.ApplicationContext;

public class RegisterAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		ApplicationContext<TestUserService> ac = new ApplicationContext<TestUserService>();
		TestUserService us = ac.getBean("testuserservice");

		TestUser user = new TestUser();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		if (us.regist(user)) {
			request.setAttribute("user", user);
		} else {
			request.setAttribute("user", null);
		}
		request.getRequestDispatcher("/index/RegistResultJSP").forward(request, response);
		
	}
	
}
