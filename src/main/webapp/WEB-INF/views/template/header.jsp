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
        <a class="navbar-brand" href="#" style="margin-right: 25px"
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
            <li class="nav-item">
              <a class="nav-link" href="../../../../../">일석이조</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/lecture/list">강의</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">로드맵</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">멘토링</a>
            </li>
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
	           <li><a class="dropdown-item" href="/board/faq">자주묻는질문</a></li>
	         </ul>
          </li>
        </ul>

          <form style="width: 190px">
            <button
              type="button"
              class="top_button"
              style="margin-right: 10px"
            >
              🔐로그인
            </button>
            <button type="button" class="top_button">👩‍💻회원가입</button>
          </form>
        </div>
      </div>
    </nav>
  </header>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>

</html>