package com.triths.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.triths.entity.TestUser;

public class UnloginJSP  extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.print("<body>");
		out.println("<table align='center'>");
		out.println("<tr>");
		out.println("<td>您尚未登录</td>");
		out.println("<td>请先登录或注册</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<hr/>");
		out.println("<center><a href='/reservlet/index/LoginView.html'>前往</a></center>");
		out.print("</body>");
		out.println("</html>");
		out.flush();
	}

}
