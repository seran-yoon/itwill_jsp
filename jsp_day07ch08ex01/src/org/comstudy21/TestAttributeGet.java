package org.comstudy21;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestAttributeGet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		ServletContext ctx = getServletContext();
		HttpSession sess = req.getSession();
		
		String ctxMesg = (String)ctx.getAttribute("context");
		String sesMesg = (String)sess.getAttribute("session");
		String reqMesg = (String)req.getAttribute("request");
		
		String mesg = "context 값 => " + ctxMesg + " | session 값 => " + sesMesg + " | request 값 => " + req;
		out.println(mesg);
		
	}
	
}
