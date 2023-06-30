package edu.kh.control.condition;

import java.io.InputStream;
import java.util.Scanner;

class ConditionExample {

	public void ex1() {
		
		// if문
		// - 조건식이  true 일때만 내부 코드 수행 
		
		/*
		 * [작성법]
		 * 
		 * if(조건식){
		 * 
		 * 조건식이 true 일 때 수행할 코드 
		 * 
		 * }
		 * 
		 */
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정슈 입력 : ");
		int input = sc.nextInt();
				
		// 입력된 정수가 양수인지 검사 
				
		if(input > 0) {
			
			System.out.println("양수입니다");
		}
		
		if(input<=0) {
			System.out.println("양수가 아닙니다");
		}
		
	}
	
	public void ex2() {
		
		// if - else 문 
		// 조건식 결과가 true이면 if문 수행 
		// false이면  else구문 수행643 3 
		
		/*
		 * [작성법]
		 * 
		 * if(조건식){
		 * 		조건식이 true 일 때 수행할 코드 
		 * } else {
		 * 조건식이 false 일 때 수행할 코드 
		 * }
		 */

		Scanner sc = new Scanner(System.in);
		
		//홀짝 검사
		System.out.println("정수 입력 : ");
		int input = sc.nextInt();
		
		if (input % 2 != 0) {
			System.out.println("홀수입니다.");
		
		}else {// 짝수 또는 0 입력 시 수행 
			//** 중첩 if 문 **
			if(input ==0) {
				System.out.println("0 입니다.");
				
			}else {
				System.out.println("짝수 입니다.");
			}
				
		}
		
		}
		
		
		public void ex3() {
					
			// if : 만약에 이거면 
			// else if 그게 아님 이거면 
			// else 그게 아니면 
		
		// 양수, 음수, 0판별 
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("정수 입력 : ");
			int input = sc.nextInt();
			
			if(input > 0 ) { // input 이 양수일 경우 
				System.out.println("양수입니다");
				
			}else if (input <0) { // input이 음수일 경우 
				// 바로 위에 있는 if 문이 만족되지 않은 경우 수행 
				System.out.println("음수입니다");
				
			}else {
				//모든 if, else if가 만족디지 않은 경우 수행 
				System.out.println("0입니다");
				
			}
			
		}
			
			
		public void ex4() { // 선생님 답 
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("달 입력 : ");
			int month = sc.nextInt();
			
			// 봄 : 3,4,5
			// 여름 : 6,7,8
			// 가을 : 9,10,11
			// 겨울 : 12,1,2
			// 해당하는 계절이 없을 경우 " 해당하는 계절이 없습니다"출력 
			
			if (month ==3 || month == 4 || month == 5) {
				System.out.println("봄입니다.");
				
			}else if(month >= 6 && month <= 8 ) {
				System.out.println("여름입니다.");
				
			}else if(month >= 9 && month <=11 ) {
				System.out.println("가을입니다.");
				
			}else if(month ==12 || month == 1 || month == 2) {
				System.out.println("가을입니다.");
				
			}else{ //if , else if가 모두 false인 경우 
				System.out.println("해당하는 계쩔이 없습니다.");
			}
				
			
		}
		
		public void ex5() {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("달 입력 : ");
			int month = sc.nextInt();
			String season;
		
			// 봄 : 3,4,5
			// 여름 : 6,7,8
			// 가을 : 9,10,11
			// 겨울 : 12,1,2
			// 해당하는 계절이 없을 경우 " 해당하는 계절이 없습니다"출력 
			
			if (month ==3 || month == 4 || month == 5) {
				season = "봄";
				
			}else if(month >= 6 && month <= 8 ) {
				 season = "여름";
				
			}else if(month >= 9 && month <=11 ) {
				season = "가을";
				
			}else if(month ==12 || month == 1 || month == 2) {
				season = "겨울";
				
			}else{ //if , else if가 모두 false인 경우 
				season = "해당하는 계절이 없습니다.";
		
			}
			System.out.println(season);
		}
			
