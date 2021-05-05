<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
	
	<h1>New Category</h1>
 	<div class="form-group">
	<form action="/add/${product.id}" method="POST">
		<select name="catagory">
			<c:forEach items="${catagories}" var="cat">
				<option value="${cat.id}"><c:out value = "${cat.name}"/></option>
			</c:forEach>
		</select>
			
		
		<input type="submit" value="submit"/>
	</form> 
    </div>

		<h1><c:out value="${product.name}"/></h1>
		<ul>
			<c:forEach items="${product.catagories}" var="catagory">
				<li>
				 <c:out value="${catagory.name}"/>
				</li>
			</c:forEach>
		</ul>
</body>
</html>