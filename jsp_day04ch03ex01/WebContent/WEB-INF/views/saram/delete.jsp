<%@page import="org.comstudy21.saram.dto.SaramDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
		<h3>���� �����Ͻðڽ��ϱ�?</h3><br>
<%
	if(request.getAttribute("saram") != null){
		SaramDto saram = (SaramDto)request.getAttribute("saram");
%>
	<form action="delete.do" method="POST">
		<input type="hidden" value="<%=saram.getId()%>" name="id"> 
		<input type="submit" value="����"> | <input type="button" value="���" onclick="location.href='detail.do?id=<%=saram.getId()%>'">
	</form>
<% 
	}
%>

</body>
</html>