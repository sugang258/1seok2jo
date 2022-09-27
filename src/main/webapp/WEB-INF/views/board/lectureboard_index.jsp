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

    <section class="container" style="width:90%; margin-top:150px;">
      강의상세보기 페이지 수강평 구현

        <div class="board_top">
          <div
            class="ms-4"
            style="font-size: 17px; color: rgba(5, 5, 5, 0.808)"
          >
            <b
              ><i
                class="fa-solid fa-leaf"
                style="color: rgba(72, 170, 72, 0.89)"
              ></i>
              수강평 <span style="font-size: 13px; color: gray">총10개</span></b
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
                <div class="p-2" style="font-size: 34px"><b>5.0</b></div>
                <div class="p-2" style="font-size: 20px">⭐⭐⭐⭐⭐</div>
                <div class="p-2" style="color: rgb(85, 84, 84)">
                  10개의 수강평
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
                    style="width: 100%"
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
                    style="width: 0%"
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
                    style="width: 0%"
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
                    style="width: 0%"
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
                    style="width: 0%"
                    aria-valuenow="75"
                    aria-valuemin="0"
                    aria-valuemax="100"
                  ></div>
                </div>
              </div>
            </div>
          </div>
        </div>
  
        <div class="board">
          <!--Contents-->
          <div>
            <div class="d-flex mt-3 ms-3 justify-content: flex-start;">
              <div class="p-2 flex-grow-3"><b>VIEW</b></div>
              <div class="p-2 flex-grow-3" style="color: gray">|</div>
              <div class="p-2 flex-grow-3 font_st">👍 좋아요 순</div>
              <div class="p-2 flex-grow-3 font_st">👀 최신 순</div>
              <div class="p-2 flex-grow-3 font_st">😍 높은 평점 순</div>
              <div class="p-2 flex-grow-3 font_st">🤔 낮은 평점 순</div>
            </div>
            <hr
              style="border: solid 0.7px; margin-top: 5px; margin-bottom: 0px"
            />
          </div>

            <!--Reply-Content-->
          <c:forEach items="list" var="lectureBoardDTO">
          <input type="text" name="l_num" value="${lectureBoardDTO.l_num}" id="l_num" style="display: none"/>

          <div class="reply_list p-3" id="reply_list">
  
            <div class="mb-1 ms-2" style="margin-top: -8px; font-size: 13px">
              ⭐⭐⭐⭐⭐ <b>5</b>
            </div>
            <div class="d-flex mb-2 ms-2">
              <div>
                <img
                  src="https://img.danawa.com/prod_img/500000/017/350/img/13350017_1.jpg?shrink=330:330&_v=20210224095944"
                  style="width: 26px; border-radius: 24px"
                />
              </div>
              <div class="ms-2 mt-1" style="font-size: 13px"><input type="text" name="id" value="${lectureBoardDTO.id}" id="id" style="display: none"/></div>
            </div>
            <div class="d-flex mb-1">
              <div class="ms-2" style="font-size: 15px">
                ${lectureBoardDTO.contents}
              </div>
            </div>
            <div class="d-flex justify-content: space-around">
              <div
                class="ms-2"
                style="
                  font-size: 11px;
                  margin-top: 10px;
                  margin-bottom: -6px;
                  color: rgb(73, 71, 71);
                  width: 93%;
                "
              >
                🕓&{lectureBoardDTO.reg_date}
              </div>
              <div class="best">
                <i class="fa-solid fa-thumbs-up"></i
                ><span
                  class="ms-1 d-md-inline-block d-none"
                  style="font-size: 11px"
                >
                  추천</span
                >
              </div>
            </div>
            <hr />
  
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
                <!--임시로 보내는 값 -->
                   <input type="text"  style="display: none;" name = "l_num" value="1">
                   <input type="text"  style="display: none;" name = "id" value="user">
				<!--임시로 보내는 값 -->
                
                <div class="modal-footer">
                  <button
                    type="button"
                    class="btn btn-secondary"
                    data-bs-dismiss="modal"
                  >
                    취소
                  </button>
                  <button type="button" class="lecture_add btn btn-warning" id="lecture_add">
                    등록하기
                  </button>
                </div>
                  </form>
              </div>
            </div>
          </div>
          </c:forEach>
          
        </div>
    </section>

    <c:import url="../template/footer.jsp"></c:import>
    <script src="/resources/js/l_board.js"></script>
  </body>
</html>
