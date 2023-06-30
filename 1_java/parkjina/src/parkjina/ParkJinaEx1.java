package parkjina;

import java.util.Scanner;

public class ParkJinaEx1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 :");
		String str = sc.nextLine();
		
		//  next() : 한 단어 (띄어쓰기 , 엔터를 만나면 입력 종료)
		//  nextLine() : 한 문장 (엔터를 만나면 입력을  종료)
		
		
		System.out.print(str);
		
		System.out.println("---------------------------");
		
		System.out.print("nextInt() :");
		int a = sc.nextInt();
		// 입력버퍼에 엔터가 하나 남아 있다. 
		
		sc.nextLine(); // nextInt 엔터를 제거하기 위해서 작성
		 			   // 만일 제거하지 않으면 뒤에 nextLine에 엔터를 만나서 종료가 된다. 
		
		System.out.print("nextLine():"); // 입력버퍼 : [ a b c (엔터) ]
		String s =sc.nextLine();
		
		System.out.println("종료");
		
		int b = sc.nextInt(); // 1(엔터)
		// 입력버퍼에 엔터 하나가 남아 있음 
		sc.nextLine(); // 입력버퍼에 남아 있는 (엔터)를 만나서 nextLine이 끝나버림 (입력 버퍼에 남아 있는 엔터 날려주기용)
		// 중간마다 엔터를 날려주는 애를 안넣어주면 바로 다음 실행되는 입력문과 실행이 안됨 
		int c = sc.nextInt(); // 2(엔터)
		int d = sc.nextInt(); // 3(엔터)
	
		
		}
	int num = 30;
	String str1 = "num은 30보다 큰수이다.";
	String str2 = "num은 30이하의 수다.";
	
	String result = num > 30? str1 :str2;
	

			
	}

