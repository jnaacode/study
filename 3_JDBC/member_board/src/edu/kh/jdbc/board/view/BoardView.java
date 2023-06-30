package edu.kh.jdbc.board.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.board.model.service.BoardService;
import edu.kh.jdbc.board.model.vo.Reply;
import edu.kh.jdbc.board.vo.Board;

import edu.kh.jdbc.member.model.vo.Member;

// 게시판 메뉴 전용 화면
public class BoardView {

   private Scanner sc = new Scanner(System.in);
   
   private BoardService service = new BoardService();
   
   /** 게시판 전용 메뉴 화면
    * @param loginMember (로그인한 회원 정보)
    */
   public void boardMenu(Member loginMember) {
      
      int menuNum = -1;
      
      do {
         try {
             System.out.println("\n********** 게시판 메뉴 **********\n");
               
               System.out.println("1. 게시글 목록 조회");
               System.out.println("2. 게시글 상세 조회(게시글 번호 입력)");
                           // 게시글 작성자와 로그인한 회원이 같을 때 
                           // 게시글 수정(UPDATE), 게시글 삭제(DELETE)
               
               System.out.println("3. 게시글 작성(INSERT)");
               System.out.println("4. 게시글 검색(제목/내용/제목+내용/작성자)");
               
               System.out.println("0. 회원 메뉴로 돌아가기");
            
               System.out.println("메뉴를 선택해주세요 >> ");
               menuNum = sc.nextInt();
               sc.nextLine(); // 개행 문자 제거
               System.out.println(); // 줄 바꿈
               
               switch (menuNum) {
            case 1 : selectAll(); break;
            case 2 : selectOne(loginMember);break;
            //상세 조회 시 게시글 수정/ 삭제 (게시글 작성 == 로그인한 회원 비교)
            //댓글 (누가 작성? / 작성자가 수정, 삭제)
            // -> loginMember를 매개변수로 전달 
            case 3 : insertBoard(loginMember.getMemberNO());break;
            case 4 : searchBoard();break;
            case 0 : System.out.println("회원 메뉴로 돌아갑니다 .."); break;
            default:System.out.println("메뉴에 작성된 번호를 입력해주세요."); break;
            }
         } catch (InputMismatchException e) {
            System.out.println("\n입력 형식이 올바르지 않습니다. 다시 시도해주세요.");
            sc.nextLine(); // 입력 버퍼에 남은 잘못된 문자열 제거
         }
   
		} while (menuNum != 0);
	}

	/**
	 * 게시글 검색 
	 */
	private void searchBoard() {
		
		System.out.println("\n[게시글 검색]\n");
		
		int menuNum = -1;
		
		do {
			try {
				System.out.println("---검색 조건을 선택해주세요---");
				System.out.println("1. 제목");
				System.out.println("2. 내용");
				System.out.println("3. 제목+내용");
				System.out.println("4. 작성자");
				System.out.println("0. 돌아가기");
				
				System.out.println("선택 >> ");
				menuNum =sc.nextInt();
				sc.nextLine();
				
				switch(menuNum) {
				
				case 0:System.out.println("\n게시판 메뉴로 돌아갑니다.\n");break;
				case 1: case 2:	case 3: case 4:
					//검색어 입력 -> Service호출 
					System.out.print("검색어 : ");
					String keyword = sc.nextLine();
					
					List<Board> boardList = service.searchBoard(menuNum,keyword);
					
					if(boardList.isEmpty()) { //검색 결과가 비어 있다 == 검색 결과가 없다.
						System.out.println("\n검색결과가 없습니다.\n");
						
					}else {
						System.out.println("------------------------------------------------------------------------");
		                  System.out.printf("%3s  %13s%12s   %7s%3s %7s%2s %s\n",
		                           "글번호", "제목", "", "작성자", "", "작성일", "" , "조회수");
		                  System.out.println("------------------------------------------------------------------------");
		                  
		                  // 향상된 for문
		                  for(Board b : boardList) {
		                     
		                     System.out.printf("%3d  %20s [%d]  %10s  %s %3d\n",
		                           b.getBoardNo(), b.getBoardTitle(), b.getReplyCount(),
		                           b.getMemberName(), b.getCreateDate().toString(), b.getReadCount());
		                     
		                  }
					}
					
					break;
					
				default : System.out.println("\n메뉴에 작성된 번호를 입력해주세요.\n");break;
				
				}
				
			}catch (InputMismatchException e) {
				System.out.println("\n입력 형식이 올바르지 않습니다. 다시 시도해주세요.");
				sc.nextLine();
			}catch(Exception e) {
				System.out.println("\n<게시글 검색 중 예외 발생>\n ");
				e.printStackTrace();
				break; //검색 반복문 종료 
			}
			
			
		}while (menuNum != 0);
		
}

