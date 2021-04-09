<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Driver's License</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container my-5">
		<nav class="nav justify-content-end">
			<a href="/persons/new" class="mx-3">Add Person</a>
		</nav>
		<h1>DMV Driver's License</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>License #</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ persons }" var="person">
				<tr>
					<td><a href="/persons/${person.id}">${ person.firstName } ${ person.lastName }</a></td>
					<c:choose>
					<c:when test="${person.license != null}">
					<td>${ person.license.getNumberAsString() }</td>
					</c:when>
					<c:otherwise>
					<td><a href="/licenses/new">Add License</a></td>
					</c:otherwise>
					</c:choose>
					<td><a href="/persons/delete/${person.id}">delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>	
	</div>
</body>
</html>