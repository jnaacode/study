package parkjina;

import java.util.Arrays;
import java.util.Scanner;

public class ArraryStudy1 {
	
	public void ex1() {
		
		int [] arr = new int[3];
		arr[0]=10;
		arr[1]=50;
		arr[2]=80;
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
	}
	
	public void ex2() {
		int arr [] = new int[4];
		arr[0]=100;
		arr[1]=200;
		arr[2]=9000;
		arr[3]=10;
		
		for(int i=0; i <arr.length;i++) {
			System.out.printf("arr[%d]에 저장된 값 : %d\n",i,arr[i]);
		}
		
	}
	public void ex3() {
		
		// 5명의 키(cm)를 입력 받고 평균 구하기
	      
	      // 1번 키 입력 : 170.5
	      // 2번 키 입력 : 165.7
	      // 3번 키 입력 : 184.3
	      // 4번 키 입력 : 190.2
	      // 5번 키 입력 : 174.4
	      
	      // 입력 받은 키 : 170.5  165.7  184.3  190.2  174.4
	      // 평균 : 177.02cm
		
		Scanner sc = new Scanner(System.in);
		
		double [] height = new double[5];
		
		for(int i =0;i<height.length;i++) {
			System.out.print((i+1) + "번 키 입력 :");
			
			height[i] = sc.nextDouble();// 
			
		}
		System.out.println();
			
			double sum =0;
			System.out.print("입력 받은 키 :");
			
			for(int i =0 ; i<height.length;i++) {
				System.out.print(height[i]+" ");
				
				sum+=height[i];
				
			}
			System.out.printf("\n평균 : %.2f\n",sum /height.length);
	}
	
	public void ex4() {
		
		int [] arr = {100,200,300,400,500,600,700,800};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 :");
		int input = sc.nextInt();
		
		boolean flag =false; 
		
	
		for(int i =0;i<arr.length;i++) {
			if(input==arr[i]) { 
				System.out.println(i+"번째 인덱스에 존재");
				
				flag = true; 
			
			}
		}
 
		if(!flag) { 
			System.out.print("존재하지 않음");
		}
	}
	
	public void ex5() {
		
		String [] arr = {"사과","딸기","바나나","키워","멜론","아보카도"};
		
		Scanner sc= new Scanner(System.in);
		System.out.print("과일입력 : ");
		
		String input = sc.next();
		
		boolean flag = false ; 
		
		
	}
	
	public void ex6() {
		
		int [] arr = new int[4];
		
		arr[0]=100;
		arr[1]=200;
		arr[2]=500;
		arr[3]=1000;
		
		for(int i=0 ;i <arr.length;i++) {
			System.out.print("arr[%d]에 저장된 값은 %d이다.");
		}
		
	}
	
	public void ex7() {
		
		//1.입력 받은 인원 수 만큼 점수를 입력 받아 배열에 저장 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 받을 인원 수 :");
		int input = sc.nextInt();
		
		int [] score = new int[input];
		
			
	}
	
	public void ex8() {
		
		int [] arr = {1,2,3,4,5};
		int [] copyArr = arr;
		
		System.out.println(copyArr);
		
		System.out.println("변경 전");
		System.out.println("arr :" +Arrays.toString(arr)); //Arrays.toString 배열 숫자 나옴 
		System.out.println("copyArr :" +Arrays.toString(copyArr));
		
		arr[2] =9989;
		System.out.println("변경 후");
		System.out.println("arr :" +Arrays.toString(arr)); //Arrays.toString 배열 숫자 나옴 
		System.out.println("copyArr :" +Arrays.toString(copyArr));
		
		
	}
	
	
	public void ex9() {
		
		// 5명의 키(cm)를 입력 받고 평균 구하기
	      
	      // 1번 키 입력 : 170.5
	      // 2번 키 입력 : 165.7
	      // 3번 키 입력 : 184.3
	      // 4번 키 입력 : 190.2
	      // 5번 키 입력 : 174.4
	      
	      // 입력 받은 키 : 170.5  165.7  184.3  190.2  174.4
	      // 평균 : 177.02cm
		
		Scanner sc = new Scanner(System.in);
		
		double[] height = new double[5];
		
		for(int i =0 ; i<height.length;i++) {
			System.out.print((i+1) + "번 키 입력 :");
			height[i] = sc.nextDouble();
		}
		System.out.println();
			
			double sum =0;
			System.out.print("입력 받은 키 :");
			
			for(int i=0; i<height.length;i++) {
				System.out.print(height[i]+ " ");
				
				sum+=height[i];
			}
	
		System.out.printf("\n평균 : %.2f",sum/height.length);
	}
	
	public void ex10() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 받을 인원 수 :");
		int input = sc.nextInt(); // 입력 받은 인원 수 만큼의 점수를 받아 배열에 저장 
		
		int [] score = new int [input];
		
		int sum =0;
		
		for(int i =1; i <= score.length ;i++) {
			System.out.print(i+"번 점수 입력 : ");
			score[i]=sc.nextInt();
			
			sum+=score[i];
		}
		
		int max = score[0];
		int min = score[0];
		