	/** 게시글 작성 
	 * @param memberNO
	 */
	private void insertBoard(int memberNO) {

		System.out.println("\n[게시글 작성]\n");

		System.out.println("게시글 제목 : ");
		String boardTitle = sc.nextLine();

		System.out.println("\n게시글 내용(종료 시 @exit 입력)\n");
		
		String boardContent = inputContent();
		
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setMemberNo(memberNO);
		
		try {
			
			int result = service.insertBoard(board);
			
			if(result>0) {
				System.out.println("\n게시글이 등록 되었습니다.\n");
			}else {
				System.out.println("\n게시글 작성 실패\n");
			}
			
			
		} catch (Exception e) {
			System.out.println("\\n<게시글 작성 중 예외 발생>\\n");
			e.printStackTrace();
		}
	}

	/**
	 * 게시글 목록 조회
	 */
	private void selectAll() {

		System.out.println("[게시글 목록 조회]");

		try {
			// 게시글 목록 조회 Service 호출 후 결과 반환 받기
			List<Board> boardList = service.selectAll();

			if (boardList.isEmpty()) { // 조회 결과가 없는 경우
				System.out.println("\n[조회된 게시글이 없습니다.]");

			} else {
				System.out.println("------------------------------------------------------------------------");
				System.out.printf("%3s  %13s%12s   %7s%3s %7s%2s %s\n", "글번호", "제목", "", "작성자", "", "작성일", "", "조회수");
				System.out.println("------------------------------------------------------------------------");

				// 향상된 for문
				for (Board b : boardList) {

					System.out.printf("%3d  %20s [%d]  %10s  %s %3d\n", b.getBoardNo(), b.getBoardTitle(),
							b.getReplyCount(), b.getMemberName(), b.getCreateDate().toString(), b.getReadCount());
				}
			}

		} catch (Exception e) {
			System.out.println("\n<게시글 목록 조회 중 예외 발생>\n");
			e.printStackTrace();
		}
	}

