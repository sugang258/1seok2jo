<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-success">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="/admin/main"><b>일석이조</b> <span class="small" style="color:rgba(255,255,255,0.5)">관리자모드</span></a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <a class="btn btn-link btn-sm d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0" id="sidebarToggle" href="/">일석이조 바로가기</a>
            <button class="btn btn-link btn-sm d-md-inline-block form-inline me-2" id="logout" type="button"><span class="material-symbols-outlined" style="color:rgba(255,255,255,0.5)">logout</span></button>

        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">고객 문의</div>
                            <a class="nav-link" href="/admin/csboardList">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                문의 관리
                            </a>
                            <div class="sb-sidenav-menu-heading">일석이조 관리</div>
                            <a class="nav-link" href="/admin/memberList">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                회원관리
                            </a>
                            <a class="nav-link" href="/admin/paymentList">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                매출관리
                            </a>
                            <a class="nav-link" href="/admin/boardsList">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                게시판관리
                            </a>
                            <a class="nav-link" href="/admin/lectureList">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                강의관리
                            </a>
                        </div>
                    </div>

                </nav>
            </div>