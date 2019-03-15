package com.triths.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triths.entity.TestUser;

public class LoginResultJSP extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		TestUser user = (TestUser)request.getAttribute("user");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.print("<body>");
		out.println("<td>当前用户：  </td>");
		out.println("<td>"+user.getUsername()+"</td>");
		out.println("<a href='/reservlet/index/Logout'>退出</a>");
		out.println("<hr/>");
		out.println("<table align='center'>");
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
		out.println("<center><a href='/reservlet/index/QueryAllJSP'>查看通讯录</a></center>");
		out.print("</body>");
		out.println("</html>");
		out.flush();
	}

}
