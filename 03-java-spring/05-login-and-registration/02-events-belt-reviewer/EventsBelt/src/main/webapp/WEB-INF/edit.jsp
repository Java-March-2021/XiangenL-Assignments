<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">	
<title>Edit</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container my-5">
		<a href="/events" class="float-right">Dashboard</a>
		<a href="/logout" class="float-right mx-5">Logout</a>
		<h1 class="my-3">${thisevent.name}</h1>
		<h3>Edit Event</h3>
		<form:form action="/events/edit/${thisevent.id}" method="POST" modelAttribute="updateEvent">
			<p>
	            <form:label path="name">Name:
	            <form:errors path="name"/>
	            <form:input path="name" />
	            </form:label>
	        </p>
	        <p>
	            <form:label path="eventDate">Date:
	            <form:errors path="eventDate"/>
	            <form:input type="date" path="eventDate"/>
	            </form:label>
	        </p>
	        <p>
	            <form:label path="city">Location:
	            <form:errors path="city"/>
	            <form:input path="city"/>
	            <form:select path="state">
	            	<option value="CA">CA</option>
					<option value="UT">UT</option>
					<option value="TX">TX</option>
					<option value="CO">CO</option>
					<option value="WA">WA</option>
					<option value="NV">NV</option>
	            </form:select>
	            </form:label>
	        </p>
	        <input type="submit" value="Edit"/>
		</form:form>
	</div>
</body>
</html>