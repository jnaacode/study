package edu.kh.control.loop;
	
import java.util.Scanner;

public class ForExample {
	
	/*for문
	 * 
	 * - 끝이 정해져 있는(횟수가 정해져있는) 반복문 
	 * 
	 * [작성법]
	 * 
	 * for(초기식 ; 조건식 ;증감식){
	 * 
	 * 		반복 수행할 코드 
	 * 
	 * }
	 * 
	 * - 초기식 : for문을 제어하는 용도의 변수 선언 
	 * 
	 * - 조건식 : for문의 반복 여부를 지정하는 식 (다음 반복 진행 해? 말아!)
	 * 		       보통 초기식에 사용된 변수를 이용하여 조건식을 작성함
	 * 
	 * - 증감식 : 초기식에 사용된 변수를 for문이 끝날때마다 증가 또는 감소 시켜
	 * 		       조건식의 결과를 변하게 하는 식 
	 */
	
	public void ex1() {
		
		//for문 기초 사용법 1
		// - 1 ~ 10 출력하기   
		// --> 1부터 10까지 1씩 증가하면 출력
		
		
		for (int i = 1; i<=10 ;i++) {
			//1) 초기식  2),5) 조건식   ;4),7)증감식 

			//3),6) 반복 수행할 코드 
			System.out.println(i + "출력");
			
		}
			
	}
	
	public void ex2() {
		
		// for 기초 사용법 2
		
		// 3에서 7까지 1씩 증가하며 출력   3 ~ 7 1++
		// i값이 7이하일때 true가 되는 조건식 
		
		for (int i = 3 ; i <= 7 ; i++) {
			
			System.out.print(i+ " ");
		}
			
	}
	
	public void ex3() {
		
		// 2에서15까지 1씩 증가하며 출력 
		for(int i = 2 ; i < 16 ; i++) {
			System.out.print(i + " ");
		}

	}
	
	public void ex4() {
		// 1부터 입력 받은 수까지 1씩 증가하며 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("끝번호 :");
		
		int input =sc.nextInt();
		
		for(int i = 1 ; i <= input ; i++) {
			
			System.out.println(i);
		}
	
	}
			
	public void ex5() {
		
		// 증감식은 1만 증가하는게 아니라 2씩도 증가 가능하다.
		// 1부터 입력 받은 수까지 2씩 증가하며 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.println("끝번호 :");
		
		int input =sc.nextInt();
		
		for(int i = 1 ; i <= input ; i+=2) {
									//i = i + 2 -> i에 기존 i값 대입 +2대입`
			
			System.out.println(i + "출력");
		
		}
	
	}
	
	public void ex6() {
		
		//1.0부터 입력 받은 실수까지 0.5씩 증가 
		
		Scanner sc =new Scanner(System.in);
		System.out.print("끝나는 실수 :");
		
		double input =sc.nextDouble();
		
		for(double i = 1.0 ; i <= input ; i+=0.5) {
		
			System.out.println(i+"출력");
		}
		
	}	
		public void ex7() {
			
			//영어 알파벳 A부터 Z까지 한줄로 출력 
			//char 자료형은 문자형이지만 실제로는 정수로 출력
			

			for(int i = 'A'  ; i <= 'Z' ; i++) {
				System.out.print( (char)i); //형변환
			}	
		
		System.out.println("\n-------------------------");
		
		
		for(char i = 'A'  ; i <= 'Z' ; i++) {
			System.out.print(i); //형변환
		
			}	
			
		}
	
		public void ex8() {
		
			for(int i = 10 ; i >= 1 ; i--) {
				System.out.println(i);
			}
		}
		
		public void ex9() {
			
			//for문 응용1 : 반복문을 이용한 값의 누적
			//1부터 10까지 모든 정수의 합구하기	
		
			int sum = 0; //반복되어 증가하는 i값의 합계를 저장할 변수 
						 //0으로 시작하는 이유: 아무것도 더하지 않음으로 정확히 결과를 도출할 수 있기 때문이다.
			
			for(int i = 1 ; i <=10 ; i++){
				
				//sum = sum + i;
				sum += i;
			
				System.out.println("합계 :"+ sum);
			}
			
		}
		
