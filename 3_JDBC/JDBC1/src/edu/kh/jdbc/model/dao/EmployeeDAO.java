package edu.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.model.vo.Employee;

//DAO (Date Acces Object ) : 데이터 접근 객체 
// - DB와 연결되어 SQL을 수행하고 결과를 반환 받는 역할 
public class EmployeeDAO {

	// JDBC 객체 저장용 참조 변수 필드 선언
	private Connection conn;
	// DB 연결 정보를 담은 객체 (Java - DB 사이의 통로 역할)

	private Statement stmt;
	// Connection을 통해 SQL을 수행하고 결과를 반환 받는 객체

	private PreparedStatement pstmt;
	// Statement의 자식으로 좀 더 향상된 기능 제공
	// - ? (위치홀더)를 이용하여 SQL에 작성되어지는 리터럴을 동적으로 제어한다.
	// --> 오타 위험 감소, 가독성 상승

	private ResultSet rs;
	// SELECT 수행 후 반환되는 객체

	/**
	 * 전체 사원 정보 조회 DAO
	 * 
	 * @return
	 */
	public List<Employee> selectAll() {

		// 결과 저장용 변수 준비
		List<Employee> empList = new ArrayList<Employee>();

		try {
			// 1) Oracle JDBC Driver 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2) DB 연결 작업(Connection 얻어오기)
			String type = "jdbc:oracle:thin:@"; // JDBC 드라이버가 thin 타입

			String ip = "localhost"; // DB 서버 컴퓨터 IP
			// localhost == 127.0.01

			String port = ":1521";
			String sid = ":xe"; // DB 이름
			String user = "pja"; // 사용자명
			String pw = "pja1234"; // 비밀번호

			conn = DriverManager.getConnection(type + ip + port + sid, user, pw);
			// DriverManager : Connection 생성 메소드 제공

			// 3) 수행할 SQL 작성
			String sql = "SELECT * FROM EMPLOYEE_COPY ORDER BY EMP_ID";

			// 4) Statemet 객체 생성
			stmt = conn.createStatement();// 커넥션을 왔다갔따 하는 셔틀버스 같은 역할

			// 5) SQL 수행 후 결과(ResultSet) 반환 받기
			rs = stmt.executeQuery(sql);
			// executeQuery() : SELECT 문 수행 후 ResultSet 결과를 반환

			// 6) 결과를 List에 옮겨 담기
			// -> ResultSet을 한 행씩 접근하여 컬럼값을 얻어와
			// 한 행의 정보가 담긴 Employee 객체를 생성하고 이를 empList에 추가

			while (rs.next()) {
				// rs.next() : 다음 행이 있으면 true, 호출 시 마다 다음 행으로 이동

				int empId = rs.getInt("EMP_ID"); // 현재 행의 EMP_ID 컬럼 값을 int 자료형으로 얻어옴
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String deptCode = rs.getString("DEPT_CODE");
				String jobCode = rs.getString("JOB_CODE");
				String selLevel = rs.getString("SAL_LEVEL");
				int salary = rs.getInt("SALARY");
				double bonus = rs.getDouble("BONUS"); // 실수형
				int managerId = rs.getInt("MANAGER_ID");
				Date hireDate = rs.getDate("HIRE_DATE");
				Date entDate = rs.getDate("ENT_DATE");
				char entYn = rs.getString("ENT_YN").charAt(0);

				// rs.getChar()는 존재하지 않음
				// 왜? 자바에서는 문자 하나(char) 개념이 있지만, DB에서는 오로지 문자열 개념만 존재 함
				// -> String.CharAt(0) 을 이용함

				// 얻어 온 컬럼 값으로 객체 생성 초기화
				Employee emp = new Employee(empId, empName, empNo, email, email, deptCode, jobCode, selLevel, salary,
						bonus, managerId, hireDate, entDate, entYn);

				// empList 추가
				empList.add(emp);
				System.out.println(empList);

			}

		} catch (Exception e) {
			// Exception : 모든 예외의 최상위 부모
			// -> try 에서 발생하는 모든 예외를 잡아서 처리
			e.printStackTrace();

		} finally {

			// 7) 사용한 JDBC 자원 반환 (Close)
			// -> 이때 생성 역순으로 반환하는게 좋다.

			try {

				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.cancel();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// 8) List 호출부로 반환

		return empList; // EmployeeService 반환된다.
	}

	/**
	 * 사번으로 사원 정보 조회 DAO
	 * 
	 * @param input
	 * @return
	 */
	public Employee selectOne(int input) {

		Employee emp = null; // 결과 저장용 변수

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 메모리 로드

			String type = "jdbc:oracle:thin:@"; // JDBC 드라이버가 thin 타입
			String ip = "localhost"; // 접속할 아이피
			String port = ":1521";
			String sid = ":xe"; // 접속할DB 이름
			String user = "pja"; // 사용자 계정 명
			String pw = "pja1234"; // 사용자 계정 비밀번호

			// 커넥션 생성
			conn = DriverManager.getConnection(type + ip + port + sid, user, pw);

			// SQL 준비
			String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID =" + input;

			// Statement 생성
			stmt = conn.createStatement();

			// SQL 수행 후 결과 반환 받기
			rs = stmt.executeQuery(sql);

			// 조회 결과가 있다면 1행 밖에 나오지 않으므로
			// while 대신 if문 사용

			if (rs.next()) {
				// 조회 결과가 있으면 rs.next() == true 값 --> if문 수행

				// 조회 결과가 없으면 rs.next() == false --> if문 수행 x --> Employee 객체 생성 x

				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String deptCode = rs.getString("DEPT_CODE");
				String jobCode = rs.getString("JOB_CODE");
				String selLevel = rs.getString("SAL_LEVEL");
				int salary = rs.getInt("SALARY");
				double bonus = rs.getDouble("BONUS"); // 실수형
				int managerId = rs.getInt("MANAGER_ID");
				Date hireDate = rs.getDate("HIRE_DATE");
				Date entDate = rs.getDate("ENT_DATE");
				char entYn = rs.getString("ENT_YN").charAt(0);

				emp = new Employee(empId, empName, empNo, email, email, deptCode, jobCode, selLevel, salary, bonus,
						managerId, hireDate, entDate, entYn);

//				Employee emp = new Employee(empId, empName, empNo, email, email, deptCode, jobCode, selLevel, 
//	                    salary, bonus, managerId, hireDate, entDate, entYn); --> 작성하면 오류 발생 위에 처럼 작성 

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			// 사용한 JDBC 객체 자원 반환(생성 역순)
			try {

				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.cancel();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// 조회결과가 있으면 Employee 객체 주소
		// 없으면 null 반환
		return emp;
	}

	/**
	 * 입력 받은 급여 이상으로 받는 모든 직원 조회 DAO
	 * 
	 * @param input
	 * @return
	 */
	public List<Employee> selectSalary(int input) {

		List<Employee> empList = new ArrayList<Employee>();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 메모리 로드

			String type = "jdbc:oracle:thin:@"; // JDBC 드라이버가 thin 타입
			String ip = "localhost"; // 접속할 아이피
			String port = ":1521";
			String sid = ":xe"; // 접속할DB 이름
			String user = "pja"; // 사용자 계정 명
			String pw = "pja1234"; // 사용자 계정 비밀번호

			// 커넥션 생성
			conn = DriverManager.getConnection(type + ip + port + sid, user, pw);

			String sql = "SELECT * FROM EMPLOYEE_COPY WHERE SALARY >=" + input;
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int empId = rs.getInt("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String empNo = rs.getString("EMP_NO");
				String email = rs.getString("EMAIL");
				String deptCode = rs.getString("DEPT_CODE");
				String jobCode = rs.getString("JOB_CODE");
				String selLevel = rs.getString("SAL_LEVEL");
				int salary = rs.getInt("SALARY");
				double bonus = rs.getDouble("BONUS"); // 실수형
				int managerId = rs.getInt("MANAGER_ID");
				Date hireDate = rs.getDate("HIRE_DATE");
				Date entDate = rs.getDate("ENT_DATE");
				char entYn = rs.getString("ENT_YN").charAt(0);

				Employee emp = new Employee(empId, empName, empNo, email, email, deptCode, jobCode, selLevel, salary,
						bonus, managerId, hireDate, entDate, entYn);

				empList.add(emp);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return empList;
	}

	/**
	 * 새로운 사원 정보 추가 DAO
	 * 
	 * @param emp
	 * @return
	 */
	public int insertEmployee(Employee emp) {

		int result = 0; // 결과 저장용 변수

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 메모리 로드

			String type = "jdbc:oracle:thin:@"; // JDBC 드라이버가 thin 타입
			String ip = "localhost"; // 접속할 아이피
			String port = ":1521";
			String sid = ":xe"; // 접속할DB 이름
			String user = "pja"; // 사용자 계정 명
			String pw = "pja1234"; // 사용자 계정 비밀번호

			// 커넥션 생성
			conn = DriverManager.getConnection(type + ip + port + sid, user, pw);
			
			// --> 생성된 커넥션을 이용해 SQL을 수행하면 자동 커밋이 된다(기본값)
			// ---> 자동 커밋 기능을 끄고 개발자가 트랜잭션을 직접 제어하는게 좋음
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			// --> 자동 커밋을 비활성화 시켜도 conn.close()가 실행되면 남은 트랜잭션 내용이 모두 commit 된다.

			// SQL 작성
			String sql = "INSERT INTO EMPLOYEE2 VALUES (?, ?, ?, ?, ?, ?, ?, 'S5', ?, ?,200,SYSDATE, NULL, 'N')";
			// ? 기호 == 위치 홀더

			// Statment : 커넥션 생성 - SQL 작성 - Statemnet 객체 생성 - SQL 수행 수 결과 반환

			// preparedStatement : 커넥션 생성 - SQL 작성(? 사용) - PreparedStatement 객체 생성 (SQL 적재)
			// -- 준비된 셔틀버스(누가탈지 정해져있음)
			// - 위치 홀더에 알맞는 값 대입 - SQL 수행 후 결과 반환

			// preparedStatment 객체 생성(SQL 적재)
			pstmt = conn.prepareStatement(sql);

			// 위치홀더에 알맞는 값 대임
			// pstmt.set[Type](위치 홀더 순서, 값)

			pstmt.setInt(1, emp.getEmpId()); // 입력 받은 사번을 1번 ? (위치홀더)에 세팅
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpNo());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhone());
			pstmt.setString(6, emp.getDeptCode());
			pstmt.setString(7, emp.getJobCode());
			pstmt.setInt(8, emp.getSelary());
			pstmt.setDouble(9, emp.getBonus());

			// SQL 수행 후 결과 반환 받기
			// 1) Statement - SELECT : stmt.excuteQuery(sql);
			// 2) PreparedStatment - SELECT : pstmt.excuteQuery(); <--sql 다시 담지 않음 ! (위에서 이미
			// 적재합)

			// *** DML 수행 시 executeUpdate 사용 ***
			// 3) Statement - DML : stmt.executeUpdate(sql);
			// 4) PreparedStatment - DML : pstmt.executeUpdate(); <-- sql 다시 답지 않음!

			result = pstmt.executeUpdate(); // DML INSERT, UPDATE, DELECT 성공한 개수를 반환
											// 조건에 맞는 행이 없으면 0 반환

			// ****************** 트랜잭션 제어 ******************

			if (result > 0)
				conn.commit(); // DML 성공시 commit 수행
			else
				conn.rollback();// DML 실패시 rollback 수행

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {

			}
		}

		return result;
	}

	/**
	 * 사원으로 사원 정보 삭제 DAO
	 * 
	 * @param input
	 * @return
	 */
	public int deleteEmployee(int input) {

		int result = 0; // 결과 저장용 변수

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 메모리 로드

			String type = "jdbc:oracle:thin:@"; // JDBC 드라이버가 thin 타입
			String ip = "localhost"; // 접속할 아이피
			String port = ":1521";
			String sid = ":xe"; // 접속할DB 이름
			String user = "pja"; // 사용자 계정 명
			String pw = "pja1234"; // 사용자 계정 비밀번호

			// 커넥션 생성
			conn = DriverManager.getConnection(type + ip + port + sid, user, pw);
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			// -> 안적는다면 활성화 상태임으로 SQL이 수행되지마자 commit이 되어 버림

			String sql = "DELETE FROM EMPLOYEE2 WHERE EMP_ID = ?";

			// PreparedStatement 생성 (SQL 적재)
			pstmt = conn.prepareStatement(sql);

			// 위치 홀더에 알맞은 값 대입
			pstmt.setInt(1, input);

			result = pstmt.executeUpdate();

			if (result > 0)
				conn.commit();
			else
				conn.rollback();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	/**
	 * 사번으로 사원정보 수정 DAO (PreparedStatement)
	 * 
	 * @param emp
	 * @return
	 */
	public int updateEmployee(Employee emp) {

		int result = 0;

		try {

			// oracle jdbc driver 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 커넥션 생성 (드라이버메니저가 생성해준다)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pja", "pja1234");

			// 자동 커밋 비활성화
			conn.setAutoCommit(false);

			// SQL 작성 (위치홀더 포함)
			String sql = "UPDATE EMPLOYEE2 SET EMAIL =? ,PHONE = ?, SALARY =? WHERE EMP_ID =?";

			// PreparedStatement 생성
			pstmt = conn.prepareStatement(sql);

			// 위치 홀더에 알맞은 값 대입
			pstmt.setString(1, emp.getEmail());
			pstmt.setString(2, emp.getPhone());
			// setInt()는 '' 붙지 않음
			pstmt.setInt(3, emp.getSelary());
			pstmt.setInt(4, emp.getEmpId());

			// setString()을 통해 위치홀더에 문자열 값을 대입하면
			// 문자열 양쪽에 ''(홑따옴표)가 포함된 상태로 추가된다!

			// ex) pstmt.setString(1,"abc");
			// --> 위치 홀더 자리에 'abc'

			// SQL 수행
			// pstmt.executeQuery();//SELECT 조회할때, 수행
			result = pstmt.executeUpdate(); // DML (INSERT, UPDATE, DELETE 수행)

			// 트랜잭션 제어
			if (result > 0)
				conn.commit();
			else
				conn.rollback();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	/**
	 * 사원으로 사원 정보 수정 2 DAO (Statement)
	 * 
	 * @param emp
	 * @return
	 */
	public int updateEmployee2(Employee emp) {

		int result = 0;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:xe", "pja", "pja1234");

			conn.setAutoCommit(false);

			// SQL 작성(문자열 데이터 양쪽에 '' 붙이는거 잊지 않기!)
			String sql = "UPDATE EMPLOYEE2 SET EMAIL ='" + emp.getEmail() + " ', " + "PHONE=' " + emp.getPhone() + "',"
					+ "SALARY = " + emp.getSelary() + " WHERE EMP_ID = " + emp.getEmpId();

			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);

			if (result > 0)
				conn.commit();
			else
				conn.rollback();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	/** 부서의 보너스를 모두 수정 DAO
	 * @param emp
	 * @return
	 */
	public int updateBonus(Employee emp) {

		int result = 0;
		
		try {
			
			// oracle jdbc driver 메모리 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
	
			// 커넥션 생성 (드라이버메니저가 생성해준다)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521","pja","pja1234");
		

			// 자동 커밋 비활성화
			conn.setAutoCommit(false);

//			String _sql = "UPDATE EMPLOYEE2 SET BONUS  = 350 WHERE DEPT_CODE = '50'";
			String sql = "UPDATE EMPLOYEE2 SET BONUS  = "+emp.getBonus()+" WHERE DEPT_CODE = '"+ emp.getDeptCode()+"'";

//			String sql = "UPDATE EMPLOYEE2 SET" + " BONUS = "+emp.getBonus() +" WHERE DEPT_CODE ='" + emp.getDeptCode()+ " ' ";

			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
		
			if (result > 0)
				conn.commit();
			else
				conn.rollback();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	
	/**부서의 보너스를 모두 수정하는 DAO2
	 * @param emp
	 * @return
	 */
	public int updateBonus2(Employee emp) {
		
		int result =0;
	
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521","pja","pja1234");
			
			// 자동 커밋 비활성화
			conn.setAutoCommit(false);

			
			String sql = "UPDATE EMPLOYEE2 SET BONUS = ? WHERE DEPT_CODE = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			// PreparedStatement 생성
			pstmt.setDouble(1, emp.getBonus());
			pstmt.setString(2, emp.getDeptCode());

			result = pstmt.executeUpdate(); // DML (INSERT, UPDATE, DELETE 수행)
			
			if(result > 0) conn.commit();
			else 		   conn.rollback();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
			
		}

}

