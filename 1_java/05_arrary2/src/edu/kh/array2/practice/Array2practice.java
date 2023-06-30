package edu.kh.array2.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Array2practice {

	public void ex1() {

		String[][] arrStr = new String[3][3];

		for (int row = 0; row < arrStr.length; row++) {

			for (int col = 0; col < arrStr[row].length; col++) {
				arrStr[row][col] = "(" + row + "," + col + ")"; // 배열에 저장 후 출력
			}
			System.out.println();
		}

	}

	public void ex2() {

		int[][] arr = new int[4][4];

		int count = 1;

		for (int row = 0; row < arr.length; row++) {

			for (int col = 0; col < arr[row].length; col++) {
				arr[row][col] = count++;
				System.out.printf("%3d", arr[row][col]);
			}
			System.out.println();
		}

	}

	public void ex3() {

		int[][] arr = new int[4][4];

		int count = 16;
		// int count = arr.length*arr[row].length

		for (int row = 0; row < arr.length; row++) {

			for (int col = 0; col < arr[row].length; col++) {

				arr[row][col] = count--;
				System.out.printf("%3d", arr[row][col]);
			}
			System.out.println();
		}

	}

	public void ex4() {

		int[][] arr = new int[4][4]; // 4행4열을 생성하여

		// 상수사용!
		// 변하지 않는 특정 값에 이름을 붙여준다 (3행3열은 고정이다)

		final int LOW_LAST_INDEX = arr.length - 1; // 행의 마지막 인덱스
		final int COL_LAST_INDEX = arr[0].length - 1; // 열의 마지막 인덱스 (0을 넣는 이유는 열은 어떤 자리에도 상관없음)

		for (int row = 0; row < arr.length; row++) {

			for (int col = 0; col < arr[row].length; col++) {

				// 마지막 행, 마지막 열이 아닌 경우
				if (row != LOW_LAST_INDEX && col != COL_LAST_INDEX) {
					int random = (int) (Math.random() * 10 + 1); // 1~10사이에 난수
					arr[row][col] = random;

					// 각 행의 마지막 열에 난수를 누적
					arr[row][COL_LAST_INDEX] += arr[row][col]; // [0][3]

					// 각 열의 마지막 행에 난수를 누적
					arr[LOW_LAST_INDEX][col] += arr[row][col];

					// 생성된 모든 난수를 마지막 행, 마지막 열을 누적
					arr[LOW_LAST_INDEX][COL_LAST_INDEX] += arr[row][col];

				}

				System.out.printf("%4d", arr[row][col]);

			} // 열 반복 끝
			System.out.println();
		} // 행 반복 끝

	}

	public void ex5() {

		Scanner sc = new Scanner(System.in); // 직접 입력 받되

		System.out.print("행크기 : ");
		int input1 = sc.nextInt();
		System.out.print("열크기 : ");
		int input2 = sc.nextInt();

		char[][] arr = new char[input1][input2];

		for (int row = 0; row < arr.length; row++) {

			for (int col = 0; col < arr[row].length; col++) {

				int random = (int) (Math.random() * 26) + 65;

				arr[row][col] = (char) random;

				System.out.printf("%4c", arr[row][col]);
			}
			System.out.println();
		}

	}

	public void ex6() {

		Scanner sc = new Scanner(System.in);

		System.out.print("행크기 : ");
		int input1 = sc.nextInt(); // 사용자에게 행크기 입력 받아 inpu1만큼 반복하거야

		char[][] arr = new char[input1][];

		// 열크기 정하는 for문
		for (int i = 0; i < input1; i++) {
			System.out.print(i + "열 크기 입력 : ");
			int input2 = sc.nextInt();
			arr[i] = new char[input2]; // 값을 저장할 있는 방이라고! -> 이거는 열크기 생성한거에 대해서 ! 가변배열 작성하는거야!

		}
		char ch = 'a';

		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				arr[row][col] = ch++;

				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}

	public void ex51() { // 5번문제 선생님 답

		Scanner sc = new Scanner(System.in); // 직접 입력 받되

		while (true) {

			System.out.print("행크기 : ");
			int row = sc.nextInt();
			System.out.print("열크기 : ");
			int col = sc.nextInt();

			if (row < 1 || row > 10 || col < 1 || col > 10) {
				System.out.println("반드시 1~10사이에 정수를 입력 해야합니다.");

			} else {
				int[][] arr = new int[row][col];

				for (int i = 0; i < row; i++) {

					for (int j = 0; j < col; j++) {
						arr[i][j] = (int) (Math.random() * 26);

						char result = (char) (arr[i][j] + 65);
						System.out.print(result + " ");
					}
					System.out.println();
				}

				break;
			}
		}
	}

	public void homework() {
		int[][] arr = new int[4][4];
		final int ROW_SUM = arr.length - 1; // 3행은 고정값이다.
		final int COL_SUM = arr[0].length - 1; // 3열은 고정이다.

		for (int row = 0; row < arr.length; row++) { // 행은 3번반복할것이다.
			for (int col = 0; col < arr[row].length; col++) { // 열은 3번 반복할 것이다.

				if (row != ROW_SUM && col != COL_SUM) {
					int random = (int) (Math.random() * 10 + 1); //
					arr[row][col] = random;

					arr[ROW_SUM][col] += arr[row][col];

					arr[row][COL_SUM] += arr[row][col];

					arr[ROW_SUM][COL_SUM] += arr[row][col];

					System.out.printf("%3d", arr[row][col]);
				}
				System.out.println();
			}
		}

	}

	public void pratice7() {

		String[] students = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하" };

		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];

		int index = 0; // students 배열에서 0 부터 1씩 증가하며 학생들을 선택하는 용도의 변수

		System.out.println("== 1분단 ==");
		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr1[row].length; col++) {

				arr1[row][col] = students[index];
				// students배열 index 번째 학생을 arr1[row][col]에 대입

				index++;

				System.out.print(arr1[row][col] + " ");
			}
			System.out.println();// 줄바꿈
		}
		System.out.println("==2분단==");
		for (int row = 0; row < arr2.length; row++) {
			for (int col = 0; col < arr2[row].length; col++) {

				arr2[row][col] = students[index];
				index++;

				System.out.print(arr2[row][col] + " ");

			}
			System.out.println();// 줄바꿈
		}
	}

	public void pratice8() {

		String[] students = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하" };

		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];

		int index = 0; // students 배열에서 0 부터 1씩 증가하며 학생들을 선택하는 용도의 변수

		System.out.println("== 1분단 ==");
		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr1[row].length; col++) {

				arr1[row][col] = students[index];
				// students배열 index 번째 학생을 arr1[row][col]에 대입

				index++;

				System.out.print(arr1[row][col] + " ");
			}
			System.out.println();// 줄바꿈
		}
		System.out.println("==2분단==");
		for (int row = 0; row < arr2.length; row++) {
			for (int col = 0; col < arr2[row].length; col++) {

				arr2[row][col] = students[index];
				index++;

				System.out.print(arr2[row][col] + " ");

			}
			System.out.println();// 줄바꿈
		}
		System.out.println("================================");
		Scanner sc = new Scanner(System.in);

		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String inputName = sc.next();

		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr1[row].length; col++) {

				if (arr1[row][col].equals(inputName)) {
					if (col == 0) {
						System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 왼쪽에 있습니다.", inputName, row + 1);
					} else {
						System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 오른쪽에 있습니다.", inputName, row + 1);
					}
				}

			}
		}

		for (int row = 0; row < arr2.length; row++) {
			for (int col = 0; col < arr2[row].length; col++) {

				if (arr2[row][col].equals(inputName)) {
					if (col == 0) {
						System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 왼쪽에 있습니다.", inputName, row + 1);
					} else {
						System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 오른쪽에 있습니다.", inputName, row + 1);
					}
				}
			}
		}
	}

	public void practice9Techer() {

		String[][] arr = new String[6][6];

		Scanner sc = new Scanner(System.in);
		System.out.print("행 인덱스 입력 : ");
		int input1 = sc.nextInt();
		System.out.print("행 인덱스 입력 : ");
		int input2 = sc.nextInt();

		int num1 = 0;
		int num2 = 0;
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr.length; col++) {

				if (row == 0 && col != 0) {
					arr[row][col] = num1++ + " ";
				} else if (col == 0 && row != 0) {
					arr[row][col] = num2++ + " ";

				} else {
					arr[row][col] = "  ";
				}
				arr[input1 + 1][input2 + 1] = "X";
				System.out.print(arr[row][col]);

			}
			System.out.println();
		}
	}

	public void practice9() {
		String[][] arr = new String[6][6];

		Scanner sc = new Scanner(System.in);
		System.out.print("행 인덱스 입력 : ");
		int input1 = sc.nextInt();
		System.out.print("행 인덱스 입력 : ");
		int input2 = sc.nextInt();

		arr[input1][input2] = "X";

		System.out.println("  0 1 2 3 4");
		for (int row = 0; row < arr.length - 1; row++) {
			for (int col = 0; col < arr.length; col++) {

			}

			System.out.println(row);
		}
	}

	public void startBingo() {

		Scanner sc = new Scanner(System.in);

		System.out.println("빙고판 크기 지정 : ");
		int num = sc.nextInt();
		sc.nextLine();

		// 1차원 배열로 빙고판에 입력될 값 생성 + 중복제거

		// 1차원 배열 생성
		int[] tempArr = new int[num * num];
		// num*num --> 빙고판 크기는 가로, 세로 곱 만큼의 공간이 필요

		// 중복값 제거하면서 랜덤값 집어넣기

		// 랜덤값 집어넣기
		for (int i = 0; i < tempArr.length; i++) {

			tempArr[i] = (int) (Math.random() * (num * num)) + 1;
			// 중복제거
			for (int j = 0; j < i; j++) {
				if (tempArr[i] == tempArr[j]) {
					i--; // 중복제거
					break;
				}
			}

		}

		// 위에서 만들어진 중복제거한 1차원 배열을 --> 2차원 배열에 넣기
		// String 배열로 변경해서 대입 진행 --> 왜? 빙고가 된 부분을 "★" 변경하기 위해서

		String[][] bingoBoard = new String[num][num];

		int index = 0;// 1차원 배열 인덱스 지정을 위한 변수

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {

				// 1차원 배열은 0부터 num*num까지 반복 진행

				bingoBoard[i][j] = tempArr[index] + ""; // ""넣어주는 이유 tempArr은 String이고 index int라고 맞춰주기 위해 넣어준다.
				index++;

			}
		}

		// -----------------------------------------------------------------
		// 랜덤 배치된 빙고판 최초 1회 출력 (빙고판 크기 만들기)
		for (int i = 0; i < bingoBoard.length; i++) {
			for (int j = 0; j < bingoBoard[0].length; j++) {
				System.out.printf("%4s", bingoBoard[i][j]);
			}
			System.out.println();
		}

		System.out.println("=========빙고게임시작=============");
		while (true) {
			System.out.println("정수를 입력하세요 : ");
			String input = sc.nextLine();

			boolean flag = true; // 검색된 값이 빙고판에 있는지 확인 (잘못된 입력 확인)
			for (int i = 0; i < bingoBoard.length; i++) {
				for (int j = 0; j < bingoBoard[0].length; j++) {

					// 입력된 값과 일치 되는 곳을 ★ 별행태로 변환
					if (bingoBoard[i][j].equals(input)) {
						bingoBoard[i][j] = "★";
						flag = false;
//					}else {
//						System.out.println("잘못 입력함. 다시 입력하세요");
//						
					}
					System.out.printf("%4s", bingoBoard[i][j]);
				}
				System.out.println();
			}
			if (flag) {
				System.out.println("잘못 입력 하셨습니다. 다시 입력 하세요");
				continue;// 밑에 코드 건너 띄고 위로 올라간다.
			}

			// 빙고판 크기에 따라 빙고 기분이 되는 문자열 생성
			// ex) 5*5 크기 빙고 -> 한줄이 "★★★★★"이면 빙고
			String bingoLine = "";
			for (int i = 0; i < num; i++) {
				bingoLine += "★";
			}

			// 빙고 검사
			int bingoCount = 0; // 빙고 수 저장할 변수

			// 가로(행) 또는 세로(열)의 문자열을 더하여 하나의 문자열로 저장
			// --> 저장된 문자열의 모양이 "★★★★★"인 경우 == 빙고
			// --> bingoCount 증가

			for (int i = 0; i < bingoBoard.length; i++) {
				
				//매 반복 시 마다 row,col을 빈 문자열로 초기화
				// --> 바깥쪽 for문이 반복 될 때 마다 검사하는 행과 열이 이동하므로
				//     빙고 여부를 검사하기 위한 row, col을 빈 문자열로 초기화 해야함.
				String row = "";
				String col = "";
				
				for(int j=0;j<bingoBoard.length;j++) {
					row +=bingoBoard[i][j]; // 현재 행의 문자를 모두 더함 
					
					//i,j(행렬)를 반대로 하여 열의 모든 문자를 더함 
					col +=bingoBoard[j][i];
				}

				if(row.equals(bingoLine)) {//가로 빙고가 존재할 경우 
					bingoCount++;
				}
				if(col.equals(bingoLine)) { //세로 빙고가 존재할 경우 
					bingoCount++;
					
				}
			}
		
			// 대각선 빙고 여부 
			// 대각선 : diagonal(다이애그널)
			
			//대각선은 빙고판에 두 개만 존재 
			// -> 대각선 문자를 더해서 저장할 변수 두개 선언 및 빈 문자열로 초기화 
			
			String dia1 ="";
			String dia2 ="";
			
			//대각선은 for문 하나로 가능 
			for(int i = 0;i<bingoBoard.length;i++) {
				dia1 += bingoBoard[i][i]; //좌상 우하 (0,0)(1,1)...
				
				dia2 += bingoBoard[bingoBoard.length-1 -i][i]; //우상 좌하 (4,1)(3,2)(2,2)...
			
			}
			if(dia1.equals(bingoLine)) {
				bingoCount++;
				
			}
			
			if(dia2.equals(bingoLine)) {
				bingoCount++;
			}
					
			
			// 빙고카운트 출력 : 
			System.out.println("현재"+bingoCount+"빙고");
			if(bingoCount>=3) {
				System.out.println("*****BINGO!!*******");
				break;
			}

		} // while문 종료
	}

}
