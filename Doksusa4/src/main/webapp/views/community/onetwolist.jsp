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
		<h3>고1&고2 커뮤니티</h3>

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
				<tbody>
				<tr>

					
					<c:forEach var="list" items="${u_nick_list}">

						<tr>
							<td>${list.c_num}</td>
							<td>${list.f_foreword}</td>
							<td><a href="communityview.do?c_num=${list.c_num}"
								class=notice>${list.c_title}</a></td>
							<td>${list.c_date}</td>
							<td>${list.u_nick}</td>
						</tr>
					</c:forEach>
				</tr>
			
				</tbody>
			</table>
		</div>
			
				<form action="communityinsert.do">
					<input type="submit" value="등록">
					<input type="hidden" name="c_group" id="c_group" value="${c_group}">
				</form>
		
	</div>
</body>
</html>