<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="shortcut icon" href="/resources/images/15.png">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
					<div class="text-center my-5">
						<img src="/resources/images/15.png" alt="logo" width="200">
					</div>
					<div class="card shadow-lg">
						<div class="card-body p-5">
							<h1 class="fs-4 card-title fw-bold mb-4">관리자 로그인</h1>
							<form method="POST" class="needs-validation" novalidate="" autocomplete="off">
								<div class="mb-3">
									<label class="mb-2 text-muted" for="id">ID</label>
									<input id="id" type="email" class="form-control" name="id" value="" required autofocus>
								</div>

								<div class="mb-3">
									<div class="mb-2 w-100">
										<label class="text-muted" for="password">Password</label>
									</div>
									<input id="password" type="password" class="form-control" name="password" required>
								</div>

								<div class="d-flex align-items-center">
									<div class="form-check">
										<input type="checkbox" name="remember" id="remember" class="form-check-input ">
										<label for="remember" class="form-check-label">Remember Me</label>
									</div>
									<button type="submit" class="btn ms-auto btn-outline-success" >
										Login
									</button>
								</div>
							</form>
						</div>
						<div class="card-footer py-3 border-0">
							<div class="text-center">
								최초 관리자 로그인 전에 인증이 필요합니다.<br>
								<!--관리자 인증 모달-->
								<div>
									<!-- Button trigger modal -->
									<button type="button" id="btnAuth" data-bs-toggle="modal" data-bs-target="#modalAuth">
									관리자 인증
									</button>
								
									<!-- Modal -->
									<div class="modal fade" id="modalAuth" tabindex="-1" aria-hidden="true">
										<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
											<h5 class="modal-title" id="ModalLabel">관리자 인증</h5>
											</div>
											<div class="modal-body mb-3">
												<div class="mb-3"> 
													일석이조 회원가입을 먼저한 후 <br>
													관리자 인증을 해주세요
												</div>
												<form>
													<div class="mb-3 row">
														<label for="recipient-name" class="text-muted col-form-label">아이디</label>
														<input type="text" class="form-control col-3" id="idAuth">
													</div>
													<div class="mb-3">
														<label for="recipient-name" class="text-muted col-form-label">비밀번호</label>
														<input type="password" class="form-control" id="pwAuth">
													</div>
													<div class="mb-3">
														<label for="recipient-name" class="text-muted col-form-label">인증번호</label>
														<input type="text" class="form-control" id="authNum">
													</div>
												</form>
												<!--인증요청 응답텍스트 표시-->
												<div id="authMessage"></div>
											</div>
											<div class="modal-footer">
											<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
											<button type="button" class="btn btn-outline-success" id="getAuth">인증 요청</button>
											</div>
										</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>



	<style type="text/css">
	.form-control:focus {
		border-color:#aed581;
		box-shadow: 0 0 0 0.25rem #e1ffb1;
		}
	#btnAuth{
		border:none;
		color:#7da453;
		background-color: transparent !important;
		text-decoration:underline;
	}
	</style>
<script src="/resources/js/admin.js">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>