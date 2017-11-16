<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

</script>
</head>
<body>
<jsp:include page="up.jsp" flush="false"/>
<div id="here">
<h3>회원 탈퇴</h3>
정말 탈퇴하시겠습니까?
   <form name="f" action="delete.do" method="POST">
         <input type="radio"  name="yesOrno" onclick="go()" value="예">예
         <input type="radio"  name="yesOrno" onclick="go()" value="아니오">아니요<br>
         <input type="submit" value="확인">
   </form>
</div>
</body>
</html>