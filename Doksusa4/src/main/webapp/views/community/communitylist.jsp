<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/exam.css">
</head>
<body>
	<jsp:include page="../up.jsp" flush="false" />
	<div id="here">
		<c:if test="${c_group=='1'}">
		<h3>공지사항</h3></c:if>
		<c:if test="${c_group=='2'}">
		<h3>고1&고2 커뮤니티</h3></c:if>
		<c:if test="${c_group=='3'}">
		<h3>고3 커뮤니티</h3></c:if>
		<c:if test="${c_group=='4'}">
		<h3>N수생 커뮤니티</h3></c:if>
		
		<form action="searchforeword.do" >
        <input type="hidden" name="c_group" id="c_group" value="${c_group}">
      	말머리 :
	<select name="f_foreword">
        <c:forEach var="foreword" items="${foreword}">
            <option value="${foreword.f_foreword}">${foreword.f_foreword}</option>
        </c:forEach>
    </select>
    <input type="submit" value="검색">
    </form>
    
    

		<div class="container">
			<table class="table">
				<thead class="hd">
					<tr>
						<th id="c_num">글번호</th>
						<th id="f_foreword">머리말</th>
						<th id="c_title">제목</th>
						<th id="c_date">날짜</th>
						<th id="u_nick">작성자</th>
					</tr>
				</thead>
				<tr>

					<c:set var="num" value="0"></c:set>
					<c:forEach var="comuserdto" items="${list}">

						<tr>
							<td>${comuserdto.c_num}</td>
							<td>${comuserdto.f_foreword}</td>
							<td><a href="communityview.do?c_num=${comuserdto.c_num}"
								class=notice>${comuserdto.c_title}</a></td>
							<td>${comuserdto.c_date}</td>
							<td>${comuserdto.u_nick}</td>
						</tr>
					</c:forEach>
				
			</table>
		</div>
		<c:choose>
			<c:when test="${sessionScope.u_id == 'dok'}" >
				<form action="communityinsert.do">
				<input type="hidden" name="c_group" value="1">
					<input type="submit" value="등록">
				</form>
		 </c:when>
		 <c:otherwise>
		 <c:if test="${c_group !='1'}">
		<form action="communityinsert.do">
					<input type="submit" value="등록">
					<input type="hidden" name="c_group" id="c_group" value="${c_group}">
				</form>
		 
		 </c:if>
		 </c:otherwise>
		</c:choose>
		
			<form action="searchlist.do">
			<div class="container">
      <div class="btn-group" data-toggle="buttons">
          <input type="radio"  name="search" value="1">제목
    
          <input type="radio" name="search" value="2">작성자
          <input type="radio" name="search" value="3">내용
      </div>
      <input type="text" name="search_content" id="search_content">
      <input type="hidden" name="c_group" value="${c_group}"> 
   
      <input type="submit" value="검색" class="button1">
      

      
   </div>
</form>
		
		
	</div>
</body>
</html>