package kr.or.ddit.basic.tcp;

import java.net.Socket;

public class TcpClient02 {
	public static void main(String[] args) {
		// Socket객체를 생성해서 서버에 연결 요청을 하고
		// 연결이 완료되면 이 Socket객체를
		// 메시지를 받는 쓰레드와 메시지를 보내는 쓰레드에 주입해서 실행하면 된다.
		try {
			Socket socket = new Socket("192.168.145.13",7777);
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