		public void ex10() {
			// for문 응용 2 : 정수 5개를 입력 받아서 합계 구하기 
			
			
			Scanner sc = new Scanner(System.in);
			int sum = 0;
			
			for(int i =1; i<=5 ; i++) {
				System.out.print("입력" + i + ":");
				int input = sc.nextInt();
				sum += input; //sum 입력 받은 input값을 누적
				//System.out.println(input);
				//{} 안에서 생성된 변수는{} 밖에서 사용할 수 없다.
				// -> {}가 끝나는 시점에 사라기지 때문에
			}
			System.out.println("합계 : "+sum);
			
			//System.out.println(input);// 에러! 가로 안에서 선언된 변수는 가로 밖에서 사용할 수가 없다.
		
		}
		
		public void ex11() {
			
			Scanner sc = new Scanner(System.in);
			System.out.print("입력 받을 정수의 개수 :");
			int num = sc.nextInt(); //입력할 정수를 num에 담아준다.
			
			int sum = 0;
			
			for (int i = 1; i <= num; i++) 
			{
				
				System.out.print("입력" + i +":");
				int input = sc.nextInt();
				
				sum += input;
			}
			System.out.println("합계 :" +sum);//합계 1개만 찍히기 때문에 밖에 작성
		}
		
		public void ex12() {

			//1부터 20까지 1씩 증가하면서 출력
			//단, 5의 배수()를 붙여서 출력
			//ex)1 2 3 4 (5) 6 7 8 9 (10)
			
			for(int i = 1; i <=20 ; i++) {
		
				if (i % 5 ==0) { //i가 5의 배수인 경우
					System.out.print("("+i+") ");
				}else {
					System.out.print(i+ " ");
					
				}
				
			}
			
		}
		public void ex13() {
			
			// 1 부터 20까지 1씩 증가하면서 출력 -> 반복되네 for이야 (int i =1 1~20 1++)
		      // 단, 입력 받은 수의 배수는 () 표시	if(i%input==0)sysout("("+ i+") ")
		      							//else 그럼 배수 아닌거는  1~20까지 나와야지 그러니 i만출력
		      // ex)
		      // 괄호를 표시할 배수 : 3
		      // 1 2 (3) 4 5 (6) ...
		      
		      // 괄호를 표시할 배수 : 4
		      // 1 2 3 (4) 5 6 7 (8) 9 ...
			
			Scanner sc = new Scanner(System.in);

			System.out.print("괄호를 표시할 배수  :");
			int input =sc.nextInt();
			
			for(int i = 1 ;i <=20 ;i++) {
				
				if(i % input ==0) { //i가 input에 저장된 값의 배수인 경우 
					System.out.print("("+ i+") ");
				}else {
					System.out.print(i+ " ");
				}
				
			}
				
			
		}
		
		public void ex14() {
			
		      // [구구단 출력]
		      // 2 ~ 9 사이 수를 하나 입력 받아
		      // 해당 단을 출력
		      // 단, 입력 받은 수가 2 ~ 9 사이 숫자가 아니면 "잘못 입력 하셨습니다" 출력

			Scanner sc = new Scanner(System.in);
			System.out.println("단 입력  :");
			int dan =sc.nextInt();
		
				if (dan>=2 && dan<=9) {
					
					for(int i = 1 ; i <=9;i++) {
						System.out.printf("%d x %d = %d\n", dan,i,dan*i);
					}
				
				} else {
					System.out.println("잘못 입력 하셨습니다.");
				}
			}
				
		public void ex15() {
			
			//19단 출력기
			//2~19단 사이단을 입력 받아서 X1~X19까지 출력
			//단, 2~9 사이 단이 입력되지 않으면 "잘못입력 하셨습니다."출력 
			
		Scanner sc = new Scanner(System.in);
		System.out.println("단 입력 : ");
		int dan = sc.nextInt();
		
		if(dan>= 2 && dan <=19) {
			
			for(int i =1;i<=19;i++) {
				System.out.printf("%d X %d = %d\n", dan,i,dan*i);
			} 
		}else {
			System.out.print("잘못입력하셨습니다.");
				
			}
			
		}
			
		//**중첩 반복문 
		
