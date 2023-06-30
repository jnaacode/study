package edu.kh.collection.model.serivce;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Student;

/**
 * @author jina
 *
 */
public class StudentService {

	// 필드
	private Scanner sc = new Scanner(System.in);

	// java.utill.List인터페이스 : List에 반드시 필요한 필수 기능을 모아둔 인터페이스
	// *인터페이스는 객체 생성 x,부모 참조 변수로는 가능!

	// List StudentList = new List();

	// 인터페이스
	// 모든 메소드가 public abstract(추상메소드)
	// 미완성된 부분이 존재하는 클래스이기 때문에 객체를 생성해도 미완성 객체가 된다 !객체 생성불가!

	// ArrayList () 기본 생성자 : 기본 크키가 10칸 짜리 리스트를 생성
	// -> 하지만 리스트는 크키가 늘었다 줄었다 하기 때문에 큰 의미 없음

	// ArrayList(용량) :용량 만큼의 리스트 생성
	// -> 너무 큰 값을 작성하면 메모리를 많이 소모함

	// 학생정보를 저장할 List(객체배열 Upgrade 버전)
//	private List<Student> studentList = new ArrayList<Student>(); //검색(조회)에 효율적 
	private List<Student> studentList = new LinkedList<Student>(); //추가 삭제 수정  효율이 좋다 
	
	
	// Student 저장되는 타입이 제한된 리스트 수정 == Student만 저장이 가능 == 모든 Student = Student임을 검사할 필요없다!
	
	public StudentService() {
		
		studentList.add(new Student ("박진아",25,"서울 송파구",'f',90));
		studentList.add(new Student ("박도비",21,"서울 청담",'m',50));
		studentList.add(new Student ("김서아",27,"서울 강남구",'f',30));
		studentList.add(new Student ("강민수",29,"서울 송파구",'m',15));
		studentList.add(new Student ("박수아",31,"제주도",'f',75));
		
		
	}
	
	
	

	public void ex() {
		// List test

		// List.add(Object e) : 리스트에 객체를 추가
		// *매개변수 타입이 Object == 모든 객체를 매개변수로 전달할 수 있다.
		// (매개변수 Object == 최상위 부모 참조 변수 == 다형성 적용 가능)

		studentList.add(new Student()); // 0번째 인덱스
//		StudentList.add(sc);			//1번째 인덱스
//		StudentList.add("문자열");		//2번쨰인덱스
//		StudentList.add(new Object());	//3번쨰인덱스
		// ->컬렌션 특징 : 여러타입의 데이터를 저장 할 수 있다.

//		*위에 3개 주석처리 한 이유  
//		List<Student> StudentList = new ArrayList<Student>();student만 저장 가능하다라고 설정해줘서! 
//		나머지 타입은 오류가 난다. 

		// (반환형)
		// Object list.get(index i) : 리스트에서 i번째 인덱스에 있는 객체(Object)를 반환한다.
		// 반환형 Object == 모든 객체를 반환할 수 있다.

		System.out.println(studentList.get(0).toString());
		// 실행전 : java.lang.Object.toString() == 정적 바인딩
		// 실행후 : 알고보니 0번째는 Student객체이고, toStirng()오버라이딩 되어있음
		// -> Student toString()이 수행됨 == 동적바인딩

		// Student의 이름만 얻어오기
		// Student 객체가 맞는지 확인하고 다운캐스팅을 해야 Student 기능을 사용할 수 있다.

		if (studentList.get(0) instanceof Student) {
			System.out.println(((Student) studentList.get(0)).getName());
		}
		// -> 길고 복잡함
		// -> 컬렉션의 장점인 여러객체 저장이 코딩에 방해됨

		// ********************그래서 등장 했다 -> 제네릭스(Generics)*******************
		// 보통은 제너릭이라고 함 <> 로 표시한다.
		// [제일중요한 역할]
		// -> 컬렉션에 저장되는 객체 타입을 한 가지로 제한

		System.out.println(studentList.get(0).getName());

	}

