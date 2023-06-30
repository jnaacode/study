package edu.kh.jdbc.member.view;

import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.member.model.service.MemberService;
import edu.kh.jdbc.member.model.vo.Member;


public class MemberView { //회원관련 화면 입/출력 
	
	private Scanner sc = new Scanner(System.in);
	
	// 회원 관련 서비스 제공 객체 생성 및 참조 
	private MemberService service = new MemberService();

	/**
	 *  회원 가입 출력용 메소드 
	 */
	public void signUp(){ 
		System.out.println("[회원 가입]");
		
		try {
			
			String memberId = null;
			String memberPw = null;
			String memberPw2 = null;
			String memberName = null;
			char memberGender = ' ';
			
			
			
			while(true) { //중복 아이디가 없을 경우 종료하는 if문 필요 
				
				System.out.println("아이디 : ");
				memberId =sc.next();
				
				/* 아이디 중복 검사 (DB에 일치하는 아이디가 있으면 "중복" 다시 아이디 입력 받기 */
				int result = service.duplicateCheck(memberId);
				
				//result 중복이면 1, 아니면 0이 반환될 예정
				if(result==0) { //중복이 아니면 반복문 종료 
					System.out.println("[사용가능한 아이디 입니다.]");
					break;
				}else {
					System.out.println("[이미 사용중인 아이디 입니다. 다시 입력해주세요.]");
				}
		
			 }// 중복 검사 while 문 종료 
			
			//비밀번호, 비밀번호 확인을 각각 입력 받아 
			//일치할 때 까지 무한 반복 
			
			while(true) {
				
				System.out.println("비밀번호 : ");
				memberPw =sc.next();
				
				System.out.println("비밀번호 확인 : ");
				memberPw2 =sc.next();
				
				if(memberPw.equals(memberPw2)) { //일치하면

					break;
				}else {
					System.out.println("\n 비밀번호가 일치하지 않습니다. 다시 입력해주세요\n");
				}
			}// 비밀번호 확인 while 종료 
			
			//이름 입력 
			System.out.println("회원 이름 : ");
			memberName = sc.next();
			
			//성별이 'M'또는 'F'가 입력 될 때 까지 반복 
			
			while(true) {
				
				System.out.println("성별입력(M/F) : ");
				memberGender = sc.next().toUpperCase().charAt(0);
				//String.toUpperCase() : 문자열을 대문자로 변환 
				
				if(memberGender != 'M' && memberGender != 'F') {
					System.out.println("\n[성별은 M 또는 F만 입력해주세요.]\n");
				}else {
					break;
				}
				
			} // 성별 while 문종료 
			//입력 받은 값을 하나의 객체(Member)에 저장 
			
			Member signUpMember = new Member(memberId, memberPw2, memberName, memberGender);
			
			//회원 가입 Service 호출 후 결과 반환 받기 
			// - 회원가입 == DB에 회원 정보 삽입 == INSERT(DML)
			//   -> DML 구문 수행 시 성공한 행의 개수가 반환됨 == int형 변수로 결과를 저장 
		
			 int result = service.signUp(signUpMember);
			 
			 //Service 결과에 따른 화면 처리 
			 
			 if(result > 0) { //가입 성공 시 
				 System.out.println("\n***회원 가입 성공***\n");
			 }else {
				 System.out.println("[회원가입 실패]");
			 }
			
		}catch(Exception e){
			System.out.println("\n<회원 가입 중 예외발생>\n");
			 e.printStackTrace();
		
	
			

				
			
		}
		

		
	}

