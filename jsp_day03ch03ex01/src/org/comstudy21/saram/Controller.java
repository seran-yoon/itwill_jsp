package org.comstudy21.saram;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.saram.dao.SaramDao;
import org.comstudy21.saram.dto.SaramDto;
import org.comstudy21.util.JdbcUtil;

public class Controller extends HttpServlet {
	SaramDao dao = new SaramDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//*******한글 처리 (POST) 방식 일때*********
		req.setCharacterEncoding("UTF-8"); //요청받을때
		resp.setCharacterEncoding("UTF-8"); //전달받을때
		resp.setContentType("text/html; charset=UTF-8"); //화면에 띄울때
		
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		int beginIndex = ctxPath.length();
		int lastIndex = reqUri.lastIndexOf(".");
		
		String path = reqUri.substring(beginIndex, lastIndex);
		
		//form의 method가 POST 요쳥일때 자동 호출된다
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		SaramDto dto = new SaramDto(id, name, age);
	
		if("/saram/input".equals(path)){ //입력
			dao.setConn(JdbcUtil.getConnection());
			dao.insert(dto);
		} else if("/saram/modify".equals(path)){ //수정
			dao.setConn(JdbcUtil.getConnection());
			dao.update(dto);
		}
		
		resp.sendRedirect("list.do"); //리스트화면 재출력
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		
//		System.out.println("doGet - Controller");
//		System.out.println("ctxpath => " + ctxPath); //출력 -> /jsp_day03ex01
//		System.out.println("reqUri => " + reqUri); //출력 -> /jsp_day03ex01/누르는 페이지의 위치
		
		int beginIndex = ctxPath.length();
		int lastIndex = reqUri.lastIndexOf(".");
		
		String path = reqUri.substring(beginIndex, lastIndex);
		System.out.println("path => " + path);
		
		String viewName = "/";
		if("/saram/list".equals(path)){ //******전체보기
			dao.setConn(JdbcUtil.getConnection());
			SaramDto[] saramArr = dao.selectAll();
			req.setAttribute("saramArr", saramArr); //saramArr 뿌려주는것
			viewName = "/WEB-INF/views/saram/list.jsp";
		} else if("/saram/input".equals(path)){ //******입력하기
			viewName = "/WEB-INF/views/saram/input.jsp";
		} else if("/saram/detail".equals(path)){ //******상세보기
			String id = req.getParameter("id");
			dao.setConn(JdbcUtil.getConnection()); //매번 해줘야 함
			SaramDto saram = dao.selectOne(new SaramDto(id, null, 0));
			req.setAttribute("saram", saram); //saram 뿌려주는것
			viewName = "/WEB-INF/views/saram/detail.jsp";
		} else if("/saram/modify".equals(path)){ //******수정하기
			String id = req.getParameter("id");
			dao.setConn(JdbcUtil.getConnection());
			SaramDto saram = dao.selectOne(new SaramDto(id, null, 0));
			req.setAttribute("saram", saram); //saram 뿌려주는것
			viewName = "/WEB-INF/views/saram/modify.jsp";
		} else { //******삭제하기
			String id = req.getParameter("id");
			dao.setConn(JdbcUtil.getConnection());
			dao.delete(new SaramDto(id,null,0));
			resp.sendRedirect("list.do"); //리스트화면 재출력
			return; //삭제시에는 viewName이 없기 때문에 밑에 두 줄때문에 오류가 나기 때문에 return을 해주면 됨
		}
//		else if("/saram/delete".equals(path)){ //******삭제하기
//			String id = req.getParameter("id");
//			dao.setConn(JdbcUtil.getConnection());
//			SaramDto saram = dao.selectOne(new SaramDto(id, null, 0));
//			req.setAttribute("saram", saram);
//			viewName = "/WEB-INF/views/saram/delete.jsp";
//		}
		
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}

}
