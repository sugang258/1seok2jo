function initpay(){
    let startDate = document.getElementById("startDate");
    let endDate = document.getElementById("endDate");
    
    let page = 1;
    let offset = new Date().getTimezoneOffset() * 60000;
    let today = new Date(Date.now() - offset).toISOString().substring(0,10);

    let orderby = document.querySelectorAll('input[name="orderby"]')
    let orderbyVal = document.querySelector('input[name="orderby"]:checked').value;

    startDate.value = today
    endDate.value= today

    payList(page)

    //search버튼 클릭하면 리스트 요청
    let btnSearch = document.getElementById("btnSearch");
    btnSearch.addEventListener("click", function(){
        page = 1;
        payList(page)
        
    })

    //order 값 바뀌면 변경하고 리스트 요청
    let newlb = document.getElementById("newlb")
    let oldlb = document.getElementById("oldlb")
    for(let i = 0 ; i<orderby.length; i++){
        orderby[i].addEventListener("change", function(){
            orderbyVal = document.querySelector('input[name="orderby"]:checked').value;
            if(orderbyVal=='old'){
                newlb.setAttribute("style", "");
                oldlb.setAttribute("style", "font-weight:bold; color:black");
            }else if(orderbyVal=='new'){
                oldlb.setAttribute("style", "");
                newlb.setAttribute("style", "font-weight:bold; color:black");
            }
            page = 1
            payList(page)
        })
    }
}

//payList요청하기
function payList(page){
    let postResult = document.getElementById("postResult");
    let chkstatus = getCheckboxValue("status")
    orderbyVal = document.querySelector('input[name="orderby"]:checked').value
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST","./paymentList");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    xhttp.send("page="+page+"&chkstatus="+chkstatus+"&startDate="+startDate.value+"&endDate="+endDate.value+"&kind="+kind.value+"&search="+search.value+"&orderby="+orderbyVal)
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            postResult.innerHTML = xhttp.responseText;
        }
    })

}

//리스트 페이지 js
function initcs(){
    //오늘날짜로 초기화
    let startDate = document.getElementById("startDate");
    let endDate = document.getElementById("endDate");
    let today = new Date().toISOString().substring(0,10);
    let orderby = document.querySelectorAll('input[name="orderby"]')
    let orderbyVal = document.querySelector('input[name="orderby"]:checked').value;
    let page = 1;

    startDate.value = today
    endDate.value= today
    csList(page)

    //search버튼 클릭하면 리스트 요청
    let btnSearch = document.getElementById("btnSearch");
    btnSearch.addEventListener("click", function(){
        page = 1;
        csList(page)
    })

    //boardList 클릭하면
    let postResult = document.getElementById("postResult");
    postResult.addEventListener("click", function(event){
        let cs_num = event.target.parentNode.getAttribute("data-csnum");
        if(cs_num==null){
            if(event.target.getAttribute("class")=="page-link"){
                page = event.target.getAttribute("data-page")
                csList(page)
            }else{
            }
        }else{
            location.href="./csAnswer?cs_num="+cs_num;
        }
    })

    //order 값 바뀌면 변경하고 리스트 요청
    let newlb = document.getElementById("newlb")
    let oldlb = document.getElementById("oldlb")
    for(let i = 0 ; i<orderby.length; i++){
        orderby[i].addEventListener("change", function(){
            orderbyVal = document.querySelector('input[name="orderby"]:checked').value;
            if(orderbyVal=='old'){
                newlb.setAttribute("style", "");
                oldlb.setAttribute("style", "font-weight:bold; color:black");
            }else if(orderbyVal=='new'){
                oldlb.setAttribute("style", "");
                newlb.setAttribute("style", "font-weight:bold; color:black");
            }
            page = 1
            csList(page)
        })
    }

}

