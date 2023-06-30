package practice;

import java.util.Scanner;

public class LoopPracitce {
	
	public void pracitce1() {
		
		//1개의 합을 입력 받아 1부터 그 숫자까지 모두 출력하세요
		//단, 입력한 수는 1보다 크거나 같아야한다. 
		//만일, 1미만의 숫자가 입력됐다면 1이상의 숫자를 입력해주세요출력
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의  숫자를 입력하세요 :");
		int input = sc.nextInt();
		
		for(int i =0 ; i <= input; i++) {
			
			if(input < 1) {
				System.out.print("1이상의 숫자를 입력해주세요");
			}else {
				System.out.print(i+ " ");
			}
			
		}
	}

	public void pracitce2() {
		
		//사용자로부터 한개의 값을 입력 받아 1부터 그 숫자까지 모든 숫자를 거꾸로 출력 
		//단, 입력한수는 1보다 크거나 같아야한다. 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의  숫자를 입력하세요 :");
		int input = sc.nextInt();

		for(int i =input ; i > 0 ; i--) {
			
			if(input >=1) {
				System.out.print(i+ " ");
		
			}
		} System.out.println("1이상의 숫자를 입력하세요");
	}
	public void pracitce3() {

		// 1부터 사용자에게 입력 받은 수까지 정수의 합을 for문 
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요 :");
		int input = sc.nextInt(); 
		int sum =0;
		
		for (int i = 1; i <=input; i++) {

			sum += input;
			System.out.print(i);
			
			if(i <input) {
				System.out.print("+");
			}else {
				System.out.print("=");
			}
		}
		
		System.out.print(sum);
	}
	
	public void pracitce4(){
		//두개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요 
		//만일, 1미만의 숫자가 입력됐다면 "1이상의 숫자를 입력해주세요"출력
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 :");
		int input1 = sc.nextInt(); 
		
		System.out.print("두 번째 숫자 :");
		int input2 = sc.nextInt(); 
		
		for(int i = 1 ; i <= input1;i++) {
			System.out.print(i+" ");
			if(input1 >= input2);{
				System.out.println();
				
			}
					
		}
	}

	public void pracitce5() {
		
		// 사용자로 부터 입력 받은 단을 출력하세요
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 :");
		int input = sc.nextInt(); 		
		System.out.println("===="+input+"단"+"====");
		
		for(int dan = input ; dan <=9 ; dan++) {
			
			for(int i = 1 ;i <=9 ;i++) {
				System.out.printf("%d * %d = %d\n",dan,i,dan*i);
			}
		System.out.println();
		break;
		}
		
	}
	public void pracitce6() {
			
	Scanner sc = new Scanner(System.in);
			
		System.out.print("숫자 :");
		int input = sc.nextInt(); 		

		if(input<=2 || input>=9)
			System.out.print("2~9사이 숫자만 입력해주세요");
		
		for(int dan = input ; dan <=9 ; dan++) {
			System.out.println("===="+dan+"단"+"====");
			for(int i = 1 ;i <=9 ;i++) {
				System.out.printf("%d * %d = %d\n",dan,i,dan*i);
			}
			System.out.println();
		}
	}
	
	public void pracitce7() {
		
		//*    첫번째 줄은 1개
		//**   두번째 줄은 2개
		//***
		//****
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 :");
		int input = sc.nextInt(); 		

		for(int i = 1; i<=input ; i++) { //반복

			for(int x=1; x<=i ; x++) {
				System.out.print("*");
			}
			System.out.println();
		
		}
	}
	
	public void pracitce8() {
		
		//**** 	1번째 줄 4개 출력
		//***	2번째 줄 3개 출력
		//**	3번쨰 줄 2개 출력 
		//*
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("정수 입력 :");
		int input = sc.nextInt(); 
		
		for(int i = 1 ;i<=input ;i++) {
			
			for(int x =input ; x >= i ; x--) {
				System.out.print("*");
			} 
			System.out.println();
		}
		
	}	
		
