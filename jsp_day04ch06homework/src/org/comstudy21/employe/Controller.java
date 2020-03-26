package org.comstudy21.employe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.employe.dao.EmployeDao;
import org.comstudy21.employe.dto.EmployeDto;
import org.comstudy21.util.JdbcUtil;

public class Controller extends HttpServlet {
	EmployeDao dao = new EmployeDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dopost");
		
		//*******한글 처리 (POST) 방식 일때*********
		req.setCharacterEncoding("UTF-8"); //요청받을때
		resp.setCharacterEncoding("UTF-8"); //전달받을때
		resp.setContentType("text/html; charset=UTF-8"); //화면에 띄울때
		
		String course = req.getParameter("course");
		String name = req.getParameter("name");
		String jumin1 = req.getParameter("jumin1");
		String jumin2 = req.getParameter("jumin2");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String mobile = req.getParameter("mobile");
		String payment = req.getParameter("payment");
		String start_day = req.getParameter("start_day");
		String end_day = req.getParameter("end_day");
		String collect_person_info = req.getParameter("collect_person_info");
		
		EmployeDto dto = new EmployeDto(course, name, jumin1, jumin2, address, phone, mobile, payment, start_day, end_day, collect_person_info);
		dao.setConn(JdbcUtil.getConnection());
		
		String path = makePath(req); //경로 받아옴
		String viewName = "/";
		
		if("/accept_insert".equals(path)){ //입력
			dao.insert(dto);
			viewName = "insert_end.do";
		} else if("/employer/delete".equals(path)){ //삭제
			dao.delete(dto);
			viewName = "list.do";
		}
		
		resp.sendRedirect(viewName);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget");
		
		String path = makePath(req); //경로 받아옴
		String viewName = "/";
		
		if("/employer/list".equals(path)){ //전체보기
			dao.setConn(JdbcUtil.getConnection());
			EmployeDto[] listArr = dao.selectAll();
			req.setAttribute("listArr", listArr);
			viewName = "/WEB-INF/views/employer/list.jsp";
		} else if("/employer/detail".equals(path)){ //상세보기
			String name = req.getParameter("name");
			dao.setConn(JdbcUtil.getConnection());
			EmployeDto emplist = dao.selectOne(new EmployeDto(null, name, null, null, null, null, null, null, null, null, null));
			req.setAttribute("emplist", emplist);
			viewName = "/WEB-INF/views/employer/detail.jsp";
		} else if("/insert_end".equals(path)){ //입력후, 확인 창 보여주기
			viewName = "/insert_end.jsp";
		} else if("/employer/delete".equals(path)){ //삭제하기
			String name = req.getParameter("name");
			dao.setConn(JdbcUtil.getConnection());
			EmployeDto emplist = dao.selectOne(new EmployeDto(null, name, null, null, null, null, null, null, null, null, null));
			req.setAttribute("emplist", emplist);
			viewName = "/WEB-INF/views/employer/delete.jsp";
		} else if("/accept_insert".equals(path)){ //다시 입력창으로 가기
			viewName = "/accept_insert.html";
		}
		
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
		
	}
	
	
	private String makePath(HttpServletRequest req) {
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		
		int beginIndex = ctxPath.length();
		int lastIndex = reqUri.lastIndexOf(".");
		
		String path = reqUri.substring(beginIndex, lastIndex);
		System.out.println("path => " + path);
		
		return path;
	}

}
