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
		<h1>Questions Dashboard</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Question</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${questions}" var="q">
				<tr>
					<td><a href="/questions/${q.id}">${q.question}</a></td>
					<td>
					<p>
					<c:forEach items="${q.tags}" var="tag">
					${tag.subject}
					<c:if test="${ q.tags.indexOf(tag) != q.tags.size() - 1 }">, </c:if>
					
					</c:forEach>
					</p>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="questions/new" class="float-right">New Question</a>
	</div>
</body>
</html>