<%@page import="org.comstudy21.shop.model.ProductDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>장바구니</h1>
	<hr>
	<table border="1" width="100%">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>가격</td>
			<td>회사</td>
			<td>연식</td>
			<td>삭제하기</td>
		</tr>
<%
	if(session.getAttribute("product_cart") != null){
		ArrayList<ProductDto> cartArr = (ArrayList<ProductDto>)session.getAttribute("product_cart");
		if(cartArr == null || cartArr.size() <= 0){
%>
		<p>장바구니가 비어있습니다!</p>
<%		}//end of if2
		for(int i=0;i<cartArr.size();i++){
			ProductDto product = cartArr.get(i);
%>
		<tr>
			<td><%=i+1 %></td>
			<td><%=product.getName() %></td>
			<td><%=product.getPrice() %></td>
			<td><%=product.getCompany() %></td>
			<td><%=product.getYear() %></td>
			<td><a >삭제하기</a></td>
		</tr>

	</table>
<%
		int sum = 0;
		sum += product.getPrice();
		
		int cnt = 1;
		cnt = i;
%>	
	<p>총 주문한 갯수 <%=cnt %></p><br>
	<p>총 주문한 금액 <%=sum %></p><br>
	<a href="list.do">더 둘러보기</a> | <a href = "">장바구니 비우기</a>
<%
		}//end of for
	}//end of if1
%>

</body>
</html>