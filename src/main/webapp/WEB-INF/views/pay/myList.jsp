<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <div class="row justify-content-center pt-3 mt-3">
            <div class="col-sm-8 text-center">
                <h3>📜결제내역</h3>
                
            </div>

            <div class="col-sm-8 text-center">
                <div class="card p-3 my-2">
                	<div class="row align-items-center">
                		<div class="col-3 text-center">
                			<div>
			                    <img src="http://20.249.88.100/resources/member/${payListMap.member.memberFileDTO.f_name}" style="width: 100px;  border-radius: 24px;">
                			</div>
                		</div>
                		<div class="col text-center ">
                            <div class="row align-items-center"></div>
                            <div>${sessionScope.member.n_name}님</div>
                			<div>현재 마일리지</div>
                			
                			<div>구매한 강의 수</div><div>${payListMap.Lcnt} 개</div>
                		</div>
                        <div></div>
                	</div>
                </div>
            </div>
            <c:forEach items="${payListMap.payList}" var="pay">
                <div class="p_detail row">
	            <div class="col-sm-8 text-center mt-5" style="background: url(/resources/images/bg_tit_month.gif); height: 39px;">
		            <div class="py-2 mx-auto" style="background:url(/resources/images/bg_tit_month2.gif); width: 110px; height: 39px;">
                        <b style="color: darkgreen;">${pay.p_regdate }</b>
                    </div>
	            </div>
                <div class="col-sm-8 text-center">
                    <div class="row">
                        <div class="col-8">
                            <div>${pay.orders[0].lectureDTO.l_name}</div>
                            <div><spen class="text-muted">결제금액</spen> ${pay.p_realamount}</div>
                        </div>
                        <div class="col-4">
                            <div>${pay.p_remains eq pay.p_realamount? '결제완료':'환불'}</div>
                            <div><a href="${pay.p_receipt}" style="color:darkolivegreen">매출전표</a></div>
                        </div>
                    </div>
                </div>
                </div>
            </c:forEach>

    <div class="container-fluid" style="height: 300px;">
        <c:import url="../template/footer.jsp"></c:import>
    </div>
    
<!--부트스트랩-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script src="/resources/js/complete.js"></script>
</body>
</html>