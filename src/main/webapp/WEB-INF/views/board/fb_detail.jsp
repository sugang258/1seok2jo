<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>게시판 상세보기</title>
    <link rel="stylesheet" href="/resources/css/board/fb_detail.css" />
    <!-- jquery -->
    <script
      type="text/javascript"
      src="//code.jquery.com/jquery-3.6.0.min.js"
    ></script>
    <!-- include summernote css/js-->
    <link
      href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
      rel="stylesheet"
    />
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
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
    <section class="container" style="width: 75%">
      <div class="board">
        <div class="board_contents">
          <div style="padding: 12px 0px">
            <div class="d-flex">
              <div
                class="pt-2 flex-grow-1"
                style="font-size: 13.5px; line-height: 26px"
              >
                <div>🏷️${freeBoardDTO.category}</div>
              </div>
              <div class="p-2">
                <i
                  class="fa-regular fa-user"
                  style="width: 20px; line-height: 26px"
                ></i>
                ${freeBoardDTO.id}
              </div>
              <div
                class="p-2 flex-shrink-1 pt-2"
                style="font-size: 13px; line-height: 26px"
              >
                🕔${freeBoardDTO.reg_date}
              </div>
            </div>
            <div style="margin-top: 7px; margin-left: 2px">
              <h5><b>${freeBoardDTO.title}</b></h5>
            </div>

            <div class="d-flex mt-4">
              <div class="d-flex p-1 w-100 justify-content-between">
                <div class="b1 d-flex" style="height: 32px; line-height: 28px">
                  <div class="me-2" style="font-size: 14px; color: #6c6969">
                    0 조회
                  </div>
                  <div style="font-size: 14px; color: #6c6969">0 좋아요</div>
                </div>
                <div
                  class="p-2"
                  style="
                    margin-bottom: 20px;
                    position: absolute;
                    right: 15px;
                    bottom: -12px;
                  "
                >
                  <div><i class="fa-solid fa-heart"></i></div>
                  <div style="font-size: 10px"><b>좋아요</b></div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <!--Contents-->
        <div class="fb_contents">
          <div class="mb-3">
            <h5 style="text-align: justify; text-justify: auto">
              ${freeBoardDTO.contents}
            </h5>
          </div>

          <div>
            <div class="d-flex mt-4">
              <div class="p-2 flex-grow-1">🗨 댓글 0개</div>
              <div class="p-2 share">
                <a href="#" onclick="clip(); return false;">
                  <i
                    class="fa-solid fa-share-nodes"
                    style="color: rgb(15, 156, 50)"
                  ></i>
                  공유하기</a
                >
              </div>
              <div class="p-2">
                <i
                  style="color: rgb(15, 156, 50)"
                  class="fa-solid fa-caret-down"
                ></i
                ><button id="reply">댓글</button>
              </div>
            </div>
          </div>

          <!--Reply-Content-->
          <div id="reply_content"></div>
        </div>
      </div>

      <!--board-Writer-Button-->
      <div
        class="d-flex flex-row-reverse mb-5"
        style="width: 70%; margin: 0px auto"
      >
        <div class="p-2">
          <button
            class="btn-st btn btn-outline-secondary"
            onclick="location.href='/board/fb_list'"
          >
            목록보기(작성자)
          </button>
        </div>
        <div class="p-2">
          <button class="btn-st btn btn-outline-secondary">
            삭제하기(작성자)
          </button>
        </div>
        <div class="p-2">
          <button
            class="btn-st btn btn-outline-secondary"
            id="update_free_board"
            data-bs-toggle="modal"
            data-bs-target="#exampleModal_update"
            data-bs-whatever="@mdo"
          >
            수정하기(작성자)
          </button>
        </div>
      </div>

      <!--modal-->
      <div
        class="modal fade"
        id="exampleModal_update"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">
                <b style="color: gray">글 수정하기😊</b>
              </h5>
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <div class="modal-body">
              <form
                action="fb_update"
                method="post"
                enctype="multipart/form-data"
              >
                <input value="${freeBoardDTO.fb_num}" style="display: none" />
                <div class="mb-2">
                  <label
                    for="recipient-name"
                    class="col-form-label"
                    style="color: gray"
                    ><b>글제목</b></label
                  >
                  <input
                    type="text"
                    name="title"
                    value="${freeBoardDTO.title}"
                    class="form-control"
                    id="exampleFormControlInput1"
                  />
                </div>
                <div class="mb-3">
                  <label
                    for="message-text"
                    class="col-form-label"
                    style="color: gray"
                    ><b>내용</b></label
                  >
                  <textarea
                    name="contents"
                    class="form-control mt-1"
                    id="contents"
                    rows="3"
                  >
${freeBoardDTO.contents}</textarea
                  >
                </div>
              </form>
            </div>
            <div class="modal-footer">
              <button
                type="button"
                id="close"
                class="btn btn-secondary"
                data-bs-dismiss="modal"
              >
                취소
              </button>
              <button
                class="update_btn btn btn-warning"
                id="update_btn"
                data-board-num="${freeBoardDTO.fb_num}"
              >
                등록하기
              </button>
            </div>
          </div>
        </div>
      </div>

      <!--Fixed-button:back-->
      <div class="d-flex flex-row-reverse fix_b">
        <div class="fix_box d-flex">
          <div class="d-grid gap-2 d-md-block">
            <button
              class="fix_btn"
              type="button"
              onclick="location.href='/board/fb_list'"
            >
              <i class="fa-solid fa-circle-chevron-left"></i>
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
    <script type="text/javascript">
      $("#contents").summernote({
        placeholder: "글 내용 수정",
        height: 260,
        minHeight: null,
        maxHeight: null,
        focus: true,
      });
    </script>
    <script src="/resources/js/fb_detail.js"></script>
    <script></script>
  </body>
</html>
