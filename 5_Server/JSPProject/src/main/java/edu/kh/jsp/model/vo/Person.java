package edu.kh.jsp.model.vo;

public class Person {

	//캡슐화원칙으로 접근 못하도록 private으로 작성
	private String name;
	private int age;
	private String address;

	//기본 생성자
	public Person() {}
	
	//getter/setter 작성(alt+shift+s -> r) 
	
	public String getName() { //외부에서 현재 객체의 name을 얻어감
		return name;
	}

	public void setName(String name) { //외부에서 전달 받은 name을 현재 객체에 저장
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	
}
