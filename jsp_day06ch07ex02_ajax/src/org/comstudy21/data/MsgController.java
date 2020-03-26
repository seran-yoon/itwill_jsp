package org.comstudy21.data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MsgController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String user = req.getParameter("user");
		String message = req.getParameter("msg");
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("test/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("USER:" + user + "| MSG: " + message);
		out.println("</body></html>");
		out.close();
		
	}
	
}
