package practice;

import java.util.Scanner;

public class ConditionPractice {

	public void practice1 () {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 한개 입력하세요 : ");
		int input1 = sc.nextInt();
		
		if(input1 > 0 && input1%2==0 ) {
			System.out.print("짝수입니다.");
			
		}else if(input1%2==1) {
			System.out.print("홀수입니다.");	
				
		}else { 
			System.out.print("양수만 입력해주세요.");
			
		}
		
	}
	
	public void practice2 () {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		
		System.out.print("수학점수 : ");
		int eng = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int math = sc.nextInt();
		
		int score1 = kor+eng+math;
		double score2 = (kor+eng+math)/3;
	
		
		if( kor >= 40 && (kor+eng+math)/3 >=60) {
			//System.out.println("합격입니다.");
			//System.out.println("국어 :"+kor);
			//System.out.println("영어 :"+eng);
			//System.out.println("수학 :"+math);
			//System.out.println("합계 :"+score1);
			//System.out.println("평균 :"+score2);
			System.out.printf("국어 : %d\n 수학 : %d\n 영어 : %d\n 합계 : %d\n 평균 : %.1f\n" ,kor, eng, math, score1, score2);
			System.out.println("축하합니다, 합격입니다!");
		
		}else if( eng >= 40 && (kor+eng+math)/3 >=60) {
			System.out.println("합격입니다.");
		
		
		
		}else if( math >= 40 && (kor+eng+math)/3 >=60) {
			System.out.print("합격입니다.");
			
				
		}else {
			System.out.print("불합격입니다.");
		}
		
	}
	
	public void practice3() {
		
		Scanner sc= new Scanner(System.in);
		System.out.print("1~12 사이의 정수입력 :");
		int a = sc.nextInt();
		
		String month;
		
		switch(a) {
		case 1 : case 3 :case 5 :case 7 :case 8 :case 10 :case 31 :month = a+ "월은 31일까지 있습니다" ;break;
		case 11 : case 4 :case 6 :case 9 :month = a +"월은 30일까지 있습니다." ;break;
		case 2 : month = a + "월은 28일까지 있습니다." ;break;
		
		default : month = a + "은 잘못 입력된 달입니다."; 
		
		}
		System.out.print(month);
		}
		
	public void practice4() {	
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키(m)를 입력해 주세요 :");
		double height =sc.nextDouble();
		
		System.out.print("몸무게(kg)를 입력해 주세요 :");
		double weight =sc.nextDouble();
		
		double bmi = (weight/(height*height));
		
		System.out.println("BMI 지수 :"+bmi); // 코드는 위에서 아래 오른쪽으로 흐른다.
	
		if(bmi < 18.5) {
			System.out.println("저체중");
			
		}else if(bmi < 23) {
			System.out.println("정상체중");
			
		}else if(bmi<25) {
			System.out.println("과체중");
			
		}else if(bmi<30) {
			System.out.println("비만");
			
			}else {
				System.out.println("고도비만");
			}
		
		}
	
	public void practice5() {	// 집에 가서 다시 풀어보기 !	
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 :");
		double midTerm =sc.nextDouble();
		
		System.out.print("기말 고사 점수 :");
		double finalTerm =sc.nextDouble();
		
		System.out.print("과제 점수 :");
		double homework =sc.nextDouble();
		
		System.out.print("출석 횟수 :");
		double attendance =sc.nextDouble();
		
		if (attendance <=20 *(1-0.3)) { // 30%이상 결석 <-> 70%미만 출석 
			System.out.println("Fail [출석 횟수 부족 (" + (int)attendance+ "/20)]" ); //형변환
		
		}else {
			midTerm *=0.2;
			finalTerm *= 0.3;
			homework *= 0.3;
			attendance *=5*0.2;
			
			System.out.println("================= 결과 =================");
		}

		System.out.printf("중간 고사 점수(20) : %.1f\n",midTerm);
		System.out.printf("기말 고사 점수(30) : %.1f\n",finalTerm);
		System.out.printf("과제 점수 (30) : %.1f\n",homework);
		System.out.printf("출석 점수 (20) : %.1f\n",attendance);
		System.out.println("총점 : " + (midTerm+finalTerm+homework+attendance));
		
		if(midTerm+finalTerm+homework+attendance >= 70) {
			System.out.println("PASS");
			
		}else {
			System.out.println("Fail [점수 미달]");
		}
	}
		
}