const lecture = document.querySelectorAll("#lec");
const cart = document.querySelectorAll(".cart");
const lecturebtn = document.querySelectorAll(".lec");
const cate = document.querySelectorAll(".cate");
const cate1 = document.querySelectorAll("#cate1");

lecture.forEach(function(lecturebtn){
    lecturebtn.addEventListener("click",function(){
       let ln = lecturebtn.getAttributeNode("data-ln-num").value;
        window.location.href="./detail?l_num="+ln;

        
    });
});


cart.forEach(function(cartbtn) {
    cartbtn.addEventListener("click",function(event){
        event.stopPropagation();
        let check = window.confirm("장바구니에 담으시겠습니까?")
       
        if(check){
       let target =  event.target;
       let l_num =  target.parentNode.parentNode.parentNode.childNodes[7].childNodes[1].childNodes[19].value;
      // let c_num = target.parentNode.parentNode.parentNode.childNodes[7].childNodes[1].childNodes[21].value;
       
        console.log(l_num);
        //console.log(c_num);
        
        // let l_num = lecture1.value;
         let id = 'gang';
        // let c_num = cate1.value;

        // console.log(id);
        // console.log(l_num);
        // console.log(c_num);

        const xhttp = new XMLHttpRequest() ;

        xhttp.open("POST","../cart/setCartAdd");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("id=" + id + "&l_num=" + l_num);

        xhttp.onreadystatechange = function() {
            if(this.readyState == 4 && this.status == 200) {
                let result = xhttp.responseText.trim();
                console.log(result);
                result = JSON.parse(result);
                if (result == 1) {
                    alert("장바구니 담기 성공");
                    let check1 = window.confirm("장바구니로 이동하시겠습니까?");
                    if(check1) {
                        window.location.href="../member/cart";
                    }else{

                        window.location.href = "./list";
                    }
                   

                }else {
                    alert("장바구니 담기 실패");
                    
                }
            }
        }
    }else{
        alert("장바구니 담기 취소");
    }

     })
});


