<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>강의 매출 목록</title>
    <!--파비콘-->
    <link rel="shortcut icon" href="/resources/images/favicon.ico">
    <!-- help icon-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20,700,0,0" />
    <!--bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
	
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    
    <link rel="stylesheet" href="/resources/css/admin/bscommon.css">
</head>
<body>
  <div class="container-fluid" style="height: 90px;">
    <c:import url="../template/header.jsp"></c:import>
  </div>
  <main class="container px-4">
  	<div class="row">
  	<div class="col col-xl-10">
      <h3 style="line-height: 80px"><strong>💰 강의 판매 현황</strong></h3>
	</div>
    <div class="card mb-4">
        <div class="card-body">
            <h6>
                <b>검색 조건 설정</b>
            </h6>
            <div class="row">
                <div class="col-7">
                    <span class="text-muted">시작날짜</span>
                    <input type="date" id="startDate" name="startDate" class="p-1"></input>
                    ~
                    <span class="text-muted">끝날짜</span>
                    <input type="date" id="endDate" name="endDate" class="p-1"></input>
                </div>
                <div class="col-5">
                    <div class="input-group">
                    <select type="button" name="kind" id="kind" class="btn btn-outline-success dropdown-toggle" style="text-align: left;" data-bs-toggle="dropdown" aria-expanded="false">
                        <option value="P_UID">결제번호</option>
                        <option value="TEACHER">강사아이디</option>
                        <option value="L_NAME">강의명</option>
                        <option value="ID">구매자아이디</option>
                    </select>
                    <input type="text" name="search" id="search" class="form-control"></input>
                    </div>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <span class="text-muted">상태</span>
                    <input type="checkbox" id="paid" name="status" value="paid" checked>
                    <label id="plb" for="paid" style="font-weight:bold; color:black">결제</label>
                    <input type="checkbox" id="canceled" name="status" value="canceled" checked>
                    <label id="clb" for="canceled" style="font-weight:bold; color:black">환불</label>
                </div>
            </div>
            <div class="row mt-2">
                <button type="button" class="btn btn-outline-success mx-auto" id="btnSearch" style="width: 100px;">검색</button>
            </div>
        </div>
    </div>
    <div class="card">
        <div class="d-flex ms-3 justify-content: flex-start;">
            <div class="p-2 flex-grow-3"><b>VIEW</b></div>
            <div class="p-2 flex-grow-3" style="color: gray">|</div>
            <div class="p-2 flex-grow-3">
                <input type="radio" id="new" name="orderby" value="new" style="display: none;" checked>
                <label id="newlb" for="new" style="font-weight:bold; color:black">⏳ 최신 순</label>
            </div>
            <div class="p-2 flex-grow-3">
                <input type="radio" id="old" name="orderby" value="old" style="display: none;" >
                <label id="oldlb" for="old">⌛ 오래된 순</label>
            </div>
          </div>
    </div>
    <div class="card mb-4 mt-2">
        <div class="card-header" id="postResult">
        </div>
    </div>
    </div>
</main>

  <c:import url="../template/footer.jsp"></c:import>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>