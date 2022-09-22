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

//아이디 확인
ipId.addEventListener("blur", function(){
    //console.log("블러 이벤트 실행");
    idCheck=false;
    if(ipId.value.length>5 && ip){

    }

});