<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 목록</title>
<link rel="stylesheet" href="/resources/css/index.css" />
<link rel="stylesheet" href="/resources/css/list.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
  href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap"
  rel="stylesheet"
/>
</head>
<c:import url="../template/header.jsp"></c:import>
<body>
   <main class="container mt-5">
		<!--Category Search-->
		<form action="./list">
			<div class="input-group mb-3 " style="width: 500px; margin: auto;">
				<select name="category" class="form-select" id="category" style="border-radius: 7px 0 0 7px; width: 100px;">
					<option class="categories" value="">Category</option>
					<option class="categories" value="java">Java</option>
					<option class="categories" value="python">Python</option>
					<option class="categories" value="javascript">JavaScript</option>
					<option class="categories" value="html/css">HTML/CSS</option>
				</select>

				<input type="text" class="form-control" aria-label="Text input with dropdown button">
				<button class="btn btn-outline-secondary" type="submit" id="button-addon2">Search</button>
			</div>
		</form>
		<!--Lecture List-->
			<section class="py-5">
				<div class="container px-4 px-lg-5 mt-5">
					<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4">
						<c:forEach items="${list}" var="list">
						<div class="col mb-5">
							<div class="card h-100">
								<!-- Lecture image-->
								<img class="card-img-top" src="../resources/upload/lecture/${list.lectureFileDTO[0].f_name}" alt="...">
								<!-- Lecture details-->
								<div class="card-body p-4">
									<div class="text-center">
										<!-- Lecture name-->
										<h5 class="fw-bolder">${list.l_name}</h5>
										<!-- Lecture price-->
										<div>${list.l_price}원</div>
										<!--Student count-->
										<div>현재 ${list.l_count}명</div>
										<!--Level-->
										<div>난이도 : ${list.level_num}</div>
									</div>
								</div>
								<!-- Product actions-->
								<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
									<div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
								</div>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>
			</section>

                   


    </main>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>