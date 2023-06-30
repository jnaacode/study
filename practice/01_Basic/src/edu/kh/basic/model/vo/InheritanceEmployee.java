package edu.kh.basic.model.vo;

public class InheritanceEmployee extends InheritancePerson{
	
	
	private String company;
	
	public InheritanceEmployee() {
		// TODO Auto-generated constructor stub
	}

	public InheritanceEmployee(String name, int age, String nationality, String company) {
		super(name, age, nationality);
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "InheritanceEmployee [company=" + company + "]";
	}
	 
	
	

}
