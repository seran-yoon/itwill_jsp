<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="login.do" method="get">
    <h1>Login Form</h1>
    <table border="1" cellpadding="5" width="600">
        <tr>
            <td width="200">아이디</td>
            <td width="400"><input type="text" name="userID"></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="passwd"></td>
        </tr>
        <tr>
            <td>관심분야</td>
            <td>
                <input type="checkbox" name="checkValue" value="JAVA">JAVA
                <input type="checkbox" name="checkValue" value="Oracle">Oracle
                <input type="checkbox" name="checkValue" value="Node.js">Node.js
                <input type="checkbox" name="checkValue" value="Spring">Spring
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="전송">
                <input type="reset" value="취소">
            </td>
        </tr>
    </table>
    </form>


</body>
</html>