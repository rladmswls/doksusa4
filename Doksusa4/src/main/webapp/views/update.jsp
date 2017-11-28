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
	<table align="center">
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="u_pw" value="${user.u_pw}"></td>
	         </tr>
	         <tr>
	        	<th>닉네임</th>
	            <td><input type="text" name="u_nick" value="${user.u_nick}"></td>
	         </tr>
	         <tr>
	        	<th>전화번호</th>
	            <td><input type="tel" name="u_phone"  value="${user.u_phone}"></td>
	         </tr>
	</table>
		<input type="hidden" name="u_num" id="u_num" value="${sessionScope.u_num}" > 
		<input type="hidden" name="u_id" id="u_id" value="${sessionScope.u_id}" > 
		<input type="submit" value="저장">
	</form>
	<hr>
	<form action="delete.do">
		<input type="submit" value="탈퇴">
	</form>
</div>
</body>
</html>