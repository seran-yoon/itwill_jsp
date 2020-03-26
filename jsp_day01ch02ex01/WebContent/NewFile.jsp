<%@page import="org.comstudy21.Helloworld"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<!-- JSP를 바로 실행하는 것은 모델 1 방식이다. -->
<h1>Hello World</h1>
<hr>
<% //JSP 스크립트렛 (java문법 사용 가능)
	String name = "홍길동";
	Helloworld hello = new Helloworld(name);
	hello.sayHello();
%>

</body>
</html>