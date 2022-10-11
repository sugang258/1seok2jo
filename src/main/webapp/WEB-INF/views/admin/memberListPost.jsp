<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table class="table table-striped table-hover">
    <colgroup>
        <col width="3%"  />
        <col width="12%"/>
        <col width="8%" />
        <col width="11%"/>
        <col width="12%"/>
        <col width="15%"  />
        <col width="18%"/>
        <col width="7%" />
        <col width="7%"/>
        <col width="7%"/>
    </colgroup>
    <thead>
        <tr>
            <th><input type="checkbox" id="all"></th>
            <th>아이디</th>
            <th>이름</th>
            <th>닉네임</th>
            <th>생년월일</th>
            <th>연락처</th>
            <th>이메일</th>
            <th>회원</th>
            <th>강사</th>
            <th>관리자</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${memberList}" var="mem">
            <tr data-id="${mem.id}">
                <td><input type="checkbox" class="chk"></td>
                <td>${mem.id}</td>
                <td>${mem.name}</td>
                <td>${mem.n_name}</td>
                <td>${mem.b_date}</td>
                <td>${mem.phone}</td>
                <td>${mem.email}</td>
                <td><a href='/member/profile?id=${mem.id}' target="_blank">${mem.roleDTOs[0].roleName}</a></td>
                <c:if test="${null eq mem.roleDTOs[1].roleName}"><td></td><td></td></c:if>
                <c:if test="${mem.roleDTOs[1].roleName eq '관리자'}"><td></td><td>관리자</td></c:if>
                <c:if test="${mem.roleDTOs[1].roleName eq '강사'}"><td><a href='/member/tcherProfile?id=${mem.id}' target="_blank">강사</a></td>
                    <c:if test="${mem.roleDTOs[2].roleName eq '관리자'}"><td>관리자</td></c:if>
                    <c:if test="${mem.roleDTOs[2].roleName eq null}"><td></td></c:if>
                </c:if>
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
