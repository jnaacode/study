package parkjina;

import java.util.Arrays;
import java.util.Scanner;

public class Study {
	
	private int i;


	public void ex1() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("인원 수 : ");
		int input1 = sc.nextInt();
		
		System.out.print("사탕 개수: ");
		int input2 = sc.nextInt();
	
		System.out.println();
		System.out.println("1인당 사탕 개수 : " + input2/input1 );
		System.out.println("사탕 개수 : " + input2%input1 );
		
		
	}
	
	public void ex2() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String input1 = sc.next();
		
		System.out.print("학년: ");
		int input2 = sc.nextInt();
		
		System.out.print("반 : ");
		int input3 = sc.nextInt();
		
		System.out.print("번호 : ");
		int input6 = sc.nextInt();
		
		System.out.print("성별: ");
		String input4 = sc.next();

		System.out.print("성적: ");
		double input5 = sc.nextDouble();
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f입니다."
				,input2,input3,input6,input1,input4,input5);
		
	}
		
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 : ");
		int input1 = sc.nextInt();
		
		if(input1 /2 ==0) {
			System.out.println("짝수입니다.");
		}else {
			System.out.println("홀 수 입니다.");
		}
		
	}
	
	public void ex4() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이입력 : ");
		int input1 = sc.nextInt();
		
		
		if(input1<0||input1>100) {
			System.out.println("잘못입력하셨습니다.");
		}else {
			System.out.println("키 입력 :");
			double height = sc.nextDouble();
		
		
		if(input1 <12) {
			System.out.print("적정 연령이 아닙니다.");
			
		}else if(height<140.0) {
			System.out.println("적정키가 아닙니다.");
		}else {
			System.out.println("탑승가능");
		}
		
		}
		
	}
	
	public void ex5() {
		
		//1부터 20까지 1씩 증가하면서 출력
		//단, 5의 배수()를 붙여서 출력
		//ex)1 2 3 4 (5) 6 7 8 9 (10)

		for(int i = 1 ; i <=20 ; i++){
		
		if(i % 5 ==0) {
			System.out.print("("+i+") ");
		}else {
			System.out.print(i+" ");
		}
		}
		
	}
	
	public void ex6() {
		
		// 1 부터 20까지 1씩 증가하면서 출력 
		// 단, 입력 받은 수의 배수는 () 표시
		
		Scanner sc = new Scanner(System.in);
		System.out.print("괄호를 표시할 배수 : ");
		int input1 = sc.nextInt();
		
		for(int i = 1 ; i <=20 ; i++){
			
			if(i % input1 ==0) {
				System.out.print("("+i+") ");
				
			}else {
				System.out.print(i+" ");
			}
		}
	}
	
	public void ex7() {
		
		  // [구구단 출력]
	      // 2 ~ 9 사이 수를 하나 입력 받아
	      // 해당 단을 출력
	      // 단, 입력 받은 수가 2 ~ 9 사이 숫자가 아니면 "잘못 입력 하셨습니다" 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print(" 단 입력 : ");
		int dan = sc.nextInt();
		
		if(dan>=2 && dan<10) {
		
		for(int i=0;i<=9;i++) {
			System.out.printf("%d X %d = %d\n",dan,i,dan*i);
		}
		
		}else {	
			System.out.print("잘못 입력 하셨습니다.");
		}
	}
	
	public void ex8() {
		//2중 for문 이용해서 다음 모양을 다섯번 출력하세요
		
		//12345
		//12345
		
		for(int i = 1 ; i<=5;i++) {
			for(int x =1;x<=5;x++) {
				System.out.print(x);
			}
			System.out.println();
		}
	}

	public void ex9() {
		
		for(int i = 1 ; i<=5;i++) {
			for(int x =1;x<=i;x++) {
				System.out.print(x);
			}
			System.out.println();
		}
	}
	
	public void ex10() {
		
		for(int i = 4 ;i>=1;i--) {
			for(int x =i ; x>=1;x--) {
				System.out.print(x);
			}
			System.out.println();
		}
	}
	
	public void ex11() {
		
		// count(숫자세기)
		//1부터 20까지 1씩 증가하면서 
		//3의 배수의 총 개수 출력
		//3 6 9 12 15 18 : 6개 
		//3의 배수의 합계 : 63
		
		int count = 0;
		int sum = 0;
		
		for(int i = 1 ;i<=20 ;i++) {
			
			if(i%3==0) {
				count++;
				sum+=i;
				System.out.print(i+" ");
			}
		}
		System.out.println(":"+count+"개");
		System.out.print("3의 배수의 합계 :"+sum);
		
	}
	public void ex12() {
		
	Scanner sc = new Scanner(System.in);
		
		int input = 0; 
		int sum = 0;
		
		do {
			
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			sum += input; //입력 받은 값을 sum에 누적 

		}while(input != 0);
		
		System.out.println("합계 :" + sum);
		
	
		
	}

	public void ex13() {
		
		Scanner sc = new Scanner(System.in);
		
		double[] height = new double[3];
		
		for(int i =0; i <height.length;i++) {
			
			System.out.print((i+1)+"번 키 입력 : " );
			
			height[i]=sc.nextDouble();
		}
		double sum = 0;
		System.out.print("입력받은키 : ");
		
		for(int i =0; i <height.length;i++) {
			System.out.print(height[i]+ " ");
			sum+=height[i];
		}
	
		System.out.printf("\n평균 : %.2f\n",sum /height.length);
		
	}
	
	public void ex14() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력받을 인원 수 ");
		int input =sc.nextInt();
		
		int[] score = new int[4];
		
		int sum =0;
		int avg=0;
		
		for(int i =0;i<score.length;i++) {
			System.out.print((i+1)+"번 점수 입력 : ");
			
			score[i]=sc.nextInt();
			sum+=score[i];
		}
		
		int max = score[0];
		int min = score[0];
			for(int i =0 ;i <score.length ;i++) {
			
			if(score[i] > max) { //최고점 비교 
					
			}else if(score[i] < min) {//최저점 비교 
				min = score[i];
			}
		}
			System.out.println("\n합계 : "+sum);
			System.out.printf("\n평균 : %.2f\n",sum/score.length);

	}
	
	
	public void ex15() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1 이상의 숫자를 입력하세요 :");
		int input = sc.nextInt(); 	
		
		if(input<1) {
			System.out.print("1이상의 수자를 입력해주세요.");
		}
		
		for(int i =input; i>=1;i--) {
			
			System.out.print(i+" ");
	
		}
	}
	
	public void ex16() {
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		System.out.print("정수 입력 : ");
		int input = sc.nextInt(); 
		
		for(int i =1; i<=input;i++) {
			
			System.out.print(i+" ");
	
			sum+=i;
			if(i<input) {
				System.out.print("+"+" ");
			}else {
				System.out.print("=");
			}
	
		}
		System.out.print(sum);
	}
	
	public void ex17() {
		
		Scanner sc = new Scanner(System.in);
		
		int count =0;
		
		System.out.print("첫번째 숫자: ");
		int input1 = sc.nextInt(); 
		
		System.out.print("두번째 숫자: ");
		int input2 = sc.nextInt(); 
		
		if(input1<1 || input2<1) {
			System.out.print("1이상의 숫자를 입력해주세요.");
		}else if(input1<input2){
			for(int i = input1;i<=input2;i++)
			System.out.print(i+ " ");
			
		}else {
			for(int i = input2;i<=input1;i++)
			System.out.print(i+ " ");
		}

		
	}
	public void ex18() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int x = 1; x <= input ; x++) {
			for(int i = 1; i <= input; i++) {
				if(i <= input - x) {
					System.out.print(" ");
				}else {
					System.out.print("*");
					
				}
			}
			System.out.println(); // 줄바꿈
		}
	}
	
	
	public void ex19() {
		
		Scanner sc = new Scanner(System.in);
		
		int [] height = new int [5];
		
		for(int i =0;i<height.length;i++) {
			System.out.print(i+1+"번 키 입력 : ");
			height[i]=sc.nextInt();
		}
		System.out.println();{
		
			int sum =0;
		System.out.println("입력 받은 키 :");
		
		for(int i =0;i<height.length ;i++) {
		System.out.print(height[i]+" ");
		
		sum+= height[i]; //배열에 저장된 값을 sum에 누적한다. 
		
		}
		System.out.printf("\n평균 : %.2f\n",sum /height.length);
		}
		
	}
	
	public void ex20() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 받을 인원 수 ");
		int input1= sc.nextInt();
		
		int[] arr = new int[input1];
		
		int sum =0;
		
		
		for(int i =0;i<arr.length;i++) {
			System.out.print((i+1)+"번 점수 입력 : " );
			arr[i]=sc.nextInt();
			
			sum+=arr[i];
			
		}
		System.out.println("합계 : "+sum);
		System.out.print("평균 : "+sum/arr.length);
	
		int max = arr[0];
		int min = arr[0];

		for(int i =0;i<arr.length;i++) {
			
			if(arr[i]>max) {
				max = arr[i];
				
			} else if( arr[i] < min ) { 
				min = arr[i];
			}
		}
		System.out.println("최고점 :"+max);
		System.out.println("최저점 :"+min);
	}

	public void ex21() {
		
		int [] arr = {100,200,300,400,500,600,700,800,900,1000};
		Scanner sc = new Scanner(System.in);
		
		boolean flag=true;
		
		System.out.print("정수 입력 : ");
		int input =sc.nextInt();
		
		for(int i =0;i<arr.length;i++) {
			if(input==arr[i]) {
				System.out.println(i+"번째 인덱스에 존재");
				flag = false;
			}
		}
		 if(flag) {
			 System.out.print("존재하지않음");
		 }
	}
	
	public void ex22() {
		
		String [] arr = {"사과","딸기","바나나","키워","멜론","아보카도"};
		
		Scanner sc= new Scanner(System.in);
		System.out.print("과일입력 : ");
		
		int count =0;
		
		String input = sc.next();
		
		for(int i =0;i<arr.length;i++) {
			if(input.equals(arr[i])) {
				System.out.print((i+1)+"번째 인덱스에 존재");
				count++;
			}
		}
		if(count==0) {
			System.out.print("존재하지않음");
		}
	}
	
	public void ex23() {
		
		int [] arr = {1,2,3,4,5};
		
		int [] copyArr=new int[arr.length];
		for(int i =0;i<arr.length;i++) {
			copyArr[i]=arr[i];
		}
		
	}
	
	public void ex24() {
		
		int [] lotto = new int [6]; 
		for(int i =0;i<lotto.length;i++) {
			int random = (int)(Math.random()*45+1);
			
			lotto[i]=random;
			
			for(int x =0;x<i;x++) {
				if(random==lotto[x]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(lotto);
		System.out.print(Arrays.toString(lotto));
	}
	public void ex25() {
		Scanner sc = new Scanner(System.in);

		System.out.println("두 정수를 입력 받아서 나누기 한 몫을 출력");
		System.out.print("정수 1 입력 : ");
		int input1 = sc.nextInt();

		System.out.print("정수 2 입력 :");
		int input2 = sc.nextInt();
	}


	public void ex26() {
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("나이 입력 :");
//		int age = sc.nextInt();
//		
//		//System.out.println("키 입력 :");
//		//double heigt = sc.nextDouble();
//
//		//String result;
//		
//		if (age < 0 || age > 100) {
//			System.out.println("잘못입력하셨습니다");
//		}else {
//			System.out.println("키 입력 :");
//			double height = sc.nextDouble();
//		
//			if (age <12) {
//				System.out.println("적정연령이아닙니다");
//	
//				
//			}else if (height < 140.0) {
//				System.out.println("적정 키가 아닙니다.");
//				
//						
//			}else {
//				System.out.println("탑승가능");
//			}
//		
//		
//		}
//	}
	Scanner sc = new Scanner(System.in);
	
	System.out.println("나이 입력 :");
	int age = sc.nextInt();
	
	//System.out.println("키 입력 :");
	//double heigt = sc.nextDouble();

	String result;
	
	if (age < 0 || age > 100) {
		result = "잘못입력하셨습니다.";	
		
	}else {
		System.out.println("키 입력 :");
		double height = sc.nextDouble();
	
		if (age <12) {
			result = "적정연령이아닙니다";
			
		}else if (height < 140.0) {
			result = "적정 키가 아닙니다.";
					
		}else {
			result = "탑승가능";
		}
	}
	}


}


	
	
	



	
	


