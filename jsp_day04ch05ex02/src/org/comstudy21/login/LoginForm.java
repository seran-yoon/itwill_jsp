package org.comstudy21.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//한글패치
		resp.setContentType("text/html; charset=UTF-8");
		
		//화면에 출력을 하기 위해 PrintWriter을 선언해줌
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("userID");
		String pw = req.getParameter("passwd");
		String[] checkValues = req.getParameterValues("checkValue");
		
		out.println("<html> <body>");
		out.println("userID : " + id + "<br>");
		out.println("password : " + pw + "<br>");
		for(int i=0;i<checkValues.length;i++){
			out.println("관심분야는 " + checkValues[i] + "<br>");
		}
		out.println("</body> </html>");
		out.close(); //out을 다 사용했으면 종료
		
		//parameter값이 무엇이 있는지 확인하는 코드
		Enumeration enu = req.getParameterNames();
		
		while(enu.hasMoreElements()){
			String name = (String)enu.nextElement();
			String value = req.getParameter(name);

			System.out.println("name값은" + name + "value값은 " + value + "<br>");
			
//			String key = enu.nextElement();
//			
//			System.out.println("key" + key + );
		}
		
	}

}
