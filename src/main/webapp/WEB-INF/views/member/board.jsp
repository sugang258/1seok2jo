<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="/resources/css/index.css" />
<link rel="stylesheet" href="/resources/css/member/board.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
  href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap"
  rel="stylesheet"
/>
<link rel="shortcut icon" href="/resources/images/favicon.ico">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 게시판</title>
</head>
<c:import url="../template/header.jsp"></c:import>
<body>
    <main class="container mt-2">
        <div class="py-3 text-center">
            <!--<img class="ml-1 mb-2 " src="/resources/images/15.png" alt="" width="100" height="70" style="display: inline;">-->
            <h2 style="display: inline;">📋내 게시판</h2>
        </div>
        <div>
            <button class="bold" id="free">자유게시판</button>
            <button id="study">학습게시판</button>
            <button id="lecture">내가 작성한 수강평</button>
        </div>
        <div id="result">
            <table class="table">
                <tbody class="table-group-divider">
                    <c:forEach items="${f_board}" var="fb">
                        <!--<div class="row gx-2 gx-lg-2 align-items-center my-3 cart" id="cart" data-l-num ="${lecturedto.l_num}">-->
                            <tr class ="board"id="board" data-l-num ="${fb.fb_num}">
                                
                                <td>
                                    <div style="margin-top: 30px; font-weight: bold;">
                                        ${fb.title}
                                    </div>
                                    ${fb.reg_date} / ${fb.hit} / ${fb.category}/${fb.like_count}
                                </td>
                                
                            </tr>
                        </div>
                        
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
    
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script src="/resources/js/board.js"></script>
</body>
</html>