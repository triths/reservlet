package com.triths.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triths.entity.TestUser;
import com.triths.util.ApplicationContext;

public class AddPersonJSP extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
	/*	String sid = req.getParameter("Id");
		int id = Integer.parseInt(sid);
		ApplicationContext<UserDao> ac1 = new ApplicationContext<UserDao>();
		UserDao ud = ac1.getBean("userdao");
	*/
		HttpSession session = req.getSession();
		TestUser testuser = (TestUser)session.getAttribute("user");
		if(testuser==null){
			req.getRequestDispatcher("/index/LoginView.html").forward(req, resp);
		}
	
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.print("<body>");
		out.println("<td>当前用户：  </td>");
		out.println("<td>"+testuser.getUsername()+"</td>");
		out.println("<a href='/reservlet/index/Logout'>退出</a>");
		out.println("<hr/>");
		out.println("<form action='AddPerson' method='post'>");
		out.println("<table align='center'>");
		out.println("<tr>");
		out.println("<td>姓名</td>");
		out.println("<td><input type='text' name='name'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>手机</td>");
		out.println("<td><input type='text' name='mobile'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>固话</td>");
		out.println("<td><input type='text' name='telphone'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>邮箱</td>");
		out.println("<td><input type='text' name='email'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>城市</td>");
		out.println("<td><input type='text' name='city'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>生日</td>");
		out.println("<td><input type='text' name='birthday'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><input type='submit' value='提交'></td>");
		out.println("<td><input type='reset' value='重置'></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<hr/>");
		out.println("<center><a href='/reservlet/index/QueryAllJSP'>返回</a></center>");
		out.print("</body>");
		out.println("</html>");
		out.flush();
	}
}