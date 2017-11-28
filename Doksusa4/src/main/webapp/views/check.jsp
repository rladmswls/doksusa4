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
<h3>본인 확인</h3>
<form action="check.do" method="POST" >
	<input type="hidden" name="u_id" value="${u_id }">
	<input type="password" name="u_pw" placeholder="비밀번호 입력">
	<input type="submit" id="button">
</form>
</div>
</body>
</html>