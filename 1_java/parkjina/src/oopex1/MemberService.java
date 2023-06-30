//package oopex1;
//
//
//import java.util.Scanner;
//
//import oopex0.Member;
//
//public class MemberService {
//	
//	private Scanner sc = new Scanner(System.in);  
//	
//	private Member memberInfo = null;
//	private Member loginMember = null;
//	
//	public MemberService() {}
//	
//	public void displayMenu() {
//		
//		int menuNum =0;
//	
//		do {
//			System.out.println("=======회원 정보 관리 프로그램 v1=======");
//			System.out.println("1. 회원가입");
//			System.out.println("2. 로그인");
//			System.out.println("3. 회원 정보 조회");
//			System.out.println("4. 회원 정보 수정");
//			System.out.println("0. 프로그램종료");
//			
//			System.out.println("메뉴입력 >> ");
//			menuNum = sc.nextInt();
//			sc.nextLine();
//	
//			switch(menuNum) {
//			
//			case 1 : System.out.println(signUp());break;
//			case 2 : System.out.println(login());break;
//			case 3 : ;break;
//			case 4 : ;break;
//			case 0 : System.out.println("프로그램을 종료합니다."); ;break;
//				
//				default : 
//			}
//			
//		}while(menuNum!=0);
//		
//	}
//}
//
//			
//		
//		
//	
//
//	
//
//		