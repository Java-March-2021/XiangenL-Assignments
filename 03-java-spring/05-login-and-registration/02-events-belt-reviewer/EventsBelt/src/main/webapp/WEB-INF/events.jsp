<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">	
<title>Dashboard</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container my-5">
		<a href="/logout" class="float-right">Logout</a>
		<h1>Welcome, ${user.firstName}</h1>
		<h3>Here are some of the events in your state:</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action / Status</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${userEvents}" var="event">
				<tr>
					<td><a href="/events/${event.id}">${event.name}</a></td>
					<td>${event.eventDate}</td>
					<td>${event.city}</td>
					<td>${event.host.firstName}</td>
					<td>
					<c:choose>
						<c:when test="${event.host.id == user.id}">
							<a href="/events/edit/${event.id}">Edit</a>
							<a href="/events/delete/${event.id}">Delete</a>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${event.joinedUsers.contains(user)}">
								<p>Joining <a href="/events/cancel/${event.id}">Cancel</a></p>
								</c:when>
								<c:otherwise>
								<a href="/events/join/${event.id}">Join</a>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
				<h3>Here are some of the events in other state:</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>State</th>
					<th>Host</th>
					<th>Action / Status</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${otherEvents}" var="event">
				<tr>
					<td><a href="/events/${event.id}">${event.name}</a></td>
					<td>${event.eventDate}</td>
					<td>${event.city}</td>
					<td>${event.state}</td>
					<td>${event.host.firstName}</td>
					<td>
					<c:choose>
						<c:when test="${event.host.id == user.id}">
							<a href="/events/edit/${event.id}">Edit</a>
							<a href="/events/delete/${event.id}">Delete</a>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${event.joinedUsers.contains(user)}">
								<p>Joining <a href="/events/cancel/${event.id}">Cancel</a></p>
								</c:when>
								<c:otherwise>
								<a href="/events/join/${event.id}">Join</a>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<h3>Create an event</h3>
		<form:form action="/events/new" method="POST" modelAttribute="event">
			<p>
	            <form:label path="name">Name:</form:label>
	            <form:errors path="name"/>
	            <form:input path="name"/>
	        </p>
	        <p>
	            <form:label path="eventDate">Date:</form:label>
	            <form:errors path="eventDate"/>
	            <form:input type="date" path="eventDate"/>
	        </p>
	        <p>
	            <form:label path="city">Location:</form:label>
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
	        </p>
	        <input type="submit" value="Add new event"/>
		</form:form>
	</div>
</body>
</html>