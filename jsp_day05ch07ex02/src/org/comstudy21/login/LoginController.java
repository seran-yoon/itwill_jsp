package org.comstudy21.login;

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

		boolean isRedirect = false;
		String viewName = "/";
		HttpSession session = req.getSession();

		if ("GET".equals(req.getMethod())) {
			String cmd = req.getParameter("cmd");
			if("logout".equals(cmd)){
				session.removeAttribute("login.id");
				session.invalidate();
				System.out.println("로그아웃 처리 됨!");
				isRedirect = true;
				viewName = "login.do";
			} else{
				viewName = "/WEB-INF/views/login/login.jsp";
			}
		} else { //post
			if("admin".equals(req.getParameter("userID"))&&"1234".equals(req.getParameter("passwd"))){
				session.setAttribute("login.id", "SERAN");
			}else{
				System.out.println("아이디 또는 비밀번호가 다릅니다!");
			}
			isRedirect = true;
			viewName = "login.do";
		}

		if (isRedirect) {
			resp.sendRedirect(viewName);
		} else {
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		}

	}
	
	
}