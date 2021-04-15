<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add ninja</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<a href="/" class="float-right">Home</a>
		<h1 class="my-5">New Ninja</h1>
		<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
			<div>
				<form:label path="dojo">Dojo:</form:label>
				<form:errors path="dojo"/>
				<form:select path="dojo">
					<c:forEach items="${dojos}" var="dojo">
					<option value="${dojo.id}">${dojo.name}</option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				<form:label path="firstName">First Name:
				<form:errors path="firstName"/>
				<form:input path="firstName"/>
				</form:label>
			</div>
			<div>
				<form:label path="lastName">Last Name:
				<form:errors path="lastName"/>
				<form:input path="lastName"/>
				</form:label>
			</div>
			<div>
				<form:label path="age">Age:
				<form:errors path="age"/>
				<form:input path="age"/>
				</form:label>
			</div>
			<button>Create</button>
		</form:form>
	</div>
</body>
</html>