//member.js
//input 선택자
const ipId = document.getElementById("ipId");
const ipPw = document.getElementById("ipPw");
const ipPwCheck = document.getElementById("ipPwCheck");
const ipName = document.getElementById("ipName");
const ipNname = document.getElementById("ipNname");
const ipBdate = document.getElementById("ipBdate");
const ipGender = document.getElementById("ipGender");
const ipEmail = document.getElementById("ipEmail");
const ipPhone = document.getElementById("ipPhone");
const btn = document.getElementById("btn");

//div 선택자
const ipIdResult = document.getElementById("ipIdResult");
const ipPwResult = document.getElementById("ipPwResult");
const ipPwCheckResult = document.getElementById("ipPwCheckResult");
const ipNameResult = document.getElementById("ipNameResult");
const ipNnameResult = document.getElementById("ipNnameResult");
const ipBdateResult = document.getElementById("ipBdateResult");
const ipGenderResult = document.getElementById("ipGenderResult");
const ipEmailResult = document.getElementById("ipEmailResult");
const ipPhoneResult = document.getElementById("ipPhoneResult");

//확인 결과
let idCheck=false;
let pwCheck=false;
let pwEqualCheck=false;
let nameCheck=false;
let nnameCheck=false;
let bdateCheck=false;
let genderCheck=false;
let emailCheck=false;
let phoneCheck=false;

//아이디길이 확인
ipId.addEventListener("blur", function(){
    //console.log("블러 이벤트 실행");
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

//패스워드길이 확인
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

//패스워드가 일치하는지 확인
ipPwCheck.addEventListener("blur", function(){
    if(ipPw.value == ipPwCheck.value){
        ipPwCheckResult.innerHTML="";
        pwEqualCheck=true;
    }else {
        pwEqualCheck=false;
        ipPwCheck.value="";
        ipPwCheckResult.innerHTML="비밀번호가 일치하지 않습니다.";
    }
});

//회원가입 버튼 클릭
btn.addEventListener("click", function(){
    if(idCheck && pwCheck && pwEqualCheck){

    }else {
        alert("필수 정보입니다");
    }
});