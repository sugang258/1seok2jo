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
        <title>Member List</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="/resources/temp/css/styles1.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
            <!-- jQuery -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    </head>
    <body class="sb-nav-fixed">
    	<c:import url="./navbar.jsp"></c:import>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">문의 내역 목록</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                            <li class="breadcrumb-item active">Tables</li>
                        </ol>
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
                                            <option value="CS_STATUS">답변여부</option>
                                            <option value="CS_TITLE">제목</option>
                                            <option value="ID">아이디</option>
                                            <option value="CS_PHONE">연락처</option>
                                            <option value="CS_EMAIL">이메일</option>
                                        </select>
                                        <input type="text" name="search" id="search" class="form-control" value="미답변"></input>
                                        </div>
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
                                    <input type="radio" id="new" name="orderby" value="new" checked>
                                    <label id="newlb" for="new" style="font-weight:bold; color:black">⏳ 최신 순</label>
                                </div>
                                <div class="p-2 flex-grow-3">
                                    <input type="radio" id="old" name="orderby" value="old" >
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
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/resources/temp/js/scripts.js"></script>
        <script src="/resources/js/admin.js"></script>
        <script>
        initlist()
        </script>
        
    </body>
</html>
