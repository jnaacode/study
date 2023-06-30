package edu.kh.jdbc.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class LoadXML {

	public static void main(String[] args) {
			
		// 외부 XML 파일 읽어오기(Properies 사용)
		
		Properties prop = new Properties();
		// key,value가 String으로 제한된 Map
		
		try {
			prop.loadFromXML(new FileInputStream("driver.xml"));
				// 적제
			// Property : 속성(데이터)
			// prop.getProperty("driver") : XML에서 얻어온 값 중 
			//                              key가 "driver" 엔트리의 value를 얻어옴 
			System.out.println("driver : "+ prop.getProperty("driver"));
			
			// 외부 파일 미사용
			String str = "oracle.jdbc.driver.OracleDriver";
			System.out.println(str);
			
			//Java는 코드가 한 글자라도 변환되면 다시 처음부터 전체 내용을 컴파일(이진 코드 번역) --> 비효율적 
			//그런데, Java에 외부 파일을 읽어오는 변하지 않는 코드를 작성하면
			//컴파일을 다시 하지 않음 --> 효율적
			
			// 컴파일을 다시 하지 않아도 외부파일 내용이 변하면 자동으로 반영됨
			
			//DB 연결정보, SQL 내용은 빈번히 자주 변화된 예정
			// 1) Java 코드에 직접 작성 > 컴파일 > 실행 (비효율)
			// 2) XML에 작성 -> 바로 실행(다시 컴파일 X, 효율적)
			//   + (추가효과) DB정보와 SQL 한곳에 모아서 관리(보기 좋고, 관리가 쉬움)
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		System.out.println(JDBCTemplate.getConnection());
	
		
	}
	
	
}
