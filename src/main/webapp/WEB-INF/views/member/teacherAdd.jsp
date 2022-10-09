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
						<h2><b>${member.id}</b></h2>
						<input type="hidden" name="id" class="form-control" id="ipId" value="${member.id}">
					</div>
					
					<div class="row g-2">
						<label for="ipBank_name" class="form-label mt-4"><b>은행이름</b></label>
						<div class="col-6">
							<input type="text" class="form-control bank_name" name="bank_name" placeholder="은행명" maxlength="4">
						</div>
						<div class="col-6">
						<select class="form-select bank_name" disabled name="">
							<option value="">직접입력</option>
							<option value="신한은행">신한은행</option>
							<option value="농협은행">농협은행</option>
							<option value="기업은행">기업은행</option>
							<option value="하나은행">하나은행</option>
							<option value="하나은행">카카오뱅크</option>
						</select>
						</div>
					</div>

					<div class="my-4">
						<label for="ipBank_num" class="form-label"><b>계좌번호</b></label>
						<input type="number" name="bank_num" class="form-control" id="ipBank_num" placeholder="계좌번호를 입력해주세요">
					</div>
					
					<div class="mb-4">
						<label for="ipIntroduce" class="form-label"><b>소개글</b></label>
						<input type="text" name="introduce" class="form-control" id="ipIntroduce" placeholder="나를 간단히 소개하는 글을 입력해주세요">
					</div>
					
					<!-- 구분선 -->
					<hr class="my-5">

					<!-- 회원가입 버튼 -->
					<div class="d-grid gap-2 mt-3">
						<button type="submit" class="btn btn-outline-success"><b>강사신청</b></button>
					</div>
				</form>
			</div>
		</div>
	</section>
<!-- 계좌번호 input type number에 화살표 안나오게 하는 css-->
<style>
	.bank_num::-webkit-outer-spin-button,
	.bank_num::-webkit-inner-spin-button {
		-webkit-appearance: none;
	}
</style>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>