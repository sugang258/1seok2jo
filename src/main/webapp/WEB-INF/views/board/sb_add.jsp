<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta charset="UTF-8">
		<title>글 작성</title>
		<link rel="stylesheet" href="/resources/css/board/sb_list.css" />
  	    <%-- Bootstrap CSS --%>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
		<link rel="preconnect" href="https://fonts.googleapis.com" />
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
		<link href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap" rel="stylesheet"/>
		<!-- jquery -->
    	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
		<!-- include summernote css/js-->
	    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
	    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
		<%-- favicon --%>
		<link rel="shortcut icon" href="/resources/images/favicon.ico">
</head>
<c:import url="../template/header.jsp"></c:import>
<body>

    <section class="container" style="width: 50em;">
        <div class="add_box" style="width:80%; margin: 150px auto 50px auto; padding: 1.7em; box-shadow: rgba(17, 17, 26, 0.1) 0px 4px 16px, rgba(17, 17, 26, 0.1) 0px 8px 24px, rgba(17, 17, 26, 0.1) 0px 16px 56px;">
        <div class="mb-4"><h2 style="text-align:center;">질문하기📬</h2></div>
            
                <form action="./sb_add" method="post" enctype="multipart/form-data">

                    <div class="d-flex row">
                        <div class="flex-fill col-8">
                            <div class="mb-1"><label for="exampleFormControlInput1">제목</label></div>
                            <input type="text" name = "title" placeholder="글제목" class="form-control" id="exampleFormControlInput1">
                        </div>
                        <div class="flex-fill col-4">
                            <div class="mb-1"><label for="exampleFormControlInput1">카테고리</label></div>
                            <div class="dropdown">
                                <select type="button" name = "category" class="btn btn-success dropdown-toggle" style="text-align: left;" data-bs-toggle="dropdown" aria-expanded="false">
                                    <option value="JAVA">JAVA</option>
                                    <option value="SPRING">SPRING</option>
                                    <option value="SPRING">JAVASCRIPT</option>
                                    <option value="HTML">HTML</option>
                                    <option value="CSS">CSS</option>
                                </select>
                              </div>
                        </div>
                      </div>
                    
<!--                     임시로 보내는 값 -->
                     <input type="text"  style="display: none;" name = "l_num" value="1">
                     <input type="text"  style="display: none;" name = "answer" value="0">
                     <input type="text"  style="display: none;" name = "hit" value="0">
<!--                     임시로 보내는 값 -->
                    
                    
                    <div class="form-group pt-3 ">
                        <input type="text"  style="display: none;" name = "id" readonly value="USER2" class="form-control" id="exampleFormControlInput1">
                    </div>
                    <div class="mt-1">
                        <div ><label  for="exampleFormControlInput1">글내용</label></div>
                        <textarea name = "contents" class="form-control mt-1" id="contents" rows="3"></textarea>
                    </div>
        
                    <div id="addFiles">
                        <button class="mt-2 file_add"><b>파일추가📂</b></button>
                    </div>			
                    
                    <div class="mt-3 mb-1" style="text-align: right;">
                    <input class="btn btn-success text-white" type="submit" value="작성하기" >
                    </div>			
                </form>
            </div>
        </section>

<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    <script type="text/javascript">
        $("#contents").summernote(
                {
                      height: 260,                
                      minHeight: null,           
                      maxHeight: null,          
                      focus: true 
                    });
        $("#contents").summernote('pasteHTML', data);
        $("#contents").html(data.replace(/&amp;/g, "&").replace(/&lt;/g, "<").replace(/&gt;/g, ">").replace(/&quot;/g,'"').replace(/&#40;/g,'(').replace(/&#41;/g,')').replace(/&#35;/g,'#'));

</script>
</body>
</html>