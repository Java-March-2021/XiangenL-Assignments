<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add dojo</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container m-5">
		<h1>Dojo and Ninjas(One to Many)</h1>
		<a href="/dojos/new" class="m-5">Add New Dojo</a>
		<a href="/ninjas/new">Add New Ninja</a>
		<h2 class="mt-5">All dojos</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<td>Name</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dojos}" var="dojo">
				<tr>
					<td><a href="/dojos/${dojo.id}">${dojo.name}</a></td>
					<td><a href="/dojos/delete/${dojo.id}">Delete</a></td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
</body>
</html>
