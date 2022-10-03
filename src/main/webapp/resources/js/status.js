const bar = document.querySelectorAll("#bar");
const detail = document.querySelectorAll("#detail");
const listenbtn = document.querySelectorAll("#listenbtn");
const listen = document.querySelectorAll("#listen");
const cancel = document.querySelectorAll("#cancel");
const cancelbtn = document.querySelectorAll("cancelbtn");
const lecture_list = document.querySelector("#lecture_list");




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

lecture_list.addEventListener("click",function(){
    window.location.href="../lecture/list";
})



