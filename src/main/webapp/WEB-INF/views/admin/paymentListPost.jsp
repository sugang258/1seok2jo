<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table class="table table-striped table-hover">
    <thead>
        <tr>
            <th>주문번호</th>
            <th>결제번호</th>
            <th>강의명</th>
            <th>구매자아이디</th>
            <th>강의금액</th>
            <th>강사명</th>
            <th>환불여부</th>
            <th>실 결제금액</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${payList}" var="pay">
            <c:forEach items="${pay.orders}" var="order">
            <tr data-csnum="${pay.p_uid}">
                <td>${order.o_num}</td>
                <td>${pay.p_uid}</td>
                <td>${order.lectureDTO.l_name}</td>
                <td>${pay.id}</td>
                <td>${order.o_amount}</td>
                <td>${order.lectureDTO.id}</td>
                <td>${null eq order.pr_num? '결제완료':'환불완료'}</td>
                <td>${pay.p_realamount}</td>
            </tr>
            </c:forEach>
        </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation">
    <ul class="pagination justify-content-center">
        <li class="page-item">
        <span class="page-link" aria-label="Previous" data-page="1">
            &laquo;&laquo;
        </span>
        </li>
        <li class="${pager.pre? 'page-item disabled':'page-item'}">
        <span class="page-link" data-page="${pager.startNum-1}" aria-label="Previous">
            이전
        </span>
        </li>
        <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
        <li class="page-item"><span class="page-link" data-page="${i}">${i}</span></li>
        </c:forEach>
        <li class="${pager.next? 'page-item disabled':'page-item'}">
        <span class="page-link" data-page="${pager.lastNum+1}" aria-label="Next">
            다음
        </span>
        </li>
        <li class="page-item">
        <span class="page-link" data-page="${pager.totalPage}" aria-label="Next">
            &raquo;&raquo;
        </span>
        </li>
    </ul>
    </nav>