		for(int i =0 ; i<score.length;i++) {
			
			if(score[i]> max) {
				
			}else if (score[i] <min) {
				min =score[i];
			}
		}
		
		System.out.println("합계 :");
		System.out.printf("평균 :%.2f\n",(double)sum / score.length);
		
		System.out.println("최고점 :"+max);
		System.out.println("최저점 :"+min);
		
	}
	
	public void ex11() {
		
		String [] arr = {"김밥","서브웨이","햄버거","백반","국밥","파스타"};
		
		System.out.print("오늘의 점심 메뉴 : " +arr[(int)(Math.random()*6)]);
		
	}
	
	public void ex12(){
		
		String [] arr = {"사과","딸기","바나나","키워","멜론","아보카도"};
		
		Scanner sc= new Scanner(System.in);
		System.out.print("과일입력 : ");
		
		String input = sc.next();
		
		boolean flag= false;
		
		for(int i =0; i <arr.length;i++) {
			
			if(input.equals(arr[i])) {
				System.out.print(i + "값이 존재한다.");
					flag = true;
				
					}
				}
			
			if(flag=true) {
			System.out.print("존재하지않음");
			}
		
		}
	
	public void ex13() {
		
//	  Scanner sc = new Scanner(System.in);
//	      
//	      System.out.print("문자열 : ");
//	      String input = sc.nextLine(); //문자열 입력 
//	      
//	      char [] arr = new char [input.length()]; //배열에 넣어 
//	      for(int i =0 ; i <arr.length;i++) { 
//	    	  arr[i] = input.charAt(i); //문자 하나하를 배열에 넣어 
//	      }
//	      
//	      int count =0;
//	      
//	      System.out.print("문자 : ");
//	      char ch = sc.nextLine().charAt(0);//1개 입력을 할거야 그러니 1개?
//	      System.out.print(input+"에"+ch+"가 존재하는 위치(인덱스):");
//	      
//	      for(int i=0;i<arr.length;i++) {
//	    	  if(arr[i]==ch) {
//	    		  System.out.print(i+ " ");
//	    		  count++;
//	    	  }
//	    	  
//	      }
//	  	System.out.println("\n"+ch+"개수 : "+count);
	}
	
	public void ex14() {
		
		Scanner sc = new Scanner(System.in);
		
		double [] height = new double [5];
		
		for(int i =0 ;i<height.length;i++) {
			
			System.out.print(i+1+" 번 키 입력 : ");
			
			height[i] = sc.nextDouble();
			
		}
		System.out.println();
		
		
		
	}
	
	public void ex15() {
		
		Scanner sc = new Scanner(System.in);
		
		int arr[][] = new int [3][];
		
		arr[0] = new int [3];
		arr[1] = new int [1];
		arr[2] = new int [2];
		
		for(int row =0 ; row<arr.length;row++) {
			
			for (int col = 0; col <arr[row].length;col++) {
				System.out.print("입력 : ");
				int input =sc.nextInt();
				arr[row][col]=input;
				
			}
		}
		
		System.out.print(Arrays.deepToString(arr));
		
	}

	
	public void ex16() {
		
		// 5명의 키(cm)를 입력 받고 평균 구하기
	      
	      // 1번 키 입력 : 170.5
	      // 2번 키 입력 : 165.7
	      // 3번 키 입력 : 184.3
	      // 4번 키 입력 : 190.2
	      // 5번 키 입력 : 174.4
	      
	      // 입력 받은 키 : 170.5  165.7  184.3  190.2  174.4
	      // 평균 : 177.02cm
		
		
		//1. 5명의 키를 입력 받아 
		
		Scanner sc = new Scanner(System.in);
		
		double[] height = new double[5];
		
		for(int i= 0 ; i <height.length ;i++ ) {
			
			System.out.print((i+1)+"번 키 입력 : ");
			height[i]=sc.nextDouble();
//			int x = sc.nextInt();
			
		}
		
		double sum =0;
		
		System.out.println("입력 받은 키 :");
		for(int i =0; i<height.length;i++) {
			System.out.print(height[i]+ " ");
			
			sum+=height[i];
			
		}
		
		System.out.printf("\n평균 : %f\n",sum/height.length);
	}
	
	public void ex17() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String input = sc.next();
		
		char[] ch = new char [input.length()];
		
		for(int i = 0 ; i<input.length(); i++) {
			ch[i] = input.charAt(i);
			// 문자열을 입력 받아 문자 하나하나를 배열에 넣고 
			
		}
		
		int count =0;
		
		System.out.print("문자 : ");
		int input1 = sc.nextInt();
		System.out.print(input+"에 "+input1+"존재하는 위치 (인덱스) : ");
		
		for(int i =0; i <input.length();i++) {
			if(ch[i]==input1) {
				count++;
			}
			
			
		}
		
		System.out.print(input1+ "개수 :" + count);
	}
	
	
	public void ex18() {
		
		//1. 정수 5개를 입력 받아 배열을 초기화하고
		//2. 검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력 
		//3. 배열에 같은 수가 없을 경우 '일치하지 값이 존재하지 않습니다
		
		Scanner sc = new Scanner(System.in);
		
		int[]arr= new int[5];
		
		for(int i = 0 ; i<arr.length;i++) {
			System.out.print("입력 "+i+ ":" );
//			int input = sc.nextInt();
			arr[i] =sc.nextInt(); //5개 입력 받으면서 배열에 초기화 
		}
		
		
		System.out.print("검색할 값 : ");
		int input = sc.nextInt();

		int count =0;
		
		for(int i=0; i <arr.length;i++) {
			if(arr[i]==input) {
				System.out.print("인덱스 : "+i);//i가 아닌 input를 넣어다 ? 내가 아까 검색한 값을 넣어줘 
												// 그게 아닌, 배열안에 내가 검색한 결과와 같은 갑을 찾아야해 
				
				count++;
			}
		}
		if(count==0) {
			System.out.println("값이 존재 하지 않습니다.");
		}
	}
	
	
	public void ex19() {
		
		
		int [] arr = new int[9];
		
		
		for(int i = 0; i <arr.length; i++) {
			arr[i]=i+1;
			System.out.print(arr[i]+" "+"");
			
//			
		}
		System.out.println();
		int sum =0;
		
		for(int i =0 ; i <9 ;i++) {
			if(i%2==0) { // 짝수번쨰 인덱스 값의 합이라며 그럼 이거 아님 ? 
				sum+=arr[i];
			}
			
		}
		System.out.print("짝수번째 인덱스 합 : "+sum);
	}

	public void ex28() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양수정수 : ");
		int input = sc.nextInt();
		
		int arr [] = new int [input];
		
		for(int i =0; i < input;i++) {
			
			arr[i]=i+1;
			System.out.print(arr[i]);
			
		}
		
		
		
		
	}
	
	public void ex20() {
	char ch = 'A';
	char ch2 = 66; // B
	// ** char 자료형에 숫자가 대입될 수 있는 이유
	// - 컴퓨터에는 문자표가 존재하고 있는데
	//   숫자에 따라 지정된 문자 모양이 매핑되어있고
	//   'B' 문자 그대로가 대입이 되면 변수에 숫자 66으로 변환되어 저장
	//   -> 반대로 생각하면 변수에 애초에 66이라는 숫자를 저장하는 것이 가능
	
	System.out.println("ch : " + ch);
	System.out.println("ch2 : " + ch2);
	}
	
	public void ex99() {
		
	
		// 구구단 2~9단까지 모두 출력
		// 단, 2단은 x2까지 3단은 x3까지 ....9단은 x9까지만 출력 
		
		for(int dan = 2 ; dan <=9; dan++) {
			for(int i = 1 ;i <= 9 ;i++) {
				System.out.printf("%d x %d =%2d ", dan,i,dan*i);
				
				if(dan == i) {
					break;
					
					
				}
			}
			System.out.println();//줄바꿈
		}
	}
	
	public void ex21(){
		
		int [] arr = {100,200,300,400,500,600,700,800,900,1000};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 :" );
		int input = sc.nextInt();
		boolean flag = true;
		
		for(int i = 0;i<arr.length;i++) {
			if(input==arr[i]) {
				System.out.print(i+"번째 인덱스에 존재");
				flag = false;
			}
		}
		if(flag) {
			System.out.print("존재하지 않습니다.");
		}
	}
	public void ex22() {
	
		//정수 5개를 입력 받아 배열을 초기화 하고
		//	검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
		//	배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		
		for(int i=0;i <arr.length;i++) {
			System.out.print("입력"+i+":");
			arr[i]=sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int input = sc.nextInt();
	
		boolean flag = true;
		
		System.out.print("인덱스 : ");
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==input) {
				System.out.print(i+ " ");
				flag = false;
			}
		}
		 if(flag) {
			 System.out.print("값이 존재하지 않습니다");
			
		}
	}
	public void ex23() {
		
		//문자열을 입력 받아 문자 하나하나를 배열에 넣고 
		//검색할 문자가 문자열에 몇개 들어가 있는지 
		//개수와 몇번째 인덱스에 위치하는지 인덱스를 출력하세요. 
		
		Scanner sc= new Scanner(System.in);
		System.out.print("문자열 : ");
		String input1 = sc.next();
		
		System.out.print("문자 :");
		char input2 = sc.next().charAt(0);
		char[]arr=new char[input1.length()];
		
		int count =0;
		System.out.print(input1+"에"+input2+"가  존재하는 위치(인덱스) :");
		for(int i =0;i<arr.length;i++) {
			arr[i]=input1.charAt(i);
			
			if(input2 ==arr[i]) {
				count++;
				System.out.print(i+ " ");
			}
		}
	}
	public void ex24() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String input1 = sc.next();
		
		System.out.print("문자 :");
		char input2 = sc.next().charAt(0);
		
		char [] arr= new char[input1.length()];
		
		int count =0;
		
		System.out.print(input1+"에"+input2+"가  존재하는 위치(인덱스) :");
		for(int i =0;i<arr.length;i++) {
			arr[i]=input1.charAt(i);
			
			if(arr[i]==input2) {
				count++;
				System.out.println(i+"개수");
			}
		}

	}
}
	
	

		
		
		

	

	


