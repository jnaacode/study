$(document).ready(function(){
    const arr = document.getElementsByTagName("p");
    for(let item of arr){
        item.style.color="pink";
    }
})

$("#check").on("click",function(){

    // name 속성값이 gender인 요소 중 check된 요소를 선택
    // .checked -> check 된 요소만 선택
    const gender = $("input[name='gender']:checked");

})