		/*
		
		
		for(int i = 1; i<=input ; i++) {

			for(int x=i;x<=input ; x++) {
				System.out.print("*");
			}
			System.out.println();

	}
*/	
	public void pracitce9() {
		
		//   * 첫번 째 반복할 때 4번째만 별
		//  ** 두번 째 반복할때 3,4번째만 별
		// ***
		//****
		
		Scanner sc =new Scanner(System.in);
		System.out.print("정수입력 : ");
		int input =sc.nextInt();
		
		for(int i = input;i>=1;i--) { //4줄반복
			
			for(int x =1; x<=input ; x++) { //4번반복, 첫줄은 입력한 숫자에 별을 찍어
				if(x >= i) {
				System.out.print("*");
				}else {
				System.out.print(" ");
				}
			}
			System.out.println();
			
			/*
			 * 		Scanner sc =new Scanner(System.in);
		System.out.print("정수입력 : ");
		int input =sc.nextInt();
		
		for(int i = 1;i<=input;i++) { //4줄반복
		
		1) for문 하나 더 박성
		1개 출력전에 띄어쓰기 3번
		2개 출력전에 띄어쓰기 2번
		3개 출력전에 띄어쓰기 1번
		4개 출력전에 띄어쓰기 0번
		
		y == 3 2 1 0
		
		1) 방법  
			for(int y =input-x; y>=1;y--){
			System.out.print(" ");
		
			for(int x =1; x<=i ; x++) { //4번반복, 첫줄은 입력한 숫자에 별을 찍어
				System.out.print("*");
			}
			System.out.println();
			
		2) 방법
		for (int x = 1 ;x <=input ;x++){
		
			if(i <=input-i){
			System.out.print(" ");
			}else 
			System.out.print("*");
			}
		}	
			System.out.println();
		
		 */
			
	
		}
	}
	public void pracitce10() {
		
		//* 	1번째 줄은 1번 별
		//** 	2번쨰 줄은 2번 별
		//***   3번째 줄은 3번 별 
		//**	
		//*

		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 :");
		int input = sc.nextInt(); 		
	
		
		for(int i = 1; i<=input ; i++) { //반복

			for(int x=1; x<=i ; x++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 1; i<=input ; i++) {

			for(int x=i;x<=input ; x++) {
				
				if(x==input) {
					continue;
				}
				System.out.print("*");
			}
			System.out.println();
			*/
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 :");
		int input = sc.nextInt(); 		
	
		
		for(int x = 1; x<=input ; x++) { //반복

			for(int i=1; i<=x ; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int y =input-1;y>=1;y--) {
			
			for(int i = 1 ;i<=y ;i++) {
				System.out.println("*");
			}
				System.out.println();
		
		
		}
	}
	public void pracitce11() {
		//   *   3칸 띄고 별 찍고 3칸
		//  ***  2칸 띄고 별 찍고 2칸 
		// ***** 1칸 띄고 별 찍고 1칸
		//*******
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 :");
		int input = sc.nextInt(); 		
		/*
		for(int x =1 ;x <=input ;x++) { //입력 받은 input 만큼 줄 출력
			
			//공백 출력 for문 
			for(int i = input -x ; i>=1 ;i--) {
				System.out.print(" ");
			}
				//별 출력 for문 
				//1 3 5 7 10  	
			for(int i = 1 ;i <=2*x-1 ;i++) {
				System.out.print("*");
			}
			System.out.println();
			
			}
			*/
		
		int star = 1;
		int space = input;
		
		
		for(int i =1 ;i<=input ;i++) {
			for(int j =1 ; j<=space-1;j++) {// 공백찍는
				System.out.print(" ");
			}
			for(int j =1;j<=star;j++) {//*찍는 
				System.out.print("*");
			}
			star+=2;
			space--;
			System.out.println();
		}
	}
	public void pracitce12() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 :");
		int input = sc.nextInt(); 	
		
		//row : 행(줄)
		//col(column) : 열(칸)
		
		for(int row=1;row<=input ;row++) {
			
			for(int col =1; col<=input;col++) {
				//row 또는 col이 1또는 input인 경우 *출력(==테두리)
				
				if(row ==1 || row ==input ||col ==1 || col==input) {
					System.out.print("*");
					
				}else { //내부는 띄어쓰기할거야 ! 
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
	public void pracitce14() {
		//1부터 사용자에게 입력 받은 수까지 중에 1~input
		//2와 3의 배수 모두 출력 
		//2와 3의 공배수?????
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("자연수 하나를 입력하세요 :");
		int input = sc.nextInt();
		int count =0;
		
		for(int i =1 ;i<=input ;i++) {
			if(i%2==0 || i%3==0) System.out.print(i+" ");
			if(i%2 ==0 && i%3==0) count++;
			}
	
		System.out.println("\ncount : "+ count); // 출력을 다 끝내고 줄바꾼다. 
	}
		
	
  
}