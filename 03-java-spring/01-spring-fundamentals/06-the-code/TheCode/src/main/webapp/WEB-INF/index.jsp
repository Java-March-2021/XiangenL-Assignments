<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="wrapper">
		<span class="red"><c:out value="${error}"/></span>
		<form action="/submit" method="POST">
		<label name = "code" class="code">What is the code?</label>
		<input type="text" name="code">
		<button class="code">Try Code</button>
	</form>
	</div>
	
</body>
</html>