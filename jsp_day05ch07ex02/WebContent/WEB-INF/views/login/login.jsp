<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h3>�α��� ������</h3>
	<%
		if(session.getAttribute("login.id") == null){
	%>
	<form>
		<table>
			<tr>
				<th>���̵�</th>
				<td><input type="text" name="userID" placeholder="���̵� �Է�"></td>
			</tr>
			<tr>
				<th>��й�ȣ</th>
				<td><input type="password" name="passwd" placeholder="��й�ȣ �Է�"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="Log-in"></td>
			</tr>
		</table>
	</form>
	<%
		}else{
	%>
		<h2>�α��� ����!</h2>
		<p><%=(String)session.getAttribute("login.id")%>�� ȯ���մϴ�!</p>
		<p><a href="login.do?cmd=logout">�α׾ƿ�</a></p>
	<%
		}//end of if
	%>
	
	<script>
		var form = document.forms[0];
		form.onsubmit = function(){
			//form�� ������ �̵� ����� �Ͻ�����
			event.preventDefault();
			
			//��ȿ�� üũ
			if(this.userID.value == ""){
				alert("���̵�� �ʼ� �Է� �׸� �Դϴ�!");
				this.userID.focus();
				return;
			}
			if(this.passwd.value == ""){
				alert("�н������ �ʼ� �Է� �׸� �Դϴ�!");
				this.passwd.focus();
				return;
			}
			
			//�����ϱ�
			this.action = "login.do";
			this.method = "post";
			this.submit();
		};
	</script>

</body>
</html>