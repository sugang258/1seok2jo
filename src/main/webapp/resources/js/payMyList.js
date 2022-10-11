let linkStatus = document.querySelectorAll(".linkStatus");

for(let i=0;i<linkStatus.length;i++){
    linkStatus[i].addEventListener("click", function(){
        let p_uid = linkStatus[i].getAttribute("data-puid");
        location.href="/pay/status?p_uid="+p_uid;
    })
}