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

	<h1>��� ��� ������</h1>
	<%
		/* String name = (String)request.getAttribute("name"); //�����Ҷ� �� object�� �־��� ������ String���� ����ȯ ����� ��
		out.println("name => " + name + "<br>"); //System�� ���� �ܼ�â�� ������, System�� ���� �� �������� ���
		
		String[] names = (String[])request.getAttribute("names");
		for(int i=0;i<names.length;i++){
			out.println("names => ");
			out.println(names[i] + "<br>");
		} */
		
		out.print("<html><body>");
		out.print("<table border=1<tr>");
		out.print("<td>ID</td><td>NAME</td><td>AGE</td></tr>");
		
		SaramDto[] arr = (SaramDto[])request.getAttribute("selectAll");
		for(int i=0;i<arr.length;i++){
			SaramDto dto = new SaramDto();
			String id = dto.getId();
			String name = dto.getName();
			int age = dto.getAge();
			
			out.print("<tr><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td></tr>");
		}
		
		out.print("</body></html>");
		
		/* for(SaramDto dto : arr){
			out.println(dto.toString()+"<br>");
		} */
	%>

</body>
</html>