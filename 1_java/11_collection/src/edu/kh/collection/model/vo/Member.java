package edu.kh.collection.model.vo;

public class Member {
	
	private String id;
	private String pw;
	private int age;
	
	
	//빈공간에 단축키 :컨드럴 + 스페이스 
	public Member() {}	
	
	
	public Member(String id, String pw, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	//단축키 : [Alt + Shift + s -> s] -> [Enter]
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", age=" + age + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (age != other.age)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}






	//자동완성 alt + shift +s -> has

	
	
	//Object.equals()오버라이딩 
	//현재 객체와 매개변수로 전달 받은 객체의 필드가 같은지 비교하는 형태로 오버라이딩 
	/*
	 * @Override public boolean equals(Object obj) {
	 * 
	 * //매개변수 다운캐스팅 Member other = (Member) obj;
	 * 
	 * //필드값 비교 return
	 * this.id.equals(other.id)&&this.pw.equals(other.pw)&&this.age==other.age;
	 * 
	 * }
	 * 
	 * //Object.hashCode()오버라이딩
	 * 
	 * @Override public int hashCode() { //필드 값이 같은 객체는 같은 정수를 반환해야한다. //==필드값을 이용해서
	 * 정수를 만들면 된다.
	 * 
	 * 
	 * final int PRIME = 31; //31이 연산속도가 빠른 소수 중 하나 //소수
	 * 
	 * int result = 1; //결과 저장 변수
	 * 
	 * result = result*PRIME*age;
	 * 
	 * result = result*PRIME*(id==null?0:id.hashCode()); result =
	 * result*PRIME*(pw==null?0:pw.hashCode());
	 * 
	 * return result;
	 * 
	 * }
	 * 
	 */
	

}
