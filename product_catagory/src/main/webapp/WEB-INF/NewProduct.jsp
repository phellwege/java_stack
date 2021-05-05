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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<form:form action="/createProd" method="post" modelAttribute="product">
	<p>
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
        <form:errors path="name"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:input path="description"/>
        <form:errors path="description"/>
    </p>
    <p>
        <form:label path="price">Price</form:label>
        <form:input path="price"/>
        <form:errors path="price"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>  
  </div>
</body>
</html>