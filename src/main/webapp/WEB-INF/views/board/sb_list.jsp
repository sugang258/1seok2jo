<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta charset="UTF-8">
		<title>학습게시판</title>
		<link rel="stylesheet" href="/resources/css/board/sb_list.css" />
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
      <!--Board-Main-Top-->
      <div style="height: 190px; margin-top:125px;">
        <div style="height: 70px">
          <h3 style="line-height: 80px"><strong>📗 학습게시판</strong></h3>
        </div>
        <div style="height: 55px">
          <div class="search-bar">
            <button id="seach_logo" class="seach-logo">
              <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
            </button>
            <input type="search" placeholder="궁금한 내용을 찾아보세요." />
          </div>
        </div>
        <!--Order-->
        <div class="order">
          <form>
            <div class="d-flex mb-3">
              <div class="p-1">
                <select class="select" name="kind">
                  <option value="newest">최신순</option>
                  <option value="hits">조회순</option>
                </select>
              </div>
              <div class="p-1">
                <select class="select" name="kind">
                  <option value="all">답변전체</option>
                  <option value="wait">답변대기</option>
                  <option value="finish">답변완료</option>
                </select>
              </div>
              <div class="p-1">
                <select class="select" name="kind" style="width: 100px;">
                  <option value="category">카테고리</option>
                  <option value="java">JAVA</option>
                  <option value="spring">SPRING</option>
                  <option value="javascript">JAVASCRIPT</option>
                  <option value="html">HTML</option>
                  <option value="css">CSS</option>
                </select>
              </div>
              <div class="ms-auto p-2">
                <button  class="btn btn-success text-white" id="writer"><a href="/board/sb_add">✏글쓰기</a></button>
              </div>
            </div>
          </form>
        </div>
      </div>

      <!--Board_Contents-->
      <div class="board">
        <c:forEach items="${requestScope.list}" var="BoardDTO">
        <div class="contents_box">
        <div class="board_contents" onclick="location.href='/board/sb_detail?sb_num=${BoardDTO.getSb_num()}';">
          <div style="padding: 12px 0px">
            <div class="d-flex">
              <div class="p-1 flex-grow-1" style="font-size:13px;">
                <div>${BoardDTO.category}</div>
              </div>
              <div class="p-2"><i class="fa-regular fa-user"></i> ${pageScope.BoardDTO.id}</div>
            </div>
            <div style="margin-top:-5px;">
              <h5><b>${BoardDTO.title}</b></h5>
            </div>
            <div>
              <p>
                <c:choose>
              		<c:when test="${fn:length(BoardDTO.contents) > 65}">
    					<c:out value="${fn:substring(BoardDTO.contents,0 , 65)}" />....
              		</c:when>
              		<c:otherwise>
              			${BoardDTO.contents}
              		</c:otherwise>
              	</c:choose>
              </p>
            </div>

            <div class="d-flex">
              <div class="d-flex p-1 w-100">
                <div class="b1 d-flex" style="font-size:15px;">
                  <div>${BoardDTO.hit} 조회</div>
                  <div><b>
                  	<c:choose>
                  		<c:when test="${BoardDTO.answer eq 0}">
                  			답변대기
                  		</c:when>
                  		<c:otherwise>
                  			답변완료
                  		</c:otherwise>
                  	</c:choose>
                  </b></div>
                </div>
              </div>
              <div class="p-2 flex-shrink-1" style="width: 116px; font-size:14px;">${BoardDTO.reg_date}</div>
            </div>
          </div>
        </div>
        </div>
        </c:forEach>
      </div>

      <!--PageNation-->
      <div class="paging">
        <nav aria-label="Page navigation example">
          <ul class="pagination">
			<c:if test="${pager.pre}">
            <li class="page-item">
              <a class="page-link text-success" href="./sb_list?page=${pager.startNum-1}" aria-label="Previous">
                <span aria-hidden="true">이전</span>
              </a>
            </li>
              </c:if>
            <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
            <li class="page-item">
              <a class="page-link text-success" href="sb_list?page=${pageScope.i}">${i}</a>
            </li>
            </c:forEach>
            
            <li class="page-item">
            <c:if test="${pager.next}">
              <a class="page-link text-success" href="./sb_list?page=${pager.lastNum+1}" aria-label="Next">
                <span aria-hidden="true">다음</span>
              </a>
              </c:if>
            </li>
          </ul>
        </nav>
      </div>

      <!--Fixed Button-->
      <div class="d-flex flex-row-reverse">
        <div class="fix_box d-flex flex-row-reverse">
          <div class="d-grid gap-2 d-md-block">
            <span style="padding-right: 20px; color: rgb(73, 71, 71)"
              ><b>궁금한 부분이 있으신가요?</b></span
            >
            <button class="fix_btn" type="button"><a href="/board/sb_add">질문하기</a></button>
          </div>
        </div>
      </div>
    </section>


<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>