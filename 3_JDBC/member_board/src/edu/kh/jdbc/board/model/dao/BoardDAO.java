package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*; // 안하면 close 오류남 

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.vo.Reply;
import edu.kh.jdbc.board.vo.Board;
import edu.kh.jdbc.member.model.vo.Member;

public class BoardDAO {
	
	//JDBC 객체 참조용 변수 선언(java.sql)
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	//SQL 내용을 저장할 Properties 객체 참조 변수 선언 
	private Properties prop;
	
	//기본 생성자(borad-sql.xml 파일 읽어오기(Properites))
	public BoardDAO() {
		
		try {
			
			prop = new Properties();
			
			//xml 파일 읽어오기 
			prop.loadFromXML(new FileInputStream("board-sql.xml"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/** 게시글 목록 조회 DAO
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Board> selectAll(Connection conn) throws Exception {
		
		// 결과 저장용 변수 
		List <Board> boardList = new ArrayList<Board>();		
//		List <Board> boardList = new ArrayList<>(); -- 작성해도 상관없음 
		
		try {
			
		
			//1) sql 작성 
			String sql = prop.getProperty("selectAll");
			
			//2) Statement 객체 생성 
			stmt = conn.prepareStatement(sql);
			
			//3) SQL(SELECT) 수행 후 결과 반환(ResultSet) 받기
			rs = stmt.executeQuery(sql);

			//4) ResultSet을 한 행씩 접근 (rs.next())하여 조회된 컬럼 값을 얻어와
	
			while(rs.next()) {
				
//				SELECT BOARD_NO, BOARD_TITLE, CREATE_DATE, READ_COUNT, MEMBER_NM,
//		   		  (SELECT COUNT(*) FROM REPLY R
//		    	   WHERE R.BOARD_NO  = B.BOARD_NO) REPLY_COUNT
//		   		  FROM BOARD B
//		   		  JOIN MEMBER USING (MEMBER_NO)
//		   		  ORDER BY BOARD_NO DESC;
				
//				//5) 현재 행에서 컬럼명을 이용해서 컬럼 값 얻어오기 
					int boardNo = rs.getInt("BOARD_NO");
					String boardTitle = rs.getString("BOARD_TITLE");
					Date createDate = rs.getDate("CREATE_DATE");
					int readCount = rs.getInt("READ_COUNT");
					String memberName = rs.getString("MEMBER_NM");
					int replyCount = rs.getInt("REPLY_COUNT");
							
				//6) Board 객체를 생성하여 컬럼 값 담기 
					Board board = new Board(boardNo, boardTitle, createDate, readCount, memberName, replyCount);
					
				//7) Borad 객체를 boardList에 추가 
					boardList.add(board);
				
				
			}
			
			//컬럼 값이 저장된 Member객체를 List 추가 
	
			
		}finally {
			
			//8) JDBC 자원 반환 
			close(rs);
			close(stmt);
			//import static edu.kh.jdbc.common.JDBCTemplate.*;인포트 해줘야함 

		}
		
		return boardList;
	}

	/** 특정 게시글 상세 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectOne(Connection conn, int boardNo) throws Exception{

		//결과 저장용 변수 
		Board board = null; 
		
		try {
			
			//1) sql 작성 
			String sql = prop.getProperty("selectOne");
			
			//2) PrepareStatement 생성 
			pstmt = conn.prepareStatement(sql);
					
			//3) 위치 홀더 '?'알맞은 값 세팅 
			pstmt.setInt(1,boardNo);
					
			//4) SQL 수행(SELECT) 후 결과 반환 받기(ResultSet)
			rs = pstmt.executeQuery();
			
			//5) 조회된 한행 (if)이 있을 경우 조회된 컬럼 값 얻어오기 
			
				if(rs.next()) {
					
//					입력 받은 boardNo와 조회된 BOARD_NO는 같으므르
//					굳이 DB조회 결과에서 얻어오지 않아도 된다. 
//					boardNo = rs.getInt("BOARD_NO"); 
					
					String boardTitle = rs.getString("BOARD_TITLE");
					Date createDate = rs.getDate("CREATE_DATE");
					int readCount = rs.getInt("READ_COUNT");
					String memberName = rs.getString("MEMBER_NM");
					
					String boardContent = rs.getString("BOARD_CONTENT");
					int memberNo = rs.getInt("MEMBER_NO");
					
					
					//6) Board 객체를 생성하여 컬럼 값 세팅
					board = new Board();
					board.setBoardNo(boardNo); //매개변수세팅
					board.setBoardTitle(boardTitle);
					board.setBoardContent(boardContent);
					board.setCreateDate(createDate);
					board.setReadCount(readCount);
					board.setMemberName(memberName);
					board.setMemberNo(memberNo);
				}
			
			
		} finally {
			
			// 7) 사용한 JDBC 자원 반환 
			close(rs);
			close(pstmt);
			
		}
		// 결과 반환 
		return board;
	}

	/** 특정 게시글 댓글 목록 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return replyList
	 * @throws Exception
	 * 
	 */
	public List<Reply> selectReplyList(Connection conn, int boardNo)throws Exception {
		
		List<Reply> replyList = new ArrayList<>();
		
		try {
			
			//1) sql 작성 
			String sql = prop.getProperty("selectReplyList");
			
			//2) PrepareStatement 생성 
			pstmt = conn.prepareStatement(sql);
					
			//3) 위치 홀더 '?'알맞은 값 세팅 
			pstmt.setInt(1,boardNo);
								
			//4) SQL 수행(SELECT) 후 결과 반환 받기(ResultSet)
			rs = pstmt.executeQuery();
			
			//5) 조회된 결과를 한 행씩 접근(while(rs.next)) 각 행별로 컬럼 값 얻어오기 
			
			while(rs.next()) {
				
				int replyNo = rs.getInt("REPLY_NO");
				String replyContent =rs.getString("REPLY_CONTENT");
				Date createDate = rs.getDate("CREATE_DATE");
				int memberNo = rs.getInt("MEMBER_NO");
				String memberName = rs.getString("MEMBER_NM");
				
				
				//6) Replay 객체 생성하여 컬럼 값 담기 
				Reply reply = new Reply();
				
				reply.setReplyNo(replyNo);
				reply.setReplyContent(replyContent);
				reply.setCreateDate(createDate);
				reply.setMemebrNo(memberNo);
				reply.setMemberName(memberName);
				reply.setBoardNo(boardNo);
			
				//7) replyList에 Reply객체 추가 
				replyList.add(reply);
				
			}		
			
		} finally {
			
			//8) JDBC 객체 자원 반환 
			close(rs);
			close(pstmt);
		}
		
		return replyList;
	}

	/** 게시글 조회수 증가 DAO
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int increaseReadCount(Connection conn, int boardNo) throws Exception{
		
		//결과 저장용 변수 
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("increaseReadCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

	/**게시글 삭제 DAO
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(Connection conn, int boardNo) throws Exception {

		int result =0;
		
		try {
			
			String sql = prop.getProperty("deleteBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		
		}
		
		return result;
	}

	/**게시글 수정 
	 * @param conn
	 * @param board
	 * @return
	 * @throws Exception
	 */
	public int updateBoard(Connection conn, Board board) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateBoard");
			
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1,board.getBoardTitle());
			pstmt.setString(2,board.getBoardContent());
			pstmt.setInt(3,board.getBoardNo());
			
			result = pstmt.executeUpdate();

		}finally{
			close(pstmt);
		}

		return result;
	}


	/**댓글 작성 Service
	 * @param conn
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Connection conn, Reply reply) throws Exception{

		int result = 0;

		try {

			String sql = prop.getProperty("insertReply");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,reply.getReplyContent());
			pstmt.setInt(2,reply.getMemebrNo());
			pstmt.setInt(3,reply.getBoardNo());
					
			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}

		return result;
	}


	/** 댓글 수정 DAO
	    * @param conn
	    * @param inputNo
	    * @param input 
	    * @return result
	    * @throws Exception
	    */
	   public int updateReply(Connection conn, Reply reply) throws Exception{
	      
	       int result = 0;
	         
	         try {
	            
	            String sql = prop.getProperty("updateReply");
	            
	            pstmt = conn.prepareStatement(sql);
	            
	            pstmt.setString(1, reply.getReplyContent());
	            pstmt.setInt(2, reply.getReplyNo());
	            
	            result = pstmt.executeUpdate();
	            
	            
	         }finally {
	            close(pstmt);
	            
	         }
	         
	         return result;

	      
	   }

	/**댓글 삭제 DAO
	 * @param conn
	 * @param inputNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteReply(Connection conn, int inputNo) throws Exception {
		
		 int result = 0;
         
         try {
            
            String sql = prop.getProperty("deleteReply");
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, inputNo);
            
            result = pstmt.executeUpdate();
            
            
         }finally {
            close(pstmt);
            
         }
         
         return result;
	}

	/**게시글 작성 DAO
	 * @param conn
	 * @param board
	 * @return result
	 */
	public int insertBoard(Connection conn, Board board) throws Exception{
		
		int result = 0;
		
		 try {
	            
	            String sql = prop.getProperty("insertBoard");
	            
	            pstmt = conn.prepareStatement(sql);
	            
	            pstmt.setString(1, board.getBoardTitle());
	            pstmt.setString(2, board.getBoardContent());
	            pstmt.setInt(3, board.getMemberNo());
	            
	            result = pstmt.executeUpdate();
	            
	            
	         }finally {
	            close(pstmt);
	            
	         }
	         
	         return result;
	}

	/**게시글 검색 DAO
	 * @param conn
	 * @param menuNum
	 * @param keyword
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> searchBoard(Connection conn, int menuNum, String keyword) throws Exception{

		//결과 저장용 변수 
		List<Board> boardList = new ArrayList<>();
		
		try { //sql작성 (menuNum에 따라서 SQL 조합)

			String sql = prop.getProperty("searchBoard1") 
						+ prop.getProperty("condition"+ menuNum) 
						+ prop.getProperty("searchBoard2");
			
			pstmt = conn.prepareStatement(sql);
			
			//위치 홀더에 알맞은 값 세팅 
			// * 주의 * 
			// -> 제목 + 내용을 검색하는 조건 (3번)은 혼자만 위치홀더가 2개이다!!
			
			pstmt.setString(1, keyword);
			
			if(menuNum == 3)pstmt.setString(2, keyword);
			
			rs = pstmt.executeQuery(); // SELECT 문 수행 후 결과 ResultSet 반환 
			
			while(rs.next()) {
				

			// 현재 행에서 컬럼명을 이용해서 컬럼 값 얻어오기 
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				Date createDate = rs.getDate("CREATE_DATE");
				int readCount = rs.getInt("READ_COUNT");
				String memberName = rs.getString("MEMBER_NM");
				int replyCount = rs.getInt("REPLY_COUNT");
						
			// Board 객체를 생성하여 컬럼 값 담기 
				Board board = new Board(boardNo, boardTitle, createDate, readCount, memberName, replyCount);
				
			//Borad 객체를 boardList에 추가 
				boardList.add(board);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
	
		return boardList;
	}


}
