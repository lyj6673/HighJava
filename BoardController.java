package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.member.vo.MemberVO;


public class BoardController {
	private IBoardService service; //Service 객체가 저장될 변수
	private Scanner scan;
	
	//생성자
	public BoardController() {
		super();
		scan = new Scanner(System.in);
		service = BoardServiceImpl.getInstance();
	}
	
	public static void main(String[] args) {
		new BoardController().BoardStart();
	}
	
	private void BoardStart() {
		String searchTitle = null;
		while(true) {
			int choice = displayMenu(searchTitle);
			switch (choice) {
				case 1:			// 추가
					insertBoard();
					searchTitle = null;
					break;
				case 2:			// 보기
					viewBoard();
					searchTitle = null;
					break;
				case 3:			// 검색
					searchTitle = searchBoard();
					break;
				case 0:			// 작업 끝
					System.out.println("프로그램을 종료합니다...");
					return;
				default:
					System.out.println("다시 선택하세요...");
			}
		}
	}
	private String searchBoard() {
		System.out.println();
		System.out.println("검색 작업");
		System.out.println("-------------------");
		System.out.print("- 검색할 제목 입력>> ");
		String searchWord = scan.nextLine();
		
		return searchWord;
	}
	
	private void insertBoard() {
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("--------------------");

		
		scan.nextLine();
		System.out.print("제 목 : ");
		String b_title = scan.nextLine();
		System.out.print("작성자 :  ");
		String b_writer = scan.nextLine();
		System.out.print("내 용 :  ");
		String b_content = scan.nextLine();
		
		//입력 받은 자료들을 VO객체에 저장한다.
		BoardVo boardVo = new BoardVo();
		boardVo.setB_title(b_title);
		boardVo.setB_writer(b_writer);
		boardVo.setB_content(b_content);
		
		//Service의 insert하는 메서드를 호출한다.
		//이 때 insert할 데이터가 저장된 MemberVO객체를 보내준다.
		int cnt = service.insertBoard(boardVo);
		
		if(cnt>0) {
			System.out.println("새글이 추가되었습니다.");
		}else {
			System.out.println("새글이 추가되지 않았습니다.");
		}
	}
	private void viewBoard() {
		System.out.println();
		System.out.print("보기를 원하는 게시물 번호 입력 >>");
		int b_no = scan.nextInt();
		
		BoardVo boardVo = service.getBoard(b_no);
		if(boardVo==null) {
			System.out.println(b_no + " 번의 게시글이 존재하지 않습니다...");
			return;
		}
		
		System.out.println(b_no + "번 게시글 내용");
		System.out.println("----------------------------------------------");
		System.out.println("- 제 목 : " + boardVo.getB_title());
		System.out.println("- 작성자 : " + boardVo.getB_writer());
		System.out.println("- 내 용 : " + boardVo.getB_content());
		System.out.println("- 작성일 : " + boardVo.getB_date());
		System.out.println("- 조회수 : " + boardVo.getB_cnt());
		System.out.println("----------------------------------------------");
		System.out.println("메뉴 : 1.수정  2.삭제  3.리스트로 가기");
		System.out.print("작업 선택 >> ");
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1 :	//수정
			updateBoard(b_no); break;
		case 2 :	//삭제
			deleteBoard(b_no); break;
		case 3 :
			return;
		}
		
	}
	
	private void deleteBoard(int boardNo) {
		System.out.println();
		System.out.print("보기를 원하는 게시물 번호 입력 >>");
		int b_no = scan.nextInt();
		
		int cnt = service.deleteBoard(boardNo);
		if(cnt>0) {
			System.out.println(boardNo+"번 글이 삭제되었습니다.");
		}else {
			System.out.println(boardNo+"번 글이 삭제되지 않았습니다.");
		}
	}

	private void updateBoard(int boardNo) {
		System.out.println();
		System.out.println("수정 작업하기");
		System.out.println("----------------------------------------------");
		System.out.println("- 제 목 : ");
		String newTitle = scan.nextLine();
		
		System.out.println("- 내 용 : ");
		String newContent = scan.nextLine();
		
		// 입력 받은 데이터와 게시글 번호를 Vo객체에 저장한다.
		BoardVo boardVo = new BoardVo();
		boardVo.setB_no(boardNo);
		boardVo.setB_title(newTitle);
		boardVo.setB_content(newContent);
		
		int cnt = service.updateBoard(boardVo);
		
		if(cnt>0) {
			System.out.println(boardNo+"번 글이 수정되었습니다.");
		}else {
			System.out.println(boardNo+"번 글이 수정되지 않았습니다.");
		}
	}

	
	private int displayMenu(String title) {
		System.out.println("----------------------------------------------");
		System.out.println("No \t\t 제 목 \t\t 작 성 자 \t 조 회 수");
		System.out.println("----------------------------------------------");
		
		List<BoardVo> boardList = null;
		if(title==null) {
			boardList = service.getAllBoard();
		}else {
			boardList = service.getSearchBoard(title);
		}
		
		if(boardList==null || boardList.size()==0) {
			System.out.println("등록된 게시판 글이 하나도 없습니다.");
			System.out.println("----------------------------------------------");
		}else {
			for(BoardVo boardVo : boardList) {
				int no = boardVo.getB_no();
				String title2 = boardVo.getB_title();
				String writer = boardVo.getB_writer();
				System.out.println(no + "\t" + title2 + "\t" + writer);
			}
		}
		System.out.println("----------------------------------------------");
		System.out.println("1. 새글 작성  2. 게시글보기  3. 검색 0. 작업 끝");
		System.out.println("----------------------------------------------");
		System.out.print("작업 선택 >> ");
		return scan.nextInt();
	}

}
