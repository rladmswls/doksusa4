<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE>
<html>
<head>
<title>Doksusa</title>
<link rel="stylesheet" type="text/css" href="css/exam.css">
<script>
	function egrade() {
		var grade = document.getElementById("e_grade").value;
		location.href = "egrade.do?e_subject=${e_subject}&e_grade="+grade;
	}
</script>
</head>
<body>
<jsp:include page="../up.jsp" flush="false"/>
<div id="here">
<h3>${e_subject} 고${e_grade } 모의고사  리스트</h3>
<select  class="btn btn-default" onchange="egrade()" id="e_grade">
	<option>------</option>
	<option value="1">고1</option>
	<option value="2">고2</option>
	<option value="3">고3</option>
</select>
<br><br>
<form action="e_delete2.do">
	<input type="hidden" name="e_num" value="${list.e_num}">
<div class="container">
<table class="table">
   <thead class="hd">
   <tr>
      <th id="e_year">년도</th>
      <th id="e_grade">학년</th>
      <th id="e_subject">과목</th>
      <th id="e_link">문제PDF</th>
      <th id="e_answer">답지PDF</th>
      <th id="e_solution">해설PDF</th>
     <th>오답노트등록</th>
   </tr>
   </thead>
 	<c:set var="num" value="0"></c:set> 
   <c:forEach var="list" items="${egradelist}">
   <tbody>
      <tr>
         	<input type="hidden" name="e_num" value="${list.e_num}">
         <td>${list.e_year}</td>
         <c:if test="${num==0}"><input type="hidden" name="e_grade" value="${list.e_grade}"></c:if>
         <c:if test="${num==0}"><input type="hidden" name="e_subject" value="${list.e_subject}"></c:if>
         <td>${list.e_grade}</td>
         <td>${list.e_subject}</td>
         <td><a href="${list.e_link}"><img src="exams/pdf.png"/></a></td>
         <td><a href="${list.e_answer}"><img src="exams/pdf.png"/></a></td>
         <td><a href="${list.e_solution}"><img src="exams/pdf.png"/></a></td>
         <td><a href="e_wrongnote.do">오답노트</a></td>
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