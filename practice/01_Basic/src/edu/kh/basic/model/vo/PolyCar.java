package edu.kh.basic.model.vo;

public class PolyCar {
	

	private String engine;//엔진
	private String fuel;//연료
	private int wheel;
	
	public PolyCar() {
		// TODO Auto-generated constructor stub
	}

	public PolyCar(String engine, String fuel, int wheel) {
		super();
		this.engine = engine;
		this.fuel = fuel;
		this.wheel = wheel;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	
	public String toString() {
		return engine+"/"+fuel+"/"+wheel;
	}
	
}
