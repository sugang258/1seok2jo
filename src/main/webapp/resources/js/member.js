
//member.js - 회원-회원가입, 회원-로그인 

// select 선택
// ------------------- 회원가입-유효성 검사 -------------------
const segender = document.querySelector("#segender");
const semm = document.querySelector("#semm");
// input 선택

// ---------------- 회원가입-아이디 중복 확인 ----------------
const aIdCheck = document.querySelector("#aIdCheck");
// ------------------- 회원가입-유효성 검사 -------------------
const ipId = document.getElementById("ipId");
const ipPw = document.getElementById("ipPw");
const ipPwCheck = document.getElementById("ipPwCheck");
const ipName = document.getElementById("ipName");
const ipNname = document.getElementById("ipNname");
const ipyy = document.querySelector("#ipyy");
const ipdd = document.querySelector("#ipdd");
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

    // 확인 결과
    let idCheck=false;
    let pwCheck=false;
    let pwEqualCheck=false;
    let nameCheck=false;
    let nnameCheck=false;
    let yyCheck=false;
    let mmCheck=false;
    let ddCheck=false;
    let genderCheck=false;
    let emailCheck=false;
    let phoneCheck=false;
// 휴대폰 정규 표현식 /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
// 이메일 체크 정규식 /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
// ------------------- 회원가입-유효성 검사 -------------------
function joinCheck(){

    // 아이디길이 확인
    ipId.addEventListener("blur", function(){
        // 아이디 정규식
        const idText = /^[a-z]+[a-z0-9]{5,19}$/g;
        const id = ipId.value;
        // 일치하면 true 리턴
        if(!idText.test(id)){
            idCheck=false;
            ipIdResult.innerHTML="6~20자의 영문 소문자, 숫자만 사용 가능합니다.";
        }else {
            ipIdResult.innerHTML="";
            idCheck=true;
        }
    });

    // 패스워드길이 확인
    ipPw.addEventListener("blur", function(){
        // 비밀번호 정규식
        const pwText = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;
        const pw = ipPw.value;
        // 일치하면 true 리턴
        if(!pwText.test(pw)){
            pwCheck=false;
            ipPwResult.innerHTML="8~16자 영문 대 소문자, 숫자를 사용하세요.";
        }else {
            ipPwResult.innerHTML="";
            pwCheck=true;
        }
    });

    // 패스워드가 일치하는지 확인
    ipPwCheck.addEventListener("blur", function(){
        if(ipPw.value == ipPwCheck.value){
            ipPwCheckResult.innerHTML="";
            pwEqualCheck=true;
        }else if(ipPwCheck.value.length == 0){
            pwEqualCheck=false;
            ipPwCheckResult.innerHTML="필수 정보입니다.";
        }else {
            pwEqualCheck=false;
            ipPwCheck.value="";
            ipPwCheckResult.innerHTML="비밀번호가 일치하지 않습니다.";
        }
    });

    // 이름길이 확인
    ipName.addEventListener("blur", function(){
        const nameText = /^[a-zA-Zㄱ-힣][a-zA-Zㄱ-힣 ]*$/;
        const name = ipName.value;
        if(!nameText.test(name)){
            nameCheck=false;
            ipNameResult.innerHTML="한글, 영문만 사용 가능합니다.";
        }else {
            ipNameResult.innerHTML="";
            nameCheck=true;
        }
    });

    // 닉네임길이 확인
    ipNname.addEventListener("blur", function(){
        if(ipNname.value.length > 0){
            ipNnameResult.innerHTML="";
            nnameCheck=true;
        }else {
            nnameCheck=false;
            ipNnameResult.innerHTML="필수 정보입니다.";
        }
    });

    // 생일 년도길이 확인
    ipyy.addEventListener("blur", function(){
        if(ipyy.value.length  < 4){
            yyCheck=false;
            ipBdateResult.innerHTML="태어난 년도 4자리를 정확하게 입력하세요.";
        }else if(ipyy.value.length == 4) {
            ipBdateResult.innerHTML="태어난 월을 선택하세요.";
            yyCheck=true;
        }else {
            yyCheck=false;
            ipBdateResult.innerHTML="태어난 년도 4자리를 정확하게 입력하세요.";
        }
    });

    semm.addEventListener("blur", function(){
        if(semm.value.length > 0){
            ipBdateResult.innerHTML="태어난 일(날짜) 2자리를 정확하게 입력하세요.";
            mmCheck=true;
        }else {
            mmCheck=false;
            ipBdateResult.innerHTML="태어난 월을 선택하세요.";
        }
    });

    ipdd.addEventListener("blur", function(){
        let idd = ipdd.value;
        console.log("ipdd : "+idd);
        console.log(typeof idd);
        const dd = parseInt(ipdd.value);
        console.log("dd : "+dd);
        console.log(typeof dd);
        if(ipdd.value.length == 2){
            ipBdateResult.innerHTML="";
            ddCheck=true;
        }else if(dd > 31){
            ddCheck=false;
            ipBdateResult.innerHTML="생년월일을 다시 확인해 주세요.";
        }else if(ipdd.value=="e"){
            ddCheck=false;
            ipBdateResult.innerHTML="숫자를 입력하세요.";
        }else if(ipdd.value.length < 2){
            ddCheck=false;
            ipBdateResult.innerHTML="태어난 일(날짜) 2자리를 정확하게 입력하세요.";
        }
    });

    // 이메일 정규식 /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    ipEmail.addEventListener("blur", function(){

    });

    // 핸드폰번호 정규식
    ipPhone.addEventListener("blur", function(){
        const phoneText = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
        const phone = ipPhone.value;
        if(!phoneText.test(phone)){
            ipPhoneResult.innerHTML="010(011)-1234-5678 형식에 맞게 입력해 주세요.";
            phoneCheck=false;
        }else {
            ipPhoneResult.innerHTML="";
            phoneCheck=true;
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
function idCheckCheck(){
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

// -------------------------- 회원가입-닉네임중복 확인 --------------------------
function nNameCheck(){
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

function loginCheck(){

}