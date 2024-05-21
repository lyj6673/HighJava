package kr.or.ddit.basic;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Browser b = new Browser();
		
		b.history();
		
		b.goURL("1.네이버");
		b.history();
		
		b.goURL("2.야후");
		b.history();
		
		b.goURL("3.구글");
		b.goURL("4.다음");
		b.history();
		
		System.out.println("뒤로 가기 후...");
		b.goBack();
		b.history();
		
		System.out.println("뒤로 가기 후...");
		b.goBack();
		b.history();
		
		System.out.println("앞으로 가기 후...");
		b.goForward();
		b.history();
		
		System.out.println("새로운 사이트 접속 후...");
		b.goURL("5.네이트");
		b.history();
	}

}

// 웹브라우저의 앞으로 가기, 뒤로 가기 기능을 구현하는 예제(Stack 이용)

class Browser{
	private Stack<String> back;   //이전 방문내역이 저장될 Stack
	private Stack<String> forward;   //다음 방문내역이 저장될 Stack
	private String currentURL;   //현재 페이지
	
	public Browser() {
		back = new Stack<String>();
		forward = new Stack<String>();
		currentURL = "";
	}
	
	public void goURL(String url) {
		System.out.println(url + "사이트에 접속합니다...");
		
		if(currentURL!=null && !"".equals(currentURL)) { //현재 페이지가 있으면
			back.push(currentURL); // 현재 페이지를 back 스택에 추가한다.
		}
		
		currentURL = url; //현재 페이지를 변경한다.
		forward.clear(); // forward 스택의 내용을 모두 지운다.
	}
	
	// 뒤로 가기 처리
	// isEmpty() ==> 컬렉션에 데이터가 없이 비어 있으면 true, 그렇지 않으면 false
	public void goBack() {
		if(!back.isEmpty()) {  //back 스택에 데이터가 있으면...
			forward.push(currentURL); //현재 페이지를 forward에 추가
			currentURL = back.pop();  // back스택에서 꺼내온 주소를 현재 페이지로 한다.
			
		}
		
	}
	
	//앞으로 가기 처리
	public void goForward() {
		if(!forward.isEmpty()) {	
			back.push(currentURL);	//현재 페이지를 back에 추가
			currentURL = forward.pop(); // forward 스택에서 꺼내온 주소를 현재 페이지로
			
		}
	}
	
	//방문기록 확인용 메서드
	
	public void history() {
		System.out.println("------------------------");
		System.out.println("     방 문 기 록");
		System.out.println("------------------------");
		System.out.println("back => "+back);
		System.out.println("currentURL => "+currentURL);
		System.out.println("forward => "+forward);
		System.out.println("------------------------");
	}
	
}
