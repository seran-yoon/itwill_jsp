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

	<h3>�α��� ������</h3>
	<hr>
	<%
		if(session.getAttribute("login.id") == null){
	%>
	<form action="login.do" method="post">
		<table width="400">
			<tr>
				<th width="100">���̵�</th>
				<td width="200"><input type="text" name="userID" placeholder="���̵� �Է�"></td>
				<td rowspan="2"><input class="loginBtn" type="submit" value="login"></td>
			</tr>
			<tr>
				<th>��й�ȣ</th>
				<td><input type="text" name="passwd" placeholder="��й�ȣ �Է�"></td>
			</tr>
		</table>
	</form>
	<%
		} else {
	%>
		<h3><%=session.getAttribute("login.id")%>�� ȯ���մϴ�!</h3>
		<p><a href="login.do?cmd=logout">�α׾ƿ�</a></p>
	<%
		}
	%>
	
	<script>
		var form = document.forms[0];
		/* var form = document.getElementsByTagName("form")[0]; */
		form.onsubmit = function(){
			//submit��ư�� �������� ���� �Ǵ� �̺�Ʈ �ڵ鷯
			//form�� �⺻ ��� : ������ �̵�
			event.preventDefault(); //����� �Ͻ�����
			
			//��ȿ�� üũ
			if(this.userID.value == ""){//�̺�Ʈ �ڵ鷯������ this�� �ش� �̺�Ʈ ��ü(form)�̴�
				alert("���̵�� �ʼ� �׸��Դϴ�!");
				this.userID.focus();
				return;
			}
			if(this.passwd.value == ""){
				alert("��й�ȣ�� �ʼ� �׸��Դϴ�!");
				this.passwd.focus();
				return;
			}
			if(this.userID.value != "admin" || this.passwd.value != "1234"){
				alert("���̵� �Ǵ� ��й�ȣ�� �ٸ��ϴ�!");
				return;
			}
			
			//����
			form.action = "login.do";
			form.method = "POST";
			form.submit(); //������ �ض�!
		};
	</script>

</body>
</html>