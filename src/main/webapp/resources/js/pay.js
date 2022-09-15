var IMP = window.IMP; // 생략 가능
IMP.init("imp18741385"); // 예: imp00000000

let btnimport = document.getElementById("btnimport");

btnimport.addEventListener("click", requestPay());

function requestPay() {
    IMP.request_pay({
        pg : 'kcp',
        pay_method : 'card',
        merchant_uid: "570sdfsfe833-33sdfasde", 
        name : '당근 10kg',
        amount : 1004,
        buyer_email : 'Iamport@chai.finance',
        buyer_name : '아임포트 기술지원팀',
        buyer_tel : '010-1234-5678',
        buyer_addr : '서울특별시 강남구 삼성동',
        buyer_postcode : '123-456'
    }, function (rsp) { // callback
        if (rsp.success) {
            console.log(rsp);
        } else {
            console.log(rsp);
        }
    });
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
