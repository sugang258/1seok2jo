<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${size2 == 0}">
            <div class="text-center">
              <div id="null">아직 작성한 수강평이 없습니다.</div>
              <div id="null2">수강평을 작성해 보세요!</div>
              <input type="button" class="lecture_list" id="lecture_list" value="내 학습 가기"  style="background-color: #66ba39; color: white; border:none;">
            </div>
          </c:if>
<table class="table">
    <tbody class="table-group-divider">
        <c:forEach items="${lecture}" var="lecture" varStatus="lecNm">
            <tr class="lec" id="lec" data-fb-num="${lecture.l_num}">
               <td style="width: 250px;">
                    <img class="img-fluid rounded mb-4 mb-lg-0" src="http://20.249.88.100/resources/lecture/${lecture.lectureFileDTO[0].f_name}" alt="..." style="height: 150px;">
                </td>
                <td>
                    <div style="margin-top: 30px; font-weight: bold;">
                    ${lecture.l_name}
                    </div>
                    ${lecture.id} / ${lecture.c_name} / ${lecture.l_price}원
                </td>                
                    
                    <td>
                        <div style="margin-top: 50px; font-weight: bold;">
                            ${list[lecNm.index].contents}
                        </div>
                        ${list[lecNm.index].reg_date}
                    </td>
                    <td>
                        <div style="margin-top:60px;">
                        ${list[lecNm.index].score}점
                        </div>
                    </td>
                    
            </tr>
        </c:forEach>
    </tbody>
</table>