package edu.kh.poly.ex2.model.service;

//계산기 인터페이스
// -> 모든 계산기에 대한 공통필드, 기능명을 제공하는 접점(interface)용도 

public interface Calculator {
	
//	인터페이스 : 추상 클래스의 변형체 (추상클래스보다 추상도 높음)
//			   추상 클래스 : 일부만 추상메소드(0개 이상)
//			   인터페이스 : 모든 추상 메소드  !!!!!!
	
//	필드 (묵시적 public static final)
//	아래 오류 안나는거 보이시죠 ? 어떻게 작성하든 모든 public static fianl이다. 
	public static final double PI = 3.14;
	static final int MAX_NUM =10000;
	public int MIN_NUM =-100000;
	int ZERO =0;
	
//	메소드(묵시적 public abstract)
	public abstract int plus(int num1,int num2);
	
	public abstract int minus(int num1,int num2);
	
	public abstract int multiple(int num1,int num2);
	
	public abstract double divide(int num1,int num2);

}
