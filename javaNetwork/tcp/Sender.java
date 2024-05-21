package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

// 이 클래스는 소켓을 이용하여 메시지를 보내는 역할을 담당한다.
public class Sender	extends Thread {
	private Socket socket;
	private DataOutputStream dout;
	
	private String name;
	private Scanner scan;
	
	//생성자
	public Sender(Socket socket) {
		this.socket = socket;
		scan = new Scanner(System.in);
		
		System.out.print("이름 입력>>");
		name = scan.nextLine();
		
		try {
			//스트림 객체 구하기
			dout = new DataOutputStream(this.socket.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void run() {
		//쓰레드가 처리할 내용은 사용자가 입력한 메시지를 이름과 같이 상대방에게 전송한다.
		while(dout!=null) {
			try {
				dout.writeUTF(name+" : "+scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	
	
	
}
