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
<link rel="stylesheet" href="/resources/css/lecture/status.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap"
rel="stylesheet"/>
<link rel="shortcut icon" href="/resources/images/favicon.ico">
</head>
<c:import url="../template/header.jsp"></c:import>
<body>
    <main class="container mt-2">
        <div class="py-3 text-center">
            <h1 style="display: inline;">✏내 학습</h1>
        </div>
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">

                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

                   
                    <c:if test="${ar == null}">
                        <div class="text-center">
                            <div id="null">아직 수강중인 강의가 없습니다.</div>
                            <div id="null2">강의를 수강해 보세요!</div>
                            <input type="button" id="lecture_list" value="강의 보러 가기">

                        </div>
                    </c:if>
                    <c:forEach items="${ar}" var="ar" varStatus="arNm">
                        <div class="col mb-5" id="detail" data-l-num="${ar.l_num}">
                            <div class="card h-100">
                                <!-- Product image-->
                                <img class="card-img-top" src="http://20.249.88.100/resources/lecture/${ar.lectureFileDTO[0].f_name}" alt="...">
                                <!-- Product details-->
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <!-- 강의 이름-->
                                        <div class="fw-bolder">${ar.l_name}</div>
                                        <!--난이도-->
                                        <div class="fw-bolder">난이도</div>
                                        ${ar.level_name}
                                        <!--진도율-->
                                        <div class="fw-bolder">진도율</div>
                                            <div class="progress">
                                                
                                                <div class="progress-bar progress-bar-success progress-bar-striped" id="bar" role="progressbar" aria-valuenow="${status[arNm.index]}"
                                                    aria-valuemin="0" aria-valuemax="100">
                                                    ${status[arNm.index]}% Complete
                                                </div>
                                            </div>
                                            <div class="fw-bolder mt-2">수강 종료 날짜</div>
                                            ${end[arNm.index].s_end}
                                        </div>
                                    </div>
                                <!-- Product actions-->
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center" id="listen">
                                        <input type="button" class="btn btn-outline-dark mt-auto" id="listenbtn" data-ln-num="${ar.l_num}"  value="강의 들으러 가기"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
       
     
    <c:import url="../template/footer.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    <script src="/resources/js/status.js"></script>
</body>
</html>