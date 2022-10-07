<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>자유게시판</title>
    <link rel="stylesheet" href="/resources/css/board/fb_list.css" />
    <%-- Bootstrap CSS --%>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
      crossorigin="anonymous"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap"
      rel="stylesheet"
    />
    <%-- favicon --%>
    <link rel="shortcut icon" href="/resources/images/favicon.ico" />
  </head>
  <c:import url="../template/header.jsp"></c:import>
  <body>
    <section class="container" style="width: 70%">
      <!--Board-Main-Top-->
      <div class="mt-5" style="height: 190px; margin-top: 125px">
        <div style="height: 70px">
          <h3 style="line-height: 80px"><strong>🐸 자유게시판</strong></h3>
        </div>
          <form action="./fb_list" method="get">
        <div style="height: 55px">
          <div class="search-bar">
            <button id="seach_logo" class="seach-logo">
              <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
            </button>
            <input type="search" name="search" value="${param.search}" placeholder="궁금한 내용을 찾아보세요." />
          </div>
        </div>
        <!--Order-->
        <div class="order">
            <div class="d-flex mb-3">
              <div class="p-1">
                <select class="select" name="order">
                  <option class="orders" value="new">최신순</option>
                  <option class="orders" value="hit">조회순</option>
                  <option class="orders" value="heart">추천순</option>
                </select>
              </div>
              <div class="p-1">
                <select class="select" name="kind">
                <option class="kinds" value="all">전체보기</option>
                  <option class="kinds" value="study">스터디모집</option>
                  <option class="kinds" value="data">자료실</option>
                  <option class="kinds" value="confirm">공부인증</option>
                  <option class="kinds" value="talk">수다</option>
                </select>
              </div>
              <div class="ms-auto p-2">
                <button class="btn btn-success text-white" id="writer">
                  <a href="/board/fb_add">✏글쓰기</a>
                </button>
              </div>
            </div>
        </div>
        </form>
      </div>

      <!--Board_Contents-->
      <div class="board">
        <c:forEach items="${list}" var="freeBoardDTO" varStatus="i">
          <div class="contents_box">
            <div
              class="board_contents"
              onclick="location.href='/board/fb_detail?fb_num=${freeBoardDTO.fb_num}';"
            >
              <div style="padding: 12px 0px">
                <div class="d-flex">
                  <div
                    class="p-2 flex-grow-1"
                    style="font-size: 13.5px; margin-left: -6.5px"
                  >
                    <div>🏷️${freeBoardDTO.category}</div>
                  </div>
                  <div class="p-2">
                    <i class="fa-regular fa-user"></i> ${freeBoardDTO.id}
                  </div>
                </div>
                <div
                  style="margin-bottom: 33px; margin-top: 5px; margin-left: 2px"
                >
                  <h5 style="padding-left: 4px">
                    <b>${freeBoardDTO.title}</b>
                  </h5>
                </div>

                <div style="display: none">
                  <div
                    class="list_contents pt-1 mb-2"
                    style="word-break: break-all; margin-left: 2px"
                  >
                    <c:choose>
                      <c:when test="${fn:length(freeBoardDTO.contents) > 55}">
                        <c:out
                          value="${fn:substring(freeBoardDTO.contents,0 , 55)}"
                        />....
                      </c:when>
                      <c:otherwise> ${freeBoardDTO.contents} </c:otherwise>
                    </c:choose>
                  </div>
                </div>

                <div class="d-flex">
                  <div class="d-flex p-1 w-100">
                    <div class="b1 p-1 d-flex sort" style="font-size: 14.5px">
                      <div>${freeBoardDTO.hit} 조회</div>
                      <div><span>${count_list[i.index]}</span> 좋아요</div>
                    </div>
                  </div>
                  <div
                    class="p-2 flex-shrink-1"
                    style="width: 116px; font-size: 14px; text-align: right"
                  >
                    ${freeBoardDTO.reg_date}
                  </div>
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
                <a
                  class="page-link text-success"
                  href="./fb_list?page=${pager.startNum-1}&order=${pager.order}&kind=${pager.kind}&search=${pager.search}"
                  aria-label="Previous"
                >
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
            </c:if>
            <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
              <li class="page-item">
                <a class="page-link text-success" href="fb_list?page=${i}&order=${pager.order}&kind=${pager.kind}&search=${pager.search}"
                  >${i}</a
                >
              </li>
            </c:forEach>

            <c:if test="${pager.next}">
              <li class="page-item">
                <a
                  class="page-link text-success"
                  href="./fb_list?page=${pager.lastNum+1}&order=${pager.order}&kind=${pager.kind}&search=${pager.search}"
                  aria-label="Next"
                >
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </c:if>
          </ul>
        </nav>
      </div>

      <!--Fixed Button-->
      <div class="d-flex flex-row-reverse">
        <div class="fix_box d-flex flex-row-reverse">
          <div class="d-grid gap-2 d-md-block">
            <button class="fix_btn" type="button" onclick="location.href='#'">
              <h1 style="color: green">
                ▲
                <h6 style="color: green">맨 위로</h6>
              </h1>
            </button>
          </div>
        </div>
      </div>
    </section>

    <c:import url="../template/footer.jsp"></c:import>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://kit.fontawesome.com/6e23c67242.js"
      crossorigin="anonymous"
    ></script>
    <script>
  const kinds = document.getElementsByClassName('kinds');
  const orders = document.getElementsByClassName('orders');
  let k = '${param.kind}';
  let o = '${param.order}';

  for(let i =0;i < kinds.length;i++){
    if(k == kinds[i].value){
      kinds[i].selected = true;
      break;
    }
  }
    for(let i =0;i < orders.length;i++){
        if(o == orders[i].value){
          orders[i].selected = true;
          break;
        }  
  }
</script>
    <script src="/resources/js/fb_list.js"></script>
  </body>
</html>
