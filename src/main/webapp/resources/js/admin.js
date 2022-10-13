//게시글관리 페이지
function initboards(){
    let startDate = document.getElementById("startDate");
    let endDate = document.getElementById("endDate");
    let offset = new Date().getTimezoneOffset() * 60000;
    let today = new Date(Date.now() - offset).toISOString().substring(0,10);
    let orderby = document.querySelectorAll('input[name="orderby"]')
    let orderbyVal = document.querySelector('input[name="orderby"]:checked').value;
    let page = 1;

    startDate.value = today
    endDate.value= today

    boardsList(page)

    //search버튼 클릭하면 리스트 요청
    let btnSearch = document.getElementById("btnSearch");
    btnSearch.addEventListener("click", function(){
        page = 1;
        boardsList(page)    
    })

    //페이징 클릭하면
    let postResult = document.getElementById("postResult");
    postResult.addEventListener("click", function(event){
        let num = event.target.parentNode.getAttribute("data-num");
        let chk = document.querySelectorAll(".chk");
        if(event.target.getAttribute("class")=="page-link"){
            page = event.target.getAttribute("data-page")
            boardsList(page)
        }else{
            //all 체크박스 클릭하면 전체 체크, 해제
            if(event.target.getAttribute("id")=='all'){
                for(let i=0; i<chk.length; i++){
                    chk[i].checked = event.target.checked;
                }
            }else if(event.target.getAttribute("class")=='chk'){
                if(!event.target.checked){
                    all.checked = false;
                }else{
                    let test = true;
                    for(let i=0; i<chk.length; i++){
                        test = test && chk[i].checked;
                    }
                    if(test){
                        all.checked = test;
                    }
                }
            }else{
                //게시판 상세로 페이지 이동
                let num = event.target.parentNode.getAttribute("data-num")
                let bd = event.target.parentNode.childNodes[3].innerText
                if(bd=='공지사항'){
                    window.open("/board/nb_detail?n_num="+num);
                }else if(bd=='학습게시판'){
                    window.open("/board/sb_detail?sb_num="+num);
                }else if(bd=='자유게시판'){
                    window.open("/board/fb_detail?fb_num="+num);
                }
            }
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
            boardsList(page)
        })
    }
    //게시글 삭제 버튼 누르면
    let deleteboard = document.getElementById("deleteboard");
    let msg = "";
    deleteboard.addEventListener("click", function(){

        let board_num = getCheckboxValue("board_num")
        let chk = window.confirm("선택한 게시글을 삭제 하시겠습니까?")
        
        if(chk){
            let bnum_list = board_num.split(",");
            for(let i=0;i<bnum_list.length;i++){
                let b_num = bnum_list[i];
                const xhttp = new XMLHttpRequest();
                xhttp.open("POST","/admin/delBoardAdmin");
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
                xhttp.send("fb_num="+b_num);
                xhttp.addEventListener("readystatechange", function(){
                    if(this.readyState==4 && this.status==200){
                        console.log(xhttp.responseText)
                    }
                })

            }
            alert(msg+"게시글이 삭제되었습니다");
            location.href="./boardsList";
        }

    })
}
//게시글리스트 요청하기
function boardsList(page){
    let postResult = document.getElementById("postResult");
    let chkstatus = getCheckboxValue("status")
    orderbyVal = document.querySelector('input[name="orderby"]:checked').value
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST","./boardsList");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    xhttp.send("page="+page+"&chkstatus="+chkstatus+"&startDate="+startDate.value+"&endDate="+endDate.value+"&kind="+kind.value+"&search="+search.value+"&orderby="+orderbyVal)
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            postResult.innerHTML = xhttp.responseText;
        }
    })

}

//강의관리 페이지
function initlectures(){
    let page = 1;
    lectureList(page)

    //search버튼 클릭하면 리스트 요청
    let btnSearch = document.getElementById("btnSearch");
    btnSearch.addEventListener("click", function(){
        page = 1;
        lectureList(page)    
    })

    //페이징 클릭하면
    let postResult = document.getElementById("postResult");
    postResult.addEventListener("click", function(event){
        let chk = document.querySelectorAll(".chk");
        if(event.target.getAttribute("class")=="page-link"){
            page = event.target.getAttribute("data-page")
            lectureList(page)
        }else{
            //all 체크박스 클릭하면 전체 체크, 해제
            if(event.target.getAttribute("id")=='all'){
                for(let i=0; i<chk.length; i++){
                    chk[i].checked = event.target.checked;
                }
            }else if(event.target.getAttribute("class")=='chk'){
                if(!event.target.checked){
                    all.checked = false;
                }else{
                    let test = true;
                    for(let i=0; i<chk.length; i++){
                        test = test && chk[i].checked;
                    }
                    if(test){
                        all.checked = test;
                    }
                }
            }
            else{
                if(event.target.getAttribute("class")=="l_link"){
                    location.href="/lecture/detail?l_num="+event.target.getAttribute("data-num");
                }
            }
        }
    })

    //강의 삭제 버튼 누르면

    let lecDelBtn = document.getElementById("lecDelBtn");
    lecDelBtn.addEventListener("click", function(){

        let l_num = getCheckboxValue("l_num")
        let chk = window.confirm("강의를 삭제 하시겠습니까?")
        if(chk){
            let lnum_list = l_num.split(",");
            for(let i=0;i<lnum_list.length;i++){

                const xhttp = new XMLHttpRequest();
                xhttp.open("POST","/lecture/setDelete");
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
                xhttp.send("l_num="+lnum_list[i])
                xhttp.addEventListener("readystatechange", function(){
                    if(this.readyState==4 && this.status==200){
                        console.log(xhttp.responseText);
                    }
                })
            }
            alert("강의삭제가 완료되었습니다.")
            location.href="./lectureList";
        }
    });

}
//강의리스트 요청하기
function lectureList(page){
    let postResult = document.getElementById("postResult");
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST","./lectureList");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    xhttp.send("page="+page+"&kind="+kind.value+"&search="+search.value)
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            postResult.innerHTML = xhttp.responseText;
        }
    })

}

