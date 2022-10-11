<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>결제완료 페이지</title>
        <!--파비콘-->
        <link rel="shortcut icon" href="/resources/images/favicon.ico">
        <!--bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">    
</head>
<body>
    <div class="container-fluid" style="height:80px">
        <c:import url="../template/header.jsp"></c:import>
    </div>

    <div class="container">
        <div class="row justify-content-center pt-3 mt-5">
            <div class="col-sm-8 text-center">
                <h3><b>결제완료</b></h3>
                
            </div>

            <div class="col-sm-8 my-4 py-3" style="border: 2px solid lightgrey;">
                <div class="row d-flex">
                                        
                    <div class="col-sm-5 order-sm-2" >
                        <div class="row align-items-center" style="height: 100%">
                            <table class="text-center">
                                <tr><th>결제번호</th><td> ${requestScope.result.paymentDTO.p_uid}</td></tr>
                                <fmt:parseNumber var="prpoint" value="${result.paymentDTO.p_realamount*0.05}" integerOnly="true"/>
                                <tr><th>적립 마일리지</th><td> ${prpoint} 마일리지</td></tr>
                                <tr><th>총 결제금액</th><td> ${result.paymentDTO.p_realamount}원</td></tr>
                            </table>

                        </div>
                    </div>

                    <div class="col-sm-7 order-sm-1">
                        <!-- 결제한 강의목록 -->
                        <c:forEach items="${result.lectures}" var="lecture">
                        <div class="row g-1 p-3 align-items-center">
                            <div class="col-3">
                              <img src="http://20.249.88.100/resources/lecture/${lecture.lectureFileDTO[0].f_name}" class="img-fluid rounded" style="object-fit: contain">
                            </div>
                            <div class="col-9">
                              <small class="d-inline-flex px-2 py-1 fw-semibold text-success bg-success bg-opacity-10 border border-success border-opacity-10 rounded-2">${lecture.l_date} 개월 수강</small>
                              <label for="name" class="text-muted">${lecture.id}</label>
                              <p>${lecture.l_name}</p>
                            </div>
                          </div>
                        </c:forEach>

                        <!--결제한 강의목록 끝-->
                    </div>

                </div>
            </div>

            <div class="col-sm-8 text-center mt-2">
                <button type="button" class="btn btn-outline-success" id="list">내 강의목록으로 이동하기</button>
            </div>
        </div>
    </div>
    

    <div class="container-fluid" style="height: 300px;">
        <c:import url="../template/footer.jsp"></c:import>
    </div>
    
<!--부트스트랩-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script src="/resources/js/complete.js"></script>
</body>
</html>