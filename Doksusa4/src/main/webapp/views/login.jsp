<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>doksusa</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	function login() {
		f.action = 	"/login";
		f.method="post";
		f.submit();
	}
	function userinsert() {
		f.action = 	"/userinsert";
		f.method="get";
		f.submit();
	} 
</script>
</head>
<body>
	<form name="f" method="post" action="">
		<p>로그인</p>
		<input type="text" id="u_id" placeholder="아이디 입력"><br>
		<input type="password" id="u_pw" placeholder="비밀번호 입력"><br>
		<button class="btn" onclick="login()" id="login">로그인</button>
		<button class="btn" onclick="userinsert()" id="join">회원가입</button>
	</form>
</body>
</html>