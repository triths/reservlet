package com.triths.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginErrorJSP extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		ArrayList<String> msgs = (ArrayList<String>)req.getAttribute("msgs");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.print("<body>");
		out.println("<table align='center'>");
		for(String s :msgs){
			out.println("<tr>");
			out.println("<td>"+s+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<hr/>");
		out.println("<center><a href='/reservlet/index/LoginView.html'>返回</a></center>");
		out.print("</body>");
		out.println("</html>");
		out.flush();
	}

}
