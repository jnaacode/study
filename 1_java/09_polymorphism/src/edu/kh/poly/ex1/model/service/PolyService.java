package edu.kh.poly.ex1.model.service;

import edu.kh.poly.ex1.model.vo.Car;
import edu.kh.poly.ex1.model.vo.Spark;
import edu.kh.poly.ex1.model.vo.Tesla;

public class PolyService {

	public void ex1() {
		
		//다형성 확인 예제
		
		//Car 객체 생성 
		Car car = new Car();
		//부모타입 참조 변수 = 부모 객체를 참조 하겠다. 
		
		//Tasla 객체 생성
		Tesla tesla = new Tesla();
		//자식타입 참조 변수 = 자신 객체 
		
		//******다형성(업캐스팅)******
		Car car2 = new Tesla(); //-> 오류 발생 안함
		//Tesla 객체를 참조하는 변수의 타입이 Car(부모)이기 때문에 
		//Tesla 객체가 Car(부모) 객체로 변화함 
		
		Car car3 = new Spark();
		//부모타임 참조변수 = 자식 객체 
		
		//******다형성(업캐스팅)작성법******
		
		//1)자식 객체가 부모 객체로 변하였기 때문에 
		//  자식만의 고유한 필드, 메소드를 사용할 수 없다. 
		
		//1-1) car (부모 타입 참조 변수로 부모참조하고 있다./ 부모 = 부모)
		car.setEngine("v6 6기통 엔진");
		car.setFuel("휘발유");
		car.setWheel(4);
		//Car 메소드 모두 사용 가능
		
		//1-2) tesla (자식이 자식을 참조하고 있는 형태 / 자식 = 자식)
		tesla.setBatteryCapacity(1000000);
		tesla.setEngine("전기모터");
		tesla.setFuel("전기");
		tesla.setWheel(4);
		//Car 메소드 모두 사용 가능
		
		//1-3) car2 (부모타임 참조변수로 자식 tesla 참조하고 있는 형태 / 부모 = 자식(Tesla)) 
		car2.setEngine("전기모터");
		car2.setFuel("전기");
		car2.setWheel(4);
		//car2.setBatteryCapacity(1000000); 오류내용 The method setBatteryCapacity(int) is undefined for the type Car
		
		//1-4) car3(부모타입 참조변수로 자식 spark참조하고 있는 형태 / 부모 = 자식 (Spark))
		car3.setEngine("경차엔진");
		car3.setFuel("휘발유");
		car3.setWheel(4);
		//car3.setDiscountOffer(0.5); 오류내용 :The method setDiscountOffer(double) is undefined for the type Car
		
		
		//-------------------------------------------------------------------------------------------
		
		
		//2) 다형성을 이용한 객체 배열
		
		//객체배열 : 같은 객체 참조 자료형의 변수를 하나의 묶음으로 다루는 것 
		//+ 다형성 적용 -> 부모 타입 참조 자료형의 변수를 하나의 묶음으로 다루는 것 
		
		Car [] arr = new Car[3]; //부모타입 참조 변수 배열 선언 및 할당 
								// 각 배열 요소가 Car타입 참조 변수 
		
		arr[0] = car;//Car 주소 == Car 객체  
		//Car 참조변수
		
		arr[1] = car2; //Tesla 주소 == Tesla 객체 
		//Car 참조변수
		
		arr[2] = car3; //Spark 주소 = Spark객체
		//Car 참조변수
		
		//상속 + 다형성
		//상속특징 :일련의 클래스들에 대한 공통적인 규약 정의 
		//      -> Car 상속 클래스는 모두 getEngine()을 가지고 있다를 정의 
		//다형성(업캐스팅) : 부모타입참조 변수 arr[i]로 자식 객체를 참조할 수 있다. 
	
		for(int i =0;i<arr.length;i++) {
			System.out.println(i+"번째 인덱스의 엔진 : "+ arr[i].getEngine());
		}
	}
	
