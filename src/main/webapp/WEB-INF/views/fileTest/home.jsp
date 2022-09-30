<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>

</head>
<body>
<h1>
	Hello world!  
</h1>


    <div class="modal">
    	<div class="mdimg">
	      <img src="/resources/images/1.png">
    	</div>
    </div>
    <button class="btn-open-popup">Modal 띄우기</button>
    <style>
          .modal {
          position: absolute;
		  top:0;
		  left:0;

          width: 100%;
          height: 100%;
         
			text-align: center;

          display: none;

          background-color: rgba(0, 0, 0, 0.4);

        }
        .mdimg{
          margin-top:30px;
          top:50%;
          left:50%;
          
          display: inline-block;
        }
    </style>
    <script>
    
    
      const modal = document.querySelector('.modal');
      const btnOpenPopup = document.querySelector('.btn-open-popup');

      btnOpenPopup.addEventListener('click', () => {
        modal.style.display = 'block';
        body.style.overflow = 'hidden';
      });
      
    </script>


<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
