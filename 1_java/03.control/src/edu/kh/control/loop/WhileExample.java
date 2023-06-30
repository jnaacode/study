package edu.kh.control.loop;

import java.util.Scanner;

public class WhileExample {
	
	/*while 문 
	 * - 별도의 초기식, 증감식이 존재하지 않고
	 * 반복 종료 조건을 자유롭게 설정하는 반복문
	 * 
	 * ** 확실히 언제 반복이 끝날지 모르지만 
	 * 	  언젠가 반복 조건이 false가 되는 경우 반복을 종료합니다.
	 * 
	 * [작성법]
	 * while(조건식){
	 * 
	 * 조건식이 true 일때 반복 수행할 구문
	 * 
	 * }
	 * 
	 */

	public void ex1() {
	
		Scanner sc = new Scanner(System.in);
		int input =0;
		
		while(input != 9) {
			
			System.out.println("--------------------");
			System.out.println("--------메뉴선택-------");
			System.out.println("1번 돈까스");
			System.out.println("2번 김치찌개");
			System.out.println("3번 삼겹살");
			System.out.println("9번 종료");
			
			System.out.println("메뉴선택 >> ");
			input = sc.nextInt();
			
			//input 값에 따라서 case 선택 
			
			switch(input) {
			case 1 : System.out.println("돈까스를 주문했습니다");break;
			case 2 : System.out.println("김치찌개를 주문했습니다");break;
			case 3 : System.out.println("삼겹살를 주문했습니다");break;
			case 9 : System.out.println("메뉴 선택을 종료합니다.");break;
			default : System.out.println("잘못입력하셨습니다.");break;
			
			}

		}
	}
	
	public void ex2() {
		
		//입력되는 모든 정수의 합 구하기 
		//단, 0이 입력되면 반복종료 후 결과 출력 == 0이 입력되지 않으면 계속 반본
		
		Scanner sc = new Scanner(System.in);
		
		int input = -1; //입력 받은 값을 저장할 변수
		//* input = 0으로 넣었을때 나중에 값이 sum = 0 이 나온다 
		// -> 해결방법
		//1) 0이 아닌 값을 대입하여 while문이 처음에 수행될 수 있도록 함
		int sum = 0; // 모든 정수의 합을 저장하는 변수 
		
		while(input != 0) {
			
			System.out.println("정수 입력 : ");
			input = sc.nextInt();
			sum += input; //입력 받은 값을 sum에 누적 

		}
		
		System.out.println("합계 :" + sum);
		
		
	}
	
	public void ex3() {
		
		//입력되는 모든 정수의 합 구하기 
		//단, 0이 입력되면 반복종료 후 결과 출력 == 0이 입력되지 않으면 계속 반본
		
		Scanner sc = new Scanner(System.in);
		
		int input = 0; //입력 받은 값을 저장할 변수
		int sum = 0; // 모든 정수의 합을 저장하는 변수 
		
		//2)while문을 최소 한번은 수행하는 반복문 
		// - > do ~ while문 
		
		do {
			
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			sum += input; //입력 받은 값을 sum에 누적 

		}while(input != 0);
		
		System.out.println("합계 :" + sum);
		
	}
	
}
		
	
	
	
	

