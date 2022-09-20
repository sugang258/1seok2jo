const reply = document.getElementById("reply");
const reply_sir = document.getElementById("reply_sir");

/**URL주소복사 */
function clip(){

	let url = '';
	const textarea = document.createElement("textarea");
	document.body.appendChild(textarea);
	url = window.document.location.href;
	textarea.value = url;
	textarea.select();
	document.execCommand('copy'); 
	document.body.removeChild(textarea);
	alert("URL이 복사되었습니다.")
}

reply.addEventListener("click", function(){
	
	if(document.getElementById("reply_list").style.display == "none"){
		document.getElementById("reply_list").style.display = "";
		reply.innerHTML ="접기"
	} else {
		document.getElementById("reply_list").style.display = "none";
		reply.innerHTML ="댓글 더보기"
	}
});

reply_sir.addEventListener("click", function(){
	
	if(document.getElementById("reply_list_second").style.display == "none"){
		document.getElementById("reply_list_second").style.display = "";
		reply_sir.innerHTML ="접기"
	} else {
		document.getElementById("reply_list_second").style.display = "none";
		reply_sir.innerHTML ="댓글 더보기"
	}
});



/*Update Page*/
const update_btn = document.getElementById("update_btn");
const contents = document.getElementById("contents");
const title = document.getElementById("exampleFormControlInput1");

update_btn.addEventListener("click", function(){

	let num = update_btn.getAttribute("data-board-num")
    let tv = title.value;
    let cv = contents.value;

	console.log(tv)
	console.log(cv)
	console.log(num)

	//1.XMLHTTPRequest생성
	const xhttp = new XMLHttpRequest();

	//2. url준비
	xhttp.open("POST", "./sb_update");

	//3. Enctype 요청 헤더 설정
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	//4. 전송(post일 경우 파라미터 추가)
	xhttp.send("sb_num="+num+"&title="+tv+"&contents="+cv);

	//5.응답처리
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			if(this.responseText.trim()=='1'){
				alert('수정 성공');
				document.querySelector("#up"+num).innerHTML=contents;
			}else {
				alert('수정 실패');
			}
		}
	}



/*
    값을 파라미터로 넘겨줌 post형식
	1.xhttp객체를 만들어서
	2.오픈으로 메서드 형식이랑 유알엘 지정
	3.헤더설정 포스트로 보낼것이니까 헤더설정 복붙
	4. 보내는거 샌드 포스트로 보낼거라서 

 */
});


