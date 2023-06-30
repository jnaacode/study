package edu.kh.oop.cls.model.vo;

public class User { //클래스에는 객체가 가지고 있어야할 속성 기능이 있어야한다. 
	
	//속성 (==필드)
	//캡슐화 원칙에 의해 필드는 기본적으로 private
	
	//아이디 , 비밀번호 , 이름 , 나이 , 성별 -> (추상화 진행)
	
	private String userId;
	private String userPw;
	private String userName;
	private int userAge;
	private char userGender;

	
	//기능 (==생성자+메소드)
	
	//생성자 : new연산자를 통해서 객체가 생성될때 
	//      1.생성된 객체의 필드값 초기화 + 2.기능 수행 역할 
	
	//기본 생성자 
	public User() {
		//2.기능수행역할 
		System.out.println("기본 생성자로 User 객체 생성");
		
		//1.필드값 초기화 
		userId = "user01";
		userPw = "user01";
		userName = "홍길동";
		userAge = 20;
		userGender = '남';
		
	}

	//매개변수 생성자 
	//**사용되는 기술, 변수 : 매개변수,Overloading(오버로딩),this
	
	//**매개변수 : 생성자나 메소드 호출 시 ()안에 작성되어 전달되어지는 값을 저장하는 변수 
	
	//-> 전달 받은 값을 저장하고 있는 매개체(지니고있는) 역할의 변수 
	
	public User(String userId, String userPw) {
				//매개변수 : 생성자 {가로 안}에서만 사용 가능! 
		
		System.out.println("매개변수 생성자를 이용해서 User 객체 생성");
		System.out.println(userId+"/"+userPw);
		
		//전달 받은 값을 필드에 초기화 (this 참조 변수)
		
		//***this 참조 변수 ***
		//- 객체가 자기 자신을 참조할 수 있도록 하는 변수 
		//- 모든 객체 내부에 숨겨져 있다. 
		// ? 왜 사용하는가 ?
		//-> 필드명과 매개변수명이 같을 경우 구분하기 위해 사용한다. 
		
		this.userId = userId;
		//필드    = 매개변수 
		this.userPw =userPw;
	}
		
		//필드를 전부 초기화 하는 목적의 매개변수 생성자 
		public User(String userId,String userPw,String userName,int userAge, char userGender) {
			
			
			//매개변수로 전달 받은 값으로 필드 초기화 
			//this.userId = userId; // 현재 객체가 가지고 있는 필드 userId에 
									// 매개변수 userId 값을 대입
			
			//this.userPw = userPw;
			
			this(userId,userPw); //this() 생성자
			// - 같은 클래스의 다른 생성자를 호출할때 사용 
			// - 생성자 내에서 반드시 첫번째 줄에 작성되어야 한다!! 

			//왜 사용하는 가 ? 
			
			//중복 코드 제거, 코드 길이 감소, 재사용성증가
			// (감독성이 어려운 경우가 생길 수 있어서 많이 사용되진 않음)  	
			
			
			this.userName = userName;
			this.userAge =userAge;
			this.userGender = userGender;
	}
		//자바는 기본적으로 필드명, 생성자명, 메소드명, 변수명의 중복을 허용하지 않는다. 
		
		/*
		private String userId; //Duplicate field User.userId
		public User() {}//Duplicate method User() in type User
		public String getUserId() {}//Duplicate method User() in type User
		public void ex() {
			int num = 10;
			int num =10; //Duplicate local variable num
		}
		 */
		
		//***오버로딩(Over Loading)***
		// - 클래스 내에서 동일한 이름의 메소드 (생성자도포함)을 여러 개 작성하는 기법 
	
		// --> 하나의 이름으로 여러기능을 수행할 수 있게 하는 것 이다. 
		
		//[오버로딩 조건]
		// 1. 메소드(생성자 포함)의 이름이 동일
		// 2. 매개변수 개수, 타입, 순서 중 1개라도 달라야함
		
		//public User() //기본 생성자가 이미 작성되어 있어서 중복
		public User(String userId) {} //매개변수 개수가 같은 생성자가 없어 오버로딩 성립한다.(1개자리가 없었음)
		
		public User(int userAge) {} // 매개변수 개수는 같지만 타입이 달라 오버로딩 성립 (int != String)
		
		public User(int userAge,String userId) {} //매개변수의 개수는 같지만 타입/순서가 달라 오버로딩 성립
		
		public User(String userId, int userAge) {}
		//매개변수 개수/타입은 가지만 순서가 달라 오버로딩 성립 
		
		public User(String userId,String userPw,String userName) {}
//		public User(String userName, String userId, String userPw) {} 에러발생 
		
		// 매개변수 개수 타입 순서가 모두 같아서 오버로딩 불가 (순서는 변수명이 중요한게 아니니 신경 쓰지마 ! String 순서가 같기에 에러발생한다) 
		
		
	
	//캡슐화로 인한 간접 접근 기능(getter /setter)
	public String getUserId() { //UserId의 getter
		return userId;
	}
	public void setUserId(String userId) { //UserId의 setter
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public char getUserGender() {
		return userGender;
	}
	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}
	
	
	

}
