package edu.kh.op.ex;

import java.util.Scanner;

public class OpExample { // 예제 코드 작성용 클래스 

	//ex1()메소드
	// -> OpExample이 가지고 있는 기능중 ex1()이라는 기능 
	public void ex1() {
		
		//syso 작성 후 ctrl + space
		System.out.println("OpExample 클래스에 ex1()기능 수행");
		System.out.println("클래스 분리 테스트");
		System.out.println("println 자동완성해봤어요");
	
	}
	//ex2()메소드(기능)
	public void ex2() {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 1 :");
		int input1 = sc.nextInt(); // 다음 입력되는 정수를 읽어옴
		
		System.out.print("정수 입력 2 :");
		int input2 =sc.nextInt();
		
		System.out.printf("%d / %d = %d\n", input1,input2,input1/input2);
		System.out.printf("%d %% %d = %d\n", input1,input2,input1/input2);
		
	}
	
	public void ex3() {
		// 증감(증가++, 감소-- 연산자)
		// -> 피연산자 (값)를 1 증가 또는 감소 시키는 연산자 
		
		int iNum1 =10;
		int iNum2 =10;
		
		iNum1++; //1증가 
		iNum2--; //1감소
		
		System.out.println("iNum1:" + iNum1);
		System.out.println("iNum2:" + iNum2);
		
		//전위 연산  :++3,--2 연산자가 앞쪽에 배치 , 다른 연산자보다 먼저 증가/감소한다.
		
		int temp1 = 5;
		System.out.println(++temp1+5);
		                 // ++5 + 5 
		                 //   6 + 5 = 11
		
		System.out.println("temp1 :" + temp1);
		// temp1 = 5+1; 먼저 수행 후 6+5에 대한 값을 출력  
		
		
		//후위 연산 :3++,2-- 연산자가 뒤쪽에 배치 , 다른연산자보다 나중에 증가/감소 
		
		int temp2 = 3;
		System.out.println(temp2-- + 2);
						// 3 -- + 2 ==5
						// temp2 = 2;(1감소)
		
		System.out.println("temp2 :" + temp2);
		// 3+2에 대한 값을 출력 후 temp2 = 3-1;을 수행
		
		int a = 3;
		int b = 5;
		int c = a++ + --b;
		
		// (a)3 ++ + -- 5(b)
		//  c = (a)3 ++ + 4(b)
		//	= 7
		
		
		System.out.printf("%d/%d/%d\n",a,b,c); 
		}
	
		public void ex4() {
			
			//비교 연산자 : >, <, >=, <=, ==, !=
			// - 결과는 항상 논리값이다 (true/false)
			// - 등호(=)가 포함된 연산자에서 등호는 항상 오른쪽! >= , <=
			
			// = (대입연산자) , ==(같다) 
			
			
			int a = 10;
			int b = 20;
			
			System.out.println(a < b); //true
			System.out.println(a > b); //false
			System.out.println(a != b); //true
			System.out.println(a == b); //false
			
			System.out.println("--------------------------------------");
			
			int c = 4;
			int d = 5;
			
			System.out.println( c<d );
			System.out.println( c+1 <= d );
			System.out.println((++c != d) ==(--c != d));
							// ++4 != 5 -> false
							// --5 ! = 5 -> true  
				
			System.out.println("--------------------------------------");
			
			int temp = 723;
			
			System.out.println("temp는 짝수인가 ?" + (temp % 2 == 0)); //false
			System.out.println("temp는 짝수인가 ?" + (temp % 2 != 1)); //false
			
			
			System.out.println("temp는 홀수인가 ?" + (temp % 2 == 1));//true
			System.out.println("temp는 홀수인가 ?" + (temp % 2 != 0));//true
			
			System.out.println("temp는 3의 배수인가?"+ (temp % 3 == 0)); //true
			System.out.println("temp는 4의 배수인가?"+ (temp % 4 == 0)); //false
			System.out.println("temp는 5의 배수인가?"+ (temp % 5 == 0)); //false
			
			
		}
	
		public void ex5() {
		
			// 논리연산자 : 엠퍼센트&&(AND) / 버티컬||(OR)
			
			//&& 둘다 true이면 true, 나머지 false
			// ~와, 그리고(이고), ~면서, ~이면서, ~부터,~까지 ~사이 
			
			int a = 100;
			
			// a는 100이상이면서  짝수인가 ? 
			System.out.println(a >= 100); //>=이상, <=이하
			System.out.println(a%2==0);
			System.out.println(a>=100 && a%2==0);
			
			int b =5;
			//b는 1부터 10끼지 숫자 범위에 포함되어 있는가 ? 
			
			System.out.println(b >= 1);
			System.out.println(b <= 10);
			
			System.out.println(b>=1 && b<=10);
			
			System.out.println("-----------------------------------");
		
			// || (OR) 연산자 : 둘다 false이면 false, 나머지 true (AND 반대)
			//~또는, ~거나, ~이거나 
			
			int c = 10;
			
			// c는 10를 초과하거나 짝수다.
			System.out.println(c<10 || c%2 ==0);
			
		}
		