	public void ex2() {
		
		//3) 다형성(업캐스팅)을 이용한 매개변수 사용법 
		Tesla t = new Tesla("전기모터","전기",4,1000000);
		Spark s = new Spark("경차엔진","휘발유",4,0.5);
		Car c = new Car("경유엔진","경유",12);
		
		
		// 밑에 있는 printCar확인하기
		printCar(t); 
		printCar(s); 
		printCar(c); 
		
		System.out.println("--------------------------------------------------");
		
		//4) 다형성을 이용한 반환형 사용법
		
//		Car[] arr= {new Car(), new Tesla(), new Spark()};
		
		//다형성을 이용한 반환형 
		Car[] arr = {createCar(1),createCar(2),createCar(3)};
		            // Car       // Car        // Car -> 전부 반환형은 car지만 
								 //(Tesla)     // Spark -> 주소를 리턴 받는다. 
		
		//arr[0] = Car
		//arr[1] = Tesla
		//arr[2] = Spark
		
		//instanceof 연산자 : 객체의 자료형을 검사하는 연산자
		//-> 참조하는 객체가 특정 자료형 이거나 부모쪽 상속 관계인지 확인 
		
		//arr[1] 참조하는 객체가 Tesla이면 true 아니면 false 반환
		System.out.println(arr[1]instanceof Tesla); //true
		//arr[1] 참조하는 객체가 Spark이면 true 아니면 false 반환
		System.out.println(arr[1]instanceof Spark);
		//arr[1] 참조하는 객체가 Car이면 true 아니면 false 반환
		System.out.println(arr[1]instanceof Car); //true -> 부모도 나온다.
		
		System.out.println("---------------------------------------");
		
		for(int i =0;i<arr.length;i++) {
			if(arr[i] instanceof Tesla) {
				System.out.println("Tesla 객체 입니다.");
				
			}else if(arr[i] instanceof Spark) {
				System.out.println("Spark 객체입니다.");
			
			}else {
				System.out.println("Car 객체입니다.");
			}
			
		}
		
	}
	//전달 받은 Car 또는 자식 객체의 엔진, 연료,바퀴 개수를 출력하는 메소드
	//매개변수에 부모 타입 참조변수를 작성하면 모든 자식 객체를 전달 받을 수 있다. 
	
	public void printCar(Car temp) { //부모타입 참조변수 = 자식 객체 
		
		//매개변수에 작성된 참조형 변수에는 주소가 저장된다.(얕은복사)
		//메소드 내부 변수  + 매개변수 == 지역 변수(Local Variable)-> 가로안에서만 사용할 수 있다. 
		
		System.out.println("엔진 :"+temp.getEngine());
		System.out.println("바퀴개수 :"+temp.getWheel()+"개");
		System.out.println("연료  :"+temp.getFuel());
		System.out.println();		
	}
	
	//전달 받은 매개변수에 따라서 Car 또는 자식 객체를 생성하고, 
	//생성된 객체의 주소를 반환
	public Car createCar(int num) {
		
		Car result = null;
		//null은 아무것도 참조하고 있지 않다. 
		
		switch(num) {
		
		case 1: result = new Car();break;
		case 2: result = new Tesla();break;
		case 3: result = new Spark(); break;
		}
		//반환형이 Car이지만 case가 2,3이면 Car의 자식 객체의 주소가 반환된다. 
		return result;
	}
	
	public void ex3() {
		
		//*******다형성 중 다운 캐스팅*******
		
		//- 다운캐스팅이란 ? 
		//부모타입 참조변수가 자식객체를 참조하는
		//업 캐스팅 상태에서만 진행 할 수 있는 기술 
		
		//부모타입을 자식타입으로 "강제형변환"해서
		//자식 객체의 본래 필드,메소드를 사용 가능하게 한다. 
		
		Car c1 = new Tesla("전기모터","전기",4,50000); //업캐스팅 상태 만들고
		System.out.println( ((Tesla)c1).getBatteryCapacity());
		//주의! ".연산자가 
		//     (Tesla) 형변환 연산자보다 우선순위가 높다
		
		//<효율적인 다운 캐스팅 방법>
		// - 얕은 복사를 이용한다.
		
		Tesla t1 = (Tesla)c1;
		System.out.println(t1.getBatteryCapacity());
	}
	
