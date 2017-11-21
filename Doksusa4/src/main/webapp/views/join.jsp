<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
<script>
	function checkID(){
		//alert($("#myfrm").serialize());
		$.ajax({
			url:"checkID.do",
			data: $("#myfrm").serialize(),
			success:function(responsetext){
				if(responsetext=="1"){
					alert("이미 존재하는 아이디입니다.");
					//f.u_id.value = "";
					$("#u_id").val("");
					
				}else{
					alert("사용가능한 아이디입니다.");
				}
			}
			
		});
		 
	}
</script>
</head>
<body>
<jsp:include page="up.jsp" flush="false"/>
<div id="here">
<center>
<h3>회원가입</h3>
<div>
   <form id="myfrm" name="f" action="" method="post">
      <table>
         <tr>
            <td><input type="text"  name="u_id" id="u_id" placeholder="아이디를 입력하세요"></td>
            <td><input   type="button" onclick ="checkID()" value="중복체크 "></td>      
         </tr>
         <tr>
            <td><input type="password" name="u_pw" placeholder="비밀번호를 입력하세요"></td>
         </tr>
         <tr>
            <td><input type="text" name="u_nick" placeholder="닉네임을 설정하세요"></td>
         </tr>
         <tr>
            <td><input type="tel" name="u_phone"  placeholder="전번 입력하세요"></td>
         </tr>
         <tr>
            <td><input id="join" type="button" value="회원등록"><input type="reset" value="초기화"></td>
         </tr>
      </table>
   </form>
   </div>
</center>
</div>
</body>
</html>