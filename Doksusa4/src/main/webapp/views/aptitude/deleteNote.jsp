<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../up.jsp" flush="false" />
	<div id="here">
		<h3>오답문제 삭제</h3>
		정말 삭제하시겠습니까?
		<form name="f" action="a_deleteNote.do" method="POST">
			<input  class="btn btn-default" type="hidden" name="a_num" id="a_num" value=${a_num }>
			<input class="btn btn-default" type="hidden" name="a_subnum" id="a_subnum" value=${a_subnum }>
			<input type="radio" name="yesOrno" value="예">예 <input
				type="radio" name="yesOrno" value="아니오">아니요<br> <input
				 class="btn btn-default" type="submit" value="확인">
		</form>
	</div>
</body>
</html>