package kr.or.ddit.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberController {
	private Scanner scan;
	
	private IMemberService service;
	
	//생성자
	public MemberController() {
		super();
		scan = new Scanner(System.in);
		service = MemberServiceImpl.getInstance();
	}

	public static void main(String[] args) {
		new MemberController().memberStart();

	}
	
	private void memberStart() {
		while(true) {
			int choice = displayMenu();
			switch (choice) {
				case 1:			// 추가
					insertMember();
					break;
				case 2:			// 삭제
					deleteMember();
					break;
				case 3:			// 수정
					updateMember();
					break;
				case 4:			// 전체 출력
					displayMember();
					break;
				case 5:			// 수정2
					updateMember2();
					break;
				case 0:			// 작업 끝
					System.out.println("프로그램을 종료합니다...");
					return;
				default:
					System.out.println("다시 선택하세요...");
			}
		}
	}
	private void updateMember2() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("수정할 회원 ID 입력 >> ");
		String memId = scan.next().toLowerCase();
		
		int num;
		String updateField = null;
		String updateTitle = null;
		
		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요");
			System.out.println("1.비밀번호 2.회원이름  3.전화번호  4. 회원주소");
			System.out.println("-------------------------------------");
			System.out.println("수정할 항목 선택>>");
			num = scan.nextInt();
			switch(num) {
			case 1: updateField = "mem_pass";
					updateTitle = "비밀번호"; break;
			case 2: updateField = "mem_pass";
					updateTitle = "비밀번호"; break;
			case 3: updateField = "mem_pass";
					updateTitle = "비밀번호"; break;
			case 4: updateField = "mem_pass";
					updateTitle = "비밀번호"; break;
			default :
				System.out.println("수정할 항목을 잘못 선택했습니다.");
				System.out.println("다시 선택하세요");
			}
		}while(num<1||num>4);
		
		System.out.println();
		//수정할 값 입력 받기
		scan.hasNextLine();
		System.out.print("새로운" + updateTitle + "입력 >> ");
		String updateData = scan.nextLine();
		
		//만들어진 데이터들을 Map객체에 추가한다.
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("MEMID", memId); //회원ID추가
		paramMap.put("FIELD", updateField); // 수정할 컬럼명 추가
		paramMap.put("VALUE", updateData); // 수정된 값 추가
		
		int cnt = service.updateMember2(paramMap);
		
		System.out.println();
		if(cnt > 0) {
			System.out.println(updateTitle+" 컬럼 수정 작업 성공!!!");
		} else {
			System.out.println("수정  작업 실패~~~");
		}
		
	}
	//display메서드
	private void displayMember() {
		System.out.println();
		System.out.println("=====================================================");
		System.out.println("ID\t비밀번호\t이름\t전화번호\t\t주소");
		System.out.println("=====================================================");
		
		List<MemberVO> memList = service.getAllMember();
		
		if(memList==null || memList.size()==0) {
			System.out.println("등록된 회원 정보가 하나도 없습니다.");
		}else {
			for(MemberVO memVo : memList) {
				String id = memVo.getMem_id();
				String pass = memVo.getMem_pass();
				String name = memVo.getMem_name();
				String tel = memVo.getMem_tel();
				String addr = memVo.getMem_addr();
				
				System.out.println(id + "\t" + pass + "\t" + name + "\t"
						+ tel + "\t" + addr);
			}
			System.out.println("=====================================================");
		}
		
	}
	//update메서드
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("수정할 회원 ID 입력 >> ");
		String memId = scan.next().toLowerCase();
		
		int count = service.getMemIdCount(memId);
		if(count == 0) {	// 없는 회원ID일 경우
			System.out.println("입력한 " + memId + "은(는) 없는 회원ID입니다...");
			System.out.println("수정 작업을 중단합니다...");
			return;
		}
		
		System.out.println();
		System.out.print("새로운 비밀번호 입력 >> ");
		String newPass = scan.next();
		
		System.out.print("새로운 회원 이름 입력 >> ");
		String newName = scan.next();
		
		System.out.print("새로운 전화번호 입력 >> ");
		String newTel = scan.next();
		
		scan.nextLine();	// 버퍼 비우기
		System.out.print("새로운 회원 주소 입력 >> ");
		String newAddr = scan.nextLine();
		
		// 입력 받은 수정할 자료를 VO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(newPass);
		memVo.setMem_name(newName);
		memVo.setMem_tel(newTel);
		memVo.setMem_addr(newAddr);
		
		int cnt = service.updateMember(memVo);
		
		System.out.println();
		if(cnt > 0) {
			System.out.println("수정 작업 성공!!!");
		} else {
			System.out.println("수정  작업 실패~~~");
		}
	}
	
	
	//delete메서드
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요...");
		System.out.print("삭제할 회원 ID 입력 >> ");
		String memId = scan.next().toLowerCase();
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		
		int cnt = service.deleteMember(memVo);
		
		System.out.println();
		if(cnt > 0) {
			System.out.println("회원ID가 " + memId + "인 회원 정보 삭제 성공!!");
		} else {
			System.out.println("회원ID가 " + memId + "인 회원은 없는 회원이거나"
					+ " 삭제 작업에 실패했습니다...");
		}
	}
	//insert메서드
	private void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요");
		int count = 0;
		String memId = null;
		
		do {
			System.out.print("회원ID 입력 >> ");
			memId = scan.next();
			count = service.getMemIdCount(memId);
			if(count>0) {
				System.out.println("입력한 " + memId + "은(는) 이미 등록된 회원ID입니다");
			}
		} while(count > 0);
		System.out.print("비밀번호 입력 >> ");
		String memPass = scan.next();
		
		System.out.print("회원 이름 입력 >> ");
		String memName = scan.next();
		
		System.out.print("전화번호 입력 >> ");
		String memTel = scan.next();
		
		System.out.print("회원 주소 입력 >> ");
		scan.nextLine();
		String memAddr = scan.nextLine();
		
		//입력 받은 자료들을 VO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		//Service의 insert하는 메서드를 호출한다.
		//이 때 insert할 데이터가 저장된 MemberVO객체를 보내준다.
		int cnt = service.insertMember(memVo);
		
		if(cnt>0) {
			System.out.println("회원 추가 성공!!!");
		}else {
			System.out.println("회원 추가 실패 ~~~");
		}
	}
	
	private int displayMenu() {
		System.out.println();
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("5. 자료 수정2");
		System.out.println("0. 작업 끝.");
		System.out.println("---------------");
		System.out.print("작업 선택 >> ");
		return scan.nextInt();
	}
	

}
