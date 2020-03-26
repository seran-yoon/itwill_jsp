package org.comstudy21.saram;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("doProcess - LoginController");
		System.out.println("Method : " + req.getMethod());
		
		HttpSession session = req.getSession();
		
		String viewName = "/WEB-INF/views/login/login.jsp";
		boolean isRedirect = false;
		
		if("GET".equals(req.getMethod())){ //method가 get일때 처리되는 방법
			//로그아웃 처리
			String cmd = req.getParameter("cmd");
			if("logout".equals(cmd)){
				session.removeAttribute("login.id"); //세션이 지워지는 방법1
				session.invalidate(); //세션이 지워지는 방법2
				System.out.println("로그아웃 처리 되었습니다!");
			}
		}else if("POST".equals(req.getMethod())){ //method가 post일때 처리되는 방법
			//로그인 처리
			String userID = req.getParameter("userID");
			String passwd = req.getParameter("passwd");
			if("admin".equals(userID) && "1234".equals(passwd)){
				session.setAttribute("login.id", "윤세란");
			}
			
			isRedirect = true;
			viewName = "login.do";
		}
		
		if(isRedirect){
			resp.sendRedirect(viewName);
		} else {
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		}
		
	}
	
}
