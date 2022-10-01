const t_btn = document.getElementsByClassName("t_btn");
const toggle_box = document.getElementsByClassName("toggle_box");
const minus = document.getElementsByClassName("minus");
const plus = document.getElementsByClassName("plus");
const line_box = document.getElementsByClassName("line_box");
const cate = document.getElementsByClassName("cate");
const lec = document.getElementById("lec");
const man = document.getElementById("man");
const rec = document.getElementById("rec");
const sign = document.getElementById("sign");

for (let i = 0; i < cate.length; i++) {
  cate[i].addEventListener("click", function () {
    if (cate[i].innerHTML == "강의상세") {
      lec.setAttribute("style", "color:black");
      man.style.color = "grey";
      rec.style.color = "grey";
      sign.style.color = "grey";
    } else if (cate[i].innerHTML == "계정관리") {
      man.setAttribute("style", "color:black");
      lec.style.color = "grey";
      rec.style.color = "grey";
      sign.style.color = "grey";
    } else if (cate[i].innerHTML == "기기 및 재생환경") {
      rec.setAttribute("style", "color:black");
      lec.style.color = "grey";
      man.style.color = "grey";
      sign.style.color = "grey";
    } else if (cate[i].innerHTML == "결제") {
      sign.setAttribute("style", "color:black");
      lec.style.color = "grey";
      man.style.color = "grey";
      rec.style.color = "grey";
    }
  });
}

for (let i = 0; i < t_btn.length; i++) {
  t_btn[i].addEventListener("click", function () {
    if (toggle_box[i].style.display == "none") {
      toggle_box[i].style.display = "block";
      plus[i].style.display = "none";
      minus[i].style.display = "block";
      line_box[i].style.display = "block";
    } else {
      toggle_box[i].style.display = "none";
      plus[i].style.display = "block";
      minus[i].style.display = "none";
      line_box[i].style.display = "none";
    }
  });
}

const t_btn2 = document.getElementsByClassName("t_btn2");
const toggle2_box = document.getElementsByClassName("toggle2_box");
const minus2 = document.getElementsByClassName("minus2");
const plus2 = document.getElementsByClassName("plus2");
const line2_box = document.getElementsByClassName("line2_box");

for (let i = 0; i < t_btn2.length; i++) {
  t_btn2[i].addEventListener("click", function () {
    if (toggle2_box[i].style.display == "none") {
      toggle2_box[i].style.display = "block";
      plus2[i].style.display = "none";
      minus2[i].style.display = "block";
      line2_box[i].style.display = "block";
    } else {
      toggle2_box[i].style.display = "none";
      plus2[i].style.display = "block";
      minus2[i].style.display = "none";
      line2_box[i].style.display = "none";
    }
  });
}

const t_btn3 = document.getElementsByClassName("t_btn3");
const toggle3_box = document.getElementsByClassName("toggle3_box");
const minus3 = document.getElementsByClassName("minus3");
const plus3 = document.getElementsByClassName("plus3");
const line3_box = document.getElementsByClassName("line3_box");

for (let i = 0; i < t_btn3.length; i++) {
  t_btn3[i].addEventListener("click", function () {
    if (toggle3_box[i].style.display == "none") {
      toggle3_box[i].style.display = "block";
      plus3[i].style.display = "none";
      minus3[i].style.display = "block";
      line3_box[i].style.display = "block";
    } else {
      toggle3_box[i].style.display = "none";
      plus3[i].style.display = "block";
      minus3[i].style.display = "none";
      line3_box[i].style.display = "none";
    }
  });
}

const t_btn4 = document.getElementsByClassName("t_btn4");
const toggle4_box = document.getElementsByClassName("toggle4_box");
const minus4 = document.getElementsByClassName("minus4");
const plus4 = document.getElementsByClassName("plus4");
const line4_box = document.getElementsByClassName("line4_box");

for (let i = 0; i < t_btn4.length; i++) {
  t_btn4[i].addEventListener("click", function () {
    if (toggle4_box[i].style.display == "none") {
      toggle4_box[i].style.display = "block";
      plus4[i].style.display = "none";
      minus4[i].style.display = "block";
      line4_box[i].style.display = "block";
    } else {
      toggle4_box[i].style.display = "none";
      plus4[i].style.display = "block";
      minus4[i].style.display = "none";
      line4_box[i].style.display = "none";
    }
  });
}
