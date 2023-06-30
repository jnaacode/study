package edu.kh.inheritance.practice.model.vo;

public class Person {
	
	protected String name;
	private int age;
	private double heigth;
	private double weight;
	
	public Person() {}

	public Person(int age, double heigth, double weight) {

		this.age = age;
		this.heigth = heigth;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public double getHeigth() {
		return heigth;
	}

	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return name+"/"+age+"/"+heigth+"/"+weight;
	}
	

}
