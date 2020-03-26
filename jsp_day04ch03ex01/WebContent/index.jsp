<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>사람 정보 관리 프로그램</h1>
	<hr>
	<ul>
		<li><a href="<%=request.getContextPath()%>/saram/list.do">사람 목록</a></li>
		<li><a href="<%=request.getContextPath()%>/saram/input.do">사람 정보 입력</a></li>
	</ul>
	
	<!-- request.getContextPath() -> 해당 프로젝트의 상위폴더를 확인할 수 있음
		상위폴더를 하나하나 적어주는 대신, 이 코드문을 작성하면 프로젝트의 경로가 변경되어도 일일이 수정하지 않아도 됨-->

</body>
</html>