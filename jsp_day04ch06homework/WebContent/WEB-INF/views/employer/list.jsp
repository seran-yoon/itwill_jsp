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

	<h2>지원자 목록</h2>
	<hr>
	<table border="1" width="80%">
<%
	if(request.getAttribute("listArr") != null){
		EmployeDto[] listArr = (EmployeDto[])request.getAttribute("listArr");
		for(int i=0;i<listArr.length;i++){
			EmployeDto list = listArr[i];
%>
		<tr>
			<th><% out.println(i+1); %></th>
			<td>
				<%=list.getCourse()%>
			</td>
			<td><a href="detail.do?name=<%=list.getName()%>"><%=list.getName()%></a></td>
			<td><%=list.getMobile()%></td>
		</tr>
<%
		}//end of for
	}//end of if
%>
		
	</table>

</body>
</html>