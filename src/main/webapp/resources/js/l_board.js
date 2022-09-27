const lecture_add_btn = document.getElementById("lecture_add_btn");
const l_board_delete = document.getElementsByClassName("l_board_delete");

lecture_add.addEventListener("click", function(event){
    if(event.target.classList[0]=="lecture_add"){
        const l_num = document.getElementById("l_num");
        const l_board_id = document.getElementById("l_board_id");
        const ratingNodeList = document.getElementsByName("rating");
        const contents = document.getElementById("contents");               

        let num = l_num.value; //나중에 파라미터 값을 받기
        let id = l_board_id.value;    
        let score;
        ratingNodeList.forEach((node) => {
            if(node.checked){
                score = node.value;
            }
        })
        let l_contents = contents.value;
        const xhttp = new XMLHttpRequest();
        xhttp.open("POST","/board/l_boardAdd");
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("l_num="+num+"&id="+id+"&score="+score+"&contents="+l_contents);
        xhttp.onreadystatechange=function(){
            if(this.readyState == 4 && this.status == 200){
                let result = xhttp.responseText;
                console.log(result);
                document.querySelector("#close").click();
                window.location.reload();
            }
        }
    }
});

for(l of l_board_delete){
    l.addEventListener("click", function(){
        let num = document.getElementById("lecture_boardNum").value;
        const xhttp = new XMLHttpRequest();
        xhttp.open("POST", "/board/l_boardDelete");
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("num="+num);
        xhttp.onreadystatechange=function(){
            if(this.readyState == 4 && this.status == 200){
                let result = xhttp.responseText.trim();
                if(result == 1) {
                    window.location.reload();
                }else{
                    alert("삭제실패");
                }
            }
        }
    });
}


/**정렬기능 */
let array = document.getElementsByClassName("array");

for(ar of array){
    ar.addEventListener("click", function(event){
        if(event.target.classList[0]="array"){
            const l_num = document.getElementById("l_num").value;
            // let l_array = event.target.getAttribute("data-l_board-value")
            let l_array = event.target.value;
            console.log(l_array)
            const xhttp = new XMLHttpRequest();
            xhttp.open("GET", "/board/lectureboard_index?array="+l_array+"&l_num="+l_num);
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send();
            xhttp.onreadystatechange=function(){
                xhttp.responseText.trim();
            }
        }
    }
)}





