<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/index.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com"  />
<link
  href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap"
  rel="stylesheet"
/>
</head>
<c:import url="./template/header.jsp"></c:import>
<body>
    <main>
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
                    src="/resources/images/b5.png"
                    class="d-block w-60"
                    alt="..."
                    style="height: 300px"
                  />
                </div>
                <div class="carousel-item" data-bs-interval="3000">
                  <img
                    src="/resources/images/b4.png"
                    class="d-block w-60"
                    alt="..."
                    style="height: 300px"
                  />
                </div>
                <div class="carousel-item" data-bs-interval="3000">
                  <img
                    src="/resources/images/b3.png"
                    class="d-block w-60"
                    alt="..."
                    style="height: 300px"
                  />
                </div>
                <div class="carousel-item" data-bs-interval="3000">
                  <img
                    src="/resources/images/b1.png"
                    class="d-block w-60"
                    alt="..."
                    style="height: 300px"
                  />
                </div>
                <div class="carousel-item" data-bs-interval="3000">
                  <img
                    src="/resources/images/b2.png"
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
          
          <div class="d-flex flex-column" id="d1_2">
          		<div class="mb-2" style="margin:0 auto; width:80%; color: gray; font-size: 13.5px;">페이지를 더 안전하고 편리하게 이용하세요😊</div>
               <div class="submit">
               	  <input type="submit" value="Login">
               </div>
               <div class="d-flex justify-content-between mt-2" style="width: 80%; margin: 0 auto;">
	               	<div class="login"><a href="#">🔒아이디/비밀번호 찾기</a></div>
	               	<div class="login"><a href="#">👩‍💻회원가입</a></div>
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
           
           <div class="d-flex justify-content-between" id="d4">
            <c:forEach items="${list}" var="count">
              <div class="lecture">
                <div class="card" style="height:277px">
                  <img src="http://20.249.88.100/resources/lecture/${count.lectureFileDTO[0].f_name}" class="card-img-top img " alt="...">
                  <div class="card-text">
                    <h5 style="margin-top: 10px;">${count.l_name}</h5>⭐
                    <h7>⭐⭐⭐⭐⭐</h7>
                    <p>평점</p>
                  </div>
                </div>
              </div>
            </c:forEach>

            
            
		</div>
		
		<div class="hot"><span style="color: red;"><a href="#">왕초보도 할 수 있어요! 💪</a></div>
  
          <div  class="d-flex justify-content-between" id="d5" style="white-space:nowrap; overflow-x: auto;">
            <c:forEach items="${level}" var="lv">
              <div class="lecture">
                <div class="card" style="height:277px">
                  <img src="http://20.249.88.100/resources/lecture/${lv.lectureFileDTO[0].f_name}" class="card-img-top img " alt="...">
                  <div class="card-text">
                    <h5 style="margin-top: 10px;">${lv.l_name}</h5>
                    <h7>⭐⭐⭐⭐⭐</h7>
                    <p>평점</p>
                  </div>
                </div>
              </div>
            </c:forEach>
            
             <!-- <div class="lecture">
              <div class="card" style="height:277px">
                <img src="/resources/images/20.png" class="card-img-top img " alt="...">
                <div class="card-text">
                  <h5 style="margin-top: 10px;">자바스크립트 완전정복</h5>
                  <h7>⭐⭐⭐⭐⭐</h7>
                  <p>평점</p>
                </div>
              </div>
            </div>
            
             <div class="lecture">
              <div class="card" style="height:277px">
                <img src="/resources/images/20.png" class="card-img-top img " alt="...">
                <div class="card-text">
                  <h5 style="margin-top: 10px;">자바스크립트 완전정복</h5>
                  <h7>⭐⭐⭐⭐⭐</h7>
                  <p>평점</p>
                </div>
              </div>
            </div>
            
             <div class="lecture">
              <div class="card" style="height:277px">
                <img src="/resources/images/20.png" class="card-img-top img " alt="...">
                <div class="card-text">
                  <h5 style="margin-top: 10px;">자바스크립트 완전정복</h5>
                  <h7>⭐⭐⭐⭐⭐</h7>
                  <p>평점</p>
                </div>
              </div>
            </div>
            
            <div class="lecture">
              <div class="card" style="height:277px">
                <img src="/resources/images/20.png" class="card-img-top img " alt="...">
                <div class="card-text">
                  <h5 style="margin-top: 10px;">자바스크립트 완전정복</h5>
                  <h7>⭐⭐⭐⭐⭐</h7>
                  <p>평점</p>
                </div>
              </div>
            </div>
            
            
          </div> -->
          
          
          
          <!-- <div class="hot"><span style="color: red;"><a href="#">기본부터 실무까지 제시해주는 로드맵 🏃🏻‍♀️<span style="color: #fa4c3d; font-size: 12px; font-weight: 700;">RoadMap!!</span></a></div>
  
          <div  class="d-flex justify-content-between" id="d6" style="white-space:nowrap; overflow-x: auto;">
          
          	<div class="lecture">
              <div class="card" style="height:277px">
                <img src="/resources/images/20.png" class="card-img-top img " alt="...">
                <div class="card-text">
                  <h5 style="margin-top: 10px;">자바스크립트 완전정복</h5>
                  <h7>⭐⭐⭐⭐⭐</h7>
                  <p>평점</p>
                </div>
              </div>
            </div>
            
             <div class="lecture">
              <div class="card" style="height:277px">
                <img src="/resources/images/20.png" class="card-img-top img " alt="...">
                <div class="card-text">
                  <h5 style="margin-top: 10px;">자바스크립트 완전정복</h5>
                  <h7>⭐⭐⭐⭐⭐</h7>
                  <p>평점</p>
                </div>
              </div>
            </div>
            
             <div class="lecture">
              <div class="card" style="height:277px">
                <img src="/resources/images/20.png" class="card-img-top img " alt="...">
                <div class="card-text">
                  <h5 style="margin-top: 10px;">자바스크립트 완전정복</h5>
                  <h7>⭐⭐⭐⭐⭐</h7>
                  <p>평점</p>
                </div>
              </div>
            </div>
            
            <div class="lecture">
              <div class="card" style="height:277px">
                <img src="/resources/images/20.png" class="card-img-top img " alt="...">
                <div class="card-text">
                  <h5 style="margin-top: 10px;">자바스크립트 완전정복</h5>
                  <h7>⭐⭐⭐⭐⭐</h7>
                  <p>평점</p>
                </div>
              </div>
            </div>
            
            <div class="lecture">
              <div class="card" style="height:277px">
                <img src="/resources/images/20.png" class="card-img-top img " alt="...">
                <div class="card-text">
                  <h5 style="margin-top: 10px;">자바스크립트 완전정복</h5>
                  <h7>⭐⭐⭐⭐⭐</h7>
                  <p>평점</p>
                </div>
              </div>
            </div>
          -->
        </div>
        
        <div class="hot"><span style="color: red;"><a href="#">읽어보기 📖</a></div>
        
        <div id="d7"></div>
        
        <div class="d-flex mt-4 mb-5" id="d8">
        	<div class="pt-2 pe-5 d-flex flex-column" style="width: 50%; border: solid 2px;">
        		<div class="mt-5" style="font-size: 35px; font-weight: bold;"><span style="color:#47c880;">10</span> 명이</div>
        		<div class="mb-4" style="font-size: 35px; font-weight: bold;">일석이조와 함께합니다.</div>
        		<div class="" style="font-size: 16px; color:gray">일석이조는 강의의 수강생수, 평점을 투명하게 공개합니다. 실제로 많은 온오프라인 학원들은 단기적 성과를 높이기 위해 잘나온 특정 후기만 노출 하거나, 아예 숨겨버리는 경우가 많습니다.
반면 일석이조는 강의에 대한 후기, 학생수 등 정보를 투명하게 공개합니다. 신뢰성을 바탕으로 학습자들이 더 좋은 컨텐츠를 선택하고 교육의 질을 높입니다.</div>
				<div class="mt-4">
						<button type="button" class="btn btn-outline-success">수강평 더보기</button>
						<button type="button" class="btn btn-outline-success">기능/강좌 요청하기</button>
				</div>
        	</div>
        	<div class="p-4 d-flex flex-column" style="width: 50%; border: solid 2px;">수강평 몇개 가져오기</div>
        </div>
        
        
        
      </main>
<c:import url="./template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>