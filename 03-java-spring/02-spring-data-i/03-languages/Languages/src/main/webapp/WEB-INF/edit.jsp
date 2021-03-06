<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Language</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container py-5">
		<div class="nav justify-content-end">
			<a href="/languages/delete/${language.id}" class="mx-3">Delete</a>
			<a href="/languages">Dashboard</a>
		</div>
		<form:form action="/languages/edit/${language.id}" method="POST" modelAttribute="language">
			<p>
				<form:label path="name">Name
				<form:errors path="name"/>
				<form:input path="name"/></form:label>
			</p>
			<p>
				<form:label path="creator">Creator
				<form:errors path="creator"/>
				<form:input path="creator"/></form:label>
			</p>
			<p>
				<form:label path="currentVersion">Version
				<form:errors path="currentVersion"/>
				<form:input path="currentVersion"/></form:label>
			</p>
			<button>Submit</button>
		</form:form>
	</div>
</body>
</html>