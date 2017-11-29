<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Doksusa</title>
<script>
	var check_id = false;
	var check_nick = false;
	var check_phone = false;
	function checkID() {
		//alert($("#myfrm").serialize());
		$.ajax({
			url : "checkID.do",
			data : $("#myfrm").serialize(),
			success : function(responsetext) {
				if (responsetext == "1") {
					alert("이미 존재하는 아이디입니다.");
					//f.u_id.value = "";
					$("#u_id").val("");

				} else {
					check_id = true;
					alert("사용가능한 아이디입니다.");
				}
			}

		});

	}
	function checkNick() {
		//alert($("#myfrm").serialize());
		$.ajax({
			url : "checkNick.do",
			data : $("#myfrm").serialize(),
			success : function(responsetext) {
				if (responsetext == "1") {
					alert("이미 존재하는 닉네임입니다.");
					//f.u_id.value = "";
					$("#u_nick").val("");

				} else {
					check_nick = true;
					alert("사용가능한 닉네임입니다.");
				}
			}

		});

	}
	function goJoin() {
		if (check_id && check_nick && check_phone) {
			f.action = "join.do";
			f.submit();
		}else{
			alert("중복체크를 해주세요");
		}

	}
	function checkPhone() {
		$.ajax({
			url : "checkPhone.do",
			data : $("#myfrm").serialize(),
			success : function(responsetext) {
				if (responsetext == "1") {
					alert("이미 존재하는 전화번호입니다.");
					$("#u_phone").val("");

				} else {
					check_phone = true;
					alert("사용가능한 전화번호입니다.");
				}
			}
		});
	}
</script>
</head>
<body>
	<jsp:include page="up.jsp" flush="false" />
	<div id="here">
		<center>
			<h3>회원가입</h3>
			<div>
				<form id="myfrm" name="f" action="" method="post">
					<table>
						<tr>
							<td><input class="btn btn-default" type="text" name="u_id"
								id="u_id" placeholder="아이디를 입력하세요"></td>
							<td><input class="btn btn-default" type="button"
								onclick="checkID()" value="중복체크 "></td>
						</tr>
						<tr>
							<td><input class="btn btn-default" type="password"
								name="u_pw" placeholder="비밀번호를 입력하세요"></td>
						</tr>
						<tr>
							<td><input class="btn btn-default" type="text" id="u_nick"
								name="u_nick" placeholder="닉네임을 설정하세요"></td>
							<td><input class="btn btn-default" type="button"
								onclick="checkNick()" value="중복체크 "></td>
						</tr>
						<tr>
							<td><input class="btn btn-default" type="tel" name="u_phone"
								id="u_phone" placeholder="전번 입력하세요"></td>
							<td><input class="btn btn-default" type="button"
								onclick="checkPhone()" value="중복체크 "></td>
						</tr>
						<tr>
							<td><input class="btn btn-default" id="join" type="button"
								onclick="goJoin()" value="회원등록"> <input
								class="btn btn-default" type="reset" value="초기화"></td>
						</tr>
					</table>
				</form>
			</div>
		</center>
	</div>
</body>
</html>