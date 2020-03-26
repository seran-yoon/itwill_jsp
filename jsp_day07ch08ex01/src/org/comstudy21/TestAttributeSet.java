package org.comstudy21;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestAttributeSet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ctxMesg = "contxt변수";
		String sesMesg = "session변수";
		String reqMesg = "request변수";
		
		ServletContext ctx = getServletContext();
		HttpSession session = req.getSession();
		
		ctx.setAttribute("context", ctxMesg);
		session.setAttribute("session", sesMesg);
		req.setAttribute("request", reqMesg);
		
	}
	
}
