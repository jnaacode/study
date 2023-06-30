package edu.kh.jdbc.board.model.vo;

import java.sql.Date;

public class Reply {
	
	private int replyNo;
	private String replyContent;
	private Date createDate;
	private int memebrNo;
	private String memberName;
	private int boardNo;
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public Reply(int replyNo, String replyContent, Date createDate, int memebrNo, String memberName, int boardNo) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.createDate = createDate;
		this.memebrNo = memebrNo;
		this.memberName = memberName;
		this.boardNo = boardNo;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getMemebrNo() {
		return memebrNo;
	}

	public void setMemebrNo(int memebrNo) {
		this.memebrNo = memebrNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", createDate=" + createDate
				+ ", memebrNo=" + memebrNo + ", memberName=" + memberName + ", boardNo=" + boardNo + "]";
	}
	
	
	
}
