// 배열 확인1
document.getElementById("btn1").addEventListener("click",function(){
    
    //배열 선언 방법
    const arr1 = new Array(3); //3칸짜리 배열생성
    const arr2 = new Array();  //0칸짜리 배열(비어 있는 배열) 생성
    // console.log(arr1);
    // console.log(arr2);

    //다른 자료형 대입
    arr1[0]="김밥";
    arr1[1]=123;
    arr1[2]=true;

    console.log(arr1);

    //0칸 배열에 대입 -> 자동으로 길이 증가 
    arr2[0]="김밥";
    arr2[1]=123;
    arr2[2]=true;

    console.log(arr2);

    //배열 선언 방법
    const arr3 = []; // 비어있는 배열(0칸)
    const arr4 = ["사과","딸기","바나나"]; //선언 및 초기화

    // for 문으로 배열 요소 반복 접근하기
    // 1. 일반 for문
    // 2. 향상된 for문 (for..for):배열용 향상된 for문
    for(let item of arr4){ //arr4배열에서 요소를 하나씩 얻어와 item에 대입
        console.log(item);
    }

})

//배열확인2
document.getElementById("btn2").addEventListener("click",function(){

    // 비어있는 배열설정
    const arr=[];

    //push() : 배열 마지막 요소로 추가
    arr.push("삼겹살");
    arr.push("곱창");
    arr.push("막창");
    arr.push("대창");

    console.log(arr);

    //pop():배열 마지막 요소 꺼내오기 
    console.log("꺼내온 요소 : " + arr.pop());
    console.log(arr);

    // 배열.indexOf("값") : 일치하는 값을 가진 요소의 index를 반환
    console.log("곱창인덱스 : "+arr.indexOf("곱창")); //1
    console.log("초밥인덱스 : "+arr.indexOf("초밥")); //-1

    //배열.sort([정렬기준 함수]) : 배열 내 요소를 오름차순 정렬(문자열)
    const arr2 = [5, 3, 2, 10, 1];
    console.log(arr.sort()); //문자열
    console.log(arr2.sort()) //숫자 -> 정상 정렬 X
                             //왜? 문자열로 변환되서 정렬되기 때문에 
                             //   (문자열 정렬 기준이 기본값)

    //숫자 오름차순 정렬                   
    console.log(arr2.sort(function(a,b){ return a-b;}));

    //문자열로 출력
    console.log(arr.toString()); //배열값 가운  데에 , 찍힘!
    console.log(arr.join("/"));
})