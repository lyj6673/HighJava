package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisUtil;
import kr.or.ddit.vo.BoardVo;


public class BoardDaoImpl implements IBoardDao{
		
	    //1번
		private static BoardDaoImpl dao;
		
		//2번
		private BoardDaoImpl() { }

		//3번
		public static BoardDaoImpl getInstance() {
			if(dao==null) dao = new BoardDaoImpl();
			
			return dao;
		}

	@Override
	public int insertBoard(BoardVo boardVo) {
		SqlSession session = null;
		int cnt = 0;	//반환값이 저장될 변수
		
		try {
			session = MyBatisUtil.getSqlSession();
			
			cnt = session.insert("board.insertBoard", boardVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) try { session.close(); } catch(Exception e) {}
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		SqlSession session = null;
		int cnt = 0;	//반환값이 저장될 변수
		
		try {
			session = MyBatisUtil.getSqlSession();
			
			cnt = session.delete("board.deleteBoard", boardNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) try { session.close(); } catch(Exception e) {}
		}
		return cnt;
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		SqlSession session = null;
		int cnt = 0;	//반환값이 저장될 변수
		
		try {
			session = MyBatisUtil.getSqlSession();
			
			cnt = session.update("board.updateBoard", boardVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) try { session.close(); } catch(Exception e) {}
		}
		return cnt;
	}

	@Override
	public List<BoardVo> getAllBoard() {
		SqlSession session = null;
		List<BoardVo> boardList = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			
			boardList = session.selectList("board.getAllBoard");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return boardList;
	}

	@Override
	public BoardVo getBoard(int boardNo) {
		SqlSession session = null;
		BoardVo boardVo = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			
			boardVo = session.selectOne("board.getBoard", boardNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return boardVo;
	}

	@Override
	public List<BoardVo> getSearchBoard(String title) {

		SqlSession session = null;
		List<BoardVo> boardList = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			
			boardList = session.selectList("board.getSearchBoard", title);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return boardList;
	}

	@Override
	public int boardCountIncrement(int boardNo) {
		SqlSession session = null;
		int cnt = 0;	//반환값이 저장될 변수
		
		try {
			session = MyBatisUtil.getSqlSession();
			
			cnt = session.update("board.boardCountIncrement", boardNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) try { session.close(); } catch(Exception e) {}
		}
		return cnt;
	}

}
