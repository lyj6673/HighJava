package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

// 이 쓰레드 클래스는 소켓을 통해서 메시지를 받아서 화면에 출력하는 역할을 담당한다.
public class Receiver extends Thread {
	private Socket socket;
	private DataInputStream din;
	
	// 생성자
	public Receiver(Socket socket) {
		this.socket = socket;
		try {
			//입력용 스트림 객체를 구한다
			din = new DataInputStream(this.socket.getInputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		// 쓰레드에서는 메시지를 받아서 화면에 출력하는 작업을 수행한다.
		try {
			System.out.println(din.readUTF());
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	
	
}
