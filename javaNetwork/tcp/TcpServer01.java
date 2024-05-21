package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {
	public static void main(String[] args) throws IOException {
		
		//TCP소켓 통신을 위해 port번호 지정하여 ServerSocket객체를 생성한다.
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버가 접속을 기다립니다...");
		System.out.println();
		
		// accept()메소드
		//	==> Client에서 연결 요청이 올 때까지 계속 기다린다.
		//	==> 연결 요청이 오면 새로운 Socket객체를 생성해서 Client의 Socket과 연결한다.
		Socket socket = server.accept();
		
		// accept()메소드 호출 이후에는 접속이 완료된 후에 처리할 내용을 작성하면 된다.
		System.out.println("클라이언트가 연결되었습니다...");
		System.out.println();
		
		System.out.println("접속한 상대방 컴퓨터의 정보 확인...");
		System.out.println("IP주소 : " +
					socket.getInetAddress().getHostAddress());
		System.out.println("Port번호 : " + socket.getPort());
		System.out.println();
		
		System.out.println("현재 컴퓨터의 정보 확인...");
		System.out.println("IP주소 : " + socket.getLocalAddress());
		System.out.println("Port번호 : " + socket.getLocalPort());
		System.out.println("-------------------------------------");
		System.out.println();
		
		// Client가 보내준 메시지 받기
		//	==> Socket객체의 InputStream객체를 이용한다.
		//	==> Socket의 getInputStream()메소드를 이용하여 InputStream객체를 구한다.
		InputStream in = socket.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		// 클라이언트가 보낸 메시지를 받아서 출력한다.
		String str = din.readUTF();		// 수신 (입력)
		System.out.println("Client로부터 받은 메시지 : " + str);
		System.out.println();
		System.out.println("--------------------------------------");
		System.out.println();
		
		// Client에서 받은 메시지를 그대로 다시 보내기
		//	==> Socket객체의 OutputStream객체를 이용한다.
		//	==> Socket의 getOutputStream()메소드를 이용하여 OutputStream객체를 구한다.
		DataOutputStream dout =
				new DataOutputStream(socket.getOutputStream());
		
		// 상대방에게 메시지 보내기
		dout.writeUTF(str);		// 송신(출력)
		System.out.println("클라이언트에게 메시지를 보냈습니다...");
		System.out.println();
		
		System.out.println("연결을 종료합니다...");
		
		// 스트림과 소켓 닫기
		din.close();
		dout.close();
		socket.close();
		server.close();
	}
}
