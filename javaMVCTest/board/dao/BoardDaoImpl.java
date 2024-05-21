package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.util.DBUtil3;

public class BoardDaoImpl implements IBoardDao{
	
		private static BoardDaoImpl dao;

		
		public static BoardDaoImpl getInstance() {
			if(dao==null) dao = new BoardDaoImpl();
			
			return dao;
		}

	@Override
	public int insertBoard(BoardVo boardVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;	//반환값이 저장될 변수
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "insert into jdbc_board" 
					+ " values( board_seq.nextval, ?, ?, sysdate, 0, ? ) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getB_title());
			pstmt.setString(2, boardVo.getB_writer());
			pstmt.setString(3, boardVo.getB_content());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int deleteBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVo> getAllBoard() {
		// TODO Auto-generated method stub
		return null;
	}

}
