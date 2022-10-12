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
    reply.innerHTML = "✖️더보기";
  } else {
    reply_content.style.display = "block";
    reply.innerHTML = "➖접기";
  }
});

//공지사항 댓글 리스트
function getNoticeReply() {
  const notice_num = document.getElementById("notice_num");
  let n_num = notice_num.value;
  const xhttp = new XMLHttpRequest();
  xhttp.open("POST", "nb_detail");
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("n_num=" + n_num);
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      reply_content.innerHTML = xhttp.responseText;
    }
  };
}

//공지사항 댓글 작성
reply_content.addEventListener("click", function (event) {
  if (event.target.classList[0] == "reply_btn") {
    const notice_num = document.getElementById("notice_num");
    let n_num = notice_num.value;
    const reply_add = document.getElementById("reply_add");
    let contents = reply_add.value;
    const reply_id = document.getElementById("reply_id");
    let id = reply_id.value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "reply_add");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("id=" + id + "&contents=" + contents + "&n_num=" + n_num);
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        let result = xhttp.responseText;
        if (result == 1) {
          getNoticeReply();
          getReplyCount();
        } else {
          alert("등록실패");
        }
      }
    };
  }
});

//공지사항 댓글삭제
const reply_delete = document.getElementsByClassName("reply_delete");

reply_content.addEventListener("click", function (event) {
  if (event.target.classList[0] == "reply_delete") {
    let check = window.confirm("삭제하시겠습니까?😶‍🌫️");
    if (check) {
      let num = event.target.getAttribute("data-reply-num");
      replyDelete(num);
    }
  }
});

function replyDelete(num) {
  const xhttp = new XMLHttpRequest();
  xhttp.open("POST", "reply_delete");
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("num=" + num);
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      let result = xhttp.responseText;
      if (result == 1) {
        getNoticeReply();
        getReplyCount();
      } else {
        alert("등록실패");
      }
    }
  };
}

//공지사항 댓글수
function getReplyCount() {
  const notice_num = document.getElementById("notice_num");
  const count = document.getElementById("count");
  let n_num = notice_num.value;
  const xhttp = new XMLHttpRequest();
  xhttp.open("GET", "reply_count?n_num=" + n_num);
  xhttp.send();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      count.innerHTML = xhttp.responseText;
    }
  };
}
