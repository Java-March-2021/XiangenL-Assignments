<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show the books</title>
</head>
<body>
	<a href="/books/add">New Book</a>
	<h1>All books</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Description</th>
				<th>Language</th>
				<th>pages</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
			<tr>
			<td><c:out value = "${book.id}"/></td>
				<td><a href="/books/${book.id}">${book.title} </a></td>
				<td><c:out value = "${book.description}"/></td>
				<td><c:out value = "${book.language}"/></td>
				<td><c:out value = "${book.pages}"/></td>
				<td><a href="/books/edit/${book.id}">Edit</a></td>
				<td><a href="/books/delete/${book.id}">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>