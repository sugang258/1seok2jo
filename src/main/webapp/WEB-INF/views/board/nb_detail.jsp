<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>게시판 상세보기</title>
    <link rel="stylesheet" href="/resources/css/board/nb_detail.css" />
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
  
    <section class="container" style="width: 80%;">
    
      <div class="board">
        <div class="board_contents">
              <h5><b>[💛업데이트 소식] <span>${noticeDTO.title}</span></b></h5>
        </div>

        <!--Contents-->
        <div class="nb_contents">
          <div class="d-flex mb-4">
          	   <div>
                <img
                  src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png"
                  style="width: 23px; border-radius: 24px; margin-top: -10px; margin-right:4px;"/>
              </div>
             <div class="me-2" style="font-size:14px; font-weight: bold">작성자: <span>${noticeDTO.id}</span>✅</div>
             <div style="font-size:12px;"><span>${noticeDTO.reg_date}</span></div>
          </div>
          <div>
             <span>${noticeDTO.contents}</span>
          </div>
          <div style="width: 100%">
            <img
              style="width: 80%; object-fit: fill"
              src="../../../../resources/upload/board/ㅇㄶㅇㅎㅇㅎ"
              alt=""
            />
          </div>

          <div>
            <div class="d-flex mt-4">
              <div class="flex-grow-1">🌞 댓글 0개</div>
              <div class="">
                <i
                  style="color: orange;"
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
            onclick="location.href='./notice';"
          >
            목록보기
          </button>
        </div>
        <div class="p-2">
          <button
            class="btn-st btn btn-outline-secondary"
            onclick="location.href='nb_delete?n_num=${noticeDTO.n_num}';"
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
      
      <div>


        <!--container-box-->
      </div>

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
    </script>
    <script src="/resources/js/nb_detail.js"></script>
    <script>
      getCommentDetail();
      getReply();
      teacherReply();
    </script>
  </body>
</html>
