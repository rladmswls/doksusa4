<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doksusa</title>
<link rel="stylesheet" type="text/css" href="css/exam.css">
<link href="//bootswatch.com/sandstone/" rel="stylesheet">
<script>
	function deleteCommunity() {
		f.action = "deleteCommunity.do";
		f.submit();
	}
	function updateCommunity() {
		f.action = "updateCommunity.do";
		f.submit();
	}

	function deleteComment(ct_num) {
		location.href = "deleteComment.do?ct_num3="+ct_num;

	}
	function updateComment(ct_num,cnt ) {
		location.href = "updateComment.do?ct_num2="+ct_num+"&ct_comment="+ct_comment[cnt].value;

	}
	
	function before2() {
		var param={};
		param.c_num = $("#c_num2").val();
		param.c_group = $("#c_group").val();
		
		console.log(param.c_num);
		console.log(param.c_group);
		$.ajax({
			url : "check_c_Before.do",
			//data : $("#myfrm").serialize(),
			//data : {"c_num":$("#c_num2").val(),"c_group":$("#c_group").val()},
			data: param,	
			success : function(responsetext) {
				if (responsetext == "1") {
					alert("첫 페이지 입니다.");
				} else {
					location.href = "c_before.do?c_num2="+$("#c_num2").val()+"&c_group=" + $("#c_group").val();
					 
				}
			},
			fail: function(xhr){
				alert(xhr);
				}
		});

	}
	function next() {
		
		var param={};
		param.c_num = $("#c_num2").val();
		param.c_group = $("#c_group").val();
		
		console.log(param.c_num);
		console.log(param.c_group);
		$.ajax({
			url : "check_c_Next.do",
			//data : $("#myfrm").serialize(),
			//data : {"c_num":$("#c_num2").val(),"c_group":$("#c_group").val()},
			data: param,	
			success : function(responsetext) {
				if (responsetext == "1") {
					alert("마지막 페이지 입니다.");
				} else {
					location.href = "c_next.do?c_num2="+$("#c_num2").val()+"&c_group=" + $("#c_group").val();
					 
				}
			},
			fail: function(xhr){
				alert(xhr);
				}
		});
	
	}

	function goList() {
		ff.action = "communitylist.do";
		ff.submit();
	}
</script>
</head>
<body>
	<jsp:include page="../up.jsp" flush="false" />
	<div id="here">

		<h3>${communityuserdto.f_foreword }${communityuserdto.c_title }</h3>
		<h5>${communityuserdto.u_nick}</h5>
		<br>
		<h5>${communityuserdto.c_date}</h5>

		<hr>
		<pre>${communityuserdto.c_content }</pre>

		<c:choose>
			<c:when test="${sessionScope.u_num == communityuserdto.u_num}">
				<form name="f" action="">
					<input type="hidden" name="c_num" id="c_num"
						value="${communityuserdto.c_num}"> 
						<input type="hidden"
						name="c_group" id="c_group" value="${communityuserdto.c_group}">
					<input class="btn btn-default" type="button"
						onclick="updateCommunity()" value="수정하기"> <input
						class="btn btn-default" type="button" onclick="deleteCommunity()"
						value="삭제하기">
				</form>
			</c:when>
		</c:choose>

		<br>
		<hr>
		<br> <br> <br> <br>
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
							<c:set var="cnt" value="0" />
							<c:forEach var="commentlist" items="${commentuserlist}">
								<tr>
									<c:choose>
										<c:when test="${sessionScope.u_num == commentlist.ctu_num}">
											<c:set var="cnt" value="${cnt+1 }" />
											<td>
											<textarea cols="40" rows="1" name="ct_comment" id="ct_comment">${commentlist.ct_comment}</textarea>
											 <i
												style="cursor: pointer"
												onclick="updateComment(${commentlist.ct_num},${cnt})"
												class="glyphicon glyphicon-pencil"></i> <i
												style="cursor: pointer"
												onclick="deleteComment(${commentlist.ct_num})"
												class="glyphicon glyphicon-remove"></i></td>
											<input type="hidden" name="ct_num" id="ct_num"
												value="${commentlist.ct_num}">
											<input type="hidden" name="c_num" id="c_num"
												value="${communityuserdto.c_num}">
											<input type="hidden" name="ctu_num" id="ctu_num"
												value="${commentlist.ctu_num}">
											<input type="hidden" name="ct_date" id="ct_date"
												value="${commentlist.ct_date}">
										</c:when>
										<c:otherwise>
											<td>${commentlist.ct_comment}</td>
										</c:otherwise>
									</c:choose>
									<td>${commentlist.u_nick}</td>
									<td>${commentlist.ct_date}</td>
								</tr>
							</c:forEach>

						</tr>
					</tbody>
				</table>
			</div>
		</form>
		<form action="commentinsert.do" method="post">
			<input type="hidden" name="c_num" id="c_num"
				value="${communityuserdto.c_num}"> <input type="hidden"
				name="ctu_num" id="ctu_num" value="${sessionScope.u_num}"> <input
				type="text" name="ct_comment" id="ct_comment"
				class="btn btn-default"> <input class="btn btn-default"
				type="submit" value="댓글 작성">
		</form>

		<form id="myfrm" name="ff" action="">
			<hr>
			<input type="hidden" name="c_group" id="c_group" value="${communityuserdto.c_group}">
			<input type="hidden" name="c_num2" id="c_num2" value="${communityuserdto.c_num}">
		
		
			<input class="btn btn-default" type="button" onclick="before2()" value="◀이전"> 
				<input class="btn btn-default"
				type="button" onclick="goList()" value="목록으로">
				<input class="btn btn-default" type="button"
				onclick="next()" value="다음▶"> 
				
		</form>

	</div>
</body>
</html>