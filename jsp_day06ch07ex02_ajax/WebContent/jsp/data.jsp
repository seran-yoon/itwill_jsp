<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	String user = request.getParameter("user");
	String message = request.getParameter("msg");
%>
USER: <%=user%> | MSG: <%=message%>
