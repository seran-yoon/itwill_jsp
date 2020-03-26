package org.comstudy21;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParam extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		
		String name = context.getInitParameter("name"); //contextParameter에서 가져오는거
		System.out.println("Name => " + name);
		
		String url = context.getInitParameter("url"); //servlet에서 가져오는거
		System.out.println("url => " + url);
		
		resp.getWriter()
			.append("<h3>InitParam</h3>")
			.append("<p>url : " + url);
			.append();
			.append();
			.append();
		
	}
	
}
