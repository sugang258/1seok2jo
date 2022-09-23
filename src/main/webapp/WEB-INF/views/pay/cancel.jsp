<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- jQuery CDN --->
    <script  src="https://code.jquery.com/jquery-3.3.1.min.js"  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="  crossorigin="anonymous"></script>
</head>
<body>
    <label for="p_uid">주문번호</label>
    <input type="text" id="p_uid" value="${payment.p_uid}">
    <br>
    
    <label for="reason">환불사유</label>
    <input type="text" id="reason">
    <input type="text" id="p_remains" value="${payment.p_remains}">
    <button onclick="cancelPay()">환불하기</button>

<script src="/resources/js/cancel.js"></script>
</body>
</html>