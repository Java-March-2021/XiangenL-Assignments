<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">	
<title>Show dojo</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<a href="/" class="float-right">Home</a>
		<h1>Dojo ${dojo.name} Ninjas</h1>
		<c:if test="${dojo.ninjas != null}">
			<table class="table table-striped">
				<thead>
					<tr>
						<td>First Name</td>
						<td>Last Name</td>
						<td>Age</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dojo.ninjas}" var="ninja">
					<tr>
						<td>${ninja.firstName}</td>
						<td>${ninja.lastName}</td>
						<td>${ninja.age}</td>
					</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty dojo.ninjas}">
			<a href="/ninjas/new" class="btn btn-success">Add ninjas</a>
		</c:if>
		<a href="/dojos/delete/${dojo.id}" class="display-block btn btn-danger">Delete Dojo</a>
	</div>
</body>
</html>