package edu.kh.basic.model.service;

import edu.kh.basic.model.vo.PolyCar;
import edu.kh.basic.model.vo.PolySpark;
import edu.kh.basic.model.vo.PolyTesla;

public class PolyService {
	
	public void ex1() {
		
		PolyTesla polytesla1 = new PolyTesla();

		PolyCar polycar = new PolyCar();
		polycar.setEngine("일반엔진");
		
		PolyCar polyspark = new PolySpark();
		polyspark.setEngine("경차엔진");
		
		PolyCar polyTesla = new PolyTesla();
		polyTesla.setEngine("전기엔진");
		
		PolyCar [] arr = new PolyCar[3];
		
		arr[0] = polycar;
		arr[1] = polyspark;
		arr[2] = polyTesla;
		
		for(int i =0;i<arr.length;i++) {
			System.out.println(i+"번째 인덱스의 엔진 : "+arr[i].getEngine());
			
			System.out.println("---------------------------------------------------");
			
			
			PolyTesla t = new PolyTesla("전기모터","전기",4,1000000);
			PolySpark s= new PolySpark("경차엔진","휘발유",4,0.5);
			PolyCar c = new PolyCar("경유엔진","경유",12);
			
		}
	}
			
	public void ex2() {
		
		PolyCar c1 = new PolyCar("경유엔진","경유",8);
		System.out.println(c1.getEngine());
		//PolyCar 객체에 있는 getEngine() 메소드 호출 == 바인딩 
		
		//프로그램 "실행 전"
		//- 컴파일러는 getEngine()메소드가 PolyCar에 있는 걸로 인식해서
		//  c1.getEngine()호출코드와  
		//  String edu.kh.poly.ex1.model.vo.Car.getEngine() 메소드 코드를 연결 
		// -> 정적 바인딩
		System.out.println(c1.toString());
		

		PolyCar [] arr = {
				new PolyCar("경유엔진","경유",12),
				new PolyTesla("전기모터","전기",4,50000),
				new PolySpark("경차엔진","휘발유",4,0.3)
		};
		
		//arr 배열 요소가 참조하는 모든 객체의 필드 값을 출력 
		for(int i =0 ; i<arr.length;i++) {
			
			System.out.println(i + "번째 요소 :" +arr[i].toString());
		}
		
		
		
		
		
 
	}

}
