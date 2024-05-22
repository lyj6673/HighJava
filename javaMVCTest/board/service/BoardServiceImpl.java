package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVo;


public class BoardServiceImpl implements IBoardService {
	
		private IBoardDao dao;	//DAO객체가 저장될 변수 선언
	
		// 1번
		private static BoardServiceImpl service;
		
		// 2번 (생성자)
		private BoardServiceImpl() {
			dao = BoardDaoImpl.getInstance();
		}
		
		// 3번
		public static BoardServiceImpl getInstance() {
			if(service==null) service = new BoardServiceImpl();
			
			return service;
		}

	@Override
	public int insertBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return dao.insertBoard(boardVo);
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(boardNo);
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return dao.updateBoard(boardVo);
	}

	@Override
	public List<BoardVo> getAllBoard() {
		// TODO Auto-generated method stub
		return dao.getAllBoard();
	}

	@Override
	public BoardVo getBoard(int boardNo) {
		// 조회수 증가
		int cnt = dao.boardCountIncrement(boardNo);
		
		// 조회수 증가 실패일 때
		if(cnt==0) {
			return null;
		}
		return dao.getBoard(boardNo);
	}

	@Override
	public List<BoardVo> getSearchBoard(String title) {
		// TODO Auto-generated method stub
		return dao.getSearchBoard(title);
	}

	@Override
	public int boardCountIncrement(int boardNo) {
		// TODO Auto-generated method stub
		return dao.boardCountIncrement(boardNo);
	}

}
