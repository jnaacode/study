package edu.kh.oarr.model.vo;

public class Member {
	
	//필드(==멤버변수)
	
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String region;  //지역 (서울 경기 충북)
	
	//생성자
	
	public Member() {} // 기본 생성자 
	
	public Member(String memberId, String memberPw,String memberName,int memberAge,String region) { //매개변수 생성자 변수이름은 굳이 필드와 같을 필요가 없다. 
		
		this.memberId = memberId; 
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.region = region;
		
	}
	
	//메소드
	
	//memberID
	public String getMemberId() {
		return memberId; //this.memberId //현재 객체가 가지고 있는 멤버아이디니까 이렇게 써도 된다. 
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
		return;
		//모든 메소드는 종료 시 호출한 곳으로 돌아가는 return구문이 작성되어야 하지만, void 일 경우 생략 가능하다! 
		//-> 생략 시 컴파일러가 자동으로 추가해준다. 
	}
	
	public String getMemberPw() {
		return memberPw;
	}
	
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}


}
