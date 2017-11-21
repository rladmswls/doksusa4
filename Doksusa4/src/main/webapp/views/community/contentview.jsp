<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("home.do");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/exam.css">
<script>
function deleteCommunity(){
	f.action="deleteCommunity.do";
	f.submit();
}
function updateCommunity(){
	f.action="updateCommunity.do";
	f.submit();
}
</script>
</head>
<body>
<jsp:include page="../up.jsp" flush="false"/>
<div id="here">

<h3>${communityuserdto.f_foreword } ${communityuserdto.c_title }</h3>
<h6>${communityuserdto.u_nick}</h6>
<h6>${communityuserdto.c_date}</h6>

<hr>
<textarea rows="20" cols="100">${communityuserdto.c_content }</textarea>
	<c:choose>
		<c:when test="${sessionScope.u_num == communityuserdto.u_num}">
			<form name="f" action="">
				<input type="hidden" name="c_num" id="c_num" value="${communityuserdto.c_num}">
				<input type="hidden" name="c_group" id="c_group" value="${communityuserdto.c_group}">
				<input type="button" onclick = "updateCommunity()" value="수정하기">
				<input type="button" onclick = "deleteCommunity()" value="삭제하기">
			</form>
		</c:when>
	</c:choose>
</div>
</body>
</html>