package edu.kh.basic.model.vo;

public class InheritanceStudent extends InheritancePerson {
	
	private int grade;
	private int classRoom;
	
	public InheritanceStudent() {
		// TODO Auto-generated constructor stub
	}

	public InheritanceStudent(String name, int age, String nationality, int grade, int classRoom) {
		super(name, age, nationality);
		this.grade = grade;
		this.classRoom = classRoom;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}

	@Override
	public String toString() {
		return super.toString()+"/"+grade+"/"+classRoom;
	}


	
	
	
	

}