	// 메소드 설명용 주석
	/**
	 * 메뉴출력용 메소드 (alt+shift+j)
	 * 
	 * @author 박진아
	 */
	public void displayMenu() {

		int menuNum = 0;

		do {
			System.out.println("\n============학생관리프로그램============\n");
			System.out.println("1. 학생정보추가");
			System.out.println("2. 학생전체조회");
			System.out.println("3. 학생정보수정");
			System.out.println("4. 학생정보제거");
			System.out.println("5. 이름으로 검색(일치)");
			System.out.println("6. 이름으로 검색(포함)");

			System.out.println("0. 프로그램 종료");
			System.out.print("\n 메뉴번호선택 >> ");

			// +기호 같은걸 잘못 눌렀을때를 위해 try-catch문을 쓴다.
			try {
				menuNum = sc.nextInt();
				System.out.println();

				switch (menuNum) {
				case 1:System.out.println(addStudent());break;
				case 2:selectAll();break;
				case 3:System.out.println(updateStudent());break;
				case 4:System.out.println(removeStudent());break;
				case 5:searchName1();break;
				case 6:searchName2();break;

				case 0:
					System.out.println("<프로그램 종료>");
					break;

				default:
					System.out.println("메뉴에 작성된 번호만 입력해주세요.");

				}

			} catch (InputMismatchException e) {
				System.out.println("\nerror:입력형식이 유효하지 않습니다. 다시 시도해주세요.");
				sc.nextLine();// 입력 버퍼에 남아있는 잘못 입력된 문자열 제거 제거 안하면 무한돌기 한다!

				// menuNum = -1 //첫반복 시 잘못입력하는 경우, menuNum이 0을 가지고 있어서 종료되는데
				// 이를 방지하기 위해서 임의값 -1 대입

			}

		} while (menuNum != -1); /// 위에 -1 안쓰고 싶다면 여기에 -1이라고 작성하면 된다.

	}

	/**
	 * 1. 학생 정보 추가메소드 - 추가 성공시 "성공" , 실패시 "실패"문자열 반환
	 */
	public String addStudent() throws InputMismatchException {

		System.out.println("===========학생정보추가===========");
		System.out.print("이릅 : ");
		String name = sc.next();

		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.print("사는곳 : ");
		String region = sc.nextLine();

		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		// String -> char 바꿔주는 것 !

		System.out.print("점수 :");
		int score = sc.nextInt();

		// Student 객체 생성 후 List에 추가

		if (studentList.add(new Student(name, age, region, gender, score))) {// 객체 학생리스트에 추가해줘! 잘 추가가 되었다면 성공!값이 반환해줘
			// boolean java.until.List.add(Student e)
			// (반환형) -> 제네릭 <Student>때문이 List 타입이 Student제한됨

			// add()무조건 true 반환하기 때문에 실패하는 경우 없음 !
			// 대신 예외가 발생해서 add() 수행 전에 메소드가 종료 될 순 있음
			return "성공";
		} else {
			return "실패";
		}

	}

	/**
	 * 2. 학생 전체 조회 메소드 
	 */ 
	public void selectAll() {
		// List는 인덱스가 있다(0번째부터 시작)
		// List에 저장된 데이터의 개수를 얻어오는 방법 : int List.size()
		// ->배열명 .length대신 사용
		
		//-> List가 비어 있는 지 확인 하는 방법 
		//boolean java.util.List.isEmpty():비어 있으면 true를 반환
		
		System.out.println("=====학생 전체 조회======");
		
		//studentList가 비어 있는 경우 "학생 정보가 없습니다."출력 
		
		//if(studentList.size() == 0) {
		if(studentList.isEmpty()) {	
		System.out.println("학생정보가 없습니다.");
			
			return; //현재 메소드를 종료하고 호출한 곳으로 돌아감 
					//단, 반환값은 없음(void)
			
		}
		
//		for(int i =0;i<studentList.size();i++) {
//			System.out.println(studentList.get(i));
//			//					studentList에서 i번째 인덱스 요소를 얻어와 출력 
//			
//		}
		//향상된 for문 (for each문)
		//- 컬렌션, 배열의 모든 요소를 순차적으로 반복 접근할 수 있는 for문
		//(순차적 : 0번 인덱스부터 마지막 요소까지 인덱스를 1씩 증가)
		
		//[작성법] 
		//for (컬렉션 또는 배열에서 꺼낸 한개의 요소를 저장할 변수 : 컬랙션명 또는 배열명)
		
		int index =0;
		for(Student std :studentList) {
			//std에는 for문이 반복 시 마다 0,1,2,...인덱스 요소들 한번씩 저장 됨 
			
			System.out.print((index++)+"번 : ");
			System.out.println(std);
		}
	}
	
