<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show the book</title>
</head>
<body>
	<a href="/books">Home</a>
	<a href="/books/edit/${book.id}">Edit</a>
	<h2>Title: <c:out value = "${book.id}"/></h2>
	<h2>Title: <c:out value = "${book.title}"/></h2>
	<h2>Description: <c:out value = "${book.description}"/></h2>
	<h2>Language: <c:out value = "${book.language}"/></h2>
	<h2>Pages: <c:out value = "${book.pages}"/></h2>
</body>
</html>