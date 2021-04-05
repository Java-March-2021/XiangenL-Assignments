<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a book</title>
</head>
<body>
	<a href="/books">Home</a>
	<h1>Add Book</h1>
	<form:form action="/books/add" method = "POST" modelAttribute = "book">
		<p>
			<form:label path="title">Title</form:label>
			<form:errors path="title"/>
			<form:input path="title"/>
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description"/>
			<form:input path="description"/>
		</p>
		<p>
			<form:label path="language">Language</form:label>
			<form:errors path="language"/>
			<form:input path="language"/>
		</p>
		<p>
			<form:label path="pages">Pages</form:label>
			<form:errors path="pages"/>
			<form:input path="pages"/>
		</p>
		<button>Add New Book</button>
	</form:form>
</body>
</html>