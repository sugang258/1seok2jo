const video_add = document.querySelector("#video_add");
const video_adds = document.querySelector(".video_adds");
const video_del = document.querySelectorAll("#video_del");
const video_dels = document.querySelectorAll(".video_dels");
const img_change = document.querySelector("#img_change");
const img_changee = document.querySelector(".img_change");
const video_change = document.querySelector(".video_change");
const ot_change = document.querySelector("#ot_change");
const setFileUpdate = document.querySelector("#setFileUpdate");
const ori_img = document.querySelector("#ori_img");
const update = document.querySelector("#update");
const update_sub = document.querySelector("#update_sub");
const cc = document.querySelector("#c_num");
const c_num = document.querySelector(".c_num");
const category = document.querySelectorAll(".category");
const level_num = document.querySelector("#level_num");
const level=document.querySelectorAll(".level")
const files = document.querySelector("#files");
const file_sub = document.querySelector("#file_sub");

let count = 0;
let idx=0;

function setCount(ct) {
    if(ct>=0) {
        count=ct;
    }
}
let c1 = cc.getAttributeNode("data-c-num").value;
console.log(c1);
category.forEach(function(c){
    console.log(c.value == c1);
    if(c.value == c1) {
        c.setAttribute("selected",true);
    }
})

let l1 = level_num.getAttributeNode("data-level-num").value;
console.log(l1);
level.forEach(function(l){
    if(l.value == l1) {
        l.setAttribute("selected",true);
    }
})

//비디오 추가
video_add.addEventListener("click",function(){

    let d = document.createElement("div");
    let c = document.createAttribute("class");
    c.value = "mt-4 mb-3";
    d.setAttributeNode(c);
    c= document.createAttribute("id");
    c.value = "video"+count;
    d.setAttributeNode(c);
    //-----------------------------------------------------
    let d1 = document.createElement("div");
    let l = document.createElement("label");
    let f = document.createAttribute("for");
    f.value = "v_url";
    let c1 = document.createAttribute("class");
    c1.value = "form-label";
    let t = document.createTextNode("동영상 url 주소");

    l.setAttributeNode(f);
    l.setAttributeNode(c1);
    l.appendChild(t);

    d1.appendChild(l);
    d.appendChild(d1);

    //-------------------------------------------------------
    let d2 = document.createElement("div");
    let i = document.createElement("input");
    let c2 = document.createAttribute("class");
    c2.value = "form-control";
    let t1 = document.createAttribute("type");
    t1.value="text";
    let i1 = document.createAttribute("id");
    i1.value = "v_url";
    let n = document.createAttribute("name");
    n.value = "v_url"

    i.setAttributeNode(c2);
    i.setAttributeNode(t1);
    i.setAttributeNode(i1);
    i.setAttributeNode(n);

    d2.appendChild(i);
    d.appendChild(d2);

//     //--------------------------------------------------------------
    let d4 = document.createElement("div");
    let l1 = document.createElement("label");
    let f1 = document.createAttribute("for");
    f1.value = "v_context";
    let c4 = document.createAttribute("class");
    c4.value = "form-label";
    let t4 = document.createTextNode("동영상 제목");

    l1.setAttributeNode(f1);
    l1.setAttributeNode(c4);
    l1.appendChild(t4);

    d4.appendChild(l1);
    d.appendChild(d4);

//     //------------------------------------------------------
    let d5 = document.createElement("div");
    let i2 = document.createElement("input");
    let c5 = document.createAttribute("class");
    c5.value = "form-control";
    let t5 = document.createAttribute("type");
    t5.value="text";
    let i3 = document.createAttribute("id");
    i3.value = "v_context";
    let n1 = document.createAttribute("name");
    n1.value = "v_context";

    i2.setAttributeNode(c5);
    i2.setAttributeNode(t5);
    i2.setAttributeNode(i3);
    i2.setAttributeNode(n1);

    d5.appendChild(i2);
    d.appendChild(d5);

    let d3 = document.createElement("div");
    let b = document.createElement("button");
    let c3 = document.createAttribute("class");
    c3.value = "del btn btn-danger";
    let t2 = document.createTextNode("삭제");
    let t3 = document.createAttribute("type");
    t3.value="button";


    b.setAttributeNode(c3);
    b.setAttributeNode(t3);
    b.appendChild(t2);


    t3 = document.createAttribute("title");
    t3.value = count;
    b.setAttributeNode(t3);

    d3.appendChild(b);
    d.appendChild(d3)

      video_adds.appendChild(d);

     count++;

});

