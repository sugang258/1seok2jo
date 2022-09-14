<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lecture List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<c:import url="../template/header.jsp"></c:import>
<body>
	
	<main class="container" style="height: 1000px;">
		<div class="input-group mb-3">
		<button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</button>
		<ul class="dropdown-menu">
			<li><a class="dropdown-item" href="#">Java</a></li>
			<li><a class="dropdown-item" href="#">Python</a></li>
			<li><a class="dropdown-item" href="#">JavaScript</a></li>
			<li><a class="dropdown-item" href="#">HTML/CSS</a></li>
		</ul>
		<input type="text" class="form-control" aria-label="Text input with dropdown button">
		<input type="button" class="btn btn-outline-secondary" id="search" value="검색">
		</div>

	</main>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>