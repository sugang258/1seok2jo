const fileAdd = document.querySelector("#fileAdd");
const addFiles = document.querySelector("#addFiles");

let count = 0;
let idx = 0;

try {
fileAdd.addEventListener("click",function(){
    // <div class="mt-4 mb-3">
    //      <label for="formFile" class="form-label" name="formFile">강의 썸네일 사진</label>
    //      <input class="form-control" type="file" id="formFile">
    // </div>

    let d = document.createElement("div");
    let c = document.createAttribute("class");
    c.value = "mt-4 mb-3";
    d.setAttributeNode(c);
    c= document.createAttribute("id");
    c.value = "file"+idx;
    d.setAttributeNode(c);
    let d1 = document.createElement("div");
    let l = document.createElement("label");
    let f = document.createAttribute("for");
    f.value = "files";
    let c1 = document.createAttribute("class");
    c1.value = "form-label";
    let t = document.createTextNode("File");

    l.setAttributeNode(f);
    l.setAttributeNode(c1);
    l.appendChild(t);

    d1.appendChild(l);
    d.appendChild(d1);

    let d2 = document.createElement("div");
    let i = document.createElement("input");
    let c2 = document.createAttribute("class");
    c2.value = "form-label";
    let t1 = document.createAttribute("type");
    t1.value="file";
    let i1 = document.createAttribute("id");
    i1.value = "files";
    let n = document.createAttribute("name");
    n.value = "formFile"

    i.setAttributeNode(c2);
    i.setAttributeNode(t1);
    i.setAttributeNode(i1);
    i.setAttributeNode(n);

    d2.appendChild(i);
    d.appendChild(d2);

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
    t3.value = idx;
    b.setAttributeNode(t3);

    d3.appendChild(b);
    d.appendChild(d3)

    addFiles.appendChild(d);

    idx++;

})

addFiles.addEventListener("click",function(event){
    let button = event.target;

    if(button.classList[0] == 'del') {
        document.getElementById("file"+button.title).remove();

    }

});

}catch (e) {

};