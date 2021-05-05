<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table table-hover table-dark">
	<thead>
		<tr>
			<th>Title</th>
			<th>Description</th>
			<th>Language</th>
			<th>Number of Pages</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${books}" var="book">
	<tr>
		<td><c:out value ="${book.title}"/> </td>
		<td><c:out value ="${book.description}"/> </td>
		<td><c:out value ="${book.language}"/> </td>
		<td><c:out value ="${book.numberOfPages}"/> </td>
		<td><a href="/api/books/<c:out value="${book.id}"/>">Delete</a></td>
		</tr>
		</c:forEach>
		
	</tbody>
</table>
<a href="/books/new">New Book</a>
</body>
</html>