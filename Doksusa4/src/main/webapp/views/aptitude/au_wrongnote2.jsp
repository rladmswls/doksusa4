<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doksusa</title>
<link rel="stylesheet" type="text/css" href="css/exam.css">
<script>
	function a_school() {
		var a_school = document.getElementById("a_school").value;
		if (a_school == "전체보기") {
			location.href = "au_wrongnote.do"
		} else {
			location.href = "au_wrongnote2.do?a_school=" + a_school;
		}
	}
</script>
</head>
<body>
	<jsp:include page="../up.jsp" flush="false" />
	<div id="here">
		<h3>오답 노트</h3>

		<div class="container">

			<table class="table">
				<thead class="hd">
					<tr>
						<th>오답번호</th>
					</tr>
				</thead>
				<tbody>


					<tr>
						<c:forEach var="a_dto" items="${a_list}">
							<tr>
								<td><a
									href="showA_wrong.do?a_num=${a_dto.a_num}&a_subnum=${a_dto.a_subnum}">${a_dto.a_link } : ${a_dto.a_subnum }번</a></td>
							</tr>
						</c:forEach>
					</tr>
				</tbody>
			</table>
			
			
			<select onchange="a_school()" class="btn btn-default" id="a_school">
				<option>----</option>
				<option value="전체보기">전체보기</option>
				<c:forEach var="a_school_list" items="${a_school_list}">
					<option value="${a_school_list }">${a_school_list }</option>
				</c:forEach>
			</select> 
			
		</div>
	</div>
</body>
</html>
