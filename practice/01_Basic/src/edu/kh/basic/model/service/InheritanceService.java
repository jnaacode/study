package edu.kh.basic.model.service;

import edu.kh.basic.model.vo.InheritancePerson;
import edu.kh.basic.model.vo.InheritanceStudent;

public class InheritanceService {
	
	public void ex1() {
		
		InheritancePerson p1  = new InheritancePerson();
		
		p1.setAge(28);
		p1.setName("박진아");
		p1.setNationality("대한민국");
		
		System.out.println(p1.getAge());
		System.out.println(p1.getName());
		System.out.println(p1.getNationality());

		InheritanceStudent std = new InheritanceStudent();
		
		System.out.println("----------------------------------");
		
		std.setAge(11);
		std.setClassRoom(5);
		std.setGrade(3);
		std.setName("최지연");
		std.setNationality("미국");
		
		System.out.println(std.getAge());
		System.out.println(std.getClassRoom());
		System.out.println(std.getGrade());
		System.out.println(std.getName());
		System.out.println(std.getNationality());
		
		InheritanceStudent std1 = new InheritanceStudent("공유",35,"한국",1,3) ;
		System.out.println(std1);
	}

}