		public void ex16() {
			//구구단 모두 출력하기
			
			for(int dan =2 ;dan<=9;dan++) { //2~9단까지 차례로 증가
			
				//안쪽 for문이 반복하면서 하나의 단을 한 줄로 출력
				for(int num = 1; num<=9 ; num++) {//각 단에 곱해질 수 1~9까지 차례대로 증가
					//System.out.printf("%d x %d = %d\t ", dan ,num,dan*num);
					System.out.printf("%d x %d = %2d\t ", dan ,num,dan*num);
					
				}
				System.out.println( ); //아무내용없는 pirntln() == 줄바꿈
			}
			
		}
		
		public void ex17() {
			//구구단 역순 출력
			//9~2단까지 곱해지는 수1~9까지는 정방향
			
			//for(int dan = 9 ; dan <=9 ;dan--) { //내가 한 오답
			for(int dan = 9 ; dan >=2 ;dan--) {
				
				for(int i = 1 ; i <=9 ; i++) {
					System.out.printf("%d x %d =%d\t", dan,i,dan*i);
				}//한단의 출력 종료 
				System.out.println( );//한단이 끝났을떄 줄 바꿈
			}
		}
		
		public void ex18() {
			//2중 for문 이용해서 다음 모양을 다섯번 출력하세요
			
			//12345
			//12345
			
			for(int i =1 ; i<=5 ; i++) { //5바퀴 반복되는 for문 //몇번 돌린건지 (얼마나 반복할건지)
				
				for(int num = 1; num <=5 ; num++ ) { // 이부분에 대해서 출력됨 12345 한줄 출력하는 for문
					System.out.print(num);
				}
				System.out.println( );
			}
			System.out.println("----------------------------");
			
			for(int i = 1 ;i <=3;i++) {
				
				for(int x =5 ; x >=1 ;x--) {
					System.out.print(x);
				}
				System.out.println( );
			}
			
		}
		public void ex19() {
			
			//2중 for문을 이용하여 다음 모양을 출력하세요
			//1
			//12
			//123
			//1234
			
			for(int x = 1 ; x <=4 ; x++) {//줄 반복 
			
				for(int i = 1 ; i<=x ;i++) { //출력 반복
					System.out.print(i);
				}
				System.out.println( );
			}
			//x가 1일 떄 i = 1 
			//x가 2일 떄 i = 1 2 
			//x가 3일 떄 i = 1 2 3 
			//x가 4일 떄 i = 1 2 3 4
			
			System.out.print("----------------------------");
			
		
		//2중 for문을 이용하여 다음 모양을 출력하세요
		//4321
		//321
		//21
		//1
		
		for(int x = 4; x>=1 ;x--) { //줄반복
			
			for(int i = x ; i>=1 ; i--) {//숫자출력 
				System.out.print(i);
			}
		}System.out.println();
		
	}
		//x가 4일때//1일때  4 3 2 1
		//x가 3일때//2일때  3 2 1 
		//x가 2일때//3일때  2 1 
		//x가 1일때//4일때  1
	
		public void ex20() {
			
			// count(숫자세기)
			//1부터 20까지 1씩 증가하면서 
			//3의 배수의 총 개수 출력
			//3 6 9 12 15 18 : 6개 
			//3의 배수의 합계 : 63
			
			int count =0; // 3의 배수의 개수를 세기 위한 변수 
			int sum = 0; //3의 배수의 합계를 구하기 위한 변수 
			
			for(int i =1 ;i<=20;i++) 
			{
				
				if(i%3==0) 
				{
					System.out.print(i + " ");
					count++; //if 문이 동작할때 마다 1씩 증가
					sum+=i; //3의 배수 누적 
				}
			}
			System.out.println(":" + count + "개");
			System.out.print("3의 배수의 합계 :" + sum); 
		}
		
		public void ex21() {
			
			//2중 for문과 count를 이용해서 아래 모양 출력하기 
			//  1  2  3  4
			//  5  6  7  8
			//  9 10 11 12
			
			int count =0;//1부터 시작하기 때문에 
			//int count = 0;//1부터 시작하기 때문에 
			
			
			for(int x = 1 ; x <=3 ; x++) { //3줄 반복
				
				for(int i = 1 ; i <=4 ;i++) { //4칸
					//count++ > count가 0일때는 여기에 위치한다. 
					System.out.printf("%-3d" , count); 
					count++;
				}
				System.out.println();
			}
		}
}
	
		
		
