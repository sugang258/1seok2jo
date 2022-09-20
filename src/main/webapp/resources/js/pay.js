let btnimport = document.getElementById("btnimport");

//결제창이 열리면 주문번호를 생성한다.
let now = new Date();
let uid = "1seok2jo-"+now.getTime();




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
        merchant_uid: uid, //필수, 주문번호 내가 생성함. 중복불가!!!
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
            const res = JSON.stringify(rsp)

            xhttp.open("Post","./success", true);
            xhttp.setRequestHeader("Content-type", "application/json");
            xhttp.send(res);
            console.log(res);
            
        } else {
            alert("결제실패\n"+rsp.error_msg);
            console.log(rsp);
        }
    })
}



//툴팁
const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))