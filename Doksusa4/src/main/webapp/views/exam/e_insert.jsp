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
	<h5>연도</h5><input class="btn btn-default"  type="number" min="1996" max="2018" value="2018" name="e_year"><br>
	<h5>학년</h5><select class="btn btn-default" name="e_grade">
		<option>----</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
	</select><br>
	<h5>과목</h5><select class="btn btn-default" name="e_subject">
		<option>----</option>
		<option value="언어">언어</option>
		<option value="수리-가형">수리-가형</option>
		<option value="수리-나형">수리-나형</option>
		<option value="외국어">외국어</option>
		<option value="한국사">한국사</option>
		<option value="사탐">사탐</option>
		<option value="과탐">과탐</option>
	</select><br>
	<h5>문제링크</h5><input class="btn btn-default" type="text" name="e_link"><br>
	<h5>답지링크</h5><input class="btn btn-default" type="text" name="e_answer"><br>
	<h5>해설링크</h5><input class="btn btn-default" type="text" name="e_solution"><br><br>
	<input class="btn btn-default" type="submit" value="등록"> 
</form>
</div>
</body>
</html>