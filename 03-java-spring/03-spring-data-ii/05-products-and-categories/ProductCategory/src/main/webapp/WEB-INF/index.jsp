<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">	
<title>Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	    <h1 class="my-5">Products and Categories (Many To Many)</h1>
	    <h3><a href="/products/new">Add Product</a></h3>
	    <h3><a href="/categories/new">Add Categories</a></h3>
	    <div>
		    <h2>All Products</h2>
		    <table class="table table-striped">
		    	<thead>
		    		<tr>
		    			<td>Name</td>
		    			<td>Description</td>
		    			<td>Price</td>
		    	</thead>
		    	<tbody>
		    		<c:forEach items="${products}" var="product">
		    		<tr>
		    			<td><a href="/products/${product.id}">${product.name}</a></td>
		    			<td>${product.description}</td>
		    			<td>${product.price}</td>
		    		</tr>
		    		</c:forEach>
		    	</tbody>
		    </table>
	    </div>
	    <div>
		    <h2>All Categories</h2>
		    <ol>
	    		<c:forEach items="${categories}" var="category">
	    			<li><a href="/categories/${category.id}">${category.name}</a></li>
	    		</c:forEach>
		    </ol>
	    </div>
	</div>
</body> 