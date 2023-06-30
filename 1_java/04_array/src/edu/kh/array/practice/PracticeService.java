package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeService {

//	길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
	//	순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
	//	짝수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
	public void practice1() {
		int arr[] = new int[9];
		
		int sum = 0;
		
		for(int i=0; i < arr.length; i++) {
			arr[i] = i+1;
			
			if(i % 2 == 0) {
				sum += arr[i];
				//System.out.println("arr["+ i +"] 의 값 " );
			}
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("짝수 번째 인덱스 합 : " + sum);
		
	}
	
	//	길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
	//	순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
	//	홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급
	public void practice2() {

		int[] arr = new int[9];

		// int num = 9;

		int sum = 0; // 합계용 변수

		for (int i = 0; i < arr.length; i++) {

			arr[i] = 9 - i;
			// arr[i] = num;
			// num--;

			if (i % 2 == 1) { // i 가 홀수인 경우
				sum += arr[i];
			}

			System.out.print(arr[i] + " "); // 출력
		}

		System.out.println("\n홀수 번째 인덱스 합 : " + sum);

	}
	
	//	사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
	//	1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요

	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
		}
	}
	
	//	정수 5개를 입력 받아 배열을 초기화 하고
	//	검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
	//	배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		
		for(int i=0; i<arr.length; i++) {
			System.out.print("입력 " + i + " : ");
			arr[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int input = sc.nextInt();
		
		boolean flag = false;
		
		System.out.print("인덱스 : " );
		
		for(int i=0; i<arr.length; i++) {
			
			if(arr[i] == input) {
				System.out.print(i + " ");
				
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}
	}
	
	//	문자열을 입력 받아 문자 하나하나를 배열에 넣고 
	//	검색할 문자가 문자열에 몇 개 들어가 있는지
	//	개수와 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String input = sc.nextLine();
		
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0); // 입력 받은 문자열에서 0번 인덱스 문자를 반환
		//         String -> char
		
		char[] arr = new char[input.length()]; // 입력 받은 문자열 길이 만큼의 배열 생성
		
		int count = 0; // input에 일치하는 ch가 몇개 있는지 카운트하는 변수
		System.out.print(input + "에 " + ch + "가 존재하는 위치(인덱스) : ");
		
		for(int i=0; i < arr.length; i++) {
			
			// 배열 대입
			arr[i] = input.charAt(i);
			// 입력 받은 문자열에서 i번째 인덱스 문자를 arr[i]에 대입
			
			// 검색 + 카운트
			if(ch == arr[i]) { // 검색 조건
				count++;
				System.out.print(i + " ");
				
			}
		}

		System.out.println("\n"+ ch + "개수 : " + count);
		
		
	}
	
	
	//	사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
	//	배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
	//	그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
	
	public void practice6() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		int[] arr = new int[input];
		
		int sum = 0;
		String value = "";
		for(int i=0; i<arr.length; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			arr[i] = sc.nextInt();
			sum += arr[i];
			value += arr[i] + " ";
		}
		System.out.println(value);
		System.out.println("총 합 : " + sum);
	}
	
	
	//	주민등록번호 번호를 입력 받아 char 배열에 저장한 후 출력하세요.
	//	단, char 배열 저장 시 성별을 나타내는 숫자 이후부터 *로 저장하세요.
	public void practice7() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.nextLine();
		
		char[] arr = new char[input.length()];
		
		for(int i=0; i <arr.length; i++) {
			
			if(i <= 7) { // 7번 인덱스 이하(생년월일, - , 성별)
				arr[i] = input.charAt(i);		
			} else { // 8번 인덱스 이상부터는 *
				arr[i] = '*';
			}
			
			System.out.print(arr[i]);
		}
		
	}
	public void practice8() {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("정수 : ");		
		int i = sc.nextInt();
		if(i%3==1 ||i<3) {
			System.out.println("다시 입력 하세요.");
			}else {
			int[] arr = new int[i];
			for(int x=0;x<arr.length;x++) {
			 	System.out.print((x+1)+" ");
				}
			}
	}
	
	public void practice9() {
		
		int [] arr= new int[10];
		System.out.print("발생한 난수 : ");
		for(int i=0;i<arr.length;i ++) {
		arr[i]=(int)(Math.random()*10+1);
		
		System.out.print(arr[i]+" ");
		}
	}
	
	public void practice10() {
		
		int [] arr= new int[10];
		int max = arr[0];
		int min = arr[0];

		System.out.print("발생한 난수 : ");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
			
			if (arr[i] > max) {
				max = arr
						[i];
			}else if(arr[i] < min)
				min = arr[i];
			}
		System.out.print("\n최대값 : " + max);
		System.out.print("\n최소값 : " + min);
		
	}
	
	public void practice11() {
		
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr[i]) {
					i--;
					break;
				}
			}
		}

	for (int i = 0; i < arr.length; i++)
		System.out.print(arr[i] + " ");
	}
	
	public void practice12() {
		
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 45 + 1);
			
			for (int j = 0; j < i; j++) {
				if (arr[j] == arr[i]) {
					i--;
					break;
				}
			}
		}

		Arrays.sort(arr);
	for (int i = 0; i < arr.length; i++)
		System.out.print(arr[i] + " ");
	}
		
