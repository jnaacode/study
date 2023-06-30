package parkjina;

import java.util.Scanner;

public class LoopEx {
	
	public void ex1() {
		
		for (int i = 3; i <=7; i++) {
			System.out.print(i + " ");
		}
	}
	public void ex2() {
		
		//1.0부터 입력 받은 실수까지 0.5씩 증가 
		
		
		Scanner sc =new Scanner(System.in);
		System.out.print("끝 번호 :");
		
		double num = sc.nextInt();
		
		for(double i =1.0 ; i <=num ; i+=0.5) {
			System.out.println(i + "출력");
		}
	}
	
	public void ex3() {
		
		for(char i ='A' ; i <='Z' ; i++) {
			
			System.out.print(i);
		}
	}
	
	public void ex4() {
		
		//반복문을 이용한 값의 누적 
		// 1부터 10까지 합계 
		
		int sum = 0;
	
		for(int i = 1 ; i <=10 ; i++) {
			
			sum += i; //sum+i=sum 0+1=sum
				
		}
			
		System.out.println(sum);	
	}
	
	public void ex5() {
		
		// 정수 5개를 입력 받아서 합계 구하기 
		// 스캐너 
		// 합계 
		
		Scanner sc = new Scanner(System.in);
		int sum =0;
		
		for(int i =1 ; i <=5 ; i ++) {
			
			System.out.print("입력"+i+":");
			int input =sc.nextInt();
			sum += input; //sum+input = sum
			
			System.out.print(sum);
		}
		
	
	}
		
	public void ex6() {
		
		int count =0;
		int sum =0;
		
		for(int i=1 ; i<= 20 ; i++) {
			
			if(i%3==0) {
				System.out.print(i+" ");
				count++;
				sum+=i;
			}
		}
		System.out.println(":"+count+"개");
		System.out.print("3의 배수의 합계 : "+sum);
	}
	
	public void ex7() {
		
		for(int i = 1; i<=4;i++) {
			
			for(int x =1 ;x<=i;x++) {
				System.out.print(x);
			}
			System.out.println();
		}
		
		
	}
	
	
}
		


		



