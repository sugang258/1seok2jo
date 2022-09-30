const lecture_add_btn = document.getElementById("lecture_add_btn");
const l_board_delete = document.getElementsByClassName("l_board_delete");

lecture_add.addEventListener("click", function (event) {
  if (event.target.classList[0] == "lecture_add") {
    const l_num = document.getElementById("l_num");
    const l_board_id = document.getElementById("l_board_id");
    const ratingNodeList = document.getElementsByName("rating");
    const contents = document.getElementById("contents");

    let num = l_num.value; //나중에 파라미터 값을 받기
    let id = l_board_id.value;
    let score;
    ratingNodeList.forEach((node) => {
      if (node.checked) {
        score = node.value;
      }
    });
    let l_contents = contents.value;
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "/board/l_boardAdd");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send(
      "l_num=" +
        num +
        "&id=" +
        id +
        "&score=" +
        score +
        "&contents=" +
        l_contents
    );
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        let result = xhttp.responseText;
        console.log(result);
        document.querySelector("#close").click();
        window.location.reload();
      }
    };
  }
});

for (let i = 0; i < l_board_delete.length; i++) {
  l_board_delete[i].addEventListener("click", function () {
    let num = document.querySelectorAll(".lecture_boardNum");
    num = num[i].value;
    console.log(num);
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "/board/l_boardDelete");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("num=" + num);
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        let result = xhttp.responseText.trim();
        console.log(result);
        if (result == 1) {
          window.location.reload();
        } else {
          alert("삭제실패");
        }
      }
    };
  });
}

//수강평 추천 기능구현
const reply_list = document.getElementsByClassName("reply_list");
const like_btn = document.getElementsByClassName("like_btn");

for (let i = 0; i < like_btn.length; i++) {
  like_btn[i].addEventListener("click", function () {
    const count_text = document.querySelectorAll(".count_text");
    let count_text_value = count_text[i].innerHTML;
    let result;
    let num = document.querySelectorAll(".lecture_boardNum");
    num = num[i].value;
    let id = document.querySelectorAll(".l_board_id");
    id = id[i].innerHTML;
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "/board/l_heart");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("num=" + num + "&id=" + id);
    xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        result = xhttp.responseText.trim();

        if (result == 1) {
          like_btn[i].setAttribute("style", "color:#FFCD28");
          count_text[i].innerHTML = ++count_text_value;
        } else {
          like_btn[i].setAttribute("style", "color: rgb(73, 71, 71)");
          count_text[i].innerHTML = --count_text_value;
        }
      }
    };
  });
}

//추천 수 조회
function getHeartCount() {
  const heart_text = document.getElementsByClassName("heart_text");
  const xhttp = new XMLHttpRequest();
  xhttp.open("GET", "/board/l_heartCount?num=" + num);
  console.log(num);
  xhttp.send();
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      let result = xhttp.responseText;
      heart_text.innerHTML = result;
    }
  };
}