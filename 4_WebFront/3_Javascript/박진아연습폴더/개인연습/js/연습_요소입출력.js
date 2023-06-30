function accessId(){

    const div1 = document.getElementById("div1");

    const bgColor =div1.style.backgroundColor;

    if(bgColor == "red"){
        div1.style.backgroundColor="pink";
    }else{
        div1.style.backgroundColor="red";
    }
}

function accessClass(){
    const arr = document.getElementsByClassName("div2");

    arr[0].style.backgroundColor="pink";
    arr[0].innerText = "첫번째요소";

    arr[1].style.backgroundColor="green";
    arr[1].innerText = "2번째요소";

    arr[2].style.backgroundColor="red";
    arr[2].innerText = "3번째요소";

}

function accessTagName(){

    const arr = document.getElementsByTagName("li");
    for(let i =0;i<arr.length;i++){
        const num = arr[i].innerHTML;
        arr[i].style.backgroundColor="rgb(130,220, "+(210*num)+")";
    }
}

function inputTest(){

    const input = document.getElementById("input-test");
    input.value='';
    input.focus();
}

function accessName(){

    const hobbyList = document.getElementsByName("hobby");
    let str = "";
    let count = 0;

    for(let i= 0;i<hobbyList.length;i++){

        if(hobbyList[i].checked){
            str+=hobbyList[i].value+",";
            count++;
        }
        
    }
    document.getElementById("name-div").innerText=str;
    document.getElementById("name-div").innerText+= "<br>선택한 개수" + count;

}

function accessCss(){
    document.querySelector("#css-div").style.border = "3px solid red";
    document.querySelector("#css-div>div").style.fontSize = "30px";
    const arr = document.querySelectorAll("#css-div>div");

    for(let i=0;i<arr.length;i++){
        arr[i].style.backgroundColor="yellow";
    }

}

document.getElementById("btn1").addEventListener("click",function(){

    const nodeList = document.getElementById("test").childNodes


})