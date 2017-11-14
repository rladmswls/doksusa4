<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="resources/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
<script>
$(document).ready(function(){
	 $("button").click(function(){
	        $("#here").load("cm_insert.do");
	    });
});
</script>
</head>
<body>
<h3>공지사항</h3>
<table class="table">
	<tr>
		<th id="c_num">번호</th>
		<th id="f_foreword">머리말</th>
		<th id="title">제목</th>
		<th id="day">날짜</th>
		<th id="u_nick">작성자</th>
	</tr>
	<tr>
	<c:forEach var="noticelist" items="${noticelist}">
		<tr>
			<td>${noticelist.c_num }</td>
			<td>${noticelist.f_foreword }</td>
			<td><a href="noticeview.do?c_num=${noticelist.c_num }" class=notice>${noticelist.title }</a></td>
			<td>${noticelist.day }</td>
			<td>${noticelist.u_nick }</td>
		</tr>
	</c:forEach>
	</tr>
</table>
<c:choose>
<c:when test="${sessionScope.u_id == 'dok'}">
	<button class="btn" id="if">등록</button></c:when>
</c:choose>
<div id="here"></div>
</body>
</html>