package edu.kh.basic.model.vo;

public class PolyTesla extends PolyCar {

	private int batteryCapacity;
	public PolyTesla() {
		// TODO Auto-generated constructor stub
	}
	public PolyTesla(String engine, String fuel, int wheel, int batteryCapacity) {
		super(engine, fuel, wheel);
		this.batteryCapacity = batteryCapacity;
	}
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	
	public String toString() {
		return super.toString()+"/"+batteryCapacity;
	}
	
}
