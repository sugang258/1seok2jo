<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="/resources/css/header.css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
    href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap"
    rel="stylesheet"
  />
</head>

<body>
  <header id="header">
    <nav class="navbar navbar-expand-lg container fixed-top" 
    style="background-color:rgb(255, 255, 255);
    padding-top: 15px;">
      <div class="container-fluid" style="
      height: 50px;">
        <a class="navbar-brand" href="/" style="margin-right: 25px"
          ><img src="/resources/images/15.png" style="width: 120px; height: 65px"
        /></a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent" style="background-color: white;">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <c:if test="${not empty member}">
              <c:forEach items="${sessionScope.member.roleDTOs}" var="r">
                <c:if test="${r.getRoleName() eq '관리자'}">
                  <li class="nav-item">
                    <a class="nav-link" href="/admin/login">관리HOME</a>
                  </li>
                </c:if>
              </c:forEach>
            </c:if>
            <li class="nav-item">
              <a class="nav-link" href="/lecture/list">강의</a>
            </li>
            <c:set var="teacher" value="false" />
            <c:if test="${not empty member}">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">강사</a>
              <ul class="dropdown-menu">
                  <c:forEach items="${sessionScope.member.roleDTOs}" var="r">
                     <c:if test="${r.getRoleName() eq '강사'}">
                      <c:set var="teacher" value="true"></c:set>
                      <li><a class="dropdown-item add"  href="/lecture/add">강의 추가</a></li>
                      <li><a class="dropdown-item service" href="/lecture/teacher">내 강의 관리</a></li>
                      <li><a class="dropdown-item service" href="/teacher/salesList">강의 매출 목록</a></li>
                      </c:if>
                  </c:forEach>
                  <c:if test="${teacher eq 'false'}">
                    <li><a class="dropdown-item empty" href="/member/teacherAdd">강사 신청</a></li>
                  </c:if>
              </ul>
            </li>
            </c:if>
            <c:if test="${not empty member}">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">마이페이지</a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="/member/profile">프로필</a></li>
                <li><a class="dropdown-item" href="/status/sign">내 학습</a></li>
                <li><a class="dropdown-item" href="/member/board">내 게시판</a></li>
                <li><a class="dropdown-item" href="/pay/myList">내 결제내역</a></li>
              </ul>
            </li>
          </c:if>
          <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            커뮤니티
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/board/sb_list">학습게시판</a></li>
            <li><a class="dropdown-item" href="/board/fb_list">자유게시판</a></li>
          </ul> 
         </li>
         <li class="nav-item dropdown">
	         <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	           공지사항
	         </a>
	         <ul class="dropdown-menu">
	           <li><a class="dropdown-item" href="/board/notice">공지사항</a></li>
             <c:if test="${not empty member}">
               <li><a class="dropdown-item" href="/csBoard/mylist">1대1문의</a></li>
             </c:if>
	           <li><a class="dropdown-item" href="/board/faq">자주묻는질문</a></li>
	         </ul>
          </li>
        </ul>

          <div style="width: 230px">
            <c:if test="${empty member}">
            <button
              type="button"
              class="top_button"
              style="margin-right: 10px; float: right;"
              onclick="location.href='/member/login';"
            >
            🔐로그인
            </button>

            <button type="button" class="top_button" style="margin-right: 10px; float: right;" onclick="location.href='/member/join';">👩‍💻회원가입</button>
            </c:if>
            <c:if test="${not empty member}">

            <input type="button" class="btn" id="cartt" onclick="location.href='/member/cart'" style="margin-right: 10px; float: right; font-size:x-large;" value="🛒"/>
            </c:if>
          </div>
        </div>
      </div>
    </nav>
  </header>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
<script src="/resources/js/header.js"></script>
<script>setLoginCheck()</script>
</html>