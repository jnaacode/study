package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample1 {
	
	/*배열 (array)
	 * 
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는것 (자료구조)
	 * - 묶여진 변수들은 하나의 배열명으로 불러지고 
	 *   구분은 index를 이용한다.(index는 0부터 시작하는 정수이며 칸의 번호이다)
	 *   
	 */

	// 각각의 변수로 선언
	int i1,i2,i3;
	
	//3개의 int값을 저장할 수 있는 배열 생성
	int [] i = new int[3];
	


	public void ex1() {
		
		//변수 vs 배열 
		
		//1-1 변수 선언
		int num;
		//stack 영역에 int 자료형을 저장할 수 있는 공간 4byte 생성(할당)하고
		// 그 공간에 num이라는 이름을 부여했다. 
		
		//1-2 변수 대입
		num = 10;
		//생성된 num이라는 변수 공간에 10을 대입
		
		//1-3 변수 사용
		System.out.println("num에 저장된 값 :"+num);
		//num이 작성된 자리에 num에 저장된 값을 읽어와서 출력
		
		//----------------------------------------------------------
		
		//2-1.배열선언
		int[] arr;
		// stack 영역에 int[] (int 배열) 자료형 공간을 8byte 할당하고
		// 그 공간에 arr 이라는 이름을 부여 
		// ***해당 변수는 참조형으로 주소 값(8byte)만을 저장할 수 있음
		
		//2-2.배열할당
		arr = new int[3];
		//new: new 연산자 라고 하며 Heap메모리 영역에 새로운 공간 (배열/객체)할당
		//int[3] : int 자료형 변수 3개를 하나의 묶음으로 나타내는 배열 
		
		//new int[3] : heap 영역에 int 3칸 짜리 int[]을 생성(할당)
				//** 생성된 int[]에는 시작 주소가 지정된다!! **
		
		// arr = new int[3];
		// int[]    int[]   -> 같은 자료형 == 연산 가능 
		
		//heap영역에 생성된 int[]에 시작 주소를 stack영역에 생성된 arr변수에 대입한다. 
		
		//-> arr변수가 int[]참조하게 된다! (arr을 참조형이라고한다)
		
		//2-3.배열 요소 값 대입
		//arr은 int[]참조형 변수이지만, arr[0] int 자료형 변수이기 때문에 정수값을 대입할 수 있다.
		//(int[])arr =(int)10 in[] /int는 다른 자료형이기에 이렇게 쓸 수 없음 
		
		arr[0]=10;
		arr[1]=50;
		arr[2]=80;
		//2-4.배열 요소 값 읽어오기
		
		System.out.println(arr[0]); //arr이 참조하고 있는 배열의 0번 인덱스 값을 얻어온다. 
		System.out.println(arr[1]); //arr이 참조하고 있는 배열의 1번 인덱스 값을 얻어온다. 
		System.out.println(arr[2]); //arr이 참조하고 있는 배열의 2번 인덱스 값을 얻어온다. 
	}
	
	public void ex2() {
		//배열의 선언 및 할당
		
		/*
		int[] arr;  			1) stack영역에 int[]자료형 참조형 변수 arr선언
		arr = new int[4]; 		2) heap영역에 int자료형 4개를 묶음으로 다루는 int[]할당
		int[] arr = new int[4]; 3) 생성된 in[]주소를 arr에 대입하여, 참조하는 형태를 만든다. 
		*/
		
		int[] arr = new int[4]; 
		//배열길이(몇칸인가)배열명.length
		
	
		arr[0]=100;
		arr[1]=200;
		arr[2]=500;
		arr[3]=1000;
		
		//배열과 for문 
		//i == index
		for(int i=0; i<arr.length ; i++) { //배열의 길을 예상할 수 없을때 .length를 이용한다. 
			System.out.printf("arr[%d]에 저장된 값은 %d이다\n", i,arr[i]);
			
			//참고지만 알고 있는게 좋음 
			//비어있다. stack영역에 선언된 변수에 값이 대입되지 않음
			//null: 참조형 변수가 선언되었으나 아무곳도 참고 하지 않는다(빈칸 x / null값도 값임!)
			//0 : int 자료형 0(확실히 존재하는 값)
			// "" String 자료형이지만 내용없음(빈문자열)
		}
	}
	
	public void ex3() {
		
		// 5명의 키(cm)를 입력 받고 평균 구하기
	      
	      // 1번 키 입력 : 170.5
	      // 2번 키 입력 : 165.7
	      // 3번 키 입력 : 184.3
	      // 4번 키 입력 : 190.2
	      // 5번 키 입력 : 174.4
	      
	      // 입력 받은 키 : 170.5  165.7  184.3  190.2  174.4
	      // 평균 : 177.02cm
		
		Scanner sc = new Scanner(System.in);
		
		double[] height = new double[5];
		// double 배열 -> 자료형 참조 변수 height를 stack영역에 생성하고
		// heap영역에 새로 생성된 double 5칸 짜리  double[]의 시작 주소를 height 대입 한다
		
		for(int i =0; i <height.length;i++) {
			
			System.out.print((i+1)+"번 키 입력 : " );
			
			height[i]=sc.nextDouble();
			//각 인덱스에 입력 받은 값을 대입(초기화) height =sc.nextDouble(); 
			//	> [i]을 제외하고 height만 쓴다면  위에서 double []이라고 썼기에 다른 자료형으로 오류 발생
			
		}
		System.out.println();{
			
			double sum =0;
			System.out.println("입력 받은 키 :");
			
			for(int i =0;i<height.length ;i++) {
			System.out.print(height[i]+" ");
			
			sum+= height[i]; //배열에 저장된 값을 sum에 누적한다. 
			
			}
			System.out.printf("\n평균 : %.2f\n",sum /height.length);
		}
	
	}
	public void ex4() {
	

		// 입력 받은 인원 수 만큼의 점수를 입력 받아 배열에 저장
	    // 입력이 완료되면 점수 합계, 평균, 최고점, 최저점 출력
	    
	    // ex)
	    // 입력 받을 인원 수 : 4
	    // 1번 점수 입력 : 100
	    // 2번 점수 입력 : 80
	    // 3번 점수 입력 : 50
	    // 4번 점수 입력 : 60
	    
	    // 합계 : 290
	    // 평균 : 72.50
	    // 최고점 : 100
	    // 최저점 : 50
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 받을 인원 수 :");
		int input = sc.nextInt();
		
		//배열 선언 및 할당 , 할당할 배열의 크기는 입력 받은 크기만큼(input)
		int[] score = new int[input];
		
		int sum =0;//합계 저장용 변수
		
		for(int i =0 ;i <score.length ;i++) {
			System.out.print((i+1)+"번 점수 입력 : ");
			score[i] = sc.nextInt();
			
			sum+=score[i];//점수를 입력 받자마자 sum에 누적한다. 
		}
		
		//최고/최저점 구하기 
		int max = score[0];
		int min = score[0];
		// 아래 for문을 이용해서 score 배열에 있는 모든 값과 max, min을 비교
		// 이 때,
		// score[i] 값이 max 보다 크면 max에 대입
		// score[i] 값이 min 보다 작으면 min에 대입
		
		for(int i = 0; i < score.length; i++) {
			
			if(score[i] > max) { // 최고점 비교
				max = score[i];
				
			} else if( score[i] < min ) { // 최저점 비교
				min = score[i];
			}
		}
		System.out.println("합계 :"+sum);
		System.out.printf("평균 :%.2f\n",(double)sum / score.length);
		
		System.out.println("최고점 :"+max);
		System.out.println("최저점 :"+min);
	}
			
	public void ex5() {
		
		//배열 선언과 동시에 초기화
		char[] arr = new char[5];
		//char[] arr이 참조하는 배열 요소에 A B C D E 대입하기 
		
		for(int i =0;i<arr.length;i++) {//arr.length == 5
			//arr[i]  = 'A'+ i;
			//char 자료 = int >오류 발생 
			arr[i] =(char)('A'+i);
			
		}
		// ** Arrays 클래스 
		// -> java에서 제공하는 배열과 관련된 기능을 모아둔 클래스 
		int [] arr2 =new int[4];
		System.out.println(arr2); //[I@4232c52b > (암호화) 배열의 시작주소
		
		//Arrays.toString(배열명) :모든 요소 값을 출력 
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr));
	
		//배열 선언과 동시에 (할당 및) 초기화
		char []arr3 = {'A','B','C','D','E'};
		//char [] 참조 변수 arr3를 선언하고 heap영역에 char5칸 짜리 char[] 을 생성하고
		//각각  'A','B','C','D','E'로 초기화 후 주소를 arr3에 대입
		//{}(중괄호)는 배열의 리터럴 표기법이다. 
		//HEAP메모리에 문자로ABCEDE가 아닌 65,66,67,68,69로 표시된다. 
		
		System.out.println("arr3 길이 :"+arr3.length);
		System.out.println(Arrays.toString(arr3));
		
		
	}
	public void ex6() {// 점심메뉴 뽑기 프로그램 

		String [] arr = {"김밥","서브웨이","햄버거","백반","국밥","파스타"};
		//0  ~ (배열길이-1) 사이의 난수 발생 
		
		System.out.print("오늘의 점심 메뉴 : "+ arr[(int)(Math.random()*6)] );
		//Math.random : 랜덤값 출력 
		//0.0 <= x <1.0
		//0.0 <= x *6 < 6.0
		//0<= (int)(x*6)<6 -> 0 1 2 3 4 5
	}
	
	public void ex7() { // 이해가 좀 필요함 ! 
		
		//배열을 이용한 검색 
		//입력 받은 정수가 배열에 있는지 없는지 확인 
		//만약 있다면 몇번 인덱스에 존재하는지도 출력
		
		int [] arr = {100,200,300,400,500,600,700,800,900,1000};
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input =sc.nextInt();
		
		//신호를 나타내기 위한 변수 
		//flag == false : 일치하는 값이 존재하지 않음 
		//flag == true : 일치하는 갓이 존재 
		
		boolean flag =false; //검사 전에는 없다고 가정  / 못찾았어
		//in count = 0; // 나는 0이 찾은거라고 생각할거야! 
			
		
		//arr 배열 요소 순차 접근(반복접근)
		for(int i =0;i<arr.length;i++) {
			if(input==arr[i]) { //내가 입력한 값이랑 arr[i] 저장된 값 같을 경우 
				System.out.println(i+"번째 인덱스에 존재");
				//count++;
				flag = true; //일치하는 값이 있으므로 true로 변경 
			
			}
		}
		//if(count==00) {System.out.println("존재하지 않습니다.");
		//else System.out.println("동일한 값이"+count+"존재합니다.");
		
		//flag 상태를 검사 
		if(!flag) { //!flag > true //true ==false 값지 않다고 되어 있는데 왜 존재하지 않음이 실행되지?
			System.out.print("존재하지 않음");
		}
	}
	
	public void ex8() {
		
		//입력 받은 값과 일치하는 값이 있으면 인덱스 번호 출력
		//없으면 "존재하지 않음" 
		
		//과일입력 : 수박 
		//존재하지 않음 
		
		//과일입력 : 딸기
		// 1번째 인덱스에 존재 
		
		
		String [] arr = {"사과","딸기","바나나","키워","멜론","아보카도"};
		
		Scanner sc= new Scanner(System.in);
		System.out.print("과일입력 : ");
		
		String input = sc.next();
		
		boolean flag = false; // 나는 false를 썼을때 존재하지 않는다고 약속할거야! 
		
		for(int i =0 ;i <arr.length ; i++) {
			if(input.equals(arr[i])) { //String 비교시 문자열 비교는 문자열1.equals(문자열2) / == > 기본자료형만 비교 할 수 있다
				System.out.print(i+ "번 인덱스에 존재");
				
				flag = true; //존재하네?
			}
		}
		if(!flag) { //flag가 false인 경우  // false일경우는 존재하지 않음을 출력할거
			System.out.print("존재하지않음");
		}
		
	}
	
	public void ex9() {
		//1. 문자열을 입력 받아서 한 글자씩 잘라내여 char배열에 순서대로 저장
		//2. 문자 하나를 입력 받아 일치하는 문자가 char 배열에 몇개 존재하는지 확인 
		//3. 단 일치하는 문자가 없을 경우,"존재하지 않음"
		
		//[사용해야하는 검색 기능]
		//1) 배열 검색
		//2) String.length():문자의 길이 
		
		//3) String.charAt(index) : 문자열에서 특정 index에 위치한 문자 하나를 얻어옴 -> "hello".charAt(1) - 'e'
		//4) count (숫자세기)
		

		Scanner sc= new Scanner(System.in);
		System.out.print("문자열 입력  : ");
		
		String input=sc.nextLine();// 한줄(띄어쓰기포함) 입력 받기 
		
		//1. 문자열을 입력 받아서 한 글자씩 잘라내여 char배열에 순서대로 저장
		char [] arr = new char[input.length()];
		
		for(int i=0;i<arr.length;i++) {
			
			arr[i]=input.charAt(i);
			//arr[i]에 입력 받은 문자열 중 i 번째 문자를 대입
		}
		//중간확인 
		//System.out.println(arr); //String 아닐 때 Arrays.toString(arr) 넣어야한다. 
		
		//2. 문자 하나를 입력 받아 일치하는 문자가 char 배열에 몇개 존재하는지 확인 
		System.out.print("검색할 문자 입력 : ");
		char ch = sc.nextLine().charAt(0);
			//String.charAt(0) : 문자열 제일 앞 문자 얻어오기
		
		int count =0;// 같은 글자 개수를 세기 위한 변수 
		
		for(int i = 0; i <arr.length ;i++) {
			if(arr[i]==ch) {
				//arr[i]값과 검색할 문자 ch가 같은 경우  > 카운트 
				count++;
				
			}
			
		}
		
		//3. 단 일치하는 문자가 없을 경우,"존재하지 않음"
		
		if(count > 0) {//일치한다면
			System.out.print(count + "개 있음");
		}else { //일치하지 않는다면 
			System.out.print("존재하지 않습니다. ");
		}
	}	

	public void ex10() {
		Scanner sc = new Scanner(System.in);
		// 값 3개를 입력받아서  최대 4자릿수까지 
		
		System.out.print("정수 입력 : ");
		double input1 = sc.nextDouble();
		
		System.out.print("	정수 입력 : ");
		double input2 = sc.nextDouble();
		
		System.out.print("정수 입력 : ");
		double input3 = sc.nextDouble();
		
		System.out.printf("%\n",input1);
		System.out.printf("%\n",input2);
		System.out.printf("%\n",input3);
			
		//   1
		//  10
		// 100
		
		
		
	}
}