		public void ex6() {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("달 입력 : ");
			int month = sc.nextInt();
			String season;
		
			// 봄 : 3,4,5
			// 여름 : 6,7,8
			// 가을 : 9,10,11
			// 겨울 : 12,1,2
			// 해당하는 계절이 없을 경우 " 해당하는 계절이 없습니다"출력 
			
			if (month > 2 && month < 6) {
			season = "봄";
				
			}else if(month > 5 && month <9 ) {
				 season = "여름";
				
			}else if(month > 8 && month <12) {
				season = "가을";
				 
			}else if(month ==12 || month == 1 || month ==2) {
				season = "겨울";
				
			}else{ //if , else if가 모두 false인 경우 
				season = "해당하는 계절이 없습니다.";
			
			
			}
			System.out.println(season);
		}
		
		public void ex7() {
			
			Scanner sc = new Scanner(System.in);
			int age = sc.nextInt();
			
			//13세 이하면 어린이입니다. 
			//13세 초과 19이하면 : 청소년입니다.
			//19세 초과시 : 성이닙니다. 출력 
			

			/*
			if(age <= 13) {
				System.out.println("어린이 입니다.");
			
			}else if (age <=19) { //이미 앞에서 걸러져서 와서 굳이 && 쓸 필요가 없다.
				System.out.println("청소년 입니다.");
				
			}else {
				System.out.println("성인 입니다.");
			*/
			
			if (age<= 13) {
				System.out.println("어린이 입니다.");
			}else if (age > 19) {
				System.out.println("성인 입니다.");
			}else {
				System.out.println("청소년 입니다.");
			
			
			}

		}
		
		public void ex8() {
			
			// 점수(100점 만점)를 입력 받아
		      // 90점 이상 : A
		      // 80점 이상 90점 미만 : B
		      // 70점 이상 80점 미만 : C
		      // 60점 이상 70점 미만 : D
		      // 60점 미만 : F
		      // 0점 미만, 100 초과 : "잘못 입력하셨습니다"
		
			/*	
			Scanner sc = new Scanner(System.in);
			int score = sc.nextInt();
			String result;
			
		
			if(score >=90) {
				result = "A";
			}else if(score>=80 ) {
				result = "B";
			}else if(score>=70 ) {
				result = "C";
			}else if(score>=60 ) {
				result = "D";
			}else if(score<60){
				result = "F";
			}else {
				result = "잘못입력하였습니다.";
			}	
			System.out.println(result);		
			*/
			
			Scanner sc = new Scanner(System.in);
			System.out.println("점수입력(0~100) :");
			int score = sc.nextInt();
			String result;
				
			
			if(score<0 ||score >100) {
				result = "잘못 입력하셨습니다";
				
			}else if(score >=90) {
				result = "A";
				
			}else if(score>=80 ) {
				result = "B";
				
			}else if(score>=70 ) {
				result = "C";
				
			}else if(score>=60 ) {
				result = "D";
				
			}else if(score<60){
				result = "F";
			
			}else {
				result ="F";
			}	
			System.out.println(result);	
		}
	
	
		public void ex10() {
			
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
	
			System.out.print("나이 입력 : ");
			int age = sc.nextInt();
			String result;
			
			if(age < 0 || age >100) {
				result = "나이를 잘못 입력 하셨습니다.";
			
			}else {
				System.out.print("키 입력 : ");
				double height =sc.nextDouble();
				
				if(height <0 || height >250.0) {
					result = "키를 잘못 입력 하셨습니다.";
					
				}else {
					if(age < 12 && height >=140.0) { //나이 X , 키 O
						result = "키는 적절하나, 나이는 적절치 않음";
						
					}else if (age >= 12 && height <140.0) { //나이 O , 키 X
						result = "나이는 적절하나, 키가 적절히 않음";
						
					}else if (age< 12 && height < 140.0) {	//나이 X , 키 X
						result = "나이와 키 모두 적절치 않음";
					
					}else {
						result = "탑승가능";
					}
				
				}
				
		}
			System.out.println(result);
			
			/*
			if (age < 0 || age >100) {
				result = "나이를 잘못 입력 하셨습니다.";
				
			}else if (height < 0 || height >250.0) {
				result = "키를 잘못 입력 하셨습니다.";
			
			}else if (height < 0 || height >250.0) {
				result = "키를 잘못 입력 하셨습니다.";
			*/
			
			
		}

	
		}


