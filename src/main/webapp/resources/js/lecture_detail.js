const signs = document.querySelector("#signs");
const update = document.querySelector("#update");
const de = document.querySelector("#de");
const board = document.querySelector("#board");
const content = document.querySelector("#content");

signs.addEventListener("click",function(){
    let check = window.confirm("수강신청 하시겠습니까?");
    let l_num =  content.getAttributeNode("data-ll-num").value;
    if(check) {
        window.location.href="../pay/order?l_num="+l_num;
    }else{
        alert("수강신청 취소");
    }
})


//수정하기, 삭제하기 기본 값 display:none;
//l_num이 있고 로그인한 id 가 강의의 id 와 같으면 result = 1
//1이면 display:보이게

function setTeacherCheck(){
    let l_num = content.getAttributeNode("data-ll-num").value;
    
    const xhttp = new XMLHttpRequest();

        xhttp.open("POST","../lecture/setTeacherCheck");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        
        xhttp.send("l_num="+l_num);

        xhttp.onreadystatechange = function() {
            if(this.readyState == 4 && this.status == 200) {
                let result = xhttp.responseText.trim();
                console.log(result);
                
                result = JSON.parse(result);
                if(result == 1) {
                    
                    console.log("본인 강의 되어있음");
                    signs.setAttribute("style","display:none;");
                    
                }else {
                    update.setAttribute("style","display : none;");
                    de.setAttribute("style","display : none;");
                    console.log("본인 강의 아님");
                }
            }
        }
    }
    const listen = document.querySelector("#listen");
    
    listen.addEventListener("click",function(){
        let l_num = content.getAttributeNode("data-ll-num").value;
        window.location.href="../lecture/listen?l_num="+l_num;
        
    })
    
    board.addEventListener("click",function(){
        let l_num = board.getAttributeNode("data-lnum-num").value;
    
        window.location.href="../board/list?l_num="+l_num;
    })

update.addEventListener("click",function(){
    let check = window.confirm("수정하시겠습니까?");
    let l_num = content.getAttributeNode("data-ll-num").value;

    if(check){
        window.location.href="../lecture/update?l_num="+l_num;
    }else{
        alert("수정하기 취소");
    }
})

de.addEventListener("click",function(){
    let check = window.confirm("삭제하시겠습니까?");
    let l_num = content.getAttributeNode("data-ll-num").value;

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

//수강신청 테이블에 l_num과 id 가 있으면 버튼을 보이게
//없으면 버튼 display:none; (기본값)

function setLectureSign(){

    let l_num = content.getAttributeNode("data-ll-num").value;
    console.log(l_num);
    const xhttp = new XMLHttpRequest();

        xhttp.open("POST","../lectureAdd/SignCheck");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        
        xhttp.send("l_num="+l_num);

        xhttp.onreadystatechange = function() {
            if(this.readyState == 4 && this.status == 200) {
                let result = xhttp.responseText.trim();
                console.log(result);
                
                result = JSON.parse(result);
                if(result == 1) {
                    
                    console.log("수강신청 되어있음");
                    signs.setAttribute("style","display : none;");
                    
                }else {
                    listen.setAttribute("style","display : none;");
                    console.log("수강신청 안되어있음");
                }
            }
        }

    }