video_adds.addEventListener("click",function(event){
    let button = event.target;

    if(button.classList[0] == 'del') {
        document.getElementById("video"+button.title).remove();
        
    }

});

//비디오 삭제
video_dels.forEach(function(video_del){
    video_del.addEventListener("click",function(event){
        let check = window.confirm("삭제하시겠습니까?");
        let v = event.target.parentNode.parentNode;
        console.log(v);
        
        //check = true면 ajax로 v_num 보내서 삭제
        if(check) {
            let v_num = video_del.getAttributeNode("data-del-num").value;
            //console.log(v_num);
            const xhttp = new XMLHttpRequest();

            xhttp.open("POST","../lecture/setVideoDelete");
    
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    
            
            xhttp.send("v_num="+v_num);
    
            xhttp.onreadystatechange = function() {
                if(this.readyState == 4 && this.status == 200) {
                    let result = xhttp.responseText.trim();
                    console.log(result);
                    
                    result = JSON.parse(result);
                    if(result == 1) {
                            v.remove();
                            
                        alert("동영상 삭제 성공");
                                
                            
                    }else {
                        alert("동영상 삭제 실패");
                    }
                }
        }
        
    }else {
        alert("동영상 삭제 취소");
    }

    })

})

//ot 비디오 변경
let countt = 0;
ot_change.addEventListener("click",function(){
    if(countt>0) {
        alert("추가 안됩니다.");
    }else{

        let form = document.createElement("form");
        let action = document.createAttribute("action");
        action.value ="setVideoUpdate";
        let id = document.createAttribute("id");
        id.value = "setVideoUpdate";
        let method = document.createAttribute("method");
        method.value="post";
        let enctype = document.createAttribute("enctype");
        enctype.value="multipart/form-data"
        
        let d = document.createElement("div");
        let c = document.createAttribute("class");
        c.value = "mt-4 mb-3";
        d.setAttributeNode(c);
        c= document.createAttribute("id");
        c.value = "video"+count;
        d.setAttributeNode(c);
        //-----------------------------------------------------
        let d1 = document.createElement("div");
        let l = document.createElement("label");
        let f = document.createAttribute("for");
        f.value = "v_url";
        let c1 = document.createAttribute("class");
        c1.value = "form-label";
        let t = document.createTextNode("동영상 url 주소");

        l.setAttributeNode(f);
        l.setAttributeNode(c1);
        l.appendChild(t);

        d1.appendChild(l);
        d.appendChild(d1);

        //-------------------------------------------------------
        let d2 = document.createElement("div");
        let i = document.createElement("input");
        let c2 = document.createAttribute("class");
        c2.value = "form-control";
        let t1 = document.createAttribute("type");
        t1.value="text";
        let i1 = document.createAttribute("id");
        i1.value = "v_url";
        let n = document.createAttribute("name");
        n.value = "v_url"

        i.setAttributeNode(c2);
        i.setAttributeNode(t1);
        i.setAttributeNode(i1);
        i.setAttributeNode(n);

        d2.appendChild(i);
        d.appendChild(d2);

    //     //--------------------------------------------------------------
        let d4 = document.createElement("div");
        let l1 = document.createElement("label");
        let f1 = document.createAttribute("for");
        f1.value = "v_context";
        let c4 = document.createAttribute("class");
        c4.value = "form-label";
        let t4 = document.createTextNode("동영상 제목");

        l1.setAttributeNode(f1);
        l1.setAttributeNode(c4);
        l1.appendChild(t4);

        d4.appendChild(l1);
        d.appendChild(d4);

    //     //------------------------------------------------------
        let d5 = document.createElement("div");
        let i2 = document.createElement("input");
        let c5 = document.createAttribute("class");
        c5.value = "form-control";
        let t5 = document.createAttribute("type");
        t5.value="text";
        let i3 = document.createAttribute("id");
        i3.value = "v_context";
        let n1 = document.createAttribute("name");
        n1.value = "v_context";

        i2.setAttributeNode(c5);
        i2.setAttributeNode(t5);
        i2.setAttributeNode(i3);
        i2.setAttributeNode(n1);

        d5.appendChild(i2);
        d.appendChild(d5);

        let div = document.createElement("div");
        let button = document.createElement("button");
        let cl = document.createAttribute("class");
        cl.value = "change btn btn-danger mb-2";
        let text = document.createTextNode("변경 확정");
        let type = document.createAttribute("type");
        type.value="button";
    
        button.setAttributeNode(cl);
        button.setAttributeNode(type);
        button.appendChild(text);
    
        type = document.createAttribute("title");
        type.value = count;
        button.setAttributeNode(type);
    
        div.appendChild(button);
        d.appendChild(div);

        let d3 = document.createElement("div");
        let b = document.createElement("button");
        let c3 = document.createAttribute("class");
        c3.value = "vdel btn btn-danger";
        let t2 = document.createTextNode("삭제");
        let t3 = document.createAttribute("type");
        t3.value="button";



        b.setAttributeNode(c3);
        b.setAttributeNode(t3);
        b.appendChild(t2);

        t3 = document.createAttribute("title");
        t3.value = count;
        b.setAttributeNode(t3);

        d3.appendChild(b);
        d.appendChild(d3)

        form.appendChild(d);

        video_change.appendChild(form);

        console.log(countt);
        countt++

    }
})