	/** 로그인 메소드 
	 * @return
	 */
	public Member login() {
		
		System.out.println("[로그인]");
		
		System.out.println("아이디 : ");
		String memberId = sc.next();
		
		System.out.println("비밀번호 : ");
		String memberPw = sc.next();
		
		//service.login(memberId,memberPw);
		
		//Member 객체를 생성하여 입력 받은 값 세팅 
		Member mem = new Member();

		//setter이용해서 초기화 
		mem.setMemberId(memberId);
		mem.setMemberPw(memberPw);
				
		//로그인 Service 수행 후 결과 반환 받기 
		
		Member loginMember = null;
		
		try {
			loginMember = service.login(mem);
			
			if(loginMember != null) { //참조하는 객체가 있다 == 로그인 성공 
				System.out.println("\n***"+loginMember.getMemberName() +"님 환영합니다.***\n");
				
			}else {//로그인 실패(아이디 또는 비밀번호 불일치 또 탈퇴한 회원) 
				System.out.println("\n[아이디 또는 비밀번호가 일치하지 않습니다.]\n");
				
			}
			
		} catch (Exception e) {
			System.out.println("\n<로그인과정에서 예외 발생>\n");
			e.printStackTrace();
		}
		
		return loginMember;
	}

	/**내 정보 조회 
	 * @param loginMember
	 */
	public void myInfo(Member loginMember) {

		System.out.println("[내 정보 조회]");
		
		System.out.println("회원번호 : "+loginMember.getMemberNO());
		
		System.out.println("아이디 : "+loginMember.getMemberId());

		System.out.println("이름 :"+loginMember.getMemberName());

		System.out.println("성별 : "+ (loginMember.getMemberGender() =='M' ?"남성":"여성"));
		
//		if(loginMember.getMemberGender() == 'M') {
//			System.out.println("성별 : 남성");
//		}else {
//			System.out.println("성별 : 여성");
//			
//		}
					


		System.out.println("가입일 : "+loginMember.getEnrollDate());

	}


