package edu.kh.array2.ex;

import java.util.Arrays;
import java.util.Scanner;

public class Array2Example {
	
	/* 2차원 배열 
	 * 
	 * 자료형이 같은 1차원 배열을 묶음으로 다루는 것 
	 * -> 행/열 개념이 존재한다. 
	 * 	
	 */
	
	public void ex1() {
		
		//2차원 배열 선언 
		int [][] arr;// -> int 2차원 배열을 참조하는 참조 변수를 선언
		//(참조형 == 참조변수 == 레퍼런스 변수 == 레퍼런스)
		
		//2차원 배열 할당  
		//-> new 자료형 [행크기][열크기]
		arr = new int [2][3];
		//heap 영역에 int 2차원 배열 2행3열 공간을 할당 한다. 
		
		//2차원 배열  초기화
		
		//1)행, 열, 인덱스를 이용해서 직접 초기화
//		arr = new int [2][3];
//		
//		arr[0][0]=10;
//		arr[0][1]=20;
//		arr[0][2]=30;
//		
//		arr[1][0]=40;
//		arr[1][1]=50;
//		arr[1][2]=60;
		
		//2) 2중 for문 
		
		int num = 10; //배열 요소 초기화에 사용할 변수 

		//배열길이
		// 배열명.length는 변수가 직접 참조하고 있는 배열의 길이를 변환 
		
		
		System.out.println(arr.length); // 2(행 길이)
		//arr이 참조하고 있는 2차원 배열의 행의 길이 
		
		
		System.out.println(arr[0].length); //3 (열 길이)
		System.out.println(arr[1].length);
		//arr[0]행이 참조하고 있는 1차원 배열(열)의 길이 
		
		
		//Arrays.toString(배열명): 참조하고 있는 1차원 배열 값을 문자열을 반환
		System.out.println(Arrays.toString(arr));
		
		//Arrays.deepToString(배열): 참조하고 있는 배열의 데이터가 나오는 부분까지 파고들어 
		//모든 값을 문자열로 반환한다. 
		System.out.println(Arrays.deepToString(arr));
	
		for(int row = 0; row < arr.length ; row++) {//행 반복 (0,1)
			
			for(int col = 0 ; col <arr[row].length;col++) {//열반복 (0,1,2){
				
				arr[row][col]=num;
				num+=10;
				
			}
			
		}
		System.out.print(Arrays.deepToString(arr));
	}
	
		
	public void ex2() {
		
		   //2차원 배열 선언과 동시에 초기화 
	      //3행 3열짜리 정수형 2차원 배열 선언과 동시에 
	      //1~9까지 초기화 
		
		int [][]arr = {{1,2,3},
				       {4,5,6},
				       {7,8,9}  };
		
		//행, 별로 합 출력 
		
		
		for(int row =0; row <arr.length;row++) {//행반복
			int sum =0;
			
			for(int col =0; col <arr[row].length;col++) {//열반복
				
				sum+=arr[row][col];//현재 행의 모든 열 값을 누적 
			}
			System.out.printf("%d행의 합 : %d\n",row,sum);
		}
		
		System.out.println("-------------------------------------");
		
		//열별로 합 출력 
		//-> 열 부터 지정 후 각 행의 값을 누적 
		//--> 완전한 사각형의 형태를 지닌 2차원 배열은 
		//	     모든 열의 길이가 같다. 
		
		for( int col = 0; col <arr[1].length;col++) {//열반복 --> arr[i] -> 1 2 3다 들어갈 수 있어 왜냐고? 정사각형은 모든 열의 길이가 같아
			int sum =0;
			
			for(int row =0 ;row <arr.length ; row++) { //행반복 
				
				sum+= arr[row][col];
				
			}
			System.out.printf("%d열의 합 : %d\n", col,sum);
		}
				
		System.out.print("---------------------------------------");
		
		//전체 합 출력
		
		int sum =0;
		for(int row = 0; row <arr.length;row++) {
			
			for(int col =0; col<arr[row].length;col++) {
				
				sum+=arr[row][col];
			}
		}
		System.out.println("\n"+sum);
	}

	public void ex3() {

		//가변 배열 
		// 2차원 배열 생성시 마지막 배열 차수(열)을 지정하지 않고
		// 나중에 서로 크기가 다른 1차원 배열을 생성하여 참조하는 배열  --> 행만 먼저 지정하고 나중에 열만 지정할거야
		
		char[][] arr = new char [4][];
		 				// char 2차원 배열 생성시 행 부분만 생성 
		
		arr[0] = new char[3]; //0행에 3열짜리 1차원 배열을 생성하여 주소값 저장
		arr[1] = new char[4]; //1행에 4열짜리 1차원 배열을 생성하여 주소값 저장
		arr[2] = new char[5]; //2행에 5열짜리 1차원 배열을 생성하여 주소값 저장
		arr[3] = new char[2]; //3행에 2열짜리 1차원 배열을 생성하여 주소값 저장
		
		//각 배열 요소에 'a' 부터 차례대로 대입 
		
		char ch = 'a';
		
		for(int row =0;row <arr.length ;row++) {
			
			for(int col =0; col <arr[row].length;col++) {
				
				arr[row][col]=ch++;
				//ch+=1;
				
			}
		}
		System.out.print(Arrays.deepToString(arr));
		
	}
	
	public void ex4() {
	
	
    Scanner sc = new Scanner(System.in);
    
    
    
    int[][]arr =new int[2][2];

    
    for(int i = 0; i <arr.length;i++) {
       
       for(int x =0; x <arr[i].length;i++) {
          System.out.print("입력 : ");
          int input = sc.nextInt();
          System.out.print(arr[i][x] = input);
       }
       
      }
			
	}
}
       
    

		
		
	


