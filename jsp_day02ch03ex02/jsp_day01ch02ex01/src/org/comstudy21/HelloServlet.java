package org.comstudy21;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//do get 함수 내부...
		System.out.println("doget - HelloServlet 호출 ....");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>Hello Servlet</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<h1>Hello Servlet page!</h1>");
		out.println("	</body>");
		out.println("</html>");
		
		out.close();
	}

}
