<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Top Ten</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<a href="/dashboard" class="d-block float-right">Dashboard</a>
		<div>
			<h1 class="mb-5">Top 10 Songs:</h1>
			<div>
				<c:forEach items="${topTenSongs}" var="song">
				<h3>${song.rating} - <a href="/songs/{song.id}">${song.title}</a> - ${song.artist}</h3>
				</c:forEach>
			</div>
			
		</div>
	</div>
</body>
</html>