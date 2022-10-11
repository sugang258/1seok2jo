//카드번호 보여주기
let pcnumView = document.getElementById("pcnumView");

let pcnum = pcnumView.getAttribute("data-pcnum");

pcnumView.innerText=pcnum.substring(0,6)+'******'+pcnum.substring(12,16)



//최종환불금액 계산하기
let cal_pramount = document.querySelectorAll(".cal_pramount"); 
let tot_pramount = 0; 
let cancelMessage = document.getElementById("cancelMessage");

for(let i=0; i<cal_pramount.length; i++){
    console.log(cal_pramount);
}
