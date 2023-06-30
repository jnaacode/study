package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Book;

public class BookService {
	
	public void practice() {
		// 1) 기본 생성자를 이용하여 첫 번째 Book 객체 생성
		// 2) 매개변수 생성자를 이용하여 두 번째 Book 객체 생성 (사용 데이터 참고)
		// 3) 객체가 가진 필드 값을 toString()을 이용하여 출력
		Book b1 = new Book();
		Book b2 = new Book("자바의정석",30000,0.2,"남궁성");
		
	      System.out.println(b1.toString());
	      System.out.println(b2.toString());
	      
	      System.out.println("==========================");
	      
	      System.out.println("수정된 결과 확인");
	      b1.setTitle("c언어");
	      b1.setPrice(30000);
	      b1.setDiscountRate(0.1);
	      b1.setAuthor("홍길동");
	      
	      System.out.println(b1);
	      
	      System.out.println("==========================");
	      
	   // 6) 각 객체의 할인율을 적용한 책 가격을 계산해서 출력
	   // 7) 할인된 가격 = 가격 - (가격 * 할인율_
	      
	      
	      System.out.printf("도서명 = %s \n할인된 가격 = %d\n", b1.getTitle(), b1.getPrice() - (int)(b1.getPrice() * b1.getDiscountRate()));
	      System.out.printf("도서명 = %s \n할인된 가격 = %d\n", b2.getTitle(), b2.getPrice() - (int)(b2.getPrice() * b2.getDiscountRate()));
	      

	
	}
	

}
