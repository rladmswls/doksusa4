<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<% 
    if (session.getAttribute("user") == null) {
        response.sendRedirect("home.do");
    }
%> 
<!DOCTYPE>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/exam.css">
</head>
<body>
<jsp:include page="../up.jsp" flush="false"/>
<div id="here">
<h3>과목별 모의고사  리스트</h3>
<form action="egrade.do">
<label class="radio-inline"><input type="radio" name="e_grade" value="1">고1</label>
<label class="radio-inline"><input type="radio" name="e_grade" value="2">고2</label>
<label class="radio-inline"><input type="radio" name="e_grade" value="3" checked="checked">고3</label> 
<input type="submit" value="선택" class="btn btn-outline-dark">
</form>
<form action="esubject.do" method="get">
<div class="container">
	<table class="table" >
   <thead class="hd">
   <tr>
      <th id="e_num">글번호</th>
      <th id="e_year">년도</th>
      <th id="e_grade">학년</th>
      <th id="e_subject">과목</th>
      <th id="e_link">문제PDF</th>
      <th id="e_answer">답지PDF</th>
      <th id="e_solution">해설PDF</th>
       <c:choose>
			<c:when test="${sessionScope.u_id == 'dok'}">
				 <th>수정</th>
				 <th>삭제</th>
			</c:when>
		</c:choose>
   </tr>
   </thead>
  <c:set var="num" value="0"></c:set> 
   <c:forEach var="list" items="${esubjectlist}">
   <tbody>
      <tr>
         <td>${list.e_num}</td>
         <td>${list.e_year}</td>
         <td>${list.e_grade}</td>
         <td>${list.e_subject}</td>
         <td><a href="${list.e_link}"><img src="exams/pdf.png"/></a></td>
         <td><a href="${list.e_answer}"><img src="exams/pdf.png"/></a></td>
         <td><a href="${list.e_solution}"><img src="exams/pdf.png"/></a></td>
         <c:choose>
			<c:when test="${sessionScope.u_id == 'dok'}">
				<td><input type="button" onclick="e_update.do" value="수정"></td>
				<td><input type="button" onclick="e_delete.do" value="삭제"></td>
				<td></td>
			</c:when>
		</c:choose>
      </tr>
   <c:set var="num" value="${num+1}"></c:set>
	<c:if test="${num%5==0}"><br></c:if> 
   </c:forEach>
</table>	
</div>
</form>
</div>

</body>
</html>