<%@page import="org.comstudy21.shop.model.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>자동차 상품 목록</h1>
	<hr>
	<table border=1, width="100%">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>가격</td>
			<td>회사</td>
			<td>연식</td>
			<td>카트 담기</td>
		</tr>
		<% 
		if(session.getAttribute("product_list") != null){
			ProductDto[] arr = (ProductDto[])session.getAttribute("product_list");
			for(int i=0;i<arr.length;i++){
				ProductDto product = arr[i];
		%>
			<tr>
				<td><%=i+1%></td>
				<td><%=product.getName()%></td>
				<td><%=product.getPrice()%></td>
				<td><%=product.getCompany()%></td>
				<td><%=product.getYear()%></td>
				<td><a href="cart.do?no=<%=product.getNo()%>">담기</a></td>
			</tr>
		<% 
			}//end of for
		}//end of if
		%>
	</table>

</body>
</html>