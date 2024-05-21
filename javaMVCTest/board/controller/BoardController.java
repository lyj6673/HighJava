package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVo;
import kr.or.ddit.member.vo.MemberVO;


public class BoardController {
	private Scanner scan;
	
	private IBoardService service;
	
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
		while(true) {
			int choice = displayMenu();
			switch (choice) {
				case 1:			// 추가
					insertBoard();
					break;
				case 2:			// 보기
					DetailBoard();
					break;
				case 3:			// 검색
					//searchBoard();
					break;
				case 0:			// 작업 끝
					System.out.println("프로그램을 종료합니다...");
					return;
				default:
					System.out.println("다시 선택하세요...");
			}
		}
	}
	
	private void insertBoard() {
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("--------------------");

		
		System.out.print("제 목 : ");
		String b_title = scan.nextLine();
		scan.nextLine();
		System.out.print("작성자 :  ");
		String b_writer = scan.next();
		scan.nextLine();
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
	private void DetailBoard() {
		System.out.print("보기를 원하는 게시물 번호 입력 >>");
		int b_no = scan.nextInt();
		
		BoardVo boardVo = new BoardVo();
		boardVo.setB_no(b_no);
		
		//List<BoardVo> boardData = service.insertBoard(boardVo);
	
		
	}
	
	private void deleteBoard() {
		
	}

	private void updateBoard() {
	
	}

	private void displayBoard() {
		System.out.println("----------------------------------------------");
		System.out.println("No \t\t 제목 \t\t 작성자 \t 조회수");
		System.out.println("----------------------------------------------");
		
		List<BoardVo> boardList = service.getAllBoard();
		if(boardList==null || boardList.size()==0) {
			System.out.println("등록된 게시판 글이 하나도 없습니다.");
			System.out.println("----------------------------------------------");
		}else {
			for(BoardVo boardVo : boardList) {
				int no = boardVo.getB_no();
				String title = boardVo.getB_title();
				String writer = boardVo.getB_writer();
				System.out.println(no + "\t" + title + "\t" + writer);
			}
			System.out.println("----------------------------------------------");
		}
		
	}
	
	private int displayMenu() {
		displayBoard();
		System.out.println();
		System.out.println("1. 새글 작성  2. 게시글보기  3. 검색 0. 작업 끝");
		System.out.println("----------------------------------------------");
		System.out.print("작업 선택 >> ");
		return scan.nextInt();
	}

}
