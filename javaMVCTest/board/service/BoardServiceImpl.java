package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVo;


public class BoardServiceImpl implements IBoardService {
	
	private IBoardDao dao;	//DAO객체가 저장될 변수 선언
	
		// 1번
		private static BoardServiceImpl service;
		
		// 3번
		public static BoardServiceImpl getInstance() {
			if(service==null) service = new BoardServiceImpl();
			
			return service;
		}
	
	//생성자
	private BoardServiceImpl() {
		//dao = new MemberDaoImpl();	//DAO객체 생성
		dao = BoardDaoImpl.getInstance();
	}

	@Override
	public int insertBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return dao.insertBoard(boardVo);
	}

	@Override
	public int deleteBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(boardVo);
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

}
