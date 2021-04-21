<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">	
<title>Add Product</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container my-5">
	<h1>New Product</h1>
	<form:form action="/products/new" method="POST" modelAttribute="product">
		<div class="form-group">
			<form:label path="name">Name:
			<form:errors path="name"/>
			<form:input path="name"/>
			</form:label>
		</div>
		<div class="form-group">
			<form:label path="description">Description:
			<form:errors path="description"/>
			<form:input path="description"/>
			</form:label>
		</div>
		<div class="form-group">
			<form:label path="price">Price:
			<form:errors path="price"/>
			<form:input path="price"/>
			</form:label>
		</div>
		<button class="btn btn-primary">Create</button>
	</form:form>
</div>
</body>
</html>