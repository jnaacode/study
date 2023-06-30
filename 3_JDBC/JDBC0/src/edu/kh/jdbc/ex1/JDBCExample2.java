package edu.kh.jdbc.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample2 {
	public static void main(String[] args) {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String type = "jdbc:oracle:thin:@";
			String ip = "localhost"; 
			String port = ":1521";
			String sid = ":xe"; //DB 이름
			String user = "pja"; // 사용자명
			String pw = "pja1234";	//비밀번호	
			

			conn = DriverManager.getConnection(type + ip + port +sid,user,pw);


			String sql = "SELECT * FROM EMPLOYEE_COPY ORDER BY EMP_ID";
			
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);
			int sum = 0;

			while (rs.next()) {
				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				String deptCode = rs.getString("DEPT_CODE");
				sum+=salary;

				System.out.printf("사번 :%d 이름 : %s 급여 : %7d 부서코드 : %s\n", empId, empName, salary,deptCode);
		
			}
			System.out.println("급여 합계 : "+sum);

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			System.out.println("OJDBC 라이브러리 미등록 또는 경로 오타");
			e.printStackTrace();

		} finally {

			try {
		
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
