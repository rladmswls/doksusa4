<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doksusa</title>
<script>
	function deleteNote() {
		f.action = "e_deleteNote.do";
		f.submit();
	}

	function before() {

		$.ajax({
			url : "check_e_Before.do",
			data : $("#myfrm").serialize(),
			success : function(responsetext) {
				if (responsetext == "1") {
					alert("첫 페이지 입니다.");
				} else {
					f.action = "e_before.do";
					f.submit();
				}
			}
		});

	}
	function next() {
		$.ajax({
			url : "check_e_Next.do",
			data : $("#myfrm").serialize(),
			success : function(responsetext) {
				if (responsetext == "1") {
					alert("마지막 페이지 입니다.");
				} else {
					f.action = "e_next.do";
					f.submit();
				}
			}
		});
	}

	function goList() {
		f.action = "eu_wrongnote.do";
		f.submit();
	}

	function showAnswer() {
		$.ajax({
			url : "showE_Answer.do",
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
		<form id="myfrm" name="f" action="">
			<h1>♥${show_link } - ${e_subnum }번♥</h1>
			<input type="hidden" name="e_num" id="e_num" value=${e_num }>
			<input type="hidden" name="e_subnum" id="e_subnum" value=${e_subnum }>
			<img src="${e_link}" />
			<hr>
			<input class="btn btn-default" type="button"
				onclick="deleteNote()" value="삭제">
			<input class="btn btn-default" type="button" onclick="before()"
				value="◀이전">  <input
				class="btn btn-default" id="show" type="button"
				onclick="showAnswer()" value="정답 확인"> <input
				class="btn btn-default" type="button" onclick="next()" value="다음▶">
			<input class="btn btn-default" type="button" onclick="goList()"
				value="목록으로">
			<div id="answer" style="display: none">
				정답은 <img src="${answer_link}/${e_subnum}.PNG" />
			</div>
		</form>
	</div>
</body>
</html>