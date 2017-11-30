<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<jsp:include page="up.jsp" flush="false"/>
<div id="here">
	<h3>입시 사이트로 바로가기</h3>
	<c:set var="num" value="0"></c:set>
	   <c:forEach var="ipsi" items="${ipsiInfo}">
		<a href="#" onclick="window.open('${ipsi.link}')">
	      <img id="ipsi" src="upload/${ipsi.logo}"/>		
		</a>
		<c:set var="num" value="${ num+1}"></c:set>
		<c:if test="${num%5==0}"><br></c:if>
	   </c:forEach>
</div>
