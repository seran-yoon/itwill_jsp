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

	<h1>사람 상세 정보</h1>
	<hr>
<%
	if(request.getAttribute("saram") != null){
		SaramDto saram = (SaramDto)request.getAttribute("saram");
%>
	<table border="1" width="80%">
		<tr>
			<th>아이디</th>
			<td><%=saram.getId()%></td>
		</tr>
		<tr>
			<th>성명</th>
			<td><%=saram.getName()%></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><%=saram.getAge()%></td>
		</tr>
	</table>
	
	<p><a href="<%=request.getContextPath()%>/saram/modify.do?id=<%=saram.getId()%>">수정하기</a> | <a href="<%=request.getContextPath()%>/saram/delete.do?id=<%=saram.getId()%>">삭제하기</a></p>
<%
	}//end of if
%>

</body>
</html>