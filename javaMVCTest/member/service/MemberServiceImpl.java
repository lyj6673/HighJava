package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;	//DAO객체가 저장될 변수 선언
	
	// 1번
		private static MemberServiceImpl service;
		
		// 3번
		public static MemberServiceImpl getInstance() {
			if(service==null) service = new MemberServiceImpl();
			
			return service;
		}
	
	//생성자
	private MemberServiceImpl() {
		//dao = new MemberDaoImpl();	//DAO객체 생성
		dao = MemberDaoImpl.getInstance();
	}

	@Override
	public int insertMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return dao.insertMember(memVo);
	}

	@Override
	public int deleteMember(MemberVO memId) {
		// TODO Auto-generated method stub
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return dao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		// TODO Auto-generated method stub
		return dao.getAllMember();
	}

	@Override
	public int getMemIdCount(String memId) {
		// TODO Auto-generated method stub
		return dao.getMemIdCount(memId);
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return dao.updateMember2(paramMap);
	}
	
	

}
