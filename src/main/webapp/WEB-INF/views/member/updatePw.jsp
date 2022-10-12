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
                    <!-- 제목부분 -->
                    <h1><b>비밀번호 변경✒</b></h1>
                </div>
                <form action="./updatePw" method="post" id="updatePwForm">
                    
                    <div class="mb-3">
                        <label for="now_pw" class="form-label">현재 비밀번호</label>
                        <input type="password" name="now_pw" class="form-control border-success border-opacity-25" id="now_pw" placeholder="현재 비밀번호를 입력하세요">
                    </div>

                    <div class="mb-3">
                        <label for="new_pw" class="form-label">새 비밀번호</label>
                        <input type="password" name="new_pw" class="form-control border-success border-opacity-25" id="ipnew_pw" placeholder="새 비밀번호를 입력하세요">
                    </div>
                    
                    <div class="mb-3">
                        <label for="pw_check" class="form-label">새 비밀번호 확인</label>
                        <input type="password" class="form-control border-success border-opacity-25" id="pw_check" placeholder="새 비밀번호를 다시 입력하세요">
                    </div>

                    <!-- 구분선 -->
					<div class="text-success">
						<hr class="my-5">
					</div>

                    <!-- 비밀번호변경 버튼 -->
                    <div class="d-grid gap-2 mt-3">
                        <button type="button" class="btn btn-outline-success" id="btn">확인</button>
                    </div>
                </form>
            </div>
		</div>
	</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script src="/resources/js/member_update.js"></script>
<script>
    updatePwCheck();
</script>
</body>
</html>