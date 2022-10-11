const free = document.querySelector("#free");
const study = document.querySelector("#study");
const lecture = document.querySelector("#lecture");


free.addEventListener("click",function(){
    window.location.href="/member/board";
})

study.addEventListener("click",function(){
    console.log("학습 게시판");
    let ll = "ll";
    const xhttp = new XMLHttpRequest() ;

    xhttp.open("POST","../board/sb_list");

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send("ll="+ll);

    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            let result = xhttp.responseText.trim();
            console.log(result);
            const r=document.getElementById("result");
            r.innerHTML = result;
            
        }
    }
})

lecture.addEventListener("click",function(){
    alert("수강평");

    let ll = "ll";
    const xhttp = new XMLHttpRequest() ;

    xhttp.open("POST","../board/lecture_list");

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send("ll="+ll);

    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            let result = xhttp.responseText.trim();
            console.log(result);
            const r=document.getElementById("result");
            r.innerHTML = result;
            
        }
    }
})