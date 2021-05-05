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
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<h1>New Ninja</h1>
<div class="form-group">
<form:form action="/newNinja" method="post" modelAttribute="ninja">
    <div>
    
    <form:label path="Dojo">Dojo:</form:label>
            <form:errors path="Dojo"/>
            <form:select class="form-control" path="Dojo">
                <c:forEach items="${allDojos}" var="Dojo">
                    <form:option value="${Dojo.id}"><c:out value="${Dojo.name}"/></form:option>
                </c:forEach>
                
            </form:select>
    </div>
    <p>
        <form:label path="firstName">First Name</form:label>
        <form:input path="firstName"/>
        <form:errors path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:textarea path="lastName"/>
        <form:errors path="lastName"/>
    </p>
    <p>
        <form:label path="age">Age</form:label>
        <form:input path="age"/>
        <form:errors path="age"/>
    </p>
     
    <input type="submit" value="Submit"/>
</form:form>  
  </div>
</body>
</html>