	public void selectAll() {
		
		System.out.println("[가입된 회원 목록 조회]");
		
		// DB에서 회원정보 모두 조회(아이디, 이름, 가입일)
		// 단, 탈퇴 회원 제외 아이디 오름차순 조회 
		
		try {
			// 회원정보 조회 service 호출 후 결과 반환 받기 
			List<Member>memebrList = service.selectAll();
			
			if (memebrList.isEmpty()) { //조회 결과가 없다면
				System.out.println("조회 결과가 없습니다. ");
				
			}else {
				
				for(Member m : memebrList) {
					System.out.printf( " %12s %12s  %s\n",
							m.getMemberId(),m.getMemberName(),
							m.getEnrollDate().toString());
						
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("\n<회원 목록 조회 과정에서 예외 발생>\n");
			e.printStackTrace();
		}
	}

	/** 내 정보 수정 
	 * @param loginMember
	 * @throws Exception 
	 */
	public void updateMyInfo(Member loginMember) throws Exception {
		
		System.out.println("[내 정보 수정(이름, 성별)]");
		
		System.out.println("변경 할 이름 : ");
		String memberName = sc.next();
			
		System.out.println("변경 할 성별 : ");
		char memberGender = sc.next().toUpperCase().charAt(0);
		
		// 입력 받은 값 + 로그인한 회원 번호 하나의 Member 객체에 저장 
		// (로그인한 회원 번호 == 어떤 회원 정보를 수정할지 지정) 
		
		Member updateMamber = new Member();
		
		updateMamber.setMemberName(memberName);
		updateMamber.setMemberGender(memberGender);
		updateMamber.setMemberNO(loginMember.getMemberNO()); // PK 지정한 NO를 가져온다. 
		
		try {		
			//UPDATE == DML == 수행 성공한 결과 행의 개수를 반환 == 정수형 
			int result = service.updateMyInfo(updateMamber);
			
			if(result >0) {	// 수정 성공 + 수정한 값으로 로그인 멤버 바꾸기 
				System.out.println("\n[회원정보가 수정되었습니다.]\n");
				
				//변경했는데, DB 수정이 되지 않아서 아래와 같은 내용으로 진행함. 
				//DB에 수정된 내용과 현재 로그인한 회원 정보 일치 시킴 
				//앝은복사 : 참조 주소만 복사하여 같은 객체를 참조
				//특징 : 복사된 주소를 참조하여 수정하면 원본 객체가 수정된다. 
				loginMember.setMemberName(memberName);
				loginMember.setMemberGender(memberGender);
				
			}else {// 수정 실패 
				System.out.println("\n[회원정보가 수정에 실패하였습니다.]\n");
					
			}
			
		}catch(Exception e) {
			System.out.println("\n<내 정보 수정 중 예외 발생>\n");
			e.printStackTrace();
		}

	}

	/** 비밀번호 변경 
	 * @param loginMember
	 * @throws Exception 
	 */
	public void updatePw(Member loginMember) throws Exception {

		System.out.println("[비밀번호 변경]");
		
		// 현재 비밀번호 --> DB Update 조건(WHERE)
		System.out.println("현재 비밀번호 : ");
		String currentPW = sc.next();
		
		//새비밀번호 
		//새 비밀번호 확인 
		// 둘이 일치할때까지 무한 반복 
		
		String newPw= null;
		String newPw2 = null;
		
		while(true) {
			System.out.println("새 비밀번호 : ");
			newPw = sc.next();
			
			System.out.println("새 비밀번호 확인  : ");
			 newPw2 = sc.next();
			
			if(newPw.equals(newPw2)) {
				break;
			}else {
				System.out.println("\n새 비밀번호가 일치하지 않습니다. 다시 입력해주세요\n");
			}
				
		}
		try {
			
			int result = service.updatePw(loginMember.getMemberNO(),currentPW, newPw);
			
			if(result > 0) {
				System.out.println("[비밀번호가 변경되었습니다.]");
	
			}else {
				System.out.println("[비밀번호가 일치하지 않습니다.]");
			}
			
		}catch(Exception e) {
			System.out.println("\n<비밀번호 변경 중 예외 발생>\n");
			e.printStackTrace();
		}
		
		
	}

	/**회원탈퇴 
	 * @param loginMember
	 */
	public int secession(Member loginMember) {
		
		//loginMember = null;
		//->매개변수로 전달 받은 값(주소복사본)을 저장할 뿐이다. 
		//->복사본이 사라진다고 해도 원본(MainView의 loginMember)은 
		//  사라지지 않고 로그아웃도 안된다 ! 
		// == MainView에 쓰여진 객체임! 우리는 주소값만 저장되고 있음! 
		
		System.out.println("[회원 탈퇴]");
		
		//1. 현재 비밀번호 입력 받기
		System.out.println("비밀번호 입력 : ");
		String memberPw = sc.next();
		
		//2. "정말 탈퇴하시겠습니까? (y/n)"
		System.out.println("정말 탈퇴하시겠습니까?(y/n) : ");
		char ch = sc.next().toUpperCase().charAt(0);
		
		//3. (y입력 시 ) 탈퇴 Service 수행 
		if(ch == 'Y') {
		
			// 로그인한 회원 번호 + 입력 받을 비밀번호 
			try {
				
				int result = service.secssion(loginMember.getMemberNO(),memberPw);
				// 4. 탈퇴 Service 수행 성공 -> "탈퇴 되었습니다." --> 로그아웃 
				//    탈퇴 Service 수행 실패 -> "비밀번호가 일치하지 않습니다."
				
				if(result >0) {
					System.out.println("탈퇴 되었습니다.");
					
				}else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
				
				return result; // 현재 메소드를 종료하고 호출한 곳으로 돌아감 
				
			} catch (Exception e) {
				System.out.println("\n<회원 탈퇴 과정에서 예외발생>\n");
				e.printStackTrace();
			}
			
		}else {
			// (N 입력 시) "회원 탈퇴 취소"
			System.out.println("\n[회원 탈퇴 취소]\n");
		}
			
		return 0;
	}

}
