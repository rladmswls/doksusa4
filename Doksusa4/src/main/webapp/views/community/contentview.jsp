<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Doksusa</title>
<link rel="stylesheet" type="text/css" href="css/exam.css">
<link
	href="//bootswatch.com/sandstone/"
	rel="stylesheet">
<script>
	function deleteCommunity() {
		f.action = "deleteCommunity.do";
		f.submit();
	}
	function updateCommunity() {
		f.action = "updateCommunity.do";
		f.submit();
	}

	function deleteComment() {
		cf.action = "deleteComment.do";
		cf.method = "post";
 		cf.submit();
	}
	function updateComment() {
		cf.action = "updateComment.do";
		cf.method = "post";
		cf.submit();
	}
</script>
</head>
<body>
	<jsp:include page="../up.jsp" flush="false" />
	<div id="here">

		<h3>${communityuserdto.f_foreword }${communityuserdto.c_title }</h3>
		<h5>${communityuserdto.u_nick}</h5><br>
		<h5>${communityuserdto.c_date}</h5>

		<hr>
		<pre>${communityuserdto.c_content }</pre>
		
		<c:choose>
			<c:when test="${sessionScope.u_num == communityuserdto.u_num}">
				<form name="f" action="">
					<input type="hidden" name="c_num" id="c_num"
						value="${communityuserdto.c_num}"> <input type="hidden"
						name="c_group" id="c_group" value="${communityuserdto.c_group}">
					<input class="btn btn-default" type="button" onclick="updateCommunity()" value="수정하기">
					<input class="btn btn-default" type="button" onclick="deleteCommunity()" value="삭제하기">
				</form>
			</c:when>
		</c:choose>

		<br>
		<hr>
		<br>
<br>
<br>
<br>
<form name="cf" action="">
	<div>
		<table class="table">
			<thead>
				<tr>
					<th id="ct_comment">댓글</th>
					<th id="u_nick">댓글작성자</th>
					<th id="ct_date">작성날짜</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="commentlist" items="${commentuserlist}">
						<tr>
							<c:choose>
								<c:when test="${sessionScope.u_num == commentlist.ctu_num}">
									<td><input class="btn btn-default btn-sm" type="text" name="ct_comment" id="ct_comment" value="${commentlist.ct_comment}"></td>
								</c:when>
								<c:otherwise>
									<td>${commentlist.ct_comment}</td>
								</c:otherwise>
							</c:choose>
							<td>${commentlist.u_nick}</td>
							<td>${commentlist.ct_date}</td>
							<c:choose>
									<c:when test="${sessionScope.u_num == commentlist.ctu_num}">
											<input type="hidden" name="ct_num" id="ct_num" value="${commentlist.ct_num}" > 
											<input type="hidden" name="c_num" id="c_num" value="${communityuserdto.c_num}">
											<input type="hidden" name="ctu_num" id="ctu_num" value="${commentlist.ctu_num}">
											<input type="hidden" name="ct_date" id="ct_date" value="${commentlist.ct_date}">
											<td><input  class="btn btn-default btn-sm" type="button" onclick="updateComment()" value="수정"></td>
											<td><input  class="btn btn-default btn-sm" type="button" onclick="deleteComment()" value="삭제"></td>
									</c:when>
							</c:choose>
						</tr>
					</c:forEach>
				</tr>
			</tbody>
		</table>
		</div>
</form>
		<form action="commentinsert.do" method="post">
			<input type="hidden" name="c_num" id="c_num" value="${communityuserdto.c_num}"> 
			<input type="hidden" name="ctu_num" id="ctu_num" value="${sessionScope.u_num}"> 
			<input type="text" name="ct_comment" id="ct_comment"> 
			<input class="btn btn-default" type="submit" value="댓글 작성">
		</form>

	</div>
</body>
</html>