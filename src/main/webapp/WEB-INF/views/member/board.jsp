<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="/resources/css/index.css" />
<link rel="stylesheet" href="/resources/css/member/board.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
  href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap"
  rel="stylesheet"
/>
<link rel="shortcut icon" href="/resources/images/favicon.ico">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 게시판</title>
</head>
<c:import url="../template/header.jsp"></c:import>
<body>
    <main class="container mt-2">
        <div class="py-3 text-center">
            <h1 style="display: inline;">📋내 게시판</h1>
        </div>
        <div>
            <button class="list bold" id="free">자유게시판</button>
            <button class="list" id="study">학습게시판</button>
            <button class="list" id="lecture">내가 작성한 수강평</button>
        </div>
        <section class="container" style="width: 750px;">
          
        <div id="result">
          <c:if test="${size == 0}">
            <div class="text-center mt-5" style="font-weight: bold;">
              <div id="null">아직 작성한 게시글이 없습니다.</div>
              <div id="null2">게시글을 작성해 보세요!</div>
              <input type="button" class="board_list" id="board_list" value="자유게시판 가기"  style="background-color: #66ba39; color: white; border:none;">
            </div>
          </c:if>
            <c:forEach items="${f_board}" var="fb">
              <div class="contents_box">
                <div
                  class="board" id="board" data-fb-num="${fb.fb_num}">
                  <div style="padding: 12px 0px">
                    <div class="d-flex">
                      <div
                        class="p-2 flex-grow-1"
                        style="font-size: 13.5px; margin-left: -6.5px"
                      >
                        <div>🏷️${fb.category}</div>
                      </div>
                      <div class="p-2">
                        <i class="fa-regular fa-user"></i> ${fb.id}
                      </div>
                    </div>
                    <div
                      style="margin-bottom: 33px; margin-top: 5px; margin-left: 2px"
                    >
                      <h5 style="padding-left: 4px">
                        <b>${fb.title}</b>
                      </h5>
                    </div>
    
                    <div class="d-flex">
                      <div class="d-flex p-1 w-100">
                        <div class="b1 p-1 d-flex sort" style="font-size: 14.5px">
                          <div>${fb.hit} 조회</div>
                        </div>
                      </div>
                      <div
                        class="p-2 flex-shrink-1"
                        style="width: 116px; font-size: 14px; text-align: right"
                      >
                        ${fb.reg_date}
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
          </div>
        </section>
    </main>
    
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script src="/resources/js/board.js"></script>
</body>
</html>