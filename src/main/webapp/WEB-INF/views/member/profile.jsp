<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Insert title here</title>
		
		<%-- 보통 타이틀밑에 BootStrap 링크를 넣는다 --%>
    	<%-- Bootstrap CSS --%>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
		<link rel="preconnect" href="https://fonts.googleapis.com" />
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
		<link href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap" rel="stylesheet"/>
		<!-- jquery -->
		<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
		<%-- favicon --%>
		<link rel="shortcut icon" href="/resources/images/favicon.ico">
		<link rel="stylesheet" href="/resources/css/admin/bscommon.css">
</head>
<c:import url="../template/header.jsp"></c:import>
<body>
<%-- 입력창 만들기 전 부트스트랩 쓸때 이걸 써야한다 --%>
<%-- con-lg-7은 사이즈 조절하는것 --%>
	<section class="container-fluid con-lg-7 ilseok">
		<div class="row mt-5">
			<%-- 회원 회원가입JSP --%>
			<form action="./profile" method="post" enctype="multipart/form-data">
			
			  <div class="mb-3">
			    <img src="http://20.249.88.100/resources/member/${member.memberFileDTO.f_name}" style=" max-width: 300px;  height: 300px;">
			  </div>
			  
			  <div id="addFile">
				<!--하단 파일 추가 input과 연결된 라벨-->
				<label for="file" name class="mt-2 file_add"><b>파일추가📂</b>
			  </div>					
			  <!-- 파일 추가 input -->
			  <input type="file" id="file" style="display: none;">

			  <div id="tcherProfile">
				<!-- 강사프로필로 가는 버튼 -->
				<button type="button" class="btn btn-outline-success btn-sm" onclick="location.href='/member/tcherProfile';"><b>프로필수정✏</b></button>
			  </div>

			  <div class="mb-3">
				<label for="ipName" class="form-label">${member.id}</label>
			    <input type="hidden" name="id" class="form-control" id="ipId" value="${member.id}">
			  </div>
			  
			  <div class="mb-3">
			    <label for="ipName" class="form-label">이름</label>
			    <input type="text" name="name" class="form-control" id="ipName" value="${member.name}">
			  </div>
			  
			  <div class="mb-3">
			    <label for="ipNname" class="form-label">닉네임</label>
			    <input type="text" name="n_name" class="form-control" id="ipNname" value="${member.n_name}">
			  </div>
			  
			  <div class="mb-3">
			    <label for="ipBdate" class="form-label">생년월일</label>
			    <input type="number" name="b_date" class="form-control" id="ipBdate" value="${member.b_date}">
			  </div>
			  
			  <div class="mb-3">
			    <label for="ipGender" class="form-label">성별</label>
			    <input type="text" name="gender" class="form-control" id="ipGender" value="${member.gender}">
			  </div>

			  <div class="mb-3">
			    <label for="ipEmail" class="form-label">이메일</label>
			    <input type="text" name="email" class="form-control" id="ipEmail" value="${member.email}">
			  </div>
			  
			  <div class="mb-3">
			    <label for="ipPhone" class="form-label">연락처</label>
			    <input type="tel" name="phone" class="form-control" id="ipPhone" value="${member.phone}">
			  </div>
			  
			  <div class="mb-3">
			    <input type="hidden" name="point" class="form-control" id="ipPoint">
			  </div>
			  
			  <div>
				  <button type="submit" class="btn btn-outline-success"><b>프로필수정✏</b></button>
			  </div>
			  
			  <!-- 프로필-이미지카드 -->
			  <div class="card" style="width: 18rem;">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
				  <h5 class="card-title">Card title</h5>
				  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				</div>
				<ul class="list-group list-group-flush">
				  <li class="list-group-item">An item</li>
				  <li class="list-group-item">A second item</li>
				  <li class="list-group-item">A third item</li>
				</ul>
				<div class="card-body">
				  <a href="#" class="card-link">Card link</a>
				  <a href="#" class="card-link">Another link</a>
				</div>
			  </div>

			  <!-- 초록색-카드 -->
			  <div class="card border-success mb-3" style="max-width: 18rem;">
				<div class="card-header">Header</div>
				<div class="card-body text-success">
				  <h5 class="card-title">Success card title</h5>
				  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				</div>
			  </div>

			</form>
		</div>
	</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script src="/resources/js/member_file.js"></script>
<script>save()</script>
</body>
</html>