video_change.addEventListener("click",function(event){
    let button = event.target;

    if(button.classList[0] == 'vdel') {
        document.getElementById("video"+button.title).remove();
        countt--
        
    }

    if(button.classList[0] == 'change') {
        
        let check = window.confirm("변경확정하시겠습니까?(기존에 있던 동영상은 삭제됩니다.)");
        
        if(check) {
            let v_num = ot_change.getAttributeNode("data-video-num").value;
            let v_url = button.parentNode.parentNode.parentNode.childNodes[0].childNodes[1].firstChild.value;
            let v_context = button.parentNode.parentNode.parentNode.childNodes[0].childNodes[3].firstChild.value;

            console.log(v_url);
            console.log(v_context);

            const xhttp = new XMLHttpRequest();

            xhttp.open("POST","../lecture/setVideoUpdate");
    
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    
            
            xhttp.send("v_url="+v_url+"&v_context="+v_context+"&v_num="+v_num);
    
            xhttp.onreadystatechange = function() {
                if(this.readyState == 4 && this.status == 200) {
                    let result = xhttp.responseText.trim();
                    console.log(result);
                    
                    result = JSON.parse(result);
                    if(result == 1) {
                        
                        alert("OT 동영상 변경 성공");
                        
                    }else {
                        alert("OT 동영상 변경 실패");
                    }
                }
        }
        
    }else {
        alert("OT 동영상 변경 취소");
    }


        }

});

//썸네일 이미지 변경
// img_change.addEventListener("click",function(){

//     if(idx>0) {
//         alert("추가 안됩니다.");
//     }else {
        
        
//         // let form = document.createElement("form");
//         // let action = document.createAttribute("action");
//         // action.value ="setFileUpdate";
//         // let id = document.createAttribute("id");
//         // id.value = "setFileUpdate";
//         // let method = document.createAttribute("method");
//         // method.value="post";
//         // let enctype = document.createAttribute("enctype");
//         // enctype.value="multipart/form-data"

//         // form.setAttribute(action);
//         // form.setAttribute(id);
//         // form.setAttribute(method);
//         // form.setAttribute(enctype);
        
//         let d = document.createElement("div");

//         let c = document.createAttribute("class");
//         c.value = "mt-4 mb-3";
//         d.setAttributeNode(c);
//         c= document.createAttribute("id");
//         c.value = "file"+idx;
//         d.setAttributeNode(c);
//         let d1 = document.createElement("div");
//         let l = document.createElement("label");
//         let f = document.createAttribute("for");
//         f.value = "files";
//         let c1 = document.createAttribute("class");
//         c1.value = "form-label";
//         let t = document.createTextNode("File");

//         l.setAttributeNode(f);
//         l.setAttributeNode(c1);
//         l.appendChild(t);

//         d1.appendChild(l);
//         d.appendChild(d1);

//         let d2 = document.createElement("div");
//         let i = document.createElement("input");
//         let c2 = document.createAttribute("class");
//         c2.value = "form-label";
//         let t1 = document.createAttribute("type");
//         t1.value="file";
//         let i1 = document.createAttribute("id");
//         i1.value = "files";
//         let n = document.createAttribute("name");
//         n.value = "files";

