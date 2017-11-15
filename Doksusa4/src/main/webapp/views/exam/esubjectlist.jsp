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
<h3>과목별 모의고사  리스트</h3>
<form action="esubject.do" method="get">
<div class="container">
	<table class="table" >

   <thead class="hd">
   <tr>
      <th id="e_num">글번호</th>
      <th id="e_title">제목</th>
      <th id="e_year">년도</th>
      <th id="e_subject">과목</th>
      <th id="e_subnum">학년</th>
      <th id="e_answer">답안</th>
   </tr>
   </thead>
  <c:set var="num" value="0"></c:set> 
   <c:forEach var="list" items="${esubjectlist}">
   <tbody>
      <tr>
         <td>${list.e_num}</td>
         <td><a href="${list.e_link}">${list.e_title}</a></td>
         <td>${list.e_year}</td>
         <td>${list.e_subject}</td>
         <td>${list.e_subnum}</td>
         <td><a href="${list.e_answer}"><img src="exams/pdf.png"/></a></td>
      </tr>
      
   <c:set var="num" value="${ num+1}"></c:set>
	<c:if test="${num%5==0}"><br></c:if> 
   </c:forEach>
</table>	
</div>
</form>
</div>

</body>
</html>