<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table class="table table-striped table-hover">
    <thead>
        <tr>
            <th><input type="checkbox" id="all"></th>
            <th>강의번호</th>
            <th>강의명</th>
            <th>강사</th>
            <th>강의가격</th>
            <th>수강기간</th>
            <th>카테고리</th>
            <th>난이도</th>
            <th>수강인원</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${lectureList}" var="lecture">
            <tr>
                <td><input type="checkbox" class="chk" name="l_num" value="${lecture.l_num}"/></td>
                <td>${lecture.l_num}</td>
                <td>${lecture.l_name}</td>
                <td>${lecture.id}</td>
                <td>${lecture.l_price}</td>
                <td>${lecture.l_date}</td>
                <td>${lecture.c_name}</td>
                <td>${lecture.level_name}</td>
                <td>${lecture.l_count}</td>
            </tr>
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