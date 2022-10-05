const empty = document.querySelector(".empty");
const add = document.querySelector(".add");
const service = document.querySelector(".service");
const cart = document.querySelector("#cart");

function setTeacherLecture() {

    const xhttp = new XMLHttpRequest();
        let ll = 1;
        xhttp.open("POST","../lecture/setTeacherLecture");

        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("ll="+ll);
        xhttp.onreadystatechange = function() {
            if(this.readyState == 4 && this.status == 200) {
                let result = xhttp.responseText.trim();
                console.log(result);
                
                result = JSON.parse(result);
                if(result == 1) {
                    
                    console.log("강사임");
                    empty.setAttribute("style","display:none;");
                    
                }else {
                    add.setAttribute("style","display : none;");
                    service.setAttribute("style","display : none;");
                    console.log("강사 아님");
                }
            }
        }
}

function setLoginCheck() {
    const xhttp = new XMLHttpRequest();
    let ll = 1;
    xhttp.open("POST","../lecture/setLoginCheck");

    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    xhttp.send("ll="+ll);
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            let result = xhttp.responseText.trim();
            console.log(result);
            
            result = JSON.parse(result);
            if(result == 1) {
                
                console.log("로그인 완료");
                
            }else {
                cart.setAttribute("style","display : none;");
                console.log("로그인 안함");
            }
        }
    }

}

