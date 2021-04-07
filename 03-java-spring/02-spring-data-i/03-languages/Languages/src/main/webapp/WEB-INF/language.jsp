<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Language</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container py-5">
		<a href="/languages" class="float-right">Dashboard</a>
		<h1><c:out value="${language.name}"/></h1>
		<h3>Creator: <c:out value="${language.creator}"/></h3>
		<h3>Version: <c:out value="${language.currentVersion}"/></h3>
		<a href="/languages/edit/${language.id}">Edit</a>
		<a href="/languages/delete/${language.id}">Delete</a>
	</div>
</body>
</html>