package edu.kh.exception.model.vo;

import java.io.FileNotFoundException;

public class Child extends Parent {
	
    @Override
    public void method() throws FileNotFoundException {
        System.out.println("오버라이딩 된 자식 메소드");
		
//		오버라이딩 :상속받은 메소드를 자식이 재정의
//		성립조건 :메소드명 반환형 매개변수동일 접근제한자 같거나 더 넓은 범위
		
//		성립조건 : 예외의 범위는 같거나 더 좁게 
//		* 좁은 범위 == 구체적인 예외 
		
//		FileNotFoundException은 IOException의 자식 예외이므로 오버라이딩 가능!
//		Exception(모든 예외의 부모)은 IOException의 부모예외이므로 오버라이딩 불가
	}

}
