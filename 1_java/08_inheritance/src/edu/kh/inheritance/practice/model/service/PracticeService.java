package edu.kh.inheritance.practice.model.service;

import java.util.Arrays;
import java.util.Scanner;

import edu.kh.inheritance.practice.model.vo.Employee;
import edu.kh.inheritance.practice.model.vo.Student;

public class PracticeService {

	public void homework() {

//		  3명의 학생 정보를 기록할 수 있게 객체 배열 할당 
		Student[] Student = new Student[3];

		// 위의 사용데이터 참고하여 3명의 학생 정보 초기화 // 위의 학생 정보 모두 출력 --> 향상된 for문 이용해서

		Student[0] = new Student("카리나", 20, 168.2, 70.0, 1, "정보시스템공학과");
		Student[1] = new Student("정해인", 21, 187.3, 80.0, 2, "경영학과");
		Student[2] = new Student("박서준", 23, 179.0, 45.0, 4, "정보통신공학과");

		for (int i = 0; i < Student.length; i++) {
			System.out.println(Student[i]);
		}

		// 최대 10명의 사원 정보를 기록할 수 있게 배열을 할당
		Employee[] ep = new Employee[10];

		Scanner sc = new Scanner(System.in);
		int count = 0;
		boolean flag = true;

		while (flag) {

			// 사원들의 정보를 키보드로 계속 입력 받고 --> while(true) 무한 반복문을 통해

			System.out.print("이름 : ");
			String name = sc.next();

			System.out.print("나이 : ");

			int age = sc.nextInt();

			System.out.print("신장 : ");
			double heigth = sc.nextDouble();

			System.out.print("몸무게 : ");
			double weight = sc.nextDouble();

			System.out.print("급여 : ");
			int salary = sc.nextInt();

			System.out.print("부서 : ");
			String dept = sc.next();

			ep[count++] = new Employee(name, age, heigth, weight, salary, dept);

			// 계속 추가할 것인지 물어보고, 대소문자 상관없이 ‘y’이면 계속 객체 추가
			System.out.print("계속 입력 하시겠습니까? (y/n) : ");
			char input = sc.next().toUpperCase().charAt(0);

			if (input == 'N') {
				flag = false;
				break;
			}
		}
		for(int i=0;i<count;i++) {
		System.out.println(ep[i]);
		}
	}
}
