<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book List</title>
<style>
table, tr, td {
	border: 1px solid brown;
}
</style>
</head>
<body>
<p>Book in simple table</p>
<table>
	<tr>
		<td>ISBN</td>
		<td>Title</td>
		<td>Price</td>
	</tr>
	<c:forEach items="${requestScope.books }" var="book">
		<tr>
			<td>${book.isbn }</td>
			<td>${book.title }</td>
			<td>${book.price }</td>
		</tr>
	</c:forEach>
</table>
<br/>
<p>Book in styled table</p>
<table>
	<tr style="background:#ababff">
		<td>ISBN</td>
		<td>Title</td>
		<td>Price</td>
	</tr>
	<c:forEach items="${requestScope.books}" var="book" varStatus="vs">
		<c:if test="${vs.count%2==0}">
			<tr style="background:#eeeeff">
		</c:if>
		<c:if test="${vs.count%2!=0}">
			<tr style="background:#dedeff">
		</c:if>
		<td>${book.isbn }</td>
		<td>${book.title }</td>
		<td>${book.price }</td>
		</tr>
	</c:forEach>
</table>
<br/>
<p>ISBNs only</p>
<c:forEach items="${requestScope.books }" var="book" varStatus="vs">
	${book.isbn }<c:if test="${!vs.last }">,</c:if>
	<!-- 
	<br/>
	${vs.first }, ${vs.last }
	-->
</c:forEach>
</body>
</html>