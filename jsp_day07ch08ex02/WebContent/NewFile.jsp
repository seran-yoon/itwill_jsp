<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Login Form</h1>
	<hr>
	<form action="login" method="get">
	<table border="1" cellpadding="5" cellspacing="0" width="600">
		<tr>
			<td width="200">
				<p align="right">사용자 아이디</p>
			</td>
			<td width="400">
				<input type="text" name="userID">
			</td>			
		</tr>
		<tr>
			<td width="200">
				<p align="right">비밀번호</p>
			</td>
			<td width="400">
				<input type="password" name="passwd">
			</td>			
		</tr>
		<tr>
			<td width="200">
				<p>&nbsp;</p>
			</td>
			<td width="400">
				<input type="submit" value="전송"><input type="reset" value="초기화">
			</td>			
		</tr>
	</table>
	</form>

</body>
</html>