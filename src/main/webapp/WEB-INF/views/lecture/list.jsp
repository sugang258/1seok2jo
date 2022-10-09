<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 목록</title>
<link rel="stylesheet" href="/resources/css/index.css" />
<link rel="stylesheet" href="/resources/css/lecture/list.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
  href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap"
  rel="stylesheet"
/>
<link rel="shortcut icon" href="/resources/images/favicon.ico">
</head>
<c:import url="../template/header.jsp"></c:import>
<body>
   <main class="container mt-5">
	
		<!--Category Search-->
		<form action="./list">
			<div class="input-group mb-3 " style="width: 700px; margin: auto; height: 40px;">
				
				<select name="kind" class="form-select input-group" id="kind" >
					<option class="kinds" value="" style="display: none;">Category</option>
					<option class="kinds" value="id">강사</option>
					<option class="kinds" value="l_name">강의 제목</option>
					<option class="kinds" value="level_name">난이도</option>
					<option class="kinds" value="c_name">카테고리</option>
				</select>

				<input type="text" class="form-control" id="search" name="search" value="">
			
				<button class="btn btn-outline-secondary" type="submit" id="button-addon2">Search</button>
				
					
				<select id="filter" class="form-select" aria-label="Default select example" name="filter">
					<option class="filters" value="" style="display: none;">
					정렬
					</option>
					<option class="filters" value="seq">
					추천순
					</option>
					<option class="filters" value="popular">
					인기순
					</option>
					<option class="filters" value="recent">
					최신순
					</option>
					<option class="filters" value="level">
					난이도순
					</option>
					<option class="filters" value="price">
					가격순
					</option>
				</select>
				
			</div>
		
		
		</form>
		<div class="buttons text-center">
  
			<button class="btn btn-secondary cate" name="Python" id="python" data-c-num="2">Python</button>
			<button class="btn btn-secondary cate" name="JavaScript" id="js" data-c-num="3">JavaScript</button>
			<button class="btn btn-secondary cate" name="HTML/CSS" id="hc" data-c-num="4">HTML/CSS</button>
			<button class="btn btn-secondary cate" name="Java" id="java" data-c-num="1">Java</button>
			<button class="btn btn-secondary cate" name="React" id="react" data-c-num="5">React</button>
			<button class="btn btn-secondary cate" name="Spring" id="spring" data-c-num="7">Spring</button>
			<button class="btn btn-secondary cate" name="SQL" id="sql" data-c-num="8">SQL</button>
			<button class="btn btn-secondary cate" name="Node.js" id="node" data-c-num="6">Node.js</button>
		</div>
		<!--Lecture List-->
		<div id="result">
		<section class="py-5">
				<div class="container px-4 px-lg-5 mt-5">
					<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4">
						<c:forEach items="${list}" var="list">
						<div class="col mb-5 lec" id="lec" data-ln-num ="${list.l_num}">
							<div class="card h-100" >
								<!-- Lecture image-->
								<img class="card-img-top" src="http://20.249.88.100/resources/lecture/${list.lectureFileDTO[0].f_name}" alt="...">
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
										<div>난이도 : ${list.level_name}</div>
										<div>카테고리 : ${list.c_name}</div>
										<input type="label" value="${list.l_num}" style="display: none;">
										<!--<input type="label" value="${list.c_num}" style="display: none;">-->
									</div>
								</div>
								<!-- Product actions-->
								<div class="card_footer p-4 pt-0 border-top-0 bg-transparent cart">
									<div class="text-center">
										<input type="button" class="btn btn-outline-dark mt-auto" id="cartbtn" value="Add to cart">
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>
				
				<div class="container" id="pager">
					<nav aria-label="Page navigation example" class="justify-content-center">
						<ul class="pagination">
							<c:if test="${pager.pre}">
								<li class="page-item"><a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
							</c:if>
							<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
								<li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
							</c:forEach>
							
							<li class="page-item ${pager.next?'':'disabled'}">
								<a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
							</ul>
						</nav>
					</div>
			</section>
		</div>
		
			</main>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script src="/resources/js/lecture_list.js"></script>
</body>
</html>