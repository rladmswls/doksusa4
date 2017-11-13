<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<% 
    if (session.getAttribute("user") != null) {
        response.sendRedirect("home.jsp");
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
<center>
<h3>회원가입</h3>
<div>
   <form action="join.do" method="post">
      <table>
         <tr>
            <td><input type="text"  name="u_id"  placeholder="아이디를 입력하세요"></td>      
         </tr>
         <tr>
            <td><input type="password" name="u_pw" placeholder="비밀번호를 입력하세요"></td>
         </tr>
         <tr>
            <td><input type="text" name="u_nick" placeholder="닉네임을 설정하세요"></td>
         </tr>
         <tr>
            <td><input type="tel" name="u_phone"  placeholder="전번 입력하세요"></td>
         </tr>
         <tr>
            <td><input id="join" type="submit" value="회원등록"><input type="reset" value="초기화"></td>
         </tr>
      </table>
   </form>
   </div>
</center>
</body>
</html>