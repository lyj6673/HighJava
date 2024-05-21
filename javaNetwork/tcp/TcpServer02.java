package kr.or.ddit.basic.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer02 {
	public static void main(String[] args) throws IOException {
		// ServerSocket을 생성하고 클라이언트가 접속해 오면
		// 클라이언트와 연결된 Socket을 만들어서
		// 메시지를 받는 쓰레드와 메시지를 보내는 쓰레드에 이 Socket을 주입해서 실행하면 된다.
		ServerSocket server = new ServerSocket(7777);
		
		System.out.println("서버가 준비 중입니다..");
		
		Socket socket = server.accept();
		
		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);
		
		sender.start();
		receiver.start();
	}
	
}
