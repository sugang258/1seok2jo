const free = document.querySelector("#free");
const study = document.querySelector("#study");
const lecture = document.querySelector("#lecture");
const list = document.querySelectorAll(".list");
const board = document.querySelectorAll("#board");
const sb_board = document.querySelectorAll("#sb_board");
const result = document.querySelector("#result");


    result.addEventListener("click",function(event){
        let target = event.target;
        console.log(target);
        console.log("sb");
        if(event.target.parentNode.className == 'sb_board') {
            let target = event.target.parentNode.getAttributeNode("data-fb-num").value;
            location.href="/board/sb_detail?sb_num="+target;

        }else if(event.target.parentNode.className == 'lec'){
            let target = event.target.parentNode.getAttributeNode("data-fb-num").value;
            location.href="/board/list?l_num="+target;
            
        }else if(event.target.className == 'board_list') {
            window.location.href="/board/fb_list";
        }else if(event.target.className == 'study_list') {
            window.location.href="/board/sb_list"
        }else if(event.target.className == 'lecture_list') {
            window.location.href="/status/sign"
        }

    })


board.forEach(function(board){
    board.addEventListener("click",function(){
        console.log("free");

        let fb_num = board.getAttributeNode("data-fb-num").value;
        console.log(fb_num);

        window.location.href="/board/fb_detail?fb_num="+fb_num;
    })
})

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