	/**
	 * 게시글 상세 조회
	 * 
	 * @param loginMember
	 */
	private void selectOne(Member loginMember) {

		System.out.println("[게시글 상세 조회]");

		System.out.println("조회할 게시글 번호 입력 : ");

		int boardNo = sc.nextInt();

		// 게시글 상세 조회 Service를 호출 후 결과 반환 (게시글 1개의 정보 == Board)
		try {

			Board board = service.selectOne(boardNo);

			if (board != null) { // 조회된 게시글이 있을 경우

				System.out.println("\n------------------------------------------------------------");
				System.out.printf("번호 : %d     |  제목 : %s\n", board.getBoardNo(), board.getBoardTitle());
				System.out.println("------------------------------------------------------------");
				System.out.printf("작성자 : %s\n" + "작성일 : %s\n" + "조회수 : %d\n", board.getMemberName(),
						board.getCreateDate(), board.getReadCount());
				System.out.println("------------------------------------------------------------");
				System.out.printf("\n%s\n\n", board.getBoardContent());
				System.out.println("------------------------------------------------------------");

				// 댓글 목록 조회
				System.out.println("\n[댓글]");
				for (Reply r : board.getReplyList()) {
					System.out.printf("<%d> | %s | %s\n", r.getReplyNo(), r.getMemberName(), r.getCreateDate());

					System.out.println(r.getReplyContent());
					System.out.println(".............................................................\n");
				}

				// -------------------------------------------
				// 상세 조회용 메뉴 출력

				System.out.println("===== 상세 조회 메뉴 =====");

				// 어떤 회원이든 가능
				System.out.println("1. 댓글 삽입");

				// 댓글 번호 입력 받아
				// 댓글을 작성한 회원번호 == 로그인한 회원 번호)
				// -> 수정 / 삭제
				System.out.println("2. 댓글 수정");
				System.out.println("3. 댓글 삭제");
				// 댓글 번호 입력 > 댓글 있어? 확인 > 해당 댓글이 로그인한 회원꺼가 맞는지 검사

				// 상세 조회된 게시글의 회원 번호 == 로그인한 회원번호
				// -> 수정 / 삭제

				if (board.getMemberNo() == loginMember.getMemberNO()) {

					System.out.println("4. 게시글 수정");
					System.out.println("5. 게시글 삭제");

				}

				System.out.println("0. 게시판 메뉴로 돌아가기");

				System.out.print("메뉴 선택 >> ");
				int menuNum = sc.nextInt();
				sc.nextLine();

				switch (menuNum) {

				case 0:
					System.out.println("\n게시판 메뉴로 돌아갑니다.\n");
					break;
				case 1:
					insertReply(loginMember, boardNo);
					break;
				case 2:
				case 3:

					String tmp = menuNum == 2 ? "\n[댓글수정]\n" : "\n[댓글삭제]\n";

					System.out.println(tmp);

					System.out.print("댓글번호입력 : ");
					int inputNo = sc.nextInt();
					sc.nextLine();

					// 입력 받은 댓글 번호가 댓글 목록에 있는지 확인
					// 1) 확인된 댓글을 참조할 변수
					Reply reply = null;

					for (Reply r : board.getReplyList()) {
						if (r.getReplyNo() == inputNo) { // 입력 받은 번호와 일치하는 댓글이 있다면

							reply = r;

//									System.out.println("리플 :: " + reply.getMemebrNo());
							break; // replyNo는 프라이머리키로 굳이 더 찾을 필요없음 ! break 붙여줌

						}
					}

					if (reply == null) { // 같은 번호(댓글)가 목록에 없는 경우
						System.out.println("\n해당 댓글이 존재하지 않습니다.\n");
					} else {// 같은 번호가 목록에 있을 경우

						// 해당 댓글의 회원번호(작성자)와
						// 로그인한 회원의 번호가 같은지 확인
						// -> 같을 경우 로그인한 댓글이다.

//								System.out.println("loginMember.getMemberNO() :: " + loginMember.getMemberNO());
//								System.out.println("reply.getMemebrNo() :: " + reply.getMemebrNo());

						if (loginMember.getMemberNO() == reply.getMemebrNo()) {

							if (menuNum == 2)
								updateReply(inputNo); // 댓글 수정
							else
								deleteReply(inputNo); // 댓글 삭제

						} else {
							System.out.println("\n현재 로그인한 회원의 댓글이 아닙니다.\n");
						}

					}

					break;
				case 4:
				case 5:
					// 게시글 작성자 번호 == 로그인 회원 번호 실행
					// 작성 안해주면 4번 누르면 숨겨진 4번이 보이기 때문에 아래 내용을 작성해줘야한다.
					if (board.getMemberNo() == loginMember.getMemberNO()) {

						// 4번 게시글 수정
						if (menuNum == 4) {
							updateBoard(boardNo); // 수정용 메소드

						} else {// 5번 게시글 삭제
							deleteBoard(boardNo); // 삭제용메소드
						}

					} else {
						System.out.println("메뉴에 표시된 번호만 입력 해주세요.");
					}

					break;

				default:
					System.out.println("메뉴에 표시된 번호만 입력 해주세요.");
					break;
				}

			} else {// 조회된 게시글이 있을 경우
				System.out.println("\n 존재하지 않는 게시글 번호 입니다\n");
			}

		} catch (Exception e) {
			System.out.println("\n게시글 상세 조회 중 예외발생\n");
			e.printStackTrace();
		}

	}

