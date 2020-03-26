package org.comstudy21.saram;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("doGet => Controller");
		
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		
		int beginIndex = ctxPath.length(); //앞에 상위폴더 명을 빼고 추출
		int lastIndex = reqUri.lastIndexOf("."); //뒤에 .확장자를 빼고 추출
		String path = reqUri.substring(beginIndex, lastIndex);
		System.out.println("path => " + path);
		
		String viewName = "/";
		if("/saram/list".equals(path)){
			viewName = "/WEB-INF/views/saram/list.jsp";
		}else if("/saram/input".equals(path)){
			viewName = "/WEB-INF/views/saram/input.jsp";
		}
			
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
		
	}

}
