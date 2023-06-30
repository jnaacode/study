/* 아이디 : 값이 변했을 때 
영어 소문자로 시작하고, 
영어 대/소문자, 숫자, - , _ 로만 이루어진 6~14 글자 사이 문자열인지 검사
아이디 정규표현식 : (각자 작성)

- 형식이 일치할 경우
입력창의 배경색을 green 으로 변경

- 형식이 일치하지 않은 경우
입력창의 배경색을 red, 글자색을 white 로 변경*/

document.getElementById("id-btn").addEventListener("keyup",function(){

    const regExp = /^[a-z](\w|[A-Z]|[0-9]|\-|\_){5,13}$/;

    if(regExp.test(this.value)){
        this.classList.remove("red");
        this.classList.add("green");
    }else{
        this.classList.add("red");
        this.classList.add("white");
        this.classList.remove("green");
    }
})

// ------------------------------------------------------------------

/* 비밀번호, 비밀번호 확인 : 키보드가 올라올 때 
"비밀번호" 를 미입력한 상태에서 "비밀번호 확인"을 작성할 경우
"비밀번호 확인"에 작성된 내용을 모두 삭제하고
'비밀번호를 입력해주세요' 경고창 출력 후
focus 를 "비밀번호" 입력창으로 이동
*/
document.getElementById("pw-2").addEventListener("keyup",function(){

    const pw = document.getElementById("pw-1");

    if(pw.value == ""){
        this.value="";
        alert("비밀번호 입력해주세요");
        pw.focus();
    }

})
// ------------------------------------------------------------------

/*
- 비밀번호가 일치할 경우
"비밀번호" 입력창 오른쪽에 "비밀번호 일치" 글자를 초록색으로 출력.

- 비밀번호가 일치하지 않을 경우
"비밀번호" 입력창 오른쪽에 "비밀번호가 불일치" 글자를 빨간색으로 출력

- 비밀번호가 작성되지 않은경우 오른쪽에 출력되는 문구 삭제
*/

document.getElementById("pw-2").addEventListener("keyup",function(){


    const span = document.getElementById("pw-text");
    const pw = document.getElementById("pw-1");

    if(this.value == pw.value){
        span.innerText = "일치";
        span.style.color="green";
    }else{
        span.innerText = "불일치";
        span.style.color="red";
    }




})

// -------------------------------------------------------------

/* 이름 : 값이 변화했을 때 
한글 2~5 글자 사이 문자열인지 검사.
- 형식이 일치할 경우
"이름" 입력창 오른쪽에 "정상입력" 글자를 초록색으로 출력.
- 형식이 일치할 경우
"이름" 입력창 오른쪽에 "한글만 입력하세요" 글자를 빨간색으로 출력.
*/

document.getElementById("name").addEventListener("keyup",function(){

    const regExp = /^[가-힣]{2,5}$/;
    const span = document.getElementById("name-text");

    if(regExp.test(this.value)){
        span.innerText = "정상입력";
        span.style.color="green";
    }else{
        span.innerText ="한글만 입력하세요.";
        span.style.color="red";
    }
})

// -----------------------------------------------------------

/* 회원가입 버튼 클릭 시 : validate() 함수를 호출하여 
성별이 선택 되었는지, 전화번호가 형식에 알맞게 작성되었는지 검사 */

function validate(){

    /*- 성별이 선택되지 않은 경우 
    "성별을 선택해주세요." 경고창(==대화상자) 출력 후
    submit 기본 이벤트를 제거하여 회원가입이 진행되지 않게 함.*/

    

    /*
    - 전화번호 형식이 올바르지 않을 경우 
    "전화번호의 형식이 올바르지 않습니다" 경고창(==대화상자) 출력 후
    submit 기본 이벤트를 제거하여 회원가입이 진행되지 않게 함.
    */




}