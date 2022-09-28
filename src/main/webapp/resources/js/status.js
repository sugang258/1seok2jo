const bar = document.querySelectorAll("#bar");



bar.forEach(function(bar){
    let status = bar.getAttributeNode("aria-valuenow").value;
    let style = document.createAttribute("style");
    style.value = "width :"+status+"%"
    bar.setAttributeNode(style);

})