//csboardList요청하기
function csList(page){
    let postResult = document.getElementById("postResult");
    orderbyVal = document.querySelector('input[name="orderby"]:checked').value
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST","./csboardList");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    xhttp.send("page="+page+"&startDate="+startDate.value+"&endDate="+endDate.value+"&kind="+kind.value+"&search="+search.value+"&orderby="+orderbyVal)
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            postResult.innerHTML = xhttp.responseText;
        }
    })

}

//로그인 페이지에서 실행되는 js
function login(){

    //관리자 인증 버튼 클릭 : 모달 창에서 값을 받아와서 ajax로 인증하기
    let getAuth = document.querySelector("#getAuth")
    
    getAuth.addEventListener("click", function(){
        let idAuth = document.querySelector("#idAuth")
        let pwAuth = document.querySelector("#pwAuth")
        let authNum = document.querySelector("#authNum")
        let authMessage = document.getElementById("authMessage")
    
        const xhttp = new XMLHttpRequest();
        xhttp.open("POST","./auth");
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
        xhttp.send("id="+idAuth.value+"&pw="+idAuth.value+"&authNum="+authNum.value)
        xhttp.addEventListener("readystatechange", function(){
            if(this.readyState==4 && this.status==200){
                    authMessage.innerHTML=xhttp.responseText.trim()
            }
        })
    
    })

    //쿠키에 idremember있으면 가져와서 value에 세팅
    let id = document.getElementById("id")
    id.value=getCookie("rememberid")


} //로그인 페이지 fucntion종료


//로그인 폼을 submit하면 쿠키에 아이디 저장 및 삭제
function rememberid(){
    let remember = document.getElementById("remember")

    //remember값이 true면 아이디 저장, false면 아이디 삭제
    if(remember.checked){
        setCookie("rememberid",id.value, 30);
    }else if(!remember.checked){
        let ck = getCookie("rememberid")
        if(ck!=""){
            deleteCookie("rememberid")
        }
    }
}

// 쿠키 저장하기 
// setCookie => saveid함수에서 넘겨준 시간이 현재시간과 비교해서 쿠키를 생성하고 지워주는 역할
function setCookie(cookieName, value, exdays) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue =  encodeURIComponent(value)
            + ((exdays == null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}

// 쿠키 삭제
function deleteCookie(cookieName) {
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires="
            + expireDate.toGMTString();
}

//쿠키가져오기
function getCookie(name) { //가져올 쿠키의 이름을 파라미터 값으로 받고
        var nameOfCookie = name + "="; //쿠키는 "쿠키=값" 형태로 가지고 있어서 뒤에 있는 값을 가져오기 위해 = 포함
        var x = 0; 
        while (x <= document.cookie.length) { //현재 세션에 가지고 있는 쿠키의 총 길이를 가지고 반복
            var y = (x + nameOfCookie.length); //substring으로 찾아낼 쿠키의 이름 길이 저장
            if (document.cookie.substring(x, y) == nameOfCookie) { //잘라낸 쿠키와 쿠키의 이름이 같다면
                if ((endOfCookie = document.cookie.indexOf(";", y)) == -1) //y의 위치로부터 ;값까지 값이 있으면 
                     endOfCookie = document.cookie.length; //쿠키의 길이로 적용하고
                    return (document.cookie.substring(y, endOfCookie)); //쿠키의 시작점과 끝점을 찾아서 값을 반환
                 } 
             x = document.cookie.indexOf(" ", x) + 1; //다음 쿠키를 찾기 위해 시작점을 반환
             if (x == 0) //쿠키 마지막이면 
                break; //반복문 빠져나오기
        } 
        return ""; //빈값 반환
}

function getCheckboxValue(chkboxname)  {
    // 선택된 목록 가져오기
    const query = 'input[name='+'"'+chkboxname+'"'+']:checked';
    const selectedEls = 
        document.querySelectorAll(query);
    
    // 선택된 목록에서 value 찾기
    let result = '';
    selectedEls.forEach((el) => {
      result += el.value + ',';
    });
    
    // 출력
    return (result.substring(0,result.length-1));
}
