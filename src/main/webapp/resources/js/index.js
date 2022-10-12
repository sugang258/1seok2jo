const lecture = document.querySelectorAll(".lecture");

lecture.forEach(function(lecture){
    lecture.addEventListener("click",function(){
        let l_num = lecture.getAttributeNode("data-l-num").value;

        window.location.href="/lecture/detail?l_num="+l_num;
    })
})