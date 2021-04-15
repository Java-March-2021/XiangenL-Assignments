	<a href=""></a><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="my-5">Dojo Survey</h1>
		<form action="/result" method="POST">
			<div class="form-group">
				<label for="name">Your Name</label>
				<input type="text" name="name" id="name"/>
			</div>
			<div class="form-lg-group">
				<label for="location">Dojo Location</label>
				<select name="location" id="location">
					<c:forEach items="${locations}" var="location">
						<option value="${location}">${location}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="language">Favorite Language</label>
				<select name="language" id="language">
					<c:forEach items="${languages}" var="language">
						<option value="${language}">${language}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="comment">Comment(option)</label>
				<input type="text" name="comment" id="comment"/>
			</div>
			<button class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>