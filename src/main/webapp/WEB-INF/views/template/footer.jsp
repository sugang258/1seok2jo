<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
    href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap"
    rel="stylesheet"
  />
</head>
<body>
    <footer>
        <div class="end-var">
          <div class="end-container">
            <div class="end-meun">
              <div class="first-menu">
                <div class="bottom-menu-bar">
                  <img
                    src="/resources/images/15.png"
                    width="130" height="75"
                  />
                </div>
                <div class="bottom-menu-bar">
                  <h1>일석이조</h1>
                  <h2>일석이조 소개</h2>
                  <h2>프로젝트 과정</h2>
                  <h2>프로젝트 결과</h2>
                  <h2>프로젝트 소감</h2>
                </div>
                <div class="bottom-menu-bar">
                  <div>
                    <h1>고객센터</h1>
                    <h2>자주묻는 질문</h2>
                    <h2>수료증 확인</h2>
                    <h2>이용약관</h2>
                  </div>
                </div>
                <div class="bottom-menu-bar">
                  <div>
                    <h1>신청하기</h1>
                    <h2>지식공유 참여</h2>
                    <h2>멘토링 소개</h2>
                    <h2>인프런X대학교</h2>
                  </div>
                </div>
                <div class="bottom-menu-bar">
                  <div>
                    <h1>학습하기</h1>
                    <h2>IT 프로그래밍</h2>
                    <h2>크리에이티브</h2>
                    <h2>수강코드 등록</h2>
                  </div>
                </div>
              </div>
              <div class="second-menu">
                <div id="map" style="width:300px;height:170px;"></div>
                <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=67a15d0ede53def65514d5bb44685f5a"></script>
                <script>
                  var container = document.getElementById('map');
                  var options = {
                    center: new kakao.maps.LatLng(37.47807428498916, 126.87930082685244),
                    level: 3
                  };

                  var map = new kakao.maps.Map(container, options);

                  var markerPosition  = new kakao.maps.LatLng(37.47807428498916, 126.87930082685244); 

                  // 마커를 생성합니다
                  var marker = new kakao.maps.Marker({
                      position: markerPosition
                  });

                  // 마커가 지도 위에 표시되도록 설정합니다
                  marker.setMap(map);
                </script>
                <div></div>
                <!-- <div class="icon" style="color: rgb(0, 140, 255)">
                  <a style="color: rgb(0, 140, 255);" href="https://twitter.com/?lang=ko"><i class="fa-brands fa-twitter"></i></a>
                </div>
                <div class="icon" style="color: rgb(208, 34, 98)">
                  <a style="color: rgb(208, 34, 98);" href="https://www.instagram.com/"><i class="fa-brands fa-instagram-square"></i></a>
                </div>
                <div class="icon" style="color: rgb(0, 85, 255)">
                  <a style="color: rgb(0, 85, 255)" href="https://www.facebook.com/"><i class="fa-brands fa-facebook"></i></a>
                </div>
                <div></div> -->
              </div>
            </div>
  
            <div class="end-line"></div>
  
            <div class="end-second-line">
              <div class="topmenu_bar">
                <a class="topmenu" href="#">Premium |</a>
                <a class="topmenu" href="#">Suppor |</a>
                <a class="topmenu" href="#">Download |</a>
                <a class="topmenu" href="#">Sign up |</a>
                <a class="topmenu" href="#">Log in</a>
              </div>
              <div>
                @2022 일석이조 프로젝트 <br />구효경 심예지 김설희 홍수경
              </div>
            </div>
          </div>
        </div>
      </footer>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script
src="https://kit.fontawesome.com/6e23c67242.js"
crossorigin="anonymous"
></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script>
</html>