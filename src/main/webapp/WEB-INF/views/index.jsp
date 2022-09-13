<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/index.css" />
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
  crossorigin="anonymous"
/>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
  href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap"
  rel="stylesheet"
/>
</head>
<body>
    <main class="container">
        <div id="d1">
          <div id="d1_1">
            <div
              id="carouselExampleInterval"
              class="carousel slide"
              data-bs-ride="carousel"
              style="height: 300px"
            >
              <div class="carousel-inner" style="height: 350px">
                <div class="carousel-item active" data-bs-interval="3000">
                  <img
                    src="/resources/images/1.png"
                    class="d-block w-60"
                    alt="..."
                    style="height: 300px"
                  />
                </div>
                <div class="carousel-item" data-bs-interval="3000">
                  <img
                    src="/resources/images/2.gif"
                    class="d-block w-60"
                    alt="..."
                    style="height: 300px"
                  />
                </div>
                <div class="carousel-item" data-bs-interval="3000">
                  <img
                    src="/resources/images/3.png"
                    class="d-block w-60"
                    alt="..."
                    style="height: 300px"
                  />
                </div>
                <div class="carousel-item" data-bs-interval="3000">
                  <img
                    src="/resources/images/6.png"
                    class="d-block w-60"
                    alt="..."
                    style="height: 300px"
                  />
                </div>
                <div class="carousel-item" data-bs-interval="3000">
                  <img
                    src="/resources/images/5.png"
                    class="d-block w-60"
                    alt="..."
                    style="height: 300px"
                  />
                </div>
              </div>
              <button
                class="carousel-control-prev"
                type="button"
                data-bs-target="#carouselExampleInterval"
                data-bs-slide="prev"
              >
                <span
                  class="carousel-control-prev-icon"
                  aria-hidden="true"
                ></span>
                <span class="visually-hidden">Previous</span>
              </button>
              <button
                class="carousel-control-next"
                type="button"
                data-bs-target="#carouselExampleInterval"
                data-bs-slide="next"
              >
                <span
                  class="carousel-control-next-icon"
                  aria-hidden="true"
                ></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div>
          </div>
          <div id="d1_2">
            <div>
              <div class="login">
                  <h1 style="
                  margin-bottom: 0px;
                  margin-top: 8px;
                  color: coral;
              "><b>Log-in</b></h1>
                  <div class="login_id">
                      <h3 style="
                      margin-bottom: 0px;
                  ">E-mail</h3>
                      <input type="email" name="" id="" placeholder="Email">
                  </div>
                  <div class="login_pw">
                      <h3 style="
                      margin-bottom: 0px;
                  ">Password</h3>
                      <input type="password" name="" id="" placeholder="Password">
                  </div>
                  <a href="#" style="color: rgb(57, 216, 244); text-decoration: none;">아이디 / 비번찾기 <span style="font-size: 16px;">🔍</span></a>
                  <div class="submit">
                    <input type="submit" value="Login">
                  </div>
              </div>
          </div>
          </div>
        </div>
        <div class="container">
          <div id="d2">
            <h4 style="text-align: center" class="mt-5 mb-4">
              성장기회의 평등을 추구합니다.🚶‍♀️🏃
            </h4>
            <div class="search-bar">
              <input
                type="search"
                placeholder="배우고 싶은 지식을 입력해보세요."
              />
              <button id="seach_logo" class="seach-logo">
                <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
              </button>
            </div>
          </div>
  
          <div class="hot"><span style="color: red;">HOT</span>❗ <a href="#">너도 나도 듣는 인기 강의 👉</a></div>
  
          <div id="d3">
  
            <div class="lecture">
              <div class="card" style="height:277px">
                <img src="/resources/images/21.png" style="height: 60%;" class="card-img-top img " alt="...">
                <div class="card-text">
                  <h5 style="margin-top: 10px;">자바 완전정복</h5>
                  <h7>⭐⭐⭐⭐⭐</h7>
                  <p>평점</p>
                </div>
              </div>
            </div>
  
            <div class="lecture">
              <div class="card" style="height:277px">
                <img src="/resources/images/20.png" style="height: 60%;" class="card-img-top img " alt="...">
                <div class="card-text">
                  <h5 style="margin-top: 10px;">자바스크립트 완전정복</h5>
                  <h7>⭐⭐⭐⭐⭐</h7>
                  <p>평점</p>
                </div>
              </div>
            </div>
  
            <div class="lecture">
              <div class="card" style="height:277px">
                <img src="/resources/images/22.png" style="height: 60%;" class="card-img-top img " alt="...">
                <div class="card-text">
                  <h5 style="margin-top: 10px;">HTML마스터하기</h5>
                  <h7>⭐⭐⭐⭐⭐</h7>
                  <p>평점</p>
                </div>
              </div>
            </div>
  
            <div class="lecture">
              <div class="card" style="height:277px">
                <img src="/resources/images/23.png" style="height: 60%;" class="card-img-top img " alt="...">
                <div class="card-text">
                  <h5 style="margin-top: 10px;">스프링 특강</h5>
                  <h7>⭐⭐⭐⭐⭐</h7>
                  <p>평점</p>
                </div>
              </div>
            </div>
  
          </div>
  
          <div id="d4"></div>
  
          <div id="d5"></div>
        </div>
      </main>

</body>
</html>