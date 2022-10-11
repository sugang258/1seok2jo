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
	<section class="container-fluid con-lg-7 ilseok">
		<div class="row mt-5">
			<h1>강사프로필페이지</h1>
			<form action="./tcherProfile" method="post">
				<div class="mb-3">
				  <label for="ipId" class="form-label">${member.id}</label>
				  <input type="hidden" name="id" class="form-control" id="ipId" value="${member.id}">
				</div>
  
				<div class="mb-3">
				  <label for="ipBank_num" class="form-label">계좌번호</label>
				  <input type="text" name="bank_num" class="form-control" id="ipBank_num" value="${teacher.bank_num}">
				</div>
				
				<div class="mb-3">
				  <label for="ipBank_name" class="form-label">은행이름</label>
				  <input type="text" name="bank_name" class="form-control" id="ipBank_name" value="${teacher.bank_name}">
				</div>
				
				<div class="mb-3">
				  <label for="ipIntroduce" class="form-label">소개글</label>
				  <input type="text" name="introduce" class="form-control" id="ipIntroduce" value="${teacher.introduce}">
				</div>
  
				<div>
				  <button type="submit" class="btn btn-outline-success">프로필수정</button>
				</div>
			</form>
		</div>
	</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>