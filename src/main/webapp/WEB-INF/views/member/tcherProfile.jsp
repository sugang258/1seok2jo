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
		<%-- favicon --%>
		<link rel="shortcut icon" href="/resources/images/favicon.ico">
		<link rel="stylesheet" href="/resources/css/admin/bscommon.css">
</head>
<div class="container-fluid" style="height: 80px;">
	<c:import url="../template/header.jsp"></c:import>
</div>
<body>
	<section class="container ilseok">
		<div class="row justify-content-md-center">
			<div class="col-md-8 col-lg-7 mt-5">
				
				<div class="mb-5 text-center">
					<h1><b>강사프로필✒</b></h1>
				</div>
				
				<%-- 강사 프로필 수정 form --%>
				<form action="./tcherProfile" method="post">
	
					<!-- 프로필사진 카드 -->
					<div class="card border-success mb-3">
						<div class="row my-4">
							<img src="http://20.249.88.100/resources/member/${member.memberFileDTO.f_name}" class="border border-success p-2 mb-2 border-opacity-50 mx-auto d-block" style=" max-width: 300px;  height: 300px;  border-radius: 75px;">
							<!-- <input type="hidden" name="f_name" value="${member.memberFileDTO.f_name}">
							<input type="hidden" name="f_oriname" value="${member.memberFileDTO.f_oriname}"> -->
						</div>
						<div class="card-body">
							<!-- <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p> -->
							<ul class="list-group list-group-flush">
								<li class="list-group-item border-success text-center mb-1">
									<label for="ipId" class="form-label card-title"><h4><b>${member.id}</b></h4></label>
									<p class="card-text"><input type="hidden" name="id" class="form-control" id="ipId" value="${member.id}"></p>
								</li>
								<li class="list-group-item border-success my-2 mt-3">
									<label for="ipIntroduce" class="form-label card-title"><h6><b>소개글</b></h6></label>
									<p class="card-text"><input type="text" name="introduce" class="form-control" id="ipIntroduce" value="${teacher.introduce}"></p>
								</li>
							</ul>
						</div>
					</div>

					<!-- 프로필정보 카드 -->
					<div class="card border-success mb-3">
						<div class="card-body">
							<ul class="list-group list-group-flush">
								<li class="list-group-item border-success">
									<div class="mb-3">
										<label for="ipBank_num" class="form-label card-title"><h6><b>계좌번호</b></h6></label>
										<p class="card-text"><input type="text" name="bank_num" class="form-control" id="ipBank_num" value="${teacher.bank_num}"></p>
									</div>
								</li>
								<li class="list-group-item border-success my-2 mt-3">
									<label for="ipBank_name" class="form-label card-title"><h6><b>은행이름</b></h6></label>
									<p class="card-text"><input type="text" name="bank_name" class="form-control" id="ipBank_name" value="${teacher.bank_name}"></p>
								</li>
							</ul>
						</div>
					</div>

					<!-- 구분선 -->
					<div class="text-success">
						<hr class="my-4">
					</div>
					
					<!-- 강사프로필수정 버튼 -->
					<div class="d-grid gap-2 mt-3">
						<button type="submit" class="btn btn-outline-success">프로필수정✏</button>
					</div>
				</form>
			</div>
		</div>
	</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>