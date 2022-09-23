<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>

  <form action="c_detail" method="post">
      <div id="teacher_box"  class="teacher_box">
          <div class="teacher board" style="margin-top: 2em; margin-bottom: 0.5em;">
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
              <input type="number" class="comment_ref" data-comment-num="${commentDTO.sb_num}" style="display: none" value="${commentDTO.ref}" id="comment_ref"/>
              <div>
                <div class="d-flex mt-4">
                  <div class="p-2 flex-grow-1">🗨 댓글 ${count}개</div>
                  <div class="p-2 share"><a href="#" onclick="clip(); return false;"><i class="fa-solid fa-share-nodes" style="color: rgb(15, 156, 50);"></i> 공유하기</a></div>
                  <div class="p-2"><i style="color: rgb(15, 156, 50);"class="fa-solid fa-caret-down"></i><button type="button" class="reply_t" id="reply_t"> 댓글</button></div>
                </div>
              </div>

                <!--Reply-Content-->
                <div id="t_comment">
                  <div class="reply_list p-3" id="reply_list">
                   
                    <c:forEach items="${tCommentDTO}" var="tCommentDTO">
                    <div id="commentList">
                    <div class="d-flex mb-2">
                      <div><img src="https://img.danawa.com/prod_img/500000/017/350/img/13350017_1.jpg?shrink=330:330&_v=20210224095944" style="width: 50px;  border-radius: 24px;"/></div><div class="ms-2 mt-3" >${tCommentDTO.id}</div>
                    </div>
                  
                    <div class="d-flex mb-2 justify-content-between">
                      <div class="d-flex">
                        <div class="ms-5"><i class="fa-regular fa-comment-dots"></i></div>
                        <div class="ms-2" >${tCommentDTO.contents}</div>
                      </div>
                      <div><button type="button" style="height: 30px;" class="delete_btn" data-comment-num="${tCommentDTO.num}">❌</button></div>
                      
                    </div>
                    <hr>
                    
                  </div>     
                  </c:forEach>
        
                    <div class="mb-3" style="text-align: center;"><button id="plus">더보기</button></div>
                    <div>
                      <form action="t_commentAdd" method="post">
                         <input id="c_id2" name="id" style="display:none;" type="text" value="유저"/>
                         <input id="c_num2" name="num" style="display:none;" type="text" value="${commentDTO.num}"/>
                        <input name="contents" type="text" class="reply_text2" id="reply_text2" placeholder="모두에게 도움이 되는 답변의 주인공이 되어주세요!">
                        
                        <button type="button"  class="reply_btn2" id="reply_btn2" data-t_comment-num="${commentDTO.getSb_num()}">댓글작성</button>
                      </form>
                	  </div>
                  </div>
              </div>
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
