
//member_update.js - 프로필-비밀번호변경, 프로필-회원탈퇴

// input 선택
const ipPw = document.querySelector("#ipPw");

// button 선택
const btn = document.querySelector("#btn");

// div 선택
const ipPwResult = document.querySelector("#ipPwResult");

function updatePwCheck(){

    btn.addEventListener("click", function(){

        let pw = ipPw.value;
        //---------------- Ajax --------------------
        // 1. XMLHTTPRequest 생성
        let xhttp = new XMLHttpRequest();

        // 2. Method, URL 준비 
        xhttp.open("POST", "../member/pwCheck");
        
        // 3. Enctype
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        // 4. 요청 발생 (POST일 경우prammeter 추가)
        xhttp.send("pw="+pw);

        // 5. 응답 처리
        xhttp.onreadystatechange=function(){
            if(this.readyState==4 && this.status==200){

                let respPw = xhttp.responseText.trim();

                if(respPw!==pw){

                    alert('❌현재 비밀번호가 일치하지 않습니다.');
                }else if(pw.length===0) {

                    alert('❗비밀번호를 입력해 주세요');
                }else{
                    
                    alert('✔사용 가능한 아이디입니다.');
                }
            }
        }
    });

}