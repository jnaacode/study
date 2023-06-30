package vo;
import java.sql.Date;

public class Employee {
	
	private int empId;; //사번 
	private String empName; //이름  
	private String empNo; //주민등록번호 
	private String email;//이메일 
	private String phone; //전화번호 
	private String deptCode; //부서코드
	private String jobCode; //직급코드  
	private String selLevel; //급여등급 
	private int selary; //급여
	private double bonus; //보너스율 
	private int managerId; //관리자사번 
	private Date hireDate; //입사일 (java.sql.Date)
	private Date entDate; //퇴직일
	private char entYn; //퇴직여부

	public Employee() {} //기본 생성자 

	public Employee(int empId, String empName, String empNo, String email, String phone, String deptCode,
			String jobCode, String selLevel, int selary, double bonus, int managerId, Date hireDate, Date entDate,
			char entYn) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.selLevel = selLevel;
		this.selary = selary;
		this.bonus = bonus;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.entDate = entDate;
		this.entYn = entYn;
	}

	
	public Employee(int empId, String empName, String empNo, String email, String phone, String deptCode,
			String jobCode, int selary, double bonus) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
		this.selary = selary;
		this.bonus = bonus;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getSelLevel() {
		return selLevel;
	}

	public void setSelLevel(String selLevel) {
		this.selLevel = selLevel;
	}

	public int getSelary() {
		return selary;
	}

	public void setSelary(int selary) {
		this.selary = selary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getEntDate() {
		return entDate;
	}

	public void setEntDate(Date entDate) {
		this.entDate = entDate;
	}

	public char getEntYn() {
		return entYn;
	}

	public void setEntYn(char entYn) {
		this.entYn = entYn;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", email=" + email
				+ ", phone=" + phone + ", deptCode=" + deptCode + ", jobCode=" + jobCode + ", selLevel=" + selLevel
				+ ", selary=" + selary + ", bonus=" + bonus + ", managerId=" + managerId + ", hireDate=" + hireDate
				+ ", entDate=" + entDate + ", entYn=" + entYn + ", getEmpId()=" + getEmpId() + ", getEmpName()="
				+ getEmpName() + ", getEmpNo()=" + getEmpNo() + ", getEmail()=" + getEmail() + ", getPhone()="
				+ getPhone() + ", getDeptCode()=" + getDeptCode() + ", getJobCode()=" + getJobCode()
				+ ", getSelLevel()=" + getSelLevel() + ", getSelary()=" + getSelary() + ", getBonus()=" + getBonus()
				+ ", getManagerId()=" + getManagerId() + ", getHireDate()=" + getHireDate() + ", getEntDate()="
				+ getEntDate() + ", getEntYn()=" + getEntYn() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
}
