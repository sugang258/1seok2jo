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
	<section class="container-fluid ilseok">
		<div class="row justify-content-center mt-5">
			<%-- 회원 회원가입JSP --%>
			<form action="./join" method="post">
			
			  <div class="mb-3">
			    <label for="ipId" class="form-label">아이디</label>
			    <input type="text" name="id" class="form-control" id="ipId" placeholder="아이디를 입력해주세요">
					<div id="ipIdResult"></div>
			  </div>
			  
			  <div class="mb-3">
			    <label for="ipPw" class="form-label">비밀번호</label>
			    <input type="password" name="pw" class="form-control" id="ipPw" placeholder="비밀번호를 입력해주세요">
					<div id="ipPwResult"></div>
			  </div>
			  
			  <div class="mb-3">
			    <label for="ipPwCheck" class="form-label">비밀번호 재확인</label>
			    <input type="password" class="form-control" id="ipPwCheck" placeholder="비밀번호를 다시 입력해주세요">
					<div id="ipPwCheckResult"></div>
			  </div>
			  
			  <div class="mb-3">
			    <label for="ipName" class="form-label">이름</label>
			    <input type="text" name="name" class="form-control" id="ipName" placeholder="이름을 입력해주세요">
					<div id="ipNameResult"></div>
			  </div>
			  
			  <div class="mb-3">
			    <label for="ipNname" class="form-label">닉네임</label>
			    <input type="text" name="n_name" class="form-control" id="ipNname" placeholder="닉네임을 입력해주세요">
					<div id="ipNnameResult"></div>
			  </div>
			  
			  <div class="mb-3">
			    <label for="ipBdate" class="form-label mt-4">생년월일</label>
				<div class="bir_yy">
					<span class="ps_box">
						<input type="text" class="form-control" id="yy" placeholder="년(4자)" maxlength="4">
					</span>
				</div>
				<div class="bir_mm">
					<span class="ps_box focus">
						<select class="form-select" name="" id="mm" id="exampleSelect1">
							<option value="">월</option>
							<option value="">1</option>
							<option value="">2</option>
							<option value="">3</option>
							<option value="">4</option>
							<option value="">5</option>
							<option value="">6</option>
							<option value="">7</option>
							<option value="">8</option>
							<option value="">9</option>
							<option value="">10</option>
							<option value="">11</option>
							<option value="">12</option>
						</select>
					</span>
				</div>
				<div class="bir_dd">
					<span class="ps_box">
						<input type="text" class="form-control" id="dd" placeholder="일" maxlength="2">
					</span>
				</div>
				<div id="ipBdateResult"></div>
			  </div>

			  <div class="mb-3">
				<div class="form-group">
					<label for="ipGender" class="form-label mt-4">성별</label>
					<select class="form-select" id="exampleSelect1">
						<option value="">남자</option>
						<option value="">여자</option>
						<option value="">선택안함</option>
					</select>
				</div>
			    <input type="text" name="gender" class="form-control" id="ipGender" placeholder="성별을 입력해주세요">
					<div id="ipGenderResult"></div>
			  </div>

			  <div class="mb-3">
			    <label for="ipEmail" class="form-label">이메일</label>
			    <input type="text" name="email" class="form-control" id="ipEmail" placeholder="이메일을 입력해주세요">
					<div id="ipEmailResult"></div>
			  </div>
			  
			  <div class="mb-3">
			    <label for="ipPhone" class="form-label">연락처</label>
			    <input type="tel" name="phone" class="form-control" id="ipPhone" placeholder="연락처를 입력해주세요">
					<div id="ipPhoneResult"></div>
			  </div>
			  
			  <div class="mb-3">
			    <input type="hidden" name="point" class="form-control" id="ipPoint">
			  </div>

			  <div>
				  <button type="submit" class="btn btn-outline-success" id="btn">회원가입</button>
			  </div>
			  
			</form>
		</div>
	</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<!-- <script src="/resources/js/member.js"></script> -->
</body>
</html>