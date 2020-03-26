<%@page import="org.comstudy21.saram.dto.SaramDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>사람 목록</h1>
	<hr>
	<table border="1" width="80%">
		<tr>
			<th>아이디</th>
			<th>성명</th>
			<th>나이</th>
		</tr>
<% 
	//반복 할 내용을 request에서 받아온다
	if(request.getAttribute("saramArr") != null){
		SaramDto[] saramArr = (SaramDto[])request.getAttribute("saramArr");
		for(int i=0;i<saramArr.length;i++){
			SaramDto saram = saramArr[i];
%>
		<tr>
			<td><%=saram.getId()%></td>
			<td><a href="detail.do?id=<%=saram.getId()%>"><%=saram.getName()%></a></td>
			<td><%=saram.getAge()%></td>
		</tr>
<%
		}//end of for
	}//end of if
%>
	</table>
	<p><a href="<%=request.getContextPath()%>">Home</a></p>

</body>
</html>