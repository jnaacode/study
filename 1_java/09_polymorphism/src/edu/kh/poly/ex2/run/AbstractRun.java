package edu.kh.poly.ex2.run;

import edu.kh.poly.ex2.model.service.AbstractService;
import edu.kh.poly.ex2.model.service.Calculator;
import edu.kh.poly.ex2.model.service.JHSCalculator;
import edu.kh.poly.ex2.model.service.PJACalculator;

public class AbstractRun {
	public static void main(String[] args) {
	
		AbstractService service = new AbstractService();
//		service.ex1();
//		service.ex2();
		
		
		// Calculator 임폴트
		// import edu.kh.poly.ex2.model.service.Calculator;
		      
		// 각자 만든 xxxCalculator 임폴트
		// import edu.kh.poly.ex2.model.service.JHSCalculator;
		
		//Calculator cal = new PJACalculator();
		Calculator cal = new JHSCalculator();
		
		//Calculator cal = new Calculator();
		//인터페이스  == 미완성 설계도 == 객체 생성이 불가능하다. 
		// -> 추상 클래스처럼 참조 변수로는 사용 가능

		//코드의 큰 수정이 없이 객체생성 코드만 바꾸면 새로운 클래스 코드를 수행할 수 있다. 
		
		      
		System.out.println("합 : " + cal.plus(20, 15));
		System.out.println("차 : " + cal.minus(20, 15));
		System.out.println("곱 : " + cal.multiple(20, 15));
		System.out.println("몫 : " + cal.divide(20, 15));
		
		//인터페이스의 특징 
		//1) 인터페이스를 부모 참조 변수로 사용하면 
		//   다형성 업캐스팅이 적용되서 
		//   상속 받은 모든 클래스를 자식 객체로 참조 할 수 있다. 
		
		//-> 이를 이용하여 중요한 메인 코드의 수정을 최소화 할 수 있다. 
		//ex) Run에 작성된 합,차,곱,몫을 출력하는 코드 수정 없이 
		//    객체 생성 코드 한줄만 수정하여 다르게 작성된 기능을 수행 할 수 있다.
		
		//2) 자식 클래스에 공통된 메소드 구현을 강제하기 때문에 
		//   모든 자식 클래스가 동일한 형태를 띄게 된다. 
		// -> 이를 이용하여 공동 작업(팀 프로젝트)에 필요한 개발 환경을 조성 할 수 있다. 
		
		
	}		
		
}