	/**
	 * 댓글삭제
	 * 
	 * @param inputNo
	 */
	private void deleteReply(int inputNo) {

		System.out.println("\n[댓글 삭제]\n");

		char ch;

		while (true) {
			System.out.println("정말 삭제 하시겠습니까? (Y/N): ");
			ch = sc.next().toUpperCase().charAt(0);
			if (ch == 'Y' || ch == 'N') {
				break;
			} else {
				System.out.println("Y 또는 N를 입력 해주세요.\n");
			}
		}

		if (ch == 'Y') {

			// 보안 문자 생성
			String cap = capcha();
			System.out.println("다음 보안 문자를 입력해주세요>>" + cap);
			String input = sc.next();

			if (input.equals(cap)) {

				try {

					int result = service.deleteReply(inputNo);

					if (result > 0) {
						System.out.println(inputNo + "번 댓글이 삭제되었습니다.");
					} else {
						System.out.println("댓글 삭제 실패");
					}

				} catch (Exception e) {
					System.out.println("\n<댓글 삭제 중 예외 발생>\n");
					e.printStackTrace();
				}

			} else {
				System.out.println("\n보안 문자가 일치하지 않습니다(삭제취소)\n");
			}

		}
	}

	/**
	 * 댓글 수정
	 * 
	 * @param inputNo
	 */
	private void updateReply(int inputNo) {

		System.out.println("수정할 내용 입력(종료시 @exit 입력)");
		String input = inputContent();

		// Reply 객체 생성해서 댓글 번호, 내용 저장
		Reply reply = new Reply();

		reply.setReplyNo(inputNo);
		reply.setReplyContent(input);

		try {
			int result = service.updateReply(reply);

			if (result > 0) {
				System.out.println(inputNo + "번 댓글이 수정되었습니다.\n");
			} else {
				System.out.println("\n댓글 수정 실패\n");
			}

		} catch (Exception e) {
			System.out.println("\n<댓글 수정 과정중 예외 발생>\n");
			e.printStackTrace();
		}
	}

	/**
	 * 댓글작성
	 * 
	 * @param loginMember
	 * @param boardNo
	 */
	private void insertReply(Member loginMember, int boardNo) {

		System.out.println("[댓글작성]");

		System.out.println("댓글 내용 입력(종료 시 @exit 입력)\n");

		String replyContent = inputContent();

		// 회원 번호, 게시글 번호, 댓글내용 -> 하나의 Reply 객체에 저장

		Reply reply = new Reply();
		reply.setMemebrNo(loginMember.getMemberNO());
		reply.setBoardNo(boardNo);
		reply.setReplyContent(replyContent);

		System.out.println("reply :: " + reply.getMemebrNo());

		try {

			// 댓글 삽입(INSERT)Service 호출 후 결과 반환 받기

			int result = service.insertReply(reply);

			if (result > 0) {
				System.out.println("\n댓글이 작성되었습니다.\n");
			} else {
				System.out.println("댓글 삽입 실패");
			}

		} catch (Exception e) {
			System.out.println("\n<댓글 작성 중 예외 발생>\n");
		}

	}

	/**
	 * 게시글 수정
	 * 
	 * @param boardNo
	 * 
	 */
	private void updateBoard(int boardNo) {

		System.out.println("\n[게시글 수정]\n");

		System.out.println("수정할 제목 : ");
		String boardTitle = sc.nextLine();

		System.out.println("\n수정할 내용(종료시 @exit 입력)\n");

		String boardContent = inputContent();// 내용 입력 메소드를 호출 후 결과 반환 받기

		// 게시글 번호 /수정한 제목 + 내용을 한번에 저장할 Board 객체 생성
		Board board = new Board();

		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);

