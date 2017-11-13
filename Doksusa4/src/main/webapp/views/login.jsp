<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
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
      f.action =    "login.do";
      f.method="post";
      f.submit();
   }
   function searchID() {
      f.action =    "searchID.do";
      f.submit();
   }
   function searchPW() {
      f.action =    "searchPW.do";
      f.submit();
   }
   
</script>
</head>
<body>
<h3>로그인</h3>
   <form name="f" action="" method="post">
      <input type="text" name="u_id" id="u_id"  placeholder="아이디 입력"><br>
      <input type="password" name="u_pw" placeholder="비밀번호 입력"><br>
      <button class="btn" onclick="login()" id="login1">로그인</button>
      <button class="btn" onclick="searchID()" id="login2">아이디 찾기</button>
      <button class="btn" onclick="searchPW()" id="login3">비밀번호 찾기</button>
   </form>
</body>
</html>