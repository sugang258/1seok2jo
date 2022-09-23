const reply = document.getElementById("reply");
const reply_t = document.getElementById("reply_t");
const teacher = document.getElementById("teacher");

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

reply.addEventListener("click", function () {
  const reply_content = document.getElementById("reply_content");
  if (document.getElementById("reply_content").style.display == "none") {
    document.getElementById("reply_content").style.display = "";
    reply.innerHTML = "접기";
  } else {
    document.getElementById("reply_content").style.display = "none";
    reply.innerHTML = "댓글 더보기";
    getReply();
  }
});

teacher.addEventListener("click", function (event) {
  if (event.target.className == reply_t) {
    console.log(event.target.className.nextSibling);
    const t_comment = document.getElementById("t_comment");

    if (document.getElementById("t_comment").style.display == "none") {
      document.getElementById("t_comment").style.display = "";
      reply_t.innerHTML = "접기";
    } else {
      document.getElementById("t_comment").style.display = "none";
      reply_t.innerHTML = "댓글 더보기";
    }
  }
});

/*Update Page*/
const update_btn = document.getElementById("update_btn");
const contents = document.getElementById("contents");
const title = document.getElementById("exampleFormControlInput1");

update_btn.addEventListener("click", function () {
  let num = update_btn.getAttribute("data-board-num");
  let tv = title.value;
  let cv = contents.value;
  console.log(cv);

  //1.XMLHTTPRequest생성
  const xhttp = new XMLHttpRequest();

  //2. url준비
  xhttp.open("POST", "./sb_update");

  //3. Enctype 요청 헤더 설정
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

  //4. 전송(post일 경우 파라미터 추가)
  xhttp.send("sb_num=" + num + "&title=" + tv + "&contents=" + cv);

  //5.응답처리
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      if (this.responseText.trim() == "1") {
        alert("수정 성공");
        document.querySelector("#close").click();
        window.location.reload();
      } else {
        alert("수정 실패");
      }
    }
  };
});

/*강사 답글작성*/
const answer_btn = document.getElementById("answer_btn");
const t_answer = document.getElementById("t_answer");

answer_btn.addEventListener("click", function () {
  let t_num = update_btn.getAttribute("data-board-num");
  let t_cv = t_answer.value;
  console.log(t_num);

  //1.XMLHTTPRequest생성
  const xhttp = new XMLHttpRequest();

  //2. url 준비
  xhttp.open("POST", "/comment/c_add");

  //3. Enctype 요청 헤더 설정
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

  //4. send (post일 경우 파라미터 추가),++++ id, ref추가하기
  xhttp.send("sb_num=" + t_num + "&contents=" + t_cv);

  //5. 응답처리
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      let result = this.responseText.trim();
      if (result == 1) {
        document.querySelector("#close").click();
        window.location.reload();
      }
    }
  };
});

/*작성 된 강사 답글 조회*/

function getCommentDetail() {
  let num = update_btn.getAttribute("data-board-num");
  const xhttp = new XMLHttpRequest();
  xhttp.open("GET", "../comment/c_detail?sb_num=" + num);
  xhttp.send();

  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      teacher.innerHTML = xhttp.responseText;
    }
  };
}

/*강사답글 삭제*/
teacher.addEventListener("click", function (event) {
  let num = update_btn.getAttribute("data-board-num");
  if (event.target.classList[0] == "c_delete") {
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "/comment/c_delete");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("sb_num=" + num);
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        let result = xhttp.responseText;
        if (result == 1) {
          window.location.reload();
        }
      }
    };
  }
});

/*강사답글 수정*/

/*게시판 댓글 가져오기*/
const reply_content = document.getElementById("reply_content");

function getReply() {
  let c_num = update_btn.getAttribute("data-board-num");
  const xhttp = new XMLHttpRequest();
  xhttp.open("GET", "/comment/sb_comment?sb_num=" + c_num);
  xhttp.send();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      reply_content.innerHTML = xhttp.responseText;
    }
  };
}

