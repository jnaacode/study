package edu.kh.oop.cls.model.vo;

class TestVo {
	
	//접근 제한자 (default) : 같은 패키지 내에서만 import가 가능함을 나타냄.  
	
	//Student 와 같은 패키지 
	
	//public, protected, (default) 3개만 접근이 가능하다. 
	
	public void ex( ) {
		
		System.out.println("같은 패키지");
		
		Student std = new Student();
		
		System.out.println(std.v1);
		System.out.println(std.v2);
		System.out.println(std.v3);
//		System.out.println(std.v4); 
//		ㄴprivate이기 때문에 같은 패키지라도 다른 클래스에서 직접 접근이 불가능하다.
		
		
		
		
	}
	

}
