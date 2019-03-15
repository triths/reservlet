package com.triths.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triths.entity.TestUser;

public class RegistResultJSP  extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		TestUser user = (TestUser) req.getAttribute("user");

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.print("<body>");
		out.println("<table align='center'>");
		if (user == null) {
			out.println("<tr>");
			out.println("<td>该用户名已存在，请重新注册</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<hr/>");
			out.println("<center><a href='/reservlet/index/RegisterView.html'>重新注册</a></center>");
		} else {
			out.println("<tr>");
			out.println("<td>注册成功</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>用户名</td>");
			out.println("<td>"+user.getUsername()+"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>密码</td>");
			out.println("<td>"+user.getPassword()+"</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<hr/>");
			out.println("<center><a href='/reservlet/index/LoginView.html'>前往登录</a></center>");
		}
		out.print("</body>");
		out.println("</html>");
		out.flush();
	}

}
