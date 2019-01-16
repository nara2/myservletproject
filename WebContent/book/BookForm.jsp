<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
<style>
ul { padding: 0; }
li { list-style:none; }

label {
  float: left;
  text-align: right;
  width: 60px;
}
</style>
</head>
<body>
	<jsp:include page="/Header.jsp"/>
	<h1>도서 등록</h1>
	<form action='add.do' method='post'>
	책제목: <input type='text' name='bname'><br>
	저자: <input type='text' name='author'><br>
	가격: <input type='text' name='price'><br>
	수량: <input type='text' name='bcount'><br>
	image url: <input type='text' name='image'><br>
	<input type='submit' value='추가'>
	<input type='reset' value='취소'>
	</form>
	<!-- <jsp:include page="/Tail.jsp"/> -->
</body>
</html>
