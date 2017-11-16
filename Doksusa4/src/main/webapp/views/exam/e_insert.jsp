<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../up.jsp" flush="false"/>
<div id="here">
<h3>모의고사 등록</h3>
<form action="e_insert.do" method="post">
	연도<input type="number" min="1996" max="2017" value="2017" name="e_year">
	학년<input type="number" min="1" max="3" value="3" name="e_grade">
	과목<select id="e_subject">
		<option>언어</option>
		<option>수리</option>
		<option>외국어</option>
		<option>한국사</option>
		<option>사탐</option>
		<option>과탐</option>
	</select>
	문제링크<input type="text" name="e_link">
	답지링크<input type="text" name="e_answer">
	해설링크<input type="text" name="e_solution">
	<input type="submit" value="등록"> 
</form>
</div>
</body>
</html>