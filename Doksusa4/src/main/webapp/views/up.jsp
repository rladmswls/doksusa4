<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>doksusa</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="resources/jquery-3.2.1.min.js"></script>
</head>
<body>
	<header>
		<h1>독하게 수능준비하는 사람들</h1>
	</header>
	<c:choose>
			<c:when test="${sessionScope.user == null}">
				<div>==로그인 후 이용해 주세요==</div>
			</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li class="active"><a href="home.do">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">모의고사<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="esubject.do?e_subject=언어">언어</a></li>
						<li><a href="esubject.do?e_subject=수리-가형">수리-가형</a></li>
						<li><a href="esubject.do?e_subject=수리-나형">수리-나형</a></li>
						<li><a href="esubject.do?e_subject=외국어">외국어</a></li>
						<li><a href="esubject.do?e_subject=한국사">한국사</a></li>
						<li><a href="esubject.do?e_subject=사탐">사탐</a></li>
						<li><a href="esubject.do?e_subject=과탐">과탐</a></li>
						<c:choose>
							<c:when test="${sessionScope.u_id == 'dok'}">
								<li><a href="e_insert.do">등록</a></li>
							</c:when>
						</c:choose>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">적성<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="aschool.do?a_school=고대세종">고대세종</a></li>
						<li><a href="aschool.do?a_school=홍익대">홍익대</a></li>
						<li><a href="aschool.do?a_school=한신대">한신대</a></li>
						<li><a href="aschool.do?a_school=가천대">가천대</a></li>
						<li><a href="aschool.do?a_school=수원대">수원대</a></li>
						<li><a href="aschool.do?a_school=을지대">을지대</a></li>
						<c:choose>
                     <c:when test="${sessionScope.u_id == 'dok'}">
                        <li><a href="a_insert.do">등록</a></li>
                     </c:when>
                  </c:choose>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">커뮤니티<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="noticelist.do">공지사항</a></li>
						<li><a href="onetwolist.do">고1 + 고2</a></li>
						<li><a href="threelist.do">고3</a></li>
						<li><a href="relist.do">N수생</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">마이페이지<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="u_wrongnote.do">오답 노트</a></li>
						<li><a href="check.do">개인정보수정</a></li>
					</ul></li>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<li><c:choose>
					<c:when test="${sessionScope.user == null}">
						<a href="join.do"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
				</li>
				<li><c:choose>
					<c:when test="${sessionScope.user == null}">
						<a href="login.do"><span class="glyphicon glyphicon-log-in"></span>
							Login</a>
					</c:when>
					<c:otherwise>
						<a href="logout.do"><span class="glyphicon glyphicon-log-out"></span>
						  ${user.u_nick}님 Logout</a>
					</c:otherwise>
				</c:choose>
				</li>
			</ul>
		</div>
	</nav>
</body>
</html>
