const lecture = document.querySelectorAll("#lec");
const cart = document.querySelectorAll(".cart");
const cartbtn = document.querySelectorAll("#cartbtn");
const lecturebtn = document.querySelectorAll(".lec");
const recommend = document.querySelector("#recommend");
const popular = document.querySelector("#popular");
const recent = document.querySelector("#recent");
const price = document.querySelector("#price");
const pager = document.querySelector("#pager");
const filter = document.querySelector(".filter");
const cate = document.querySelectorAll(".cate");
const result = document.querySelector("#result");


result.addEventListener("click",function(event){
   let even = event.target;
    console.log(even);
    console.log("sb");
   
    if(event.target.classList[3] == 'cc'){
        let target = event.target.parentNode.parentNode.parentNode.parentNode.getAttributeNode("data-ln-num").value;

        console.log(event.target);
        let check = window.confirm("장바구니에 담으시겠습니까?")

        if(check) {
            const xhttp = new XMLHttpRequest() ;

            xhttp.open("POST","../cart/setCartAdd");

            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            xhttp.send("l_num=" + target);

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
    }else if(event.target.parentNode.parentNode.parentNode.parentNode.classList[2] == 'lec') {
        let target = event.target.parentNode.parentNode.parentNode.parentNode.getAttributeNode("data-ln-num").value;
        location.href="/lecture/detail?l_num="+target;           
    }else if(event.target.className == 'card-img-top') {
        let imgget = event.target.parentNode.parentNode.getAttributeNode("data-ln-num").value;

        location.href="/lecture/detail?l_num="+imgget;    
    }

     })




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
       let l_num =  target.parentNode.parentNode.parentNode.parentNode.getAttributeNode("data-ln-num").value;
      // let c_num = target.parentNode.parentNode.parentNode.childNodes[7].childNodes[1].childNodes[21].value;
       
        console.log(l_num);
        //console.log(c_num);
        
        // let l_num = lecture1.value;
         //let id = 'gang';
        // let c_num = cate1.value;

        // console.log(id);
        // console.log(l_num);
        // console.log(c_num);

        const xhttp = new XMLHttpRequest() ;

        xhttp.open("POST","../cart/setCartAdd");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("l_num=" + l_num);

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
cate.forEach(function(cate){

    cate.addEventListener("click",function(event){
        let e = event.target;

        let c_num = e.getAttributeNode("data-c-num").value;
        console.log(c_num);
        
        const xhttp = new XMLHttpRequest() ;

        xhttp.open("POST","../lecture/list");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("c_num="+c_num);

        xhttp.onreadystatechange = function() {
            if(this.readyState == 4 && this.status == 200) {
                let result = xhttp.responseText.trim();
                console.log(result);
                const r=document.getElementById("result");
                r.innerHTML = result;
                
            }
        }
    })
})

function handleClick(event) {
    console.log(event.target);

    console.log(event.target.classList);

    if (event.target.classList[1] === "clicked") {
      event.target.classList.remove("clicked");

    } else {
      for (var i = 0; i < cate.length; i++) {
        cate[i].classList.remove("clicked");

      }

      event.target.classList.add("clicked");

    }
    
  }

 
function init() {
    for (var i = 0; i < cate.length; i++) {
      cate[i].addEventListener("click", handleClick);
    }
}

  init();

