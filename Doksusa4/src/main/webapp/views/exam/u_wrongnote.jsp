<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
						<c:forEach var="ewdto" items="${e_list}">
							<tr>
								<td><a
									href="showE_wrong.do?e_num=${ewdto.e_num}&e_subnum=${ewdto.e_subnum}">${ewdto.e_link }:
										${ewdto.e_subnum }번</a></td>
							</tr>
						</c:forEach>
					</tr>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>