<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update.do" method="POST">
		비밀번호<input type="password" name="u_pw" placeholder="수정 할 비밀번호"><br>
		닉네임<input type="text" name="u_nick" placeholder="수정 할 닉네임"><br>
		핸드폰번호<input type="text" name="u_phone" placeholder="수정 할 핸드폰번호"><br>
		<input type="submit">
	</form>
	
</body>
</html>