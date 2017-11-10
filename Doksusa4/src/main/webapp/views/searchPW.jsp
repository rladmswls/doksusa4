<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form name="f" method="post" action="">
		<p>패스워드 찾기</p>
		<input type="text" name="u_id" placeholder="아이디 입력"><br>
		<input type="password" name="u_pw" placeholder="비밀번호 입력"><br>
		<button class="btn" onclick="login()" id="login">로그인</button>
		<button class="btn" onclick="searchID()" id="login">아이디 찾기</button>
		<button class="btn" onclick="searchPW()" id="login">비밀번호 찾기</button>
	</form>
</body>
</html>