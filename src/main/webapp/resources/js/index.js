const lecture = document.querySelectorAll(".lecture");

lecture.forEach(function(lecture){
    lecture.addEventListener("click",function(){
        alert("클릭");
    })
})