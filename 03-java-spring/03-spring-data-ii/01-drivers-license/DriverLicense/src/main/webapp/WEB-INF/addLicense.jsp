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
	<div class="container my-3">
	<a href="/" class="float-right">Home</a>
		<h1 class="my-3">New License</h1>
		<form:form action="/licenses/new" method="POST" modelAttribute="license">
			<div class="form-group">
				<form:label path="person">Person:
				<form:errors path="person"/>
				<form:select class="form-control" path="person">
		        <c:forEach items="${ persons }" var="p">
		        	<form:option value="${ p.id }">${ p.firstName } ${ p.lastName }</form:option>
		        </c:forEach>
		        </form:select>
		        </form:label>
			</div>
			<div class="form-group">
				<form:label path="state">State:
				<form:errors path="state"/>
				<form:input path="state"/></form:label>
			</div>
			<div class="form-group">
				<form:label path="expirationDate">Expiration Date:
				<form:errors path="expirationDate"/>
				<form:input type="date" path="expirationDate"/></form:label>
			</div>
			<button class="btn btn-success">Create</button>
		</form:form>
	</div>
</body>
</html>