<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주문번호</title>
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
    <div class="row justify-content-center pt-3 mt-3">
        <div class="mx-5">
            <h3 class="mx-5">결제 상세 정보</h3>    
        </div>
        <div class="col mx-5" style="border: 2px solid #aed581;">      
            <div class="">
                <div class="row align-items-center my-2" style="height: 100%">
                    <div class="col">
                        결제번호<span>${requestScope.result.paymentDTO.p_uid}</span>  
                    </div>
                    <div class="col">
                        주문일자  <span>${paymentDTO.p_regdate}
                    </div>
                    <div class="col text-end">
                        <a href="${paymentDTO.p_receipt}" >매출전표보기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <div class="container-fluid" style="height: 300px;">
        <c:import url="../template/footer.jsp"></c:import>
    </div>
    
<!--부트스트랩-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>

</body>
</html>