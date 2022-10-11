const list_contents = document.getElementsByClassName("list_contents");

let str = list_contents[0].innerHTML;

function init() {
  for (c of list_contents) {
    str = removeHTML(c.innerHTML);
    c.innerHTML = str;
  }
}

function removeHTML(text) {
  text = text.replace(/<br\/>/gi, "\n");
  text = text.replace(/<(\/)?([a-zA-Z]*)(\s[a-zA-Z]*=[^>]*)?(\s)*(\/)?>/gi, "");
  text = text.replace(/(<([^>]+)>)/gi, ""); // 태그 제거
  text = text.replace(/\s\s+/g, " "); // 연달아 있는 줄바꿈, 공백, 탭을 공백 1개로 줄임
  return text;
}