//         i.setAttributeNode(c2);
//         i.setAttributeNode(t1);
//         i.setAttributeNode(i1);
//         i.setAttributeNode(n);

//         d2.appendChild(i);
//         d.appendChild(d2);

//         let div = document.createElement("div");
//         let button = document.createElement("button");
//         let cl = document.createAttribute("class");
//         cl.value = "change btn btn-danger mb-2";
//         let text = document.createTextNode("변경 확정");
//         let type = document.createAttribute("type");
//         type.value="button";

//         button.setAttributeNode(cl);
//         button.setAttributeNode(type);
//         button.appendChild(text);

//         type = document.createAttribute("title");
//         type.value = count;
//         button.setAttributeNode(type);

//         div.appendChild(button);
//         d.appendChild(div);

//         let d3 = document.createElement("div");
//         let b = document.createElement("button");
//         let c3 = document.createAttribute("class");
//         c3.value = "idel btn btn-danger";
//         let t2 = document.createTextNode("삭제");
//         let t3 = document.createAttribute("type");
//         t3.value="button";


//         b.setAttributeNode(c3);
//         b.setAttributeNode(t3);
//         b.appendChild(t2);


//         t3 = document.createAttribute("title");
//         t3.value = idx;
//         b.setAttributeNode(t3);

//         d3.appendChild(b);
//         d.appendChild(d3);

//         //form.appendChild(d);

//         img_changee.appendChild(d);

//         idx++;
//         }


// })

// img_changee.addEventListener("click",function(event){
//     let button = event.target;

//     if(button.classList[0] == 'idel') {
//         document.getElementById("file"+button.title).remove();
//         idx--;

//     }

    // if(button.classList[0] == 'change') {
    //     let check = window.confirm("변경 확정하시겠습니까? (기존에 있던 사진은 삭제됩니다.)");
    //     let num = img_change.getAttributeNode("data-f-num").value;
    //     let f_name = ori_img.getAttributeNode("data-file-num").value;
    //     let f_oriname = ori_img.getAttributeNode("data-ori-num").value;
    //     let update = button.parentNode.parentNode.parentNode.parentNode;
    //     let l_num = update_sub.getAttributeNode("data-l-num").value;
        
    //     console.log(update);

    //     // var formData = new FormData();
    //     // var inputFile = $("input[name='files']");
    
    //     // var files = inputFile[0].files;

    //     // console.log(files);
    //     // console.log(inputFile);

    //     console.log(f_oriname);
    //     console.log(f_name);
    //     console.log(num);

    //     if(check) {



        //     const xhttp = new XMLHttpRequest();

        //     xhttp.open("POST","../lecture/setFileUpdate");
    
        //     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    
            
        //     xhttp.send("f_name="+f_name+"&f_oriname="+f_oriname+"&num="+num);
    
        //     xhttp.onreadystatechange = function() {
        //         if(this.readyState == 4 && this.status == 200) {
        //             let result = xhttp.responseText.trim();
        //             console.log(result);
                    
        //             result = JSON.parse(result);
        //             if(result == 1) {
                        
        //                 alert("썸네일 사진 변경 성공");
        //                 setFileUpdate.submit();
                                
                            
        //             }else {
        //                 alert("썸네일 사진 변경 실패");
        //             }
        //         }
        // }
//         setFileUpdate.submit();
        
        
        
//     }else {
//         alert("썸네일 사진 변경 취소");
//     }

//        }
    

// });

const setAddVideo = document.querySelector("#setAddVideo");


files.addEventListener("change",function(){
    let filedata = new FormData();
    filedata.append("file",files.files[0]);
    filedata.append("path","lecture");

    $.ajax({
        type:"POST",
        enctype: "multipart/form/data",
        url: "http://20.249.88.100/uploadFile",
        data: filedata,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,

        success: function(dt) {
            console.log(dt);
            console.log(files.files[0].name)

            let inputf_name = document.createElement("input")
                let typei = document.createAttribute("type")
                typei.value="text"
                let typei2 = document.createAttribute("name")
                typei2.value="oriname"
                let typei3 = document.createAttribute("class")
                typei3.value = "form-control"
                let typei4 = document.createAttribute("value")
                typei4.value= files.files[0].name
                let typei5 = document.createAttribute("readonly")
    
                inputf_name.setAttributeNode(typei)
                inputf_name.setAttributeNode(typei2)
                inputf_name.setAttributeNode(typei3)
                inputf_name.setAttributeNode(typei4)
                inputf_name.setAttributeNode(typei5)
                
                img_changee.append(inputf_name)
    
                //fname input
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
                
                img_changee.append(inputf_name);
        },
        error: function(e){
            alert('파일 업데이트 실패');
        }
    })
})

