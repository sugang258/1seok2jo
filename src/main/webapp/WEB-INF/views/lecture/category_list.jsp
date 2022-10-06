<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container px-4 px-lg-5 mt-5" id="category_list">
    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4">
        <c:forEach items="${list}" var="vo">
            <div class="col mb-5 lec" id="lec" data-ln-num ="${vo.l_num}">
                <div class="card h-100" >
                    <!-- Lecture image-->
                    <img class="card-img-top" src="http://20.249.88.100/resources/lecture/${vo.lectureFileDTO[0].f_name}" alt="...">
                    <!-- Lecture details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Lecture name-->
                            <h5 class="fw-bolder">${vo.l_name}</h5>
                            <!-- Lecture price-->
                            <div>${vo.l_price}원</div>
                            <!--Student count-->
                            <div>현재 ${vo.l_count}명</div>
                            <!--Level-->
                            <div>난이도 : ${vo.level_name}</div>
                            <div>카테고리 : ${vo.c_name}</div>
                            <input type="label" value="${vo.l_num}" style="display: none;">
                            
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card_footer p-4 pt-0 border-top-0 bg-transparent cart">
                        <div class="text-center">
                            <input type="button" class="btn btn-outline-dark mt-auto" id="cartbtn" value="Add to cart">
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
    
