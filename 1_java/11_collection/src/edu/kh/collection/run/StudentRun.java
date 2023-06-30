package edu.kh.collection.run;

import edu.kh.collection.model.serivce.StudentService;

public class StudentRun {
	
	public static void main(String[] args) {
	
		StudentService service = new StudentService(); 
	
		service.displayMenu();
//		service.ex();
	}

}
