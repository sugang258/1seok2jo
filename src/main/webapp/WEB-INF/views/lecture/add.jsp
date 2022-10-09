<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>강의 추가</title>
    <link rel="stylesheet" href="/resources/css/index.css" />
    <link rel="stylesheet" href="/resources/css/lecture/list.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
    href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap"
    rel="stylesheet"
    />
    <!-- jquery -->
 <script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
    <link rel="shortcut icon" href="/resources/images/favicon.ico">
</head>
<c:import url="../template/header.jsp"></c:import>
<body>
    <main class="container mt-3">
        <div class="py-3 text-center">
            <img class="ml-1 mb-2 " src="/resources/images/15.png" alt="" width="100" height="70" style="display: inline;">
            <h2 style="display: inline;">강의 추가 Form</h2>
        </div>

        <div class="text-center">
            <form action="add" method="post" id="add" enctype="multipart/form-data" >
              <div class="row g-3">
                
                <div class="col-12">
                  <label for="l_name" class="form-label">강의 제목</label>
                  <div class="input-group has-validation">
                    <input type="text" class="form-control add_ele" id="l_name" name="l_name" placeholder="강의 제목">
                  </div>
                  <div id="div3"></div>
                </div>
    
                <div class="col-12">
                  <label for="l_contents" class="form-label">강의 설명</label>
                  <textarea  class="form-control add_ele" id="l_contents" name="l_contents" placeholder="강의 설명"></textarea>
                  <div id="div4"></div>
                </div>
    
                <div class="col-md-3">
                  <label for="c_num" class="form-label">Category</label>
                  <select class="form-select" id="c_num" name="c_num" required="" >
                    <option value="">Choose...</option>
                    <option value="1">Java</option>
                    <option value="2">Python</option>
                    <option value="3">JavaScript</option>
                    <option value="4">HTML/CSS</option>
                    <option value="5">React</option>
                    <option value="6">Node.js</option>
                    <option value="7">Spring</option>
                    <option value="8">SQL</option>
                  </select>
                  <div id="div5"></div>
                </div>
    
                <div class="col-md-3">
                  <label for="level_num" class="form-label">Level</label>
                  <select class="form-select" id="level_num" name="level_num" required="">
                    <option value="">Choose...</option>
                    <option value="3">상</option>
                    <option value="2">중</option>
                    <option value="1">하</option>
                  </select>
                  <div id="div6"></div>
                </div>
    
                <div class="col-md-3">
                  <label for="l_date" class="form-label">수강 기간 (개월)</label>
                  <input type="text" class="form-control add_ele" id="l_date" name="l_date" placeholder="" required="">
                  <div id="div1"></div>
                </div>

                <div class="col-md-3">
                    <label for="l_price" class="form-label">강의 가격 (원)</label>
                    <input type="text" class="form-control add_ele" id="l_price" name="l_price" placeholder="" required="">
                    <div id="div2"></div>
                </div>
            </div>

            <!-- 파일 추가, 동영상 추가-->
            <div class="mt-4 mb-3" id="addFiles">
                <label for="files" class="form-label">강의 썸네일 사진</label>
                <input class="form-control add_ele" type="file" id="files" name="files">
                <div id="div7"></div>
            </div>

            <div class="mt-4 mb-3">
                <label for="v_url" class="form-label">강의 OT 영상 URL</label>
                <input class="form-control add_ele" type="text" id="v_url" name="v_url">
                <div id="div8"></div>
                <label for="v_context" class="form-label">OT 제목</label>
                <input class="form-control add_ele" type="text" id="v_context" name="v_context">
                <div id="div9"></div>
            </div>

            <div class="mb-4" id="addVideos">
                <button type="button" class="btn btn-danger" id="videoAdd" style="border: none; color: #66ba39; background-color: white;">강의 영상 URL 추가</button>
            </div>

              <hr class="my-4">
    
              <input type="button" class="w-100 btn btn-primary btn-lg" id="sub" style="background-color: #66ba39; border: none;" value="강의 추가"/>
            </form>
        </div>

    </main>
    <c:import url="../template/footer.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    <script type="text/javascript">
      $(document).ready(function(){
        $("#l_contents").summernote({
          height:500,
          minHeight: null,             // 최소 높이
				  maxHeight: null,             // 최대 높이
			  	focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
			  	lang: "ko-KR",					// 한글 설정
			  	placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
			  	callbacks: {	//여기 부분이 이미지를 첨부하는 부분
            onImageUpload : function(files) {
              uploadSummernoteImageFile(files[0],this);
            },
            onPaste: function (e) {
              var clipboardData = e.originalEvent.clipboardData;
              if (clipboardData && clipboardData.items && clipboardData.items.length) {
                var item = clipboardData.items[0];
                if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
                  e.preventDefault();
                }
              }
            }
				  }
        });
      })
      function uploadSummernoteImageFile(file, editor) {
        data = new FormData();
        data.append("file", file);
        $.ajax({
          data : data,
          type : "POST",
          url : "/uploadSummernoteImageFile",
          contentType : false,
          processData : false,
          success : function(data) {
                  //항상 업로드된 파일의 url이 있어야 한다.
            $(editor).summernote('insertImage', data.url);
          }
        });
      }
      </script>
    <script src="/resources/js/lecture_file.js"></script>
    <script>addCheck()</script>
</body>
</html>