	public void ex4() {
		
		//!!!!다운캐스팅 주의사항!!!!
		
		Car c1 = new Tesla();
		//Spark s1 = (Spark)c1; //다운 캐스팅 
		
		//java.lang.ClassCastException (형변환예외가 발생했다)
		//-> c1이 참조하는 객체는 Tesla인데, 
		//   Spark 참조변수로 Tesla 참조하려고 해서 문제 발생
		
		// ! 해결 방벙 : instanceof와 같이 사용하자 !
		if(c1 instanceof Spark) {
			Spark s1 = (Spark)c1; //다운 캐스팅 
			System.out.println("성공");
		
		}else {
			System.out.println("실패(Spark 타입이 아님)");
		}
		
	}
	
	public void ex5() {
		
		//바인딩(Binding)
		//- 실제 실행할 메소드 코드와 호출하는 코드를 연결 시키는 것 
		
		Car c1 = new Car("경유엔진","경유",8); //매개변수 생성자를 이용해서 객체를 만들었다.
		
		System.out.println(c1.getEngine());
		//Car 객체에 있는 gettEngine()메소드 호출 ==바인딩 
	    //String edu.kh.poly.ex1.model.vo.Car.getEngine()

		//프로그램 "실행 전"
		//- 컴파일러는 getEngine()메소드가 Car에 있는 걸로 인식해서
		//  c1.getEngine()호출코드와  
		//  String edu.kh.poly.ex1.model.vo.Car.getEngine() 메소드 코드를 연결 
		// -> 정적 바인딩
		
		System.out.println(c1.toString());
		//String edu.kh.poly.ex1.model.vo.Car.toString()
		//Car 참조변수 c1을 이용해서 Car 객체에 있는 오버라이딩 된 toString() 메소드 호출 
		
		//**다형성 적용 시 바인딩 **
		
		Car c2 = new Spark("경차엔진","휘발유",4,0.5);
		//업캐스팅 적용 -> 부모 부분만 참조 가능한 상태 
		
		System.out.println(c2.toString());
		//String edu.kh.poly.ex1.model.vo.Car.toString()
		//참조 변수 C2 Car 타입임으로 
		//toString()도 Car의 toString()호출 -> 정적 바인딩
		
		//하지만 실행 해보면 자식(Spark)의 toString()이 호출되는 것을 확인 가능!
		// -> 컴파일 시에는 부모 (Car)와 바인딩 == [정적 바인딩]
		// -> "실행 시" 에는 자식 (Spark)의 오버라이딩된 메소드와 바인딩 ==[동적바인딩]

		
		//**동적 바인딩 활용 방법 **
		
		Car [] arr = {
				new Car("경유엔진","경유",12),
				new Tesla("전기모터","전기",4,50000),
				new Spark("경차엔진","휘발유",4,0.3)
		};
		
		//arr 배열 요소가 참조하는 모든 객체의 필드 값을 출력 
		for(int i =0 ; i<arr.length;i++) {
			
			System.out.println(i + "번째 요소 :" +arr[i].toString());
		
			//실행전 : String edu.kh.poly.ex1.model.vo.Car.toString()
			//실행후 : 각 객체의 오버라이딩 된 toString()이 호출 됨 - 동적 바인딩 
		}
		
		//**동적 바인딩 장점**
		//- 업캐스팅 상태의 참조변수를 별도의 다운 캐스팅 없이 자식의 오버라이딩되 메소드를 수행할 수 있다.
		
	}
	
}
