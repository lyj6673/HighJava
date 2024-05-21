package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVo;

public interface IBoardService {
	/**
	 * BoardVo객체에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param boardVo DB에 insert할 자료가 저장된 BoardVo객체
	 * @return	작성 성공 : 1, 작업 실패 : 0
	 */
	public int insertBoard(BoardVo boardVo);
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * 
	 * @param boardVo 삭제할 회원ID
	 * @return	작성 성공 : 1, 작업 실패 : 0
	 */
	public int deleteBoard(BoardVo boardVo);
	/**
	 * 매개변수를 받는 BoardVo객체를 이용하여 게시판 정보를 Update하는 메서드
	 * 
	 * @param boardVo update할 회원 정보가 저장된 BoardVo객체
	 * @return	작성 성공 : 1, 작업 실패 : 0
	 */
	
	public int updateBoard(BoardVo boardVo);
	
	/**
	 * DB의 전체 게시판 정보를 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return 검색된 게시판정보 각각을 BoardVo에 담고 있는 List객체
	 */
	public List<BoardVo> getAllBoard();
}
