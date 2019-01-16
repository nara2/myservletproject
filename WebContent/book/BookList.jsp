<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 목록</title>
</head>
<body>
	<jsp:include page="/Header.jsp"/>
	<h1>도서 목록</h1>
	<p><a href='add.do'>신규 도서</a></p>
	
	<c:set var="sum" value="0" />
	<c:set var="totalprice" value="0" />
	<c:forEach var="book" items="${books}"> 
	${book.getBno()},
	<a href='update.do?bno=${book.getBno()}'>${book.getBname()}</a>,
	${book.getAuthor()},
	${book.getBdate()},
	${book.getPrice()},
	${book.getBcount()},
	${book.getTotalprice()}
	<a href='delete.do?bno=${book.getBno()}'>[삭제]</a><br>
	
	<c:set var="sum" value="${book.getBcount()+sum}" />
	<c:set var="totalprice" value="${book.getPrice()*book.getBcount()+totalprice}" />

	</c:forEach>
	<p>
		보유 총 권수:<c:out value="${sum}"/><br>
		총액:<c:out value="${totalprice}"/><br>
	</p>
	
	<!--<jsp:include page="/Tail.jsp"/> -->
</body>
</html>