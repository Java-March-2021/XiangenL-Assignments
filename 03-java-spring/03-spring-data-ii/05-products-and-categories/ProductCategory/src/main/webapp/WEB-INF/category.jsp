<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">	
<title>Show Category</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container my-5">
		<a href="/" class="float-right">Home</a>
		<h1>${category.name}</h1>
		<div class="left">
			<h3>Products:</h3>
			<ol>
	    		<c:forEach items="${category.products}" var="product">
	    			<li><p>${product.name}</p></li>
	    		</c:forEach>
		    </ol>
		</div>
		<div class="right">
			<form action="/categories/${category.id}" method="POST">
				<label for="name">Products:</label>
				<select name="productId">
					<c:forEach items="${products}" var="product">
					<option value="${product.id}">${product.name}</option>
					</c:forEach>
				</select>
				<button class="btn btn-success">Add</button>
			</form>
		</div>
	</div>
</body>
</html>