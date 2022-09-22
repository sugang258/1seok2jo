<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/index.css" />
<link rel="stylesheet" href="/resources/css/list.css" />
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
</head>
<c:import url="../template/header.jsp"></c:import>
<body>
    <main class="container mt-3">
        <div class="py-3 text-center">
            <img class="ml-1 mb-2 " src="/resources/images/15.png" alt="" width="100" height="70" style="display: inline;">
            <h2 style="display: inline;">강의 수정 Form</h2>
        </div>

        <div class="text-center">
            <form action="update" method="post" id="update" enctype="multipart/form-data" >
                <div class="row g-3">
                
                    <div class="col-12">
                    <label for="l_name" class="form-label">강의 제목</label>
                        <div class="input-group has-validation">
                            <input type="text" class="form-control" id="l_name" name="l_name" placeholder="강의 제목" value="${update.l_name}">
                            <div class="invalid-feedback">
                            Your lecture title is required.
                            </div>
                        </div>
                    </div>
    
                    <div class="col-12">
                        <label for="l_contents" class="form-label">강의 설명</label>
                        <textarea  class="form-control" id="l_contents" name="l_contents" placeholder="강의 설명">${update.l_contents}</textarea>
                        <div class="invalid-feedback">
                            Your lecture content is required.
                        </div>
                    </div>
    
                    <div class="col-md-3">
                        <label for="c_num" class="form-label">Category</label>
                        <select class="form-select" id="c_num" name="c_num" required=""  >
                            <option value="">Choose...</option>
                            <option value="1">Java</option>
                            <option value="2">Python</option>
                            <option value="3">JavaScript</option>
                            <option value="4">HTML/CSS</option>
                        </select>
                        <div class="invalid-feedback">
                            Please select a valid category.
                        </div>
                    </div>
    
                    <div class="col-md-3">
                        <label for="level_num" class="form-label">Level</label>
                        <select class="form-select" id="level_num" name="level_num" required="">
                            <option value="">Choose...</option>
                            <option value="3">상</option>
                            <option value="2">중</option>
                            <option value="1">하</option>
                        </select>
                        <div class="invalid-feedback">
                            Please provide a valid level.
                        </div>
                    </div>
    
                    <div class="col-md-3">
                    <label for="l_date" class="form-label">수강 기간 (개월)</label>
                    <input type="text" class="form-control" id="l_date" name="l_date" placeholder="" required="" value="${update.l_date}">
                    </div>

                    <div class="col-md-3">
                        <label for="l_price" class="form-label">강의 가격 (원)</label>
                        <input type="text" class="form-control" id="l_price" name="l_price" placeholder="" required="" value="${update.l_price}">
                    </div>
                    
                    <div>
                        <label for="files" class="form-label">썸네일 이미지</label>
                        <img src="../resources/upload/lecture/${update.lectureFileDTO[0].f_name}" style="display: inline;">
                        <input type="button" class="btn btn-primary mt-3 del" id="img_change" value="변경하기" style="border :none; color: white; background-color: #66ba39;">
                    </div>

                    <div class="mb-3">
                        <div>
                            <label for="videos" class="form-label">OT 동영상</label>
                            <p>${update.lectureVideoDTO[0].v_context}</p>
                            ${update.lectureVideoDTO[0].v_url}
                        </div>

                        <div>
                        <input type="button" class="btn btn-primary mt-3 del" id="ot_change" value="변경하기" style="border :none; color: white; background-color: #66ba39;">
                        </div>
                    </div>

                    <div class="mt-4">
                        <c:forEach items="${video}" var="ar" begin="1">
                            <label for="videos" class="form-label">동영상 목록</label>
                            <div>
                                <p>${ar.v_context}</p>
                                ${ar.v_url}
                            </div>
                            <div>
                                <input type="button" class="btn btn-primary mt-3 video_dels" id="video_del" value="삭제하기" data-del-num="${ar.v_num}"  style="border :none; color: white; background-color: #66ba39;">
                            </div>
                        </c:forEach>
                    </div>
                    <div class="video_adds">
                        <input type="button" class="btn btn-primary mt-3 del" id="video_add" value="동영상 추가하기"style="border :none; color: #66ba39; background-color: white;">
                    </div>
                    <div>
                        <input type="button" class="w-100 btn btn-primary btn-lg" id="update_sub" style="background-color: #66ba39; border: none;" value="강의 수정"/>
                    </div>
                </div>
            </form>
        </div>
    </main>
    
    <c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#l_contents").summernote({
            height : 500
        })
    });
</script>
<script src="/resources/js/lecture_update.js"></script>
</body>
</html>