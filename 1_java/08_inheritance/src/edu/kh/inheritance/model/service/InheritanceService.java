package edu.kh.inheritance.model.service;

import java.util.Scanner;

import edu.kh.inheritance.model.vo.Employee;
import edu.kh.inheritance.model.vo.Person;
import edu.kh.inheritance.model.vo.Student;

public class InheritanceService {
	
	public void ex1() {
		
		//상속 확인 
		//-Person을 상속 받은 Student가 Person의 필드, 메소드를 사용할 수 있는다. 
		
		Person p1 = new Person();
//		p1.name = "홍길동"; //private 때문에 직접 접근 불가 
		
		p1.setName("홍길동");
		p1.setAge(25);
		p1.setNationality("대한민국");
		
		System.out.println(p1.getAge());
		System.out.println(p1.getNationality());
		System.out.println(p1.getName());
		
		
		System.out.println("----------------------------------");
		
		//Student 객체 생성
		
		Student std = new Student();
		
		//Student만의 고유한 메소드 
		std.setGrade(3);
		std.setClassRoom(5);
		
		//Person 클래스로 부터 상속받은 메소드
		std.setName("고아라");
		std.setAge(29);
		std.setNationality("대한민국");
		
		System.out.println(std.getGrade());
		System.out.println(std.getClassRoom());
		
		//Student가 Person의 필드 상속 받았는지 확인 
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
		
				
		System.out.println("----------------------------------");
		
		
		Employee emp = new Employee();
		
		//Employee만의 고유 메소드
		emp.setCompany("KH정보교육원");
		
		//Person클래스로 부터 상속 받은 메소드 
		emp.setName("다나카");
		emp.setAge(35);
		emp.setNationality("일본");
		
		System.out.println(emp.getCompany());
		System.out.println(emp.getName());
		System.out.println(emp.getAge());
		System.out.println(emp.getNationality());
		
		System.out.println("----------------------------------");
		
		//추가된 breath() 메소드 확인하기
		p1.breath();
		std.breath();
		emp.breath();
	}
	
	public void ex2() {
		
		//super() 생성자 사용 방법 
		// Student 매개변수 5개 짜리 생성자를 이용해서 Student 객체를 만들어라 
		
		Student std = new Student("공유",35,"한국",1,3) ;
		
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getGrade());
		System.out.println(std.getNationality());
		System.out.println(std.getClassRoom());
	}
	
	public void ex3() {
		//오버라이딩 확인 예제 
		
		Student std = new Student();
		Employee emp = new Employee();
		
		std.move();//오버라이딩 안한 것  -> Person의 메소드 수행
		emp.move();//오버라이딩 한 것 -> Employee의 메소드 수행
	}
	public void ex4() {
		
		//모든 클래스는 Object 클래스의 후손 
		// ★★ 모든 클래스의 최상위 부모는 Object이다.★★
		
		//1) Object 상속여부 확인 
		Person p = new Person(); //Object를 상속 받은 Person 객체 생성 

		Student std = new Student(); //Person을 상속 받은 Stduent 객체 생성 
		
		//Object = Person - Student
		
		Scanner sc = new Scanner(System .in);
		
		String str = "abc";
		
		
		//**Object 상속과 단계적인 상속 확인 
		
		System.out.println(p.hashCode());//Object에서 물려 받은 hashCode()
		
		System.out.println(std.getAge()); //Person에서 물려 받은 getAge()
		System.out.println(std.hashCode());
		//Person이 Object에서 물려 받은 hashCode()를 
		//Student가 또 물려 받아 사용 
		//-> 상속의 상속의 상속의 ...상속가능

		//*Object가 모든 클래스의 최상위부 부모인지 확인 
		System.out.println(sc.hashCode());
		//Object - hashCode()
		
		System.out.println(str.hashCode());
		//String - hashCode()
		//-> String이 Object에게 물려 받은 hashCode를 오버라이딩함
		
	}
	
	public void ex5() {
		
		Person p = new Person("박봉자",7,"한국"); //매개변수 3개자리 생성자
		System.out.println(p.toString());
		System.out.println(p);
		
		
		//print 구문 수행 시 참조 변수명을 작성하면
		//자동으로 toString() 메소드를 호출해서 출력한다! 

		System.out.println("----------------------------------");
		
		Student std = new Student("공유",41,"미국",2,6);
		System.out.println(std.toString());
		//1) Student 클래스 toString() 오버라이딩 전 
		//Person으로 부터 상속 받은 오버라이딩 된 toString()수행
		
		//2) Student 클래스 toStirng 오버라이딩 후 
		//Student toString() 수행
		
		System.out.println("----------------------------------");
		
		Employee emp = new Employee("김근로",26,"한국","00증권");
		System.out.println(emp);
		
		
		
	}
	

}
