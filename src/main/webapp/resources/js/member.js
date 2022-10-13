
//member.js - 회원-회원가입, 회원-로그인 

// ------------------- 회원가입-유효성 검사 -------------------
function joinCheck(){
    // form 선택
    // 회원가입-회원가입 폼
    const joinForm = document.querySelector("#joinForm");
    
    // button 선택
    // 회원가입-아이디 중복 확인 버튼
    const aIdCheck = document.querySelector("#aIdCheck");
    // 회원가입-닉네임 중복 확인버튼
    const bnNameCheck = document.querySelector("#bnNameCheck");
    // 회원가입-회원가입버튼 
    const btn = document.getElementById("btn");
    
    // select 선택
    const segender = document.querySelector("#segender");
    const semm = document.querySelector("#semm");
    
    // input 선택
    const ipId = document.getElementById("ipId");
    const ipPw = document.getElementById("ipPw");
    const ipPwCheck = document.getElementById("ipPwCheck");
    const ipName = document.getElementById("ipName");
    const ipNname = document.getElementById("ipNname");
    const ipyy = document.querySelector("#ipyy");
    const ipdd = document.querySelector("#ipdd");
    const ipEmail = document.getElementById("ipEmail");
    const ipPhone = document.getElementById("ipPhone");
    
    //div 선택
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
    let idCheckCh=false;
    let pwCheck=false;
    let pwEqualCheck=false;
    let nameCheck=false;
    let nnameCheck=false;
    let nnameCheckCh=false;
    let yyCheck=false;
    let mmCheck=false;
    let ddCheck=false;
    let genderCheck=false;
    let emailCheck=false;
    let phoneCheck=false;
    
    // 아이디 확인
    ipId.addEventListener("blur", function(){
        // 아이디-6~20자 영문(소문자), 숫자 정규식
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

    // 아이디 중복 확인
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
                    idCheckCh=false;
                    // 응답결과가 성공하면(중복이 있으면) 결과가 1
                    alert("❌아이디가 있습니다. 다시 입력해 주세요.");
                    ipId.focus();
                }else if(id.length===0) {
                    idCheckCh=false;
                    // 아이디 input안에 입력한 값이 없으면
                    alert("❗아이디를 입력해 주세요.");
                    ipId.focus();
                }else{

                    // 응답결과가 실패하면(중복이 없으면) 결과가 0
                    alert("✔사용 가능한 아이디입니다.");
                    idCheckCh=true;
                }
            }
        }
    });

    // 패스워드 확인
    ipPw.addEventListener("blur", function(){
        // 비밀번호-8~16자 영문 대 소문자, 숫자 정규식
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

    // 이름 확인
    ipName.addEventListener("blur", function(){
        //한글, 영문 확인 정규식
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

    // 닉네임 확인
    ipNname.addEventListener("blur", function(){
        //한글, 영문 확인 정규식
        const nnameText = /^[a-zA-Zㄱ-힣][a-zA-Zㄱ-힣 ]*$/;
        const nname = ipNname.value;
        if(!nnameText.test(nname)){
            nnameCheck=false;
            ipNnameResult.innerHTML="한글, 영문만 사용 가능합니다.";
        }else {
            ipNnameResult.innerHTML="";
            nnameCheck=true;
        }
    });

    // 닉네임 중복 확인
    bnNameCheck.addEventListener("click", function(){

        // 닉네임 input안에 입력한 값을 id 변수에 넣음
        let n_name = ipNname.value; 

        //---------------- Ajax --------------------
        // 1. XMLHTTPRequest 생성
        let xhttp = new XMLHttpRequest();

        // 2. Method, URL 준비 
        xhttp.open("POST", "../member/nNameCheck");
        
        // 3. Enctype
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        // 4. 요청 발생 (POST일 경우prammeter 추가)
        xhttp.send("n_name="+n_name);

        // 5. 응답 처리
        xhttp.onreadystatechange=function(){
            if(this.readyState==4 && this.status==200){

                // 응답결과 문자를 공백없이 result에 담음
                let result = xhttp.responseText.trim();
                
                if(result=='1'){
                    nnameCheckCh=false;
                    // 응답결과가 성공하면(중복이 있으면) 결과가 1
                    alert("❌닉네임이 있습니다. 다시 입력해 주세요.");
                    ipNname.focus();
                }else if(n_name.length===0) {
                    nnameCheckCh=false;
                    // 아이디 input안에 입력한 값이 없으면
                    alert("❗닉네임을 입력해 주세요.");
                    ipNname.focus();
                }else{

                    // 응답결과가 실패하면(중복이 없으면) 결과가 0
                    alert("✔사용 가능한 닉네임입니다.");
                    nnameCheckCh=true;
                }
            }
        }

    });

    // 생일-년도 확인
    ipyy.addEventListener("blur", function(){
        let year = parseInt(ipyy.value.substr(0,4)); // 입력한 값의 0~4자리까지 (연)
        let today = new Date(); // 날짜 변수 선언
        let yearNow = today.getFullYear(); // 올해 연도 가져옴
        if(1920 > year || year > yearNow){
            yyCheck=false;
            ipBdateResult.innerHTML="정말이세요?";
        }else if(ipyy.value.length == 4) {
            ipBdateResult.innerHTML="태어난 월을 선택하세요.";
            yyCheck=true;
        }else {
            yyCheck=false;
            ipBdateResult.innerHTML="태어난 년도 4자리를 정확하게 입력하세요.";
        }
    });

    // 생일-월 확인
    semm.addEventListener("click", function(){
        if(semm.value.length > 0){
            mmCheck=true;
            ipBdateResult.innerHTML="태어난 일(날짜) 2자리를 정확하게 입력하세요.";
            // 날짜 인풋 focus 이벤트 강제실행
            ipdd.focus();
        }else {
            mmCheck=false;
            ipBdateResult.innerHTML="태어난 월을 선택하세요.";
        }
    });

    // 생일-날짜 확인
    ipdd.addEventListener("blur", function(){
        let day = parseInt(ipdd.value.substr(0,2)); // 입력한 값 6번째 자리부터 2자리 숫자 (일)
        if(day < 1 || day > 31){
            ddCheck=false;
            ipBdateResult.innerHTML="생년월일을 다시 확인해 주세요.";
        }else if(ipdd.value.length == 2){
            ipBdateResult.innerHTML="";
            ddCheck=true;
        }else if(ipyy.value.length < 4){
            // 만약 년도가 없다면 focus 이벤트 강제실행
            ddCheck=false;
            ipBdateResult.innerHTML="생년월일을 다시 확인해 주세요.";
            ipyy.focus();
        }else {
            // 만약 ipdd.value.length < 2 라면 false
            ddCheck=false;
            ipBdateResult.innerHTML="태어난 일(날짜) 2자리를 정확하게 입력하세요.";
        }
    });

    // 성별 확인
    segender.addEventListener("click", function(){
        if(segender.value.length > 0){
            genderCheck=true;
            ipGenderResult.innerHTML="";
        }else {
            genderCheck=false;
            ipGenderResult.innerHTML="성별을 선택하세요";
        }
    });

    // 이메일 확인
    ipEmail.addEventListener("blur", function(){
        const emailText = /^[a-z]+[a-z0-9]{5,19}$/g;
        const email = ipEmail.value;
        if(!emailText.test(email)){
            emailCheck=false;
            ipEmailResult.innerHTML="이메일 아이디를 확인해 주세요.";
        }else {
            ipEmailResult.innerHTML="";
            emailCheck=true;
        }
    });

    // 핸드폰번호 확인
    ipPhone.addEventListener("blur", function(){
        // 핸드폰번호-010(011)-1234-5678 정규식
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

        // // 확인 결과
        // let idCheck=false;
        // let idCheckCh=false;
        // let pwCheck=false;
        // let pwEqualCheck=false;
        // let nameCheck=false;
        // let nnameCheck=false;
        // let nnameCheckCh=false;
        // let yyCheck=false;
        // let mmCheck=false;
        // let ddCheck=false;
        // let genderCheck=false;
        // let emailCheck=false;
        // let phoneCheck=false;

    // 회원가입 버튼 클릭
    btn.addEventListener("click", function(){
        if(idCheck && idCheckCh && pwCheck && pwEqualCheck && nameCheck && nnameCheck && nnameCheckCh && yyCheck && mmCheck && ddCheck && genderCheck && emailCheck && phoneCheck){
           
            alert("🎉🎉회원가입을 축하합니다🎉🎉 마일리지 5000포인트 지급❗❗ ");
            // 서버에 저장
            joinForm.submit();

        }else if(!idCheckCh){

            alert("❗❗아이디 중복 버튼을 클릭 하세요.❗❗");

        }else if(!nnameCheckCh){

            alert("❗❗닉네임 중복 버튼을 클릭 하세요.❗❗");

        }else {

            alert("❗❗필수 정보를 확인하세요.❗❗");

        }
    });

}

// ---------------------- 로그인 ----------------------
function loginCheck(){
    //form 선택
    const loginForm = document.querySelector("#loginForm");

    //input 선택
    const logId = document.querySelector("#logId");
    const logPw = document.querySelector("#logPw");

    //button 선택
    const login = document.querySelector("#login");

    login.addEventListener("click", function(){
        let id = logId.value;
        let pw = logPw.value;
        //---------------- Ajax --------------------
    
        // 1. XMLHTTPRequest 생성
        let xhttp = new XMLHttpRequest();
    
        // 2. Method, URL 준비 
        xhttp.open("POST", "../member/login");
        
        // 3. Enctype
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    
        // 4. 요청 발생 (POST일 경우prammeter 추가)
        xhttp.send("id="+id+"&pw="+pw);
    
        // 5. 응답 처리
        xhttp.onreadystatechange=function(){
    
            if(this.readyState==4 && this.status==200){
    
                let respMemberDTO = xhttp.responseText.trim();
    
                if(!respMemberDTO){
    
                    alert("❗비밀번호가 틀렸습니다. 다시 확인 해주세요.");
                    return false;
    
                }else{

                    //저장
                    loginForm.submit();
                    
                }
            }
        }
    });

}