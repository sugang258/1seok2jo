let btnimport = document.getElementById("btnimport");



// 결제하기 버튼을 클릭하면 하단 실행
btnimport.addEventListener("click", function(){
    requestPay()
})

function requestPay() {
    var IMP = window.IMP; // 초기화는 한번만
    IMP.init("imp18741385"); // 아임포트 회원가입하면 부여되는 내 식별코드 입력

    IMP.request_pay(
        //파라미터값 상세
        //https://docs.iamport.kr/sdk/javascript-sdk#request_pay
        {
        pg : 'kcp',
        pay_method : 'card',//필수, 결제수단
        merchant_uid: "1seok2jo-2022092204", //필수, 주문번호 내가 생성함. 중복불가!!!
        name : '당근 10kg',
        amount : 1004, //필수, 결제금액
        buyer_email : 'simyj12@naver.com', //
        buyer_name : '일석이조테스트', //
        buyer_tel : '010-1234-5678', //필수, 가능한한..
        buyer_addr : '꾸디일석이조',
        buyer_postcode : '123-456'
    }, function (rsp) { // callback
        console.log("callback펑션 실행")
        if (rsp.success) {
            //ajax로 결제성공 페이지 요청
            const xhttp = new XMLHttpRequest();
            xhttp.open("Post","./success", false);
            xhttp.setRequestHeader("Content-type", "application/json");
            xhttp.send(rsp);
            
        } else {
            console.log(rsp);
        }
    })
}
/*
function requestPay() {
    // IMP.request_pay(param, callback) 결제창 호출
    IMP.request_pay({ // param
        pay_method: "card",
        merchant_uid: "ORD20180131-0000011",
        name: "노르웨이 회전 의자",
        amount: 64900,
        buyer_email: "gildong@gmail.com",
        buyer_name: "홍길동",
        buyer_tel: "010-4242-4242",
        buyer_addr: "서울특별시 강남구 신사동",
        buyer_postcode: "01181"
    }, function (rsp) { // callback
        if (rsp.success) { // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
          // jQuery로 HTTP 요청
          jQuery.ajax({
              url: "/pay/order", // {서버의 결제 정보를 받는 endpoint} 예: https://www.myservice.com/payments/complete
              method: "POST",
              headers: { "Content-Type": "application/json" },
              data: {
                  imp_uid: rsp.imp_uid, // 결제 번호
                  merchant_uid: rsp.merchant_uid
              }
          }).done(function (data) {
            console.log(" 가맹점 서버 결제 API 성공시 로직")
          })
        } else {
          alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
        }
      });
  }
  */


//툴팁
const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))