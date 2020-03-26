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
		
		System.out.println("doPost - Controller");
		
		//form의 method가 POST 요쳥일때 자동 호출된다
		String id = null;
		String name = null;
		int age = 0;
		
		if(req.getParameter("id") != null){
			id = req.getParameter("id");
		}
		if(req.getParameter("name") != null){
			name = req.getParameter("name");
		}
		if(req.getParameter("age") != null){
			age = Integer.parseInt(req.getParameter("age"));
		}
		SaramDto dto = new SaramDto(id, name, age);
		dao.setConn(JdbcUtil.getConnection());
		
		String path = makePath(req); //경로 받아옴
		
		String viewName = "list.do";
		if("/saram/input".equals(path)){ //입력			
			dao.insert(dto);
		} else if("/saram/modify".equals(path)){ //수정
			dao.update(dto);
			viewName = "detail.do?id=" + dto.getId(); //lsit화면이 아니라 detail화면으로 가도록
		} else if("/saram/delete".equals(path)){ //삭제
			dao.delete(dto);
		}
		
		resp.sendRedirect(viewName); //sendRedirect는 새로고침(갱신) 개념, 새로운 주소값이 할당되서 아예 새로 바뀐다 
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String ctxPath = req.getContextPath();
//		String reqUri = req.getRequestURI();
//		
		System.out.println("doGet - Controller");
////		System.out.println("ctxpath => " + ctxPath); //출력 -> /jsp_day03ex01
////		System.out.println("reqUri => " + reqUri); //출력 -> /jsp_day03ex01/누르는 페이지의 위치
//		
//		int beginIndex = ctxPath.length();
//		int lastIndex = reqUri.lastIndexOf(".");
//		
//		String path = reqUri.substring(beginIndex, lastIndex);
//		System.out.println("path => " + path);
		
		String path = makePath(req); //경로 받아옴
		
		String viewName = "/";
		if("/saram/list".equals(path)){ //******전체보기
			dao.setConn(JdbcUtil.getConnection());
			SaramDto[] saramArr = dao.selectAll();
			req.setAttribute("saramArr", saramArr); //saramArr 뿌려주는것
			viewName = "/WEB-INF/views/saram/list.jsp";
		} else if("/saram/input".equals(path)){ //******입력하기
			viewName = "/WEB-INF/views/saram/input.jsp";
		} else if("/saram/detail".equals(path)){ //******상세보기
			selectOneAndSave(req);
			viewName = "/WEB-INF/views/saram/detail.jsp";
		} else if("/saram/modify".equals(path)){ //******수정하기
			selectOneAndSave(req);
			viewName = "/WEB-INF/views/saram/modify.jsp";
		} else if("/saram/delete".equals(path)){ //******삭제하기
			selectOneAndSave(req);
			viewName = "/WEB-INF/views/saram/delete.jsp";
		}
		
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp); //forward는 원래 화면을 가져와서 다시 보여주기만 하는 개념(고쳐지지는 않음 -> 새로고침 안됨) (수정을 하고 forward로 보여주게 되면 수정된 화면이 아니라 원래 db에 있던 정보들이 보여지게 될 수 있음)
	}

	//경로를 받아오는 함수
	private String makePath(HttpServletRequest req) {
		String ctxPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		
		int beginIndex = ctxPath.length();
		int lastIndex = reqUri.lastIndexOf(".");
		
		String path = reqUri.substring(beginIndex, lastIndex);
		System.out.println("path => " + path);
		
		return path;
	}

	//반복으로 사용하는 코드라 함수로 따로 만들어서 사용
	//id로 상세정보를 받아서 db의 정보를 찾아 연결하고, dao의 selectOne에서 saramDto객체를 가져와서 saram속성으로 받고, 받아온 saram을 보여주게 함
	private void selectOneAndSave(HttpServletRequest req) { 
		String id = req.getParameter("id");
		dao.setConn(JdbcUtil.getConnection()); //매번 해줘야 함
		SaramDto saram = dao.selectOne(new SaramDto(id, null, 0));
		req.setAttribute("saram", saram); //saram 뿌려주는것
	}

}
