package parkjina;

import java.util.Scanner;

public class ParkJinaEx {
	
	public static void main(String[] args) {
		
		//System.out.print() : 단순 출력 (출력 후에 줄바꿈 x)
		//System.out.println () : 한줄 출력 (출력 후 줄 바꿈 수행)
		
		System.out.println("테스트1"); // 한줄출력, 줄 바꿈 가능
		System.out.println("테스트2"); //
		
		System.out.print("테스트3"); // 단순 출력, 줄 바꿈 불가 
		System.out.print("테스트4");
		System.out.println("테스트6");
		
		System.out.println("테스트7");
		
		
		int iNum1 = 10;
		int iNum2 = 5;
		
		// 10 + 10* 5 /2 = 35
		
		System.out.println(iNum1 + "+" + iNum1 + "*" +iNum2 +"/"+2 + "=" + (iNum1+(iNum1*iNum2/2)));
	
		System.out.printf("%d+%d*%d/2 = %d\n", iNum1,iNum1,iNum2,iNum1+iNum1*5/2);

		
		System.out.println("----------------------------------------------------------------------");
		
		
		//패턴연습 
		
		int iNum = 3;
		
		System.out.printf("%d\n", iNum);
		System.out.printf("%7d\n", iNum);
		System.out.printf("%-7d\n", iNum);
		
		System.out.println();
		
		
		System.out.printf("%f\n",10/4.0); 	// 2.500000
		System.out.printf("%.2f\n",10/4.0); // 2.50
		System.out.printf("%.0f\n",10/4.0); // 3	
		
		boolean isTrue = false;
		char ch = '얍';
		String str = "배고파요";
		
		System.out.printf("%b / %c /%s\n",isTrue,ch,str);
		
		System.out.println("\\o/"); //백슬래시 출력 방법
		
		System.out.println("a\tb\tc\td") ;// tap 출력
		
		System.out.println("\" "); //쌍 따옴표 단순 문자 출력
		
		System.out.println(" \' "); //홀 따옴표 단순 문자 출력
		
		System.out.println("\u0041"); // 유니코드(16진수) 번호로 출력
		
		// Scanner : 포로그램 실행 중 키보드 입력을 받을 수 있게 하는 역할 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 1 입력 : ");
		
		int input1 =sc.nextInt();
		
		System.out.print("정수 2 입력 : ");
		
		int input2 =sc.nextInt();

		System.out.printf("%d+%d=%d",input1,input2,input1+input2);
		
		
		
	}
	
	

}
