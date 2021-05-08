<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">	
<title>Show Question</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container my-5">
		<a href="/questions" class="float-right">Home</a>
		<h1>${question.question}</h1>
		<c:forEach items="${question.tags}" var="tag">
		<h1>Tags:${tag.subject}</h1>
		</c:forEach>
		<div class="row">
			<div class="col">
				<p>You have ${question.answers.size()} answers!</p>
				<ol>
					<c:forEach items="${question.answers}" var="answer">
					<h3>${answer.name}</h3>
					</c:forEach>
				</ol>
			</div>
			<div class="col">
				<h3>Add your answer:</h3>
				<form:form action="/answers" method="POST" modelAttribute="answer">
					<div class="form-group">
						<form:label path="name">Answer:
						<form:errors path="name"/>
						<form:input path="name"/>
						</form:label>
					</div>
					<form:hidden path="question" value="${ question.id }"/>
					<button class="btn btn-primary">Answer it!</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>