		public void ex6() {
		
			// 논리 부정 연산자 : ! 
			
			// -> 논리 값을 반대로 바꾸는 연산자 
			
			boolean bool1 = true;
			boolean bool2 = !bool1;
			System.out.println("boo11 :" + bool1);
			System.out.println("boo12 :" + bool2);
			
			Scanner sc = new Scanner(System.in);
			
			// 정수를 하나 입력 받았을 때
			// 1) 해당 정수가 1부터 100사이 값이 맞는지 확인을 한다. (1이상 이면서 100 이하)
			// 2) 1부터 100사이 사이 값 아닌지 확인 (1번 반대) (1미만 또는 100 초과)
			
			 System.out.print("정수 입력 : ");
		        int input = sc.nextInt();

		        boolean result1 = input>=1 && input<=100;
		        System.out.printf("%d은/는 1 이상, 100이하의 정수인가? : %b\n",input,result1);

		        boolean result2 = !(input>=1 && input<=100); //resul2와 result3은 같은 내용이다. 
		        boolean result3 = input<1 || input>100;
		        System.out.printf("%d은/는 1 미만이거나 100 초과 정수인가? : %b, %b\n",input,result2,result3);
			
			/*System.out.print("입력 : ");
			
			int input1 = sc.nextInt();
			
			//1) 1이상 이면서 100 이하
			boolean result1 = 1 <= input1 && input1 <=100;
			
			System.out.printf("%d은/는 1 이상, 100이하의 정수인가 : %b\n",input1,result1);
			
			//2) 1미만 또는 100 초과
			
			boolean result2 = (1 < input1) || (input1 >100);      
			
			System.out.printf("%d은/는 1 미만, 100초과의 정수인가 ? : %b\n",input1,result2);
				
			boolean result3 = !(1 <= input1 && input1 <=100);
			
			System.out.printf("%d은/는 1 이상, 100이하의 정수인가 ? : %b %b\n",input1,result3,result3);*/
			
		}
		
		public void ex7() {
			
			//복합 대입 연산자 : +=, -= , *= ,/=, %= (등호는 오른쪽!)
			//피연산자가 자신과 연산 후 결과를 다시 자신에게 대입한다. 
			
			int a = 10;
			// a를 1 증가 
			a++; // a =a+1
			a+=1;
			
			System.out.println("a를 1증가 :"+ a); //12
			
			//a를 4증가 
			a += 4;
			
			System.out.println("a를 4증가 :"+ a); //16
			
			//a를 10 감소
			a-=10;			
			System.out.println("a를 10감소 :"+ a); //6
			
			//a를 3배 증가 
			a*=3;			
			System.out.println("a를 3배증가 :"+ a); //18
			
			//a를 6으로 나눴을때 몫 
			a/=6;			
			System.out.println("a를 6으로 나눴을때 몫 :"+ a); //3
			
			//a를 2로 나눴을때 나머지 
			a%=2;
			System.out.println("a를 2으로 나눴을때 나머지 :"+ a); //1
			
		}
		
		public void ex8() {
			
			// 삼항 연산자 : 조건식 ? 식 1: 식2
			
			// - 조건식의 결과가 true 이면, 식1,
			// - 조건식의 결과가 false이면 식 2
			
			// * 조건식 : 연산 결과가 true / false인식 
			//          (비교, 논리, 논리 부정, 연산이 포함)
			
			int num = 30;
			// num이 30보다 크면 (초과) : num은 30보다 큰 수이다. 
			// 아니면 				   : num은 30 이하의 수이다. 
			
			String str1 = "num은 30보다 큰 수이다.";
		    String str2 = "num은 30이하의 수 이다.";
		    
		    String result = num >30 ? str1: str2;
		    				// 조건식 ?  식 1 : 식2
		    				//          T    F
			
			// num 값이 30을 초과하면 str1
		    // num 값이 30을 초과하지 못하면 str2
		    // result 변수에 저장 
		    
		    System.out.println(result);
	
			System.out.println("-----------------------------------");
			
			// 입력 받은 정수가 음수인지 양수인지 구분
			// 단, 0은 양수로 처리 
			
			//ex)
			//정수 입력 : 4
			// 양수입니다. 
			
			// 정수 입력 : -5
			// 음수입니다. 
			
			Scanner sc = new Scanner(System.in); // 입력받은 정수가 
			
			System.out.println("입력 정수 : "); // 입력도 받아야하네 
			
			int input = sc.nextInt(); // 입력한걸 여기에 담아야지 
			
			//String str3 = "양수입니다.";
			//String str4 = "음수입니다."; // 입력된걸 결과를 넣어야지
			
			//String result2 = input >=0 ? str3 :str4	;
			//System.out.println(result2);		
			
			String result2 = input >=0 ? "양수입니다":"음수입니다";
			System.out.println(result2);	

	
			
			
		}
	}
