<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h3>로그인 페이지</h3>
	<%
		if(session.getAttribute("login.id") == null){
	%>
	<form>
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="userID" placeholder="아이디 입력"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="passwd" placeholder="비밀번호 입력"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="Log-in"></td>
			</tr>
		</table>
	</form>
	<%
		}else{
	%>
		<h2>로그인 성공!</h2>
		<p><%=(String)session.getAttribute("login.id")%>님 환영합니다!</p>
		<p><a href="login.do?cmd=logout">로그아웃</a></p>
	<%
		}//end of if
	%>
	
	<script>
		var form = document.forms[0];
		form.onsubmit = function(){
			//form의 페이지 이동 기능을 일시정지
			event.preventDefault();
			
			//유효성 체크
			if(this.userID.value == ""){
				alert("아이디는 필수 입력 항목 입니다!");
				this.userID.focus();
				return;
			}
			if(this.passwd.value == ""){
				alert("패스워드는 필수 입력 항목 입니다!");
				this.passwd.focus();
				return;
			}
			
			//전송하기
			this.action = "login.do";
			this.method = "post";
			this.submit();
		};
	</script>

</body>
</html>