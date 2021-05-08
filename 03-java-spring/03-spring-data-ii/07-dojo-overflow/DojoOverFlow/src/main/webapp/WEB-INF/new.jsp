<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">	
<title>New Question</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container my-5">
		<a href="/questions" class="float-right">Home</a>
		<h1>What is your question?</h1>
		<form:form action="/questions/new" method="POST" modelAttribute="quest">
			<div class="form-group">
				<form:label path="question">Question:
				<form:errors path="question"/>
				<form:textarea path="question" class="form-control"></form:textarea>
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="sTags">Tags:
				<form:errors path="sTags"/>
				<form:input type="text" path="sTags" class="form-control"/>
				</form:label>
			</div>
			<button class="btn btn-success">Submit</button>
		</form:form>
	</div>
</body>
</html>