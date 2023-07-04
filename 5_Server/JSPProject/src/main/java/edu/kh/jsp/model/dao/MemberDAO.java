package edu.kh.jsp.model.dao;

//JDBCTemplate 쓰려고 import 받아오기 
import static edu.kh.jsp.common.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.model.vo.Member;

public class MemberDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	/**
	 * 회원 목록 조회
	 * 
	 * @param conn
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectAll(Connection conn) throws Exception {

		// 결과 저장할 변수 선언
		List<Member> memberList = new ArrayList<Member>();

		// DB랑 왔다갔다 할때 예외처리가 발생할 수 있으니 예외처리 해야함 catch는 안써도 됨! 위에서 예외처리 던진다고 함!
		try {
			String sql = "SELECT * FROM MEMBER ORDER BY 1";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				String memberId = rs.getString("MEMER_ID");
				String memberPw = rs.getString("MEMBER_PW");
				String memberName = rs.getString("MEMBER_NM");
				// DB char 자료형이 없으니 String으로 받아 한글자만 얻어오기 !
				char memberGender = rs.getString("MEMBER_GENDER").charAt(0);
				Date enrollDate = rs.getDate("ENROLL_DATE");
				char secessionFlag = rs.getString("SECESSION_FL").charAt(0);

				Member member = new Member(memberNo, memberId, memberPw, memberName, memberGender, enrollDate,
						secessionFlag);
				
				memberList.add(member);
			}
		} finally {
			close(rs);
			close(stmt);
			
		}

		return memberList;
	}

}
