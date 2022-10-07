/**URL주소복사 */
function clip() {
  let url = "";
  const textarea = document.createElement("textarea");
  document.body.appendChild(textarea);
  url = window.document.location.href;
  textarea.value = url;
  textarea.select();
  document.execCommand("copy");
  document.body.removeChild(textarea);
  alert("URL이 복사되었습니다.");
}

//댓글보기 토글
reply.addEventListener("click", function () {
  const reply_content = document.getElementById("reply_content");
  if (document.getElementById("reply_content").style.display == "none") {
    document.getElementById("reply_content").style.display = "";
    reply.innerHTML = "접기";
  } else {
    document.getElementById("reply_content").style.display = "none";
    reply.innerHTML = "댓글 더보기";
  }
});

//자유게시판 글수정
const update_btn = document.getElementById("update_btn");
update_free_board = document.addEventListener("click", function (event) {
  if (event.target.classList[0] == "update_btn") {
    let title = document.getElementById("exampleFormControlInput1");
    title = title.value;
    let contents = document.getElementById("contents");
    contents = contents.value;
    let fb_num = update_btn.getAttribute("data-board-num");

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "fb_update");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send(
      "title=" + title + "&contents=" + contents + "&fb_num=" + fb_num
    );
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        let result = xhttp.responseText;
        if (result == 1) {
          window.location.reload();
        } else {
          alert("수정실패");
        }
      }
    };
  }
});

//자유게시판 댓글 불러오기
function getFb_reply(page) {
  const reply_content = document.getElementById("reply_content");
  let fb_num = update_btn.getAttribute("data-board-num");
  const xhttp = new XMLHttpRequest();
  xhttp.open("GET", "fb_reply?fb_num=" + fb_num + "&page=" + page);
  xhttp.send();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      reply_content.innerHTML = xhttp.responseText;
      getReplyCount();
    }
  };
}

//자유게시판 댓글작성
const reply_content = document.getElementById("reply_content");

reply_content.addEventListener("click", function (event) {
  if (event.target.className == "reply_btn") {
    let id = document.getElementById("c_id");
    id = id.value;
    let contents = document.getElementById("reply_text");
    contents = contents.value;
    let fb_num = update_btn.getAttribute("data-board-num");
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "fb_replyAdd");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("id=" + id + "&contents=" + contents + "&fb_num=" + fb_num);
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        let result = xhttp.responseText;
        if (result == 1) {
          getFb_reply(page);
          getReplyCount();
        } else {
          alert("작성실패");
        }
      }
    };
  }
});
//자유게시판 댓글작성-enter_key
reply_content.addEventListener("keydown", function (event) {
  if (event.target.className == "reply_text") {
    let id = document.getElementById("c_id");
    id = id.value;
    let contents = document.getElementById("reply_text");
    contents = contents.value;
    let fb_num = update_btn.getAttribute("data-board-num");
    if (event.keyCode == 13) {
      const xhttp = new XMLHttpRequest();
      xhttp.open("POST", "fb_replyAdd");
      xhttp.setRequestHeader(
        "Content-type",
        "application/x-www-form-urlencoded"
      );
      xhttp.send("id=" + id + "&contents=" + contents + "&fb_num=" + fb_num);
      xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
          let result = xhttp.responseText;
          if (result == 1) {
            getFb_reply(page);
            getReplyCount();
          } else {
            alert("작성실패");
          }
        }
      };
    }
  }
});

//자유게시판 댓글삭제
reply_content.addEventListener("click", function (event) {
  if (event.target.className == "text_delete_btn") {
    let check = window.confirm("삭제하시겠습니까?🤔");
    if (check) {
      let num = event.target.getAttribute("data-comment-num");
      const xhttp = new XMLHttpRequest();
      xhttp.open("POST", "fb_replyDelete");
      xhttp.setRequestHeader(
        "Content-type",
        "application/x-www-form-urlencoded"
      );
      xhttp.send("num=" + num);
      xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
          let result = xhttp.responseText;
          if (result == 1) {
            getFb_reply(page);
            getReplyCount();
          } else {
            alert("삭제실패");
          }
        }
      };
    }
  }
});

//자유게시판 댓글갯수
function getReplyCount() {
  let fb_num = update_btn.getAttribute("data-board-num");
  const getReplyCount = document.getElementById("getReplyCount");
  const xhttp = new XMLHttpRequest();
  xhttp.open("GET", "fb_reply_count?fb_num=" + fb_num);
  xhttp.send();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      getReplyCount.innerHTML = xhttp.responseText;
    }
  };
}

//자유게시판 추천
function setFb_heart() {
  const fb_heart = document.getElementById("fb_heart");
  const fb_heart_count = document.getElementById("fb_heart_count");
  fb_heart.addEventListener("click", function () {
    let heart_count_value = fb_heart_count.innerHTML;
    let id = document.getElementById("session_id");
    id = id.value;
    let fb_num = document.getElementById("free_board_num");
    fb_num = fb_num.value;
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "fb_heart");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("id=" + id + "&fb_num=" + fb_num);
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        let result = xhttp.responseText.trim();
        if (result == 1) {
          //카운트가 1씩 증가 ++count
          fb_heart.setAttribute("style", "color:red");
          fb_heart_count.innerHTML = ++heart_count_value;
        } else {
          //카운트가 1씩 감소 --count
          fb_heart.setAttribute("style", "color: rgb(189, 185, 185)");
          fb_heart_count.innerHTML = --heart_count_value;
        }
      }
    };
  });
}

//자유게시판 좋아요수
function getFb_replyCount() {
  const fb_heart_count = document.getElementById("fb_heart_count");
  let fb_num = document.getElementById("free_board_num");
  fb_num = fb_num.value;

  const xhttp = new XMLHttpRequest();
  xhttp.open("GET", "fb_heart_count?fb_num=" + fb_num);
  xhttp.send();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      let count = xhttp.responseText.trim();
      fb_heart_count.innerHTML = count;
    }
  };
}
let page = 1;
reply_content.addEventListener("click", function (event) {
  if (event.target.className == "plus") {
    page++;
    getFb_reply(page);
  }
});

//자유게시판 글삭제
const fb_delete = document.getElementById("fb_delete");
fb_delete.addEventListener("click", function () {
  let check = window.confirm("삭제하시겠습니까?😶‍🌫️");
  if (check) {
    let fb_num = update_btn.getAttribute("data-board-num");
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "fb_delete");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("fb_num=" + fb_num);
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        let result = xhttp.responseText;
        if (result == 1) {
          location.replace("/board/fb_list");
        }
      }
    };
  }
});
