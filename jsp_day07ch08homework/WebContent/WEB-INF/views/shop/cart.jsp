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

	<h1>��ٱ���</h1>
	<hr>
	<table border="1" width="100%">
		<tr>
			<td>��ȣ</td>
			<td>�̸�</td>
			<td>����</td>
			<td>ȸ��</td>
			<td>����</td>
			<td>�����ϱ�</td>
		</tr>
<%
	if(session.getAttribute("product_cart") != null){
		ArrayList<ProductDto> cartArr = (ArrayList<ProductDto>)session.getAttribute("product_cart");
		if(cartArr == null || cartArr.size() <= 0){
%>
		<p>��ٱ��ϰ� ����ֽ��ϴ�!</p>
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
			<td><a >�����ϱ�</a></td>
		</tr>

	</table>
<%
		int sum = 0;
		sum += product.getPrice();
		
		int cnt = 1;
		cnt = i;
%>	
	<p>�� �ֹ��� ���� <%=cnt %></p><br>
	<p>�� �ֹ��� �ݾ� <%=sum %></p><br>
	<a href="list.do">�� �ѷ�����</a> | <a href = "">��ٱ��� ����</a>
<%
		}//end of for
	}//end of if1
%>

</body>
</html>