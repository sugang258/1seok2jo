const signs = document.querySelector("#signs");
const update = document.querySelector("#update");

signs.addEventListener("click",function(){
    let check = window.confirm("수강신청 하시겠습니까?");
    let l_num =  signs.getAttributeNode("data-lnum-num").value;
    if(check) {
        window.location.href="../pay/order?l_num="+l_num;
    }else{
        alert("수강신청 취소");
    }
})

update.addEventListener("click",function(){
    let check = window.confirm("수정하시겠습니까?");
    let l_num = update.getAttributeNode("data-update-num").value;

    if(check){
        window.location.href="../lecture/update?l_num="+l_num;
    }else{
        alert("수정하기 취소");
    }
})

