<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>공지사항</title>
    <link rel="stylesheet" href="/resources/css/board/notice.css" />
    <%-- Bootstrap CSS --%>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
      crossorigin="anonymous"
    />
    <%-- favicon --%>
    <link rel="shortcut icon" href="/resources/images/favicon.ico" />
  </head>
  <c:import url="../template/header.jsp"></c:import>
  <body>
    <section class="container">
      <div class="d-flex mt-5">
        <!--Sidebar-->
        <div class="row" style="width: 8%">
          <div class="col-4 d-lg-block d-none">
            <div class="list-group sidebar">
              <div class="list-group" id="list-tab" role="tablist">
                <a
                  class="list-group-item list-group-item-action"
                  id="list-home-list"
                  data-bs-toggle="list"
                  href="#list-home"
                  role="tab"
                  aria-controls="list-home"
                  style="font-size: 18px; color: pink"
                  onclick="location.href='/'"
                  ><i class="fa-solid fa-house"></i
                ></a>
                <a
                  class="list-group-item list-group-item-action active"
                  id="list-profile-list"
                  data-bs-toggle="list"
                  href="#list-profile"
                  role="tab"
                  aria-controls="list-profile"
                  onclick="location.href='./notice'"
                  >공지사항</a
                >
                <a
                  class="list-group-item list-group-item-action"
                  id="list-messages-list"
                  data-bs-toggle="list"
                  href="#list-messages"
                  role="tab"
                  aria-controls="list-messages"
                  onclick="location.href='#'"
                  >1대 1문의</a
                >
                <a
                  class="list-group-item list-group-item-action"
                  id="list-settings-list"
                  data-bs-toggle="list"
                  href="#list-settings"
                  role="tab"
                  aria-controls="list-settings"
                  onclick="location.href='./faq'"
                  >자주묻는 질문</a
                >
              </div>
            </div>
          </div>
        </div>

        <div style="width: 92%">
          <div class="board">
            <div style="width: 78%; margin: 0px auto">
              <div class="ps-3 mb-4 pt-4"><h1>📢 공지사항</h1></div>

              <c:forEach items="${list}" var="noticeDTO">
                <div
                  class="board_contents"
                  onclick="location.href='/board/nb_detail?n_num=${noticeDTO.n_num}';"
                >
                  <div style="padding: 12px 0px">
                    <div>
                      <h5>
                        <b>💚[업데이트소식]${noticeDTO.title}</b>
                      </h5>
                    </div>
                    <div class="d-flex">
                      <div class="d-flex p-1 w-100">
                        <div class="b1 d-flex">
                          <div>${noticeDTO.reg_date}</div>
                          <div>글쓴이:${noticeDTO.id}✅</div>
                          <div>대상:전체</div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </c:forEach>
            </div>

            <div
              class="d-flex"
              style="width: 78%; margin: 80px auto 0px auto; text-align: end"
            >
              <!--PageNation-->
              <div class="paging justify-content-end" style="width: 100%">
                <nav
                  aria-label="Page navigation example"
                  class="justify-content-end"
                  style="justify-content: end"
                >
                  <ul class="pagination justify-content-center">
                    <li class="page-item">
                      <a
                        class="page-link text-success"
                        href="#"
                        aria-label="Previous"
                      >
                        <span aria-hidden="true">&laquo;</span>
                      </a>
                    </li>
                    <li class="page-item">
                      <a class="page-link text-success" href="#">1</a>
                    </li>
                    <li class="page-item">
                      <a class="page-link text-success" href="#">2</a>
                    </li>
                    <li class="page-item">
                      <a class="page-link text-success" href="#">3</a>
                    </li>
                    <li class="page-item">
                      <a class="page-link text-success" href="#">4</a>
                    </li>
                    <li class="page-item">
                      <a class="page-link text-success" href="#">5</a>
                    </li>
                    <li class="page-item">
                      <a
                        class="page-link text-success"
                        href="#"
                        aria-label="Next"
                      >
                        <span aria-hidden="true">&raquo;</span>
                      </a>
                    </li>
                  </ul>
                </nav>
              </div>

              <div class="" style="width: 30%;">
                <button
                  class="btn btn-light"
                  id="writer"
                  style="
                    background-color: transparent;
                    box-shadow: rgba(0, 0, 0, 0.05) 0px 0px 0px 1px;
                    font-size: 14px;
                  "
                >
                  <a href="/board/nb_add">✏글작성(관리자)</a>
                </button>
              </div>
            </div>
          </div>
        </div>
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
  </body>
</html>
