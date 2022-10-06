function init(){
    let startDate = document.getElementById("startDate");
    let endDate = document.getElementById("endDate");
    
    let page = 1;
    let offset = new Date().getTimezoneOffset() * 60000;
    let today = new Date(Date.now() - offset).toISOString().substring(0,10);

    let orderby = document.querySelectorAll('input[name="orderby"]')
    let orderbyVal = document.querySelector('input[name="orderby"]:checked').value;

    endDate.value = today
    startDate.value= today.substring(0,8)+"01";

    payList(page)
    totalpay()

    //search버튼 클릭하면 리스트 요청
    let btnSearch = document.getElementById("btnSearch");
    btnSearch.addEventListener("click", function(){
        page = 1;
        payList(page)
        totalpay()
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

    //페이지 클릭하면
    let postResult = document.getElementById("postResult");
    postResult.addEventListener("click", function(event){

        if(event.target.getAttribute("class")=="page-link"){
            page = event.target.getAttribute("data-page")
            payList(page)
        }else{
        }

    })
}

//payList요청하기
function payList(page){
    //list 요청
    let postResult = document.getElementById("postResult");
    let chkstatus = getCheckboxValue("status")
    orderbyVal = document.querySelector('input[name="orderby"]:checked').value
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST","/teacher/salesList");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    xhttp.send("page="+page+"&chkstatus="+chkstatus+"&startDate="+startDate.value+"&endDate="+endDate.value+"&kind="+kind.value+"&search="+search.value+"&orderby="+orderbyVal)
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            postResult.innerHTML = xhttp.responseText;
        }
    })
}

//매출액 계산해 가져오기
function totalpay(){
    // and pr_num is null
    let totalAmount = document.getElementById("totalAmount");
    let chkstatus = getCheckboxValue("status")
    orderbyVal = document.querySelector('input[name="orderby"]:checked').value
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST","./oamountTotal");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    xhttp.send("chkstatus="+chkstatus+"&startDate="+startDate.value+"&endDate="+endDate.value+"&kind="+kind.value+"&search="+search.value+"&orderby="+orderbyVal)
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState==4 && this.status==200){
            totalAmount.innerHTML = xhttp.responseText;
        }
    })
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