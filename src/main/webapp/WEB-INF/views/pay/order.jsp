<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Order 페이지</title>
    <!--파비콘-->
    <link rel="shortcut icon" href="/resources/images/favicon.ico">
    <!--bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <!-- iamport.payment.js -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
    <!-- help icon-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20,700,0,0" />
  </head>
<body>
  <div class="container-fluid" style="height: 90px;">
    <c:import url="../template/header.jsp"></c:import>
  </div>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-lg-6 col-md-8 col-10">
      	<div class="card">
          <div class="card-body text-center">
            결제하기
          </div>
        </div>
        <div class="card mt-3">
          <div class="card-header">
            <label>구매자 정보</label>
            <button type="button btn_tooltip" style="border: none; background-color: transparent;" data-bs-toggle="tooltip" data-bs-placement="right" data-bs-title="입력된 이름과 이메일은 거래 증빙에 사용됩니다.">
              <svg width="16" height="16" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><!--! Font Awesome Pro 6.1.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2022 Fonticons, Inc. --><path fill="#abb0b5" d="M256 0C114.6 0 0 114.6 0 256s114.6 256 256 256s256-114.6 256-256S397.4 0 256 0zM256 464c-114.7 0-208-93.31-208-208S141.3 48 256 48s208 93.31 208 208S370.7 464 256 464zM256 336c-18 0-32 14-32 32s13.1 32 32 32c17.1 0 32-14 32-32S273.1 336 256 336zM289.1 128h-51.1C199 128 168 159 168 198c0 13 11 24 24 24s24-11 24-24C216 186 225.1 176 237.1 176h51.1C301.1 176 312 186 312 198c0 8-4 14.1-11 18.1L244 251C236 256 232 264 232 272V288c0 13 11 24 24 24S280 301 280 288V286l45.1-28c21-13 34-36 34-60C360 159 329 128 289.1 128z"></path></svg>
            </button>
          </div>
          <div class="card-body">
            <div class="">
              <label for="name" class="text-muted">이름</label>
              <input type="text" class="form-control" id="name" value="${member.name}">
            </div>
            <div class="mt-2">
              <label for="email" class="text-muted">이메일</label>
              <input type="text" class="form-control" id="email">
            </div>
            <div class="mt-2">
              <label for="phone" class="text-muted">전화번호</label>
              <input type="text" class="form-control" id="phone">
            </div>
          </div>
        </div>

        <div class="card mt-3">
          <div class="card-header">
            <label>강의 정보</label>
          </div>
          <div class="card-body">
            <!--강의정보내용-->
            <!--테스트 강의정보-->
            <div class="row g-1 p-3 align-items-center">
              <div class="col-3">
                <img src="../../../resources/images/22.png" class="img-fluid rounded-start" style="object-fit: contain">
              </div>
              <div class="col-md-6">
                <small class="d-inline-flex px-2 py-1 fw-semibold text-success bg-success bg-opacity-10 border border-success border-opacity-10 rounded-2">6개월 수강</small>
                <label for="name" class="text-muted">테스트 강사명</label>
                <p>테스트 강의명</p>
              </div>
              <div class="col-md-3 text-end">
                5000원
              </div>
            </div>
            <!--테스트 끝-->
            <c:forEach items="${lectures}" var="lecture">
              <div class="row g-1 p-3 align-items-center">
                <div class="col-3">
                  <img src="../../../resources/images/22.png" class="img-fluid rounded-start" style="object-fit: contain">
                </div>
                <div class="col-md-6">
                  <small class="d-inline-flex px-2 py-1 fw-semibold text-success bg-success bg-opacity-10 border border-success border-opacity-10 rounded-2">${lecture.l_date}개월 수강</small>
                  <label for="name" class="text-muted" id="teacher">${lecture.id}</label>
                  <p id="l_name">${lecture.l_name}</p>
                </div>
                <div class="col-md-3 text-end">
                  <span id="l_price">${lecture.l_price}</span>
                  <span>원</span>
                </div>
              </div>
            </c:forEach>
            
            <!--강의-->
          </div>
        </div>

        <!--금액-->
        <div class="card mt-3">
          <div class="card-header">
            <label>결제금액</label>
          </div>
          <div class="card-body">
            <div class="mb-3" style="display: flex; justify-content:space-between">
              <span>총 상품 금액</span>
              <span>1000원</span>
            </div>
            <div class="row">
              <div class="col-6">
                <label for="point">사용 마일리지</label>
              </div>
              <div class="col-6 text-end">
                <span id="usePoint"></span>  
              </div>
            </div>
            <input type="number" class="form-control text-end" id="point" name="point" placeholder="사용가능 ${member.point}마일리지">
            <div class="mt-2" style="display: flex; justify-content:space-between">
              <span class="fw-bold">총 결제 금액</span>
              <span class="fw-bold" id="total"></span>
            </div>
          </div>
        </div>

        <div class="card mt-3 mb-5">
          <button type="button" class="btn btn-secondary" id="btnimport">결제하기</button>
        </div>
      </div>
    </div>
  </div>


  <style>
    #point::-webkit-outer-spin-button,
    #point::-webkit-inner-spin-button {
        -webkit-appearance: none;
    }
  </style>
  <script src="/resources/js/pay.js"></script>
  <!--부트스트랩-->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>