package org.comstudy21.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginForm extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=euc-kr");
		PrintWriter out = resp.getWriter();
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("userID");
		String pw = req.getParameter("passwd");
		
		Login login = new Login(id, pw);
		
		HttpSession session = req.getSession();
		session.setAttribute("login", login);
		
		out.println("<html><body>");
		out.println("userID는 " + id + "<br>");
		out.println("password는 " + pw + "<br>");
		out.println("총 접속자 수는 " + Login.total);
		out.println("</body></html>");
		
		out.close();
		
	}

}
