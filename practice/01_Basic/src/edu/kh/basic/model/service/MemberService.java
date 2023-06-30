package edu.kh.basic.model.service;

import java.util.Scanner;

import javax.security.auth.spi.LoginModule;

import edu.kh.basic.model.vo.Member;

public class MemberService {

	private Scanner sc = new Scanner(System.in);

	private Member[] memberArr = new Member[5];

	private Member loginMember = null; // 현재 로그인한 회원 정보를 저장하는 변수

	public void displayMenu() {

		int menuNum = 0;

		do {

			System.out.println("\n=======회원 정보 관리 프로그램 v2=======");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 검색 (지역)");
			System.out.println("0. 프로그램종료");

			System.out.println("메뉴입력 >> ");
			menuNum = sc.nextInt(); // 필드에 작성된 Scanner sc를 사용
			sc.nextLine();

			switch (menuNum) {

			case 1:
				System.out.println(signUp());
				break;
			case 2:
				System.out.println(login());
				break;
			case 3:
				selectMember();
				break;
			case 4:

				int result = updateMember();

				if (result == -1) {
					System.out.println("로그인 후 이용해주세요");

				} else if (result == 0) {
					System.out.println("회원정보 수정 실패");
				} else {
					System.out.println("회원정보가 수정되었습니다.");
				}

				;
				break;
			case 5:
				;
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				break;

			default:
				System.out.println("잘못 입력 하셨습니다. 다시 입력 해주세요!");

			}

		} while (menuNum != 0);
	}

	public String signUp() {

		System.out.println("\n==========회원가입==========");

		int index = emptyIndex(); //

		System.out.println("현재회원 수 : " + index);
		if (index == -1) {
			return "인원수 초과로 인해 회원가입이 불가능합니다.";
		}

		System.out.println("아이디 : ");
		String memberId = sc.next();

		System.out.print("비밀번호 : ");
		String memberPw = sc.next();

		System.out.print("비밀번호 : ");
		String memberPw2 = sc.next();

		System.out.println("이름 : ");
		String memberName = sc.next();

		System.out.print("나이 : ");
		int memberAge = sc.nextInt();

		if (memberPw.equals(memberPw2)) {

			memberArr[index] = new Member(memberId, memberPw, memberName, memberAge);

			return "회원가입 성공!";
		} else {
			return "회원가입 실패!";
		}
	}

	public int emptyIndex() {

		for (int i = 0; i < memberArr.length; i++) {
			if (memberArr[i] == null) {
				return i;//
			}
		}
		return -1;
	}

	public String login() {

		System.out.println("\n=========로그인=========");

		System.out.print("아이디 입력 : ");
		String memberId = sc.next();

		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();

		for (int i = 0; i < memberArr.length; i++) {
			if (memberArr[i] != null) {

				if (memberArr[i].getMemberPw().equals(memberPw) && memberArr[i].getMemberId().equals(memberId)) {

					loginMember = memberArr[i];
				}
			}
		}

		if (loginMember == null) {
			return "아이디 또는 비밀번호가 일치하지 않습니다";
		} else {
			return loginMember.getMemberName() + "님 환영합니다.";
		}
	}

	public String selectMember() {

		System.out.println("\n*****회원정보 조회*****");

		if (loginMember == null) {
			return "로그인 후 이용해주세요! ";
		}

		String str = " 이름 : " + loginMember.getMemberName();

		str += "\n아이디 : " + loginMember.getMemberId();
		str += "\n나이 : " + loginMember.getMemberAge() + "세";
		str += "\n지역 : " + loginMember.getRegion();

		return str;
	}

	public int updateMember() {

		System.out.println("\n***** 회원 정보 수정 *****");

		if (loginMember == null) {
			return -1;
		}

		System.out.print("수정할 이름 입력 : ");
		String inputName = sc.next();

		System.out.print("수정할 나이 입력 : ");
		int inputAge = sc.nextInt();
		sc.nextLine();

		System.out.print("비밀번호 입력 : ");
		String inputPw = sc.next();

		if (inputPw.equals(loginMember.getMemberPw())) {

			loginMember.setMemberName(inputName);
			loginMember.setMemberAge(inputAge);

			return 1;
		} else {
			return 0;
		}

	}

	public void searchReigon() {
		
		   System.out.println("\n*****회원 검색(지역)*****");
		   
		   System.out.print("검색할 지역을 입력 하세요 : ");
		   String inputReigon =sc.next();		   
		   int count = 0;
		
		   for(int i =0 ; i<memberArr.length;i++) {
			   
			   if(memberArr[i]== null) {
				   break;
				   
			   }
			   
			   if(memberArr[i].getRegion().equals(inputReigon)) {
				   System.out.printf("아이디 : %s, 이름 : %s\n",memberArr[i].getMemberId(),memberArr[i].getMemberName());
				   count++;
			   }
		   }
				  
		   if(count==0) {
			   System.out.println("일치하는 결과가 없습니다.");
		   }
		
	}
		
		     
			  
	}
