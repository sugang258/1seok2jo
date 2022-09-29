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
    <div class="container" style="min-width: 950px;">
    <div class="row justify-content-center pt-3 mt-3">
        <div class="mx-5">
            <h4 class="mx-5"><b>결제 상세 정보</b></h3>    
        </div>
        <div class="col mx-5" style="border: 2px solid #aed581;">      
            <div class="row my-2">
                <div class="col">
                    결제번호<span>${paymentDTO.p_uid}</span>  
                </div>
                <div class="col">
                    주문일자  <span>${paymentDTO.p_regdate}
                </div>
                <div class="col text-end">
                    <button type="button" onclick=doPopupopen()>매출전표보기</button>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col mx-5">
            <div class="row">
                <table border="1" cellspacing="0" style="border:none; border-top:1px solid #4b830d; border-bottom:1px solid #dddde1">
                    <colgroup>
                        <col width="10%"  />
                        <col width="55%"/>
                        <col width="15%" />
                        <col width="10%"/>
                        <col width="10%"/>
                    </colgroup>
                    <thead style="background-color: #e8f5e9;">
                        <tr>
                            <th>강의주문번호</th>
                            <th>강의정보</th>
                            <th>금액</th>
                            <th>상태</th>
                            <th>환불요청</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!--강의주문 상세-->
                        <c:forEach items="${paymentDTO.orders}" var="order">
                        <tr>
                            <td>
                                <b>${order.o_num}</b>
                            </td>
                            <td>
                                <div class="row g-1 p-3 align-items-center">
                                    <div class="col-3">
                                      <img src="../../../resources/images/22.png" class="img-fluid rounded-start" style="object-fit: contain">
                                    </div>
                                    <div class="col-9">
                                      <small class="d-inline-flex px-2 py-1 fw-semibold text-success bg-success bg-opacity-10 border border-success border-opacity-10 rounded-2">${order.lectureDTO.l_date} 개월 수강</small>
                                      <label for="name" class="text-muted">${order.lectureDTO.id}</label>
                                      <p>${order.lectureDTO.l_name}</p>
                                    </div>
                                  </div>
                            </td>
                            <td>
                                ${order.o_amount}
                            </td>
                            <td>
                            	<c:if test="${order.refundDTO eq null}">
                            		결제완료                           	
                            	</c:if>
                                <c:if test="${not empty order.refundDTO}">
                                	환불완료
                                </c:if>
                            </td>
                            <td>
                                <button type="button">환불</button> 
                                결제 후 3일 이내에만 환불
                            </td>
                        </tr>
                        
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row mt-3">
        <div class="mx-5">
            <h5><b>주문/결제 금액 정보</b></h5>    
        </div>
        <div class="col mx-5">
            <div class="row">
                <table border="1" cellspacing="0" style="border:none; border-top:1px solid #383d4a; border-bottom:1px solid #dddde1">
                    <colgroup>
                        <col width="60%" style="background:#aed581"/>
                        <col width="40%"/>
                    </colgroup>
                    <tbody>
                        <tr>
                            <td>
                                <strong>총 주문 금액</strong>${paymentDTO.p_amount}원<br>
                                <span class="text-muted">사용 마일리지</span> ${paymentDTO.p_point}마일리지<BR>
                                <span>총 결제 금액</span> ${paymentDTO.p_realamount}원<br>
                            </td>
                            <td>
                                <strong>포인트 혜택</strong><BR>
                                <span> 포인트 적립</span>
                                <span>30원</span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>결제금액</strong><BR>
                                <span>${paymentDTO.p_realamount}</span>
                            </td>
                            <td>
                                <strong>결제 상세</strong>
                                <span>카드결제</span>
                                <span>-
	                                <c:choose>
	                                	<c:when test="${paymentDTO.p_c_quota eq '0'}">일시불</c:when>
	                                	<c:otherwise>${paymentDTO.p_c_quota}개월</c:otherwise>
	                                </c:choose>
                                </span><BR>
                                <span>${paymentDTO.p_c_name}</span><span>${paymentDTO.p_c_num}</span><!--카드번호 문자열 처리 필요-->
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <c:if test="${not empty order.refundDTO}">
        <!--환불은 환불내역 있어야 보이도록.. 환불 갯수를 리턴 받고 0이면 프린트하지 않음-->
        <div class="row mt-3">
            <div class="mx-5">
                <h5><b>환불금액 상세정보</b></h5>    
            </div>
            <div class="col mx-5">
                <div class="row">
                    <table border="1" cellspacing="0" style="border:none; border-top:1px solid #383d4a; border-bottom:1px solid #dddde1">
                        <colgroup>
                            <col width="60%" style="background:#dddde1"/>
                            <col width="40%"/>
                        </colgroup>
                        <tbody>
                            <tr>
                                <td>
                                    <strong>최종 환불 금액</strong>pr_amount 합계<br>
                                    <span>환불 상품 주문 금액</span> o_amount 합계 원<br>
                                    <span>환불 마일리지</span> pr_point 합계 마일리지
                                </td>
                                <td>
                                    <strong>취소 상품 상세</strong><br>
                                    <!--refund 갯수에 따라 반복-->
                                    <span>상품명</span><small>(pr_regdate)</small> <span>pr_amount</span><br>
                                    <span>마일리지 환물</span> <span>pr_point</span>
                                    <!--반복 끝-->
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <strong>결제금액</strong>
                                    <span>${paymentDOT.p_realamount}</span>
                                </td>
                                <td>
                                    <strong>결제 상세</strong>
                                    <span>카드결제</span><span>-${paymentDTO.p_c_quota}</span>
                                    <span>${paymentdto.p_c_name}</span><span>${paymendot.p_c_num}</span>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!--환불 끝-->

    </c:if>
    </div>
    <div class="container-fluid mt-5" style="height: 300px;">
        <c:import url="../template/footer.jsp"></c:import>
    </div>
    <!--매출전표 띄우기-->
    <script type="text/javascript">
        function doPopupopen() {
            window. open("${paymentDTO.p_receipt}", "_blank", "width=300, height=360");
        }
        function doCancle(){
            window. open("/pay/cancle", "_blank", "width=300, height=360");
        }
    </script>
<!--부트스트랩-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>

</body>
</html>