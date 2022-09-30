let btnimport = document.getElementById("btnimport");

//결제창이 열리면 주문번호를 생성한다.
const url = new URL(window.location.href)
const urlparam = url.searchParams;
let l_num = urlparam.get("l_num")

let now = new Date();
let uid = "1seok2jo-"+now.getTime();

let l_name = document.querySelectorAll("#l_name");
let l_price = document.querySelectorAll("#l_price");
let total = document.getElementById("total");
let num = document.querySelectorAll("#l_num");


let usePoint = document.getElementById("usePoint");
let point = document.getElementById("point");
let pointVal = "0";
usePoint.innerText = pointVal;

//총 상품 금액 계산
let tt = 0;
let rtt = 0;
for(let i=0; i<l_price.length; i++){
    let price = Number.parseInt(l_price[i].innerHTML);
    tt += price;
}
rtt=tt;
total.innerText=tt+"원";
realtotal.innerText=rtt+"원";

//포인트 금액 입력하고 블러하면 위에 뜨게 그리고 총액 계산
point.addEventListener("blur", function(){
    pointVal = point.value;
    usePoint.innerText = pointVal;
    rtt=(tt-pointVal)
    realtotal.innerText=rtt+"원";
})

// 결제하기 버튼을 클릭하면 하단 실행
btnimport.addEventListener("click", function(){
    requestPay()
})

function requestPay() {
    let name = document.getElementById("name")
    let email = document.getElementById("email")
    let phone = document.getElementById("phone")

    var IMP = window.IMP; // 초기화는 한번만
    IMP.init("imp18741385"); // 아임포트 회원가입하면 부여되는 내 식별코드 입력

    IMP.request_pay(
        //파라미터값 상세
        //https://docs.iamport.kr/sdk/javascript-sdk#request_pay
        {
        pg : 'kcp',
        pay_method : 'card',//필수, 결제수단
        merchant_uid: uid, //필수, 주문번호 내가 생성함. 중복불가!!!
        name : l_name[0].innerHTML+" 등",
        amount : rtt, //필수, 결제금액
        buyer_email : email.value, //
        buyer_name : name.value, //
        buyer_tel : phone.value, //필수, 가능한한..
    }, function (rsp) { // callback
        console.log("callback펑션 실행")
        if (rsp.success) {
            //ajax로 결제성공 페이지 요청
            const xhttp = new XMLHttpRequest();
            //rsp에 금액, 포인트 추가
            rsp.point=pointVal
            rsp.amount=tt
            rsp.l_num = l_num;

            const res = JSON.stringify(rsp)

            xhttp.open("Post","./success");
            xhttp.setRequestHeader("Content-type", "application/json");
            
            xhttp.send(res);

            xhttp.addEventListener("readystatechange", function(){

                if(this.readyState==4 && this.status==200){
                    if(xhttp.response==1){
                        let l_num = num[0].getAttributeNode("data-l-num").value;
                        let name = document.getElementById("name");
                        console.log(name.value);
                        console.log(l_num);
                   
                        const xhttp = new XMLHttpRequest();
                   
                        xhttp.open("POST","../lectureAdd/setLectureAdd");
                   
                        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                   
                        
                        xhttp.send("l_num="+l_num+"&id="+name.value);
                   
                        xhttp.onreadystatechange = function() {
                            if(this.readyState == 4 && this.status == 200) {
                                let result = xhttp.responseText.trim();
                                console.log(result);
                                
                                result = JSON.parse(result);
                                if(result == 1) {
                                    alert("수강 신청 완료");
                                                                        
                                }else {
                                    alert("수강 신청 실패");
                                }
                            }
                        }
                        
                        location.href="./complete?p_uid="+uid;
                    }
                }
            })
        } else {
            alert("결제실패\n"+rsp.error_msg);
            console.log(rsp);
        }
    })
}



//툴팁
const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]')
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl))

// const test = document.querySelector("#test");

// test.addEventListener("click",function(){
//      let l_num = num[0].getAttributeNode("data-l-num").value;
//      let name = document.getElementById("name");
//      console.log(name.value);
//       console.log(l_num);

//      const xhttp = new XMLHttpRequest();

//      xhttp.open("POST","../lectureAdd/setLectureAdd");

//      xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

     
//      xhttp.send("l_num="+l_num+"&id="+name.value);

//      xhttp.onreadystatechange = function() {
//          if(this.readyState == 4 && this.status == 200) {
//              let result = xhttp.responseText.trim();
//              console.log(result);
             
//              result = JSON.parse(result);
//              if(result == 1) {
//                  alert("수강 신청 완료");
                                                     
//              }else {
//                  alert("수강 신청 실패");
//              }
//          }
//      }
// })