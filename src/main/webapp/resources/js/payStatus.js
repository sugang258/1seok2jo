//카드번호 보여주기
let pcnumView = document.getElementById("pcnumView");
let pcnum = pcnumView.getAttribute("data-pcnum");
pcnumView.innerText=pcnum.substring(0,6)+'******'+pcnum.substring(12,16)



//카드 환불금액 계산하기
let cal_pramount = document.querySelectorAll(".cal_pramount"); 
let tot_pramount = 0; 
let total_pramount = document.getElementById("total_pramount");

for(let i=0; i<cal_pramount.length; i++){
    tot_pramount = tot_pramount+Number.parseInt(cal_pramount[i].value)
    total_pramount.innerText = tot_pramount+" 원 ";
}

// 환불마일리지 계산하기
let cal_prpoint = document.querySelectorAll(".cal_prpoint"); 
let tot_prpoint = 0; 
let total_prpoint = document.getElementById("total_prpoint");

for(let i=0; i<cal_pramount.length; i++){
    tot_prpoint = tot_prpoint+Number.parseInt(cal_prpoint[i].value)
    total_prpoint.innerText = tot_prpoint+" 마일";
}

//금액
let sum_pointamount = document.getElementById("sum_pointamount")

sum_pointamount.innerText = tot_pramount+ tot_prpoint + " 원 ";

//취소 상품 상세 보여주기
let chk_orderprnum = document.querySelectorAll(".chk_orderprnum") //orderDTO에 있는 prnum
let chk_prnum = document.querySelectorAll(".chk_prnum"); //paymentDTO에 있는 prnum

for(let i=0; i<chk_orderprnum.length ; i++){
    let chkNum = chk_orderprnum[i].getAttribute("data-chk");
    for(let j=0; j<chk_prnum.length; j++){
        if(chkNum==chk_prnum[j].value){
            //pr_num이 동일하면 display:none해제하고 내용을 보여줌
            let st = document.createAttribute("style")
            chk_orderprnum[i].setAttributeNode(st)
            //환불일자 세팅
            chk_orderprnum[i].children[0].children[1].children[0].innerText = chk_prnum[j].getAttribute("data-regdate")+"일 환불"
            //환불금액 세팅
            chk_orderprnum[i].children[1].children[1].innerText = chk_prnum[j].getAttribute("data-pramount")
            //환불마일리지 세팅
            chk_orderprnum[i].children[2].children[1].innerText = chk_prnum[j].getAttribute("data-prpoint")+"마일"
        }    
    }
}