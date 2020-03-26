<%@page import="org.comstudy21.employe.dto.EmployeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table, tr, th, td {
        border: 1px solid gray;
        border-collapse: collapse;
    }
    table, th {
    	border: 2px solid gray;
    }
</style>
</head>
<body>

	<h2>지원자 상세 정보</h2>
	<hr>
<% 
	if(request.getAttribute("emplist") != null){
		EmployeDto emplist = (EmployeDto)request.getAttribute("emplist");
%>
	<table border="1" width="80%">
		<tr>
			<th>신청과정</th>
			<td><%=emplist.getCourse()%></td>
		</tr>
		<tr>
			<th>성명</th>
			<td><%=emplist.getName()%></td>
		</tr>
		<tr>
			<th>주민등록번호</th>
			<td><%=emplist.getJumin1()%>-<%=emplist.getJumin2()%>******</td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=emplist.getAddress()%></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%=emplist.getPhone()%></td>
		</tr>
		<tr>
			<th>휴대전화</th>
			<td><%=emplist.getMobile()%></td>
		</tr>
		<tr>
			<th>수강료납부</th>
			<td><%=emplist.getPayment()%></td>
		</tr>
		<tr>
			<th>교육 시작 날짜</th>
			<td><%=emplist.getStart_day()%></td>
		</tr>
		<tr>
			<th>교육 종료 날짜</th>
			<td><%=emplist.getEnd_day()%></td>
		</tr>
		<tr>
			<th>개인정보 수집 및 이용 동의</th>
			<td><%=emplist.getCollect_person_info()%></td>
		</tr>
	</table>
	
	<p><a href="<%=request.getContextPath()%>/employer/list.do">List</a> | <a href="delete.do?name=<%=emplist.getName()%>">Delete</a></p>
<%
	}//end of if
%>

</body>
</html>