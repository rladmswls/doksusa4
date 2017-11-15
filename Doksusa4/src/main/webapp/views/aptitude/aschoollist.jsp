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
<h3>학교별 적성  리스트</h3>
<form action="aschool.do" method="get">
<div class="container">
	<table class="table" >

   <thead class="hd">
   <tr>
      <th id="a_num">글번호</th>
      <th id="a_year">년도</th>
      <th id="a_school">학교</th>
      <th id="a_title">제목</th>
      <th id="a_link">문제PDF</th>
      <th id="a_answer">답지PDF</th>
   </tr>
   </thead>
  <c:set var="num" value="0"></c:set> 
   <c:forEach var="list" items="${aschoollist}">
   <tbody>
      <tr>
         <td>${list.a_num}</td>
         <td>${list.a_year}</td>
         <td>${list.a_school}</td>
         <td>${list.a_title}</td>
         <td><a href="${list.a_link}"><img src="exams/pdf.png"/></a></td>
         <td><a href="${list.a_answer}"><img src="exams/pdf.png"/></a></td>
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