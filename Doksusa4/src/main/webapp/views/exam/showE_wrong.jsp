<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function deleteNote(){
	f.action="deleteNote.do";
	f.submit();
}

function showAnswer(){
	f.action="showAnswer.do";
	f.submit();
}
</script>
</head>
<body>

	<jsp:include page="../up.jsp" flush="false" />
	<div id="here">
		<form name="f" action="" >
			<input type="hidden" name="e_num" id="e_num" value=${e_num }>
			<input type="hidden" name="e_subnum" id="e_subnum" value=${e_subnum }>
			<img src="${e_link}" />
			<hr>
			<input type="button" onclick="deleteNote()" value="삭제">
			<input type="button" onclick="showAnswer()" value="정답 확인">
		</form>
	</div>
</body>
</html>