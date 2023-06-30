package edu.kh.exception.model.vo;

import java.io.IOException;

public class Parent {
	
	public void method() throws IOException  {
		//호출한 곳으로 IOException이라는 예외를 던짐]
		//해당 메소드는 IOException을 발생 시킬 가능성이 있음으로 
		//호출 하는곳에서 예외처리를 해야한다. 
		
		System.out.println("부모메소드");
		
	}
	
	

}
