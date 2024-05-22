package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.member.vo.MemberVO;

public interface IBoardDao {

	/**
	 * BoardVo객체에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param boardVo DB에 insert할 자료가 저장된 BoardVo객체
	 * @return	작성 성공 : 1, 작업 실패 : 0
	 */
	public int insertBoard(BoardVo boardVo);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글 정보를 삭제하는 메서드
	 * 
	 * @param boardNo 삭제할 게시글 번호
	 * @return	작성 성공 : 1, 작업 실패 : 0
	 */
	public int deleteBoard(int boardNo);
	/**
	 * 수정할 내용이 저장된 BoardVo객체를 매개변수로 받아서 게시글을 Update하는 메서드
	 * 
	 * @param boardVo update할 내용이 저장된 BoardVo객체
	 * @return	작성 성공 : 1, 작업 실패 : 0
	 */
	
	public int updateBoard(BoardVo boardVo);
	
	/**
	 * DB의 전체 게시판 정보를 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return 검색된 게시판정보 각각을 BoardVo에 담고 있는 List객체
	 */
	public List<BoardVo> getAllBoard();
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글 정보를 가져와 반환하는 메서드
	 * 
	 * @param boardNo 게시글 번호
	 * @return 게시글 번호에 맞는 자료가 있으면 해당 게시글 정보를 담고 있는 BoardNo객체,
	 * 			자료가 없으면 null 반환
	 */
	public BoardVo getBoard(int boardNo);
	
	/**
	 * 검색할 게시글 제목을 매개변수로 받아서 검색한 결과를 반환하는 메서드
	 * 
	 * @param title 검색할 게시글의 제목
	 * @return 검색된 결과를 담은 List객체

	 */
	public List<BoardVo> getSearchBoard(String title);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글의 조회수를 증가하는 메서드
	 * 
	 * @param boardNo 조회수를 증가할 게시글의 번호
	 * @return 작성 성공 : 1, 작업 실패 : 0
	 */
	public int boardCountIncrement(int boardNo);
}
