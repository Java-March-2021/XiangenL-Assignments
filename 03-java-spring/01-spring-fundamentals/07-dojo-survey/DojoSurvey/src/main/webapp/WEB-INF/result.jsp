<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<c:set var="result" value="${ result }"/>
		<h1 class="my-5">Submitted Info</h1>
		<h3>Name: ${result.name}</h3>
		<h3>Dojo Location: ${result.location}</h3>
		<h3>Favorite Language: ${result.language}</h3>
		<h3>Comment: ${result.comment}</h3>
		<a href="/" type="button" class="btn btn-success">Go Back</a>
	</div>
</body>
</html>