
//member_update.js - 프로필-사진수정, 프로필-비밀번호변경, 프로필-회원탈퇴

// form 선택
// ------------------- 프로필-회원탈퇴 -------------------
const deleteMemberForm = document.querySelector("#deleteMemberForm");
// ------------------- 프로필-비밀번호변경 -------------------
const updatePwForm = document.querySelector("#updatePwForm");

// input 선택
// ------------------- 프로필-회원탈퇴 -------------------
const ipPw = document.querySelector("#ipPw");
const ipPwCheck = document.querySelector("#ipPwCheck");
// ------------------- 프로필-비밀번호변경 -------------------
const now_pw = document.querySelector("#now_pw");
const ipnew_pw = document.querySelector("#ipnew_pw");
const pw_check = document.querySelector("#pw_check");
// ------------------- 프로필-사진삭제 -------------------
const ipId = document.querySelector("#ipId");

// button 선택
// 프로필-프로필사진 삭제 버튼
const defile = document.querySelector("#defile");
// 프로필-회원탈퇴 버튼
const deBtn = document.querySelector("#deBtn");
// 프로필-비밀번호변경 버튼
const btn = document.querySelector("#btn");

// ------------------- 프로필-사진삭제 -------------------
function deleteFile(){
    defile.addEventListener("click", function(){

        let id = ipId.value;
        //---------------- Ajax --------------------

        // 1. XMLHTTPRequest 생성
        let xhttp = new XMLHttpRequest();

        // 2. Method, URL 준비 
        xhttp.open("POST", "../member/deleteFile");
        
        // 3. Enctype
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        // 4. 요청 발생 (POST일 경우prammeter 추가)
        xhttp.send("id="+id);

        // 5. 응답 처리
        xhttp.onreadystatechange=function(){
            if(this.readyState==4 && this.status==200){

                let result = xhttp.responseText.trim();

                if(result=='1'){

                    alert("✔사진을 삭제했습니다.");
                    location.href="/member/profile";
                    return true;
                }else {
                    alert("❗❗사진 삭제를 실패했습니다.❗❗");
                }
            }
        }
        return false;
    });
}

// ------------------- 프로필-비밀번호변경 -------------------
function updatePwCheck(){

    btn.addEventListener("click", function(){

        let pw = now_pw.value;
        let new_pw = ipnew_pw.value;
        let pwCheck = pw_check.value;
        
        if(pw==""){

            alert("❗❗현재 비밀번호를 입력하세요.❗❗");
            now_pw.focus();

        }else if(new_pw==""){

            alert("❗❗새 비밀번호를 입력하세요.❗❗");
            ipnew_pw.focus();

        }else if(pw_check==""){

            alert("❗❗새 비밀번호 확인을 입력하세요.❗❗");
            pw_check.focus();

        }else if(pwCheck!==new_pw){

            alert("❌새 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            pw_check.value="";
            pw_check.focus();

        }else {

            //---------------- Ajax --------------------

            // 1. XMLHTTPRequest 생성
            let xhttp = new XMLHttpRequest();

            // 2. Method, URL 준비 
            xhttp.open("POST", "../member/pwCheck");
            
            // 3. Enctype
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            // 4. 요청 발생 (POST일 경우prammeter 추가)
            xhttp.send("pw="+pw+"&new_pw="+new_pw);

            // 5. 응답 처리
            xhttp.onreadystatechange=function(){
                if(this.readyState==4 && this.status==200){

                    let respPw = xhttp.responseText.trim();

                    if(respPw!==pw){

                        alert("❌현재 비밀번호가 일치하지 않습니다.");
                    }else {

                        let check = window.confirm("✔변경하시겠습니까?");
                        if(check){

                            //저장
                            updatePwForm.submit();

                        }

                    }
                }
            }
        }
        return false;
    });
}

// ------------------- 프로필-회원탈퇴 -------------------
function deleteMember(){
    deBtn.addEventListener("click", function(){
        console.log("클릭 이벤트 실행");

       let pw = ipPw.value;
       let pwCheck = ipPwCheck.value;

        if(pw==""){

            alert("❗❗비밀번호를 입력하세요.❗❗");
            ipPw.focus();

        }else if (pwCheck==""){

            alert("❗❗비밀번호 확인을 입력하세요.❗❗");
            ipPwCheck.focus();

        }else if (pw!==pwCheck){

            alert("❌비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            ipPwCheck.value="";
            ipPwCheck.focus();

        }else {
    
            //---------------- Ajax --------------------
    
            // 1. XMLHTTPRequest 생성
            let xhttp = new XMLHttpRequest();
    
            // 2. Method, URL 준비 
            xhttp.open("POST", "../member/pwCheck");
            
            // 3. Enctype
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    
            // 4. 요청 발생 (POST일 경우prammeter 추가)
            xhttp.send("pw"+pw);
    
            // 5. 응답 처리
            xhttp.onreadystatechange=function(){
                if(this.readyState==4 && this.status==200){
    
                    let respPw = xhttp.responseText.trim();

                    if(respPw!==pw){
    
                        alert("❌비밀번호가 일치하지 않습니다.");
                    }else {
    
                        let check = window.confirm("✔탈퇴하시겠습니까?");
                        if(check){
    
                            //저장
                            deleteMemberForm.submit();
    
                        }
    
                    }
                }
            }
        }
        return false;
    });
}