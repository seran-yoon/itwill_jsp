package org.comstudy21.shop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.comstudy21.shop.model.ProductDto;

public class Controller extends HttpServlet {
	
	ProductDto[] arr = {
			new ProductDto(1, "Sonata", 3000, "HYUNDAI", 2018),
			new ProductDto(2, "Genesis", 8000, "HYUNDAI", 2017),
			new ProductDto(3, "Bongo", 1500, "KIA", 2016),
			new ProductDto(4, "K9", 4000, "KIA", 2018),
			new ProductDto(5, "SM6", 3500, "SAMSUNG", 2017),
			new ProductDto(6, "Volvo", 4500, "VOLVO", 2019),
			new ProductDto(7, "Grandeur", 3500, "HYUNDAI", 2018)
	};
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("doProcess - Controller");
		System.out.println("method => " + req.getMethod());
		
		String viewName = "/WEB-INF/views/shop/list.jsp";
		boolean isRedirect = false;
		HttpSession session = req.getSession();
		
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		int begin = ctxPath.length(); //시작값
		int end = reqUri.lastIndexOf("."); //끝값
		String path = reqUri.substring(begin, end);
		System.out.println("path => " + path);
		
		if("GET".equals(req.getMethod())) {
			if("/shop/product".equals(path)) {
				session.setAttribute("product_list", arr);
			} else if("/shop/cart".equals(path)) {
				ArrayList<ProductDto> cartArr = null;
				if(session.getAttribute("product_cart") == null) { //cart가 비어있으면 새것으로 초기화
					cartArr = new ArrayList<ProductDto>();
				} else { //cart가 비어있지 않으면 지금까지의 데이터를 배열로 담는다
					cartArr = (ArrayList<ProductDto>)session.getAttribute("product_cart");
				}
				
				String name = req.getParameter("name");
				int price = Integer.parseInt(req.getParameter("price"));
				String company = req.getParameter("company");
				int year = Integer.parseInt(req.getParameter("year"));
				
				ProductDto dto = new ProductDto();
				
				dto.setName(name);
				dto.setPrice(price);
				dto.setCompany(company);
				dto.setYear(year);
				cartArr.add(dto);
				
				session.setAttribute("product_cart", cartArr);
				
				viewName = "/WebContent/WEB-INF/views/shop/cart.jsp";
			}
			
		} else { //"POST".equals(req.getMethod)
			isRedirect = true;
			viewName = "product.do";
		}
		
		if(isRedirect) {
			resp.sendRedirect(viewName);
		} else {
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		}
		
	}
	
}
