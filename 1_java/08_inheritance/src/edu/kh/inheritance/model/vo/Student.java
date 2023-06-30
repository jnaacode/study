package edu.kh.inheritance.model.vo;

public class Student extends Person {
	//Student 클래스에 Person 클래스 내용을 연장한다. 
	//== Student 클래스에 Person 클래스 내용(필드,메소드)을 추가하여 확장한다. 
	
	//**상속**
	//extends : 확장하다. 연장하다 
	
	
	
	//필드
	private int grade;
	private int classRoom;
	
	//생성자
	
	public Student() {
		// Student 객체 생성시 
		// 내부에 상속 받은 Person 객체를 생성하기 위한 
		// Person 생성자 호출 코드가 필요하다.}
		
		//super 상위 <-> sub :하위 
		//super == Person
		
		super(); //super() 생성자 
		// 부모의 생성자를 호출하는 코드
		// 반드시 자식 생성자 최 상단에 작성되어야한다!
		
		// * super()생성자 떄문에 
		// 자식 객체 내부에 부모 객체가 생성된다. 
		
		// * super 생성자 미 작성 시 컴파일러가 컴파일 단계에서 자동으로 추가된다.
		//(아까 super 안 적고 실행했는데 실행 되었잖아! 컴파일러 덕분에 실행된거야!)
	}
	
	public Student(String name, int age, String nationailty,int grade,int classRoom) {
		
		
		//전달 받은 값 중 name,age, nationality
		//부모 필드에 세팅하기 
		
		//this.name = name;//(x)
		//상속 받은 부모의 필드(name)를 자식의 필드처럼 사용하려 했으나 오류 발생 
		
		//왜 ? 부모의 필드에 private 접근 제한자가 있어서 아무리 물려 받은 자식이라도 다른 객체이기 때문에 직접 접근 불가 
		//-> 간접접근 방법을 사용 
		
		//setName(namne);
		//setAge(age);
		//setNationality(nationailty);
		//부모의 setter을 이용하면 되지만 비효율적이다...
		
		super(name,age,nationailty); //부모 매개변수 생성자 호출 
		
		
		this.grade =grade;
		this.classRoom =classRoom;
	}

	//메소드

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}

	
	//toString() 오버라이딩
	
	@Override
	public String toString() {
		
		//super참조변수
		return super.toString()+"/"+grade+"/"+classRoom;
	}
	
	
}
