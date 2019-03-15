package com.triths.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triths.service.PersonService;
import com.triths.util.ApplicationContext;

public class DeletBySelectAction extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		//修改为由过滤器实现登录控制
		/*HttpSession session=  req .getSession();
		Boolean flag =(Boolean)session.getAttribute("login");
		if(flag==null||flag==false){
			req.getRequestDispatcher("/index/unlogin.html").forward(req, resp);
		}else{*/
		ApplicationContext<PersonService>ac = new ApplicationContext<PersonService>();
		PersonService us = ac.getBean("personservice");
		
		String[] id = req.getParameterValues("users");
		if(id.length<1){
			req.getRequestDispatcher("/index/fauls.html").forward(req, resp);
		}else {
			int[] ids = new int[id.length];
			for(int i=0; i<id.length; i++){
				ids[i] = Integer.parseInt(id[i]);
			}
			us.deleteBySelect(ids);
			req.getRequestDispatcher("/index/QueryAllJSP").forward(req, resp);
		}
	}
}