//회원관리 페이지
function initmembers(){
    let page = 1;
    memberList(page)

    //회원삭제 버튼 클릭
    let memDelBtn = document.getElementById("memDelBtn");
    memDelBtn.addEventListener("click", function(){
        let member_id = getCheckboxValue("member_id")
        alert("❗❗경고❗❗ 회원삭제 후 되돌릴 수 없습니다")
        let chk = window.confirm(member_id+" 회원 삭제를 하시겠습니까?")
        if(chk){
            let id_list = member_id.split(",");
            for(let i=0;i<id_list.length;i++){
                const xhttp = new XMLHttpRequest();
                xhttp.open("POST","/member/deleteMemberAdmin");
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
                xhttp.send("id="+id_list[i])
                xhttp.addEventListener("readystatechange", function(){
                    if(this.readyState==4 && this.status==200){
                        console.log(xhttp.responseText);
                    }
                })
            }
            alert("회원삭제가 완료되었습니다.")
            location.href="./memberList";
            
        }
    });
    //강사권한삭제 버튼 클릭
    let tchrDelBtn = document.getElementById("tchrDelBtn");
    tchrDelBtn.addEventListener("click", function(){
        let member_id = getCheckboxValue("member_id")
        let chk = window.confirm(member_id+" 강사의 권한을 삭제 하시겠습니까?")
        if(chk){
            let id_list = member_id.split(",");
            for(let i=0;i<id_list.length;i++){
                const xhttp = new XMLHttpRequest();
                xhttp.open("POST","/member/delTeacherAdmin");
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
                xhttp.send("id="+id_list[i])
                xhttp.addEventListener("readystatechange", function(){
                    if(this.readyState==4 && this.status==200){
                        console.log(xhttp.responseText);
                    }
                })
            }
            alert("강사권한삭제가 완료되었습니다.")
            location.href="./memberList";
            
        }
    });

    //search버튼 클릭하면 리스트 요청
    let btnSearch = document.getElementById("btnSearch");
    btnSearch.addEventListener("click", function(){
        page = 1;
        memberList(page)
        
    })

    //페이징 클릭하면
    let postResult = document.getElementById("postResult");
    postResult.addEventListener("click", function(event){
        let cs_num = event.target.parentNode.getAttribute("data-csnum");
        let chk = document.querySelectorAll(".chk");
        if(event.target.getAttribute("class")=="page-link"){
            page = event.target.getAttribute("data-page")
            memberList(page)
        }else{
            //all 체크박스 클릭하면 전체 체크, 해제
            if(event.target.getAttribute("id")=='all'){
                for(let i=0; i<chk.length; i++){
                    chk[i].checked = event.target.checked;
                }
            }else if(event.target.getAttribute("class")=='chk'){
                if(!event.target.checked){
                    all.checked = false;
                }else{
                    let test = true;
                    for(let i=0; i<chk.length; i++){
                        test = test && chk[i].checked;
                    }
                    if(test){
                        all.checked = test;
                    }
                }
            }
        }

    })

    //회원삭제버튼 클릭하면

    //강사권한삭제버튼 클릭하면

}
//memberList요청하기
function memberList(page){
    let postResult = document.getElementById("postResult");
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST","./memberList");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    xhttp.send("page="+page+"&kind="+kind.value+"&search="+search.value)
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            postResult.innerHTML = xhttp.responseText;
        }
    })

}

//매출관리 페이지
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

    //list및 페이징 클릭하면
    let postResult = document.getElementById("postResult");
    postResult.addEventListener("click", function(event){
        let num = event.target.parentNode.getAttribute("data-num");
        if(num==null){
            if(event.target.getAttribute("class")=="page-link"){
                page = event.target.getAttribute("data-page")
                payList(page)
            }else{
            }
        }else{
            window.open("/pay/status?p_uid="+num);
        }
    })
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
    let offset = new Date().getTimezoneOffset() * 60000;
    let today = new Date(Date.now() - offset).toISOString().substring(0,10);
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

