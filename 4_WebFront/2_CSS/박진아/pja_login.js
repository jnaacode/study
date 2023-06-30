document.getElementById("inputmem").addEventListener("keyup",function(){

    const inputmem = document.getElementsByName("inputmem");

    if (!inputmem[0].checked && !inputmem[1].checked && !inputmem[2].checked) {
        alert("회원유형을 등록하세요.");
        return false;
    }


})

document.getElementById("joinsao").addEventListener("keyup",function(){

    const joinsao = document.getElementsByName("joinsao");

    if (!joinsao[0].checked && !joinsao[1].checked && !joinsao[2].checked) {
        alert("회원유형을 등록하세요.");
        return false;
    }


})




document.getElementsByClassName("joinsa").addEventListener("keyup",function(){

    const joinsa = document.getElementsByClassName("joinsa");

    if (joinsa==null) {
        alert("상호명을 입력하세요.");
        return false;
    }


})