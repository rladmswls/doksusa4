<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
	function checka_Wrong() {
		alert($("#myfrm").serialize());
		$.ajax({
			url : "a_checkWrong.do",
			data : $("#myfrm").serialize(),
			success : function(responsetext) {
				alert("aaaaaa");
				if (responsetext == "1") {
					alert("이미 문제가 등록되어 있습니다");
					$("input[type='checkbox']").prop("checked",false);

				} else {
					f.action = "a_wrongnote.do";
					f.submit();
				}
			}

		});

	}
</script>
</head>
<body>
<jsp:include page="../up.jsp" flush="false"/>
<div id="here">
<h3>오답노트등록</h3>
(오답노트에 등록하고 싶은 번호를 선택하세요.)<br>
<hr>
<form id="myfrm" name="f" action="" method="post">
<input type="hidden" id="a_num" name="a_num" value=${param.a_num }>
<input type="hidden" id="u_num" name="u_num" value=${sessionScope.u_num }>
	<c:set var ="num" value="0"></c:set>
	<c:forEach var="num" begin="1" end="${end }">
		${num } <input type="checkbox" name="a_subnum" id="${a_subnum }" value="${num }">
		<c:if test="${num%5==0 }"><br></c:if>
	</c:forEach>
	<input type="button" value="제출"  onclick="checka_Wrong()">
</form>
</div>
</body>
</html>