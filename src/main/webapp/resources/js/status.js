const bar = document.querySelectorAll("#bar");
const detail = document.querySelectorAll("#detail");
const listenbtn = document.querySelectorAll("#listenbtn");
const listen = document.querySelectorAll("#listen");
const cancel = document.querySelectorAll("#cancel");
const cancelbtn = document.querySelectorAll("cancelbtn");




bar.forEach(function(bar){
    let status = bar.getAttributeNode("aria-valuenow").value;
    let style = document.createAttribute("style");
    style.value = "width :"+status+"%"
    bar.setAttributeNode(style);
    
})

detail.forEach(function(detail){
    detail.addEventListener("click",function(){
        
        let ln = detail.getAttributeNode("data-l-num").value;

        window.location.href="../lecture/detail?l_num="+ln;
    })
})
    
listen.forEach(function(listenbtn){
        
        listenbtn.addEventListener("click",function(event){
            event.stopPropagation();
    
            let check = window.confirm("강의 들으러 가시겠습니까?");
            
            if(check) {
                let target =  event.target;
                let ln = target.getAttributeNode("data-ln-num").value;

                //console.log(ln);
                window.location.href="../lecture/listen?l_num="+ln;
            }
    
        })
})

cancel.forEach(function(cancelbtn){
    cancelbtn.addEventListener("click",function(event){
        event.stopPropagation();

        let check = window.confirm("강의 취소하시겠습니까?");
        //환불 페이지로 -> 환불 완료되면 강의 수강 + 상태 테이블 삭제
    })
})




