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
<form method="post" action="searchPW.do">
      <h3>�н����� ã��</h3>
      <input type="text" name="u_id" placeholder="���̵� �Է�"><br>
      <input type="text" name="u_nick" placeholder="�г��� �Է�"><br>
       <input type="tel" name="u_phone" placeholder="��ȭ��ȣ�Է�"><br>
      <input type="submit" value="�н����� ã��">
   </form>
   </div>
</body>
</html>