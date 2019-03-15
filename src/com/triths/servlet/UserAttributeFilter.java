package com.triths.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserAttributeFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		req.setCharacterEncoding("UTF-8");
        
		String password = req.getParameter("password");
		String username = req.getParameter("username");
		String code = req.getParameter("code");
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpSession session = request.getSession();
		String validationCode = (String)session.getAttribute("validationCode");		
		
		List<String> msgs = new ArrayList<String>();
		
		if(username==""||password==""){
			msgs.add("请填写用户名或密码");
		}else if(password!=null){
			if(password.length()!=6){
				msgs.add("密码长度不为6位");
			}
		}
		if(!validationCode.equals(code)){
			msgs.add("验证码错误");
		}
		if(msgs.isEmpty()){
			chain.doFilter(req, res);
		}else{
			req.setAttribute("msgs", msgs);
			req.getRequestDispatcher("/index/LoginErrorJSP").forward(req,res );
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
