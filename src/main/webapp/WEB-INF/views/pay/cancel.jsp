<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=300, height=360, initial-scale=1.0">
    <title>환불요청</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <!-- jQuery CDN --->
    <script  src="https://code.jquery.com/jquery-3.3.1.min.js"  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="  crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-12 pt-3 text-center" style="background:#e8f5e9;">
				<h3> 환불 요청</h3>
			</div>
				<hr>
		</div>
		<div class="row">
			<div class="col-4">
				<label for="p_uid">주문번호</label>
			</div>
			<div class="col-5">
				<input type="text" id="p_uid" value="${orderDTO.p_uid}" disabled style="border:none">
			</div>
		</div>
		<div class="row">
			<div class="col-4">
				<label for="p_uid">강의명</label>
			</div>
			<div class="col-5">
				<input type="text" id="p_uid" value="${orderDTO.lectureDTO.l_name}" style="border:none">
			</div>
		</div>
		<div class="row">
			<div class="col-4">
				<label for="p_uid">환불금액</label>
			</div>
			<div class="col-5">
				<input type="text" id="p_uid" value="${orderDTO.o_amount}" style="border:none">
			</div>
		</div>
	</div>

    <label for="p_uid">주문번호</label>
    <input type="text" id="p_uid" value="${orderDTO.p_uid}">
    <br>
    
    <label for="reason">환불사유</label>
    <input type="text" id="reason">
    <button onclick="cancelPay()">환불하기</button>

<script src="/resources/js/cancel.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>

</body>
</html>