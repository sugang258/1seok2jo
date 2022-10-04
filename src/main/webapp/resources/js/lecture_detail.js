const signs = document.querySelector("#signs");
const update = document.querySelector("#update");
const de = document.querySelector("#de");
const board = document.querySelector("#board");

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

de.addEventListener("click",function(){
    let check = window.confirm("삭제하시겠습니까?");
    let l_num = de.getAttributeNode("data-delete-num").value;

    if(check) {
        const xhttp = new XMLHttpRequest();

        xhttp.open("POST","../lecture/setDelete");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        
        xhttp.send("l_num="+l_num);

        xhttp.onreadystatechange = function() {
            if(this.readyState == 4 && this.status == 200) {
                let result = xhttp.responseText.trim();
                console.log(result);
                
                result = JSON.parse(result);
                if(result == 1) {
                    alert("삭제 성공");
                    
                    window.location.href="../lecture/list";
                    
                }else {
                    alert("삭제 실패");
                }
            }
        }

    }else {
        alert("삭제 취소");
    }
})

const listen = document.querySelector("#listen");

listen.addEventListener("click",function(){
    let l_num = listen.getAttributeNode("data-listen-num").value;
    window.location.href="../lecture/listen?l_num="+l_num;
})

board.addEventListener("click",function(){
    let l_num = board.getAttributeNode("data-lnum-num").value;

    window.location.href="../board/list?l_num="+l_num;
})


