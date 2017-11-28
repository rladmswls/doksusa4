<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doksusa</title>
</head>
<body>
<jsp:include page="../up.jsp" flush="false"/>
<div id="here">
<h3>적성고사 등록</h3>
<form action="a_insert.do" method="post">
   연도<input type="number" min="1996" max="2018" value="2018" name="a_year"><br>
   학교<select name="a_school">
      <option>----</option>
      <option value="고대세종">고대세종</option>
      <option value="홍익대">홍익대</option>
      <option value="한신대">한신대</option>
      <option value="가천대">가천대</option>
      <option value="수원대">수원대</option>
      <option value="강남대">강남대</option>
      <option value="을지대">을지대</option>
   </select><br>
제목<input type="text" name="a_title" id="a_title"><br>
   <%-- <input type="hidden" name="u_num" id="u_num" value="${aptitude.a_num }"><br> --%>
   문제링크<input type="text" name="a_link"><br>
   답지링크<input type="text" name="a_answer"><br><br>
   <input class="btn btn-default" type="submit" value="등록"> 
</form>
</div>
</body>
</html>