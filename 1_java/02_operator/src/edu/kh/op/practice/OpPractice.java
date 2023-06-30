package edu.kh.op.practice;

import java.util.Scanner;

public class OpPractice {

	public void practice1() {

		// 실습 1번
		// 모든 사람이 사탕을 골고루 나눠가지려고 한다. 인원 수와 사탕 개수를 키보드로 입력 받고
		// 1인당 동일하게 나눠가진 사탕 개수와 나눠주고 남은 사탕의 개수를 출력하세요.

		Scanner sc = new Scanner(System.in);

		System.out.print("인원수 : ");
		int input1 = sc.nextInt();

		System.out.print("사탕개수 :");
		int input2 = sc.nextInt();

		System.out.println("1인당 사탕 개수 : " + input2 / input1);
		System.out.println("남은 사탕 개수 : " + input2 % input1);

	}

	public void practice2() {

		/*
		 * 실습2번 이름 : 홍길동 학년(정수) : 3 반(정수) : 4 번호(정수) : 15 성별(남학생/여학생) : 남학생 성적(소수점 아래 둘째
		 * 자리까지) : 85.75 3학년 4반 15번 홍길동 남학생의 성적은 85.75점 입니다.
		 */
		Scanner sc = new Scanner(System.in);

		System.out.print("이름 :");
		String name = sc.next();

		System.out.print("학년(정수) :");
		int grade = sc.nextInt();

		System.out.print("반(정수): ");
		int cls = sc.nextInt();

		System.out.print("번호(정수) :");
		int number = sc.nextInt();

		System.out.print("성별(남학생/여학생):");
		String sex = sc.next();

		System.out.print("성적(소수점 아래 둘째 자리까지) :");
		double test = sc.nextDouble();

		// System.out.printf("d%학년 d%반 d%번 s% s%d의 성적은
		// d%입니다",grade,cls,number,name,sex,test);
		System.out.printf("d%학년 d%반 d%번 s% s%d의 성적은 %.2f입니다.\n", grade, cls, number, name, sex, test);
	}

	public void practice3() {

		// 정수를 하나 입력 받아 짝수/홀수를 구분하세요. (0은 짝수로 취급합니다)

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		String result = input % 2 == 0 ? "짝수" : "홀수";

		System.out.println(result + " 입니다.");

	}

	public void practice4() {

		// 실습 문제 4

		Scanner sc = new Scanner(System.in);

		System.out.print("국어 점수 : ");
		int kor = sc.nextInt();

		System.out.print("수학 점수 : ");
		int math = sc.nextInt();

		System.out.print("영어 점수 : ");
		int eng = sc.nextInt();

		System.out.println(" 합계 : " + (kor + math + eng));
		System.out.println("펑균 : " + (kor + math + eng) / 3);

		if (kor >= 40 && (kor + math + eng) / 3 >= 60) {
			System.out.println("합격");

		} else if (math >= 40 && (kor + math + eng) / 3 >= 60) {
			System.out.println("합격");

		} else if (eng >= 40 && (kor + math + eng) / 3 >= 60) {
			System.out.println("합격");

		} else {
			System.out.println("불합격");
		}

	}
}
