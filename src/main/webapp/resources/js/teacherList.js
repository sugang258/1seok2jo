const lecture = document.querySelectorAll("#lec");
const lecturebtn = document.querySelectorAll(".lec");
const board = document.querySelectorAll("#board");


lecture.forEach(function(lecturebtn){
    lecturebtn.addEventListener("click",function(){
       let ln = lecturebtn.getAttributeNode("data-ln-num").value;
        window.location.href="./detail?l_num="+ln;

        
    });
});

board.forEach(function(board){
    board.addEventListener("click",function(event){
        event.stopPropagation();
        let l_num = board.getAttributeNode("data-ll-num").value;
        console.log(l_num);
        window.location.href="../board/list?l_num="+l_num;
    })
})
