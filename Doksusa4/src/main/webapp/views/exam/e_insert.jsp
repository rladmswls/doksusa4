<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doksusa</title>
</head>
<body>
<jsp:include page="../up.jsp" flush="false"/>
<div id="here">
<h3>모의고사 등록</h3>
<form action="e_insert.do" method="post">
	연도<input type="number" min="1996" max="2018" value="2018" name="e_year"><br>
	학년<select name="e_grade">
		<option>----</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
	</select><br>
	과목<select name="e_subject">
		<option>----</option>
		<option value="언어">언어</option>
		<option value="수리-가형">수리-가형</option>
		<option value="수리-나형">수리-나형</option>
		<option value="외국어">외국어</option>
		<option value="한국사">한국사</option>
		<option value="사탐">사탐</option>
		<option value="과탐">과탐</option>
	</select><br>
	문제링크<input type="text" name="e_link"><br>
	답지링크<input type="text" name="e_answer"><br>
	해설링크<input type="text" name="e_solution"><br><br>
	<input class="btn btn-default" type="submit" value="등록"> 
</form>
</div>
</body>
</html>