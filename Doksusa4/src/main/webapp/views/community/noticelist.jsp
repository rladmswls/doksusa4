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
</head>
<body>
	<jsp:include page="../up.jsp" flush="false" />
	<div id="here">
		<h3>공지사항</h3>
		<form action="noticelist.do" method="get">
			<div class="container">
				<table class="table">
					<thead class="hd">
						<tr>
							<th id="c_num">글번호</th>
							<th id="f_foreword">머리말</th>
							<th id="c_title">제목</th>
							<th id="c_date">날짜</th>
							<th id="u_nick">작성자</th>
						</tr>
					</thead>
					<tr>

						<c:set var="num" value="0"></c:set>
						<c:forEach var="list" items="${noticelist}">
							<tr>
								<td>${list.c_num}</td>
								<td>${list.f_foreword}</td>
								<td><a href="communityview.do?c_num=${list.c_num}"
									class=notice>${list.c_title}</a></td>
								<td>${noticelist.c_date}</td>
								<td>${noticelist.u_nick}</td>
							</tr>
						</c:forEach>
					</tr>
				</table>
			</div>

		</form>

		<c:choose>
			<c:when test="${sessionScope.u_id == 'dok'}">
				<form action="noticeinsert.do">
					<input type="submit" value="등록">
				</form>
			</c:when>
		</c:choose>
	</div>
</body>
</html>