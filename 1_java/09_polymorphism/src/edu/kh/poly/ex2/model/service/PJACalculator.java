package edu.kh.poly.ex2.model.service;

import edu.kh.poly.ex2.model.vo.Animal;

public class PJACalculator extends Animal implements Calculator{
	
	//클래스와 인터페이스는 동시 상속이 가능
	//인터페이스는 다중 상속 가능
	
	//extends : 확장하다. / implements : 구현하다 
	//(부)클래스 = (자)클래스 상속시에는 extends 사용 (추상 클래스도 포함)
	
	//(부)인터페이스 = (자)클래스 상속시에는 implements 사용 (추상 클래스도 포함)
	
	   @Override
	   public int plus(int num1, int num2) {
	      return num1+num2;
	      
	   }

	   @Override
	   public int minus(int num1, int num2) {
	      // TODO Auto-generated method stub
	      return num1-num2;
	   }

	   @Override
	   public int multiple(int num1, int num2) {
	      return num1*num2;
	   }

	   @Override
	   public double divide(int num1, int num2) {
	      // TODO Auto-generated method stub
	      return num1/num2;
	   }


	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void breath() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
