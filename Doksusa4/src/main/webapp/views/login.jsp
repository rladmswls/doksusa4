<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<title>doksusa</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	function checkIDPW() {
		//alert($("#myfrm").serialize());
		$.ajax({
			url : "checkIDPW.do",
			data : $("#myfrm").serialize(),
			success : function(responsetext) {
				if (responsetext == "0") {
					alert("잘못 입력하셨습니다.");
					//f.u_id.value = "";
					$("#u_id").val("");
					$("#u_pw").val("");

				} else {
					f.action = "login.do";
					f.method = "post";
					f.submit();
				}
			}

		});

	}
	
	function searchID() {
		f.action = "searchID.do";
		f.method = "get";
		f.submit();
	}
	function searchPW() {
		f.action = "searchPW.do";
		f.method = "get";
		f.submit();
	}
</script>
</head>
<body>
	<jsp:include page="up.jsp" flush="false" />
	<div id="here">
		<h3>로그인</h3>
		<form id="myfrm" name="f" action="" method="post">
			<input type="text" name="u_id" id="u_id" placeholder="아이디 입력"><br>
			<input type="password" name="u_pw" id="u_pw" placeholder="비밀번호 입력"><br>
			<button class="btn" onclick="checkIDPW()" id="login1">로그인</button>
			<button class="btn" onclick="searchID()" id="login2">아이디 찾기</button>
			<button class="btn" onclick="searchPW()" id="login3">비밀번호 찾기</button>
		</form>
	</div>
</body>
</html>