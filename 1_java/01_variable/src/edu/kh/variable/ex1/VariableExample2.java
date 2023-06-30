package edu.kh.variable.ex1;

public class VariableExample2 {
	
	public static void main(String[] args) {
		
		/* 자바 기본 자료형 8가지
		 * 
		 * 논리형 : boolean(1byte)
		 * 정수형 : byte(1byte), short(2byte), int(4btye), long(8byte)
		 * 실수형 : float(4byte), double(8byte)
		 * 문자형 : char(2byte, 유니코드)
		 * 
		 * */
		
		// 변수 선언 : 메모리에 값을 저장할 공간을 할당 하는 것
		// 변수 값 대입(집어넣기) : 변수에 값을 집어 넣는 것
		
		// * 카멜(낙타) 표기법
		// 연결되는 두 단어 중 후속 단어의 첫 문자를 대문자로 표기
		
		boolean booleanData;
		// 메모리에 논리 값(t/f)을 저장할 공간을 1byte 할당하고
		// 할당된 공간을 booleanData라고 부르겠다.
		
		booleanData = true; // booleanData 변수에 true값을 집어 넣기
		System.out.println("booleanData : " + booleanData);
		
		byte byteNumber = 127; //(short, byte는 옛날 코드의 잔재)
		// 메모리에 정수 값을 저장할 공간을 1byte 할당하고
		// 할당된 공간을 byteNumber라고 부르겠다.
		// 선언된 byteNumber 변수에 처음으로 127을 집어 넣음
		//  --> 초기화 : 처음 변수에 값을 대입
		
		short shortNumber = 32767; // 변수 선언 및 초기화
	//  자료형   변수명      = 리터럴
		
		// ** 리터럴 : 변수에 대입되거나 작성 되어지는 값 자체
		// + 자료형에 따라 리터럴 표기법이 다름
		
		// 정수 자료형 기본형!
		int intNumber = 2147483647; // 변수 선언 및 초기화
		
		long longNumber = 10000000000L; // 또는 소문자 l
		// The literal 10000000000 of type int is out of range 
		
		float floatNumber = 1.2345f;
		// Type mismatch: cannot convert from double to float
		
		double doubleNumber = 3.141592;
		// double이 실수형 중에서 기본형
		// (리터럴 표기법이 없는 실수는 double로 인식)
		
		// 문자형 리터럴 표기법 : '' (홑따옴표)
		// -> 문자 하나
		char ch = 'A';
		char ch2 = 66; // B
		// ** char 자료형에 숫자가 대입될 수 있는 이유
		// - 컴퓨터에는 문자표가 존재하고 있는데
		//   숫자에 따라 지정된 문자 모양이 매핑되어있고
		//   'B' 문자 그대로가 대입이 되면 변수에 숫자 66으로 변환되어 저장
		//   -> 반대로 생각하면 변수에 애초에 66이라는 숫자를 저장하는 것이 가능
		
		System.out.println("ch : " + ch);
		System.out.println("ch2 : " + ch2);
		
		
		// 변수 명명 규칙
		
		// 1. 대소문자 구분, 길이제한 X
		int abcdefghijklmnopqrstuvwxyz;
		int abcdefghijklmnopqrstuvwxyZ; // Z 다름
		
		// 2. 예약어 사용 X
		//double double;
		
		// 3. 숫자 시작 X
		//char 1abc;
		
		// 4. 특수문자 $, _ 만 사용 가능 ( 하지만 쓰지 않는다 )
		int $intNumber; // 문제는 없지만 개발자가 직접 작성하진 않음
		int int_number; // 자바는 카멜표기법 사용
						// _ 작성 표기법은 DB에서 사용
		
		// 5. 카멜 표기법
		// -> 변수명 작성 시 여러 단어를 이어서 작성하는 경우
		//    띄어쓰지 않고 후속 단어 첫 글자를 대문자로 작성
		//    단, 첫 시작 글자는 소문자로 하는 것이 관례
		char helloWorldAppleBananaTomato;
		
		// 6. 변수명은 언어를 가리지 않음 ( 하지만 사용하지 않음 )
		int 정수1번;
		double 실수2번 = 3.14;
		System.out.println(실수2번);
		
		// ---------------------------------------------------------------
		
		int number = 10;
		System.out.println("number : " + number); // 10
		
		number = 20;
		System.out.println("number : " + number); // 20
		
		/* 상수(항상 같은 수) :
		 * - 변수 한 종류
		 * - 한번 값이 대입되면 다른 값을 대입할 수 없음
		 * - 자료형 앞에 final 키워드를 작성 (마지막 대입되는 값)
		 * 
		 * - 상수 명명 규칙 : 모두 대문자, 여러 단어 작성 시 "_" 사용
		 * 
		 * - 상수를 사용하는 경우
		 *  1) 변하면 안되는 고정된 값을 저장할 때
		 *  2) 특정한 값에 의미를 부여하는 경우 
		 * 
		 * */
		
		final double PI_VALUE = 3.14;
		//PI_VALUE = 2.3222; // 에러! 대입 불가
		
		final int LEFT_MOVE = -1;
		final int RIGHT_MOVE = 1;
		
		System.out.println(1 + 1.3);
		
		
		
	}

}
