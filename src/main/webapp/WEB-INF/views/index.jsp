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
		<%-- favicon --%>
		<link rel="shortcut icon" href="/resources/images/favicon.ico">
</head>
<c:import url="./template/header.jsp"></c:import>
<body>
    <main>
        <div id="d1" class="container-fluid">
          <div class="row g-0 justify-content-center">
            <div id="d1_1" class="col-lg-8 d-none d-lg-block">
              <div
                id="carouselExampleInterval"
                class="carousel slide"
                data-bs-ride="carousel"
                style="height: 300px; width: 850px; float: right;"
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
            <div class="col-lg-3 col-6">
            <c:if test="${empty member}">
              <div class="d-flex flex-column mx-auto mx-lg-none" id="d1_2">
                  <div class="mb-2" style="margin:0 auto; color: gray; font-size: 13.5px;">???????????? ??? ???????????? ???????????? ???????????????????</div>
                  <div class="submit">
                      <input type="button" value="Login" onclick="location.href='/member/login'">
                  </div>
                  <div class="login"style="margin:0 auto; color: gray; font-size: 13.5px;"><a href="/member/join">????????????????? ?????? ??????????????? ????????? ?????????</a></div>
                  <div class="d-flex justify-content-center mt-2" style="width: 80%; margin: 0 auto;">
                      
                      <div class="login row"><a href="/member/join">????????????????</a></div>
                  </div>
              </div>
            </c:if>
            <c:if test="${not empty member}">
              <div class="d-flex flex-column mx-auto mx-lg-none" id="d1_3">
                <div class="mb-2" style="margin:0 auto; color: gray; font-size: 13.5px;">${member.n_name}??? ???????????????????</div>
                <div class="row my-1">
                  <a href="/member/profile"><img src="http://20.249.88.100/resources/member/${f_name}"  class="borders boarder-dark p-2 mb-2 border-opacity-50 mx-auto d-block" style=" max-width: 150px;  height: 150px;  border-radius: 25px;"></a>
                </div>
                <div class="d-flex justify-content-center mt-2" style="width: 80%; margin: 0 auto;">
                    <div class="login"><a href="/member/logout">????Logout</a></div>
                </div>
            </div>
            </c:if>
            </div>
          </div>     
        </div>
       
        
        <div class="container">
          <div id="d2">
            <h4 style="text-align: center" class="mt-5 mb-4">
              ??????????????? ????????? ???????????????.?????????????????
            </h4>
            <div class="search-bar">
              <input
                type="search"
                placeholder="????????? ?????? ????????? ??????????????????."
              />
              <button id="seach_logo" class="seach-logo">
                <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
              </button>
            </div>
          </div>
  
          <div class="hot"><span style="color: red;">HOT</span>??? <a href="#">?????? ?????? ?????? ?????? ?????? ????</a></div>
           
           <div class="d-flex justify-content-between" id="d4">
            <c:forEach items="${list}" var="count" varStatus="countNm">
              <div class="lecture" data-l-num="${count.l_num}">
                <div class="card" style="height:350px">
                  <img src="http://20.249.88.100/resources/lecture/${count.lectureFileDTO[0].f_name}" class="card-img-top img " alt="...">
                  <div class="card-body">
                    <div class="card-text">
                      <div class="fw-bolder mb-2" style="margin-top: 10px; font-size: 16px; white-space:normal;">${count.l_name}</div>
                      <p style="font-size: 14px; margin-bottom: 0px;">????????????????? <span style="font-size: 12px;">${avg[countNm.index]} </span></p>
                      <h7>
		                  <c:choose>
		                  	  <c:when test="${avg[countNm.index] < 1}"></c:when>
			                  <c:when test="${avg[countNm.index] >=1 && avg[countNm.index] < 2}">???</c:when>
			                  <c:when test="${avg[countNm.index] >=2 && avg[countNm.index] < 3}">??????</c:when>
			                  <c:when test="${avg[countNm.index] >=3 && avg[countNm.index] < 4}">?????????</c:when>
			                  <c:when test="${avg[countNm.index] >=4 && avg[countNm.index] < 5}">????????????</c:when>
		                  <c:otherwise>???????????????</c:otherwise>
		                  </c:choose>
                      </h7>
                      <div class="tags">
                        <span class="tag " style="font-size: 15px; background-color: hsl(321,63%,90%); border-radius: 7px;">+${count.l_count}???</span>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
		</div>
		
		<div class="hot"><span style="color: red;"><a href="#">???????????? ??? ??? ?????????! ????</a></div>
  
          <div  class="d-flex justify-content-between" id="d5" style="white-space:nowrap; overflow-x: auto;">
            <c:forEach items="${level}" var="lv"  varStatus="lvNm">
              <div class="lecture" data-l-num="${lv.l_num}">
                <div class="card" style="height:350px">
                  <img src="http://20.249.88.100/resources/lecture/${lv.lectureFileDTO[0].f_name}" class="card-img-top img " alt="...">
                  <div class="card-body">
                  <div class="card-text">
                    <div class="fw-bolder mb-2" style="margin-top: 10px; font-size: 16px; white-space:normal;">${lv.l_name}</div>
                    <p style="font-size: 14px; margin-bottom: 0px;">????????????????? <span style="font-size: 12px;">${avgg[lvNm.index]} </span></p>
                    <h7>
                    	<c:choose>
		                  	  <c:when test="${avgg[lvNm.index] < 1}"></c:when>
			                  <c:when test="${avgg[lvNm.index] >=1 && avgg[lvNm.index] < 2}">???</c:when>
			                  <c:when test="${avgg[lvNm.index] >=2 && avgg[lvNm.index] < 3}">??????</c:when>
			                  <c:when test="${avgg[lvNm.index] >=3 && avgg[lvNm.index] < 4}">?????????</c:when>
			                  <c:when test="${avgg[lvNm.index] >=4 && avgg[lvNm.index] < 5}">????????????</c:when>
		                  <c:otherwise>???????????????</c:otherwise>
		                </c:choose>
                    </h7>
                    <div class="tags">
                      <span class="tag " style="font-size: 15px; background-color: hsl(321,63%,90%); border-radius: 7px;">+${lv.l_count}???</span>
                    </div>
                  </div>
                </div>
                </div>
              </div>
            </c:forEach>

        </div>
        
        <div class="hot"><span style="color: red;"><a href="#">???????????? ????</a></div>
        
        <div class="d-flex" id="d7">
        	<div class="d-flex flex-column" style="width: 33.3%; height:300px; padding-right: 2em;">
        		<div style="width: 100%; height:200px; margin: 0 auto;"><img alt="" src="/resources/images/54.png" style="width: 100%; height: 100%;"></div>
        		<div class="pt-3 pb-3" style="width: 100%; height:110px; margin: 0 auto; font-size: 20px;"><b>R ??? ?????????, ????????? ????????? ????????????!</b></div>
        	</div>
        	<div class="d-flex flex-column" style="width: 33.3%; height:300px;  padding-right: 1em;">
        		<div style="width: 100%; height:200px; margin: 0 auto;"><img alt="" src="/resources/images/50.png" style="width: 100%; height: 100%;"></div>
        		<div class="pt-3 pb-3" style="width: 100%; height:110px; margin: 0 auto; font-size: 20px;"><b>?????? ????????? ???????????? ????????? ???????</b></div>
        	</div>
        	<div class="d-flex flex-column" style="width: 33.3%; height:300px; padding-left: 1em;">
        		<div style="width: 100%; height:200px; margin: 0 auto;"><img alt="" src="/resources/images/51.png" style="width: 100%; height: 100%;"></div>
        		<div class="pt-3 pb-3" style="width: 100%; height:110px; margin: 0 auto; font-size: 20px;"><b>[???????????? ?????? #9] ????????? ?????????! 2022 ????????? ??????</b></div>
        	</div>
        </div>
        
        <div class="d-flex mt-4 mb-5" id="d8">
        	<div class="pt-2 pe-5 d-flex flex-column" style="width: 50%;">
        		<div class="mt-5" style="font-size: 35px; font-weight: bold;"><span id="cntMember" style="color:#47c880;">${cntMember}</span> ??????</div>
        		<div class="mb-4" style="font-size: 35px; font-weight: bold;">??????????????? ???????????????.</div>
        		<div class="" style="font-size: 16px; color:gray">??????????????? ????????? ????????????, ????????? ???????????? ???????????????. ????????? ?????? ??????????????? ???????????? ????????? ????????? ????????? ?????? ????????? ?????? ????????? ?????? ?????????, ?????? ??????????????? ????????? ????????????.
?????? ??????????????? ????????? ?????? ??????, ????????? ??? ????????? ???????????? ???????????????. ???????????? ???????????? ??????????????? ??? ?????? ???????????? ???????????? ????????? ?????? ????????????.</div>
				<div class="mt-4">
						<button type="button" class="btn btn-outline-success" onclick="location.href='/lecture/list';">?????? ?????????</button>
            <c:if test="${not empty member}">
              <button type="button" class="btn btn-outline-success" onclick="location.href='/csBoard/mylist';">1??? 1 ??????</button>
            </c:if>
				</div>
        	</div>
        	<div class="p-5 d-flex flex-column" style="width: 50%;">
        		<div><img alt="" src="/resources/images/521.gif" style="width: 100%; height: 100%;"></div>
        		<div class="mt-3 mb-3" style="font-size: 32px;"><b>????????? ???????????? ????????? ????????? ??????</b></div>
        		<div class="mb-3" style="font-size: 18px; color: gray;">???????????? ?????????????????? ?????? ????????? ????????? ??????????????????.</div>
        	</div>
        </div>
        
       
      </main>
<c:import url="./template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script src="/resources/js/index.js"></script>
</body>
</html>