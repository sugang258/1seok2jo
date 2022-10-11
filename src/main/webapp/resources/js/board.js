const free = document.querySelector("#free");
const study = document.querySelector("#study");
const lecture = document.querySelector("#lecture");
const list = document.querySelectorAll(".list");


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

function handleClick(event) {
    console.log(event.target);

    console.log(event.target.classList);

    if (event.target.classList[1] === "bold") {
      event.target.classList.remove("bold");

    } else {
      for (var i = 0; i < list.length; i++) {
        list[i].classList.remove("bold");

      }

      event.target.classList.add("bold");

    }
    
  }

 
function init() {
    for (var i = 0; i < list.length; i++) {
      list[i].addEventListener("click", handleClick);
    }
}

  init();