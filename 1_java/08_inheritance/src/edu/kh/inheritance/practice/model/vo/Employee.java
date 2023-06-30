package edu.kh.inheritance.practice.model.vo;

public class Employee extends Person{
	
	private int salary;
	private String dept;
	
	public Employee() {
		super();
	}

	public Employee(String name,int age, double heigth, double weight,int salary, String dept) {
		super(age,heigth,weight);
		super.name=name; //직접접근해서 초기화 된 걸 의미 
		this.salary = salary;
		this.dept = dept;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return super.toString()+"/"+salary+"/"+dept;
	}

}
