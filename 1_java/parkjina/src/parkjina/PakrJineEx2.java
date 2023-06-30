package parkjina;

import java.util.Scanner;

public class PakrJineEx2 {
	
	private static final int x = 0;

	public void ex1() {
		
		int a = 100;
		
		// a는 100이상이면서  짝수인가 ? 
		System.out.println(a>=100); //true
		System.out.println(a % 2 ==0); //true
		
		// && 를 이용해서 한번에 출력 
		System.out.println(a>=100 && a%2==0); //true
		
		int b =5;
		//b는 1부터 10끼지 숫자 범위에 포함되어 있는가 ? 
		
		System.out.println(b>=1 && b <=10); //true
		
		int c = 10;
		System.out.println(c<10 || c%2==0); //true
		System.out.println(c<10 || c%2==1); //fasle
		
		boolean boo1 = true;
		boolean boo2 = ! boo1;
		
		System.out.println("boo1 :" + boo1); //true
		System.out.println("boo2 :" + boo2); //false
		
		// 1이상 이면서 100이하 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int input = sc.nextInt();
		
		boolean result1 = input >= 1 && input <=100;
		System.out.printf("%d은/는 1이상, 100이하의 정수인가 ? : %b\n", input,result1);
	
		
		int num =30 ;
		String str1 = "num은 30보다 큰수이다.";
		String str2 = "num은 30이하의 수이다.";
		
		String result = num > 30 ? str1 : str2;
		
		System.out.println(result);
				
		
	}

	public void ex2() {
		
		//입력된 정수가 양수인지 검사를 할거야 
		
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 :");
		int input = sc.nextInt();
		
		
		if(input<0) {
			System.out.print("음수입니다.");
		
		}
		
		if(input>0) {
			System.out.print("양수입니다.");
		}
		
		// 홀짝 검사 
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("정수 입력 :");
		
		int input1 = sc1.nextInt();
		
		if (input1 % 2 != 0) {
			System.out.println("홀수입니다.");
				
			}else {
				System.out.println("짝수 입니다.");
			}
	
		// 양수 음수 0판별 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 :");
		int input1 = sc.nextInt();
		
		if(input1<0) {
			System.out.println("음수입니다.");
		
		}else if(input1>0) {
			System.out.println("양수입니다");
			
		}else {
			System.out.println("0입니다");
		}
			
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("달 입력 : ");
		int month = sc.nextInt();		
		
		if (month ==3 || month == 4 || month == 5) {
			System.out.println("봄입니다.");
			
		}else if(month >= 6 && month <= 8 ) {
			System.out.println("여름입니다.");
			
		}else if(month >= 9 && month <=11 ) {
			System.out.println("가을입니다.");
			
		}else if(month ==12 && month == 1 && month == 2) {
			System.out.println("가을입니다.");
			
		}else{ //if , else if가 모두 false인 경우 
			System.out.println("해당하는 계절이 없습니다.");
		}
     */
	
		
		}
	/*
	public void ex3() {
	//13세 이하면 어린이입니다. 
	//13세 초과 19이하면 : 청소년입니다.
	//19세 초과시 : 성인입니다. 출력 
	
		
	Scanner sc = new Scanner(System.in);
	
	System.out.println("나이 입력 : ");
	int a = sc.nextInt();
	
	if(a<=13) {
		System.out.println("어린이입니다.");
	
	}else if(a<=19) {
		System.out.println("청소년입니다.");
		
	}else{
		System.out.println("성인입니다.");
	}
	
		
		
		// 점수(100점 만점)를 입력 받아
	      // 90점 이상 : A
	      // 80점 이상 90점 미만 : B
	      // 70점 이상 80점 미만 : C
	      // 60점 이상 70점 미만 : D
	      // 60점 미만 : F
	      // 0점 미만, 100 초과 : "잘못 입력하셨습니다"
		
		Scanner sc = new Scanner(System.in);
		System.out.println("점수 입력 : ");
		int score = sc.nextInt();
		String result;
		
		if(score<0 || score>100) {
			result = "잘못 입력하셨습니다";
		
		}else if (score >= 90) {
			result = "A";
		
		}else if(score >= 80 && score <90) {
			result = "B";
		}else if(score >= 70 && score <80) {
			result = "=C";
		}else if(score >= 60 && score <70) {
			result = "=D";
		}else if(score <60) {
			result = "=F";
			
		}else {
			result = "=F";
		}
				
		System.out.println(result);
			
		
		// 놀이기구 탑승 제한 검사 프로그램
	      // 조건 - 나이 : 12세 이상
	      //     -  키 : 140.0cm 이상
	      
	      // 나이를 0~100세 사이로 입력하지 않은 경우 : "나이를 잘못 입력 하셨습니다."
	      // 키를 0~250.0cm 사이로 입력하지 않은 경우 : "키를 잘못 입력 하셨습니다."
	      // -> 입력이 되자 마자 검사를 진행하여 잘못된 경우 프로그램 종료
	      
	      // 나이 O , 키 X : "나이는 적절하나, 키가 적절치 않음";
	      // 나이 X , 키 O : "키는 적절하나, 나이는 적절치 않음";
	      // 나이 X , 키 X : "나이와 키 모두 적절치 않음";
	      // 나이 O , 키 O : "탑승 가능"
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력 :");
		int age = sc.nextInt();
		String result;
		
		if(age<0 || age >100) {
			result = "나이를 잘못 입력하셨습니다";
			
			}else {
				System.out.println("키 입력 : ");
				double height =sc.nextDouble();
				
				if(height>0 ||height<250.0) {
					result ="키를 잘못 입력 하셨습니다";
					
				}else {
					if(age >=12 && height <140.0) {
						result = "나이는 적절하나, 키가 절적하지 않음";
						
					}else if (age< 12 && height < 140.0) {	//나이 X , 키 X
						result = "나이와 키 모두 적절치 않음";
					
					}else {
						result = "탑승가능";
						
					}
					
			}
		}
		
	System.out.println("탑승가능");
	}
	*/
		public void ex4() {
			
			Scanner sc = new Scanner(System.in);
			// System.in : 키보드 입력 
			System.out.println("정수 입력 : ");
			int input = sc.nextInt();
			String result;
			
			switch (input) {
			case 1: result = "빨간색";break;
			case 2: result = "주황색";break;
			case 3: result = "노란색";break;
				
			default : result = "흰색";break;
				
			}
			System.out.println(result);


		
			
		}
		
		
}
		
	


	
	


