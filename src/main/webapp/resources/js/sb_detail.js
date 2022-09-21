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
		getReply()
	}
});

// reply_sir.addEventListener("click", function(){
	
// 	if(document.getElementById("reply_list_second").style.display == "none"){
// 		document.getElementById("reply_list_second").style.display = "";
// 		reply_sir.innerHTML ="접기"
// 	} else {
// 		document.getElementById("reply_list_second").style.display = "none";
// 		reply_sir.innerHTML ="댓글 더보기"
// 	}
// });



/*Update Page*/
const update_btn = document.getElementById("update_btn");
const contents = document.getElementById("contents");
const title = document.getElementById("exampleFormControlInput1");

update_btn.addEventListener("click", function(){

	let num = update_btn.getAttribute("data-board-num")
    let tv = title.value;
    let cv = contents.value;

	console.log(num)
	console.log(tv)
	console.log(cv)

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
				document.querySelector("#close").click();
				window.location.reload();
				
			}else {
				alert('수정 실패');
			}
		}
	}
});


/*강사 답글작성*/
const answer_btn = document.getElementById("answer_btn");
const t_answer = document.getElementById("t_answer");

answer_btn.addEventListener("click", function(){

	let t_num = answer_btn.getAttribute("data-board-num");
	let t_cv = t_answer.value;
	console.log(t_num);
	console.log(t_cv);
	
	//1.XMLHTTPRequest생성
	const xhttp = new XMLHttpRequest();

	//2. url 준비
	xhttp.open("POST", "/comment/c_detail");

	//3. Enctype 요청 헤더 설정
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	//4. send (post일 경우 파라미터 추가),++++ id, ref추가하기
	xhttp.send("sb_num="+t_num+"&contents="+t_cv);

	//5. 응답처리
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			let result = this.responseText.trim();
			if(result == 1){
				document.querySelector("#close").click();
				window.location.reload();
			}

		}
	}

});

/*작성 된 강사 답글 조회*/
const teacher = document.getElementById("teacher");
function getCommentDetail(){
let num = update_btn.getAttribute("data-board-num");
	const xhttp = new XMLHttpRequest();
	xhttp.open("GET", "/comment/c_detail?sb_num="+num);

	xhttp.send();

	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			teacher.innerHTML=xhttp.responseText;
		}
	}
}

/*강사답글 삭제*/
teacher.addEventListener("click", function (event) {
	let num = update_btn.getAttribute("data-board-num");
	if (event.target.classList[0] == "c_delete") {
		const xhttp = new XMLHttpRequest();
		xhttp.open("POST", "/comment/c_delete");
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("sb_num="+num);
		xhttp.onreadystatechange=function(){
			if(this.readyState==4&& this.status==200){
				let result = xhttp.responseText;
				if(result == 1){
					window.location.reload();
				}
			}
		}
	}
})

/*강사답글 수정*/



/*게시판 댓글 가져오기*/
const reply_content = document.getElementById("reply_content");

function getReply(){
	let c_num = update_btn.getAttribute("data-board-num");
	const xhttp = new XMLHttpRequest();
	xhttp.open("GET", "/comment/sb_comment?sb_num="+c_num);
	xhttp.send();
	xhttp.onreadystatechange = function(){
		if(this.readyState==4&&this.status==200){
			console.log(this.responseText.trim());
			reply_content.innerHTML=xhttp.responseText;
		}
	}
}

/** 댓글작성*/
const reply_btn = document.getElementById("reply_btn");

reply_content.addEventListener("click", function(event){
	console.log(event.target.className)
	if(event.target.className == reply_btn){
		const xhttp = new XMLHttpRequest();
		xhttp.open("POST", "/comment/sb_commentAdd");
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send(""); //id값가져오고 sb_num, contents가져오기
		xhttp.onreadystatechange=function(){
			if(this.readyState==4&&this.status==200){
				let result = xhttp.responseText;
				if(result==1){
					window.location.reload();
				}
			}
		}
		
	}
});