	/**
	 * 3. 학생 정보 수정 메소드
	 */
	public String updateStudent() throws InputMismatchException {
		
		//Student List.set(int index,Student e)
		//     -> List의 i번째 요소를 전달 받은 e로 변경 
		//     -> 반환값 Student == 변경 전 Student 객체가 담겨있다
		
		System.out.println("=====학생 정보 수정======");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		//1)학생정보가 studentList에 있는가 ? 
		if(studentList.isEmpty()) {	
			return"학생정보가 없습니다.";
			
			//2) 입력된 숫자가 0보다 작은가 ? (음수검사)
		}else if(index <0) {
			return "음수는 입력 할 수 없습니다.";
			
			//3) 만약 문자열을 입력한 경우  -> throws로 예외 처리 
			
			//4) 입력 받은 숫자가 studentList 범위 내 인덱스 번호인가 ? 
		}else if(index>=studentList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다.";
			
		}else {
			
			//수정코드를 작성
			System.out.println(index+"번째 인덱스에 저장된 학생 정보");
			
			System.out.println(studentList.get(index));
			
			System.out.print("이름 : ");
	         String name = sc.next();
	         
	         System.out.print("나이 : ");
	         int age = sc.nextInt();
	         sc.nextLine(); // 입력 버퍼 개행 문자 제거
	         
	         System.out.print("사는곳 : ");
	         String region = sc.nextLine();
	         
	         System.out.print("성별(M/F) : ");
	         char gender = sc.next().charAt(0);
	                  // String -> char
	         
	         System.out.print("점수 : ");
	         int score = sc.nextInt(); // InputMismatchException
		
	         //입력 받은 index 번째에 새로운 학생정보를 세팅 == 수정 
	         //이때, index번째에 있는 기존 학생 정보가 반환 된다. 
	         Student temp = studentList.set(index, new Student(name,age,region,gender,score));
	         
	         return temp.getName()+"의 정보가 변경되었습니다.";
		}
		
	}
	
	/**
	 * 4. 학생 정보 제거 메소드 
	 */
	public String removeStudent() throws InputMismatchException {
		
		//Student List.remove(int index)
		//리스트에서 index번째 요소를 제거 
		//이때, 제거된 요소가 반환된다. 
		
		//*List는 중간에 비어있는 인덱스가 없게하기 위해서 
		// remove()동작시 뒤쪽 요소를 한칸 씩 당겨온다. 
		
		System.out.println("=====학생 정보 제거======");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		//1)학생정보가 studentList에 있는가 ? 
		if(studentList.isEmpty()) {	
			return"학생정보가 없습니다.";
			
			//2) 입력된 숫자가 0보다 작은가 ? (음수검사)
		}else if(index <0) {
			return "음수는 입력 할 수 없습니다.";
			
			//3) 만약 문자열을 입력한 경우  -> throws로 예외 처리 
			
			//4) 입력 받은 숫자가 studentList 범위 내 인덱스 번호인가 ? 
		}else if(index>=studentList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다.";
			
		}else {
			
			//학생 정보 제거 
			System.out.print("정말 삭제 하시겠습니까?(y/n) : ");
			char ch = sc.next().toUpperCase().charAt(0);
			//	      String -> 대문자 String -> 대문자 0번째 인덱스 문자 
			//		  String.toUppercase(): 문자열을 대문자로 변경

			if(ch=='Y') {
				Student temp = studentList.remove(index);
				return temp.getName() + "의 정보가 제거 되었습니다.";
			
			}else {
				return "취소";
			}
		}
	
		
		
	}
	/**
	 * 이름이 일치하는 학생을 찾아서 조회하는 메소드 
	 */
	public void searchName1() {
		
		System.out.println("=====학생 검색(이름일치)======");
		
		System.out.println("검색할 이름 입력 : ");
		String input = sc.next();
		
		boolean flag = true;
		
		//향성된 for문 작성
		for(Student std :studentList) {
			
			if(input.equals(std.getName())) {//이름이 일치하는 경우
				//일치한 학생의 정보 출력 
				System.out.println(std);
				flag = false;
			}
		}
			if(flag) {
				  //flag가 true인 경우 == for문 내에 있는 if가 수행된 적 없다 
			      //== 검색 결과가 없다. 				
					
				System.out.println("검색 결과가 없습니다.");
			}
			
		}
	/**
	 * 이름에 특정 문자열이 포함되는 학생을 찾아서 조회하는 메소드 
	 */
	public void searchName2() {
		
		//contains : 포함 (포함관계이기때문에 순서주의!)
		//boolean String.contains(문자열): String에 문자열이 포함되어 있으면 true

		
		System.out.println("=====학생 검색(문자열 포함)======");
		System.out.println("이름에 포함되는 문자열 입력 : ");

		String input = sc.next();

		boolean flag = true;

		// 향성된 for문 작성
		for (Student std : studentList) {

			if (std.getName().contains(input)){
				System.out.println(std);
				flag = false;
			}
		}
		if (flag) {
			// flag가 true인 경우 == for문 내에 있는 if가 수행된 적 없다
			// == 검색 결과가 없다.

			System.out.println("검색 결과가 없습니다.");
		}

	}
}


