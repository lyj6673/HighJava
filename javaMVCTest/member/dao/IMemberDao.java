package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성해서
 * Service에게 전달하는 DAO의 interface
 * 
 * 메서드 하나가 DB와 관련된 작업 1개를 수행하도록 작성한다.
 * 
 * @author PC-24
 *
 */
public interface IMemberDao {
	/**
	 * MemberVO객체에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param memVo DB에 insert할 자료가 저장된 MemberVO객체
	 * @return	작성 성공 : 1, 작업 실패 : 0
	 */
	
	public int insertMember(MemberVO memVo);
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * 
	 * @param memId 삭제할 회원ID
	 * @return	작성 성공 : 1, 작업 실패 : 0
	 */
	public int deleteMember(MemberVO memId);
	/**
	 * 매개변수를 받는 MemberVO객체를 이용하여 회원 정보를 Update하는 메서드
	 * 
	 * @param memVo update할 회원 정보가 저장된 MemberVO객체
	 * @return	작성 성공 : 1, 작업 실패 : 0
	 */
	
	public int updateMember(MemberVO memVo);
	
	/**
	 * 매개변수로 받는 Map객체에 저장된 자료를 이요아형 원하는 항목만 수정하는 메서드
	 * Key값 정보 : 회원ID -> MEMID, 수정할 컬럼명 -> FIELD, 수정할 데이터 ->VALUE
	 * 
	 * @return paramMap 수정한 자료가 저장된 Map객체
	 */
	public int updateMember2(Map<String, String> paramMap);
	
	/**
	 * DB의 전체 회원 정보를 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return 검색된 회원정보 각각을 MemberVO에 담고 있는 List객체
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 회원 ID를 매개변수로 받아서 해당 회원ID의 개수를 반환하는 메서드
	 * 
	 * @param memId
	 * @return
	 */
	public int getMemIdCount(String memId);
}
