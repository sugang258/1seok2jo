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
		<!-- common.css적용 -->
		<link rel="stylesheet" href="/resources/css/admin/bscommon.css">
</head>
<c:import url="../template/header.jsp"></c:import>
<body>
<%-- 입력창 만들기 전 부트스트랩 쓸때 이걸 써야한다 --%>
<%-- con-lg-7은 사이즈 조절하는것 --%>
<div class="container ilseok">
		<div class="row justify-content-md-center ">
			<div class="col-6 col-md-4 col-lg-5 mt-5">
				<div class="mb-3 text-center">
					<h1><b>회원가입✒</b></h1>
				</div>
				<%-- 회원 회원가입JSP --%>
				<form action="./join" method="post">
					<div class="mb-4">
						<label for="ipId" class="form-label"><b>아이디</b></label>
						<input type="text" name="id" class="form-control" id="ipId" placeholder="아이디를 입력해주세요">
						<div id="ipIdResult"></div>
					</div>
					
					<div class="mb-4">
						<label for="ipPw" class="form-label"><b>비밀번호</b></label>
						<input type="password" name="pw" class="form-control" id="ipPw" placeholder="비밀번호를 입력해주세요">
						<div id="ipPwResult"></div>
					</div>
					
					<div class="mb-4">
						<label for="ipPwCheck" class="form-label"><b>비밀번호 재확인</b></label>
						<input type="password" class="form-control" id="ipPwCheck" placeholder="비밀번호를 다시 입력해주세요">
						<div id="ipPwCheckResult"></div>
					</div>
					
					<div class="mb-4">
						<label for="ipName" class="form-label"><b>이름</b></label>
						<input type="text" name="name" class="form-control" id="ipName" placeholder="이름을 입력해주세요">
						<div id="ipNameResult"></div>
					</div>
					
					<div class="mb-4">
						<label for="ipNname" class="form-label"><b>닉네임</b></label>
						<input type="text" name="n_name" class="form-control" id="ipNname" placeholder="닉네임을 입력해주세요">
						<div id="ipNnameResult"></div>
					</div>
					
					<!-- <div class="mb-3">
						<label for="ipBdate" class="form-label">생년월일</label>
						<input type="number" name="b_date" class="form-control" id="ipBdate" placeholder="생년월일을 입력해주세요">
						<div id="ipBdateResult"></div>
					</div>
					
					<div class="mb-3">
						<label for="ipGender" class="form-label">성별</label>
						<input type="text" name="gender" class="form-control" id="ipGender" placeholder="성별을 입력해주세요">
						<div id="ipGenderResult"></div>
					</div> -->
					
					<div class="row g-2">
						<div>
							<label for="ipBdate" class="form-label"><b>생년월일</b></label>
						</div>

						<div class="col-4">
							<input type="number" class="form-control b_date" name="yy" placeholder="년(4자)" maxlength="4">
						</div>
	
						<div class="col-4">
							<select class="form-select" name="mm">
								<option value="">월</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
							</select>
						</div>
	
						<div class="col-4">
							<input type="number" class="form-control b_date" name="dd" placeholder="일" maxlength="2">
						</div>
						<div id="ipBdateResult"></div>
					</div>
					
					<div class="mb-4">
						<div class="form-group">
							<label for="ipGender" class="form-label mt-4"><b>성별</b></label>
							<select class="form-select" name="gender">
								<option value="">성별</option>
								<option value="남자">남자</option>
								<option value="여자">여자</option>
								<option value="선택안함">선택안함</option>
							</select>
						</div>
						<!-- <input type="text" name="gender" class="form-control" id="ipGender" placeholder="성별을 입력해주세요"> -->
						<div id="ipGenderResult"></div>
					</div>
					
					<div class="row">
						<div>
							<label for="ipEmail" class="form-label"><b>이메일</b></label>
						</div>
						<div class="col-5">
							<input type="text" name="e" class="form-control" id="ipEmail" placeholder="이메일">
						</div>
						<div class="col-1">
							<label for="ipEmail" class="form-label"><b>@</b></label>
						</div>
						<div class="col-6">
							<select class="form-select" name="mail">
								<option value="">직접입력</option>
								<option value="@naver.com">naver.com</option>
								<option value="@daum.net">daum.net</option>
								<option value="@google.com">google.com</option>
							</select>
						</div>
						<div id="ipEmailResult"></div>
					</div>
					
					<div class="my-4">
						<label for="ipPhone" class="form-label"><b>연락처</b></label>
						<input type="tel" name="phone" class="form-control" id="ipPhone" placeholder="연락처를 입력해주세요">
						<div id="ipPhoneResult"></div>
					</div>
					
					<div class="mb-4">
						<input type="hidden" name="point" class="form-control" id="ipPoint">
					</div>

					<!-- 구분선 -->
					<hr class="my-5">

					<!-- 회원가입 버튼 -->
					<div class="d-grid gap-2 mt-3">
						<button type="submit" class="btn btn-outline-success" id="btn"><b>회원가입</b></button>
					</div>
				</form>
			</div>
		</div>
	</div>
<!-- 생년월일 input type number에 화살표 안나오게 하는 css-->
<style>
	.b_date::-webkit-outer-spin-button,
	.b_date::-webkit-inner-spin-button {
		-webkit-appearance: none;
	}
	</style>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<!-- <script src="/resources/js/member.js"></script> -->
</body>
</html>