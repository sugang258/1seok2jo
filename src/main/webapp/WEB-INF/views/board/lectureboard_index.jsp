<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>강의상세화면 대체</title>
    <link rel="stylesheet" href="/resources/css/board/l_board.css" />
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
    <section class="container" style="width: 90%; margin-top: 150px">
      강의상세보기 페이지 수강평 구현

      <div class="board_top">
        <div class="ms-4" style="font-size: 17px; color: rgba(5, 5, 5, 0.808)">
          <b
            ><i
              class="fa-solid fa-leaf"
              style="color: rgba(72, 170, 72, 0.89)"
            ></i>
            수강평
            <span style="font-size: 13px; color: gray">총 ${count}개</span></b
          >
        </div>
        <div
          class="mt-2 ms-4"
          style="font-size: 13px; color: rgba(43, 42, 42, 0.808)"
        >
          수강생분들이 직접 작성한 수강평입니다.
        </div>
        <div class="d-flex">
          <div
            class="p-2 ms-4 mt-2 flex-fill"
            style="
              box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
              height: 200px;
            "
          >
            <div
              class="d-flex flex-column mt-2 mb-3"
              style="text-align: center"
            >
              <div class="p-2" style="font-size: 34px"><b>${avg}</b></div>
              <div class="p-2" style="font-size: 20px">⭐⭐⭐⭐⭐</div>
              <div class="p-2" style="color: rgb(85, 84, 84)">
                ${count}개의 수강평
              </div>
            </div>
          </div>
          <div
            class="p-4 ms-3 mt-2 me-4 flex-fill"
            style="
              box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
              height: 200px;
              width: 65%;
            "
          >
            <div
              class="pe-3 d-lg-block d-none"
              style="height: 180px; width: 15%; float: left; text-align: right"
            >
              <p style="margin-top: -5px">5점</p>
              <p style="margin-top: -8px">4점</p>
              <p style="margin-top: -7px">3점</p>
              <p style="margin-top: -8px">2점</p>
              <p style="margin-top: -8px">1점</p>
            </div>
            <div style="width: 70%; margin: 0 auto">
              <div class="progress">
                <div
                  class="progress-bar bg-warning"
                  role="progressbar"
                  aria-label="Warning example"
                  style="width: ${fiveScore}%"
                  aria-valuenow="75"
                  aria-valuemin="0"
                  aria-valuemax="100"
                ></div>
              </div>

              <div class="mt-3 progress">
                <div
                  class="progress-bar bg-warning"
                  role="progressbar"
                  aria-label="Warning example"
                  style="width: ${fourScore}%"
                  aria-valuenow="75"
                  aria-valuemin="0"
                  aria-valuemax="100"
                ></div>
              </div>

              <div class="mt-3 progress">
                <div
                  class="progress-bar bg-warning"
                  role="progressbar"
                  aria-label="Warning example"
                  style="width: ${thirdScore}%"
                  aria-valuenow="75"
                  aria-valuemin="0"
                  aria-valuemax="100"
                ></div>
              </div>

              <div class="mt-3 progress">
                <div
                  class="progress-bar bg-warning"
                  role="progressbar"
                  aria-label="Warning example"
                  style="width: ${secondScore}%"
                  aria-valuenow="75"
                  aria-valuemin="0"
                  aria-valuemax="100"
                ></div>
              </div>

              <div class="mt-3 progress">
                <div
                  class="progress-bar bg-warning"
                  role="progressbar"
                  aria-label="Warning example"
                  style="width: ${firstScore}%"
                  aria-valuenow="75"
                  aria-valuemin="0"
                  aria-valuemax="100"
                ></div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!--Contents-->
      <div class="board">
        <div>
          <div class="d-flex mt-3 ms-3 justify-content: flex-start;">
            <div class="p-2 flex-grow-3"><b>VIEW</b></div>
            <div class="p-2 flex-grow-3" style="color: gray">|</div>
            <div class="array d-flex">
              <form action="./new" method="get">
                <div
                  class="arrays p-2 flex-grow-3 font_st"
                  onclick="location='./new?l_num=${lectureBoardDTO.l_num}'"
                >
                  👀 최신 순
                </div>
              </form>
              <form action="./like" method="get">
                <div
                  class="arrays p-2 flex-grow-3 font_st"
                  onclick="location='./like?l_num=${lectureBoardDTO.l_num}'"
                >
                  👍 추천 순
                </div>
              </form>
              <form action="./high" method="get">
                <div
                  class="arrays p-2 flex-grow-3 font_st"
                  onclick="location='./high?l_num=${lectureBoardDTO.l_num}'"
                >
                  😍 높은 평점 순
                </div>
              </form>
              <form action="./low" method="get">
                <div
                  class="arrays p-2 flex-grow-3 font_st"
                  onclick="location='./low?l_num=${lectureBoardDTO.l_num}'"
                >
                  🤔 낮은 평점 순
                </div>
              </form>
            </div>
          </div>
          <hr
            style="border: solid 0.7px; margin-top: 5px; margin-bottom: 0px"
          />
          <!-- 임시로 보내는값 -->
          <input
            type="text"
            style="display: none"
            name="id"
            value="악플러"
            id="l_board_id"
          />
        </div>

        <!--Reply-Content-->
        <div class="reply_list p-3" id="reply_list">
          <c:forEach items="${requestScope.list}" var="lectureBoardDTO">
            <input
              type="text"
              name="l_num"
              value="${lectureBoardDTO.l_num}"
              id="l_num"
              style="display: none"
            />
            <input
              type="text"
              name="num"
              value="${lectureBoardDTO.num}"
              class="lecture_boardNum"
              style="display: none"
            />

            <div class="d-flex justify-content-between">
              <div class="mb-2 ms-2" style="margin-top: -5px; font-size: 13px">
                <c:choose>
                  <c:when test="${lectureBoardDTO.score eq 1}">⭐</c:when>
                  <c:when test="${lectureBoardDTO.score eq 2}">⭐⭐</c:when>
                  <c:when test="${lectureBoardDTO.score eq 3}">⭐⭐⭐</c:when>
                  <c:when test="${lectureBoardDTO.score eq 4}">⭐⭐⭐⭐</c:when>
                  <c:otherwise>⭐⭐⭐⭐⭐</c:otherwise>
                </c:choose>
                <b>${lectureBoardDTO.score}</b>
              </div>
              <div>
                <button
                  id="l_board_delete"
                  class="l_board_delete"
                  type="button"
                  style="
                    font-size: 10px;
                    background-color: transparent;
                    border: none;
                  "
                >
                  ❌
                </button>
              </div>
            </div>
            <div class="d-flex mb-2 ms-2 mt-1">
              <div>
                <img
                  src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png"
                  style="width: 26px; border-radius: 24px"
                />
              </div>
              <div class="l_board_id ms-2 mt-1" style="font-size: 13px">
                ${lectureBoardDTO.id}
              </div>
            </div>
            <div class="d-flex mb-1">
              <div class="ms-2" style="font-size: 15px">
                ${lectureBoardDTO.contents}
              </div>
            </div>
            <div class="d-flex justify-content-between">
              <div
                class="ms-2"
                style="
                  font-size: 11px;
                  margin-top: 10px;
                  margin-bottom: -6px;
                  color: rgb(73, 71, 71);
                  width: 85%;
                "
              >
                🕓${lectureBoardDTO.reg_date}
              </div>
              <div class="d-flex best">
                <div style="padding: 6px 10px 0px 0px; font-size: 15px">
                  ${heart_count}
                </div>
                <div>
                  <form action="./l_heartCount" method="get">
                    <i
                      class="like_btn fa-solid fa-thumbs-up"
                      onclick="location='./l_heartCount?num=${lectureBoardDTO.num}'"
                      data-l_board-num="${lectureBoardDTO.num}"
                    ></i
                    ><span
                      class="ps-1 d-xl-inline-block d-none"
                      style="font-size: 11px"
                    >
                      추천</span
                    >
                  </form>
                </div>
              </div>
            </div>
            <hr style="margin-top: 5px" />
          </c:forEach>
        </div>

        <div class="mb-3" style="text-align: center">
          <button id="plus">더보기</button>
        </div>
      </div>

      <div class="d-grid gap-2">
        <button
          class="btn btn-warning"
          data-bs-toggle="modal"
          data-bs-target="#exampleModal"
          data-bs-whatever="@mdo"
          type="button"
          id="lecture_add_btn"
          style="width: 69%; margin: 0 auto"
        >
          수강평 작성(수강생)
        </button>
      </div>

      <!--modal-->
      <div
        class="modal fade"
        id="exampleModal"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog">
          <div class="modal-content">
            <form method="post" action="./l_boardAdd">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">
                  수강평 작성✏️
                </h5>
                <button
                  type="button"
                  class="btn-close"
                  data-bs-dismiss="modal"
                  aria-label="Close"
                ></button>
              </div>
              <div class="modal-body">
                <div class="mb-3">
                  <label
                    for="recipient-name"
                    class="col-form-label"
                    style="color: gray"
                    ><b>별점을 선택해주세요🤩</b></label
                  >
                  <div class="star-rating space-x-4 mx-auto">
                    <input
                      type="radio"
                      id="5-stars"
                      name="rating"
                      value="5"
                      v-model="ratings"
                    />
                    <label for="5-stars" class="star pr-4">★</label>
                    <input
                      type="radio"
                      id="4-stars"
                      name="rating"
                      value="4"
                      v-model="ratings"
                    />
                    <label for="4-stars" class="star">★</label>
                    <input
                      type="radio"
                      id="3-stars"
                      name="rating"
                      value="3"
                      v-model="ratings"
                    />
                    <label for="3-stars" class="star">★</label>
                    <input
                      type="radio"
                      id="2-stars"
                      name="rating"
                      value="2"
                      v-model="ratings"
                    />
                    <label for="2-stars" class="star">★</label>
                    <input
                      type="radio"
                      id="1-star"
                      name="rating"
                      value="1"
                      v-model="ratings"
                    />
                    <label for="1-star" class="star">★</label>
                  </div>
                </div>
                <div class="mb-3">
                  <label
                    for="message-text"
                    class="col-form-label"
                    style="color: gray"
                    ><b>수강평 :</b></label
                  >
                  <textarea
                    class="form-control"
                    name="contents"
                    id="contents"
                    style="height: 8em"
                  ></textarea>
                </div>
              </div>

              <div class="modal-footer">
                <button
                  type="button"
                  class="btn btn-secondary"
                  data-bs-dismiss="modal"
                  id="close"
                >
                  취소
                </button>
                <button
                  type="button"
                  class="lecture_add btn btn-warning"
                  id="lecture_add"
                >
                  등록하기
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>

    <c:import url="../template/footer.jsp"></c:import>
    <script src="/resources/js/l_board.js"></script>
  </body>
</html>
