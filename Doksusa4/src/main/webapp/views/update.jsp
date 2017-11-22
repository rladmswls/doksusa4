<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="up.jsp" flush="false"/>
<div id="here">
<h3>회원정보 수정</h3>
	<form action="update.do" method="POST">
		<tr>
		 <td><input type="password" name="u_pw" placeholder="수정 할 비밀번호를 입력"></td><br>
         </tr>
         <tr>
            <td><input type="text" name="u_nick" placeholder="수정 할 닉네임 입력"></td><br>
         </tr>
         <tr>
            <td><input type="tel" name="u_phone"  placeholder="수정 할 전화번호 입력"></td><br>
         </tr>
		<input type="submit" value="저장">
	</form>
	<hr>
	<form action="delete.do">
		<input type="submit" value="탈퇴">
	</form>
</div>
</body>
</html>