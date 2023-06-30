$(document).ready(function(){

    //parent():선택된 요소의 바로 상위 요소(부모)를 선택
    //span 태그의 부모요소의 테두리 글자색 변경 

    $("span").parent().css("border","2px solid red").css("color","red");

    //li 태그의 모든 상위요소의 글자색을 파란색으로 변경
    $("li").parents().css("color","blue");

    //li 태그의 상위요소 중 div만 선택하여 테두리 변경
    $("li").parents("div").css("border","2px dashed magenta");

    //span 태그부터 상위 요소 중 
    //div 태그를 만나기 이전까지 요소를 선택하여 배경색 변경 
    $("span").parentsUntil("div").css("backgroundColor","pink")
    

})