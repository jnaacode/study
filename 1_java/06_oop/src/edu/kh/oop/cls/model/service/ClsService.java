package edu.kh.oop.cls.model.service;

import edu.kh.oop.cls.model.vo.Student; //다른 패키지에서 수입해온다. 
//import edu.kh.oop.cls.model.vo.TestVo; 
//The type edu.kh.oop.cls.model.vo.TestVo is not visible
//(default) class인 TestVo는 import 불가  (다른 패키지) 
import edu.kh.oop.cls.model.vo.User;

public class ClsService{
						// 부모 Student를 상속 받음 

	public void ex1(){

		//클래스 접근 제한자 확인하기 
		Student std = new Student();
		//public class인 Student는 import가 가능
		
//		TestVo test = new TestV();
		// Student 클래스는 클래스 제한자를 public으로 제한하여 인포트하여 작성할 수 있었지만,
		// TestVo는 클래스 제한자를 default로 작성하였고, 같은 패키지가 아니면 불러올 수 없다.
		
		
		System.out.println("다른 패키지 ");
		System.out.println(std.v1);
		//다른 패키지에서도 접근 가능한 public만 에러가 안난다. 
//		System.out.println(std.v2);
//		System.out.println(std.v3);
//		System.out.println(std.v4); 
		
		//위에 extends Student를 상속 받는다고 작성했기에, 
		//아까처럼 에러가 안나고 수행이 된다. 
//		System.out.println(v1);
//		System.out.println(v2); // protected 직접 접근가능 
//		System.out.println(v3); // int제한자 범위로 오류가 발생한다. 
//		System.out.println(v4); // private 제한자 범위로 오류가 발생한다. 
		
	}
	
	public void ex2() {
		
		//Static 필드 확인 예제
		//학생 객체 2개 생성 
		
		Student std1 = new Student();
		Student std2 = new Student();
		
		//학생 객체 name를 세팅 
		std1.setName("김철수");
		std2.setName("이영희");
		
		//정보출력 
		System.out.println(std1.Schoolname); //public 이기 때문에 직접 접근 가능 
		System.out.println(std1.getName());
		
		System.out.println(std2.Schoolname); //public 이기 때문에 직접 접근 가능 
		System.out.println(std2.getName());
		
		//schoolName 변경 
		std1.Schoolname = "KH정보교육원";
		System.out.println("변경 후 st1 :"+std1.Schoolname);//KH정보교육원
		System.out.println("Std2 :"+std2.Schoolname); //kh고등학교 (x) -> KH정보교육원
		
		//std3생성 
		Student std3 = new Student();
		System.out.println("Std3 :"+std3.Schoolname); // ->KH정보교육원 
		
		System.out.println(std3.getName());
		
		//schoolName에 노란줄이 뜨는 이유 -> 제대로 작성하지 않아서 
		//*** static이 붙은 필드(변수)는 클래스명.변수명으로 사용함 
		Student.Schoolname="KH";
		System.out.println("Student.Schoolname :"+Student.Schoolname);
		
		/* static 
		 * 
		 * 1) 공유 메모리 영역(또는 정적 메모리 영역)이라고 한다. 
		 * 
		 * why? 프로그램 시작시 static이 붙은 코드들은 모두  static영역에 생성되고,
		 * 프로그램이 종료될때까지 사라지지 않다. (정적)
		 * 
		 * 그리고 static 영역에 생성된 변수는 어디서든지 공유할 수 있다.(공유메모리영역)
		 * 
		 * 2)사용방법 : 클래스명.변수명
		 * 
		 */
	}
	
	public void ex3() {
		//생성자 확인 테스트 
		
		// Student 객체를 기본생성자를 이용해 생성하고 이를 참조하는 참조변수 S1에 대입
		Student  s1 = new Student();
						//기본 생성자 
//		 new Student / Student 클래스를 보고 Student객체를 만들겠다. 
//		 Student();Student객체가 생성된 후 기본 생성자에 작성된 코드를 수행 
		
		//User기본 생성자를 이용해서 객체 생성
		User u1 = new User();
		
		// User 객체 필드 초기화 확인
		System.out.println(u1.getUserAge());
		System.out.println(u1.getUserId());
		System.out.println(u1.getUserPw());
		System.out.println(u1.getUserAge());
		System.out.println(u1.getUserName());
		System.out.println(u1.getUserGender());
		
		//User 기본 생성자를 이용해서 객체 생성 
		
		User u2 =new User();
		
		System.out.println(u2.getUserAge());
		System.out.println(u2.getUserId());
		System.out.println(u2.getUserPw());
		System.out.println(u2.getUserAge());
		System.out.println(u2.getUserName());
		System.out.println(u2.getUserGender());
		
		//문제점 : u1이 참조하고 있는 User객체와 
		//      u2이 참조하고 있는 User객체의 필드 값이 모두 동일함
		//      why? 같은 기본 생성자 User 객체를 생성했기 때문에 (객체는 다른데 둘다 같은 값이 나오고있다)
		
		System.out.println("----------------------------------------");
		//해결방법 : setter를 이용해서 새로운 값을 대입 (아래 내용 매우 귀찮)
		
		u2.setUserId("asdf1234");
		u2.setUserPw("1feads");
		u2.setUserName("김길동");
		u2.setUserGender('여');
		u2.setUserAge(19);
		
		//해결방법 : 매개변수 생성자를 이용해서 객체가 생성될때부터 다른 값으로 필드를 초기화 시킨다.
		
		User u3 = new User("test3", "pass333");//매개변수생성자 
						//생성자 수행시 전달할 값을 작성(순서 꼭! 지켜야됨!)
		
		System.out.println(u3.getUserId());
		System.out.println(u3.getUserPw());
		
	} 
	public void ex4(){
        User u1 = new User(); //기본생성자 	
        User u2 = new User("user02","1q2w3e4r"); //매개변수 2개 생성 
        User u3 = new User("user03","whadjfudnsep","박서준",28,'남'); //매개변수 5개 생성
        User u4 = new User("user04","whadjfudnsep","고수",29,'남'); //매개변수 5개 생성
        User u5 = new User("user05","whadjfudnsep","공유",30,'남'); //매개변수 5개 생성
        System.out.printf("u1 : %s / %s / %s / %d / %c\n",
                u1.getUserId(), u1.getUserPw(), u1.getUserName(),
                u1.getUserAge(), u1.getUserGender() );

        System.out.printf("u2 : %s / %s / %s / %d / %c\n",
                u2.getUserId(), u2.getUserPw(), u2.getUserName(),
                u2.getUserAge(), u2.getUserGender() );

        System.out.printf("u3 : %s / %s / %s / %d / %c\n",
                u3.getUserId(), u3.getUserPw(), u3.getUserName(),
                u3.getUserAge(), u3.getUserGender() );

        System.out.printf("u4 : %s / %s / %s / %d / %c\n",
                u4.getUserId(), u4.getUserPw(), u4.getUserName(),
                u4.getUserAge(), u4.getUserGender() );

        System.out.printf("u5 : %s / %s / %s / %d / %c\n",
                u5.getUserId(), u5.getUserPw(), u5.getUserName(),
                u5.getUserAge(), u5.getUserGender() );
    
	}

}
