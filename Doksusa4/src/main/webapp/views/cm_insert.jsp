<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>공지사항 등록</h3>
<hr>
<form action="cm_insert.do" method="post">
	말머리 :
	<select name="foreword">
        <c:forEach var="foreword" items="${foreword}">
            <option value="${foreword.f_foreword}">${foreword.f_foreword}</option>
        </c:forEach>
    </select><br>  
	제목 :
	<input type="text" name="title" id="title"><br><br>
	<textarea rows="10" cols="100" name="c_content" id="c_content"></textarea>
	<input type="submit" value="저장">
</form>
</body>
</html>