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
<h3>공지사항 등록</h3>
<hr>
<form action="noticeinsert.do" method="post">
	<h5>말머리 :</h5>
	<select class="btn btn-default" name="f_foreword">
        <c:forEach var="foreword" items="${foreword}">
            <option value="${foreword.f_foreword}">${foreword.f_foreword}</option>
        </c:forEach>
    </select>
	<h5>제목 :</h5>
	<input class="btn btn-default" type="text" name="c_title" id="c_title"><br><br>
	<input type="hidden" name="u_num" id="u_num" value="${user.u_num }">
	<textarea class="btn btn-default" rows="10" cols="100" name="c_content" id="c_content"></textarea><br><br>
	<input class="btn btn-default" type="submit" value="저장">
</form>
</div>
</body>
</html>









</body>
</html>