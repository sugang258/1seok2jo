
/**강사답글 - 댓글가져오기 */
const t_comment = document.getElementById("t_comment");
const teacher_box = document.getElementsByClassName("teacher_box");
const comment_ref = document.getElementById("comment_ref");

function teacherReply(){
	let num = comment_ref.getAttribute("data-comment-num");
	let ref = comment_ref.value;
	console.log(num);
	console.log(ref);
	const xhttp = new XMLHttpRequest();
	xhttp.open("POST", "teacher_comment");
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("sb_num="+num+"&ref="+ref);
	xhttp.onreadystatechange=function(){
		if(this.readyState==4&&this.status==200){
			t_comment.innerHTML = xhttp.responseText;
		}
	}

}






// teacher_reply.addEventListener("click", function(event){
// 	if(event.target.className=="")
// });

