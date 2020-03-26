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

	<h1>사람 정보 수정</h1>
	<hr>
	<form action="modify.do" method="POST">
<%
	if(request.getAttribute("saram") != null){
		SaramDto saram = (SaramDto)request.getAttribute("saram");
%>
		<table border="1" width="80%">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="<%=saram.getId()%>" readonly></td> <!-- readonly를 쓰면 입력창이 비활성화 됨 -->
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%=saram.getName()%>"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" value="<%=saram.getAge()%>"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="수정"></th>
			</tr>
		</table>
<%
	}//end of if
%>
	</form>

</body>
</html>