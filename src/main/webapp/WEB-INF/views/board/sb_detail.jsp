<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="/resources/css/board/sb_detail.css" />
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

    <section class="container">


      <div class="board">

        <div class="board_contents">
          <div style="padding: 12px 0px;">
            <div class="d-flex">
              <div class="p-2 flex-grow-1">
                <div>자바</div>
              </div>
              <div class="p-2"><i class="fa-regular fa-user"></i> 아이디</div>
            </div>
            <div>
              <h5><b>프로그래밍 언어의 종류에 대하여</b></h5>
            </div>

            <div class="d-flex mt-4">
              <div class="d-flex p-1 w-100">
                <div class="b1 d-flex">
                  <div>0 조회</div>
                  <div><b>답변대기</b></div>
                </div>
              </div>
              <div class="p-2 flex-shrink-1">2022/09/14</div>
            </div>
          </div>
        </div>

        <!--Contents-->
        <div class="sb_contents">
          <div class="mb-3">
            <h5 style="text-align:justify; text-justify:auto;">질문 내용을 입력해 주세요.
              C 자바 등 프로그래밍 언어를 소개시켜 주셨는데 HTML 관련 이야기는 없더라구요 HTML은 프로그래밍 언어인가요? 아니면 HTML은 프로그래밍 언어에 포함되지 않나요</h5>
          </div>
          <div style="width: 100%;">
            <img style="width: 80%; object-fit: fill;" src="https://www.researchgate.net/profile/Md-Masudur-Rahman-2/publication/317401664/figure/fig2/AS:504826271408129@1497371370743/Source-Code-Example-Customerjava-Partial.png" alt="">
          </div>
          
          <div>
            <div class="d-flex mt-4">
              <div class="p-2 flex-grow-1">🗨 댓글 0개</div>
              <div class="p-2 share"><a href="#" onclick="clip(); return false;"><i class="fa-solid fa-share-nodes" style="color: rgb(15, 156, 50);"></i> 공유하기</a></div>
              <div class="p-2"><i style="color: rgb(15, 156, 50);"class="fa-solid fa-caret-down"></i><button id="reply"> 댓글</button></div>
            </div>
          </div>
          
          <!--Reply-Content-->
          <div class="reply_list p-3" id="reply_list">
            <div class="d-flex mb-2">
              <div><img src="https://img.danawa.com/prod_img/500000/017/350/img/13350017_1.jpg?shrink=330:330&_v=20210224095944" style="width: 50px;  border-radius: 24px;"/></div><div class="ms-2 mt-3">USER1</div>
            </div>
            <div class="d-flex mb-2">
              <div class="ms-5"><i class="fa-regular fa-comment-dots"></i></div>
              <div class="ms-2">안녕하세요 수고 많으십니다^^</div>
            </div>
            <hr>

            <div class="d-flex mb-2">
              <div><img src="https://img.danawa.com/prod_img/500000/017/350/img/13350017_1.jpg?shrink=330:330&_v=20210224095944" style="width: 50px; border-radius: 24px;"/></div><div class="ms-2 mt-3">USER1</div>
            </div>
            <div class="d-flex mb-2">
              <div class="ms-5"><i class="fa-regular fa-comment-dots"></i></div>
              <div class="ms-2">안녕하세요 수고 많으십니다^^</div>
            </div>
            <hr>

            <div class="d-flex mb-2">
              <div><img src="https://img.danawa.com/prod_img/500000/017/350/img/13350017_1.jpg?shrink=330:330&_v=20210224095944" style="width: 50px; border-radius: 24px;"/></div><div class="ms-2 mt-3">USER1</div>
            </div>
            <div class="d-flex mb-2">
              <div class="ms-5"><i class="fa-regular fa-comment-dots"></i></div>
              <div class="ms-2">안녕하세요 수고 많으십니다^^</div>
            </div>
            <hr>

            <div class="d-flex mb-2">
              <div><img src="https://img.danawa.com/prod_img/500000/017/350/img/13350017_1.jpg?shrink=330:330&_v=20210224095944" style="width: 50px; border-radius: 24px;"/></div><div class="ms-2 mt-3">USER1</div>
            </div>
            <div class="d-flex mb-2">
              <div class="ms-5"><i class="fa-regular fa-comment-dots"></i></div>
              <div class="ms-2">안녕하세요 수고 많으십니다^^</div>
            </div>
            <hr>

            <div class="d-flex mb-2">
              <div><img src="https://img.danawa.com/prod_img/500000/017/350/img/13350017_1.jpg?shrink=330:330&_v=20210224095944" style="width: 50px; border-radius: 24px;"/></div><div class="ms-2 mt-3">USER1</div>
            </div>
            <div class="d-flex mb-2">
              <div class="ms-5"><i class="fa-regular fa-comment-dots"></i></div>
              <div class="ms-2">안녕하세요 수고 많으십니다^^</div>
            </div>
            <hr>

            <div class="mb-3" style="text-align: center;"><button id="plus">더보기</button></div>



            <div>
              <form action="">
                <input type="text" id="reply_text" placeholder="모두에게 도움이 되는 답변의 주인공이 되어주세요!">
                
                <button id="reply_btn">댓글작성</button>
              </form>
            </div>
          </div>

          </div>


        </div>

        <!--board-Writer-Button-->
        <div class="d-flex flex-row-reverse mb-5" style="width: 70%; margin: 0px auto;">
          <div class="p-2"><button class="btn-st btn btn-outline-secondary">답변달기(강사)</button></div>
          <div class="p-2"><button class="btn-st btn btn-outline-secondary">목록보기(작성자)</button></div>
          <div class="p-2"><button class="btn-st btn btn-outline-secondary">삭제하기(작성자)</button></div>
          <div class="p-2"><button class="btn-st btn btn-outline-secondary">수정하기(작성자)</button></div>
        </div>

        
      <div class="board teacher" style="margin-top: 2em; margin-bottom: 0.5em;">

        <!--Contents-->
        <div class="sb_contents">
          <div class="mb-3">
            <div class="d-flex mb-2">
              <div class="p-2" style="font-size: 19px;">
                <i class="fa-solid fa-people-roof" style="color: rgb(211, 28, 28);"></i> <b>강사 답글</b>
              </div>
              <div style="font-size: 12px; color: grey; margin: 17px 2px 0px 2px;">2022/9/15</div>
            </div>
            <h5 style="text-align:justify; text-justify:auto;">질문 내용을 입력해 주세요.</h5>
          </div>

          <div>
            <div class="d-flex mt-4">
              <div class="p-2 flex-grow-1">🗨 댓글 0개</div>
              <div class="p-2 share"><a href="#" onclick="clip(); return false;"><i class="fa-solid fa-share-nodes" style="color: rgb(15, 156, 50);"></i> 공유하기</a></div>
              <div class="p-2"><i style="color: rgb(15, 156, 50);"class="fa-solid fa-caret-down"></i><button id="reply_sir"> 댓글</button></div>
            </div>
          </div>

          <!--Reply-Content-->
          <div class="reply_list p-3" id="reply_list_second">
            <div class="d-flex mb-2">
              <div><img src="https://img.danawa.com/prod_img/500000/017/350/img/13350017_1.jpg?shrink=330:330&_v=20210224095944" style="width: 50px;  border-radius: 24px;"/></div><div class="ms-2 mt-3">USER1</div>
            </div>
            <div class="d-flex mb-2">
              <div class="ms-5"><i class="fa-regular fa-comment-dots"></i></div>
              <div class="ms-2">안녕하세요 수고 많으십니다^^</div>
            </div>
            <hr>

            <div class="d-flex mb-2">
              <div><img src="https://img.danawa.com/prod_img/500000/017/350/img/13350017_1.jpg?shrink=330:330&_v=20210224095944" style="width: 50px; border-radius: 24px;"/></div><div class="ms-2 mt-3">USER1</div>
            </div>
            <div class="d-flex mb-2">
              <div class="ms-5"><i class="fa-regular fa-comment-dots"></i></div>
              <div class="ms-2">안녕하세요 수고 많으십니다^^</div>
            </div>
            <hr>

            <div class="d-flex mb-2">
              <div><img src="https://img.danawa.com/prod_img/500000/017/350/img/13350017_1.jpg?shrink=330:330&_v=20210224095944" style="width: 50px; border-radius: 24px;"/></div><div class="ms-2 mt-3">USER1</div>
            </div>
            <div class="d-flex mb-2">
              <div class="ms-5"><i class="fa-regular fa-comment-dots"></i></div>
              <div class="ms-2">안녕하세요 수고 많으십니다^^</div>
            </div>
            <hr>

            <div class="d-flex mb-2">
              <div><img src="https://img.danawa.com/prod_img/500000/017/350/img/13350017_1.jpg?shrink=330:330&_v=20210224095944" style="width: 50px; border-radius: 24px;"/></div><div class="ms-2 mt-3">USER1</div>
            </div>
            <div class="d-flex mb-2">
              <div class="ms-5"><i class="fa-regular fa-comment-dots"></i></div>
              <div class="ms-2">안녕하세요 수고 많으십니다^^</div>
            </div>
            <hr>

            <div class="d-flex mb-2">
              <div><img src="https://img.danawa.com/prod_img/500000/017/350/img/13350017_1.jpg?shrink=330:330&_v=20210224095944" style="width: 50px; border-radius: 24px;"/></div><div class="ms-2 mt-3">USER1</div>
            </div>
            <div class="d-flex mb-2">
              <div class="ms-5"><i class="fa-regular fa-comment-dots"></i></div>
              <div class="ms-2">안녕하세요 수고 많으십니다^^</div>
            </div>
            <hr>

            <div class="mb-3" style="text-align: center;"><button id="plus">더보기</button></div>



            <div>
              <form action="">
                <input type="text" id="reply_text" placeholder="모두에게 도움이 되는 답변의 주인공이 되어주세요!">
                
                <button id="reply_btn">댓글작성</button>
              </form>
            </div>
          </div>

          </div>


        </div>

        <!--board-Writer-Button-->
        <div class="d-flex flex-row-reverse mb-4 mt-4" style="width: 70%; margin: 0px auto;">
          <div class="p-2"><button class="btn-st btn btn-outline-secondary">삭제하기(강사)</button></div>
          <div class="p-2"><button class="btn-st btn btn-outline-secondary">수정하기(강사)</button></div>
        </div>

      <!--container-box-->  
      </div> 
      

      <!--Fixed-button:back-->
      <div class="d-flex flex-row-reverse fix_b">
        <div class="fix_box d-flex">
          <div class="d-grid gap-2 d-md-block">
            <button class="fix_btn" type="button"><i class="fa-solid fa-circle-chevron-left"></i></button>
          </div>
        </div>
      </div>
    </section>

<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script src="/resources/js/sb_detail.js"></script>
</body>
</html>