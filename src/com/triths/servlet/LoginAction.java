package com.triths.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triths.entity.TestUser;
import com.triths.service.TestUserService;
import com.triths.util.ApplicationContext;

public class LoginAction extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		String validationCode = (String)session.getAttribute("validationCode");
		
		ApplicationContext<TestUserService> ac = new ApplicationContext<TestUserService>();
		TestUserService us = ac.getBean("testuserservice");
	
		TestUser user = new TestUser();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		

		if(code.equals(validationCode)&&us.login(user)){
			session.setAttribute("login",true );
			session.setAttribute("user", user);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/index/LoginResultJSP").forward(request, response);
		}else{
			request.getRequestDispatcher("/index/LoginView.html").forward(request, response);
		}
	}
}

	