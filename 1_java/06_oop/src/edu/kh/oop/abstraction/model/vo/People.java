package edu.kh.oop.abstraction.model.vo;

// VO (Vaule Object) : 값 저장용 객체를 만들기 위한 클래스를 모아두는 패키지

public class People {// 국민(사람) 클래스
	
	//public으로 작성하면 캡슐화의 원칙을 지키기 위해서 private으로 바꿨다
	//출력하니 오류가 발생했다 -> getter setter으로 
	
	
	// 클래스란 ? 객체의 특성(속상/기능)을 정의한 것이다. 
	// == 객체를 만들기 위한 설계도 
	
	// 캡슐화
	//- 데이터와 기능을 하나로 묶어서 관리하는 기법 -> { }로 묶여있음 
	//- 데이터에 직접적인 접근을 제한 하는 것이 원칙이다. 
	//-> 직접 접근을 못하기 때문에 클래스 내부에 간접 접근 방법을 제공하는 기능을 작성해 둔다. 
	
	//***데이터 직접 접근 제한***
	// public(공공의)-> private(사적인, 개인적인)변경 
	
	
	// 속성 == 값 == 데이터 
	// 값을 저장하기 위한 변수 선언 
	// -> 국민이라면 공통적으로 가지고있는 속성만 작성(추상화)
	private String name;  
	private char gender;
	private String pNo;
	private String address;
	private String phone;
	private int age;
	// double bitCoin; 국민이 가지고 있어 ? 없는 사람도 있으니 공통점이 아니므로 제거 
	
	// 기능 == 행동 == 메소드
	
	public void tax() {
		System.out.println("세급을 냅니다.");
	}
	
	public void vote() {
		System.out.println("투표를 합니다.");
	}
	
	//캡슐화에서 사용할 간접 접근 기능 ( getter: 안쪽에 있는 값을 밖으로 가져간다. /setter : 밖에 있는 값을 객체안으로 가져올 수 있게한다.)
	
	public void setName(String name) { //setName == setter
		
		//외부로부터 전달 받은 name을 
		//현재 객체의 속성 중 name (==this.name)에 대입 
		this.name = name;
	}
	
	public String getName() {
		//현재 객체의 속성 중에서 name을 호출한 곳으로 반환하겠다. 
		return name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String string) {
		this.address = string;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//단축키 : alt + shift + s또는 상단 메뉴 Source
	// -> Generate Getters and Setters클릭 > select All >generate 선택 
	
}
