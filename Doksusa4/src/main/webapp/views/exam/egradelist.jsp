<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
<jsp:include page="../up.jsp" flush="false"/>
<div id="here">
<h3>과목+학년별 모의고사  리스트</h3>
<form action="egrade.do" method="get">
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
   </tr>
   </thead>
  <c:set var="num" value="0"></c:set> 
   <c:forEach var="list" items="${egradelist}">
   <tbody>
      <tr>
         <td>${list.e_num}</td>
         <td>${list.e_year}</td>
         <td>${list.e_grade}</td>
         <td>${list.e_subject}</td>
         <td><a href="${list.e_link}"><img src="exams/pdf.png"/></a></td>
         <td><a href="${list.e_answer}"><img src="exams/pdf.png"/></a></td>
         <td><a href="${list.e_solution}"><img src="exams/pdf.png"/></a></td>
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