<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="/resources/css/index.css" />
		<%-- 보통 타이틀밑에 BootStrap 링크를 넣는다 --%>
    	<%-- Bootstrap CSS --%>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
		<link rel="preconnect" href="https://fonts.googleapis.com" />
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
		<link href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap" rel="stylesheet"/>
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
			<form action="./profile" method="post">
			
			  <div class="mb-3">
			    <label for="ipId" class="form-label">아이디</label>
			    <input type="text" name="id" class="form-control" id="ipId" value="${member.id}">
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
			  
			  <button type="submit" class="btn btn-outline-success">프로필수정</button>
			  
			</form>
		</div>
	</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>