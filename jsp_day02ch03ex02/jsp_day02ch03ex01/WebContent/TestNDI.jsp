<%@page import="org.comstudy21.util.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>TestNDI.jsp</title>
</head>
<body>

<%
	Connection conn = JdbcUtil.getConnection();
	System.out.println(conn);
%>

<%
//JdbcUtil�� �������� �ٿ����� �����ϱ� ���� �ʿ��� �ּ�ó�� ���൵ ��
/* 	Context initCtx = new InitialContext();
	Context envCtx = (Context) initCtx.lookup("java:comp/env");
	DataSource ds = (DataSource) envCtx.lookup("jdbc/EmployeeDB");

	Connection conn = ds.getConnection();
	
	System.out.println(conn);
	
	conn.close(); */
%>

</body>
</html>