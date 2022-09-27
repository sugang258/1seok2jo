const lecture_add_btn = document.getElementById("lecture_add_btn");

lecture_add.addEventListener("click", function(event){
    if(event.target.classList[0]=="lecture_add"){
        const xhttp = new XMLHttpRequest();
        xhttp.open("POST","board/l_boardAdd");
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send();//강의넘버 아이디 점수(별점) 수강평


    }
});

