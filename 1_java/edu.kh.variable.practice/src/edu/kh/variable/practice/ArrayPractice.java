package edu.kh.variable.practice;

import java.util.Scanner;

public class ArrayPractice {

	public void ex1() {
		
	
		int [] arr = new int [9]; // 길이가 9인 배열을 선언하고 할당한다. 
				
		for(int i = 0 ;i <arr.length;i++) { //반복문 이용해서 인덱스 요소 대입하고 출력
			arr[i]=i+1;
			System.out.print(arr[i] +" ");
			
		}
		System.out.println();
		int sum =0;
		for(int i =0;i<arr.length;i++) {
		if(i%2==0) { //arr[0] = 1
		sum+=arr[i];
		}
	}
		System.out.println("짝수번째 인덱스 합 :"+sum);
}

	
	public void ex2() {
		
		int [] arr = new int [9];
		
		for(int i =0; i < arr.length;i++) {
			arr[i] = 9-i;
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		int sum =0;
		for(int i =9;i>0;i--) {
			if(i%2==0) {
				sum+=i;
			}
		}
		System.out.println("홀수 번째 인덱스 합 :"+sum);
		// 8 6 4 2
		
	}
	
	public void ex3() {
		
		//  사용자에게 입력 받은 양의 정수 만큼 배열크기를 할당
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양의정수 : " );
		int input =sc.nextInt();
		int [] arr = new int [input];
		
		for(int i=1 ; i<=input;i++) {
			System.out.print(i+ " ");
		}
	}
	
	public void ex4() {
		
		//1. 정수 5개를 입력 받아 배열을 초기화하고
		//2. 검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력 
		//3. 배열에 같은 수가 없을 경우 '일치하지 값이 존재하지 않습니다'
		
		Scanner sc = new Scanner(System.in);
		
		
		
		int [] arr = new int [5];
		
		for(int i =0 ; i <arr.length ;i++) {
			System.out.print("입력 "+i+":"+ " ");
			arr[i] =sc.nextInt();
		}
		
		System.out.print("검색할 값  : ");
			int input = sc.nextInt();
		
			int count =0;
			
		for(int i =0; i<arr.length;i++) {
			if(arr[i] == input) {
				System.out.print("인덱스 :"+i);
				count++;//조건에 맞을때 똑같은 인덱스 값을 찾을때 돌아가니까
			}	
		}
		if(count==0) {
		System.out.println("일치하는 값이 존재하지 않습니다.");
		}
	}
	

	public void ex5() {
		
		// 검색할 문자가 문자열에 몇개 들어가 있는지와 개수와 몇번째 인덱스
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		
		String input1 = sc.nextLine();
		
		char [] arr = new char[input1.length()];
		for(int i =0;i<arr.length;i++) {
			arr[i] = input1.charAt(i);
			//문자열을 입력 받아 문자 하나하나를 배열에 넣고 
			//hello입력 했어 0 -> h 
		}
		
		int count =0;
		
		System.out.print("문자 : ");//e
		char input2 = sc.next().charAt(0);
		System.out.print(input1 + "에 "+input2+"가 존재하는 위치(인덱스) : ");
		
		for(int i =0; i <arr.length;i++) {
			if(input2 == arr[i]) {
				System.out.print(i+" ");
				count++;
			}
		}
		System.out.println("\n"+input1+"개수 : "+count);

	
	
		  Scanner sc1 = new Scanner(System.in);
	      
	      System.out.print("문자열 : ");
	      String input = sc1.nextLine();
	      
	      System.out.print("문자 : ");
	      char ch = sc1.next().charAt(0); // 입력 받은 문자열에서 0번 인덱스 문자를 반환
	      //         String -> char
	      
	      char[] arr1 = new char[input.length()]; // 입력 받은 문자열 길이 만큼의 배열 생성
	      
	      int count1 = 0; // input에 일치하는 ch가 몇개 있는지 카운트하는 변수
	      System.out.print(input + "에 " + ch + "가 존재하는 위치(인덱스) : ");
	      
	      for(int i=0; i < arr1.length; i++) {
	         
	         // 배열 대입
	         arr1[i] = input.charAt(i);
	         // 입력 받은 문자열에서 i번째 인덱스 문자를 arr[i]에 대입
	         
	         // 검색 + 카운트
	         if(ch == arr1[i]) { // 검색 조건
	            count1++;
	            System.out.print(i + " ");
	            
	         }
	      }

	      System.out.println("\n"+ ch + "개수 : " + count1);
	      
	      }   

		
		public void ex6() {
			
			Scanner sc = new Scanner(System.in);
			System.out.print("정수 :");
			int input= sc.nextInt();
			
			int sum =0;
			
			int [] arr = new int[input];
			for(int i =0; i<arr.length;i++) {
				System.out.print("배열"+i+"번째 인덱스에 넣는 값 : ");
				arr[i]=sc.nextInt();
			}

			for(int i = 0 ; i <arr.length;i++) {
				System.out.print(arr[i]+" ");
				sum+=arr[i];
			}
			
			System.out.println("\n총합 : " + sum);
		}
		
	

	public void ex7() {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민등록번호(-포함) :" );
		String str = sc.nextLine();
		
		for(int x= 0; x <14;x++) {
			if(x>=8) {
			System.out.print("*");
		}else {
			System.out.print(str.charAt(x));
		}

		}
	}
	
}

