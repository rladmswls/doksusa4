<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Doksusa</title>
<link rel="stylesheet" type="text/css" href="css/exam.css">
</head>
<body>
<jsp:include page="../up.jsp" flush="false"/>
<div id="here">
<form action="updateCommunity.do" method="post">
<h3>게시글 수정하기</h3>
	말머리 :
	<select name="f_foreword">
        <c:forEach var="foreword" items="${foreword}">
            <option value="${foreword.f_foreword}">${foreword.f_foreword}</option>
        </c:forEach>
    </select>
	제목 :
	<input type="text" name="c_title" id="c_title"  value="${cdto.c_title}"><br><br>
	<input type="hidden" name="c_num" id="c_num" value="${cdto.c_num }">
	<input type="hidden" name="u_num" id="u_num" value="${cdto.u_num }">
	<input type="hidden" name="c_group" id="c_group" value="${cdto.c_group}">
	<textarea rows="10" cols="100" name="c_content" id="c_content">${cdto.c_content}</textarea><br><br>
	<input type="hidden" name="c_date" id="c_date" value="${cdto.c_date}">
	<input class="btn btn-default" type="submit" value="수정완료">
</form>
</div>
</body>
</html>