const style1={border:"2px solid red",color:"red"};
const style2={border:"2px solid orange",color:"orange"};
const style3={border:"2px solid yellow",color:"yellow"};
const style4={border:"2px solid green",color:"green"};
const style5={border:"2px solid blue",color:"blue"};

//siblings():선택한 요소의 형제 요소를 모두 선택
//h2태그에 형제 요소에 스타일을 style1으로 설정
$("h2").siblings().css(style1);

//siblings("매개변수(css선택자")
//선택한 요소의 형제 요소 중에서 
//매개변수로 작성된 요소만 선택
//h2 태그 요소 중 p태그만 style2를 적용
$("h2").siblings("p").css(style2);

//next() : 선택된 요소의 다음 형제 요소를 선택하는 메소드 
//span 태그 다음에 오는 형제 요소의 스타일을 style3로 설정 
$("span").next().css(style3);

//nextAll() : 선택된 요소의 다음 모든 형제 요소를 선택하는 메소드 
//h2태그 다음에 오는 모든 형제 요소의 스타일을 style4로 설정
$("h2").nextAll().css(style4);

//nextUntil("매개변수(CSS선택자")
//선택된 요소 다음부터 매개변수로 작성된 형제관계 요소 이전까지를 모두 선택
//span태그부터 h3태그까지 폰트 크기를 30px로 변경
$("p").nextUntil("p").css("fontSize","30px");

//is("CSS선택자")
//지정된 범위내에 매개변수로 지정된 선택자와 일치하는 요소가 
//존재하는지 확인하는 메소드
//존재하면 true , 없으면 false를 반환
//h2 태그 이전에 있는 모든 형제 요소 중 p 태그가 있는지 확인
console.log($("h2").prevAll().is("p"));

//h2태그 이전에 있는 모든 형제 요소 중 pre 태그 있는지 확인 
console.log($("h2").prevAll().is("pre"));

$("span").on("click",function(){
    console.log("span태그 클릭됨");
    console.log($("span"));

    console.log($(this));
    console.log(this);

    //이벤트 핸들러(이벤트 발생 시 동작을 지정하는 함수)
    //내부에 작성된 this 라는 단어는 이벤트가 발생한 요소를 나타낸다.
})

//h2태그를 클릭했을때
//클릭한 요소의 이전 요소의 배경색을 red, 글자를 white로 설정

$("h2").on("click", function() {
    $(this).prev().css({"backgroundColor": "red","color": "white"});
})

