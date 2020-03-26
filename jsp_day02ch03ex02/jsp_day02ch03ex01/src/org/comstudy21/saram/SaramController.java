package org.comstudy21.saram;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.saram.dao.SaramDao;
import org.comstudy21.saram.dto.SaramDto;
import org.comstudy21.util.JdbcUtil;

public class SaramController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget - SaramController");
		
//		req.setAttribute("name", "Yoon-seran");
//		String[] names = { "KIM","LEE","PARK" };
//		req.setAttribute("names", names);

		resp.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = resp.getWriter();
		
		SaramDao dao = new SaramDao(JdbcUtil.getConnection());
		SaramDto[] arr = dao.selectAll();
		req.setAttribute("selectAll", arr);
		/*out.print("<html><body>");
		out.print("<table border=1<tr>");
		out.print("<td>ID</td><td>NAME</td><td>AGE</td></tr>");*/
		
		/*for(int i=0;i<arr.length;i++){
			SaramDto dto = new SaramDto();
			String id = dto.getId();
			String name = dto.getName();
			int age = dto.getAge();
			
			out.print("<tr><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td></tr>");
		}*/
		
		/*out.print("</body></html>");*/
		
		
		//saram_list.jsp 페이지 포워딩
		String viewName = "/WEB-INF/views/saram_list.jsp"; //viewName에 saram_list 경로를 저장
		RequestDispatcher view =  req.getRequestDispatcher(viewName);
		view.forward(req, resp);
		
		
	}

}
