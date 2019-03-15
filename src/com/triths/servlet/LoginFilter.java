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

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpServletRequest request = (HttpServletRequest)req;
		String uri = request.getRequestURI();
		
		List<String> includeUrl = new ArrayList<String>();
		includeUrl.add("/reservlet/index/Code");
		includeUrl.add("/reservlet/index/Login");
		includeUrl.add("/reservlet/index/LoginView.html");
		includeUrl.add("/reservlet/index/UnloginJSP");
		includeUrl.add("/reservlet/index/RegisterView.html");
		includeUrl.add("/reservlet/index/Register");
		includeUrl.add("/reservlet/index/LoginErrorJSP");
		includeUrl.add("/reservlet/index/RegistResultJSP");
		
		if(includeUrl.contains(uri)){//不过滤该地址
			chain.doFilter(req, res);
		}else{
			HttpSession session = request.getSession();
			Boolean flag = (Boolean)session.getAttribute("login");
			if(flag==null||flag==false){
				request.getRequestDispatcher("/index/UnloginJSP").forward(req,res );
			}else{
				chain.doFilter(req, res);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
