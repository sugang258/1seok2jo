function save(){

    let file = document.getElementById("file");
    let addFile = document.getElementById("addFile")
    
    file.addEventListener("change", function(){
        let filedata = new FormData();
        filedata.append("file",file.files[0])
        //path 에 저장할 폴더 경로를 담아준다.
        filedata.append("path","member")
    
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "http://20.249.88.100/uploadFile",
            data: filedata,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (dt) {
                console.log("f_name : "+dt) //f_name
                console.log("f_oriname : "+file.files[0].name) //f_oriname
                // 라벨 하단에 file 값을 담은 text input을 만들어준다.

                //기존 파일을 한번 추가하면 인풋에 disabled값을 준다.
                let att = document.createAttribute("disabled")
                file.setAttributeNode(att)

                //f_oriname input
                let inputf_name = document.createElement("input")
                let typei = document.createAttribute("type")
                typei.value="text"
                let typei2 = document.createAttribute("name")
                typei2.value="f_oriname"
                let typei3 = document.createAttribute("class")
                typei3.value = "form-control"
                let typei4 = document.createAttribute("value")
                typei4.value= file.files[0].name
                let typei5 = document.createAttribute("readonly")
    
                inputf_name.setAttributeNode(typei)
                inputf_name.setAttributeNode(typei2)
                inputf_name.setAttributeNode(typei3)
                inputf_name.setAttributeNode(typei4)
                inputf_name.setAttributeNode(typei5)
                
                addFile.append(inputf_name)
    
                //f_name input
                inputf_name = document.createElement("input")
                typei = document.createAttribute("type")
                typei.value="text"
                typei2 = document.createAttribute("name")
                typei2.value="f_name"
                typei3 = document.createAttribute("style")
                typei3.value = "display: none"
                typei4 = document.createAttribute("value")
                typei4.value= dt
    
                inputf_name.setAttributeNode(typei)
                inputf_name.setAttributeNode(typei2)
                inputf_name.setAttributeNode(typei3)
                inputf_name.setAttributeNode(typei4)
                
                addFile.append(inputf_name)
            },
            error: function (e) {
                alert('파일 업로드 실패');
            }
        })
    });


}//save 끝

function delfile(){
    let delImg = document.querySelectorAll("#delImg");

    for(let i= 0; i<delImg.length; i++){
        delImg[i].addEventListener("click", function(){
            let f_name = delImg[i].getAttribute("data-name");
            let path = delImg[i].getAttribute("data-path");

            //Ajax로 삭제요청 전송
            const xhttp = new XMLHttpRequest();
            xhttp.open("POST","http://20.249.88.100/deleteFile");
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
            //path와 f_name 전송해줌
            xhttp.send("path="+path+"&f_name="+f_name)
            xhttp.addEventListener("readystatechange", function(){
                if(this.readyState==4 && this.status==200){
                    if(xhttp.responseText.trim()==1){
                        alert("삭제성공")
                    }else if(xhttp.responseText.trim()==0){
                        alert("삭제실패")
                    }
                }
            })


        })
    }
}