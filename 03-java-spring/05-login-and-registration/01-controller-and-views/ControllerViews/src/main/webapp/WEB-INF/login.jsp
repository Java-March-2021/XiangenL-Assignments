<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">	
<title>Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<h1>Login</h1>
    <p><c:out value="${loginError}"/></p>
    <form method="POST" action="/login">
        <p>
            <label for="loginEmail">Email</label>
            <input type="email" id="loginEmail" name="loginEmail"/>
        </p>
        <p>
            <label for="loginPassword">Password</label>
            <input type="password" id="loginPassword" name="loginPassword"/>
        </p>
        <input type="submit" value="Login!"/>
    </form>   
</body>
</html>