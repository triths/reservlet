package com.triths.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.triths.entity.Person;
import com.triths.entity.TestUser;
import com.triths.service.PersonService;
import com.triths.util.ApplicationContext;

public class QueryAllJSP extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");
			
			ApplicationContext<PersonService> ac = new ApplicationContext<PersonService>();
			PersonService us = ac.getBean("personservice");
			
			List<Person> list = us.selectAll();
			
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
			out.println("<form action='/reservlet/index/DeleteBySelect' method='post'>");
			out.println("<table table width='80%' border='1' cellspacing='0' cellpadding='0' align='center'>");
			out.println("<tr>");
			out.println("<td>选中</td>");
			out.println("<td>ID</td>");
			out.println("<td>姓名</td>");
			out.println("<td>手机</td>");
			//out.println("<td>固话</td>");
			//out.println("<td>邮箱</td>");
			//out.println("<td>城市</td>");
			out.println("<td>生日</td>");
			out.println("<td>删除</td>");
			out.println("<td>修改</td>");
			out.println("</tr>");
			for (Person user : list) {
				out.println("<tr>");
				out.println("<td> <input type='checkbox' name='users' value='"+user.getId()+"'></td>");
				out.print("<td>"+user.getId()+"</td>");
				out.print("<td><a href='/reservlet/index/PersonDetailJSP?id="+user.getId()+"'>"+user.getName()+"</a></td>");
				out.print("<td>"+user.getMobile()+"</td>");
				out.print("<td>"+user.getBirthday()+"</td>");
				out.println("<td><a href='/reservlet/index/DeletePerson?id="+user.getId()+"'>删除</a></td>");
				out.println("<td><a href='/reservlet/index/UpdatePersonJSP?id="+user.getId()+"'>修改</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<hr/>");
			out.println("<center><input type='submit' name='submint' value='删除选中' ></center><br/>");
			out.println("<center><a href='/reservlet/index/AddPersonJSP'>添加</a></center>");
			out.println("</form>");
			out.print("</body>");
			out.println("</html>");
			out.flush();
	}
}
