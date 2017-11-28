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
	f.action="a_deleteNote.do";
	f.submit();
}
function showAnswer(){
	$.ajax({
		url : "showA_Answer.do",
		data : $("#myfrm").serialize(),
		success : function(responsetext) {
			if (responsetext == "1") {
				//$("#answer").css("display","block");
				$("#answer").toggle();
			}
		}
	});
}
</script>
</head>
<body>
	<jsp:include page="../up.jsp" flush="false" />
	<div id="here">
		<form id="myfrm" name="f" action="" >
			<input type="hidden" name="a_num" id="a_num" value=${a_num }>
			<input type="hidden" name="a_subnum" id="a_subnum" value=${a_subnum }>
			<img src="${a_link}" />
			<hr>
			<input class="btn btn-default" type="button" onclick="deleteNote()" value="삭제">
			<input class="btn btn-default" id="show" type="button" onclick="showAnswer()" value="정답 확인">

			<div id="answer" style="display:none">정답은 <img src="${answer_link}/${a_subnum}.PNG" />
			</div>
		</form>
	</div>
</body>
</html>