<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Doksusa</title>
</head>
<body>
<jsp:include page="up.jsp" flush="false"/>
<div id="here">
<form action="searchID.do" method="post" >
      <h3>���̵� ã��</h3>
      <input class="btn btn-default" type="tel" name="u_phone" placeholder="��ȭ��ȣ�Է�"><br>
      <input class="btn btn-default" type="submit" value="���̵� ã��">
   </form>
   </div>
</body>
</html>