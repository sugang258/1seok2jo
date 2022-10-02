// 공지사항 글수정
const n_update = document.getElementById("n_update");
const n_update_class = document.getElementsByClassName("update_btn");
const update_btn = document.getElementById("update_btn");

update_btn.addEventListener("click", function () {
  const n_title = document.getElementById("exampleFormControlInput1");
  const n_contents = document.getElementById("n_contents");
  const notice_num = document.getElementById("notice_num");
  let title = n_title.value;
  let contents = n_contents.value;
  let n_num = notice_num.value;
  console.log(title);
  console.log(contents);
  console.log(n_num);

  const xhttp = new XMLHttpRequest();
  xhttp.open("POST", "/board/nb_update");
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("title=" + title + "&contents=" + contents + "&n_num=" + n_num);
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      let result = xhttp.responseText;
      if (result == 1) {
        document.querySelector("#close").click();
        window.location.reload();
      } else {
        alert("업데이트 실패");
      }
    }
  };
});

//공지사항 댓글버튼(토글버튼)
const reply = document.getElementById("reply");
const reply_content = document.getElementById("reply_content");

reply.addEventListener("click", function () {
  if (reply_content.style.display != "none") {
    reply_content.style.display = "none";
  } else {
    reply_content.style.display = "block";
  }
});

//공지사항 댓글 리스트
