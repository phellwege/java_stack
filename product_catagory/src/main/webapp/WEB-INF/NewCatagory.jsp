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
		<div class="form-group">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<form:form action="/createCat" method="post" modelAttribute="catagory">
	<p>
        <form:label path="name">Name</form:label>
        <form:input path="name"/>
        <form:errors path="name"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>  
  </div>
</body>
</html>