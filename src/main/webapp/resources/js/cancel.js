function cancelPay() {
    /* 취소요청 */

  const xhttp = new XMLHttpRequest();
  let p_uid = document.getElementById("p_uid");
  console.log("p_uid="+p_uid.value);

  xhttp.open("Post","/pay/cancel");
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
  xhttp.send("p_uid="+p_uid.value);
  xhttp.addEventListener("readystatechange", function(){
    if(this.readyState==4 && this.status==200){
      token = xhttp.responseText.trim();
    }
  })

}