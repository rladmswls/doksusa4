<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>doksusa</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
</script>
</head>
<body style="height: 1500px">
	<header>
		<h1>독하게 수능준비하는 사람들</h1>
	</header>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">모의고사<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Page 1-1</a></li>
							<li><a href="#">Page 1-2</a></li>
							<li><a href="#">Page 1-3</a></li>
						</ul>
				</li>
				<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">적성<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Page 1-1</a></li>
							<li><a href="#">Page 1-2</a></li>
							<li><a href="#">Page 1-3</a></li>
						</ul>
				</li>
				<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">커뮤니티<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">공지사항</a></li>
							<li><a href="#">고1 + 고2</a></li>
							<li><a href="#">고3</a></li>
							<li><a href="#">재수생</a></li>
						</ul>
				</li>
				<li><a href="#">마이페이지</a></li>
			</ul>
			 <ul class="nav navbar-nav navbar-right">
    			<li><a href="join.do"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      			<li><a href="login.do"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    		</ul>
		</div>
	</nav>

	<section>
		<div id="here"></div>
	</section>
	
	<div id="footer">
		<p>&copy; Doksusa</p>
	</div>
</body>
</html>
