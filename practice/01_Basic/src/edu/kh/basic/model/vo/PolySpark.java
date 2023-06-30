package edu.kh.basic.model.vo;

public class PolySpark extends PolyCar {
	
	private double discountOffer;
	
	public PolySpark() {
		// TODO Auto-generated constructor stub
	}

	public PolySpark(String engine, String fuel, int wheel, double discountOffer) {
		super(engine, fuel, wheel);
		this.discountOffer = discountOffer;
	}

	public double getDiscountOffer() {
		return discountOffer;
	}

	public void setDiscountOffer(double discountOffer) {
		this.discountOffer = discountOffer;
	}
	
	public String toString() {
		return super.toString()+"/"+discountOffer;
	}

}
