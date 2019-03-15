package com.triths.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PersonAttributeFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String mobile = req.getParameter("mobile");
		String telphone = req.getParameter("telphone");
		String email = req.getParameter("email");
		String birthday = req.getParameter("birthday");
		List<String> msgs = new ArrayList<String>();
		
		
		if(name==""){
			msgs.add("请填写用户名");
		}
		if(mobile==""){
			msgs.add("请填写手机号");
		}
		if(mobile!=null){
			if(mobile.length()!=11){
				msgs.add("请填写手机号不为11位");
			}
		}
		if(telphone!=null){
			if(checkValidity(telphone,"^[0][0-9]{2,3}-[0-9]{5,10}$")){
				System.out.println(telphone);
				msgs.add("固定电话不满足格式___-_______");
			}
		}
		if(email!=null){
			if(checkValidity(email,"\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}")){
				System.out.println(email);
				msgs.add("邮箱不满足格式%@%.%");
			}
		}
		
		if(birthday!=null){
			
			if(checkValidity(birthday,"^[1][0-9]{3}-[0-9]{2}-[0-9]{2}$")){
				System.out.println(birthday);
				msgs.add("生日不满足格式____-__-__");
			}
		}
		if(msgs.isEmpty()){
			chain.doFilter(req, res);
		}else{
			req.setAttribute("msgs", msgs);
			req.getRequestDispatcher("/index/PersonErrorJSP").forward(req,res );
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	public static boolean checkValidity(String str, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		if (m.matches()) {
			return false;
		} else {
			return true;
		}
	}

}