		try {

			int result = service.updateBoard(board);

			if (result > 0) {
				System.out.println(board + " 번 게시글이 수정되었습니다.\n");
			} else {
				System.out.println("수정실패");
			}

		} catch (Exception e) {
			System.out.println("\n<게시글 수정중 예외 발생>\n");
			e.printStackTrace();
		}
	}

	/*
	 * String (객체) - 불변성(immutable) <-> 가변성(mutable) -> 한번 생성된 String 객체에 저장된 문자열은
	 * 변하지 않는다.
	 * 
	 * ex) String str = "abc"; // heap 영역에 String 객체가 생성되고 // 생성된 객체에 "abc" 문자열 저장
	 * 
	 * 
	 * str = "123"; // heap 영역에 새로운 String 객체가 생성되고 // 생성된 객체에 "123" 문자열 저장 후 // 객체
	 * 주소를 str에 대입
	 * 
	 * ex) String str = "abc" str += "123"; // "123"이 저장된 String 객체 생성후 // "abc"와
	 * "123"이 합쳐진 String 객체가 추가로 별도 생성 // 그 후 "abc123"개체의 주소를 str에 저장
	 * 
	 * *** String 의 문제점 ***
	 * 
	 * - String에 저장된 값을 바꾸거나 누적하려고 할때 마다 String에 객체가 무분별하게 생성된 --> 메모리 낭비(메모리누수)
	 * 
	 * *** 해결방법 *** - StringBuffe / StringBuilder(가변성) 클래스를 자바에서 제공함
	 * 
	 * (StringBuffer/ StringBuilder는 사용방법은 똑같음) -> 차이점은 동기 / 비동기 차이밖에 없음
	 *
	 * 
	 * 
	 */

	/**
	 * 게시글/ 댓글 내용 입력 메소드
	 * 
	 * @return content
	 */
	private String inputContent() {

		// String content ="";
		StringBuffer content = new StringBuffer();

		String input = "";

		while (true) {// @exit가 입력 될 때 까지 무한히 문자열을 입력 받아
			// 하나의 변수에 누적 == 게시글 내용

			input = sc.nextLine();

			if (input.equals("@exit")) { // @exit가 입력된 경우
				break;
			} else {
//				content += input + "\n"; //줄 바꾸며 누적

				content.append(input);
				content.append("\n");
//				StringBuffer에 저장된 문자열의 제일 뒤에 input을 추가 하겠다. 
//				append : (제일뒤에) 덧붙이다. 추가하다. 첨부하다.

//			 -> 하나의 StringBuffer 객체에 문자열이 계속 누적됨 == (가변)
//				(추가적인 String 객체 생성이 없다.)

			}

		}
		return content.toString(); // StringBuffer에 오버라이딩된 toString()
									// -> 저장된 문자열을 String 형태로 반환
	}

	/**
	 * 게시글 삭제
	 * 
	 * @param boardNo
	 * @throws Exception
	 */
	private void deleteBoard(int boardNo) throws Exception {

		// "정말 삭제 하시겠습니까? (y/n) -- 제대로 입력 될 때 까지 무한 반복 "
		// "y"입력 시
		// -> 보안문자 생성
		// -> 보안문자가 일치하는 경우에 삭제 진행

		System.out.println("\n[게시글 삭제]\n");

		char ch = ' ';// Y/N 저장

		while (true) {

			System.out.println("정말 삭제 하시겠습니까? (Y/N): ");
			ch = sc.next().toUpperCase().charAt(0);

			if (ch == 'Y' || ch == 'N') {// Y 또는 N인 경우 추가 입력 X (반복종료)
				break;
			} else {
				System.out.println("Y또는N을 입력 해주세요\n");
			}
		}

		if (ch == 'Y') { // 삭제를 하려고 하는 경우

			// 보안문자생성
			String cap = capcha();
			System.out.println("다음 보안 문자를 입력 해주세요 >> " + cap);

			System.out.println("보안문자 입력 : ");
			String input = sc.next();

			if (input.equals(cap)) { // 입력 받은 문자열과 보안 문자가 같을 때

				// 삭제 Service 호출
				try {

					int result = service.deleteBoard(boardNo);

					if (result > 0) {
						System.out.println(boardNo + "번 게시글이 삭제 되었습니다.");
					} else {
						System.out.println("\n삭제 실패 되었습니다.\n");
					}

				} catch (Exception e) {
					System.out.println("\n게시글 삭제 중 예외 발생\n");
					e.printStackTrace();
				}

			} else {
				// 취소
				System.out.println("\n 보안 문자가 일치하지 않습니다.(삭제취소)\n");
			}

		} else { // 삭제 취소

			System.out.println("\n삭제를 취소 했습니다.\n");
		}
	}

	/**
	 * 보안문자 생성 메소드(렌덤 영어소문자 5개)
	 * 
	 * @return cap
	 */
	private String capcha() {

		String cap = "";

		for (int i = 0; i < 5; i++) {

			cap += (char) (Math.random() * 26 + 'a');
			// int 형변환: 0+97(a) ~ 122(z)
			// char 형변환 : 'a' ~ 'z'

		}

		return cap;
	}
}