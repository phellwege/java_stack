<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<c:out value="${error}"/>
		<h4>What is the code?</h4>
		<form method="POST" action="/codeword">
		    <input type="text" name="codeattempt">
			<button>Try Code</button>
		</form>
</body>
</html>