<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>과목별 모의고사  리스트</h3>

<form action="esubject.do" method="post">
	<table>
   <tr>
      <th id="e_num">글번호</th>
      <th id="e_title">제목</th>
      <th id="e_year">년도</th>
      <th id="e_subject">과목</th>
      <th id="e_subnum">학년</th>
      <th id="e_answer">답안</th>
      
   </tr>
   <tr>
   <c:forEach var="esubjectlist" items="${esubjectlist}">
      <tr>
         <td>${esubjectlist.e_num }</td>
         <td><a href="${esubjectlist.e_link}" class=examview>${esubjectlist.title}</a></td>
         <td>${esubjectlist.e_year }</td>
         <td>${esubjectlist.e_subject }</td>
         <td>${esubjectlist.e_subnum }</td>
         <td><a href="${esubjectlist.e_answer}" class=examanswer><img src="exams/pdf.png"/></a></td>
      </tr>
   </c:forEach>
   </tr>
</table>	
	
	
	
</form>


</body>
</html>