
//member.js - 회원-회원가입, 회원-로그인 

// input 선택

// ---------------- 회원가입-아이디 중복 확인 ----------------
const aIdCheck = document.querySelector("#aIdCheck");
// ------------------- 회원가입-유효성 검사 -------------------
const ipId = document.getElementById("ipId");
const ipPw = document.getElementById("ipPw");
const ipPwCheck = document.getElementById("ipPwCheck");
const ipName = document.getElementById("ipName");
const ipNname = document.getElementById("ipNname");
const ipBdate = document.getElementById("ipBdate");
const ipGender = document.getElementById("ipGender");
const ipEmail = document.getElementById("ipEmail");
const ipPhone = document.getElementById("ipPhone");
// button 선택
// 회원-회원가입버튼
const btn = document.getElementById("btn");

//div 선택

// ------------------- 회원가입-유효성 검사 -------------------
const ipIdResult = document.getElementById("ipIdResult");
const ipPwResult = document.getElementById("ipPwResult");
const ipPwCheckResult = document.getElementById("ipPwCheckResult");
const ipNameResult = document.getElementById("ipNameResult");
const ipNnameResult = document.getElementById("ipNnameResult");
const ipBdateResult = document.getElementById("ipBdateResult");
const ipGenderResult = document.getElementById("ipGenderResult");
const ipEmailResult = document.getElementById("ipEmailResult");
const ipPhoneResult = document.getElementById("ipPhoneResult");

// ------------------- 회원가입-유효성 검사 -------------------
function joinCheck(){

    // 확인 결과
    let idCheck=false;
    let pwCheck=false;
    let pwEqualCheck=false;
    let nameCheck=false;
    let nnameCheck=false;
    let bdateCheck=false;
    let genderCheck=false;
    let emailCheck=false;
    let phoneCheck=false;

    // 아이디길이 확인
    ipId.addEventListener("blur", function(){
        // console.log("블러 이벤트 실행");
        idCheck=false;
        if(ipId.value.length>5 && ipId.value.length<20){
            ipIdResult.innerHTML="";
            idCheck=true;
        }else if(ipId.value.length == 0){
            ipIdResult.innerHTML="필수 정보입니다.";
        }else {
            ipIdResult.innerHTML="5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
        }

    });

    // 패스워드길이 확인
    ipPw.addEventListener("blur", function(){
        if(ipPw.value.length>8 && ipPw.value.length<16){
            ipPwResult.innerHTML="";
            ipPwCheck=true;
        }else if(ipPw.value.length == 0){
            ipPwResult.innerHTML="필수 정보입니다.";
        }else {
            ipPwResult.innerHTML="8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        }
    });

    // 패스워드가 일치하는지 확인
    ipPwCheck.addEventListener("blur", function(){
        if(ipPw.value == ipPwCheck.value){
            ipPwCheckResult.innerHTML="";
            pwEqualCheck=true;
        }else if(ipPwCheck.value.length == 0){
            ipPwCheckResult.innerHTML="필수 정보입니다.";
        }else {
            pwEqualCheck=false;
            ipPwCheck.value="";
            ipPwCheckResult.innerHTML="비밀번호가 일치하지 않습니다.";
        }
    });

    // 회원가입 버튼 클릭
    btn.addEventListener("click", function(){
        if(idCheck && pwCheck && pwEqualCheck){

        }else {
            alert("필수 정보를 입력하세요");
        }
    });

}

// -------------------------- 회원가입-아이디중복 확인 --------------------------
// const ipId = document.getElementById("ipId"); 회원가입-아이디입력 input태그
// const aIdCheck = document.querySelector("#aIdCheck"); 회원가입-중복확인 a태그
function idCheck(){
    aIdCheck.addEventListener("click", function(){

        // 아이디 input안에 입력한 값을 id 변수에 넣음
        let id = ipId.value; 

        //---------------- Ajax --------------------
        // 1. XMLHTTPRequest 생성
        let xhttp = new XMLHttpRequest();

        // 2. Method, URL 준비 
        xhttp.open("POST", "../member/idCheck");
        
        // 3. Enctype
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        // 4. 요청 발생 (POST일 경우prammeter 추가)
        xhttp.send("id="+id);

        // 5. 응답 처리
        xhttp.onreadystatechange=function(){
            if(this.readyState==4 && this.status==200){

                // 응답결과 문자를 공백없이 result에 담음
                let result = xhttp.responseText.trim();
                
                if(result=='1'){

                    // 응답결과가 성공하면(중복이 있으면) 결과가 1
                    alert("❌아이디가 있습니다. 다시 입력해 주세요.");
                }else if(id.length===0) {

                    // 아이디 input안에 입력한 값이 없으면
                    alert("❗아이디를 입력해 주세요.");
                }else{

                    // 응답결과가 실패하면(중복이 없으면) 결과가 0
                    alert("✔사용 가능한 아이디입니다.");
                }
            }
        }

    });
}

function nNameCheck(){

}

function loginCheck(){

}