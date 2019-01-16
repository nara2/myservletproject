<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 정보</title>
</head>
<body>
	<h1>도서 정보</h1>
	<form action='update.do' method='post'>
	번호: <input type='text' name='bno' value='${book.getBno()}' readonly><br>
	제목: <input type='text' name='bname' value='${book.getBname()}'><br>
	저자: <input type='text' name='author' value='${book.getAuthor()}'><br>
	날짜: ${book.getBdate()}<br>
	가격: <input type='text' name='price' value='${book.getPrice()}'><br>
	재고권수: <input type='text' name='bcount' value='${book.getBcount()}'><br>
	총액: <input type='text' name='bcount' value='${book.getTotalprice()}' readonly><br>
	image: <img src='${book.getImage()}' width='30px' height='30px'><br>
	<input type='submit' value='저장'>
	<input type='button' value='삭제' onclick='location.href="delete.do?bno=${book.getBno()}";'>
	<input type='button' value='취소' onclick='location.href="list.do"'>
	</form>
</body>
</html>