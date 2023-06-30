package edu.kh.oop.method.model.vo;

public class Member {
	
	//필드 (속성) 
	private String memberId;
	private String memberPw;
	private String memberName;
	public String memberAge;
		
	//기본생성자 
	public Member () {}
	// 안쓰면 안됨! 
	
	//매개변수 생성자 (필드를 모두 초기화하는 용도) 
	
	public Member(String memberId, String memberPw, String memebrName,String memberAge) {
		//(Member) 변수 명이 같은데 오류가 나지 않는 이유는 ? 오버로딩이 적용되어 있다 
		
		//전달 받은 값을 필드로 옮겨 담기
		this.memberId= memberId;
		this.memberPw= memberPw;
		this.memberName = memebrName;
		this.memberAge = memberAge;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
//	어느위치에서든 접근 할 수 있고 호출하면 string자료형으로 돌려줄거고 어떤 이름인데  get + 필드명 (딴 곳에서 얻어온다)
		return memberName;
	}

//	매개변수로 전달 받은 값을 memberName필드에 대입 
//	(매개변수 == 전달 받은 값을 지니고 있는 변수) 
	public void setMemberName(String memberName) {
			//set +필드명 
		this.memberName = memberName;
	}

	public String getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(String memberAge) {
		this.memberAge = memberAge;
	}
	
	

}
