package oopex1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import oopex0.Student;

public class StudentService {
	
	private Scanner sc = new Scanner (System.in);
// 					      스캐너 객체 생성해서 객체의 시작 주소를
//	스캐너 참조 변수 sc에 저장한다.
	
	List<Student>studentList = new ArrayList<Student>();
	
	/**
	 * 메뉴출력용 메소드 
	 * @author 박진아
	 */
	public void displaymenu() {
		
		int menuNum =0;
		
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
			
			try {
				menuNum = sc.nextInt();
				System.out.println();
				
				switch (menuNum) {
				case 1:System.out.println(addStudent());break;
				case 2:selectAll() ;break;
				case 3:break;
				case 4:break;
				case 5:break;
				case 6:break;
		
				case 0:
					System.out.println("<프로그램 종료>");
					break;

				default:
					System.out.println("메뉴에 작성된 번호만 입력해주세요.");
				}
			}catch(InputMismatchException e) {
				System.out.println("입력 형식이 유요하지 않습니다. 다시 시도해주세요.");
				sc.nextLine();
			}

		} while (menuNum != -1); 
	}
	
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
		
		if(studentList.add(new Student(name,age,region,gender,score))) {
			return "성공 ";
		} else {
			return "실패";
		}

		
	}
	
	public void selectAll() {

		System.out.println("=====학생 전체 조회======");
		if(studentList.isEmpty()) {	
			System.out.println("학생정보가 없습니다.");
			return;
		}
			int index =0;
			for(Student std :studentList) {
				//std에는 for문이 반복 시 마다 0,1,2,...인덱스 요소들 한번씩 저장 됨 
				
				System.out.print((index++)+"번 : ");
				System.out.println(std);
		}
	}
	

		
	
}

	


