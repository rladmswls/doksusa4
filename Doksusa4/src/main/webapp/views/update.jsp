<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doksusa</title>
<script>
	var check_id = false;
	var check_nick = false;
	var check_phone = false;

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
					$("#nickCheck").val("체크완료");
				}
			}

		});

	}
	function goJoin() {
	
		if("${user.u_nick}"==u_nick.value){
			
			check_nick=true;
		}
		if("${user.u_phone}"==u_phone.value){
			check_phone=true;
		}
		
		if (check_nick && check_phone) {
			f.action = "update.do";
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
					$("#phoneCheck").val("체크완료");

				}
			}
		});
	}
</script>
</head>
<body>
	<jsp:include page="up.jsp" flush="false" />
	<div id="here">
		<h3>회원정보 수정</h3>
		<form  id="myfrm" name="f" action="" method="POST">
			<table align="center">
				<tr>
					<th>비밀번호</th>
					<td><input class="btn btn-default" type="password" name="u_pw"
						value="${user.u_pw}"></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input class="btn btn-default" type="text" id="u_nick"
						name="u_nick" value="${user.u_nick}"></td>
					<td><input class="btn btn-default" type="button"
						name="nickCheck" id="nickCheck" onclick="checkNick()"
						value="중복체크 "></td>
				</tr>

				<tr>
					<th>전화번호</th>
					<td><input class="btn btn-default" type="text" maxlength="11" name="u_phone"
						id="u_phone" value="${user.u_phone}"></td>
					<td><input class="btn btn-default" type="button"
						onclick="checkPhone()" value="중복체크 "></td>
				</tr>

			</table>
			<input type="hidden" name="u_num" id="u_num"
				value="${sessionScope.u_num}"> <input type="hidden"
				name="u_id" id="u_id" value="${sessionScope.u_id}"> <input
				class="btn btn-default" type="button" onclick="goJoin()" value="저장">
		</form>
		<hr>
		<form action="delete.do">
			<input class="btn btn-default" type="submit" value="탈퇴">
		</form>
	</div>
</body>
</html>