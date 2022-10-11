<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${detail.l_name}</title>
    <link rel="stylesheet" href="/resources/css/index.css" />
    <link rel="stylesheet" href="/resources/css/lecture/lecture_detail.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
    href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap"
    rel="stylesheet"
    />
    <link rel="shortcut icon" href="/resources/images/favicon.ico">
</head>
<c:import url="../template/header.jsp"></c:import>
<body>
    <main class="container mt-5">
        
            <div class="row main-content">
                <div class="col-lg-2 sidebar" id="leftside">
                    <!-- Categories widget-->

                    <!--Teacher NAME-->
                    <div class="card mb-4 sidebar__inner text-center left" style="display: block;" >
                        <div class="card-header">강사</div>
                        <div class="card-body">
                            <div>${detail.memberDTO.n_name}</div>
                        </div>
                    </div>

                    <!--Category-->
                    <div class="card mb-4 sidebar__inner text-center left" style="display: block;" >
                        <div class="card-header">Category</div>
                        <div class="card-body">
                            <div>${detail.c_name}</div>
                        </div>
                    </div>

                        <!--Level-->
                    <div class="card mb-4 sidebar__inner text-center left" style="display: block;">
                        <div class="card-header">Level</div>
                        <div class="card-body">
                            <div>${detail.level_name}</div>
                        </div>
                    </div>
                        <!--Student Count-->
                    <div class="card mb-4 sidebar__inner text-center left" style="display: block;">
                        <div class="card-header">수강중인 학생 수</div>
                        <div class="card-body">
                            <div>${detail.l_count}명</div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8 content" id="content">
                    <!-- Post content-->
                    <article>
                        <!-- Post header-->
                        <div>
                            <!-- Post title-->
                            <h1 class="fw-bolder mb-1 text-center">${detail.l_name}</h1>
                        </div>
                        
                        <!-- Preview image figure-->
                        <figure class="mb-4"><img class="img-fluid rounded" src="http://20.249.88.100/resources/lecture/${detail.lectureFileDTO[0].f_name}" alt="..." width="600" height="350"></figure>
                        <!-- Post content-->
                        <section class="mb-5">
                            ${detail.l_contents}
                        </section>
                        <div>
                            <c:forEach items="${file}" var="file" begin="1">
                                <div class="mt-3 mb-3">
                                <img class="img-fluid rounded" src="../resources/upload/lecture/${file.f_name}" alt="..." width="600" height="350" >
                                </div>
                            </c:forEach>    
                        </div>
                    </article>
                </div>
                <!-- Side widgets-->
                <div class="col-lg-2 sidebar" id="aside">
                    
                    <!-- Side widget-->
                    <div class="card mb-4 sidebar__inner" style="display: block;">
                        <div class="card-header text-center">목 차 (총 ${count} 강의)</div>
                        <c:forEach items="${ar}" var="ar">
                        <div class="card-body" id="list">
                           ✔ ${ar.v_context}
                        </div>
                        </c:forEach>
                    </div>
                    <div class="input">
                    <!--board-->
                    <!-- <div class="card mb-4 sidebar__inner text-center" style="display: block;">
                        <div class="card-header">
                            수강평 보러가기
                        </div>
                            <div class="card-body">-->
                                <div class="input-group"> 
                                    <button class="btn btn-primary" id="board" type="button" data-lnum-num="${param.l_num}" style="border :none; background-color: white; color: #66ba39;">📝수강평<br> 보러가기</button>
                                 </div>
                           <!-- </div>
                    </div> -->
                    <!--Sign-->
                    <!-- <div class="card mb-4 sidebar__inner text-center" style="display: block;">
                        <div class="card-header">
                            Sign
                        </div>
                            <div class="card-body"> -->
                                <div class="input-group">
                                    <button class="btn btn-primary" id="signs" type="button" data-lnum-num="${param.l_num}" style="border :none; background-color: white; color: #66ba39;">✏수강신청<br> 하기</button>
                                </div>
                            <!-- </div>
                    </div> -->
                    <!--Listen-->
                    <!-- <div class="card mb-4 sidebar__inner text-center" style="display: block;">
                        <div class="card-header">
                            Listen
                        </div>
                            <div class="card-body"> -->
                                <div class="input-group">
                                    <button class="btn btn-primary" id="listen" type="button" data-listen-num="${param.l_num}" style="border :none; background-color: white; color: #66ba39;">🎧강의 <br>들으러 가기</button>
                                </div>
                            <!-- </div>
                    </div> -->
                    <!--Update-->
                    <!-- <div class="card mb-4 sidebar__inner text-center" style="display: block;">
                        <div class="card-header">Update</div>
                            <div class="card-body"> -->
                                <c:if test="${not empty sessionScope.member}">
                                <div class="input-group">
                                    <button class="btn btn-primary" id="update" type="button" data-update-num="${param.l_num}" style="border :none; background-color: white; color: #66ba39;">💡수정하기</button>
                                </div>
                                <!-- </div>
                                </div> -->
                                <!--Delete-->
                                <!-- <div class="card mb-4 sidebar__inner text-center" style="display: block;">
                                    <div class="card-header">Delete</div>
                                    <div class="card-body"> -->
                                        <div class="input-group">
                                            <button class="btn btn-primary" id="de" type="button" data-delete-num="${param.l_num}" style="border :none; background-color: white; color: #66ba39;">❌삭제하기</button>
                                        </div>
                                        </c:if>
                            <!-- </div>
                    </div> -->
                </div>
                </div>
                
            </div>
            <!--OT 비디오-->
            <section class="mb-5">
                <div class="card" id="ot">
                    <div class="card-body">
                        <h2 class="text-center">OT 영상</h2>
                        <p class="text-center">${detail.lectureVideoDTO[0].v_context}</p>
                        ${detail.lectureVideoDTO[0].v_url}
                       
                    </div>
                </div>
            </section>
        
    </main>
    <c:import url="../template/footer.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    <script src="/resources/js/lecture_detail.js">
        
    </script>
    <script>setLectureSign()</script>
    <script>setTeacherCheck()</script>
</body>
</html>