<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>게시판 상세보기</title>
    <link rel="stylesheet" href="/resources/css/board/sb_detail.css" />
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
    <section class="container" style="width: 80%">
      <div class="board">
        <div class="board_contents">
          <div style="padding: 12px 0px">
            <div class="d-flex">
              <div
                class="flex-grow-1"
                style="padding: 8px 8px 8px 0px; font-size: 14px"
              >
                <div>${requestScope.studyBoardDTO.category}</div>
              </div>
              <div class="p-2">
                <i class="fa-regular fa-user"></i> ${studyBoardDTO.id}
              </div>
            </div>
            <div>
              <h5><b>${studyBoardDTO.title}</b></h5>
            </div>

            <div class="d-flex mt-4">
              <div class="d-flex p-1 w-100">
                <div class="b1 d-flex">
                  <div>${studyBoardDTO.hit} 조회</div>
                  <div>
                    <b>
                      <c:choose>
                        <c:when test="${studyBoardDTO.answer eq 0}">
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
                style="width: 120px; font-size: 15px"
              >
                ${studyBoardDTO.reg_date}
              </div>
            </div>
          </div>
        </div>

        <!--Contents-->
        <div class="sb_contents">
          <div class="mb-3">
            <h5 style="text-align: justify; text-justify: auto">
              ${studyBoardDTO.contents}
            </h5>
          </div>
          <div style="width: 100%">
            <img
              style="width: 80%; object-fit: fill"
              src="../../../../resources/upload/board/${studyBoardDTO.boardFileDTO.f_name}"
              alt=""
            />
          </div>

          <div>
            <div class="d-flex mt-4">
              <div class="p-2 flex-grow-1">🗨 댓글 ${count}개</div>
              <div class="p-2 share">
                <a href="#" onclick="clip(); return false;"
                  ><i
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
            data-bs-toggle="modal"
            data-bs-target="#exampleModal2"
            data-bs-whatever="@mdo"
          >
            답변달기(강사)
          </button>
        </div>
        <div class="p-2">
          <button
            class="btn-st btn btn-outline-secondary"
            onclick="location.href='./sb_list';"
          >
            목록보기
          </button>
        </div>
        <div class="p-2">
          <button
            class="btn-st btn btn-outline-secondary"
            onclick="location.href='sb_delete?sb_num=${studyBoardDTO.getSb_num()}';"
          >
            삭제하기(작성자)
          </button>
        </div>
        <div class="p-2">
          <button
            type="button"
            class="btn-st btn btn-outline-secondary"
            data-bs-toggle="modal"
            data-bs-target="#exampleModal"
            data-bs-whatever="@mdo"
          >
            수정하기(작성자)
          </button>
        </div>
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
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">
                <b style="color: gray">글 수정하기📚</b>
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
                action="sb_update"
                method="post"
                enctype="multipart/form-data"
              >
                <input
                  value="${studyBoardDTO.getSb_num()}"
                  style="display: none"
                />
                <div class="mb-3">
                  <label
                    for="recipient-name"
                    class="col-form-label"
                    style="color: gray"
                    ><b>글제목</b></label
                  >
                  <input
                    type="text"
                    name="title"
                    value="${studyBoardDTO.title}"
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
${studyBoardDTO.contents}</textarea
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
                class="btn btn-warning"
                id="update_btn"
                data-board-num="${studyBoardDTO.getSb_num()}"
              >
                등록하기
              </button>
            </div>
          </div>
        </div>
      </div>

      <!--modal/강사답글-->
      <div
        class="modal fade"
        id="exampleModal2"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">
                <b style="color: gray">답글작성 😺</b>
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
                action="sb_update"
                method="post"
                enctype="multipart/form-data"
              >
                <input
                  value="${studyBoardDTO.getSb_num()}"
                  style="display: none"
                />
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
                    id="t_answer"
                    rows="2"
                    style="height: 150px"
                  ></textarea>
                </div>
                <div id="addFiles">
                  <button class="mt-2 file_add"><b>파일추가📂</b></button>
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
                class="btn btn-warning"
                id="answer_btn"
                data-board-num="${studyBoardDTO.sb_num}"
              >
                작성하기
              </button>
            </div>
          </div>
        </div>
      </div>

      <div>
        <!-- 강사 답글 위치-->
        <div id="teacher"></div>

        <!--container-box-->
      </div>

      <!--Fixed-button:back-->
      <div class="d-flex flex-row-reverse fix_b">
        <div class="fix_box d-flex">
          <div class="d-grid gap-2 d-md-block">
            <button class="fix_btn" type="button">
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
    <script type="text/javascript">
      $("#contents").summernote({
        placeholder: "글 내용 수정",
        height: 260,
        minHeight: null,
        maxHeight: null,
        focus: true,
      });
      $("#contents").summernote("pasteHTML", data);
      $("#contents").html(
        data
          .replace(/&amp;/g, "&")
          .replace(/&lt;/g, "<")
          .replace(/&gt;/g, ">")
          .replace(/&quot;/g, '"')
          .replace(/&#40;/g, "(")
          .replace(/&#41;/g, ")")
          .replace(/&#35;/g, "#")
      );
    </script>
    <script src="/resources/js/sb_detail.js"></script>
    <script>
      getCommentDetail();
      getReply();
      teacherReply();
    </script>
  </body>
</html>
