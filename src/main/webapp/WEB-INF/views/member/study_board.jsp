<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
          <c:if test="${size1 == 0}">
            <div class="text-center mt-5" style="font-weight: bold;">
              <div id="null">아직 작성한 게시글이 없습니다!</div>
              <div id="null2">게시글을 작성해 보세요!</div>
              <input type="button" class="study_list" id="study_list" value="학습 게시판 가기" style="background-color: #66ba39; color: white; border:none;">
            </div>
          </c:if>
            <c:forEach items="${study}" var="BoardDTO">
              <div class="contents_box">
                <div
                  class="sb_board" id="sb_board" data-fb-num="${BoardDTO.sb_num}"
                >
                  <div style="padding: 12px 0px">
                    <div class="d-flex">
                      <div class="p-1 flex-grow-1 mt-2" style="font-size: 13px">
                        <div>🏅${BoardDTO.category}</div>
                      </div>
                      <div class="p-2">
                        <i class="fa-regular fa-user"></i> ${pageScope.BoardDTO.id}
                      </div>
                    </div>
                    <div style="margin-top: 11px; margin-bottom: 33px;">
                      <h5 style="padding-left:5px;"><b>${BoardDTO.title}</b></h5>
                    </div>
                    <div class="d-flex">
                      <div class="d-flex p-1 w-100">
                        <div class="b1 d-flex" style="font-size: 15px">
                          <div>${BoardDTO.hit} 조회</div>
                          <div>
                            <b>
                              <c:choose>
                                <c:when test="${BoardDTO.answer eq 0}">
                                  답변대기
                                </c:when>
                                <c:otherwise> 답변완료 </c:otherwise>
                              </c:choose>
                            </b>
                          </div>
                        </div>
                      </div>
                      <div
                        class="p-2 flex-shrink-1"
                        style="width: 116px; font-size: 14px"
                      >
                        ${BoardDTO.reg_date}
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>


