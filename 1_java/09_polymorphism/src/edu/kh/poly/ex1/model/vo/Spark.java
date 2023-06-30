package edu.kh.poly.ex1.model.vo;

public class Spark extends Car { //경차 
	
	private double discountOffer;
	
	public Spark() {}
	
	//매개변수 생성자 자동완성
	//alt + shift +s + o -> 아래방향키 -> enter
	public Spark(String engine, String fuel, int wheel, double discountOffer) {
		super(engine, fuel, wheel);
		this.discountOffer = discountOffer;
	}
	
	//getter /setter자동 완성
	public double getDiscountOffer() {
		return discountOffer;
	}

	public void setDiscountOffer(double discountOffer) {
		this.discountOffer = discountOffer;
	}
	

	@Override
	public String toString() {
		return super.toString()+"/"+discountOffer;
	}
	
	
		
	
	
	
	
	
	

}
