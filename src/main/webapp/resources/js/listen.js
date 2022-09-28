const b_next = document.querySelector("#b_next");
const b_pre = document.querySelector("#b_pre");
const LectureVideo = document.querySelector("#LectureVideo");
const num = document.querySelector(".num");
const video_list = document.querySelectorAll(".video_list");
const duration = document.querySelector(".ytp-time-duration");
const video = document.querySelector("#video");

setTimeout(function(){
    let status = video.getAttributeNode("data-sta-num").value;
    let s_num = video.getAttributeNode("data-sign-num").value;
    let v_num = video.getAttributeNode("data-v-num").value;
    let num = video.getAttributeNode("data-s-num").value;

    console.log(s_num);
     if(status == 0) {
        const xhttp = new XMLHttpRequest();

        xhttp.open("POST","../status/setStatusUpdate");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("num="+num);

        xhttp.onreadystatechange = function() {
            if(this.readyState == 4 && this.status == 200) {
                let result = xhttp.responseText.trim();
                console.log(result);
                
                result = JSON.parse(result);
                if(result == 1) {
                        
                    console.log(result);
                    alert("수강 완료");
                            
                        
                }else {
                    alert("수강 완료 실패");
                }
            }
        }
    }
},10000)

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
                console.log(result.v_url);
                console.log(result.v_seq);

                LectureVideo.innerHTML = result.v_url;
                LectureVideo.getAttributeNode("data-seq-num").value = result.v_seq;
                video.getAttributeNode("data-v-num").value = result.v_num;
                video.getAttributeNode("data-sta-num").value = result.statusDTO.v_status;
                video.getAttributeNode("data-s-num").value = result.statusDTO.num;

            }
        }
        setTimeout(function(){
            let status = video.getAttributeNode("data-sta-num").value;
            let s_num = video.getAttributeNode("data-sign-num").value;
            let v_num = video.getAttributeNode("data-v-num").value;
            let num = video.getAttributeNode("data-s-num").value;

            console.log(s_num);
             if(status == 0) {
                const xhttp = new XMLHttpRequest();

                xhttp.open("POST","../status/setStatusUpdate");

                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

                xhttp.send("num="+num);

                xhttp.onreadystatechange = function() {
                    if(this.readyState == 4 && this.status == 200) {
                        let result = xhttp.responseText.trim();
                        console.log(result);
                        
                        result = JSON.parse(result);
                        if(result == 1) {
                                
                            console.log(result);
                            alert("수강 완료");
                                    
                                
                        }else {
                            alert("수강 완료 실패");
                        }
                    }
                }
            }
        },10000)
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
                console.log(result.v_url);
                console.log(result.v_seq);

                LectureVideo.innerHTML = result.v_url;
                LectureVideo.getAttributeNode("data-seq-num").value = result.v_seq;
                video.getAttributeNode("data-v-num").value = result.v_num;
                video.getAttributeNode("data-sta-num").value = result.statusDTO.v_status;
                video.getAttributeNode("data-s-num").value = result.statusDTO.num;

            }
        }
        setTimeout(function(){
            let status = video.getAttributeNode("data-sta-num").value;
            let v_num = video.getAttributeNode("data-v-num").value;
            let num = video.getAttributeNode("data-s-num").value;

            if(status == 0) {
                const xhttp = new XMLHttpRequest();

                xhttp.open("POST","../status/setStatusUpdate");

                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

                xhttp.send("num="+num);

                xhttp.onreadystatechange = function() {
                    if(this.readyState == 4 && this.status == 200) {
                        let result = xhttp.responseText.trim();
                        console.log(result);
                        
                        result = JSON.parse(result);
                        if(result == 1) {
                                
                            console.log(result);
                            alert("수강 완료");
            
                        }else {
                            alert("수강 완료 실패");
                        }
                    }
                }
            }
        },10000)
})

video_list.forEach(function(video_list) {
    video_list.addEventListener("click",function(){
        let v_seq = video_list.getAttributeNode("data-video-num").value;
        let l_num = num.getAttributeNode("data-l-num").value;

        console.log(l_num);
        console.log(v_seq);

        const xhttp = new XMLHttpRequest();

        xhttp.open("POST","./getVideoList");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        
        xhttp.send("l_num="+l_num+"&v_seq="+v_seq);

        xhttp.onreadystatechange = function() {
            if(this.readyState == 4 && this.status == 200) {
                let result = xhttp.responseText.trim();
                console.log(result);
                
                result = JSON.parse(result);
                console.log(result.v_url);
                console.log(result.v_seq);

                LectureVideo.innerHTML = result.v_url;
                LectureVideo.getAttributeNode("data-seq-num").value = result.v_seq;
                video.getAttributeNode("data-v-num").value = result.v_num;
                video.getAttributeNode("data-sta-num").value = result.statusDTO.v_status;
                video.getAttributeNode("data-s-num").value = result.statusDTO.num;

            }
        }
        setTimeout(function(){
            let status = video.getAttributeNode("data-sta-num").value;
            let v_num = video.getAttributeNode("data-v-num").value;
            let num = video.getAttributeNode("data-s-num").value;
            if(status == 0) {
                const xhttp = new XMLHttpRequest();

                xhttp.open("POST","../status/setStatusUpdate");

                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

                xhttp.send("num="+num);

                xhttp.onreadystatechange = function() {
                    if(this.readyState == 4 && this.status == 200) {
                        let result = xhttp.responseText.trim();
                        console.log(result);
                        
                        result = JSON.parse(result);
                        if(result == 1) {
                                
                            console.log(result);
                            alert("수강 완료");
                                
                        }else {
                            alert("수강 완료 실패");
                        }
                    }
                }
            }
        },10000)
    })

})



// video.addEventListener("click",function(event){
//     let time = event.target;
//     console.log(time);
//     console.log("clock");

// })

// LectureVideo.addEventListener("click",function(event){
//     event.preventDefault();
//     let t = event.target;
//     let d = document.getElementById("player");
//     let c = document.querySelector(".ytp-time-duration");
//     console.log(c);
//     console.log(d);
//     console.log(this);

// })

