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
		    
<h1>New Book</h1>
<div class="form-group">
<form:form action="/book/${book.id}" method="post" modelAttribute="book">
   <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="title">Title</form:label>
        <form:input path="title"/>
        <form:errors path="title"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:textarea path="description"/>
        <form:errors path="description"/>
    </p>
    <p>
        <form:label path="language">Language</form:label>
        <form:input path="language"/>
        <form:errors path="language"/>
    </p>
    <p>
        <form:label path="numberOfPages">Pages</form:label>
        <form:input type="number" path="numberOfPages"/>
        <form:errors path="numberOfPages"/>  
    </p>    
    <input type="submit" value="Submit"/>
</form:form>  
  </div>
</body>
</html>