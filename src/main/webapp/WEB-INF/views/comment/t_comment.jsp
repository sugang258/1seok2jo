<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>

<form action="c_detail" method="post">

  <div id="teacher_box">
      <div class="board teacher" style="margin-top: 2em; margin-bottom: 0.5em;">
        <!--Contents-->
        <div class="sb_contents">
          <div class="mb-3">
            <div class="d-flex mb-2">
              <div class="p-2" style="font-size: 19px;">
                <i class="fa-solid fa-people-roof" style="color: rgb(211, 28, 28);"></i> <b>강사 답글</b>
              </div>
              <div style="font-size: 12px; color: grey; margin: 17px 2px 0px 2px;">${commentDTO.reg_date}</div>
            </div>
            <h5 style="text-align:justify; text-justify:auto;">${commentDTO.contents}</h5>
          </div>

          <div>
            <div class="d-flex mt-4">
              <div class="p-2 flex-grow-1">🗨 댓글 0개</div>
              <div class="p-2 share"><a href="#" onclick="clip(); return false;"><i class="fa-solid fa-share-nodes" style="color: rgb(15, 156, 50);"></i> 공유하기</a></div>
              <div class="p-2"><i style="color: rgb(15, 156, 50);"class="fa-solid fa-caret-down"></i><button id="reply_sir"> 댓글</button></div>
            </div>
          </div>

          <!--Reply-Content-->
          <div></div>
          
          

          </div>

        </div>
        <!--board-Writer-Button-->
        <div class="d-flex flex-row-reverse mb-4 mt-4" style="width: 70%; margin: 0px auto;">
          <div class="p-2"><button type="button" class="c_delete btn-st btn btn-outline-secondary">삭제하기(강사)</button></div>
          <div class="p-2"><button type="button" class="c_update btn-st btn btn-outline-secondary">수정하기(강사)</button></div>
        </div>
       </div>
	</form>
</body>
