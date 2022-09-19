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
