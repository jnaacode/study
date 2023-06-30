package edu.kh.poly.ex2.model.vo;

public abstract class Animal {
	
	//추상 클래스(abstract class)
	//1. 미완성 메소드(추상메소드)를 보유하고 있는 클래스 
	
	//2. (추상메소드는 없지만) 객체로 만들면 안되는 클래스 
	
	//필드
	private String type;//종, 과 구분 
	private String eatType;//초식 육식 잡식 

	//생성자 
	// - 추상 클래스는 new 연산자를 이용해서 직접적인 객체 생성은 불가능하지만
	//   상속 받은 객체 생성 시 내부 부모 부분이 생성될 때 사용된다.
	//   == super() 생성자

	public Animal() {
		super(); //생략 시 컴파일러가 추가 
	}
	
	public Animal(String type,String eatType) { 
		this.type =type;
		this.eatType = eatType;
		
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getEatType() {
		return eatType;
	}

	public void setEatType(String eatType) {
		this.eatType = eatType;
	}
	
	//toString() 오버라이딩 
	@Override //오버라이딩 되었음을 컴파일러에게 알려주는 어노테이션 
	public String toString() {
		return type+ "/"+eatType;
	}
	
	//동물의 공통 기능 추출 = 추상화
	//-> 동물은 공통적으로 먹고, 숨쉬지만 어떤 동물이냐 따라 그 방법이 다르다.
	//--> 그럼 어떡하지 ?
	//미완성 상태로 두어 상속받은 자식이 해당 메소드를 정의하도록 오버라이딩을 강제화 시킨다. 
	//(미완성 상태로 == 추상 메소드로 작성한다. )
	
	
	//먹다
	public abstract void eat();
	
	//숨쉬다
	public abstract void breath(); 
		
	
	
	
}

