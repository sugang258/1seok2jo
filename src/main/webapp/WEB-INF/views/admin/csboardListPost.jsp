<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table class="table table-striped table-hover">
    <thead>
        <tr>
            <th>등록일자</th>
            <th>제목</th>
            <th>아이디</th>
            <th>연락처</th>
            <th>이메일</th>
            <th>답변여부</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${csList}" var="cs">
            <tr>
                <td>${cs.regdate}</td>
                <td>${cs.cs_title}</td>
                <td>${cs.id}</td>
                <td>${cs.cs_phone}</td>
                <td>${cs.cs_email}</td>
                <td>${cs.cs_status}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation">
    <ul class="pagination justify-content-center">
        <li class="page-item">
        <a class="page-link" href="./list.mg?page=1" aria-label="Previous">
            <span aria-hidden="true">&laquo;&laquo;</span>
        </a>
        </li>
        <!-- choose사용해서 해보기 -->
        <c:choose>
            <c:when test="${pager.pre}">
        <li class="page-item disabled">
            </c:when>
            <c:otherwise>
        <li class="page-item">
            </c:otherwise>
        </c:choose>
        <a class="page-link" href="./list.mg?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
            <span aria-hidden="true">이전</span>
        </a>
        </li>
        <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
        <li class="page-item"><a class="page-link" href="#">${i}</a></li>
        </c:forEach>
        <!-- 삼항연산자 사용해서 해보기 -->
        <li class="${pager.next? 'page-item disabled':'page-item'}">
        <a class="page-link" href="./list.mg?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
            <span aria-hidden="true">다음</span>
        </a>
        </li>
        <li class="page-item">
        <a class="page-link" href="./list.mg?page=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
            <span aria-hidden="true">&raquo;&raquo;</span>
        </a>
        </li>
    </ul>
    </nav>