/** 게시판 댓글작성*/
reply_content.addEventListener("click", function (event) {
  const reply_text = document.getElementById("reply_text");
  const reply_btn = document.getElementById("reply_btn");
  const c_id = document.getElementById("c_id");
  const c_box = document.getElementById("c_box");
  if (event.target.className == "reply_btn") {
    let num = update_btn.getAttribute("data-board-num");
    let text = reply_text.value;
    let id = c_id.value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "/comment/sb_commentAdd");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("sb_num=" + num + "&contents=" + text + "&id=" + id);
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        let result = xhttp.responseText;
        if (result == 1) {
          window.location.reload();
        }
      }
    };
  }
});

reply_content.addEventListener("keydown", function (event) {
  const reply_text = document.getElementById("reply_text");
  const reply_btn = document.getElementById("reply_btn");
  const c_id = document.getElementById("c_id");
  const c_box = document.getElementById("c_box");
  if (event.target.className == "reply_text") {
    if (event.keyCode == 13) {
      let num2 = update_btn.getAttribute("data-board-num");
      let text2 = reply_text.value;
      let id2 = c_id.value;

      const xhttp = new XMLHttpRequest();
      xhttp.open("POST", "/comment/sb_commentAdd");
      xhttp.setRequestHeader(
        "Content-type",
        "application/x-www-form-urlencoded"
      );
      xhttp.send("sb_num=" + num2 + "&contents=" + text2 + "&id=" + id2); //id값가져오고 sb_num, contents가져오기
      xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
          let result = xhttp.responseText;
          if (result == 1) {
            window.location.reload();
          }
        }
      };
    }
  }
});

/**게시판 댓글 삭제 */
const text_delete_btn = document.getElementsByClassName("text_delete_btn");

reply_content.addEventListener("click", function (event) {
  if (event.target.className == "text_delete_btn") {
    let comment_num = event.target.getAttribute("data-comment-num");

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "/comment/sb_commentDelete");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("num=" + comment_num);
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        if (xhttp.responseText == 1) {
          window.location.reload();
        }
      }
    };
  }
});

/**강사답글 - 댓글가져오기 */
function teacherReply() {
  let num = update_btn.getAttribute("data-board-num");
  console.log(num);
  const xhttp = new XMLHttpRequest();
  xhttp.open("POST", "../comment/t_comment");
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("sb_num=" + num);
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
    }
  };
}

/**강사답글-댓글 작성하기 */
teacher.addEventListener("click", function (event) {
  const comment_ref = document.getElementById("comment_ref");
  if (event.target.className == "reply_btn2") {
    const c_id2 = document.getElementById("c_id2");
    const reply_text2 = document.getElementById("reply_text2");
    let num = comment_ref.getAttribute("data-comment-num");
    let id = c_id2.value;
    let t_contents = event.target.previousSibling.previousSibling.value;
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "/comment/t_commentAdd");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("sb_num=" + num + "&id=" + id + "&contents=" + t_contents);
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        let result = xhttp.responseText;
        if (result == 1) {
          window.location.reload();
        } else {
          alert("등록실패");
        }
      }
    };
  }
});

/**강사답글 삭제 시 모든 댓글 삭제 */
teacher.addEventListener("click", function (event) {
  if (event.target.classList[0] == "c_delete") {
    const t_num = document.getElementById("t_num");
    let num = t_num.value;
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "/comment/c_delete");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("num=" + num);
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        let result = xhttp.responseText;
        if (result == 1) {
          console.log("삭제");
        }
      }
    };
  }
});

/**강사답글의 댓글 삭제 */
teacher.addEventListener("click", function (event) {
  console.log(event.target.className);
  if (event.target.className == "delete_btn") {
    const c_num2 = document.getElementById("c_num2");
    let num = c_num2.value;
    console.log(num);
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "/comment/t_commentDelete");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("num=" + num);
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        if (xhttp.responseText == 1) {
          alert("성공");
        }
      }
    };
  }
});
