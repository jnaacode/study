$(document).ready(function(){
    //id가 test인 요소의 테두리가 2px 빨간 실선, 글자를 파란색으로 변경
    //$("#test").css("border","2px solid red").css("color","blue");

    // 자바스크립트 객체를 매개변수로 전달하는 방법
    $("#test").css({border:"2px solid red",color:"blue"});
})

//css()매개변수로 사용할 코드를 미리 변수에 저장 
const style1={border:"2px solid red",color:"red"};
const style2={border:"2px solid orange",color:"orange"};
const style3={border:"2px solid yellow",color:"yellow"};
const style4={border:"2px solid green",color:"green"};
const style5={border:"2px solid blue",color:"blue"};

$(function(){
    $("#test").css(style5);
})

//-------------------------------------------------------------------

//children() : 선택된 요소의 바로 하위 요소(자식)를 선택하는 메소드
//클래스가 wrap인 요소의 자식 스타일을 style1로 설정
$(".wrap").children().css(style1);

//ul,p태그의 스타일을 style2로 설정
//$(".type").children().css(style2);
$(".wrap").children().children().css(style2);

//children("매개변수(CSS선택자)")
//선택된 자식 요소 중 "선택자"와 일치하는 자식만 선택

//클래스가 type인 요소 중 자식 중 ul 태그의 스타일을 style3로 설정
$(".type").children("ul").css(style3);

//클래스가 wrap인 요소를 기준으로 li태그의 스타일을 style4로 설정
$(".wrap").children(".type").children("ul").children("li").css(style4);

//find("매개변수(CSS선택자)")
//선택된 요소의 후손 중 매개변수로 작성된 선택자와 일치하는 모든 요소를 선택 

//클래스가 wrap인 요소의 후손 중 모든 span태그의 스타일 style5로 설정
$(".wrap").fine("span").css(style5);