file_sub.addEventListener("click",function(){
    let check = window.confirm("썸네일 변경 확정하시겠습니까?");

    if(check){
        setFileUpdate.submit();
    }else{
        alert("썸네일 변경 취소");
    }
})

function updateCheck() {

    const l_date = document.querySelector("#l_date");
    const l_price = document.querySelector("#l_price");
    const div1 = document.querySelector("#div1");
    const div2 = document.querySelector("#div2");
    const l_name = document.querySelector("#l_name");
    const div3 = document.querySelector("#div3");
    const l_contents = document.querySelector("#l_contents");
    const div4 = document.querySelector("#div4");
    const c_num = document.querySelector("#c_num");
    const div5 = document.querySelector("#div5");
    const level_num = document.querySelector("#level_num");
    const div6 = document.querySelector("#div6");
    const update_sub = document.querySelector("#update_sub");
    const update_ele = document.getElementsByClassName("update_ele");
    const update = document.querySelector("#update");

    let titleCheck = true;
    let contentCheck = true;
    let categoryCheck = true;
    let levelCheck = true;
    let dateCheck = true;
    let priceCheck = true;
    
    var pattern_num = /[1-9999999]/; //숫자
    var pattern_eng = /[a-zA-Z]/;	// 문자 
    var pattern_spc = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자
    var pattern_kor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/; // 한글체크

    l_name.addEventListener("blur",function(){
        if(l_name.value.length < 1) {
            div3.innerHTML="강의 제목을 작성해주세요";
            titleCheck = false;
        }else{
            div3.innerHTML="";
            titleCheck = true;
        }
    })

    l_contents.addEventListener("blur",function(){
        if(l_contents.value.length<1){
            div4.innerHTML="강의 내용을 작성해주세요";
            contentCheck = false;
        }else{
            div4.innerHTML="";
            contentCheck = true;
        }
    })

    c_num.addEventListener("blur",function(){
        if(c_num.value){
            div5.innerHTML="";
            categoryCheck = true;
        }else{
            div5.innerHTML="카테고리를 선택해주세요";
            categoryCheck = false;
        }
    })

    level_num.addEventListener("blur",function(){
        if(level_num.value){
            div6.innerHTML="";
            levelCheck = true;
        }else{
            div6.innerHTML="난이도를 선택해주세요";
            levelCheck = false;
        }
    })
    
    l_date.addEventListener("blur",function(){
        console.log("blur");
        console.log(l_date.value);
        if((pattern_num.test(l_date.value)) && !(pattern_eng.test(l_date.value)) && !(pattern_spc.test(l_date.value)) && !(pattern_kor.test(l_date.value))) {
            console.log("true");
            div1.innerHTML="";
            dateCheck = true;
        } else{
            console.log("false");
            div1.innerHTML = "❗숫자만 작성해주세요";
            l_date.value="";
            dateCheck = false;
        }
        
    });
    
    l_price.addEventListener("blur",function(){
        console.log("blur");
        console.log(l_price.value);
        if((pattern_num.test(l_price.value)) && !(pattern_eng.test(l_price.value)) && !(pattern_spc.test(l_price.value)) && !(pattern_kor.test(l_price.value))) {
            console.log("true");
            div2.innerHTML="";
            priceCheck = true;
        } else{
            console.log("false");
            div2.innerHTML = "❗숫자만 작성해주세요";
            l_price.value="";
            priceCheck = false;
        }
        
    });

    update_sub.addEventListener("click",function(){
        
        console.log(update_ele.length);
        console.log(titleCheck);
        console.log(contentCheck);
        console.log(categoryCheck);
        console.log(levelCheck);
        console.log(dateCheck);
        console.log(priceCheck);
                if((titleCheck && contentCheck && categoryCheck && levelCheck && dateCheck && priceCheck) == false) {
                    alert("모든 칸을 작성해주세요");
                }else{
                    var str = document.getElementById("l_contents").value;
                    str = str.replace(/(?:\r\n|\r\n)/g,'<br />');
                    document.getElementById("l_contents").innerHTML = str;
                    update.submit();
                }
            
    })
}


