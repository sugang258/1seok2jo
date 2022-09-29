function cancelPay() {
  let cancleBtn = document.querySelectorAll("#cancleBtn");
  
  /* 환불 버튼 클릭*/
  for(let i =0; i<cancleBtn.length; i++){
    cancleBtn[i].addEventListener("click", function(){
      let p_point = document.getElementById("p_point")
      //넘겨줄 파라미터 값
      let o_num = cancleBtn[i].getAttribute("data-onum")
      let o_amount = cancleBtn[i].getAttribute("data-amount")
      let l_name = cancleBtn[i].getAttribute("data-lname")
      let cancle_point=p_point//빼기 환불된 포인트sum
      //모달에 값을 띄워준다.
      let mLname = document.getElementById("mLname")
      let mOamount = document.getElementById("mOamount")
      mLname.innerText=
      // window. open("/pay/cancel?o_num="+o_num, "_blank", "width=300, height=360");
    })
  }

  function requestCancle(){
  
  }
  
}