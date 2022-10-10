<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart page</title>
    <link rel="stylesheet" href="/resources/css/index.css" />
    <link rel="stylesheet" href="/resources/css/lecture/cart.css" />
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
    <main class="container mt-2">
        <div class="py-3 text-center">
            <!--<img class="ml-1 mb-2 " src="/resources/images/15.png" alt="" width="100" height="70" style="display: inline;">-->
            <h2 style="display: inline;">🛒장바구니</h2>
        </div>
        <table class="table">
            <tbody class="table-group-divider">
                <c:forEach items="${lectureDTO}" var="lecturedto">
                    <!--<div class="row gx-2 gx-lg-2 align-items-center my-3 cart" id="cart" data-l-num ="${lecturedto.l_num}">-->
                    <tr class ="cart"id="cart" data-l-num ="${lecturedto.l_num}">
                        <td style="width: 250px;">
                                <img class="img-fluid rounded mb-4 mb-lg-0" src="http://20.249.88.100/resources/lecture/${lecturedto.lectureFileDTO[0].f_name}" alt="..." style="height: 150px;">
                            </td>
                            <td>
                                <div style="margin-top: 30px; font-weight: bold;">
                                ${lecturedto.l_name}
                                </div>
                                ${lecturedto.id} / ${lecturedto.c_name} / ${lecturedto.l_price}원
                            </td>
                            <td>
                                <input type="button" class="btn btn-primary mt-4 del" id="del" data-c-num="${lecturedto.cartDTO.cart_num}" value="삭제하기" style="border :none; color: #66ba39; background-color: white;">
                            </td>
                            <td>
                                <input type="button" class="btn btn-primary mt-4 sign" id="sign" value="수강신청 하기" style="border :none; color: #66ba39; background-color: white;">
                                <input type="label" value="${lecturedto.cartDTO.cart_num}" style="display: none;">
                                </div>
                            </td>

                        </tr>
                    </div>
                    
                    </c:forEach>
            </tbody>
          </table>
        <!-- <div class="row gx-2 gx-lg-2 align-items-center mb-1" id="title">
            <div class="col-lg-2">
                <h3>강의 제목</h3>
            </div>
            <div class="col-lg-2">
                <h4>강사 이름</h4>
            </div>
            <div class="col-lg-1">
                <h4>난이도</h4>
            </div>
            <div class="col-lg-2">
                <h4>카테고리</h4>
            </div>
            <div class="col-lg-2">
                <h4>가격</h4>
            </div>
            <div class="col-lg-3"></div>
            

        </div>
        <c:forEach items="${lectureDTO}" var="lecturedto">
        <div class="row gx-2 gx-lg-2 align-items-center my-3 cart" id="cart" data-l-num ="${lecturedto.l_num}">
            <div class="col-lg-2">
                <img class="img-fluid rounded mb-4 mb-lg-0" src="http://20.249.88.100/resources/lecture/${lecturedto.lectureFileDTO[0].f_name}" alt="...">
                <h3>${lecturedto.l_name}</h3>
            </div>
            <div class="col-lg-2">
                <h4>${lecturedto.id}</h4>
            </div>
            <div div class="col-lg-1">
                <h3>${lecturedto.level_name}</h3>
            </div>
            <div div class="col-lg-2">
                <h4>${lecturedto.c_name}</h4>
            </div>
            <div div class="col-lg-2">
                <h4>${lecturedto.l_price}원</h4>
                <input type="label" value="${lecturedto.cartDTO.cart_num}" style="display: none;">
            </div>
            <div div class="col-lg-3">
                <input type="button" class="btn btn-primary mt-3 del" id="del" value="장바구니에서 삭제하기" style="border :none; color: #66ba39; background-color: white;">
                <input type="button" class="btn btn-primary mt-3 sign" id="sign" value="수강신청 하기" style="border :none; color: #66ba39; background-color: white;">
            </div>
        </div>
    
        </c:forEach> -->
        <input type="button" class="btn btn-primary mt-3 sign" id="all" value="🖱모두 수강신청 하기" style="border :none; color: #66ba39; background-color: white;">

    </main>
    <c:import url="../template/footer.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    <script src="/resources/js/cart.js"></script>
</body>
</html>