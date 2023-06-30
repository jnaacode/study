package edu.kh.oop.abstraction.model.service;

import edu.kh.oop.abstraction.model.vo.People;

//service 특정 기능(비즈니스로직)을 제공하는 클래스

public class AbstractionService {
	
	//해당 클래스가 객체가 되면 아래 예제 기능을 수행할 수 있다. 
	
	public void ex1() {
		
		//국민 객체 만들기 
		
		new People(); //import 안하면 오류생겨 ! 왜냐면 패키지가 다르잖아~ 
		
		People p1 = new People();
		//people p1 : people 객체에 주소를 저장하여 참조하는 변수 p1
		//new people() : 새로운 people 객체를 Heap영역에 생성 
		
		//*** 클래스 이름이 자료형처럼 사용되어 짐 ! == 클래스를 "사용자 정의 자료형"이라고 한다 ! ***
		
		People p2 = new People(); //p2에 객체를 만들어 보세요!
		//만들어진 객체는 추상화(공통점만 추출) 되어 있기 때문에 누군지 알 수 없다.  
		// -> 속성(데이터)를 추가하여 누구인지 알 수 있게 함(구체화)
		
		//직접 접근 방법 
//		p1.name = "다나카"; // The field People.name is not visible
		
		//setter를 이용한 간접접근 방법 
		p1.setName("다나카"); 
//		p1.age = 27;
		p1.setAge(27);
//		p1.gender = '남';
		p1.setGender('남');
//		p1.phone = "010-1234-2312";
		p1.setPhone("010-1234-1234");
//		p1.pNo ="002022-12345678";
		p1.setpNo("222222-123456789");
//		p1.address = "서울시 강남구";
		p1.setAddress("서울시 서초구");
		
		System.out.println("p1의 name : " +p1.getName());//간접접근 방법 
		System.out.println("p1의 age : " +p1.getAge());
		System.out.println("p1의 gender : " +p1.getGender());
		System.out.println("p1의 phone : " +p1.getPhone());
		System.out.println("p1의 pNo : " +p1.getpNo());
		System.out.println("p1의 address : " +p1.getAddress());
		
		System.out.println("------------------------------------");
//				
//		p2.name = "박진아";
//		p2.age = 20;
//		p2.gender = '여';
//		p2.phone = "010-1234-2312";
//		p2.pNo ="002022-12345678";
//		p2.address = "서울시 송파구";
//		
//		System.out.println("p1의 name : " +p2.name);
//		System.out.println("p1의 age : " +p2.age);
//		System.out.println("p1의 gender : " +p2.gender);
//		System.out.println("p1의 phone : " +p2.phone);
//		System.out.println("p1의 pNo : " +p2.pNo);
//		System.out.println("p1의 address : " +p2.address);
		
		p1.tax();
		p1.vote();
		p2.tax();
		p2.vote();
	}
	

}
