<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-success">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="/admin/main"><b>일석이조</b> <span class="small" style="color:rgba(255,255,255,0.5)">관리자모드</span></a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <button class="btn btn-link btn-sm d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0" id="teacher" href="#!">선생<i class="fas fa-bars"></i></button>
            <button class="btn btn-link btn-sm d-md-inline-block form-inline" id="sidebarToggle" href="#!">학생<i class="fas fa-bars"></i></button>
            <!-- Navbar-->
            <ul class="navbar-nav d-md-inline-block form-inline">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Settings</a></li>
                        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Logout</a></li>
                    </ul>
                </li>
            </ul>
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