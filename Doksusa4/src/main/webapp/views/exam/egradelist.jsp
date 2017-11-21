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
<h3>고${e_grade } 모의고사  리스트</h3>
<form action="egrade.do">
<label class="radio-inline"><input type="radio" name="e_grade" value="1">고1</label>
<label class="radio-inline"><input type="radio" name="e_grade" value="2">고2</label>
<label class="radio-inline"><input type="radio" name="e_grade" value="3">고3</label>
<input type="hidden" name="e_subject" value="${e_subject}"> 
<input type="submit" value="선택" class="btn btn-outline-dark">
</form>
<form action="e_delete2.do">
<div class="container">
<table class="table">
   <thead class="hd">
   <tr>
      <th id="e_num">글번호</th>
      <th id="e_year">년도</th>
      <th id="e_grade">학년</th>
      <th id="e_subject">과목</th>
      <th id="e_link">문제PDF</th>
      <th id="e_answer">답지PDF</th>
      <th id="e_solution">해설PDF</th>
     <th>오답노트등록</th>
       <c:choose>
			<c:when test="${sessionScope.u_id == 'dok'}">
				 <th>삭제</th>
			</c:when>
		</c:choose>
   </tr>
   </thead>
 	<c:set var="num" value="0"></c:set> 
   <c:forEach var="list" items="${egradelist}">
   <tbody>
      <tr>
         <td><input type="hidden" name="e_num" value="${list.e_num}">${list.e_num}</td>
         <td>${list.e_year}</td>
         <c:if test="${num==0}"><input type="hidden" name="e_grade" value="${list.e_grade}"></c:if>
         <c:if test="${num==0}"><input type="hidden" name="e_subject" value="${list.e_subject}"></c:if>
         <td>${list.e_grade}</td>
         <td><input type="hidden" name="e_subject" value="${list.e_subject}">${list.e_subject}</td>
         <td><a href="${list.e_link}"><img src="exams/pdf.png"/></a></td>
         <td><a href="${list.e_answer}"><img src="exams/pdf.png"/></a></td>
         <td><a href="${list.e_solution}"><img src="exams/pdf.png"/></a></td>
         <td><a href="wrongnote.do">오답노트</a></td>
         <c:choose>
			<c:when test="${sessionScope.u_id == 'dok'}">
				<td><input type="submit" value="삭제"></td>
			</c:when>
		</c:choose>
      </tr>
   </tbody>
   <c:set var="num" value="${num+1}"></c:set>
	<c:if test="${num%5==0}"><br></c:if> 
   </c:forEach>
</table>	
</div>
</form>
</div>

</body>
</html>