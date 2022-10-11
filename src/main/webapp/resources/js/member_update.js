
//member_update.js - 프로필-비밀번호변경, 프로필-회원탈퇴

// form 선택
const updatePwForm = document.querySelector("#updatePwForm");

// input 선택
const now_pw = document.querySelector("#now_pw");
let new_pw = document.querySelector("#new_pw");

// button 선택
const btn = document.querySelector("#btn");

function updatePwCheck(){

    btn.addEventListener("click", function(){

        let pw = now_pw.value;
        new_pw = new_pw.value;

        //---------------- Ajax --------------------
        // 1. XMLHTTPRequest 생성
        let xhttp = new XMLHttpRequest();

        // 2. Method, URL 준비 
        xhttp.open("POST", "../member/pwCheck");
        
        // 3. Enctype
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        // 4. 요청 발생 (POST일 경우prammeter 추가)
        xhttp.send("pw="+pw+"&new_pw"+new_pw);

        // 5. 응답 처리
        xhttp.onreadystatechange=function(){
            if(this.readyState==4 && this.status==200){

                let respPw = xhttp.responseText.trim();

                if(respPw!==pw){

                    alert("❌현재 비밀번호가 일치하지 않습니다.");
                }else {
                    let check = window.confirm("변경하시겠습니까?");
                    if(check){
                        //저장
                        updatePwForm.submit();
                    }
                }
            }
        }
    });

}