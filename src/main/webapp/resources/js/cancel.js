function cancelPay() {
  let cancleBtn = document.querySelectorAll("#cancleBtn");
    /* 취소요청 */
  
  for(let i =0; i<cancleBtn.length; i++){
    cancleBtn[i].addEventListener("click", function(){
      let o_num = cancleBtn[i].getAttribute("data-onum")
      window. open("/pay/cancel?o_num="+o_num, "_blank", "width=300, height=360");
    })
  }

  function requestCancle(){
  
  }
  
}