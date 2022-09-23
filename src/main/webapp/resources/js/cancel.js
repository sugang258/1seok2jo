function cancelPay() {
    /* 액세스 토큰(access token) 발급 */
     // 인증 토큰 발급 받기
  const xhttp = new XMLHttpRequest();
  let token = 0;

  xhttp.open("Post","./getTk");
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
  xhttp.send();
  xhttp.addEventListener("readystatechange", function(){
    if(this.readyState==4 && this.status==200){
      token = xhttp.responseText.trim();
    }
  })
  
  //아임포트 api로 결제 환불 요청
  let p_uid = document.getElementById("p_uid");
  let p_remains = document.getElementById("p_remains");

  jQuery.ajax({
    "url": "https://api.iamport.kr/payments/cancel", 
    "type": "POST",
    "contentType": "application/json",
    "Authorization": token,
    "Access-Control-Allow-Origin":"origin",
    "data": JSON.stringify({
      reason,
      imp_uid:"imp_506702148369", // 예: ORD20180131-0000011
      "amount": 50000, // 환불금액
      // "reason": "테스트 결제 환불" // 환불사유
      // "refund_holder": "홍길동", // [가상계좌 환불시 필수입력] 환불 수령계좌 예금주
      // "refund_bank": "88" // [가상계좌 환불시 필수입력] 환불 수령계좌 은행코드(예: KG이니시스의 경우 신한은행은 88번)
      // "refund_account": "56211105948400" // [가상계좌 환불시 필수입력] 환불 수령계좌 번호
    }),
    "dataType": "json"
  });


  //   let data = {
  //     imp_uid: "imp_875574619822", // 예: ORD20180131-0000011
  //     amount: 160000, // 환불금액
  //     checksum :160000
  //     // "reason": "테스트 결제 환불" // 환불사유
  //     // "refund_holder": "홍길동", // [가상계좌 환불시 필수입력] 환불 수령계좌 예금주
  //     // "refund_bank": "88" // [가상계좌 환불시 필수입력] 환불 수령계좌 은행코드(예: KG이니시스의 경우 신한은행은 88번)
  //     // "refund_account": "56211105948400" // [가상계좌 환불시 필수입력] 환불 수령계좌 번호
  //   }

  // const xhttp2 = new XMLHttpRequest();
  // xhttp2.open("Post", "https://api.iamport.kr/payments/cancel");
  // xhttp2.setRequestHeader("Content-Type", "application/json")
  // xhttp2.setRequestHeader("Authorization", token);
  // xhttp2.send(data);
  // xhttp2.addEventListener("readystatechange",function(){
  //   console.log(this.readyState+"|"+this.status)
  //   if(this.readyState==4 && this.status==200){
  //     console.log( xhttp2.response)
  //   }
  // })



}