//  문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
//  문자의 개수와 함께 출력하세요
	public void practice13() {
     
     Scanner sc = new Scanner(System.in);
     
     System.out.print("문자열 : ");
     String input = sc.nextLine();
     
     char[] arr = new char[input.length()];
     
     int count = 0; // 카운트용 변수
     
     System.out.print("문자열에 있는 문자 : ");
     for(int i=0 ; i<arr.length ; i++) {
        arr[i] = input.charAt(i); // 문자열 -> char배열에 옮겨 담기
        
        // 중복 검사 + flag
        // application
        //배열 : [a, p, p, l, i, c, a, t, i, o, n]
        //화면 :  a, p, l, i, c, t, o, n
        //개수 :  1  2  3  4  5  6  7  8
        
        boolean flag = true; // 신호용 변수
        
        for(int x=0 ; x<i ; x++) { // 중복 검사용 for문
           if( arr[i] == arr[x] ) {
              // 현재 대입된 문자가 앞서 대입된 문자와 같다면 == 중복
              flag = false; // 신호용 변수의 값을 false로 변경
              break; 
           }
        }
        
        if(flag) { // flag가 true인 경우 == 중복이 없었다라는 의미
           
           count++; // 카운트 1 증가
           
           if(i == 0) { // 첫 바퀴인 경우
              System.out.print(arr[i]);
              
           }else { // 첫 바퀴가 아닌 경우
              System.out.print(", " + arr[i]);
           }
           
        }
        
     } // 바깥쪽 for문 끝
     
     System.out.println("\n문자 개수 : " + count);
     
  }
	
	public void practice14() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		sc.nextLine();//입력 버퍼 개행 문자 제거 
		
		String[] arr= new String[size];//우리가 입력한 size 만큼 배열 선언 및 할당
		
		int start = 0;
		//while 내 for문의 초기식에 사용될 변수 
		
		while(true) {
			
			for(int i =start;i<arr.length;i++) {
				System.out.print((i+1)+"번째 문자열 :");
				arr[i]=sc.nextLine();
			}
			
			System.out.print(" 더 값을 입력하시겠습니까?(Y/N) :");
			char input =sc.nextLine().charAt(0);
			              //입력 받은 문자열 중 제일 앞문자 하나만 얻어옴
			
			if(input=='Y' || input=='y') {
				
				start = arr.length;
				//추가 입력 받기 위한 추가 배열 부분의 시작 위치 
				System.out.print("더 입력하고 싶은 개수 :");
				int addsize = sc.nextInt();
				sc.nextLine();//입력 버퍼 개행 문자 제거 
				
				//증가 된 크기의 배열을 생성하여 arr배열 깊은 복사 
				String [] copyArr= new String[arr.length+addsize];
				for(int i=0;i<arr.length;i++) {//기존 배열 크기 만큼만 반복 
					
					copyArr[i]=arr[i]; //복사배열에 기존 배열 값을 같은 인덱스에 대입 
					
				}
				//배열의 얕은 복사 
				arr= copyArr; //arr이 참조하는 주소값을 copyArr의 주소값으로 바꿔서 
				              //arr이 참조하는 배열의 크기가 증가한 것 처럼 보이게 한다.
				
			}else {//y/n만 입력 했다는 상황을 가정 
				break; //while 반복을 종료 시킨다. (가장 가까운 반복문을 빠져나간다)
				
			}
				
		}//while 끝
		
		System.out.print(Arrays.toString(arr));

	}
		
}
