const del = document.querySelectorAll(".del");
const del1 = document.querySelectorAll("#del");
const cart = document.querySelectorAll("#cart");
const cartbtn = document.querySelectorAll(".cart");
const sign = document.querySelectorAll(".sign");
const sign1 = document.querySelectorAll("#sign");
const all = document.querySelector("#all");

all.addEventListener("click",function(){
    window.location.href="../pay/order";
})


del.forEach(function(del1){
    del1.addEventListener("click",function(event){
        let check = window.confirm("삭제하시겠습니까?");
        event.stopPropagation();

        if(check) {
        let d = event.target;
        let cart_num = del1.getAttributeNode("data-c-num").value;

        console.log(cart_num);

        const xhttp = new XMLHttpRequest();

        xhttp.open("POST","../cart/setCartDelete");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        
        xhttp.send("cart_num=" + cart_num);

        xhttp.onreadystatechange = function() {
            if(this.readyState == 4 && this.status == 200) {
                let result = xhttp.responseText.trim();
                console.log(result);
                
                result = JSON.parse(result);
                if(result == 1) {
                    alert("장바구니 삭제 성공");
                    
                    window.location.href="./cart";
                    
                }else {
                    alert("장바구니 담기 실패");
                }
            }
        }
    }else {
        alert("장바구니 삭제 취소");
    }
    })
    
});

cart.forEach(function(cartbtn){
    cartbtn.addEventListener("click",function(){
        let l_num = cartbtn.getAttributeNode("data-l-num").value;
        console.log("엘넘"+l_num);

        window.location.href="/lecture/detail?l_num="+l_num;

        // const xhttp = new XMLHttpRequest();

        // xhttp.open("GET","../lecture/detail");

        // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        
        // xhttp.send("l_num="+l_num);

        // xhttp.onreadystatechange = function() {
        //     if(this.readyState == 4 && this.status == 200) {
        //         let result = xhttp.responseText.trim();
        //         console.log(result);
                
        //         result = JSON.parse(result);
        //         if(result == 1) {
        //             alert("강의 페이지로 이동합니다.");
                    
        //             window.location.href="../lecture/detail?l_num="+l_num;
                    
        //         }else {
        //             alert("강의 페이지로 이동 실패");
        //         }
        //     }
        // }
        

    })

});

sign.forEach(function(sign1){
    sign1.addEventListener("click",function(event){
        event.stopPropagation();
        let l_num = event.target.parentNode.parentNode.parentNode.childNodes[3].getAttributeNode("data-l-num").value;
        
        console.log(l_num);
        let check = window.confirm("수강신청 하시겠습니까?");
        

         if(check){
            window.location.href="../pay/order?l_num="+l_num;
        }else{
            alert("수강신청 취소");
        }
    })
})





