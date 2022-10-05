<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>일대일 문의 답변창</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="/resources/temp/css/styles1.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- jquery -->
        <script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js" ></script>
        <!-- include summernote css/js-->
        <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
                <!--파비콘-->
        <link rel="shortcut icon" href="/resources/images/favicon.ico">
    </head>
    <body class="sb-nav-fixed">
    	<c:import url="./navbar.jsp"></c:import>
        <div id="layoutSidenav_content">
          <main>
            <div class="container-fluid px-4">
              <h1 class="mt-4">문의 내역 목록</h1>
              <ol class="breadcrumb mb-4">
                  <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                  <li class="breadcrumb-item"><a href="index.html">문의 내역 목록</a></li>
                  <li class="breadcrumb-item active">답변하기</li>
              </ol>
              <form action="./csAnswer" method="post">
                <input type="text" name="cs_num" value="${csboard.cs_num}" style="display: none;">
                <div class="board">
                  <!--내가 문의한 부분-->
                  <div class="board_contents">
                    <div class="row py-2">
                      <div class="col-10 align-content-center" style="padding: 8px 8px 8px 0px; font-size: 14px; margin-top: 0.5rem">
                        <h5 class="px-2"><b>${csboard.cs_title}</b></h5>
                      </div>
                      <div class="col-2 align-content-center my-auto">
                        <c:if test="${csboard.cs_status eq '미답변'}">  
                        <div class="b2 d-flex">
                          <div class="mx-auto">
                            <b>
                              ${csboard.cs_status}
                            </b>
                          </div>
                        </div>
                        </c:if>
                        <c:if test="${csboard.cs_status eq '답변완료'}">  
                        <div class="b1 d-flex">
                          <div class="mx-auto">
                            <b>
                              ${csboard.cs_status}
                            </b>
                          </div>
                        </div>
                        </c:if>
          
                      </div>
                    </div>
                    <hr style="margin: 0;">
                    <div class="row p-3 text-muted flex-row-reverse">
                      ${csboard.regdate}
                    </div>
                    <div class="row">
                      ${csboard.cs_contents}
                    </div>
                  </div>
          
                  <!--답변부분-->
                  <div class="cs_answers">
                    <div class="mb-3">
                      <h5><b>답변</b></h5>
                      <c:if test="${not empty csboard.cs_answer}">
                        ${csboard.cs_answer}
                      </c:if>
                      <c:if test="${empty csboard.cs_answer}">
                        <textarea name="cs_answer"  class="form-control mt-1" id="cs_answer"  rows="3" >
                        </textarea>
                      </c:if>  
                    </div>
                  </div>
                </div>
                <div class="card mb-4">
                  <div class="card-body">
                    <h6>
                        <b>문의자 정보</b>
                    </h6>
                    <div class="row">
                      <div class="col-4">
                          <span class="text-muted">아이디</span>
                          <span>${csboard.id}</span>
                      </div>
                      <div class="col-4">
                        <span class="text-muted">이메일</span>
                        <span>${csboard.cs_email}</span>
                      </div>
                      <div class="col-4">
                        <span class="text-muted">연락처</span>
                        <span>${csboard.cs_phone}</span>
                      </div>
                    </div>
                    <div class="row mt-2">
                        <button type="submit" class="btn btn-outline-success mx-auto" style="width: 100px;">답변하기</button>
                    </div>
                  </div>
                </div>
              </div>
            </form>
            <footer class="py-4 bg-light mt-auto">
              <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                  <div class="text-muted">Copyright &copy; Your Website 2022</div>
                  <div>
                    <a href="#">Privacy Policy</a>
                    &middot;
                    <a href="#">Terms &amp; Conditions</a>
                  </div>
                </div>
              </div>
            </footer>
          </main>
        </div>
        <script type="text/javascript">
	      $("#cs_answer").summernote({
	        placeholder: "문의 답변",
	        height: 260,
	        minHeight: null,
	        maxHeight: null,
	        focus: true,
	      });
	    </script>
      <style>
        .board {
          margin-top: 1em;
          margin-left: auto;
          margin-right: auto;
          box-shadow: rgba(0, 0, 0, 0.05) 0px 6px 24px 0px,
            rgba(0, 0, 0, 0.08) 0px 0px 0px 1px;
        }
        .board_contents {
          border-bottom: solid 1px rgba(156, 152, 152, 0.664);
          width: 97%;
          margin: 0px auto;
          padding: 0px 20px;
          z-index: 10px;
          position: relative;
          
        }

        .b1 {
          border: none;
          width: 5em;
          padding: 3px 5px;
          border-radius: 25px;
          background-color: rgba(174, 241, 172, 0.5);
        }

        .b2 {
          border: none;
          width: 5em;
          padding: 3px 5px;
          border-radius: 25px;
          background-color: rgba(231, 117, 117, 0.5);
        }
        .cs_answers {
          padding: 2em;
          width: 100%;
        }
      </style>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/resources/temp/js/scripts.js"></script>
    </body>
</html>