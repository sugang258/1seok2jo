function cancelPay() {
  let cancleBtn = document.querySelectorAll("#cancleBtn");
  let pr_amount = document.getElementById("pr_amount")

  let o_num;
  let o_amount;
  let l_name;
  let l_num;
  let cancelPoint= document.getElementById("cancelPoint");
  let cancelOnum = document.getElementById("cancelOnum");
  let cancelLnum = document.getElementById("cancelLnum");
  let pr_point = document.getElementById("pr_point");
  let cancelMessage = document.getElementById("cancelMessage");

  /* 환불 버튼 클릭*/
  for(let i =0; i<cancleBtn.length; i++){
    cancleBtn[i].addEventListener("click", function(){
      //넘겨줄 파라미터 값
      o_num = cancleBtn[i].getAttribute("data-onum")
      o_amount = cancleBtn[i].getAttribute("data-amount")
      l_name = cancleBtn[i].getAttribute("data-lname")
      l_num = cancleBtn[i].getAttribute("data-lnum")

      //모달에 값을 띄워준다.
      let mLname = document.getElementById("mLname")
      let mOamount = document.getElementById("mOamount")
      mLname.innerText= l_name;
      mOamount.innerText = o_amount;
      cancelOnum.value=o_num;
      cancelLnum.value=l_num;
      
      //환불 가능 금액 (p_remains) 받아와서 강의금액과 비교 후 환불 금액 띄우기
      premains = pr_amount.getAttribute("data-premains");
      if(Number.parseInt(premains)< Number.parseInt(o_amount)){
        //남은 금액은 마일리지에 띄우고 계산
        pr_point.value = Number.parseInt(o_amount)-Number.parseInt(premains);
        cancelPoint.innerText=pr_point.value;
        pr_amount.value=Number.parseInt(o_amount)-pr_point.value
        //메세지 보여주기
        cancelMessage.innerText = "카드 환불은 "+premains+"원 까지 가능합니다"
      }
      
     
    })
  }

  //환불 마일리지 입력하면 환불금액 계산
  pr_point.addEventListener("change", function(){
    if(pr_point.value > Number.parseInt(o_amount)){
      cancelPoint.innerHTML=o_amount+"보다 작은 값을 입력해주세요";
    }else{
      cancelPoint.innerText=pr_point.value;
      pr_amount.value=Number.parseInt(o_amount)-pr_point.value
    }
  })

  let reqCancel = document.getElementById("reqCancel");
  let cancelForm = document.getElementById("cancelForm")
  reqCancel.addEventListener("click", function(){
    cancelForm.submit();
  })



}

