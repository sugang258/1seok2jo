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
	<section class="container ilseok">
		<div class="row justify-content-md-center">
			<div class="col-6 col-md-4 col-lg-5 mt-5">
				<div class="mb-4 text-center">
					<h1><b>강사신청✒</b></h1>
				</div>
				<%-- 강사 신청 form --%>
				<form action="./teacherAdd" method="post">
					<div>
						<div>
							<label for="ipId" class="form-label mt-4"><b>아이디</b></label>
						</div>
						<h3><b>${member.id}</b></h3>
						<input type="hidden" name="id" class="form-control border-success border-opacity-25" id="ipId" value="${member.id}">
					</div>
          
					<div class="mt-4">
						<label for="ipBank_name" class="form-label mt-4"><b>은행이름</b></label>
						<select class="form-select border-success border-opacity-25 ipBank_name" name="bank_name">

							<option value="신한은행">신한은행</option>
							<option value="국민은행">국민은행</option>
							<option value="농협은행">농협은행</option>
							<option value="기업은행">기업은행</option>
							<option value="하나은행">하나은행</option>
							<option value="카카오뱅크">카카오뱅크</option>
						</select>
					</div>

					<div class="my-4">
						<label for="ipBank_num" class="form-label"><b>계좌번호</b></label>
						<input type="text" name="bank_num" class="form-control border-success border-opacity-25" id="ipBank_num" placeholder="계좌번호를 입력해주세요">
					</div>
					
					<div class="mb-4">
						<label for="ipIntroduce" class="form-label"><b>소개글</b></label>
						<input type="text" name="introduce" class="form-control border-success border-opacity-25" id="ipIntroduce" placeholder="나를 간단히 소개하는 글을 입력해주세요">
					</div>
					
					<!-- 구분선 -->
					<div class="text-success">
						<hr class="my-5">
					</div>

					<!-- 회원가입 버튼 -->
					<div class="d-grid gap-2 mt-3">
						<button type="submit" class="btn btn-outline-success"><b>강사신청</b></button>
					</div>
				</form>
			</div>
		</div>
	</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>