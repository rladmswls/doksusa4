<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
<h3>입시 사이트로 바로가기</h3>
<c:set var="num" value="0"></c:set>
   <c:forEach var="ipsi" items="${ipsiInfo}">
	<a href="${ipsi.link}">
      <img src="upload/${ipsi.logo}"/>		
	</a>
	<c:set var="num" value="${ num+1}"></c:set>
	<c:if test="${num%5==0}"><br></c:if>
   </c:forEach>
</body>
</html>