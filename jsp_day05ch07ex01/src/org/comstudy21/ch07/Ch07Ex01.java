package org.comstudy21.ch07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Ch07Ex01 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget - Ch07Ex01");
		
		resp.setContentType("UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		
		HttpSession session = req.getSession();
		out.println("<p>Session ID : " + session.getId() + "</p>");
		out.println("<p>Creation Time : " + session.getCreationTime() + "</p>");
		out.println("<P>LastAccessed Time : " + session.getLastAccessedTime() + "</p>");
		out.println("<p>MaxInactiveInterval : " + session.getMaxInactiveInterval() + "</p>");
		
		session.setMaxInactiveInterval(30);
		
//		if(session.isNew()){
//			System.out.println("New Session"); //이게 안뜨는 이유! 다른 페이지에서 세션을 만들고 넘어오면 newSession이 아니기 때문에! 우리는 index.jsp에서 세션을 한번 만들고 그 세션에서 링크를 타고 여기로 넘어오기 때문에 newSession이 아닌것
//		}
		
		if(session.isNew()){
			System.out.println("New Session"); //이게 안뜨는 이유! 다른 페이지에서 세션을 만들고 넘어오면 newSession이 아니기 때문에! 우리는 index.jsp에서 세션을 한번 만들고 그 세션에서 링크를 타고 여기로 넘어오기 때문에 newSession이 아닌것
		} else{
			System.out.println("Not New Session"); 
		}
		
		out.println("</body></html>");
		out.close();
		
	}
	
}
