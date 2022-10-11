<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    <div class="container" style="min-width: 1150px;">
    <div class="row justify-content-center pt-3 mt-5">
        <div class="mx-5">
            <h4 class="mx-5"><b>🧾 결제 상세 정보</b></h3>    
        </div>
        <div class="col mx-5 my-3" style="border: 2px solid #aed581;">      
            <div class="row my-2">
                <div class="col p-2">
                    <b>결제번호 <span> ${paymentDTO.p_uid}</span>  </b>
                </div>
                <div class="col p-2">
                    <b>주문일자  <span>${paymentDTO.p_regdate}</b>
                </div>
                <div class="col text-end">
                    <button type="button" class="btn btn-outline-success" onclick=doPopupopen()><b>매출전표보기</b></button>
                </div>
            </div>
        </div>
    </div>
    <div class="row my-3">
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
                        <tr >
                            <th class="p-1 text-center">주문번호</th>
                            <th class="p-1">강의정보</th>
                            <th class="p-1">금액</th>
                            <th class="p-1">상태</th>
                            <th class="p-1">환불요청</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!--강의주문 상세-->
                        <c:forEach items="${paymentDTO.orders}" var="order">
                        <tr>
                            <td class="text-center">
                                <b>${order.o_num}</b>
                            </td>
                            <td class="p-3">
                                <span>${order.lectureDTO.l_name}</span>
                                <label for="name" class="text-muted">${order.lectureDTO.id}</label>
                                <small class="d-inline-flex px-2 py-1 fw-semibold text-success bg-success bg-opacity-10 border border-success border-opacity-10 rounded-2">${order.lectureDTO.l_date} 개월 수강</small>
                            </td>
                            <td>
                                ${order.o_amount}
                            </td>
                            <td>
                            	<c:if test="${order.pr_num eq null}">
                            		결제완료                           	
                            	</c:if>
                                <c:if test="${not empty order.pr_num}">
                                	환불완료
                                </c:if>
                            </td>
                            <td >
                                <c:if test="${order.pr_num eq null}">
                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-secondary" id="cancleBtn" data-bs-toggle="modal" data-bs-target="#modalCancel" data-onum="${order.o_num}" data-amount="${order.o_amount}" data-lnum="${order.lectureDTO.l_num}" data-lname="${order.lectureDTO.l_name}">
                                        <b>환불</b>
                                    </button>                         	
                            	</c:if>
                            </td>
                        </tr>
                        
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row my-3">
        <div class="mx-5">
            <h5><b>주문/결제 금액 정보</b></h5>    
        </div>
        <div class="col mx-5">
            <div class="row">
                <table border="1" cellspacing="0" style="border:none; border-top:1px solid #383d4a; border-bottom:1px solid #dddde1">
                    <colgroup>
                        <col width="60%" style="background:#e8f5e9"/>
                        <col width="40%"/>
                    </colgroup>
                    <tbody>
                        <tr>
                            <td class="p-3">
                                <div class="d-flex justify-content-between">
                                    <span><strong>총 주문 금액</strong></span><span>${paymentDTO.p_amount} 원&nbsp&nbsp </span>
                                </div>
                                <div class="d-flex justify-content-between">
                                    <span class="text-muted">사용 마일리지</span> <span id="p_point" class="text-muted">(-) ${paymentDTO.p_point} 마일</span>
                                </div>
                                <div class="d-flex justify-content-between" style="color:darkred">
                                    <span><strong>총 결제 금액</strong></span> 
                                    <span><b>${paymentDTO.p_realamount} 원&nbsp&nbsp</b></span>
                                </div>
                            </td>
                            <td class="p-3">
                                <strong>마일리지 혜택</strong><BR>
                                <div class="d-flex justify-content-between">
                                <span> 마일리지 적립</span>
                                <fmt:parseNumber var="prpoint" value="${paymentDTO.p_realamount*0.05}" integerOnly="true"/>
                                <span>${prpoint}마일리지</span>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="p-3">
                                <div class="d-flex justify-content-between">
                                    <span><strong>카드 결제</strong></span>
                                    <span><strong>${paymentDTO.p_realamount} 원&nbsp&nbsp</strong></span>
                                </td>
                                <td class="p-3">
                                    <strong>결제 상세</strong>
                                    <span>
                                    <c:choose>
                                        <c:when test="${paymentDTO.p_c_quota eq '0'}">일시불</c:when>
                                        <c:otherwise>${paymentDTO.p_c_quota}개월</c:otherwise>
                                    </c:choose>
                                </span><BR>
                                <div class="d-flex justify-content-between">
                                <span>${paymentDTO.p_c_name} </span><span id="pcnumView" data-pcnum="${paymentDTO.p_c_num}"></span><!--카드번호 문자열 처리 필요-->
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <c:if test="${not empty paymentDTO.refunds}">
        <!--환불은 환불내역 있어야 보이도록.. 환불 갯수를 리턴 받고 0이면 보이지 않음-->
        <div class="row mt-3">
            <div class="mx-5">
                <h5><b>환불금액 상세정보</b></h5>    
            </div>
            <div class="col mx-5">
                <div class="row">
                    <table border="1" cellspacing="0" style="border:none; border-top:1px solid #383d4a; border-bottom:1px solid #dddde1">
                        <colgroup>
                            <col width="60%" style="background:#f0f0f3"/>
                            <col width="40%"/>
                        </colgroup>
                        <tbody>
                            <tr>
                                <td class="p-3">
                                    <c:forEach items="${paymentDTO.refunds}" var="refund">
                                        <input type="number" class="cal_pramount d-none" value="${refund.pr_amount}"></input>
                                    </c:forEach>
                                    <div class="d-flex justify-content-between">
                                        <span><strong>카드 환불 금액</strong></span><b><span id="total_pramount">  </span></b>
                                    </div>
                                    <c:forEach items="${paymentDTO.refunds}" var="refund">
                                        <input type="number" class="cal_prpoint d-none" value="${refund.pr_point}"></input>
                                    </c:forEach>
                                    <div class="d-flex justify-content-between">
                                        <span>환불 마일리지</span><span id="total_prpoint">  </span>
                                    </div>
                                    <div class="d-flex justify-content-between">
                                        <span>환불 상품 금액</span><span id="sum_pointamount">  </span>
                                    </div>
                                </td>
                                <td class="p-3">
                                    <strong>취소 상품 상세</strong><br>
                                    <!--refund 갯수에 따라 반복-->
                                    <c:forEach items="${paymentDTO.refunds}" var="refund">
                                        <input type="number" class="chk_prnum d-none" value="${refund.pr_num}" data-regdate="${refund.pr_regdate}" data-pramount="${refund.pr_amount} 원" data-prpoint="${refund.pr_point}"></input>
                                    </c:forEach>
                                    <c:forEach items="${paymentDTO.orders}" var="order">
                                        <div class="chk_orderprnum mt-2"  data-chk="${order.pr_num}" style="display: none;">
                                        <div class="d-flex justify-content-between">
                                            <span class="text-danger"><b>${order.lectureDTO.l_name}</b></span><small><span id="pr-regdate">(2022.10.09) </span></small>
                                        </div>
                                        <div class="d-flex justify-content-between">
                                            <span>환불 금액</span><span id="pr-amount">50000 원 </span>
                                        </div>
                                        <div class="d-flex justify-content-between text-muted">
                                            <span>환불 마일리지</span><span id="pr-point">50000 마일 </span>
                                        </div>
                                        </div>
                                    </c:forEach>
                                    <!--반복 끝-->
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </c:if>
    <!--환불 끝-->
    <!--환불 요청 Modal -->
    <div class="modal fade" id="modalCancel" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog  modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
            <h5 class="modal-title" id="ModalLabel">환불 요청</h5>
            </div>
            <div class="modal-body mb-3">
                <div class="mb-3 text-center"> 
                    <span id="mLname">강의명</span> (<span id="mOamount">55000</span>원)을 환불요청하시겠습니까?
                </div>
                <form method="POST" action="/pay/cancel" id="cancelForm">
                    <input type="text" id="cancelLnum" name="cancelLnum" style="display: none;">
                    <input type="text" id="cancelOnum" name="cancelOnum" style="display: none;">
                    <input type="text" id="cancelPuid" name="cancelPuid" style="display: none;" value="${paymentDTO.p_uid}"/>
                    <div class="row">
                        <div class="col-6">
                          <label>마일리지로 환불 요청</label>
                        </div>
                        <div class="col-6 text-end">
                          <span id="cancelPoint">0 </span>  마일
                        </div>
                    </div>
                    <input type="number" id="pr_point" name="pr_point" class="form-control text-end" value="0">
                    <div class="mb-3">
                        <label for="pr_reason" class="col-form-label text-muted">환불 사유</label>
                        <textarea class="form-control" id="pr_reason" name="pr_reason"></textarea>
                    </div>
                    <div class="mt-2" style="display: flex; justify-content:space-between">
                        <span class="fw-bold">포인트 제외 환불 금액</span>
                        <input type="number" class="fw-bold" name="pr_amount" id="pr_amount" value="0" data-premains="${paymentDTO.p_remains}" readonly></input>원
                    </div>
                    <div id="cancelMessage" class="text-danger text-center"></div>
                </form>
                <!--인증요청 응답텍스트 표시-->
                <div id="authMessage"></div>
            </div>
            <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">요청 취소</button>
            <button type="button" class="btn btn-outline-danger" id="reqCancel">환불 요청</button>
            </div>
        </div>
        </div>
    </div>
    <!--modal끝-->
    </div>
    <div class="container-fluid mt-5" style="height: 300px;">
        <c:import url="../template/footer.jsp"></c:import>
    </div>
    <!--페이지 계산-->
    <script src="/resources/js/payStatus.js"></script>
    <!--매출전표 띄우기-->
    <script type="text/javascript">
        function doPopupopen() {
            window. open("${paymentDTO.p_receipt}", "_blank", "width=300, height=360");
        }
    </script>
    <!--환불 모달 및 요청-->
    <script src="/resources/js/cancel.js"></script>
    <script>cancelPay()</script>
<!--부트스트랩-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<style >
    .modal-backdrop.show{
        opacity:0.1;
    }

    #pr_amount::-webkit-outer-spin-button,#pr_amount::-webkit-inner-spin-button,
    #pr_point::-webkit-outer-spin-button,
    #pr_point::-webkit-inner-spin-button {
      appearance: none;
    }
    
</style>
</body>
</html>