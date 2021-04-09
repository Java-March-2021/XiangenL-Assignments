<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Driver's License</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container my-3">
		<a href="/" class="float-right">Home</a>
		<div>
			<h1 class="my-5">${person.firstName} ${person.lastName}</h1>
			<c:choose>
			<c:when test="${person.license != null}">
			<h3>License Number: ${ person.license.getNumberAsString()}</h3>
			<h3>State: ${person.license.state}</h3>
			<h3>Expiration Date: ${person.license.expirationDate}</h3>
			</c:when>
			<c:otherwise>
			<h3>No Driver's License!</h3>
			<td><a href="/licenses/new">Add License</a></td>
			</c:otherwise>
			</c:choose>			
		</div>
	</div>
</body>
</html>