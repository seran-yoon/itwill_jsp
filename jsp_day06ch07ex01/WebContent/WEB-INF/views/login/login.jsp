<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	input.loginBtn{
		width: 50px;
		height: 40px;
	}
</style>
</head>
<body>

	<h3>로그인 페이지</h3>
	<hr>
	<%
		if(session.getAttribute("login.id") == null){
	%>
	<form action="login.do" method="post">
		<table width="400">
			<tr>
				<th width="100">아이디</th>
				<td width="200"><input type="text" name="userID" placeholder="아이디 입력"></td>
				<td rowspan="2"><input class="loginBtn" type="submit" value="login"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="passwd" placeholder="비밀번호 입력"></td>
			</tr>
		</table>
	</form>
	<%
		} else {
	%>
		<h3><%=session.getAttribute("login.id")%>님 환영합니다!</h3>
		<p><a href="login.do?cmd=logout">로그아웃</a></p>
	<%
		}
	%>
	
	<script>
		var form = document.forms[0];
		/* var form = document.getElementsByTagName("form")[0]; */
		form.onsubmit = function(){
			//submit버튼이 눌러지면 실행 되는 이벤트 핸들러
			//form의 기본 기능 : 페이지 이동
			event.preventDefault(); //기능을 일시정지
			
			//유효성 체크
			if(this.userID.value == ""){//이벤트 핸들러에서의 this는 해당 이벤트 객체(form)이다
				alert("아이디는 필수 항목입니다!");
				this.userID.focus();
				return;
			}
			if(this.passwd.value == ""){
				alert("비밀번호는 필수 항목입니다!");
				this.passwd.focus();
				return;
			}
			if(this.userID.value != "admin" || this.passwd.value != "1234"){
				alert("아이디 또는 비밀번호가 다릅니다!");
				return;
			}
			
			//전송
			form.action = "login.do";
			form.method = "POST";
			form.submit(); //전송을 해라!
		};
	</script>

</body>
</html>