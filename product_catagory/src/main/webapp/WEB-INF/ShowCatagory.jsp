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

	<h1>New Product</h1>
 	<div class="form-group">
	<form action="/make/${catagory.id}" method="POST">
		<select name="product">
			<c:forEach items="${products}" var="prod">
				<option value="${prod.id}"><c:out value = "${prod.name}"/></option>
			</c:forEach>
		</select>
			
		
		<input type="submit" value="submit"/>
	</form> 
    </div>

		<h1><c:out value="${catagory.name}"/></h1>
		<ul>
			<c:forEach items="${catagory.products}" var="product">
				<li>
				 	<c:out value="${product.name}"/>
				</li>
				<li>
					<c:out value="${product.description}"/>
				</li>
				<li>
					<c:out value="${product.price}"/>
				</li>
			</c:forEach>
		</ul>
</body>
</body>
</html>