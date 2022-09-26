const b_next = document.querySelector("#b_next");
const b_pre = document.querySelector("#b_pre");
const LectureVideo = document.querySelector("#LectureVideo");
const num = document.querySelector(".num");

b_next.addEventListener("click",function(){
    let count = document.querySelector(".count").getAttributeNode("data-count-num").value; 
    console.log(count);
    let v_seq = LectureVideo.getAttributeNode("data-seq-num").value;
    let l_num = num.getAttributeNode("data-l-num").value;
        console.log(l_num);
        console.log(v_seq);
    
        const xhttp = new XMLHttpRequest();

        xhttp.open("POST","./getLectureNext");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        
        xhttp.send("l_num="+l_num+"&v_seq="+v_seq);

        xhttp.onreadystatechange = function() {
            if(this.readyState == 4 && this.status == 200) {
                let result = xhttp.responseText.trim();
                console.log(result);
                
                result = JSON.parse(result);
                console.log(result[0].v_url);
                console.log(result[0].v_seq);

                LectureVideo.innerHTML = result[0].v_url;
                LectureVideo.getAttributeNode("data-seq-num").value = result[0].v_seq;

            }
        }
})

b_pre.addEventListener("click",function(){
    let count = document.querySelector(".count").getAttributeNode("data-count-num").value; 
    console.log(count);
    let v_seq = LectureVideo.getAttributeNode("data-seq-num").value;
    let l_num = num.getAttributeNode("data-l-num").value;
        console.log(l_num);
        console.log(v_seq);
    
        const xhttp = new XMLHttpRequest();

        xhttp.open("POST","./getLecturePre");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        
        xhttp.send("l_num="+l_num+"&v_seq="+v_seq);

        xhttp.onreadystatechange = function() {
            if(this.readyState == 4 && this.status == 200) {
                let result = xhttp.responseText.trim();
                console.log(result);
                
                result = JSON.parse(result);
                console.log(result[0].v_url);
                console.log(result[0].v_seq);

                LectureVideo.innerHTML = result[0].v_url;
                LectureVideo.getAttributeNode("data-seq-num").value = result[0].v_seq;

            }
        }
})

