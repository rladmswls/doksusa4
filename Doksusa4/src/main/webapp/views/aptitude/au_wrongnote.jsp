<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doksusa</title>
<link rel="stylesheet" type="text/css" href="css/exam.css">

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
<%-- 
			<c:set var="num" value="0"></c:set> 
			<select class="btn btn-default" name="e_subject">
				<option>----</option>
				<c:forEach var="a_dto" items="${a_list}">
					<c:if test="${num==0}"><option value="${a_dto.a_link }">${a_dto.a_link }</option></c:if>
				 <c:set var="num" value="${num+1}"></c:set>
				</c:forEach>
			</select> --%>
			
			
		</div>
	</div>
</body>
</html>
