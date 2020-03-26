<%@page import="org.comstudy21.employe.dto.EmployeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>정말 삭제하시겠습니까?</h3>
<%
	if(request.getAttribute("emplist") != null){
		EmployeDto emplist = (EmployeDto)request.getAttribute("emplist");
%>
	<form action="delete.do" method="POST">
		<input type="hidden" value="<%=emplist.getName()%>" name="name"> 
		<input type="submit" value="삭제"> | <input type="button" value="취소" onclick="location.href='detail.do?name=<%=emplist.getName()%>'">
	</form>
<% 
	}
%>

</body>
</html>