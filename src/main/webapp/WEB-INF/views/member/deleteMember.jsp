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
</head>
<c:import url="../template/header.jsp"></c:import>
<body>
    
    
    <%-- 입력창 만들기 전 부트스트랩 쓸때 이걸 써야한다 --%>
    <%-- con-lg-7은 사이즈 조절하는것 --%>
	<section class="container-fluid con-lg-7">
        <div class="row mt-5">
            <!-- 제목부분 -->
            <h1>DeleteMemberPage</h1>
			<form action="./deleteMember" method="post">
                <div class="mb-3">
                    <label for="ipId" class="form-label">아이디</label>
                    <input type="text" name="id" class="form-control" id="ipId" value="${member.id}">
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

                  <div>
				    <button type="submit" class="btn btn-outline-success" id="btn">회원탈퇴</button>
			      </div>
            </form>
		</div>
	</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>