<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="up.jsp" flush="false"/>
<div id="here">
<form name="f" method="post" action="">
      <h3>�н����� ã��</h3>
      <input type="text" name="u_id" placeholder="���̵� �Է�"><br>
      <input type="password" name="u_pw" placeholder="��й�ȣ �Է�"><br>
      <button class="btn" onclick="login()" id="login">�α���</button>
      <button class="btn" onclick="searchID()" id="login">���̵� ã��</button>
      <button class="btn" onclick="searchPW()" id="login">��й�ȣ ã��</button>
   </form>
   </div>
</body>
</html>