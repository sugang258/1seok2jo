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
		<link
		  href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap"
		  rel="stylesheet"
		/>
		<%-- favicon --%>
		<link rel="shortcut icon" href="/resources/images/favicon.ico">
		<link rel="stylesheet" href="/resources/css/admin/bscommon.css">
</head>
<c:import url="../template/header.jsp"></c:import>
<body>
	<%-- 회원 로그인JSP --%>
	<main class="container ilseok">
		<div style="margin-top: 10em; text-align: center; color: rgb(11, 138, 11);"><h2>🔐<b>LOGIN PAGE</b></h2></div>
		<div class="login_main" style="box-shadow: rgba(0, 0, 0, 0.1) 0px 4px 6px -1px, rgba(0, 0, 0, 0.06) 0px 2px 4px -1px; width: 460px; height: 330px; margin: 2em auto 5em auto;">
			<form action="" method="post" id="">
				<div class="row">
					<div><h5 style="height: 70px;line-height: 80px; padding-left: 38px;"><i class="fa-solid fa-right-to-bracket" style="color: rgb(56, 221, 56);"></i><b> ID 로그인</b></h5></div>
					<div class="row" style="justify-content: center;">

						<div class="col-sm-10 mb-3">
							<label class="mb-2 text-muted" for="id">ID</label>
							<input type="text" class="form-control" name = "id" id= "id" placeholder="아이디">
						</div>

						<div class="col-sm-10 mb-3">
							<label class="text-muted" for="password">Password</label>
							<input type="password" class="form-control"  id= "pw" name = "pw" placeholder="비밀번호">
						</div>

						<div class="col-sm-10 mb-3">
							<button type="submit" class="btn ms-auto btn-outline-success">로그인</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</main>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>