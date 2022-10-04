<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<c:forEach items="${list}" var="noticeReplyDTO">
 <div class="mb-4">
   <hr>
   <input type="text" value="${noticeReplyDTO.num}" style="display: none;" class="reply_num"/>
   <div class="d-flex">
     <div style="width: 40px;; text-align: center;">
       <img src="/resources/images/Q.jpg" alt="" style="width: 30px; border-radius: 24px;">
     </div>
     <div class="d-flex flex-column" style="width: 92%;">
      <div class="d-flex justify-content-between">
        <div class="mb-4" style="font-size: 12px; line-height: 33px;"><span class="me-2">${noticeReplyDTO.id}</span><span>🕓${noticeReplyDTO.reg_date}</span></div>
        <div class="reply_delete" data-reply-num="${noticeReplyDTO.num}" style="font-size:15px; line-height: 27px;">🗑️</div>
      </div>
       <div><span>${noticeReplyDTO.contents}</span></div>
     </div>
   </div>
 </div>
 </c:forEach>
 
 <div class="mt-4">
  <div class="d-flex flex-column">
  	  <input type="text" value="유저" style="display: none" id="reply_id"/>
      <div><textarea name="contents" class="form-control mt-1" id="reply_add" rows="4" placeholder="댓글입력"></textarea></div>
      <div class="mt-2 d-grid gap-2" style="width: 60%;"><button class="reply_btn btn btn-warning"  style="color:white;" type="button">댓글작성</button></div>
  </div>
</div>